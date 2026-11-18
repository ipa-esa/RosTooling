package de.fraunhofer.ipa.ros.glsp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.inject.Guice;
import com.google.inject.Injector;
import de.fraunhofer.ipa.ros.glsp.model.RosCatalogueResolver;
import de.fraunhofer.ipa.ros.glsp.model.RosModelState;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.eclipse.glsp.graph.GModelRoot;
import org.eclipse.glsp.server.di.ServerModule;
import org.eclipse.glsp.server.features.core.model.GModelFactory;
import org.eclipse.glsp.server.features.core.model.RequestModelAction;
import org.eclipse.glsp.server.features.core.model.SourceModelStorage;
import org.eclipse.glsp.server.features.validation.Marker;
import org.eclipse.glsp.server.features.validation.MarkersReason;
import org.eclipse.glsp.server.features.validation.ModelValidator;
import org.eclipse.glsp.server.protocol.InitializeClientSessionParameters;
import org.eclipse.glsp.server.session.ClientSession;
import org.eclipse.glsp.server.session.ClientSessionManager;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

/**
 * Verifies that {@link RosCatalogueResolver} indexes every root package declared in multi-package
 * {@code .ros} {@code PackageSet} files (such as {@code common_msgs.ros} / {@code ros_core.ros})
 * rather than stopping after the first package header.
 */
class RosCatalogueResolverTest {

    @TempDir
    Path tempDir;

    @Test
    void indexesAllPackagesInMultiPackageRosFileAndValidatesReferences() throws Exception {
        Path catalogueDir = tempDir.resolve("catalogue");
        Path commonDir = catalogueDir.resolve("RosCommonObjects/basic_msgs");
        Files.createDirectories(commonDir);

        Path commonMsgs = commonDir.resolve("common_msgs.ros");
        Files.writeString(commonMsgs, String.join("\n",
                "# Multi-package catalogue file",
                "actionlib_msgs:",
                "  msgs:",
                "    GoalID",
                "      message",
                "        string id",
                "diagnostic_msgs:",
                "  msgs:",
                "    KeyValue",
                "      message",
                "        string key",
                "        string value",
                "geometry_msgs: # second+ package should be indexed too",
                "  msgs:",
                "    Point",
                "      message",
                "        float64 x",
                "        float64 y",
                "        float64 z",
                "    Vector3",
                "      message",
                "        float64 x",
                "        float64 y",
                "        float64 z",
                ""));

        Path rosCore = commonDir.resolve("ros_core.ros");
        Files.writeString(rosCore, String.join("\n",
                "std_msgs:",
                "  msgs:",
                "    Empty",
                "      message",
                "std_srvs:",
                "  srvs:",
                "    Trigger",
                "      request",
                "      response",
                "        bool success",
                ""));

        assertEquals(Set.of("actionlib_msgs", "diagnostic_msgs", "geometry_msgs"),
                RosCatalogueResolver.declaredNames(commonMsgs));
        assertEquals(Set.of("std_msgs", "std_srvs"),
                RosCatalogueResolver.declaredNames(rosCore));

        Path modelDir = tempDir.resolve("ws/models");
        Files.createDirectories(modelDir);
        Path modelFile = modelDir.resolve("recovery_interfaces.ros");
        Files.writeString(modelFile, String.join("\n",
                "recovery_interfaces:",
                "  msgs:",
                "    Contact",
                "      message",
                "        \"geometry_msgs/msg/Point\" position",
                "        \"geometry_msgs/msg/Vector3\" normal",
                "        \"geometry_msgs/msg/Point\"[] nearest_points",
                ""));

        String previousProp = System.getProperty("rostooling.catalogue.path");
        System.setProperty("rostooling.catalogue.path", catalogueDir.toString());
        try {
            Injector serverInjector = Guice.createInjector(
                    new ServerModule().configureDiagramModule(new RosGlspModule()));
            ClientSession session = serverInjector.getInstance(ClientSessionManager.class)
                    .getOrCreateClientSession(new InitializeClientSessionParameters(
                            "cat_multi_pkg", RosModelTypes.DIAGRAM_TYPE, Collections.emptyList()));
            Injector inj = session.getInjector();
            inj.getInstance(SourceModelStorage.class).loadSourceModel(
                    new RequestModelAction(Map.of("sourceUri", modelFile.toUri().toString())));
            inj.getInstance(GModelFactory.class).createGModel();
            GModelRoot root = inj.getInstance(RosModelState.class).getRoot();
            List<Marker> markers = inj.getInstance(ModelValidator.class)
                    .validate(List.of(root), MarkersReason.LIVE);
            assertTrue(markers.isEmpty(),
                    "Expected no validation markers for geometry_msgs refs, got: " + markers);
        } finally {
            if (previousProp == null) {
                System.clearProperty("rostooling.catalogue.path");
            } else {
                System.setProperty("rostooling.catalogue.path", previousProp);
            }
        }
    }
}
