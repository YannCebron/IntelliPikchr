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

package com.yanncebron.intellipikchr.lang

import com.intellij.codeInsight.template.TemplateActionContext
import com.intellij.codeInsight.template.TemplateContextType
import com.yanncebron.intellipikchr.IntelliPikchrBundle
import com.yanncebron.intellipikchr.PikchrFileType

internal class PikchrTemplateContextType : TemplateContextType(PikchrLanguage.INSTANCE.id, IntelliPikchrBundle.message("pikchr.filetype.description")) {

    override fun isInContext(templateActionContext: TemplateActionContext): Boolean {
        return templateActionContext.file.originalFile.virtualFile.fileType == PikchrFileType.INSTANCE
    }
}