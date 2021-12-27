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

class PikchrVariableLexerTest : PikchrLexerTestCase() {

    fun testAssignment() {
        doTest("var=42", """
            variable ('var')
            = ('=')
            decimal ('42')
        """.trimIndent())
    }

    fun testAssignmentDollarPrefix() {
        doTest("${'$'}var=42", """
            variable ('${'$'}var')
            = ('=')
            decimal ('42')
        """.trimIndent())
    }

    fun testAssignmentAtSignPrefix() {
        doTest("@var=42", """
            variable ('@var')
            = ('=')
            decimal ('42')
        """.trimIndent())
    }

    fun testAssignmentSingleLetterName() {
        doTest("v=42", """
            variable ('v')
            = ('=')
            decimal ('42')
        """.trimIndent())
    }

    fun testPlusEqualAssignment() {
        doTest("var+=42", """
            variable ('var')
            += ('+=')
            decimal ('42')            
        """.trimIndent())
    }

    fun testMinusEqualAssignment() {
        doTest("var-=42", """
            variable ('var')
            -= ('-=')
            decimal ('42')            
        """.trimIndent())
    }

    fun testMulEqualAssignment() {
        doTest("var*=42", """
            variable ('var')
            *= ('*=')
            decimal ('42')            
        """.trimIndent())
    }

    fun testDivEqualAssignment() {
        doTest("var/=42", """
            variable ('var')
            /= ('/=')
            decimal ('42')            
        """.trimIndent())
    }

    fun testDefine() {
        doTest("define myMacro {}", """
            define ('define')
            WHITE_SPACE (' ')
            variable ('myMacro')
            WHITE_SPACE (' ')
            { ('{')
            } ('}')            
        """.trimIndent())
    }

}