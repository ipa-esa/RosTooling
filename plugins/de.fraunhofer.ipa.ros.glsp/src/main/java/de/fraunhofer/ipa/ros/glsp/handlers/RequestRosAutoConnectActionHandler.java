package de.fraunhofer.ipa.ros.glsp.handlers;

import com.google.inject.Inject;
import de.fraunhofer.ipa.ros.glsp.RosModelTypes;
import de.fraunhofer.ipa.ros.glsp.actions.RequestRosAutoConnectAction;
import de.fraunhofer.ipa.ros.glsp.actions.SetRosAutoConnectAction;
import de.fraunhofer.ipa.ros.glsp.model.RosAutoConnector;
import de.fraunhofer.ipa.ros.glsp.model.RosAutoConnector.Endpoint;
import de.fraunhofer.ipa.ros.glsp.model.RosModelState;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.glsp.server.actions.AbstractActionHandler;
import org.eclipse.glsp.server.actions.Action;
import org.eclipse.glsp.server.actions.ResponseAction;
import org.eclipse.glsp.server.emf.EMFIdGenerator;

/**
 * Answers an auto-connect dry run from the session's current (possibly unsaved) model. With
 * {@code selected}, it also judges that selection exactly as applyRosAutoConnect would.
 */
public class RequestRosAutoConnectActionHandler extends AbstractActionHandler<RequestRosAutoConnectAction> {

    @Inject
    protected RosModelState rosModelState;

    @Inject
    protected EMFIdGenerator idGenerator;

    @Override
    protected List<Action> executeAction(final RequestRosAutoConnectAction action) {
        RosAutoConnector.Result result = rosModelState.getRosSystem()
                .map(sys -> RosAutoConnector.propose(sys, action.getNodes(), elementIds(idGenerator), drawn(rosModelState)))
                .orElseGet(RosAutoConnector.Result::new);
        SetRosAutoConnectAction out = new SetRosAutoConnectAction();
        for (RosAutoConnector.Receiver r : result.receivers) {
            SetRosAutoConnectAction.Receiver dto = new SetRosAutoConnectAction.Receiver();
            Endpoint ep = r.endpoint;
            dto.receiverId = ep.ref;
            dto.ref = ep.ref;
            dto.node = ep.nodeRef;
            dto.iface = ep.name;
            dto.kind = ep.kind();
            dto.type = ep.typeName();
            dto.portId = ep.portId;
            dto.elementId = ep.elementId;
            dto.subsystem = subsystemName(ep);
            dto.multiAllowed = RosModelTypes.PORT_SUB.equals(ep.portType);
            for (RosAutoConnector.Candidate c : r.candidates) {
                SetRosAutoConnectAction.Candidate cd = new SetRosAutoConnectAction.Candidate();
                cd.id = c.id;
                cd.emitterRef = c.emitter.ref;
                cd.emitterNode = c.emitter.nodeRef;
                cd.emitterKind = c.emitter.kind();
                cd.emitterPortId = c.emitter.portId;
                cd.emitterElementId = c.emitter.elementId;
                cd.tier = c.tier;
                cd.score = c.score;
                cd.evidence = c.evidence;
                cd.preselected = c.preselected;
                dto.candidates.add(cd);
            }
            out.getReceivers().add(dto);
        }
        for (RosAutoConnector.EmitterSummary s : result.emitters) {
            SetRosAutoConnectAction.EmitterSummary dto = new SetRosAutoConnectAction.EmitterSummary();
            dto.emitterRef = s.endpoint.ref;
            dto.node = s.endpoint.nodeRef;
            dto.kind = s.endpoint.kind();
            dto.type = s.endpoint.typeName();
            dto.portId = s.endpoint.portId;
            dto.elementId = s.endpoint.elementId;
            dto.existingConnections = s.existingConnections;
            dto.candidateReceivers = s.candidateReceivers;
            dto.preselectedReceivers = s.preselectedReceivers;
            out.getEmitterSummary().add(dto);
        }
        for (RosAutoConnector.ConnectedReceiver cr : result.alreadyConnected) {
            SetRosAutoConnectAction.ConnectedReceiver dto = new SetRosAutoConnectAction.ConnectedReceiver();
            dto.receiverId = cr.endpoint.ref;
            dto.kind = cr.endpoint.kind();
            dto.from.addAll(cr.from);
            out.getAlreadyConnected().add(dto);
        }
        out.getSkipped().addAll(result.skipped);
        if (action.getSelected() != null) {
            RosAutoConnector.Verdict verdict = RosAutoConnector.validateSelection(result, action.getSelected());
            SetRosAutoConnectAction.Selection sel = new SetRosAutoConnectAction.Selection();
            verdict.accepted.forEach(c -> sel.accepted.add(c.id));
            verdict.rejected.forEach((id, reason) -> sel.rejected.add(new SetRosAutoConnectAction.Rejection(id, reason)));
            out.setSelection(sel);
        }
        return List.of(ResponseAction.respond(action, out));
    }

    private static String subsystemName(final Endpoint ep) {
        if (ep.topSub == null) {
            return null;
        }
        int sep = ep.nodeRef.indexOf("::");
        return sep > 0 ? ep.nodeRef.substring(0, sep) : null;
    }

    /** Element ids exactly as the diagram assigns them. */
    static Function<EObject, String> elementIds(final EMFIdGenerator idGenerator) {
        return element -> {
            String id = idGenerator == null ? null : idGenerator.getOrCreateId(element);
            return id == null || id.isEmpty() ? EcoreUtil.getURI(element).fragment() : id;
        };
    }

    /** Whether the current diagram has an element with this id. */
    static Predicate<String> drawn(final RosModelState state) {
        return id -> {
            try {
                return id != null && state.getRoot() != null && state.getIndex().get(id).isPresent();
            } catch (RuntimeException e) {
                return false;
            }
        };
    }
}
