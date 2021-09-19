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

package com.yanncebron.intellipikchr.settings

import com.intellij.openapi.components.*
import com.intellij.openapi.project.Project

@State(name = "IntelliPikchrSettings", storages = [Storage(StoragePathMacros.WORKSPACE_FILE)])
class IntelliPikchrSettings(val project: Project) :
    SimplePersistentStateComponent<IntelliPikchrSettingsState>(
        IntelliPikchrSettingsState()
    ) {

    var krokiServerUrl
        get() = state.krokiServerUrl
        set(value) {
            state.krokiServerUrl = value
        }

    var previewAdaptDarkColorScheme
        get() = state.previewAdaptDarkColorScheme
        set(value) {
            state.previewAdaptDarkColorScheme = value
        }

    var updatePreviewDelay
        get() = state.updatePreviewDelay
        set(value) {
            state.updatePreviewDelay = value
        }
    
    var previewCustomCss
        get() = state.previewCustomCss
        set(value) {
            state.previewCustomCss = value
        }

    companion object {
        @JvmStatic
        fun getInstance(project: Project): IntelliPikchrSettings {
            return project.service()
        }
    }
}