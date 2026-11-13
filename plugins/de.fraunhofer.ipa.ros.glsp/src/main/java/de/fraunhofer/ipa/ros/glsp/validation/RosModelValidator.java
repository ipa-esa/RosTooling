package de.fraunhofer.ipa.ros.glsp.validation;

import com.google.inject.Inject;
import de.fraunhofer.ipa.ros.glsp.handlers.RosElementResolver;
import de.fraunhofer.ipa.ros.glsp.model.RosAstNodeModelSerializer;
import de.fraunhofer.ipa.ros.glsp.model.RosModelState;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.glsp.graph.GModelElement;
import org.eclipse.glsp.server.emf.EMFIdGenerator;
import org.eclipse.glsp.server.features.validation.Marker;
import org.eclipse.glsp.server.features.validation.MarkerKind;
import org.eclipse.glsp.server.features.validation.ModelValidator;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import system.Component;
import system.Connection;
import system.RosInterface;
import system.RosNode;
import system.RosSystemConnection;

/**
 * Live Xtext & Ecore ModelValidator for the RosTooling GLSP Server.
 * Runs Xtext's IResourceValidator on the in-memory XtextResource and checks
 * semantic ROS connection rules, mapping diagnostics to GLSP Markers.
 */
public class RosModelValidator implements ModelValidator {

    @Inject
    protected RosModelState rosModelState;

    @Inject
    protected EMFIdGenerator idGenerator;

    @Override
    public List<Marker> validate(final List<GModelElement> elements, final String reason) {
        List<Marker> markers = new ArrayList<>();

        // Synchronize in-memory AST mutations into XtextResource before running Xtext validator
        try {
            RosAstNodeModelSerializer.synchronizeAndFormat(rosModelState);
        } catch (Exception ignored) {
            // Continue validation even if partial syntax cannot synchronize
        }

        Optional<XtextResource> xtextResOpt = rosModelState.getXtextResource();
        if (xtextResOpt.isPresent()) {
            XtextResource xtextRes = xtextResOpt.get();
            IResourceValidator validator = xtextRes.getResourceServiceProvider() != null
                    ? xtextRes.getResourceServiceProvider().getResourceValidator()
                    : null;
            if (validator != null) {
                List<Issue> issues = validator.validate(xtextRes, CheckMode.ALL, CancelIndicator.NullImpl);
                for (Issue issue : issues) {
                    String elementId = resolveElementIdForIssue(issue);
                    String kind = toMarkerKind(issue.getSeverity());
                    String msg = issue.getMessage() != null ? issue.getMessage() : "Validation issue";
                    markers.add(new Marker(msg, msg, elementId, kind));
                }
            }
        }

        // Additional semantic validation on system.System Ecore AST
        rosModelState.getRosSystem().ifPresent(sys -> validateSystemSemantics(sys, markers));

        return markers;
    }

    protected void validateSystemSemantics(final system.System sys, final List<Marker> markers) {
        for (Component comp : sys.getComponents()) {
            if (comp instanceof RosNode rn) {
                String nodeId = getElementId(rn);
                if (rn.getFrom() == null || rn.getFrom().eIsProxy()) {
                    String msg = "Unresolved origin ros.Node reference on RosNode '" + rn.getName() + "'";
                    markers.add(new Marker(msg, msg, nodeId, MarkerKind.ERROR));
                }
            }
        }
        for (Connection conn : sys.getConnections()) {
            if (conn instanceof RosSystemConnection sc) {
                String edgeId = getElementId(sc);
                RosInterface from = sc.getFrom();
                RosInterface to = sc.getTo();
                if (from == null || from.eIsProxy() || to == null || to.eIsProxy()) {
                    String msg = "Connection has unresolved interface endpoint";
                    markers.add(new Marker(msg, msg, edgeId, MarkerKind.ERROR));
                } else if (!RosElementResolver.areCompatibleInterfaces(from, to)) {
                    String msg = "Incompatible ROS interfaces connected: '"
                            + from.getName() + "' -> '" + to.getName() + "'";
                    markers.add(new Marker(msg, msg, edgeId, MarkerKind.ERROR));
                }
            }
        }
    }

    protected String resolveElementIdForIssue(final Issue issue) {
        URI uri = issue.getUriToProblem();
        if (uri != null && uri.fragment() != null && !uri.fragment().isEmpty()) {
            return uri.fragment();
        }
        return "root";
    }

    protected String getElementId(final EObject eObject) {
        if (idGenerator != null) {
            String id = idGenerator.getOrCreateId(eObject);
            if (id != null && !id.isEmpty()) {
                return id;
            }
        }
        return EcoreUtil.getURI(eObject).fragment();
    }

    protected static String toMarkerKind(final Severity severity) {
        if (severity == Severity.ERROR) {
            return MarkerKind.ERROR;
        }
        if (severity == Severity.WARNING) {
            return MarkerKind.WARNING;
        }
        return MarkerKind.INFO;
    }
}
