package com.yanncebron.intellijpikchr.editor

import com.intellij.openapi.fileEditor.TextEditor
import com.intellij.openapi.fileEditor.TextEditorWithPreview

class PikchrEditorWithPreview(editor: TextEditor, preview: PikchrPreviewFileEditor) :
    TextEditorWithPreview(editor, preview, "Pikchr Split Editor", Layout.SHOW_EDITOR_AND_PREVIEW)