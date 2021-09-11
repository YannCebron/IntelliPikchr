package com.github.yanncebron.intellipikchr.services

import com.intellij.openapi.project.Project
import com.github.yanncebron.intellipikchr.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
