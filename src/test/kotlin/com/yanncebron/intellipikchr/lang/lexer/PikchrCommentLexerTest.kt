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

class PikchrCommentLexerTest : PikchrLexerTestCase() {

    fun testCommentHash() {
        doTest("# comment", """
            comment ('# comment')
        """.trimIndent())
    }

    fun testEOLCommentHash() {
        doTest("down # EOL Comment", """
            down ('down')
            WHITE_SPACE (' ')
            comment ('# EOL Comment')
        """.trimIndent())
    }

    fun testCommentSlashSlash() {
        doTest("// comment", """
            comment ('// comment')
        """.trimIndent())
    }

    fun testEOLCommentSlashSlash() {
        doTest("down // comment", """
            down ('down')
            WHITE_SPACE (' ')
            comment ('// comment')
        """.trimIndent())
    }

    fun testBlockComment() {
        doTest("/* block comment */", """
            block_comment ('/* block comment */')   
        """.trimIndent())
    }

    fun testBlockCommentBeforeStatement() {
        doTest("""
            /* block comment */
            print
            """.trimIndent(), """
            block_comment ('/* block comment */')
            CR_LF ('\n')
            print ('print')
        """.trimIndent())
    }

    fun testBlockCommentInline() {
        doTest("print /* block comment */ \"output\"", """
            print ('print')
            WHITE_SPACE (' ')
            block_comment ('/* block comment */')
            WHITE_SPACE (' ')
            string ('"output"')            
        """.trimIndent())
    }

    fun testBlockCommentMultiLineBeforeStatement() {
        doTest("""
            /* block 
               comment
            */
            print
            """.trimIndent(), """
            block_comment ('/* block \n   comment\n*/')
            CR_LF ('\n')
            print ('print')                
            """.trimIndent())
    }

}