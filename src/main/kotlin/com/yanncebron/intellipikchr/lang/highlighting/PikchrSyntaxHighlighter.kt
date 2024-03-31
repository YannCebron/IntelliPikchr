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

package com.yanncebron.intellipikchr.lang.highlighting

import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.HighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType
import com.yanncebron.intellipikchr.lang.lexer.PikchrLexer
import com.yanncebron.intellipikchr.lang.psi.PikchrTokenGroups
import com.yanncebron.intellipikchr.lang.psi.PikchrTokenTypes

class PikchrSyntaxHighlighter : SyntaxHighlighterBase() {

    override fun getHighlightingLexer(): Lexer {
        return PikchrLexer()
    }

    override fun getTokenHighlights(tokenType: IElementType?): Array<TextAttributesKey> {
        return when (tokenType) {
            PikchrTokenTypes.LINE_COMMENT -> pack(PikchrTextAttributes.LINE_COMMENT)
            PikchrTokenTypes.BLOCK_COMMENT -> pack(PikchrTextAttributes.BLOCK_COMMENT)

            PikchrTokenTypes.BACKSLASH -> pack(PikchrTextAttributes.BACKSLASH)

            PikchrTokenTypes.LABEL -> pack(PikchrTextAttributes.LABEL)
            PikchrTokenTypes.VARIABLE -> pack(PikchrTextAttributes.VARIABLE)

            PikchrTokenTypes.DECIMAL -> pack(PikchrTextAttributes.DECIMAL)
            PikchrTokenTypes.FLOAT -> pack(PikchrTextAttributes.FLOAT)
            PikchrTokenTypes.HEX -> pack(PikchrTextAttributes.HEX)
            PikchrTokenTypes.STRING -> pack(PikchrTextAttributes.STRING)

            PikchrTokenTypes.COMMA -> pack(PikchrTextAttributes.COMMA)
            PikchrTokenTypes.DOT -> pack(PikchrTextAttributes.DOT)
            PikchrTokenTypes.COLON -> pack(PikchrTextAttributes.DOT) // todo separate?
            PikchrTokenTypes.SEMICOLON -> pack(PikchrTextAttributes.SEMICOLON)
            PikchrTokenTypes.PERCENT -> pack(PikchrTextAttributes.PERCENT)
            in PikchrTokenGroups.OPERATION_SIGN -> pack(PikchrTextAttributes.OPERATION_SIGN)
            PikchrTokenTypes.ROUND_L, PikchrTokenTypes.ROUND_R -> pack(PikchrTextAttributes.PARENTHESES)
            PikchrTokenTypes.BRACES_L, PikchrTokenTypes.BRACES_R -> pack(PikchrTextAttributes.BRACES)
            PikchrTokenTypes.BRACKET_L, PikchrTokenTypes.BRACKET_R -> pack(PikchrTextAttributes.BRACKETS)

            in PikchrTokenGroups.OBJECT -> pack(PikchrTextAttributes.OBJECT)
            in PikchrTokenGroups.DIRECTION -> pack(PikchrTextAttributes.DIRECTION)
            in PikchrTokenGroups.KEYWORDS -> pack(PikchrTextAttributes.KEYWORD)
            in PikchrTokenGroups.ATTRIBUTE -> pack(PikchrTextAttributes.ATTRIBUTE)
            in PikchrTokenGroups.ARROW_HEAD -> pack(PikchrTextAttributes.ARROW_HEAD)
            in PikchrTokenGroups.EDGE_POSITION -> pack(PikchrTextAttributes.EDGE_POSITION)
            in PikchrTokenGroups.FUNCTION -> pack(PikchrTextAttributes.FUNCTION)
            in PikchrTokenGroups.BUILTIN_VARS -> pack(PikchrTextAttributes.BUILTIN_VARIABLE)

            in PikchrTokenGroups.DEBUG_STATEMENTS -> pack(PikchrTextAttributes.DEBUG)
            TokenType.BAD_CHARACTER -> pack(HighlighterColors.BAD_CHARACTER)
            else -> return TextAttributesKey.EMPTY_ARRAY
        }
    }
}