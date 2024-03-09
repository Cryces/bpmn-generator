// FileHandler.kt
package at.jit.bpmn.generator


import kotlinx.serialization.Serializable

@Serializable
data class File(val name: String, val content: String)

interface IFileHandlerService {
    fun importXML(xml: String)
    fun saveXML()
}