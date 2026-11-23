package de.fraunhofer.ipa.rossystem.generator

import com.google.inject.Inject
import system.RosNode
import system.RosParameter

class YamlFileCompiler_ROS2 {

    @Inject extension GeneratorHelpers

    def compile_toROS2yaml(RosNode component)'''
    «component.name»:
      ros__parameters:
        «FOR param:component.rosparameters»«IF !isSubstitutionValue(param)»
        «param.from.name»: «get_param_value(param.value,param.name)»
        «ENDIF»«ENDFOR»«FOR slotParam:getSlotParameterEntries(component)»
        «slotParam.paramName»: «IF slotParam.array»[«FOR v:slotParam.values SEPARATOR ', '»"«v»"«ENDFOR»]«ELSE»"«slotParam.values.head»"«ENDIF»«ENDFOR»

    '''

}
