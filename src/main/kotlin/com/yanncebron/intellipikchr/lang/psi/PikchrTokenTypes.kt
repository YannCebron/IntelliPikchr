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

package com.yanncebron.intellipikchr.lang.psi

import com.intellij.psi.tree.IElementType
import com.yanncebron.intellipikchr.lang.PikchrLanguage
import org.jetbrains.annotations.NonNls

object PikchrTokenTypes {

    @JvmField
    val LINE_COMMENT: IElementType = PikchrTokenType("comment")

    @JvmField
    val BLOCK_COMMENT: IElementType = PikchrTokenType("block_comment")

    @JvmField
    val BACKSLASH: IElementType = PikchrTokenType("\\")

    @JvmField
    val LINEFEED: IElementType = PikchrTokenType("CR_LF")

    @JvmField
    val PRINT: IElementType = PikchrTokenType("print")

    @JvmField
    val ASSERT: IElementType = PikchrTokenType("assert")


    @JvmField
    val STRING: IElementType = PikchrTokenType("string")

    @JvmField
    val DECIMAL: IElementType = PikchrTokenType("decimal")

    @JvmField
    val FLOAT: IElementType = PikchrTokenType("float")

    @JvmField
    val HEX: IElementType = PikchrTokenType("hex")


    @JvmField
    val LABEL: IElementType = PikchrTokenType("label")

    @JvmField
    val VARIABLE: IElementType = PikchrTokenType("variable")


    @JvmField
    val LEFT: IElementType = PikchrTokenType("left")

    @JvmField
    val RIGHT: IElementType = PikchrTokenType("right")

    @JvmField
    val DOWN: IElementType = PikchrTokenType("down")

    @JvmField
    val UP: IElementType = PikchrTokenType("up")


    @JvmField
    val DOT: IElementType = PikchrTokenType(".")

    @JvmField
    val COMMA: IElementType = PikchrTokenType(",")

    @JvmField
    val SEMICOLON: IElementType = PikchrTokenType(";")

    @JvmField
    val COLON: IElementType = PikchrTokenType(":")

    @JvmField
    val EQUAL: IElementType = PikchrTokenType("=")

    @JvmField
    val EQUAL_EQUAL: IElementType = PikchrTokenType("==")

    @JvmField
    val PERCENT: IElementType = PikchrTokenType("%")

    @JvmField
    val DOLLAR: IElementType = PikchrTokenType("$")

    @JvmField
    val ROUND_L: IElementType = PikchrTokenType("(")

    @JvmField
    val ROUND_R: IElementType = PikchrTokenType(")")

    @JvmField
    val BRACES_L: IElementType = PikchrTokenType("{")

    @JvmField
    val BRACES_R: IElementType = PikchrTokenType("}")

    @JvmField
    val BRACKET_L: IElementType = PikchrTokenType("[")

    @JvmField
    val BRACKET_R: IElementType = PikchrTokenType("]")


    @JvmField
    val MINUS: IElementType = PikchrTokenType("-")

    @JvmField
    val PLUS: IElementType = PikchrTokenType("+")

    @JvmField
    val MUL: IElementType = PikchrTokenType("*")

    @JvmField
    val DIV: IElementType = PikchrTokenType("/")

    @JvmField
    val PLUS_EQUAL: IElementType = PikchrTokenType("+=")

    @JvmField
    val MINUS_EQUAL: IElementType = PikchrTokenType("-=")

    @JvmField
    val MUL_EQUAL: IElementType = PikchrTokenType("*=")

    @JvmField
    val DIV_EQUAL: IElementType = PikchrTokenType("/=")

    @JvmField
    val LT: IElementType = PikchrTokenType("<")

    @JvmField
    val GT: IElementType = PikchrTokenType(">")


    @JvmField
    val ARC: IElementType = PikchrTokenType("arc")

    @JvmField
    val ARROW: IElementType = PikchrTokenType("arrow")

    @JvmField
    val BOX: IElementType = PikchrTokenType("box")

    @JvmField
    val CIRCLE: IElementType = PikchrTokenType("circle")

    @JvmField
    val CYLINDER: IElementType = PikchrTokenType("cylinder")

    @JvmField
    val ELLIPSE: IElementType = PikchrTokenType("ellipse")

    @JvmField
    val FILE: IElementType = PikchrTokenType("file")

    @JvmField
    val DOT_OBJECT: IElementType = PikchrTokenType("dot")

    @JvmField
    val LINE: IElementType = PikchrTokenType("line")

    @JvmField
    val MOVE: IElementType = PikchrTokenType("move")

    @JvmField
    val OVAL: IElementType = PikchrTokenType("oval")

    @JvmField
    val SPLINE: IElementType = PikchrTokenType("spline")

    @JvmField
    val TEXT: IElementType = PikchrTokenType("text")


    // keywords
    @JvmField
    val ABOVE: IElementType = PikchrTokenType("above")

    @JvmField
    val ALIGNED: IElementType = PikchrTokenType("aligned")

    @JvmField
    val AND: IElementType = PikchrTokenType("and")


    @JvmField
    val AT: IElementType = PikchrTokenType("at")

    @JvmField
    val BELOW: IElementType = PikchrTokenType("below")

    @JvmField
    val BETWEEN: IElementType = PikchrTokenType("between")

    @JvmField
    val DEFINE: IElementType = PikchrTokenType("define")

    @JvmField
    val END: IElementType = PikchrTokenType("end")

    @JvmField
    val EVEN: IElementType = PikchrTokenType("even")

    @JvmField
    val FIRST: IElementType = PikchrTokenType("first")

    @JvmField
    val FROM: IElementType = PikchrTokenType("from")

    @JvmField
    val HEADING: IElementType = PikchrTokenType("heading")

    @JvmField
    val OF: IElementType = PikchrTokenType("of")

    @JvmField
    val IN: IElementType = PikchrTokenType("in")

    @JvmField
    val LAST: IElementType = PikchrTokenType("last")

    @JvmField
    val PREVIOUS: IElementType = PikchrTokenType("previous")


    @JvmField
    val TO: IElementType = PikchrTokenType("to")

    @JvmField
    val THEN: IElementType = PikchrTokenType("then")

    @JvmField
    val GO: IElementType = PikchrTokenType("go")

    @JvmField
    val CLOSE: IElementType = PikchrTokenType("close")

    @JvmField
    val THE: IElementType = PikchrTokenType("the")

    @JvmField
    val UNTIL: IElementType = PikchrTokenType("until")

    @JvmField
    val VERTEX: IElementType = PikchrTokenType("vertex")

    @JvmField
    val WAY: IElementType = PikchrTokenType("way")

    @JvmField
    val WITH: IElementType = PikchrTokenType("with")


    // arrows
    @JvmField
    val ARROW_HEAD_BEGIN: IElementType = PikchrTokenType("<-")

    @JvmField
    val ARROW_HEAD_BEGIN_SINGLE: IElementType = PikchrTokenType("←")

    @JvmField
    val ARROW_HEAD_END: IElementType = PikchrTokenType("->")

    @JvmField
    val ARROW_HEAD_END_SINGLE: IElementType = PikchrTokenType("→")

    @JvmField
    val ARROW_HEAD_BOTH: IElementType = PikchrTokenType("<->")

    @JvmField
    val ARROW_HEAD_BOTH_SINGLE: IElementType = PikchrTokenType("↔")

    @JvmField
    val ARROW_RARR: IElementType = PikchrTokenType("&rarr;")

    @JvmField
    val ARROW_RIGHT_ARROW: IElementType = PikchrTokenType("&rightarrow;")

    @JvmField
    val ARROW_LARR: IElementType = PikchrTokenType("&larr;")

    @JvmField
    val ARROW_LEFT_ARROW: IElementType = PikchrTokenType("&leftarrow;")

    @JvmField
    val ARROW_LEFT_RIGHT_ARROW: IElementType = PikchrTokenType("&leftrightarrow;")


    // edge positions
    @JvmField
    val N: IElementType = PikchrTokenType("n")

    @JvmField
    val NORTH: IElementType = PikchrTokenType("north")

    @JvmField
    val NE: IElementType = PikchrTokenType("ne")

    @JvmField
    val E: IElementType = PikchrTokenType("e")

    @JvmField
    val EAST: IElementType = PikchrTokenType("east")

    @JvmField
    val SE: IElementType = PikchrTokenType("se")

    @JvmField
    val S: IElementType = PikchrTokenType("s")

    @JvmField
    val SOUTH: IElementType = PikchrTokenType("south")

    @JvmField
    val W: IElementType = PikchrTokenType("w")

    @JvmField
    val WEST: IElementType = PikchrTokenType("west")

    @JvmField
    val NW: IElementType = PikchrTokenType("nw")

    @JvmField
    val SW: IElementType = PikchrTokenType("sw")


    @JvmField
    val T: IElementType = PikchrTokenType("t")

    @JvmField
    val TOP: IElementType = PikchrTokenType("top")

    @JvmField
    val BOT: IElementType = PikchrTokenType("bot")

    @JvmField
    val BOTTOM: IElementType = PikchrTokenType("bottom")

    @JvmField
    val C: IElementType = PikchrTokenType("c")

    @JvmField
    val CENTER: IElementType = PikchrTokenType("center")

    @JvmField
    val START: IElementType = PikchrTokenType("start")

//    @JvmField
//    val POS_END: IElementType = PikchrTokenType("pos_end")

    @JvmField
    val X: IElementType = PikchrTokenType("x")

    @JvmField
    val Y: IElementType = PikchrTokenType("y")


    // attributes

    @JvmField
    val SAME: IElementType = PikchrTokenType("same")

    @JvmField
    val AS: IElementType = PikchrTokenType("as")

    @JvmField
    val DASHED: IElementType = PikchrTokenType("dashed")

    @JvmField
    val DOTTED: IElementType = PikchrTokenType("dotted")

    @JvmField
    val COLOR: IElementType = PikchrTokenType("color")

    @JvmField
    val BEHIND: IElementType = PikchrTokenType("behind")

    @JvmField
    val FILL: IElementType = PikchrTokenType("fill")

    @JvmField
    val CW: IElementType = PikchrTokenType("cw")

    @JvmField
    val CCW: IElementType = PikchrTokenType("ccw")

    @JvmField
    val INVIS: IElementType = PikchrTokenType("invis")

    @JvmField
    val INVISIBLE: IElementType = PikchrTokenType("invisible")

    @JvmField
    val THICK: IElementType = PikchrTokenType("thick")

    @JvmField
    val THICKNESS: IElementType = PikchrTokenType("thickness")

    @JvmField
    val THIN: IElementType = PikchrTokenType("thin")

    @JvmField
    val SOLID: IElementType = PikchrTokenType("solid")

    @JvmField
    val CHOP: IElementType = PikchrTokenType("chop")

    @JvmField
    val FIT: IElementType = PikchrTokenType("fit")

    @JvmField
    val SMALL: IElementType = PikchrTokenType("small")

    @JvmField
    val BIG: IElementType = PikchrTokenType("big")

    @JvmField
    val BOLD: IElementType = PikchrTokenType("bold")

    @JvmField
    val ITALIC: IElementType = PikchrTokenType("italic")

    @JvmField
    val LJUST: IElementType = PikchrTokenType("ljust")

    @JvmField
    val RJUST: IElementType = PikchrTokenType("rjust")

    @JvmField
    val HT: IElementType = PikchrTokenType("ht")

    @JvmField
    val HEIGHT: IElementType = PikchrTokenType("height")

    @JvmField
    val RAD: IElementType = PikchrTokenType("rad")

    @JvmField
    val RADIUS: IElementType = PikchrTokenType("radius")

    @JvmField
    val DIAMETER: IElementType = PikchrTokenType("diameter")

    @JvmField
    val WID: IElementType = PikchrTokenType("wid")

    @JvmField
    val WIDTH: IElementType = PikchrTokenType("width")


    // functions
    @JvmField
    val ABS: IElementType = PikchrTokenType("abs")

    @JvmField
    val COS: IElementType = PikchrTokenType("cos")

    @JvmField
    val DIST: IElementType = PikchrTokenType("dist")

    @JvmField
    val INT: IElementType = PikchrTokenType("int")

    @JvmField
    val MAX: IElementType = PikchrTokenType("max")

    @JvmField
    val MIN: IElementType = PikchrTokenType("min")

    @JvmField
    val SIN: IElementType = PikchrTokenType("sin")

    @JvmField
    val SQRT: IElementType = PikchrTokenType("sqrt")

    private class PikchrTokenType(debugName: @NonNls String) : IElementType(debugName, PikchrLanguage.INSTANCE)
}
