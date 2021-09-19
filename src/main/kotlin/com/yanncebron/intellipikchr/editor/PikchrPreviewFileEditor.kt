/*
 * Copyright 2021 The Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.yanncebron.intellipikchr.editor

import com.intellij.openapi.application.ModalityState
import com.intellij.openapi.editor.Document
import com.intellij.openapi.editor.colors.EditorColorsManager
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
import com.intellij.ui.ColorUtil
import com.intellij.ui.jcef.JCEFHtmlPanel
import com.intellij.util.Alarm
import com.intellij.util.io.HttpRequests
import com.yanncebron.intellipikchr.IntelliPikchrBundle
import com.yanncebron.intellipikchr.settings.IntelliPikchrSettings
import java.awt.BorderLayout
import java.awt.event.ComponentAdapter
import java.awt.event.ComponentEvent
import java.beans.PropertyChangeListener
import java.io.IOException
import java.net.HttpURLConnection
import javax.swing.JComponent
import javax.swing.JPanel


class PikchrPreviewFileEditor(project: Project, private val virtualFile: VirtualFile) : UserDataHolderBase(),
    FileEditor {

    private val settings = IntelliPikchrSettings.getInstance(project)

    private val document: Document? = FileDocumentManager.getInstance().getDocument(virtualFile)

    private val panel: JPanel;
    private var jcefPanel: JCEFHtmlPanel? = null

    private val docAlarm = Alarm(Alarm.ThreadToUse.POOLED_THREAD, this)
    private val swingAlarm = Alarm(Alarm.ThreadToUse.SWING_THREAD, this)
    private val previewAlarm = Alarm(Alarm.ThreadToUse.POOLED_THREAD, this)

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
                swingAlarm.addRequest({
                    if (jcefPanel == null) {
                        attachPreview()
                    }
                }, 0, ModalityState.stateForComponent(component))
            }

            override fun componentHidden(e: ComponentEvent?) {
                swingAlarm.addRequest({
                    if (jcefPanel != null) {
                        detachPreview()
                    }
                }, 0, ModalityState.stateForComponent(component))
            }
        })

        attachPreview()

        project.messageBus.connect(this)
            .subscribe(IntelliPikchrSettings.ChangeListener.TOPIC, object : IntelliPikchrSettings.ChangeListener {
                override fun settingsChanged(settings: IntelliPikchrSettings) {
                    initPreview()
                }
            })
    }

    private fun attachPreview() {
        jcefPanel = JCEFHtmlPanel("")
        jcefPanel!!.setHtml("<em>" + IntelliPikchrBundle.message("preview.initializing") + "</em>")
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

            if (StringUtil.isEmptyOrSpaces(document.text)) {
                jcefPanel!!.setHtml(getCustomCss(true))
                return@Runnable
            }

            val server = settings.krokiServerUrl + "/pikchr/svg"

            HttpRequests.post(server, "text/plain")
                .throwStatusCodeException(false) // avoid logging all failing previews
                .connect {

                    try {
                        it.write(document.text)

                        val response = it.readString()

                        jcefPanel!!.setHtml(getCustomCss(false) + response)
                    } catch (e: IOException) {
                        // show kroki error message if available
                        val errorResponse =
                            (it.connection as HttpURLConnection).errorStream?.readAllBytes()?.toString(Charsets.UTF_8)
                        if (errorResponse != null) {
                            jcefPanel!!.setHtml(getCustomCss(true) + errorResponse)
                        } else {
                            val message = HttpRequests.createErrorMessage(e, it, false)
                            jcefPanel!!.setHtml(
                                getCustomCss(true) +
                                        "<div style='color:red; font-weight:bold;'>" +
                                        IntelliPikchrBundle.message("preview.failed") +
                                        "<br><br>$message</div>"
                            )
                        }
                    }
                }
        }
        previewAlarm.addRequest(runnable, settings.updatePreviewDelay)
    }

    private fun getCustomCss(isErrorPage: Boolean): String {
        val colorsManager = EditorColorsManager.getInstance()
        val bgColor = ColorUtil.toHtmlColor(colorsManager.schemeForCurrentUITheme.defaultBackground)
        val isDark = colorsManager.isDarkEditor
        val darkCss = if (!isErrorPage && isDark && settings.previewAdaptDarkColorScheme)
            "filter: invert(1) hue-rotate(180deg);" else ""

        return "<style>" +
                "body { " +
                "background-color: $bgColor; " +
                settings.previewCustomCss +
                darkCss +
                "}" +
                "</style>"
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
        return IntelliPikchrBundle.message("preview.editor.name")
    }

    override fun setState(state: FileEditorState) = Unit

    override fun isModified(): Boolean = false

    override fun isValid(): Boolean = true

    override fun addPropertyChangeListener(listener: PropertyChangeListener) = Unit

    override fun removePropertyChangeListener(listener: PropertyChangeListener) = Unit

    override fun getCurrentLocation(): FileEditorLocation? = null

    companion object {
        const val TYPING_UPDATE_DELAY = 100
    }
}