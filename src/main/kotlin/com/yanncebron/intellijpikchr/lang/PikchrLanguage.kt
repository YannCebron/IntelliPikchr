package com.yanncebron.intellijpikchr.lang

import com.intellij.lang.Language
import com.intellij.openapi.fileTypes.LanguageFileType
import com.yanncebron.intellijpikchr.PikchrFileType

class PikchrLanguage private constructor() : Language("Pikchr") {

    override fun getAssociatedFileType(): LanguageFileType {
        return PikchrFileType.INSTANCE
    }

    companion object {
        val INSTANCE = PikchrLanguage()
    }
}