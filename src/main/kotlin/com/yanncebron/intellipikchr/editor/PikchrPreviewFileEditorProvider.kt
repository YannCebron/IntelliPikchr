package com.yanncebron.intellipikchr.editor

import com.intellij.ide.scratch.ScratchUtil
import com.intellij.lang.LanguageUtil
import com.intellij.openapi.fileEditor.FileEditor
import com.intellij.openapi.fileEditor.FileEditorPolicy
import com.intellij.openapi.fileEditor.WeighedFileEditorProvider
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.yanncebron.intellipikchr.PikchrFileType
import com.yanncebron.intellipikchr.lang.PikchrLanguage

class PikchrPreviewFileEditorProvider : WeighedFileEditorProvider() {

    override fun accept(project: Project, file: VirtualFile): Boolean {
        return file.fileType == PikchrFileType.INSTANCE || shouldAcceptScratchFile(project, file)
    }

    private fun shouldAcceptScratchFile(project: Project, file: VirtualFile): Boolean {
        return ScratchUtil.isScratch(file) && LanguageUtil.getLanguageForPsi(project, file) == PikchrLanguage.INSTANCE
    }

    override fun createEditor(project: Project, file: VirtualFile): FileEditor {
        return PikchrPreviewFileEditor(project, file)
    }

    override fun getEditorTypeId(): String = "pikchr-preview-editor"

    override fun getPolicy(): FileEditorPolicy = FileEditorPolicy.PLACE_AFTER_DEFAULT_EDITOR
}