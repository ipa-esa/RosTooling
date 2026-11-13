package de.fraunhofer.ipa.ros.glsp.handlers;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import de.fraunhofer.ipa.ros.glsp.actions.RequestRosIndexAction;
import de.fraunhofer.ipa.ros.glsp.actions.SetRosIndexAction;
import de.fraunhofer.ipa.ros.glsp.model.RosDslText;
import de.fraunhofer.ipa.ros.glsp.model.RosGModelFactory;
import de.fraunhofer.ipa.ros.glsp.model.RosXtextModelStorage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.glsp.server.actions.AbstractActionHandler;
import org.eclipse.glsp.server.actions.Action;
import org.eclipse.glsp.server.actions.ResponseAction;
import org.eclipse.xtext.resource.XtextResourceSet;
import primitives.MessagePart;
import ros.ActionSpec;
import ros.Artifact;
import ros.InterfaceType;
import ros.MessageDefinition;
import ros.Node;
import ros.Package;
import ros.PackageSet;
import ros.Parameter;
import ros.ParameterValue;
import ros.ServiceSpec;
import ros.SpecBase;
import system.Component;
import system.RosInterface;
import system.RosNode;
import system.SubSystem;

/**
 * Parses an arbitrary list of RosTooling model files in one Xtext resource set and returns a
 * compact JSON description. The VS Code extension uses this for its component/type catalogue,
 * wrapper generation and the MCP server, so that model files are only ever read by Xtext.
 */
public class RequestRosIndexActionHandler extends AbstractActionHandler<RequestRosIndexAction> {

    private static final Gson GSON = new Gson();

    @Override
    protected List<Action> executeAction(final RequestRosIndexAction action) {
        RosXtextModelStorage.ensureXtextInitialized();
        XtextResourceSet rs = new XtextResourceSet();
        List<Resource> loaded = new ArrayList<>();
        JsonArray files = new JsonArray();
        for (String path : action.getFiles()) {
            File f = new File(path);
            if (!f.isFile()) {
                continue;
            }
            try {
                loaded.add(rs.getResource(URI.createFileURI(f.getAbsolutePath()), true));
            } catch (RuntimeException ex) {
                JsonObject err = new JsonObject();
                err.addProperty("path", f.getAbsolutePath());
                err.addProperty("error", String.valueOf(ex.getMessage()));
                files.add(err);
            }
        }
        EcoreUtil.resolveAll(rs);
        for (Resource res : loaded) {
            files.add(describe(res));
        }
        JsonObject root = new JsonObject();
        root.add("files", files);
        return List.of(ResponseAction.respond(action, new SetRosIndexAction(GSON.toJson(root))));
    }

    private JsonObject describe(final Resource res) {
        JsonObject out = new JsonObject();
        out.addProperty("path", res.getURI().toFileString());
        out.addProperty("syntaxErrors", res.getErrors().size());
        EObject root = res.getContents().isEmpty() ? null : res.getContents().get(0);
        JsonArray packages = new JsonArray();
        if (root instanceof PackageSet ps) {
            out.addProperty("kind", "ros");
            for (Package p : ps.getPackage()) {
                packages.add(describePackage(p));
            }
        } else if (root instanceof Package p) {
            out.addProperty("kind", "ros2");
            packages.add(describePackage(p));
        } else if (root instanceof system.System sys) {
            out.addProperty("kind", "rossystem");
            out.add("system", describeSystem(sys));
        }
        out.add("packages", packages);
        return out;
    }

    private JsonObject describePackage(final Package pkg) {
        JsonObject p = new JsonObject();
        p.addProperty("name", RosDslText.nullToEmpty(pkg.getName()));
        p.addProperty("kind", pkg.eClass().getName());
        p.addProperty("fromGitRepo", RosDslText.nullToEmpty(pkg.getFromGitRepo()));
        JsonArray artifacts = new JsonArray();
        for (Artifact art : pkg.getArtifact()) {
            Node node = art.getNode();
            if (node == null) {
                continue;
            }
            JsonObject a = new JsonObject();
            a.addProperty("artifact", RosDslText.nullToEmpty(art.getName()));
            a.addProperty("node", RosDslText.nullToEmpty(node.getName()));
            a.addProperty("isLifecycle", node.isIsLifecycle());
            JsonArray ifaces = new JsonArray();
            for (InterfaceType iface : RosPackageSetEditor.allInterfaces(node)) {
                JsonObject i = new JsonObject();
                i.addProperty("name", RosDslText.nullToEmpty(iface.getName()));
                i.addProperty("kind", RosDslText.kindCode(iface));
                i.addProperty("type", RosDslText.refText(null, iface, RosDslText.specFeature(iface)));
                ifaces.add(i);
            }
            a.add("interfaces", ifaces);
            JsonArray params = new JsonArray();
            for (Parameter param : node.getParameter()) {
                JsonObject pj = new JsonObject();
                pj.addProperty("name", RosDslText.nullToEmpty(param.getName()));
                pj.addProperty("type", RosDslText.parameterTypeKeyword(param.getType()));
                ParameterValue def = RosDslText.parameterTypeDefault(param.getType());
                pj.addProperty("default", def == null ? "" : RosGModelFactory.formatParameterValue(def));
                params.add(pj);
            }
            a.add("parameters", params);
            artifacts.add(a);
        }
        p.add("artifacts", artifacts);
        JsonArray specs = new JsonArray();
        for (SpecBase spec : pkg.getSpec()) {
            JsonObject s = new JsonObject();
            s.addProperty("name", RosDslText.nullToEmpty(spec.getName()));
            s.addProperty("category", RosDslText.specCategory(spec));
            s.addProperty("fullname", RosDslText.specFullName(spec));
            JsonObject sections = new JsonObject();
            List<String> names = spec instanceof ServiceSpec ? List.of("request", "response")
                    : spec instanceof ActionSpec ? List.of("goal", "result", "feedback") : List.of("message");
            for (String section : names) {
                JsonArray fields = new JsonArray();
                Object def = spec.eGet(spec.eClass().getEStructuralFeature(section));
                if (def instanceof MessageDefinition md) {
                    for (MessagePart part : md.getMessagePart()) {
                        JsonObject f = new JsonObject();
                        f.addProperty("type", RosDslText.messagePartTypeText(null, part.getType()));
                        f.addProperty("name", RosDslText.nullToEmpty(part.getData()));
                        fields.add(f);
                    }
                }
                sections.add(section, fields);
            }
            s.add("sections", sections);
            specs.add(s);
        }
        p.add("specs", specs);
        return p;
    }

    private JsonObject describeSystem(final system.System sys) {
        JsonObject s = new JsonObject();
        s.addProperty("name", RosDslText.nullToEmpty(sys.getName()));
        s.addProperty("fromFile", RosDslText.nullToEmpty(sys.getFromFile()));
        JsonArray nodes = new JsonArray();
        JsonArray subsystems = new JsonArray();
        for (Component comp : sys.getComponents()) {
            if (comp instanceof RosNode rn) {
                JsonObject n = new JsonObject();
                n.addProperty("name", RosDslText.nullToEmpty(rn.getName()));
                n.addProperty("namespace", RosDslText.nullToEmpty(rn.getNamespace()));
                Node from = rn.getFrom();
                String fromText = "";
                if (from != null && !from.eIsProxy() && from.eContainer() instanceof Artifact art
                        && art.eContainer() instanceof Package pkg) {
                    fromText = pkg.getName() + "." + from.getName();
                }
                n.addProperty("from", fromText);
                JsonArray ifaces = new JsonArray();
                for (RosInterface ri : rn.getRosinterfaces()) {
                    JsonObject i = new JsonObject();
                    i.addProperty("name", RosDslText.nullToEmpty(ri.getName()));
                    String portType = RosElementResolver.getPortType(ri);
                    i.addProperty("kind", portType == null ? "" : portType.replace("port:", ""));
                    ifaces.add(i);
                }
                n.add("interfaces", ifaces);
                nodes.add(n);
            } else if (comp instanceof SubSystem sub) {
                JsonObject j = new JsonObject();
                system.System ref = sub.getSystem();
                String refName = ref != null && !ref.eIsProxy() ? ref.getName() : "";
                if (refName == null || refName.isEmpty()) {
                    var refNodes = org.eclipse.xtext.nodemodel.util.NodeModelUtils.findNodesForFeature(
                            sub, system.RossystemPackage.Literals.SUB_SYSTEM__SYSTEM);
                    refName = refNodes.isEmpty() ? "" : RosDslText.unquote(
                            org.eclipse.xtext.nodemodel.util.NodeModelUtils.getTokenText(refNodes.get(0)).trim());
                }
                j.addProperty("name", refName);
                subsystems.add(j);
            }
        }
        s.add("nodes", nodes);
        s.add("subsystems", subsystems);
        return s;
    }
}
