// ModelerBox.kt
package at.jit.bpmn.generator.bpmn

import at.jit.bpmn.generator.service.BpmnJSModelerModule
import at.jit.bpmn.generator.service.FileHandlerService.importXML
import at.jit.bpmn.generator.service.bpmnXML
import io.kvision.html.Div
import io.kvision.utils.px

var modeler: dynamic = null

object ModelerBox : Div() {

    init {
        height = 0.px
        width = 0.px
        id = "modelerBox"

        val BpmnJS = BpmnJSModelerModule.default
        val bpmnModelerOptions = js(
            """
                {
                    container: document.getElementById('modelerBox'),
                    width: '100%',
                    height: '100%',
                    position: 'relative',
                    moddleExtensions: {}
                }
                """
        )
        modeler = js("new BpmnJS(bpmnModelerOptions)")

        importXML(bpmnXML)
    }
}