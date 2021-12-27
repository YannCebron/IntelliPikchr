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

import com.intellij.lexer.Lexer
import com.intellij.testFramework.LexerTestCase
import com.yanncebron.intellipikchr.lang.lexer.PikchrLexer

abstract class PikchrLexerTestCase : LexerTestCase() {

    override fun doTest(text: String?, expected: String?) {
        super.doTest(text, expected)
        checkCorrectRestart(text)
    }

    override fun createLexer(): Lexer = PikchrLexer()

    override fun getDirPath(): String = ""
}