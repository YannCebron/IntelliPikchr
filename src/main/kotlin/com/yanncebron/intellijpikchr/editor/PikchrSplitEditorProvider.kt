package com.yanncebron.intellijpikchr.editor

import com.intellij.openapi.fileEditor.FileEditor
import com.intellij.openapi.fileEditor.TextEditor
import com.yanncebron.intellipikchr.editor.SplitTextEditorProvider

class PikchrSplitEditorProvider :
    SplitTextEditorProvider(PikchrTextEditorProvider(), PikchrPreviewFileEditorProvider()) {

    override fun createSplitEditor(firstEditor: FileEditor, secondEditor: FileEditor): FileEditor {
        require(!(firstEditor !is TextEditor || secondEditor !is PikchrPreviewFileEditor)) { "Main editor should be TextEditor" }
        return PikchrEditorWithPreview(firstEditor, secondEditor)
    }
}