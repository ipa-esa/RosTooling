package de.fraunhofer.ipa.rossystem.scoping

import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtext.scoping.IScope
import org.eclipse.xtext.scoping.impl.SimpleScope
import org.eclipse.xtext.resource.EObjectDescription
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.EcoreUtil2
import system.System
import system.RossystemPackage
import system.RossystemFactory
import system.RosNode
import system.RosInterface
import system.SubSystem
import java.util.List
import java.util.Map
import java.util.Set
import ros.Node
import ros.Publisher
import ros.Subscriber
import ros.ServiceServer
import ros.ServiceClient
import ros.ActionServer
import ros.ActionClient

/**
 * Custom scoping provider for RosSystem connections.
 * 
 * Supports:
 *  1. Short unqualified names (e.g., 'filtered_image_pub') whenever the interface name
 *     is uniquely resolvable across the entire system AND its subsystems (100% backward-compatible).
 *  2. Colon-scoped qualified names (e.g., 'node1::map', 'sub1::node1::map')
 *     to deterministically resolve connections when multiple nodes (including across subsystems)
 *     declare identically named interfaces.
 *  3. Automatic synthetic interface exposure for nodes that do not declare explicit 'interfaces:' blocks.
 */
class RosSystemScopeProvider extends AbstractRosSystemScopeProvider {

  override IScope getScope(EObject context, EReference reference) {
    if (reference == RossystemPackage.Literals.ROS_SYSTEM_CONNECTION__FROM ||
        reference == RossystemPackage.Literals.ROS_SYSTEM_CONNECTION__TO) {
      val system = EcoreUtil2.getContainerOfType(context, System)
      if (system !== null) {
        return getRosInterfaceScope(system)
      }
    }
    return super.getScope(context, reference)
  }

  def IScope getRosInterfaceScope(System rootSystem) {
    val List<Pair<String, RosInterface>> allInterfaces = newArrayList
    val Map<String, Integer> nameCounts = newHashMap
    val Set<System> visitedSystems = newHashSet

    collectSystemInterfaces(rootSystem, "", rootSystem, allInterfaces, nameCounts, visitedSystems)

    val descriptions = newArrayList
    val Set<QualifiedName> addedNames = newHashSet

    for (entry : allInterfaces) {
      val nodePrefix = entry.key
      val iface = entry.value
      val ifaceName = iface.name

      if (ifaceName !== null && !ifaceName.empty) {
        // 1. Qualified names:
        // Strictly use colon format (::) to avoid confusion
        if (!nodePrefix.empty) {
          val colonQualified = nodePrefix.replace(".", "::") + "::" + ifaceName
          val qnColon = QualifiedName.create(colonQualified)
          if (addedNames.add(qnColon)) {
            descriptions.add(EObjectDescription.create(qnColon, iface))
          }

          val lastDot = nodePrefix.lastIndexOf('.')
          if (lastDot >= 0) {
            val bareNode = nodePrefix.substring(lastDot + 1)
            if (!bareNode.empty) {
              val qnBareColon = QualifiedName.create(bareNode + "::" + ifaceName)
              if (addedNames.add(qnBareColon)) {
                descriptions.add(EObjectDescription.create(qnBareColon, iface))
              }
            }
          }
        }

        // 2. Short unqualified name (e.g., 'downsampled_costmap') - ONLY if strictly unique (count == 1)
        val count = nameCounts.get(ifaceName)
        if (count !== null && count.intValue == 1) {
          val qnShort = QualifiedName.create(ifaceName)
          if (addedNames.add(qnShort)) {
            descriptions.add(EObjectDescription.create(qnShort, iface))
          }
        }
      }
    }

    return new SimpleScope(descriptions)
  }

  def private void collectSystemInterfaces(
      System currentSystem,
      String prefix,
      System rootSystem,
      List<Pair<String, RosInterface>> allInterfaces,
      Map<String, Integer> nameCounts,
      Set<System> visitedSystems) {

    if (currentSystem === null || !visitedSystems.add(currentSystem)) {
      return
    }

    val components = currentSystem.components
    if (components === null) return

    for (component : components) {
      if (component instanceof RosNode) {
        val rosNode = component as RosNode
        val nodeName = if (rosNode.name !== null) rosNode.name else ""
        val nodePrefix = if (prefix.empty) nodeName else prefix + "." + nodeName

        val nodeExposedNames = newHashSet

        // (a) If the node explicitly declared interfaces, use them
        val interfaces = rosNode.rosinterfaces
        if (interfaces !== null && !interfaces.empty) {
          for (iface : interfaces) {
            allInterfaces.add(Pair.of(nodePrefix, iface))
            if (iface.name !== null && !iface.name.empty) {
              nodeExposedNames.add(iface.name)
            }
          }
        } else {
          // (b) Node declares no explicit interfaces: synthesize RosInterfaces from rosNode.from
          var fromNode = rosNode.from
          if (fromNode !== null && fromNode.eIsProxy) {
            fromNode = EcoreUtil.resolve(fromNode, rootSystem) as Node
          }
          if (fromNode !== null && !fromNode.eIsProxy) {
            val existingNames = newHashSet
            if (rosNode.rosinterfaces !== null) {
              for (ex : rosNode.rosinterfaces) {
                if (ex.name !== null) existingNames.add(ex.name)
              }
            }

            if (fromNode.publisher !== null) {
              for (pub : fromNode.publisher) {
                if (pub.name !== null && !pub.name.empty && existingNames.add(pub.name)) {
                  val iface = RossystemFactory.eINSTANCE.createRosInterface
                  iface.name = pub.name
                  val ref = RossystemFactory.eINSTANCE.createRosPublisherReference
                  ref.from = pub
                  iface.reference = ref
                  rosNode.rosinterfaces.add(iface)
                  allInterfaces.add(Pair.of(nodePrefix, iface))
                  nodeExposedNames.add(pub.name)
                }
              }
            }

            if (fromNode.subscriber !== null) {
              for (sub : fromNode.subscriber) {
                if (sub.name !== null && !sub.name.empty && existingNames.add(sub.name)) {
                  val iface = RossystemFactory.eINSTANCE.createRosInterface
                  iface.name = sub.name
                  val ref = RossystemFactory.eINSTANCE.createRosSubscriberReference
                  ref.from = sub
                  iface.reference = ref
                  rosNode.rosinterfaces.add(iface)
                  allInterfaces.add(Pair.of(nodePrefix, iface))
                  nodeExposedNames.add(sub.name)
                }
              }
            }

            if (fromNode.serviceserver !== null) {
              for (ss : fromNode.serviceserver) {
                if (ss.name !== null && !ss.name.empty && existingNames.add(ss.name)) {
                  val iface = RossystemFactory.eINSTANCE.createRosInterface
                  iface.name = ss.name
                  val ref = RossystemFactory.eINSTANCE.createRosServiceServerReference
                  ref.from = ss
                  iface.reference = ref
                  rosNode.rosinterfaces.add(iface)
                  allInterfaces.add(Pair.of(nodePrefix, iface))
                  nodeExposedNames.add(ss.name)
                }
              }
            }

            if (fromNode.serviceclient !== null) {
              for (sc : fromNode.serviceclient) {
                if (sc.name !== null && !sc.name.empty && existingNames.add(sc.name)) {
                  val iface = RossystemFactory.eINSTANCE.createRosInterface
                  iface.name = sc.name
                  val ref = RossystemFactory.eINSTANCE.createRosServiceClientReference
                  ref.from = sc
                  iface.reference = ref
                  rosNode.rosinterfaces.add(iface)
                  allInterfaces.add(Pair.of(nodePrefix, iface))
                  nodeExposedNames.add(sc.name)
                }
              }
            }

            if (fromNode.actionserver !== null) {
              for (as : fromNode.actionserver) {
                if (as.name !== null && !as.name.empty && existingNames.add(as.name)) {
                  val iface = RossystemFactory.eINSTANCE.createRosInterface
                  iface.name = as.name
                  val ref = RossystemFactory.eINSTANCE.createRosActionServerReference
                  ref.from = as
                  iface.reference = ref
                  rosNode.rosinterfaces.add(iface)
                  allInterfaces.add(Pair.of(nodePrefix, iface))
                  nodeExposedNames.add(as.name)
                }
              }
            }

            if (fromNode.actionclient !== null) {
              for (ac : fromNode.actionclient) {
                if (ac.name !== null && !ac.name.empty && existingNames.add(ac.name)) {
                  val iface = RossystemFactory.eINSTANCE.createRosInterface
                  iface.name = ac.name
                  val ref = RossystemFactory.eINSTANCE.createRosActionClientReference
                  ref.from = ac
                  iface.reference = ref
                  rosNode.rosinterfaces.add(iface)
                  allInterfaces.add(Pair.of(nodePrefix, iface))
                  nodeExposedNames.add(ac.name)
                }
              }
            }
          }
        }

        for (ifaceName : nodeExposedNames) {
          val count = nameCounts.getOrDefault(ifaceName, 0)
          nameCounts.put(ifaceName, count + 1)
        }

      } else if (component instanceof SubSystem) {
        var subSystem = (component as SubSystem).system
        if (subSystem !== null && subSystem.eIsProxy) {
          subSystem = EcoreUtil.resolve(subSystem, rootSystem) as System
        }
        if (subSystem !== null && !subSystem.eIsProxy) {
          val subName = if (subSystem.name !== null) subSystem.name else ""
          val subPrefix = if (prefix.empty) subName else prefix + "." + subName
          collectSystemInterfaces(subSystem, subPrefix, rootSystem, allInterfaces, nameCounts, visitedSystems)
        }
      }
    }
  }
}
