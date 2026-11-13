package de.fraunhofer.ipa.ros.glsp.layout;

import de.fraunhofer.ipa.ros.glsp.RosModelTypes;
import org.eclipse.elk.alg.layered.options.CrossingMinimizationStrategy;
import org.eclipse.elk.alg.layered.options.LayeredMetaDataProvider;
import org.eclipse.elk.alg.layered.options.LayeredOptions;
import org.eclipse.elk.core.math.ElkPadding;
import org.eclipse.elk.core.options.CoreOptions;
import org.eclipse.elk.core.options.Direction;
import org.eclipse.elk.core.options.EdgeRouting;
import org.eclipse.elk.core.options.HierarchyHandling;
import org.eclipse.elk.core.options.PortConstraints;
import org.eclipse.elk.core.options.PortSide;
import org.eclipse.glsp.graph.DefaultTypes;
import org.eclipse.glsp.graph.GGraph;
import org.eclipse.glsp.layout.ElkLayoutEngine;
import org.eclipse.glsp.layout.GLSPLayoutConfigurator;

/**
 * Eclipse Layout Kernel (ELK) configuration for RosTooling diagrams.
 * Provides port-aware layered layout (LEFT -> RIGHT) and obstacle-avoiding
 * orthogonal edge routing.
 */
public class RosLayoutEngine extends ElkLayoutEngine {

    static {
        ElkLayoutEngine.initialize(new LayeredMetaDataProvider());
    }

    @com.google.inject.Inject
    protected de.fraunhofer.ipa.ros.glsp.model.RosModelState rosModelState;

    @Override
    public void layout() {
        if (modelState.getRoot() instanceof GGraph ggraph) {
            GLSPLayoutConfigurator configurator = createConfigurator();
            this.layout(ggraph, configurator);
            applyPinnedPositions(ggraph);
        }
    }

    /**
     * User-pinned nodes (ChangeBoundsOperation, persisted in the optional .layout sidecar) override
     * the ELK position. Wires attached to a pinned node lose their ELK route so the client routes
     * them from the ports (ELK cannot honour fixed positions in layered mode).
     */
    protected void applyPinnedPositions(final GGraph ggraph) {
        if (rosModelState == null || rosModelState.getPinnedPositions().isEmpty()) {
            return;
        }
        java.util.Set<String> moved = new java.util.HashSet<>();
        for (org.eclipse.glsp.graph.GModelElement child : ggraph.getChildren()) {
            if (child instanceof org.eclipse.glsp.graph.GNode node
                    && rosModelState.getPinnedPositions().containsKey(node.getId())) {
                org.eclipse.glsp.graph.GPoint p = rosModelState.getPinnedPositions().get(node.getId());
                node.setPosition(org.eclipse.glsp.graph.util.GraphUtil.point(p.getX(), p.getY()));
                moved.add(node.getId());
                node.eAllContents().forEachRemaining(o -> {
                    if (o instanceof org.eclipse.glsp.graph.GModelElement el) {
                        moved.add(el.getId());
                    }
                });
            }
        }
        for (org.eclipse.glsp.graph.GModelElement child : ggraph.getChildren()) {
            if (child instanceof org.eclipse.glsp.graph.GEdge edge
                    && (moved.contains(edge.getSourceId()) || moved.contains(edge.getTargetId()))) {
                edge.getRoutingPoints().clear();
            }
        }
    }

    public GLSPLayoutConfigurator createConfigurator() {
        GLSPLayoutConfigurator configurator = new GLSPLayoutConfigurator();

        // Graph-level ELK Layered + Orthogonal Obstacle Routing configuration
        configurator.configureByType(DefaultTypes.GRAPH)
                .setProperty(CoreOptions.ALGORITHM, LayeredOptions.ALGORITHM_ID)
                .setProperty(CoreOptions.DIRECTION, Direction.RIGHT)
                .setProperty(CoreOptions.EDGE_ROUTING, EdgeRouting.ORTHOGONAL)
                .setProperty(CoreOptions.HIERARCHY_HANDLING, HierarchyHandling.INCLUDE_CHILDREN)
                .setProperty(CoreOptions.PADDING, new ElkPadding(40.0, 40.0, 40.0, 40.0))
                .setProperty(CoreOptions.SPACING_NODE_NODE, 65.0)
                .setProperty(CoreOptions.SPACING_EDGE_NODE, 30.0)
                .setProperty(CoreOptions.SPACING_EDGE_EDGE, 20.0)
                .setProperty(CoreOptions.SPACING_PORT_PORT, 16.0)
                .setProperty(LayeredOptions.SPACING_NODE_NODE_BETWEEN_LAYERS, 160.0)
                .setProperty(LayeredOptions.SPACING_EDGE_NODE_BETWEEN_LAYERS, 35.0)
                .setProperty(LayeredOptions.SPACING_EDGE_EDGE_BETWEEN_LAYERS, 20.0)
                .setProperty(
                        LayeredOptions.CROSSING_MINIMIZATION_STRATEGY,
                        CrossingMinimizationStrategy.LAYER_SWEEP);

        // Node-level port constraints
        configurator.configureByType(RosModelTypes.ROS_NODE)
                .setProperty(CoreOptions.PORT_CONSTRAINTS, PortConstraints.FIXED_POS);

        configurator.configureByType(RosModelTypes.SUBSYSTEM_NODE)
                .setProperty(CoreOptions.ALGORITHM, LayeredOptions.ALGORITHM_ID)
                .setProperty(CoreOptions.DIRECTION, Direction.RIGHT)
                .setProperty(CoreOptions.EDGE_ROUTING, EdgeRouting.ORTHOGONAL)
                .setProperty(CoreOptions.PORT_CONSTRAINTS, PortConstraints.FIXED_SIDE)
                .setProperty(CoreOptions.PADDING, new ElkPadding(48.0, 24.0, 24.0, 24.0))
                .setProperty(CoreOptions.SPACING_NODE_NODE, 45.0)
                .setProperty(LayeredOptions.SPACING_NODE_NODE_BETWEEN_LAYERS, 120.0);

        configurator.configureByType(RosModelTypes.PROCESS_NODE)
                .setProperty(CoreOptions.ALGORITHM, LayeredOptions.ALGORITHM_ID)
                .setProperty(CoreOptions.DIRECTION, Direction.RIGHT)
                .setProperty(CoreOptions.EDGE_ROUTING, EdgeRouting.ORTHOGONAL)
                .setProperty(CoreOptions.PADDING, new ElkPadding(44.0, 20.0, 20.0, 20.0));

        // Input/Target ports on WEST (Left side of node card)
        configurator.configureByType(RosModelTypes.PORT_SUB)
                .setProperty(CoreOptions.PORT_SIDE, PortSide.WEST);
        configurator.configureByType(RosModelTypes.PORT_SC)
                .setProperty(CoreOptions.PORT_SIDE, PortSide.WEST);
        configurator.configureByType(RosModelTypes.PORT_AC)
                .setProperty(CoreOptions.PORT_SIDE, PortSide.WEST);

        // Output/Source ports on EAST (Right side of node card)
        configurator.configureByType(RosModelTypes.PORT_PUB)
                .setProperty(CoreOptions.PORT_SIDE, PortSide.EAST);
        configurator.configureByType(RosModelTypes.PORT_SS)
                .setProperty(CoreOptions.PORT_SIDE, PortSide.EAST);
        configurator.configureByType(RosModelTypes.PORT_AS)
                .setProperty(CoreOptions.PORT_SIDE, PortSide.EAST);

        return configurator;
    }
}
