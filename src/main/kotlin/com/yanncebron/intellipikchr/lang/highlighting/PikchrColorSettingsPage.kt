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

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage
import com.yanncebron.intellipikchr.IntelliPikchrBundle
import com.yanncebron.intellipikchr.PikchrFileType
import javax.swing.Icon

class PikchrColorSettingsPage : ColorSettingsPage {

    override fun getAttributeDescriptors(): Array<AttributesDescriptor> {
        fun createDescriptor(groupKey: String, typeKey: String, textAttributesKey: TextAttributesKey): AttributesDescriptor {
            val displayName = IntelliPikchrBundle.message(groupKey) + IntelliPikchrBundle.message(typeKey)
            return AttributesDescriptor(displayName, textAttributesKey)
        }

        return arrayOf(
                createDescriptor("color.settings.group.root", "attribute.descriptor.backslash", PikchrTextAttributes.BACKSLASH),
                createDescriptor("color.settings.group.root", "attribute.descriptor.label", PikchrTextAttributes.LABEL),
                createDescriptor("color.settings.group.root", "attribute.descriptor.variable", PikchrTextAttributes.VARIABLE),
                createDescriptor("color.settings.group.root", "attribute.descriptor.keyword", PikchrTextAttributes.KEYWORD),
                createDescriptor("color.settings.group.root", "attribute.descriptor.object", PikchrTextAttributes.OBJECT),
                createDescriptor("color.settings.group.root", "attribute.descriptor.direction", PikchrTextAttributes.DIRECTION),
                createDescriptor("color.settings.group.root", "attribute.descriptor.arrow.heads", PikchrTextAttributes.ARROW_HEAD),
                createDescriptor("color.settings.group.root", "attribute.descriptor.edge.position", PikchrTextAttributes.EDGE_POSITION),
                createDescriptor("color.settings.group.root", "attribute.descriptor.function", PikchrTextAttributes.FUNCTION),
                createDescriptor("color.settings.group.root", "attribute.descriptor.attribute", PikchrTextAttributes.ATTRIBUTE),
                createDescriptor("color.settings.group.root", "attribute.descriptor.brackets", PikchrTextAttributes.BRACKETS),

                createDescriptor("color.settings.group.comment", "attribute.descriptor.line.comment", PikchrTextAttributes.LINE_COMMENT),
                createDescriptor("color.settings.group.comment", "attribute.descriptor.block.comment", PikchrTextAttributes.BLOCK_COMMENT),

                createDescriptor("color.settings.group.braces.operators", "attribute.descriptor.comma", PikchrTextAttributes.COMMA),
                createDescriptor("color.settings.group.braces.operators", "attribute.descriptor.dot", PikchrTextAttributes.DOT),
                createDescriptor("color.settings.group.braces.operators", "attribute.descriptor.semicolon", PikchrTextAttributes.SEMICOLON),
                createDescriptor("color.settings.group.braces.operators", "attribute.descriptor.parentheses", PikchrTextAttributes.PARENTHESES),
                createDescriptor("color.settings.group.braces.operators", "attribute.descriptor.percent", PikchrTextAttributes.PERCENT),
                createDescriptor("color.settings.group.braces.operators", "attribute.descriptor.braces", PikchrTextAttributes.BRACES),
                createDescriptor("color.settings.group.braces.operators", "attribute.descriptor.operation.sign", PikchrTextAttributes.OPERATION_SIGN),

                createDescriptor("color.settings.group.literals", "attribute.descriptor.string", PikchrTextAttributes.STRING),
                createDescriptor("color.settings.group.literals", "attribute.descriptor.decimal.number", PikchrTextAttributes.DECIMAL),
                createDescriptor("color.settings.group.literals", "attribute.descriptor.hex.number", PikchrTextAttributes.HEX),
                createDescriptor("color.settings.group.literals", "attribute.descriptor.float.number", PikchrTextAttributes.FLOAT),
        )
    }

    override fun getColorDescriptors(): Array<ColorDescriptor> = emptyArray()

    override fun getDisplayName(): String = PikchrFileType.INSTANCE.name

    override fun getIcon(): Icon = PikchrFileType.INSTANCE.icon

    override fun getHighlighter(): SyntaxHighlighter = PikchrSyntaxHighlighter()

    @Suppress("SpellCheckingInspection")
    override fun getDemoText(): String {
        return """
    lineht *= 0.4
    ${'$'}margin = lineht*2.5
    scale = 0.75
    fontscale = 1.1
    charht *= 1.15
    down
In: box "Interface" wid 150% ht 75% fill white
    arrow
CP: box same "SQL Command" "Processor"
    arrow
VM: box same "Virtual Machine"
    arrow down 1.25*\${'$'}margin
BT: box same "B-Tree"
    arrow
    box same "Pager"
    arrow
OS: box same "OS Interface"
    box same with .w at 1.25*\${'$'}margin east of 1st box.e "Tokenizer"
    arrow
    box same "Parser"
    arrow
CG: box same ht 200% "Code" "Generator"
UT: box same as 1st box at (Tokenizer,Pager) "Utilities"
    move lineht
TC: box same "Test Code"
    arrow from CP to 1/4<Tokenizer.sw,Tokenizer.nw> chop
    arrow from 1/3<CG.nw,CG.sw> to CP chop

    box ht (In.n.y-VM.s.y)+\${'$'}margin wid In.wid+\${'$'}margin \
       at CP fill 0xd8ecd0 behind In
    line invis from 0.25*\${'$'}margin east of last.sw up last.ht \
        "Core" italic aligned

    box ht (BT.n.y-OS.s.y)+\${'$'}margin wid In.wid+\${'$'}margin \
       at Pager fill 0xd0ece8 behind In
    line invis from 0.25*\${'$'}margin east of last.sw up last.ht \
       "Backend" italic aligned

    box ht (Tokenizer.n.y-CG.s.y)+\${'$'}margin wid In.wid+\${'$'}margin \
       at 1/2<Tokenizer.n,CG.s> fill 0xe8d8d0 behind In
    line invis from 0.25*\${'$'}margin west of last.se up last.ht \
       "SQL Compiler" italic aligned

    box ht (UT.n.y-TC.s.y)+\${'$'}margin wid In.wid+\${'$'}margin \
       at 1/2<UT,TC> fill 0xe0ecc8 behind In
    line invis from 0.25*\${'$'}margin west of last.se up last.ht \
      "Accessories" italic aligned            
        """.trimIndent()
    }

    override fun getAdditionalHighlightingTagToDescriptorMap(): MutableMap<String, TextAttributesKey>? {
        return null
    }
}