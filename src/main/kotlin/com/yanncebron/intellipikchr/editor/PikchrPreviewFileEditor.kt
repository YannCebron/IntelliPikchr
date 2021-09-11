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
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.ui.components.JBLabel
import com.intellij.util.Alarm
import com.intellij.util.ui.UIUtil
import java.awt.BorderLayout
import java.beans.PropertyChangeListener
import javax.swing.JComponent
import javax.swing.JPanel

class PikchrPreviewFileEditor(private val project: Project, file: VirtualFile) : UserDataHolderBase(),
    FileEditor {

    private val virtualFile: VirtualFile
    private val document: Document?

    private val panel: JPanel
    private val previewLabel: JBLabel

    private val pooledAlarm = Alarm(Alarm.ThreadToUse.POOLED_THREAD, this)
    private val swingAlarm = Alarm(Alarm.ThreadToUse.SWING_THREAD, this)

    init {
        virtualFile = file
        document = FileDocumentManager.getInstance().getDocument(virtualFile)

        document?.addDocumentListener(object : DocumentListener {
            override fun beforeDocumentChange(event: DocumentEvent) {
                pooledAlarm.cancelAllRequests()
            }

            override fun documentChanged(event: DocumentEvent) {
                pooledAlarm.addRequest({ updatePreview() }, PREVIEW_UPDATE_DELAY)
            }
        }, this)

        panel = JPanel(BorderLayout())
        previewLabel = JBLabel("Loading preview...", UIUtil.ComponentStyle.REGULAR, UIUtil.FontColor.BRIGHTER)


        panel.add(previewLabel, BorderLayout.CENTER)

        initPreview()
    }

    private fun updatePreview() {
        if (document == null || !virtualFile.isValid || Disposer.isDisposed(this)) {
            return
        }

        swingAlarm.cancelAllRequests()
        swingAlarm.addRequest(
            { previewLabel.text = document.text },
            PREVIEW_UPDATE_DELAY * 2,
            ModalityState.stateForComponent(component)
        )
    }

    private fun initPreview() {
        pooledAlarm.cancelAllRequests()
        pooledAlarm.addRequest({ updatePreview() }, 0)
    }

    override fun selectNotify() {
        initPreview()
    }

    override fun dispose() {
    }

    override fun getComponent(): JComponent {
        return panel
    }

    override fun getPreferredFocusedComponent(): JComponent? {
        return panel
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
        const val PREVIEW_UPDATE_DELAY = 50
    }
}