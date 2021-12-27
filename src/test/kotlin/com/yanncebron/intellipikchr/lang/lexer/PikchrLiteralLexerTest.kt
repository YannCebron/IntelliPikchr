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

package com.yanncebron.intellipikchr.lang.lexer

class PikchrLiteralLexerTest : PikchrLexerTestCase() {

    fun testString() {
        doTest("\"string\"", """
            string ('"string"')            
        """.trimIndent())
    }

    fun testStringEscapes() {
        doTest("\"Testing \\\\backslash\\\\ support\" \"Also \\\"autofit\\\"\"","""
            string ('"Testing \\backslash\\ support"')
            WHITE_SPACE (' ')
            string ('"Also \"autofit\""')            
        """.trimIndent())
    }

    fun testDecimal() {
        doTest("42", """
            decimal ('42')
        """.trimIndent())
    }

    fun testFloat() {
        doTest("123.45", """
            float ('123.45')
        """.trimIndent())
    }

    fun testHex() {
        doTest("0x8AbC", """
            hex ('0x8AbC')
        """.trimIndent())
    }
}