// FileHandlerService.kt
package at.jit.bpmn.generator.service

import at.jit.bpmn.generator.File
import at.jit.bpmn.generator.IFileHandlerService
import at.jit.bpmn.generator.bpmn.modeler
import at.jit.bpmn.generator.state.bpmnState

object FileHandlerService : IFileHandlerService {

    override fun importXML(xml: String) {
        modeler.importXML(xml, null)
            .then { warnings: dynamic ->
                console.log("BPMN import warnings:", warnings)
                bpmnState.value = xml
                console.log("BPMN XML imported")
                undefined
            }
            .catch { error ->
                console.error("Error importing BPMN XML:", error)
            }
    }

    override fun saveXML() {
        modeler.saveXML(js("{ format: true }")).then { result: dynamic ->
            val xml: String = result.xml as String
//            console.log("Saved XML", xml)
            bpmnState.value = xml
            console.log("BPMN XML saved")
            undefined
        }.catch { err: dynamic ->
            console.error("Error saving XML", err)
        }
    }
}

