package com.yanncebron.intellipikchr.lang.lexer;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static com.yanncebron.intellipikchr.lang.psi.PikchrTokenTypes.*;

%%

%{
  public _PikchrLexer() {
    this((java.io.Reader)null);
  }
%}

%class _PikchrLexer
%implements FlexLexer
%function advance
%type IElementType

WHITE_SPACE=[\ \t\f]
CRLF=[\r\n]

LINE_COMMENT=(#|"//").*
BLOCK_COMMENT="/*" ~"*/"

STRING=\"([^\"\\]|\\.)*\"?
DECIMAL=[0-9]+
FLOAT=[0-9]*[.][0-9]+
HEX=0x[0-9a-fA-F]+

LABEL=[A-Z][a-zA-z_0-9]*
VARIABLE=[$@]?[a-z][a-zA-Z_0-9]*

%%
<YYINITIAL> {
  {WHITE_SPACE}+     { return WHITE_SPACE; }
  {CRLF}             { return LINEFEED; }

  "\\"               { return BACKSLASH; }

  "print"            { return PRINT; }
  "assert"           { return ASSERT; }

  "left"             { return LEFT; }
  "right"            { return RIGHT; }
  "down"             { return DOWN; }
  "up"               { return UP; }

  "arc"              { return ARC; }
  "arrow"            { return ARROW; }
  "box"              { return BOX; }
  "circle"           { return CIRCLE; }
  "cylinder"         { return CYLINDER; }
  "ellipse"          { return ELLIPSE; }
  "file"             { return FILE; }
  "dot"              { return DOT_OBJECT; }
  "line"             { return LINE; }
  "move"             { return MOVE; }
  "oval"             { return OVAL; }
  "spline"           { return SPLINE; }
  "text"             { return TEXT; }

  "define"           { return DEFINE; }
  "same"             { return SAME; }
  "as"               { return AS; }

  "<-"               { return ARROW_HEAD_BEGIN; }
  "←"                { return ARROW_HEAD_BEGIN_SINGLE; }
  "->"               { return ARROW_HEAD_END; }
  "→"                { return ARROW_HEAD_END_SINGLE; }
  "<->"              { return ARROW_HEAD_BOTH; }
  "↔"                { return ARROW_HEAD_BOTH_SINGLE; }
  "&larr;"           { return ARROW_LARR; }
  "&leftarrow;"      { return ARROW_LEFT_ARROW; }
  "&rarr;"           { return ARROW_RARR; }
  "&rightarrow;"     { return ARROW_RIGHT_ARROW; }
  "&leftrightarrow;" { return ARROW_LEFT_RIGHT_ARROW; }

  "behind"           { return BEHIND; }
  "dashed"           { return DASHED; }
  "dotted"           { return DOTTED; }
  "color"            { return COLOR; }
  "fill"             { return FILL; }
  "cw"               { return CW; }
  "ccw"              { return CCW; }
  "invis"            { return INVIS; }
  "invisible"        { return INVISIBLE; }
  "thick"            { return THICK; }
  "thickness"        { return THICKNESS; }
  "thin"             { return THIN; }
  "solid"            { return SOLID; }
  "chop"             { return CHOP; }
  "fit"              { return FIT; }
  "small"            { return SMALL; }
  "big"              { return BIG; }
  "bold"             { return BOLD; }
  "italic"           { return ITALIC; }
  "ljust"            { return LJUST; }
  "rjust"            { return RJUST; }

  "ht"               { return HT; }
  "height"           { return HEIGHT; }
  "rad"              { return RAD; }
  "radius"           { return RADIUS; }
  "diameter"         { return DIAMETER; }
  "wid"              { return WID; }
  "width"            { return WIDTH; }

  "above"            { return ABOVE; }
  "aligned"          { return ALIGNED; }
  "below"            { return BELOW; }
  "at"               { return AT; }
  "with"             { return WITH; }
  "between"          { return BETWEEN; }
  "way"              { return WAY; }
  "the"              { return THE; }
  "and"              { return AND; }
  "from"             { return FROM; }
  "to"               { return TO; }

  "heading"          { return HEADING; }
  "then"             { return THEN; }
  "end"              { return END; }
  "go"               { return GO; }
  "until"            { return UNTIL; }
  "even"             { return EVEN; }
  "close"            { return CLOSE; }
  "vertex"           { return VERTEX; }

  "n"                { return N; }
  "north"            { return NORTH; }
  "ne"               { return NE; }
  "e"                { return E; }
  "east"             { return EAST; }
  "se"               { return SE; }
  "s"                { return S; }
  "south"            { return SOUTH; }
  "sw"               { return SW; }
  "w"                { return W; }
  "west"             { return WEST; }
  "nw"               { return NW; }

  "t"                { return T; }
  "top"              { return TOP; }
  "bot"              { return BOT; }
  "bottom"           { return BOTTOM; }
  "c"                { return C; }
  "center"           { return CENTER; }
  "start"            { return START; }
//  "end"              { return POS_END; } // todo

   "x"               { return X;}
   "y"               { return Y;}

  "of"               { return OF; }
  "in"               { return IN; }
  "first"            { return FIRST; }
  "last"             { return LAST; }
  "previous"         { return PREVIOUS; }

  "abs"              { return ABS; }
  "cos"              { return COS; }
  "dist"             { return DIST; }
  "int"              { return INT; }
  "max"              { return MAX; }
  "min"              { return MIN; }
  "sin"              { return SIN; }
  "sqrt"             { return SQRT; }

  "."                { return DOT; }
  ","                { return COMMA; }
  ":"                { return COLON; }
  ";"                { return SEMICOLON; }
  "%"                { return PERCENT; }
  "$"                { return DOLLAR; }

  "("                { return ROUND_L; }
  ")"                { return ROUND_R; }
  "{"                { return BRACES_L; }
  "}"                { return BRACES_R; }
  "["                { return BRACKET_L; }
  "]"                { return BRACKET_R; }
  "<"                { return LT; }
  ">"                { return GT; }

  "-"                { return MINUS; }
  "+"                { return PLUS; }
  "*"                { return MUL; }
  "/"                { return DIV; }

  "="                { return EQUAL; }
  "=="               { return EQUAL_EQUAL; }
  "+="               { return PLUS_EQUAL; }
  "-="               { return MINUS_EQUAL; }
  "*="               { return MUL_EQUAL; }
  "/="               { return DIV_EQUAL; }


  {STRING}           { return STRING; }

  {DECIMAL}          { return DECIMAL; }
  {FLOAT}            { return FLOAT; }
  {HEX}              { return HEX; }


  {VARIABLE}         { return VARIABLE; }

  {LABEL}            { return LABEL; }

  {LINE_COMMENT}     { return LINE_COMMENT; }
  {BLOCK_COMMENT}    { return BLOCK_COMMENT; }
}

[^] { return BAD_CHARACTER; }
