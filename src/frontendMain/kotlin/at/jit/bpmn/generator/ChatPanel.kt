package at.jit.bpmn.generator

import io.kvision.core.CssSize
import io.kvision.core.Overflow
import io.kvision.core.UNIT
import io.kvision.form.text.TextInput
import io.kvision.form.text.text
import io.kvision.html.Div
import io.kvision.html.div
import io.kvision.panel.SimplePanel
import io.kvision.utils.px
import kotlinx.browser.document
import org.w3c.dom.Element

object ChatPanel : SimplePanel() {

    private val chatDisplay = Div().apply {
        id = "chat-display"
        overflow = Overflow.AUTO
    }

    private val chatInput = text {
        height = 30.px
        padding = 0.px
        margin = 0.px
        id = "chat-input"
        placeholder = "Type your message and press Enter"
        setEventListener<TextInput> {
            keydown = { e ->
                if (e.asDynamic().key == "Enter") {
                    val message = self.value
                    self.value = ""
                    chatDisplay.add(div {
                        +(message ?: "ERRRRRRRRRRRRROR")
                    })
                    // Scroll chatDisplay to the bottom
                    document.getElementById("chat-display")?.scrollTop =
                        document.getElementById("chat-display")?.scrollHeight?.toDouble() ?: 0.0
                }
            }
        }
    }

    init {
        id = "chat-panel"
        padding = 5.px
        height = CssSize(100, UNIT.perc) // takes 100% of its parent's height
        minWidth = 300.px
        add(chatDisplay)
        add(chatInput)
        // TODO: add code to handle incoming messages and update chatDisplay
    }
}
