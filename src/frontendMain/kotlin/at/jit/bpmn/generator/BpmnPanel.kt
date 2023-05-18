package at.jit.bpmn.generator

import bpmnXML
import io.kvision.core.Overflow
import io.kvision.html.Div
import io.kvision.panel.SimplePanel
import io.kvision.snabbdom.VNode
import io.kvision.utils.pc
import org.w3c.dom.events.Event

@JsModule("bpmn-js")
@JsNonModule
external val BpmnJSModule: dynamic

object BpmnPanel : SimplePanel() {

    private val canvas = Div().apply {
        id = "canvas"
        height = 100.pc
        overflow = Overflow.AUTO
    }

    init {
        id = "bpmn-panel"
        add(canvas)
    }

    override fun afterInsert(node: VNode) {
        super.afterInsert(node)

        val BpmnJS = BpmnJSModule.default
        val bpmnViewerOptions = js(
            """
                {
                    container: document.getElementById('canvas'),
                    width: '100%',
                    height: '100%',
                    position: 'relative',
                    moddleExtensions: {}
                }
                """
        )
        val bpmnViewer = js("new BpmnJS(bpmnViewerOptions)")

        bpmnViewer.on("import.done") { eventData: Event ->
            if (!(eventData.asDynamic().error as Boolean)) {
                // Perform additional operations or adjustments after rendering
                bpmnViewer.get("canvas").zoom("fit-viewport")
                console.log("BPMN import done")
            }
        }
        bpmnViewer.on("import.parse.start") {
            console.log("BPMN XML parsing started")
            undefined
        }
        bpmnViewer.on("import.parse.complete") { eventData: Event ->
            if (eventData.asDynamic().error) {
                console.error("Error parsing BPMN XML:", eventData.asDynamic().error)
            } else {
                console.log("BPMN XML parsing complete")
            }
            eventData.asDynamic().definitions
        }
        bpmnViewer.on("import.render.start") {
            console.log("BPMN rendering started")
        }
        bpmnViewer.on("import.render.complete") {
            console.log("BPMN rendering complete")
        }

        bpmnViewer.importXML(bpmnXML, null)
            .then { warnings: dynamic ->
                // Handle warnings if needed
                console.log("BPMN import warnings:", warnings)

            }
            .catch { error ->
                console.error("Error importing BPMN XML:", error)
            }
    }
}
