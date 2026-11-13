package de.fraunhofer.ipa.ros.glsp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.glsp.graph.DefaultTypes;
import org.eclipse.glsp.graph.GraphPackage;
import org.eclipse.glsp.server.diagram.BaseDiagramConfiguration;
import org.eclipse.glsp.server.layout.ServerLayoutKind;
import org.eclipse.glsp.server.types.EdgeTypeHint;
import org.eclipse.glsp.server.types.ShapeTypeHint;

/**
 * GLSP DiagramConfiguration for RosTooling diagrams (.rossystem, .ros2, .ros1, .ros).
 */
public class RosDiagramConfiguration extends BaseDiagramConfiguration {

    @Override
    public String getDiagramType() {
        return RosModelTypes.DIAGRAM_TYPE;
    }

    @Override
    public ServerLayoutKind getLayoutKind() {
        return ServerLayoutKind.AUTOMATIC;
    }

    @Override
    public boolean needsClientLayout() {
        return false;
    }

    @Override
    public Map<String, EClass> getTypeMappings() {
        Map<String, EClass> mappings = DefaultTypes.getDefaultTypeMappings();
        mappings.put(RosModelTypes.ROS_NODE, GraphPackage.Literals.GNODE);
        mappings.put(RosModelTypes.SUBSYSTEM_NODE, GraphPackage.Literals.GNODE);
        mappings.put(RosModelTypes.PROCESS_NODE, GraphPackage.Literals.GNODE);
        mappings.put(RosModelTypes.PACKAGE_NODE, GraphPackage.Literals.GNODE);

        mappings.put(RosModelTypes.PORT_PUB, GraphPackage.Literals.GPORT);
        mappings.put(RosModelTypes.PORT_SUB, GraphPackage.Literals.GPORT);
        mappings.put(RosModelTypes.PORT_SS, GraphPackage.Literals.GPORT);
        mappings.put(RosModelTypes.PORT_SC, GraphPackage.Literals.GPORT);
        mappings.put(RosModelTypes.PORT_AS, GraphPackage.Literals.GPORT);
        mappings.put(RosModelTypes.PORT_AC, GraphPackage.Literals.GPORT);

        mappings.put(RosModelTypes.EDGE_CONNECTION, GraphPackage.Literals.GEDGE);

        mappings.put(RosModelTypes.COMPARTMENT_HEADER, GraphPackage.Literals.GCOMPARTMENT);
        mappings.put(RosModelTypes.COMPARTMENT_PORTS, GraphPackage.Literals.GCOMPARTMENT);
        mappings.put(RosModelTypes.COMPARTMENT_PARAMS, GraphPackage.Literals.GCOMPARTMENT);

        mappings.put(RosModelTypes.LABEL_NAME, GraphPackage.Literals.GLABEL);
        mappings.put(RosModelTypes.LABEL_SUBTITLE, GraphPackage.Literals.GLABEL);
        mappings.put(RosModelTypes.LABEL_TYPE, GraphPackage.Literals.GLABEL);
        mappings.put(RosModelTypes.LABEL_BADGE, GraphPackage.Literals.GLABEL);
        return mappings;
    }

    @Override
    public List<ShapeTypeHint> getShapeTypeHints() {
        List<ShapeTypeHint> hints = new ArrayList<>();
        hints.add(new ShapeTypeHint(RosModelTypes.ROS_NODE, true, true, false, true));
        hints.add(new ShapeTypeHint(
                RosModelTypes.SUBSYSTEM_NODE,
                true,
                true,
                true,
                false,
                List.of(RosModelTypes.ROS_NODE)));
        hints.add(new ShapeTypeHint(
                RosModelTypes.PROCESS_NODE,
                true,
                true,
                true,
                false,
                List.of(RosModelTypes.ROS_NODE)));
        hints.add(new ShapeTypeHint(RosModelTypes.PACKAGE_NODE, true, true, false, false));

        for (String portType : List.of(
                RosModelTypes.PORT_PUB,
                RosModelTypes.PORT_SUB,
                RosModelTypes.PORT_SS,
                RosModelTypes.PORT_SC,
                RosModelTypes.PORT_AS,
                RosModelTypes.PORT_AC)) {
            hints.add(new ShapeTypeHint(portType, false, false, false, false));
        }
        return hints;
    }

    @Override
    public List<EdgeTypeHint> getEdgeTypeHints() {
        List<EdgeTypeHint> hints = new ArrayList<>();
        hints.add(new EdgeTypeHint(
                RosModelTypes.EDGE_CONNECTION,
                true,
                true,
                true,
                true,
                List.of(
                        RosModelTypes.PORT_PUB,
                        RosModelTypes.PORT_SUB,
                        RosModelTypes.PORT_SS,
                        RosModelTypes.PORT_SC,
                        RosModelTypes.PORT_AS,
                        RosModelTypes.PORT_AC),
                List.of(
                        RosModelTypes.PORT_PUB,
                        RosModelTypes.PORT_SUB,
                        RosModelTypes.PORT_SS,
                        RosModelTypes.PORT_SC,
                        RosModelTypes.PORT_AS,
                        RosModelTypes.PORT_AC)));
        return hints;
    }
}
