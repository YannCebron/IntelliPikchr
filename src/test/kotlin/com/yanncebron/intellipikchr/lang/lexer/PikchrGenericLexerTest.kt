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

class PikchrGenericLexerTest : PikchrLexerTestCase() {

    fun testEmptyFile() {
        doTest("", "")
    }

    fun testBadCharacter() {
        doTest("ø", """
            BAD_CHARACTER ('ø')     
        """.trimIndent())
    }

    fun testBackslash() {
        doTest("\\", """
            \ ('\')
        """.trimIndent())
    }

    fun testAssertStatement() {
        doTest("assert(1==1)", """
            assert ('assert')
            ( ('(')
            decimal ('1')
            == ('==')
            decimal ('1')
            ) (')')            
        """.trimIndent())
    }

    fun testPrintStatement() {
        doTest("print \"output\"", """
            print ('print')
            WHITE_SPACE (' ')
            string ('"output"')            
        """.trimIndent())
    }

    fun testDefineWithParameters() {
        doTest("define xyz {box ${'$'}1 ${'$'}2}", """
            define ('define')
            WHITE_SPACE (' ')
            variable ('xyz')
            WHITE_SPACE (' ')
            { ('{')
            box ('box')
            WHITE_SPACE (' ')
            ${'$'} ('${'$'}')
            decimal ('1')
            WHITE_SPACE (' ')
            ${'$'} ('${'$'}')
            decimal ('2')
            } ('}')            
        """.trimIndent())
    }
}