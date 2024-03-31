/*
 * Copyright 2024 The Authors
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

package com.yanncebron.intellipikchr.lang.psi

import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.TokenSet
import com.intellij.testFramework.UsefulTestCase
import com.yanncebron.intellipikchr.lang.PikchrLanguage
import junit.framework.TestCase

class PikchrTokenTypesTest : UsefulTestCase() {

    private val groups = arrayOf(
        PikchrTokenGroups.FUNCTION,
        PikchrTokenGroups.KEYWORDS,
        PikchrTokenGroups.DIRECTION,
        PikchrTokenGroups.OPERATION_SIGN,
        PikchrTokenGroups.OBJECT,
        PikchrTokenGroups.ATTRIBUTE,
        PikchrTokenGroups.EDGE_POSITION,
        PikchrTokenGroups.ARROW_HEAD,
        PikchrTokenGroups.DEBUG_STATEMENTS
    )

    private val ignoreTypes = TokenSet.create(
        PikchrTokenTypes.LINE_COMMENT,
        PikchrTokenTypes.BLOCK_COMMENT,
        PikchrTokenTypes.LINEFEED,
        PikchrTokenTypes.BACKSLASH,
        PikchrTokenTypes.LABEL,
        PikchrTokenTypes.VARIABLE,
        PikchrTokenTypes.STRING,
        PikchrTokenTypes.DECIMAL,
        PikchrTokenTypes.FLOAT,
        PikchrTokenTypes.HEX,
        PikchrTokenTypes.ROUND_L, PikchrTokenTypes.ROUND_R,
        PikchrTokenTypes.BRACES_L, PikchrTokenTypes.BRACES_R,
        PikchrTokenTypes.BRACKET_L, PikchrTokenTypes.BRACKET_R,
        PikchrTokenTypes.COMMA,
        PikchrTokenTypes.DOT,
        PikchrTokenTypes.SEMICOLON,
        PikchrTokenTypes.COLON,
        PikchrTokenTypes.PERCENT,
        PikchrTokenTypes.DOLLAR
    )

    fun testAllTokenTypesRegisteredInOneGroup() {
        for (type in IElementType.enumerate { t -> t.language == PikchrLanguage.INSTANCE }) {
            if (ignoreTypes.contains(type)) continue

            var groupMatch = 0
            for (group in groups) {
                if (group.contains(type)) groupMatch++
            }

            TestCase.assertEquals(type.toString(), 1, groupMatch)
        }
    }
}