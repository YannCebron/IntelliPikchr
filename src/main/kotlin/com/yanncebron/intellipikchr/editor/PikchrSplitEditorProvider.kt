/*
 * Copyright 2023 The Authors
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

import com.intellij.openapi.fileEditor.FileEditor
import com.intellij.openapi.fileEditor.TextEditor

internal class PikchrSplitEditorProvider :
    SplitTextEditorProvider(PikchrTextEditorProvider(), PikchrPreviewFileEditorProvider()) {

    override fun createSplitEditor(firstEditor: FileEditor, secondEditor: FileEditor): FileEditor {
        require(!(firstEditor !is TextEditor || secondEditor !is PikchrPreviewFileEditor)) { "Main editor should be TextEditor" }
        return PikchrEditorWithPreview(firstEditor, secondEditor)
    }
}