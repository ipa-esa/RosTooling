import java.io.File;
import java.util.Collections;

import org.eclipse.emf.codegen.ecore.generator.Generator;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage;
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenBaseGeneratorAdapter;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

/** Headless EMF generator, run by tools/emf/emf_generated.py: EmfGen ROOT ECORE_JAR CODEGEN_JAR genmodel-path... (paths relative to ROOT). */
public class EmfGen {
    public static void main(String[] args) throws Exception {
        File root = new File(args[0]).getAbsoluteFile();
        EcorePackage.eINSTANCE.eClass();
        GenModelPackage.eINSTANCE.eClass();
        org.eclipse.emf.codegen.ecore.generator.GeneratorAdapterFactory.Descriptor.Registry.INSTANCE.addDescriptor(GenModelPackage.eNS_URI, org.eclipse.emf.codegen.ecore.genmodel.generator.GenModelGeneratorAdapterFactory.DESCRIPTOR);
        for (File project : root.listFiles(File::isDirectory)) {
            EcorePlugin.getPlatformResourceMap().put(project.getName(),
                    URI.createFileURI(project.getPath() + "/"));
        }
        ResourceSet rs = new ResourceSetImpl();
        rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
        rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("genmodel", new XMIResourceFactoryImpl());
        rs.getURIConverter().getURIMap().put(URI.createURI("platform:/plugin/org.eclipse.emf.ecore/"),
                URI.createURI("jar:file:" + args[1] + "!/"));
        rs.getURIConverter().getURIMap().put(URI.createURI("platform:/plugin/org.eclipse.emf.codegen.ecore/"),
                URI.createURI("jar:file:" + args[2] + "!/"));
        for (int i = 3; i < args.length; i++) {
            URI uri = URI.createFileURI(new File(root, args[i]).getPath());
            Resource res = rs.getResource(uri, true);
            GenModel genModel = (GenModel) res.getContents().get(0);
            genModel.reconcile();
            genModel.setCanGenerate(true);
            Diagnostic d = genModel.diagnose();
            if (d.getSeverity() == Diagnostic.ERROR) {
                System.err.println(d);
                System.exit(1);
            }
            java.util.Map<Object,Object> opts = new java.util.HashMap<>(); opts.put(org.eclipse.emf.ecore.xmi.XMLResource.OPTION_LINE_WIDTH, 80); opts.put(org.eclipse.emf.ecore.xmi.XMLResource.OPTION_ENCODING, "UTF-8"); res.save(opts);
            Generator generator = new Generator();
            generator.setInput(genModel);
            for (String type : new String[] { GenBaseGeneratorAdapter.MODEL_PROJECT_TYPE,
                    GenBaseGeneratorAdapter.EDIT_PROJECT_TYPE }) {
                Diagnostic g = generator.generate(genModel, type, new BasicMonitor.Printing(System.out));
                System.out.println(args[i] + " " + type + ": " + g.getSeverity() + " " + g.getMessage());
                for (Diagnostic c : g.getChildren()) {
                    System.out.println("  " + c.getMessage());
                }
            }
        }
    }
}
