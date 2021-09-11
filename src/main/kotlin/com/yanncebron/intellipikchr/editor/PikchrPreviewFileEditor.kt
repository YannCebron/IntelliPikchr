package com.yanncebron.intellipikchr.editor

import com.intellij.openapi.application.ModalityState
import com.intellij.openapi.editor.Document
import com.intellij.openapi.editor.event.DocumentEvent
import com.intellij.openapi.editor.event.DocumentListener
import com.intellij.openapi.fileEditor.FileDocumentManager
import com.intellij.openapi.fileEditor.FileEditor
import com.intellij.openapi.fileEditor.FileEditorLocation
import com.intellij.openapi.fileEditor.FileEditorState
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.Disposer
import com.intellij.openapi.util.UserDataHolderBase
import com.intellij.openapi.util.text.StringUtil
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.ui.jcef.JCEFHtmlPanel
import com.intellij.util.Alarm
import java.awt.BorderLayout
import java.awt.event.ComponentAdapter
import java.awt.event.ComponentEvent
import java.beans.PropertyChangeListener
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.util.*
import java.util.zip.Deflater
import javax.swing.JComponent
import javax.swing.JPanel


class PikchrPreviewFileEditor(project: Project, private val virtualFile: VirtualFile) : UserDataHolderBase(),
    FileEditor {

    private val document: Document? = FileDocumentManager.getInstance().getDocument(virtualFile)

    private val panel: JPanel;
    private var jcefPanel: JCEFHtmlPanel? = null

    private val docAlarm = Alarm(Alarm.ThreadToUse.POOLED_THREAD, this)
    private val previewAlarm = Alarm(Alarm.ThreadToUse.SWING_THREAD, this)

    init {
        document?.addDocumentListener(object : DocumentListener {
            override fun beforeDocumentChange(event: DocumentEvent) {
                docAlarm.cancelAllRequests()
            }

            override fun documentChanged(event: DocumentEvent) {
                docAlarm.addRequest({ updatePreview() }, TYPING_UPDATE_DELAY)
            }
        }, this)

        panel = JPanel(BorderLayout())
        panel.addComponentListener(object : ComponentAdapter() {
            override fun componentShown(e: ComponentEvent?) {
                previewAlarm.addRequest({
                    if (jcefPanel == null) {
                        attachPreview()
                    }
                }, 0, ModalityState.stateForComponent(component))
            }

            override fun componentHidden(e: ComponentEvent?) {
                previewAlarm.addRequest({
                    if (jcefPanel != null) {
                        detachPreview()
                    }
                }, 0, ModalityState.stateForComponent(component))
            }
        })

        attachPreview()
    }

    private fun attachPreview() {
        jcefPanel = JCEFHtmlPanel("")
        jcefPanel!!.cefBrowser.createImmediately() // todo makes it _a bit_ more reliable to show up on editor load
        jcefPanel!!.setHtml("<em>Initializing preview...</em>")
        panel.add(jcefPanel!!.component, BorderLayout.CENTER)
        initPreview()
    }

    private fun detachPreview() {
        if (jcefPanel != null) {
            panel.remove(jcefPanel!!.component)
            Disposer.dispose(jcefPanel!!)
            jcefPanel = null
        }
    }

    private fun updatePreview() {
        if (jcefPanel == null || document == null || !virtualFile.isValid || Disposer.isDisposed(this)) {
            return
        }

        previewAlarm.cancelAllRequests()
        val runnable = Runnable {
            if (jcefPanel == null) return@Runnable

            val encodedDiagram = encode(
                document.text
                        + StringUtil.repeat(" ", 100) // todo fails for "too short input"
            )
//                println(encodedDiagram)

            jcefPanel!!.cefBrowser.loadURL("https://kroki.io/pikchr/svg/$encodedDiagram")
        }
        previewAlarm.addRequest(
            runnable,
            PREVIEW_UPDATE_DELAY, ModalityState.stateForComponent(component)
        )
    }

    private fun initPreview() {
        docAlarm.cancelAllRequests()
        docAlarm.addRequest({ updatePreview() }, 0)
    }

    override fun selectNotify() {
        if (jcefPanel != null) {
            initPreview()
        }
    }

    override fun dispose() {
        if (jcefPanel != null) {
            Disposer.dispose(jcefPanel!!)
        }
    }

    override fun getComponent(): JComponent {
        return panel
    }

    override fun getPreferredFocusedComponent(): JComponent? {
        return if (jcefPanel != null) jcefPanel!!.component else null
    }

    override fun getName(): String {
        return "Pikchr Preview File Editor"
    }

    override fun setState(state: FileEditorState) = Unit

    override fun isModified(): Boolean = false

    override fun isValid(): Boolean = true

    override fun addPropertyChangeListener(listener: PropertyChangeListener) = Unit

    override fun removePropertyChangeListener(listener: PropertyChangeListener) = Unit

    override fun getCurrentLocation(): FileEditorLocation? = null

    companion object {
        const val TYPING_UPDATE_DELAY = 100
        const val PREVIEW_UPDATE_DELAY = 20

        @Throws(IOException::class)
        private fun encode(decoded: String): String {
            return String(Base64.getUrlEncoder().encode(compress(decoded.toByteArray(Charsets.UTF_8))), Charsets.UTF_8)
        }

        @Throws(IOException::class)
        private fun compress(source: ByteArray): ByteArray? {
            val result = ByteArray(2048)
            val deflater = Deflater(Deflater.BEST_COMPRESSION)
            deflater.setInput(source, 0, source.size)
            deflater.finish()
            val compressedLength = deflater.deflate(result, 0, source.size, Deflater.FULL_FLUSH)
            deflater.end()
            ByteArrayOutputStream().use { byteArrayOutputStream ->
                byteArrayOutputStream.write(result, 0, compressedLength)
                return byteArrayOutputStream.toByteArray()
            }
        }

    }
}