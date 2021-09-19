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