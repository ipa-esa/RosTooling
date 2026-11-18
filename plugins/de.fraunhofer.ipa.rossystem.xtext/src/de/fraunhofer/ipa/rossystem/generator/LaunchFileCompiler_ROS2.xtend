package de.fraunhofer.ipa.rossystem.generator

import com.google.inject.Inject
import de.fraunhofer.ipa.ros.plugin.spi.SystemGenerationContext
import java.util.ArrayList
import java.util.List
import org.eclipse.emf.common.util.EList
import ros.Artifact
import ros.Parameter
import ros.impl.AmentPackageImpl
import system.Connection
import system.RosActionServerReference
import system.RosNode
import system.System
import system.impl.RosActionClientReferenceImpl
import system.impl.RosActionServerReferenceImpl
import system.impl.RosInterfaceImpl
import system.impl.RosPublisherReferenceImpl
import system.impl.RosServiceClientReferenceImpl
import system.impl.RosServiceServerReferenceImpl
import system.impl.RosSubscriberReferenceImpl
import system.impl.RosSystemConnectionImpl

class LaunchFileCompiler_ROS2 {

    /** Python variable name for a parameter: ROS names may contain '.' (nested parameters) or '/'. */
    def String pyIdentifier(String name) {
        val id = name.replaceAll("[^A-Za-z0-9_]", "_")
        return if (id.matches("^[0-9].*")) "_" + id else id
    }

    @Inject extension GeneratorHelpers


    def compile_toROS2launch(System system) {
        return compile_toROS2launch(system, List.of())
    }

    /**
     * ROS 2 launch file of a system. launch_ros' LifecycleNode takes {@code namespace} as a
     * required keyword argument on every supported distribution, so lifecycle nodes always get
     * one ({@code ""} when the model sets none); plain Node and ComposableNode keep it optional.
     */
    def compile_toROS2launch(System system, List<SystemGenerationContext.LaunchInclude> pluginIncludes) '''
«IF YamlFileGenerated(system)»import os«ENDIF»
from launch import LaunchDescription
«IF !getStandaloneRos2Nodes(system).empty || !hasComponentContainers(system)»from launch_ros.actions import Node«ENDIF»
«IF hasStandaloneLifecycleNodes(system)»from launch_ros.actions import LifecycleNode«ENDIF»
«IF hasComponentContainers(system)»
from launch_ros.actions import ComposableNodeContainer
from launch_ros.descriptions import ComposableNode
«ENDIF»
from launch_ros.parameter_descriptions import ParameterValue
«IF hasSubstitutionValues(system) || hasPluginIncludeSubstitutions(pluginIncludes)»from launch.frontend.parse_substitution import parse_substitution«ENDIF»
«IF !getSubsystems(system).empty || !pluginIncludes.empty»from ament_index_python.packages import get_package_share_directory«ENDIF»
from launch.actions import IncludeLaunchDescription, DeclareLaunchArgument
from launch.launch_description_sources import PythonLaunchDescriptionSource
from launch.substitutions import LaunchConfiguration, PythonExpression, PathJoinSubstitution, TextSubstitution

def generate_launch_description():
  ld = LaunchDescription()

  # *** PARAMETERS ***
  «FOR parameter:system.parameter»«IF !isSubstitutionParameter(parameter as ros.Parameter)»
  «pyIdentifier((parameter as ros.Parameter).name)»_arg = DeclareLaunchArgument(
    "«(parameter as ros.Parameter).name»", default_value=TextSubstitution(text="«get_param_value((parameter as ros.Parameter).value,(parameter as ros.Parameter).name)»")
  )
  ld.add_action(«pyIdentifier((parameter as ros.Parameter).name)»_arg)
  «ENDIF»«ENDFOR»
  «FOR component:getRos2Nodes(system)»«IF generate_yaml(component)»
  «component.name»_config = os.path.join(
    get_package_share_directory('«system.getName().toLowerCase»'),
    'config',
    '«component.name».yaml'
  )
  «ENDIF»«ENDFOR»
  «FOR parameter:getUniqueLaunchParameters(system)»
  «pyIdentifier(parameter.name)»_arg = DeclareLaunchArgument(
    "«parameter.name»", default_value=TextSubstitution(text="«get_param_value(parameter.value,parameter.name)»")
  )
  ld.add_action(«pyIdentifier(parameter.name)»_arg)
  «ENDFOR»

  «IF hasComponentContainers(system)»
  # *** ROS 2 component containers ***
  «FOR proc:getProcessesWithRos2Nodes(system)»
  container_«proc.name» = ComposableNodeContainer(
    name="«proc.name»",
    namespace="",
    package="rclcpp_components",
    executable="«IF proc.threads > 1»component_container_mt«ELSE»component_container«ENDIF»",
    composable_node_descriptions=[
      «FOR component:getProcessRos2Nodes(proc) SEPARATOR ',\n'»
      ComposableNode(
        package="«((component as RosNode).from.eContainer.eContainer as AmentPackageImpl).name»",
        plugin="«getPluginName(component as RosNode)»",
        name="«(component as RosNode).name»"«IF !(component as RosNode).namespace.nullOrEmpty»,
        namespace="«(component as RosNode).namespace»"«ENDIF»«compile_remappings_str(component as RosNode, system.connections)»«IF !(component as RosNode).rosparameters.nullOrEmpty || hasAutoSlotParameters(component as RosNode)»«IF generate_yaml(component as RosNode)»,
        parameters=[«(component as RosNode).name»_config«IF hasSubstitutionParameters(component as RosNode)», {«FOR param:(component as RosNode).rosparameters»«IF isSubstitutionValue(param)»"«param.from.name»": ParameterValue(parse_substitution("«escapePythonString(get_param_value(param.value,param.name))»"), value_type=str),«ENDIF»«ENDFOR»}«ENDIF»]«ELSE»,
        parameters=[{«FOR param:(component as RosNode).rosparameters»
          «IF isSubstitutionValue(param)»"«param.from.name»": ParameterValue(parse_substitution("«escapePythonString(get_param_value(param.value,param.name))»"), value_type=str),«ELSE»«IF isStringParameter(param)»"«param.from.name»": ParameterValue(LaunchConfiguration("«param.name»"), value_type=str),«ELSE»"«param.from.name»": LaunchConfiguration("«param.name»"),«ENDIF»«ENDIF»«ENDFOR»«compile_slot_params_str(component as RosNode)»}]«ENDIF»«ENDIF»
      )«ENDFOR»
    ],
    output='screen'
  )
  «ENDFOR»
  «ENDIF»

  # *** ROS 2 standalone nodes ***
  «FOR component:getStandaloneRos2Nodes(system)»
  «val isLc = isLifecycleNode((component as RosNode).from)»
  «val actionClass = if (isLc) "LifecycleNode" else "Node"»
  «IF !component.namespace.nullOrEmpty»«GeneratorHelpers.removeLeadingSlash(component.namespace)»_«(component as RosNode).name» = «actionClass»(«ELSE»
  «(component as RosNode).name» = «actionClass»(«ENDIF»
    package="«((component as RosNode).from.eContainer.eContainer as AmentPackageImpl).name»",«IF !component.namespace.nullOrEmpty»
    namespace="«component.namespace»",«ELSEIF isLc»
    namespace="",«ENDIF»
    executable="«((component as RosNode).from.eContainer as Artifact).name»",
    output='screen',
    name="«(component as RosNode).name»"«compile_remappings_str(component as RosNode, system.connections)»«IF !component.rosparameters.nullOrEmpty || hasAutoSlotParameters(component as RosNode)»«IF generate_yaml(component)»,
    parameters = [«component.name»_config«IF hasSubstitutionParameters(component)», {«FOR param:component.rosparameters»«IF isSubstitutionValue(param)»"«param.from.name»": ParameterValue(parse_substitution("«escapePythonString(get_param_value(param.value,param.name))»"), value_type=str),«ENDIF»«ENDFOR»}«ENDIF»]«ELSE»,
    parameters=[{«FOR param:component.rosparameters»
      «IF isSubstitutionValue(param)»"«param.from.name»": ParameterValue(parse_substitution("«escapePythonString(get_param_value(param.value,param.name))»"), value_type=str),«ELSE»«IF isStringParameter(param)»"«param.from.name»": ParameterValue(LaunchConfiguration("«param.name»"), value_type=str),«ELSE»"«param.from.name»": LaunchConfiguration("«param.name»"),«ENDIF»«ENDIF»«ENDFOR»«compile_slot_params_str(component as RosNode)»}]«ENDIF»«ENDIF»
  )
  «ENDFOR»

  # *** ROS 2 subsystems (include launch files)***
  «FOR subsystem:getSubsystems(system)»
  «IF subsystem.fromFile.nullOrEmpty»
  include_«subsystem.name»= IncludeLaunchDescription(
    PythonLaunchDescriptionSource([ get_package_share_directory('«subsystem.name»') + '/launch/«subsystem.name».launch.py'])«IF has_matching_parameters(system, subsystem)»,
    launch_arguments={
      «FOR param : system.parameter»«IF subsystem_references_parameter(subsystem, (param as ros.Parameter).name)»
      '«(param as ros.Parameter).name»': LaunchConfiguration('«(param as ros.Parameter).name»'),«ENDIF»«ENDFOR»
    }.items()«ENDIF»
  )
  «ELSE»
  include_«subsystem.name»= IncludeLaunchDescription(
    PythonLaunchDescriptionSource([get_package_share_directory('«subsystem.fromFile.split("/",2).get(0)»') + '/«subsystem.fromFile.split("/",2).get(1)»'])«IF has_matching_parameters(system, subsystem)»,
    launch_arguments={
      «FOR param : system.parameter»«IF subsystem_references_parameter(subsystem, (param as ros.Parameter).name)»
      '«(param as ros.Parameter).name»': LaunchConfiguration('«(param as ros.Parameter).name»'),«ENDIF»«ENDFOR»
    }.items()«ENDIF»
  )
  «ENDIF»«ENDFOR»«IF !pluginIncludes.empty»
  «FOR i : 0 ..< pluginIncludes.size»
  «val inc = pluginIncludes.get(i)»
  «pluginIncludeVarName(inc, i)»= IncludeLaunchDescription(
    PythonLaunchDescriptionSource([get_package_share_directory('«system.getName().toLowerCase»') + '/«inc.launchFileRelativePath»'])«IF !inc.launchArguments.empty»,
    launch_arguments={
      «FOR arg : inc.launchArguments.entrySet SEPARATOR ','»
      '«arg.key»': «renderPluginLaunchArg(arg.value)»
      «ENDFOR»
    }.items()«ENDIF»
  )
  «ENDFOR»
«ENDIF»

  # *** Add actions ***
  «FOR proc:getProcessesWithRos2Nodes(system)»
  ld.add_action(container_«proc.name»)
  «ENDFOR»
  «FOR component:getStandaloneRos2Nodes(system)»
  «IF !component.namespace.nullOrEmpty»
  ld.add_action(«GeneratorHelpers.removeLeadingSlash(component.namespace)»_«(component as RosNode).name»)
  «ELSE»
  ld.add_action(«(component as RosNode).name»)
  «ENDIF»
  «ENDFOR»«FOR subsystem:getSubsystems(system)»
  ld.add_action(include_«subsystem.name»)
  «ENDFOR»«IF !pluginIncludes.empty»«FOR i : 0 ..< pluginIncludes.size»
  ld.add_action(«pluginIncludeVarName(pluginIncludes.get(i), i)»)
  «ENDFOR»«ENDIF»

  return ld
    '''

    def boolean hasPluginIncludeSubstitutions(List<SystemGenerationContext.LaunchInclude> pluginIncludes) {
        if (pluginIncludes === null) return false
        for (inc : pluginIncludes) {
            for (arg : inc.launchArguments.values) {
                if (arg.kind == SystemGenerationContext.LaunchArgumentKind.SUBSTITUTION) return true
            }
        }
        return false
    }

    def String pluginIncludeVarName(SystemGenerationContext.LaunchInclude inc, int idx) {
        val base = (inc.pluginId + "_" + inc.launchFileRelativePath).replaceAll("[^A-Za-z0-9_]", "_")
        return "include_plugin_" + idx + "_" + base
    }

    def String renderPluginLaunchArg(SystemGenerationContext.LaunchArgumentValue arg) {
        switch (arg.kind) {
            case SYSTEM_LAUNCH_ARG: "LaunchConfiguration('" + escapePythonString(arg.value) + "')"
            case SUBSTITUTION: "parse_substitution(\"" + escapePythonString(arg.value) + "\")"
            default: "TextSubstitution(text=\"" + escapePythonString(arg.value) + "\")"
        }
    }



//    def void compile_list_of_ROS2components(RosSystem system, ComponentStack stack) {
//        components_tmp_.clear;
//        Ros2components.clear;
//        if (stack === null){
//            components_tmp_ = system.rosComponent;
//        } else {
//            components_tmp_ =  stack.rosComponent;
//        }
//        for(ComponentInterface component:components_tmp_){
//            if (component.compile_pkg_type.toString.contains("AmentPackage")){
//                Ros2components.add(component);
//            }
//        }
//    }
//
//    def check_ns(ComponentInterface component){
//        if (component.hasNS){
//            return component.get_ns();
//        }else {
//            return "";
//        }
//    }
//
//    def List<String> InterfaceDef(String name, String type){
//        ListInterfaceDef = new ArrayList()
//        ListInterfaceDef.add(name.replace("/","_"))
//        ListInterfaceDef.add(name)
//        ListInterfaceDef.add(type)
//        return ListInterfaceDef
//    }
//
//    def boolean hasNS(ComponentInterface component){
//        if(!component.nameSpace.nullOrEmpty){
//            return true;
//        }else{
//            return false
//        }
//    }
//    def String get_ns(ComponentInterface component){
//        return component.nameSpace.replaceFirst("/","");
//    }
//
    def String compile_remappings_str(RosNode node, EList<Connection> connections ) {
        var remap_str = ""
        var from_pub = new Object
        var from_srv = new Object
        var from_action = new Object
        var to_sub = new Object
        var to_srv = new Object
        var to_action = new Object
        var remapped_interfaces = new ArrayList

        var rename = ""


        for (connection : connections){
            var rosconnection = connection as RosSystemConnectionImpl
            if (rosconnection.from.reference.eClass.toString.contains("RosPublisherReference")){
                from_pub = rosconnection.from.reference
                rename= rosconnection.from.name

                if (rosconnection.to.reference.eClass.toString.contains("RosSubscriberReference")){
                    to_sub = rosconnection.to.reference
                }

                for ( interface : node.rosinterfaces ){
                    if ( (interface as RosInterfaceImpl).reference.toString.contains("RosPublisherReferenceImpl")){
                           if ((interface as RosInterfaceImpl).reference == from_pub){
                               if ((from_pub as RosPublisherReferenceImpl).from.name != interface.name) {
                                    remapped_interfaces.add(interface)
                                    remap_str += "\t(\"" + (from_pub as RosPublisherReferenceImpl).from.name + "\", \"" + rename + "\"),\n";
                               }
                           }
                        }
                    if ( (interface as RosInterfaceImpl).reference.toString.contains("RosSubscriberReferenceImpl")){
                           if ((interface as RosInterfaceImpl).reference == to_sub){
                               if ((to_sub as RosSubscriberReferenceImpl).from.name  != from_pub) {
                                    remapped_interfaces.add(interface)
                                    remap_str += "\t(\"" + (to_sub as RosSubscriberReferenceImpl).from.name + "\", \"" + rename + "\"),\n";
                               }
                           }
                        }
                }
            }
            if (rosconnection.from.reference.eClass.toString.contains("RosServiceServerReference")){
                from_srv = rosconnection.from.reference
                rename= rosconnection.from.name

                if (rosconnection.to.reference.eClass.toString.contains("RosServiceClientReference")){
                    to_srv = rosconnection.to.reference
                }

                for ( interface : node.rosinterfaces ){
                    if ( (interface as RosInterfaceImpl).reference.toString.contains("RosServiceServerReferenceImpl")){
                           if ((interface as RosInterfaceImpl).reference == from_srv){
                               if ((from_srv as RosServiceServerReferenceImpl).from.name != interface.name) {
                                    remapped_interfaces.add(interface)
                                    remap_str += "\t(\"" + (from_srv as RosServiceServerReferenceImpl).from.name + "\", \"" + rename + "\"),\n";
                               }
                           }
                        }
                    if ( (interface as RosInterfaceImpl).reference.toString.contains("RosServiceClientReferenceImpl")){
                           if ((interface as RosInterfaceImpl).reference == to_srv){
                               if ((to_srv as RosServiceClientReferenceImpl).from.name  != from_srv) {
                                    remapped_interfaces.add(interface)
                                    remap_str += "\t(\"" + (to_srv as RosServiceClientReferenceImpl).from.name + "\", \"" + rename + "\"),\n";
                               }
                           }
                        }
                }
        }
        if (rosconnection.from.reference.eClass.toString.contains("RosActionServerReference")){
                from_action = rosconnection.from.reference
                rename= rosconnection.from.name

                if (rosconnection.to.reference.eClass.toString.contains("RosActionClientReference")){
                    to_action = rosconnection.to.reference
                }

                for ( interface : node.rosinterfaces ){
                    if ( (interface as RosInterfaceImpl).reference.toString.contains("RosActionServerReferenceImpl")){
                           if ((interface as RosInterfaceImpl).reference == from_action){
                               if ((from_action as RosActionServerReferenceImpl).from.name != interface.name) {
                                    remapped_interfaces.add(interface)
                                    remap_str += "\t(\"" + (from_action as RosActionServerReferenceImpl).from.name + "\", \"" + rename + "\"),\n";
                               }
                           }
                        }
                    if ( (interface as RosInterfaceImpl).reference.toString.contains("RosActionClientReferenceImpl")){
                           if ((interface as RosInterfaceImpl).reference == to_action){
                               if ((to_action as RosActionClientReferenceImpl).from.name  != from_action) {
                                    remapped_interfaces.add(interface)
                                    remap_str += "\t(\"" + (to_action as RosActionClientReferenceImpl).from.name + "\", \"" + rename + "\"),\n";
                               }
                           }
                        }
                }
        }

        }

        for (interface : node.rosinterfaces){
            if (!remapped_interfaces.contains(interface)){
                var origin = interface.reference.eCrossReferences.toString
                var origin_name = origin.substring(origin.indexOf("name: ") + 6, origin.lastIndexOf(")]"))
                if (interface.name.equals(origin_name)){
                    if (interface.reference instanceof RosActionServerReference){
                        val actionSuffixes = new ArrayList
                            actionSuffixes.add("/_action/feedback")
                            actionSuffixes.add("/_action/status")
                            actionSuffixes.add("/_action/cancel_goal")
                            actionSuffixes.add("/_action/get_result")
                            actionSuffixes.add("/_action/send_goal")
                            for (suf : actionSuffixes) {
                               remap_str += "\t(\"" + origin_name + suf + "\", \"" + interface.name + suf + "\"),\n";
                            }
                    }
                    else{
                        remap_str += "\t(\"" + origin_name + "\", \"" + interface.name + "\"),\n";

                    }
                }
            }
        }
//        for (rosPublisher : interfaces.toList) {
//            if (!((prefix(NS)+rosPublisher.name).equals(compile_topic_name(rosPublisher.publisher, NS)))) {
//                remap_str += "\t(\"" + rosPublisher.publisher.name + "\", \"" + rosPublisher.name + "\"),\n";
//            }
//        }
//        for (rosSubscriber : component.rossubscriber) {
//            if (!((prefix(NS)+rosSubscriber.name).equals(compile_topic_name(rosSubscriber.subscriber, NS)))) {
//                remap_str += "\t(\"" + rosSubscriber.subscriber.name + "\", \"" + rosSubscriber.name + "\"),\n";
//            }
//        }
//        for (rosServiceServer : component.rosserviceserver) {
//            if (!((prefix(NS)+rosServiceServer.name).equals(compile_service_name(rosServiceServer.srvserver, NS)))) {
//                remap_str += "\t(\"" + rosServiceServer.srvserver.name + "\", \"" + rosServiceServer.name + "\"),\n";
//            }
//        }
//        for (rosServiceClient : component.rosserviceclient) {
//            if (!((prefix(NS)+rosServiceClient.name).equals(compile_service_name(rosServiceClient.srvclient, NS)))) {
//                remap_str += "\t(\"" + rosServiceClient.srvclient.name + "\", \"" + rosServiceClient.name + "\"),\n";
//            }
//        }
//        for (rosActionServer : component.rosactionserver) {
//            if (!((prefix(NS)+rosActionServer.name).equals(compile_action_name(rosActionServer.actserver, NS)))) {
//                remap_str += "\t(\"" + rosActionServer.actserver.name + "\", \"" + rosActionServer.name + "\"),\n";
//            }
//        }
//        for (rosActionClient : component.rosactionclient) {
//            if (!((prefix(NS)+rosActionClient.name).equals(compile_action_name(rosActionClient.actclient, NS)))) {
//                remap_str += "\t(\"" + rosActionClient.actclient.name + "\", \"" + rosActionClient.name + "\"),\n";
//            }
//        }
        if (!remap_str.empty) {
            remap_str = ",\nremappings=[\n" + remap_str.substring(0,remap_str.length-2) + "]\n";
        }
        return remap_str;
    }

    def String compile_slot_params_str(RosNode node) {
        val entries = getSlotParameterEntries(node)
        if (entries.empty) return ""
        val sb = new StringBuilder()
        for (entry : entries) {
            if (entry.array) {
                sb.append("\n      \"").append(entry.paramName).append("\": [")
                for (var i = 0; i < entry.values.size; i++) {
                    if (i > 0) sb.append(", ")
                    sb.append("\"").append(escapePythonString(entry.values.get(i))).append("\"")
                }
                sb.append("],")
            } else {
                sb.append("\n      \"").append(entry.paramName).append("\": ParameterValue(\"")
                  .append(escapePythonString(entry.values.head)).append("\", value_type=str),")
            }
        }
        return sb.toString()
    }
//
//    def String compile_parameters_str(EList<RosParameter> rosParameters) {
//        param_count = rosParameters.length;
//        var param_str = "";
//        for (rosParameter : rosParameters) {
//            val param_count=param_count--;
//            if (rosParameter.parameter.type instanceof ParameterStructTypeImpl) {
//                param_str += compile_struct_str(rosParameter.value, rosParameter.parameter.name);
//            } else {
//                param_str += "{ \"" + rosParameter.parameter.name + "\" : " + get_param_value(rosParameter.value, rosParameter.parameter.name);
//            }
//            if (param_count > 1){
//                param_str +=" },\n"
//            } else {
//                param_str +=" }\n";
//            }
//        }
//        return param_str;
//    }
//

}
