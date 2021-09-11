package com.yanncebron.intellipikchr.editor

import com.intellij.openapi.fileEditor.FileEditor
import com.intellij.openapi.fileEditor.TextEditor

class PikchrSplitEditorProvider :
    SplitTextEditorProvider(PikchrTextEditorProvider(), PikchrPreviewFileEditorProvider()) {

    override fun createSplitEditor(firstEditor: FileEditor, secondEditor: FileEditor): FileEditor {
        require(!(firstEditor !is TextEditor || secondEditor !is PikchrPreviewFileEditor)) { "Main editor should be TextEditor" }
        return PikchrEditorWithPreview(firstEditor, secondEditor)
    }
}