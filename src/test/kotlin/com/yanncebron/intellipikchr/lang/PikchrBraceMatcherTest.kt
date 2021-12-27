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

package com.yanncebron.intellipikchr.lang

import com.intellij.codeInsight.highlighting.BraceMatchingUtil
import com.intellij.openapi.editor.ex.EditorEx
import com.intellij.testFramework.fixtures.BasePlatformTestCase

class PikchrBraceMatcherTest : BasePlatformTestCase() {

    fun testParentheses() {
        doTest("var=<caret>(1+1)", false)
    }

    fun testAngles() {
        doTest("0.5<caret><previous,B>", false)
    }

    fun testBraces() {
        doTest("define myMacro <caret>{}", true)
    }

    fun testBrackets() {
        doTest("<caret>[box]", true)
    }

    private fun doTest(source: String, structural: Boolean) {
        myFixture.configureByText("a.pikchr", source)
        val editor = myFixture.editor
        val editorHighlighter = (editor as EditorEx).highlighter
        val iterator = editorHighlighter.createIterator(editor.getCaretModel().offset)

        val isMatched = BraceMatchingUtil.matchBrace(
                editor.document.charsSequence,
                myFixture.file.fileType, iterator,
                true)
        assertTrue(source, isMatched)

        val isStructural = BraceMatchingUtil.isStructuralBraceToken(
                myFixture.file.fileType, iterator, myFixture.editor.document.text)
        assertEquals(source, structural, isStructural)
    }

}