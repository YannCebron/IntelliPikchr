package com.yanncebron.intellipikchr.editor

import com.intellij.ide.scratch.ScratchUtil
import com.intellij.lang.LanguageUtil
import com.intellij.openapi.fileEditor.impl.text.PsiAwareTextEditorProvider
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.yanncebron.intellipikchr.PikchrFileType
import com.yanncebron.intellipikchr.lang.PikchrLanguage

class PikchrTextEditorProvider : PsiAwareTextEditorProvider() {

    override fun accept(project: Project, file: VirtualFile): Boolean {
        if (!super.accept(project, file)) {
            return false
        }
        return file.fileType == PikchrFileType.INSTANCE || shouldAcceptScratchFile(project, file)
    }

    private fun shouldAcceptScratchFile(project: Project, file: VirtualFile): Boolean {
        return ScratchUtil.isScratch(file) && LanguageUtil.getLanguageForPsi(project, file) == PikchrLanguage.INSTANCE
    }

}