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

package com.yanncebron.intellipikchr.lang.highlighting

import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.CodeInsightColors
import com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey

object PikchrTextAttributes {

    @JvmField
    val LINE_COMMENT = createTextAttributesKey("PIKCHR_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT)

    @JvmField
    val BLOCK_COMMENT = createTextAttributesKey("PIKCHR_BLOCK_COMMENT", DefaultLanguageHighlighterColors.BLOCK_COMMENT)

    @JvmField
    val DEBUG = createTextAttributesKey("PIKCHR_DEBUG", CodeInsightColors.RUNTIME_ERROR)


    @JvmField
    val BACKSLASH = createTextAttributesKey("PIKCHR_BACKSLASH", DefaultLanguageHighlighterColors.CONSTANT)

    @JvmField
    val DECIMAL = createTextAttributesKey("PIKCHR_DECIMAL", DefaultLanguageHighlighterColors.NUMBER)

    @JvmField
    val FLOAT = createTextAttributesKey("PIKCHR_FLOAT", DefaultLanguageHighlighterColors.NUMBER)

    @JvmField
    val HEX = createTextAttributesKey("PIKCHR_HEX", DefaultLanguageHighlighterColors.NUMBER)

    @JvmField
    val STRING = createTextAttributesKey("PIKCHR_STRING", DefaultLanguageHighlighterColors.STRING)


    @JvmField
    val PERCENT = createTextAttributesKey("PIKCHR_PERCENT", DefaultLanguageHighlighterColors.OPERATION_SIGN)

    @JvmField
    val COMMA = createTextAttributesKey("PIKCHR_COMMA", DefaultLanguageHighlighterColors.COMMA)

    @JvmField
    val DOT = createTextAttributesKey("PIKCHR_DOT", DefaultLanguageHighlighterColors.DOT)

    @JvmField
    val OPERATION_SIGN = createTextAttributesKey("PIKCHR_OPERATION_SIGN", DefaultLanguageHighlighterColors.OPERATION_SIGN)

    @JvmField
    val PARENTHESES = createTextAttributesKey("PIKCHR_PARENTHESES", DefaultLanguageHighlighterColors.PARENTHESES)

    @JvmField
    val BRACES = createTextAttributesKey("PIKCHR_BRACES", DefaultLanguageHighlighterColors.BRACES)

    @JvmField
    val BRACKETS = createTextAttributesKey("PIKCHR_BRACKETS", DefaultLanguageHighlighterColors.BRACKETS)

    @JvmField
    val SEMICOLON = createTextAttributesKey("PIKCHR_SEMICOLON", DefaultLanguageHighlighterColors.SEMICOLON)

    @JvmField
    val DOLLAR = createTextAttributesKey("PIKCHR_DOLLAR", DefaultLanguageHighlighterColors.GLOBAL_VARIABLE)


    @JvmField
    val LABEL = createTextAttributesKey("PIKCHR_LABEL", DefaultLanguageHighlighterColors.LABEL)

    @JvmField
    val VARIABLE = createTextAttributesKey("PIKCHR_VARIABLE", DefaultLanguageHighlighterColors.LOCAL_VARIABLE)

    @JvmField
    val KEYWORD = createTextAttributesKey("PIKCHR_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD)


    @JvmField
    val OBJECT = createTextAttributesKey("PIKCHR_OBJECT", DefaultLanguageHighlighterColors.CONSTANT)

    @JvmField
    val ATTRIBUTE = createTextAttributesKey("PIKCHR_ATTRIBUTE", DefaultLanguageHighlighterColors.MARKUP_ENTITY)

    @JvmField
    val DIRECTION = createTextAttributesKey("PIKCHR_DIRECTION", DefaultLanguageHighlighterColors.METADATA)

    @JvmField
    val ARROW_HEAD = createTextAttributesKey("PIKCHR_ARROW_HEAD", DefaultLanguageHighlighterColors.STATIC_METHOD)

    @JvmField
    val EDGE_POSITION = createTextAttributesKey("PIKCHR_EDGE_POSITION", DefaultLanguageHighlighterColors.PREDEFINED_SYMBOL)

    @JvmField
    val FUNCTION = createTextAttributesKey("PIKCHR_FUNCTION", DefaultLanguageHighlighterColors.FUNCTION_CALL)

}