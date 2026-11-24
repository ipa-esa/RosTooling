package de.fraunhofer.ipa.ros;

import org.eclipse.xtext.naming.DefaultDeclarativeQualifiedNameProvider
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.emf.ecore.EObject
import ros.TopicSpec
import ros.ServiceSpec
import ros.ActionSpec
import ros.Node
import ros.Plugin
import ros.PluginBase
import ros.Package
import ros.Publisher
import ros.Artifact
import ros.Subscriber
import ros.ServiceServer
import ros.ServiceClient
import ros.ActionServer
import ros.ActionClient
import ros.Parameter
import ros.InterfaceType

class RosQNP extends DefaultDeclarativeQualifiedNameProvider{

  def private QualifiedName artifactScopedName(EObject obj, String name) {
    if (obj !== null && obj.eContainer !== null && obj.eContainer.eContainer instanceof Artifact) {
      val art = obj.eContainer.eContainer as Artifact
      return getConverter().toQualifiedName(art.name + "::" + name)
    }
    if (name !== null && !name.empty) {
      return getConverter().toQualifiedName(name)
    }
    return null
  }

  override getFullyQualifiedName(EObject obj) {

    if (obj instanceof Node) {
      val node_name = obj.name
      if (obj.eContainer !== null && obj.eContainer.eContainer instanceof Package) {
        val pkg = obj.eContainer.eContainer as Package
        return getConverter().toQualifiedName(pkg.name + "." + node_name);
      }
    }
    if (obj instanceof Plugin) {
      val plugin_name = obj.name
      if (obj.eContainer !== null && obj.eContainer.eContainer instanceof Package) {
        val pkg = obj.eContainer.eContainer as Package
        return getConverter().toQualifiedName(pkg.name + "." + plugin_name);
      }
    }
    if (obj instanceof PluginBase) {
      if (obj.eContainer instanceof Package) {
        return getConverter().toQualifiedName((obj.eContainer as Package).name + "." + obj.name);
      }
    }
    if (obj instanceof TopicSpec) {
      val topic_spec_name = obj.name
      val pkg_name = obj.package.name
      return getConverter().toQualifiedName(pkg_name + "/msg/" + topic_spec_name);
    }
    if (obj instanceof ServiceSpec) {
      val service_spec_name = obj.name
      val pkg_name = obj.package.name
      return getConverter().toQualifiedName(pkg_name + "/srv/" + service_spec_name);
    }
    if (obj instanceof ActionSpec) {
      val action_spec_name = obj.name
      val pkg_name = obj.package.name
      return getConverter().toQualifiedName(pkg_name + "/action/" + action_spec_name);
    }
    if (obj instanceof InterfaceType) {
      return artifactScopedName(obj, obj.name);
    }
    // A package is named by its own name, so that "dependencies: [pkg]" can find it among the packages
    // of the workspace and the catalogue; without this the index held no name for a package at all.
    if (obj instanceof Package) {
      if (obj.name !== null && !obj.name.empty) {
        return QualifiedName.create(obj.name)
      }
    }

    return super.qualifiedName(obj);
    }
}
