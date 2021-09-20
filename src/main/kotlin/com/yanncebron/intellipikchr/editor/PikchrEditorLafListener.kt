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

import com.intellij.ide.ui.LafManager
import com.intellij.openapi.project.ProjectManager
import com.yanncebron.intellipikchr.settings.IntelliPikchrSettings

/**
 * Force refresh of all open preview panels on LaF changes.
 */
class PikchrEditorLafListener : com.intellij.ide.ui.LafManagerListener {

    override fun lookAndFeelChanged(source: LafManager) {
        val projects = ProjectManager.getInstance().openProjects
        for (project in projects) {
            val settings = IntelliPikchrSettings.getInstance(project)
            project.messageBus.syncPublisher(IntelliPikchrSettings.ChangeListener.TOPIC).settingsChanged(settings)
        }
    }
}