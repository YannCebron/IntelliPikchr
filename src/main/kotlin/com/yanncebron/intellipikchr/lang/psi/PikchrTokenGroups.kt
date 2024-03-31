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

import com.intellij.psi.tree.TokenSet

object PikchrTokenGroups {

    @JvmField
    val OBJECT = TokenSet.create(
        PikchrTokenTypes.ARC,
        PikchrTokenTypes.ARROW,
        PikchrTokenTypes.BOX,
        PikchrTokenTypes.CIRCLE,
        PikchrTokenTypes.CYLINDER,
        PikchrTokenTypes.DIAMOND,
        PikchrTokenTypes.DOT_OBJECT,
        PikchrTokenTypes.ELLIPSE,
        PikchrTokenTypes.FILE,
        PikchrTokenTypes.LINE,
        PikchrTokenTypes.MOVE,
        PikchrTokenTypes.OVAL,
        PikchrTokenTypes.SPLINE,
        PikchrTokenTypes.TEXT
    )

    @JvmField
    val DIRECTION = TokenSet.create(
        PikchrTokenTypes.LEFT,
        PikchrTokenTypes.RIGHT,
        PikchrTokenTypes.DOWN,
        PikchrTokenTypes.UP
    )

    @JvmField
    val KEYWORDS = TokenSet.create(
        PikchrTokenTypes.AND,
        PikchrTokenTypes.AT,
        PikchrTokenTypes.BETWEEN,
        PikchrTokenTypes.CLOSE,
        PikchrTokenTypes.DEFINE,
        PikchrTokenTypes.END,
        PikchrTokenTypes.EVEN,
        PikchrTokenTypes.FIRST,
        PikchrTokenTypes.FROM,
        PikchrTokenTypes.GO,
        PikchrTokenTypes.HEADING,
        PikchrTokenTypes.LAST,
        PikchrTokenTypes.IN,
        PikchrTokenTypes.OF,
        PikchrTokenTypes.PREVIOUS,
        PikchrTokenTypes.THE,
        PikchrTokenTypes.TO,
        PikchrTokenTypes.THEN,
        PikchrTokenTypes.VERTEX,
        PikchrTokenTypes.UNTIL,
        PikchrTokenTypes.WAY,
        PikchrTokenTypes.WITH
    )

    @JvmField
    val ARROW_HEAD = TokenSet.create(
        PikchrTokenTypes.ARROW_HEAD_BEGIN,
        PikchrTokenTypes.ARROW_HEAD_BEGIN_SINGLE,
        PikchrTokenTypes.ARROW_HEAD_END,
        PikchrTokenTypes.ARROW_HEAD_END_SINGLE,
        PikchrTokenTypes.ARROW_HEAD_BOTH,
        PikchrTokenTypes.ARROW_HEAD_BOTH_SINGLE,

        PikchrTokenTypes.ARROW_LARR,
        PikchrTokenTypes.ARROW_LEFT_ARROW,
        PikchrTokenTypes.ARROW_RARR,
        PikchrTokenTypes.ARROW_RIGHT_ARROW,
        PikchrTokenTypes.ARROW_LEFT_RIGHT_ARROW
    )

    @JvmField
    val OPERATION_SIGN = TokenSet.create(
        PikchrTokenTypes.EQUAL,
        PikchrTokenTypes.EQUAL_EQUAL,
        PikchrTokenTypes.PLUS,
        PikchrTokenTypes.MINUS,
        PikchrTokenTypes.MUL,
        PikchrTokenTypes.DIV,
        PikchrTokenTypes.LT,
        PikchrTokenTypes.GT,
        PikchrTokenTypes.PLUS_EQUAL,
        PikchrTokenTypes.MINUS_EQUAL,
        PikchrTokenTypes.MUL_EQUAL,
        PikchrTokenTypes.DIV_EQUAL
    )

    @JvmField
    val EDGE_POSITION = TokenSet.create(
        PikchrTokenTypes.N,
        PikchrTokenTypes.NORTH,
        PikchrTokenTypes.NE,
        PikchrTokenTypes.E,
        PikchrTokenTypes.EAST,
        PikchrTokenTypes.SE,
        PikchrTokenTypes.S,
        PikchrTokenTypes.SOUTH,
        PikchrTokenTypes.SW,
        PikchrTokenTypes.W,
        PikchrTokenTypes.WEST,
        PikchrTokenTypes.NW,

        PikchrTokenTypes.T,
        PikchrTokenTypes.TOP,
        PikchrTokenTypes.BOT,
        PikchrTokenTypes.BOTTOM,
        PikchrTokenTypes.C,
        PikchrTokenTypes.CENTER, // todo text-attribute
        PikchrTokenTypes.START,
//            PikchrTokenTypes.POS_END,// todo

        PikchrTokenTypes.X,
        PikchrTokenTypes.Y
    )

    @JvmField
    val FUNCTION = TokenSet.create(
        PikchrTokenTypes.ABS,
        PikchrTokenTypes.COS,
        PikchrTokenTypes.DIST,
        PikchrTokenTypes.INT,
        PikchrTokenTypes.MAX,
        PikchrTokenTypes.MIN,
        PikchrTokenTypes.SIN,
        PikchrTokenTypes.SQRT
    )

    @JvmField
    val BUILTIN_VARS = TokenSet.create(
        PikchrTokenTypes.ARCRAD,
        PikchrTokenTypes.ARROWHEAD,
        PikchrTokenTypes.ARROWHT,
        PikchrTokenTypes.ARROWWID,
        PikchrTokenTypes.BOXHT,
        PikchrTokenTypes.BOXRAD,
        PikchrTokenTypes.BOXWID,
        PikchrTokenTypes.CHARHT,
        PikchrTokenTypes.CHARWID,
        PikchrTokenTypes.CIRCLERAD,
        PikchrTokenTypes.BUILTIN_COLOR,
        PikchrTokenTypes.CYLHT,
        PikchrTokenTypes.CYLRAD,
        PikchrTokenTypes.CYLWID,
        PikchrTokenTypes.DASHWID,
        PikchrTokenTypes.DIAMONDHT,
        PikchrTokenTypes.DIAMONDWID,
        PikchrTokenTypes.DOTRAD,
        PikchrTokenTypes.ELLIPSEHT,
        PikchrTokenTypes.ELLIPSEWID,
        PikchrTokenTypes.FILEHT,
        PikchrTokenTypes.FILERAD,
        PikchrTokenTypes.FILEWID,
        PikchrTokenTypes.BUILTIN_FILL,
        PikchrTokenTypes.LINEHT,
        PikchrTokenTypes.LINEWID,
        PikchrTokenTypes.MOVEWID,
        PikchrTokenTypes.OVALHT,
        PikchrTokenTypes.OVALWID,
        PikchrTokenTypes.SCALE,
        PikchrTokenTypes.TEXTHT,
        PikchrTokenTypes.TEXTWID,
        PikchrTokenTypes.BUILTIN_THICKNESS
    )

    @JvmField
    val ATTRIBUTE = TokenSet.create(
        // attribute
        PikchrTokenTypes.SAME,
        PikchrTokenTypes.AS,
        PikchrTokenTypes.DASHED,
        PikchrTokenTypes.DOTTED,
        PikchrTokenTypes.COLOR,
        PikchrTokenTypes.FILL,
        PikchrTokenTypes.BEHIND,
        PikchrTokenTypes.CW,
        PikchrTokenTypes.CCW,
        PikchrTokenTypes.INVIS,
        PikchrTokenTypes.INVISIBLE,
        PikchrTokenTypes.THICK,
        PikchrTokenTypes.THIN,
        PikchrTokenTypes.SOLID,
        PikchrTokenTypes.CHOP,
        PikchrTokenTypes.FIT,

        // numeric-property
        PikchrTokenTypes.DIAMETER,
        PikchrTokenTypes.HT,
        PikchrTokenTypes.HEIGHT,
        PikchrTokenTypes.RAD,
        PikchrTokenTypes.RADIUS,
        PikchrTokenTypes.THICKNESS,
        PikchrTokenTypes.WID,
        PikchrTokenTypes.WIDTH,

        // text-attribute
        PikchrTokenTypes.ABOVE, // todo which-way-from
        PikchrTokenTypes.ALIGNED,
        PikchrTokenTypes.BELOW, // todo which-way-from
        PikchrTokenTypes.BIG,
        PikchrTokenTypes.BOLD,
        PikchrTokenTypes.ITALIC,
        PikchrTokenTypes.LJUST,
        PikchrTokenTypes.RJUST,
        PikchrTokenTypes.SMALL
    )


    @JvmField
    val DEBUG_STATEMENTS = TokenSet.create(
        PikchrTokenTypes.PRINT,
        PikchrTokenTypes.ASSERT
    )

}