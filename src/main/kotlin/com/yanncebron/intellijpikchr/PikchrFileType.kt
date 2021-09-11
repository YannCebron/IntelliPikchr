package com.yanncebron.intellijpikchr

import com.intellij.icons.AllIcons
import com.intellij.openapi.fileTypes.LanguageFileType
import com.yanncebron.intellijpikchr.lang.PikchrLanguage
import javax.swing.Icon

class PikchrFileType : LanguageFileType(PikchrLanguage.INSTANCE) {

    companion object {
        val INSTANCE = PikchrFileType()
    }

    override fun getName(): String = "Pikchr"

    override fun getDescription(): String = IntelliPikchrBundle.message("pikchr.filetype.description")

    override fun getDefaultExtension(): String = "pikchr"

    override fun getIcon(): Icon = AllIcons.FileTypes.Diagram
}