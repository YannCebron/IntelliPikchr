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

import com.intellij.openapi.options.BoundConfigurable
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.DialogPanel
import com.intellij.ui.layout.panel
import com.intellij.ui.layout.toNullableBinding
import com.yanncebron.intellipikchr.IntelliPikchrBundle

class IntelliPikchrSettingsConfigurable(private val project: Project) :
    BoundConfigurable(IntelliPikchrBundle.message("settings.display.name")) {

    private val settings
        get() = IntelliPikchrSettings.getInstance(project)

    override fun createPanel(): DialogPanel {
        return panel {
            titledRow(IntelliPikchrBundle.message("settings.preview.group.name")) {
                row(IntelliPikchrBundle.message("settings.preview.update.delay")) {
                    spinner(settings::updatePreviewDelay, 50, 2000, 50)
                        .comment("Preview is updated automatically after given delay")
                }
                row(IntelliPikchrBundle.message("settings.preview.kroki.server.url")) {
                    cell {
                        val textField = textField(settings::krokiServerUrl.toNullableBinding(DEFAULT_KROKI_URL), 30)
                            .comment(IntelliPikchrBundle.message("settings.preview.kroki.server.url.comment"))
                        button(IntelliPikchrBundle.message("settings.preview.kroki.server.default")) {
                            textField.component.text = DEFAULT_KROKI_URL
                        }

                    }
                }
                row {
                    browserLink(
                        IntelliPikchrBundle.message("settings.preview.server.kroki.install"),
                        "https://docs.kroki.io/kroki/setup/install/"
                    )
                }
            }

            titledRow(IntelliPikchrBundle.message("settings.appearance.group.name")) {
                row {
                    checkBox(
                        IntelliPikchrBundle.message("settings.preview.adapt.dark.color"),
                        settings::previewAdaptDarkColorScheme,
                        IntelliPikchrBundle.message("settings.preview.adapt.dark.color.comment")
                    )
                }
                row(IntelliPikchrBundle.message("settings.preview.custom.css")) {
                    textField(settings::previewCustomCss.toNullableBinding(""))
                        .comment(IntelliPikchrBundle.message("settings.preview.custom.css.comment"))
                }
            }
        }
    }

    companion object {
        const val DEFAULT_KROKI_URL = "https://kroki.io"
    }
}
