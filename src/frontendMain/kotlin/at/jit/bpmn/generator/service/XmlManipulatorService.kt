//XmlManipulatorService.kt
package at.jit.bpmn.generator.service

import at.jit.bpmn.generator.IXmlManipulatorService
import at.jit.bpmn.generator.bpmn.modeler
import at.jit.bpmn.generator.service.FileHandlerService.saveXML

object XmlManipulatorService : IXmlManipulatorService {
    override fun addServiceTask() {
        console.log("add service")
        val modeling = modeler.get("modeling")
        val rootElement = modeler.get("canvas").getRootElement()
        val serviceTask = modeler.get("elementFactory").createShape(
            js(
                """
                {
                    type: 'bpmn:ServiceTask',
                    x: 100,
                    y: 100,
                    width: 80,
                    height: 80
                }
                """
            )
        )

        modeling.createShape(serviceTask, js("{ x: 100, y: 100 }"), rootElement)
        saveXML()
    }

    override fun addEndEvent() {
        console.log("add endEvent")
        val modeling = modeler.get("modeling")
        val rootElement = modeler.get("canvas").getRootElement()
        val endEvent = modeler.get("elementFactory").createShape(
            js(
                """
                {
                    type: 'bpmn:EndEvent',
                    x: 200,
                    y: 200,
                    width: 36,
                    height: 36
                }
                """
            )
        )

        modeling.createShape(endEvent, js("{ x: 200, y: 200 }"), rootElement)
        saveXML()
    }
}
