// App.kt
package at.jit.bpmn.generator

import at.jit.bpmn.generator.bpmn.ModelerBox
import at.jit.bpmn.generator.model.Model
import at.jit.bpmn.generator.panel.BpmnPanel
import at.jit.bpmn.generator.panel.ChatPanel
import io.kvision.Application
import io.kvision.BootstrapModule
import io.kvision.CoreModule
import io.kvision.FontAwesomeModule
import io.kvision.i18n.DefaultI18nManager
import io.kvision.i18n.I18n
import io.kvision.module
import io.kvision.panel.root
import io.kvision.panel.splitPanel
import io.kvision.require
import io.kvision.startApplication
import io.kvision.utils.perc
import io.kvision.utils.vh
import kotlinx.browser.window
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.launch

val AppScope = CoroutineScope(window.asCoroutineDispatcher())

class App : Application() {
    init {
        require("css/kvapp.css")
        require("css/style.css")
    }

    override fun start() {
        I18n.manager =
            DefaultI18nManager(
                mapOf(
                    "en" to require("i18n/messages-en.json"),
                    "pl" to require("i18n/messages-pl.json"),
                    "de" to require("i18n/messages-de.json"),
                )
            )
        root("kvapp") {
            splitPanel {
                width = 100.perc
                height = 100.vh
                add(ChatPanel)
                add(BpmnPanel)
            }
            add(ModelerBox)
        }
        AppScope.launch {
            Model.getAddressList()
        }
    }
}

fun main() {
    startApplication(::App, module.hot, BootstrapModule, FontAwesomeModule, CoreModule)
}
