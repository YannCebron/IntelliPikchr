/*
 * Copyright 2024 The Authors
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
import com.intellij.openapi.util.text.StringUtil
import com.intellij.ui.dsl.builder.*
import com.intellij.ui.dsl.gridLayout.HorizontalAlign
import com.intellij.ui.layout.enteredTextSatisfies
import com.yanncebron.intellipikchr.IntelliPikchrBundle

private const val DEFAULT_KROKI_URL = "https://kroki.io"

internal class IntelliPikchrSettingsConfigurable(private val project: Project) :
    BoundConfigurable(IntelliPikchrBundle.message("settings.display.name")) {

    private val settings
        get() = IntelliPikchrSettings.getInstance(project)

    override fun createPanel(): DialogPanel {
        return panel {
            group(IntelliPikchrBundle.message("settings.preview.group.name")) {
                row(IntelliPikchrBundle.message("settings.preview.update.delay")) {
                    spinner(50..2000, 50)
                        .bindIntValue(settings::updatePreviewDelay)
                        .comment("Preview is updated automatically after given delay")
                }
                row(IntelliPikchrBundle.message("settings.preview.kroki.server.url")) {
                    val textField = textField()
                        .bindText(
                            { settings::krokiServerUrl.get().orEmpty() },
                            { s -> settings.krokiServerUrl = StringUtil.defaultIfEmpty(s, DEFAULT_KROKI_URL) })
                        .columns(COLUMNS_MEDIUM)
                        .comment(IntelliPikchrBundle.message("settings.preview.kroki.server.url.comment"))
                    button(IntelliPikchrBundle.message("settings.preview.kroki.server.default")) {
                        textField.component.text = DEFAULT_KROKI_URL
                    }.enabledIf(textField.component.enteredTextSatisfies { it != DEFAULT_KROKI_URL })
                }
                row {
                    browserLink(
                        IntelliPikchrBundle.message("settings.preview.server.kroki.install"),
                        "https://docs.kroki.io/kroki/setup/install/"
                    )
                }
            }

            group(IntelliPikchrBundle.message("settings.appearance.group.name")) {
                row {
                    checkBox(
                        IntelliPikchrBundle.message("settings.preview.adapt.dark.color"),
                    ).bindSelected(settings::previewAdaptDarkColorScheme)
                        .comment(IntelliPikchrBundle.message("settings.preview.adapt.dark.color.comment"))
                }
                row(IntelliPikchrBundle.message("settings.preview.custom.css")) {
                    textField()
                        .bindText(
                            { settings::previewCustomCss.get().orEmpty() },
                            { s -> settings.previewCustomCss = s })
                        .horizontalAlign(HorizontalAlign.FILL)
                        .comment(IntelliPikchrBundle.message("settings.preview.custom.css.comment"))
                }
            }
        }
    }

    override fun apply() {
        settings.update {
            super.apply()
        }
    }

}
