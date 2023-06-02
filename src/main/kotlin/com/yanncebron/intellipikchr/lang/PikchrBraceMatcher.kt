/*
 * Copyright 2023 The Authors
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

import com.intellij.lang.BracePair
import com.intellij.lang.PairedBraceMatcher
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IElementType
import com.yanncebron.intellipikchr.lang.psi.PikchrTokenTypes

internal class PikchrBraceMatcher : PairedBraceMatcher {

    private val bracePairs = arrayOf(
        BracePair(PikchrTokenTypes.ROUND_L, PikchrTokenTypes.ROUND_R, false),
        BracePair(PikchrTokenTypes.LT, PikchrTokenTypes.GT, false),

        BracePair(PikchrTokenTypes.BRACES_L, PikchrTokenTypes.BRACES_R, true),
        BracePair(PikchrTokenTypes.BRACKET_L, PikchrTokenTypes.BRACKET_R, true)
    )

    override fun getPairs(): Array<BracePair> {
        return bracePairs
    }

    override fun isPairedBracesAllowedBeforeType(lbraceType: IElementType, contextType: IElementType?): Boolean {
        return true
    }

    override fun getCodeConstructStart(file: PsiFile?, openingBraceOffset: Int): Int {
        return openingBraceOffset
    }
}