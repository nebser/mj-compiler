package rs.ac.bg.etf.pp1;

import java_cup.runtime.Symbol;

%%

%{

	private Symbol new_symbol(int type) {
		return new Symbol(type, yyline+1, yycolumn);
	}
	
	private Symbol new_symbol(int type, Object value) {
		return new Symbol(type, yyline+1, yycolumn, value);
	}

%}

%cup
%line
%column

%xstate COMMENT

%eofval{
	return new_symbol(sym.EOF);
%eofval}

%%

" " 	{ }
"\b" 	{ }
"\t" 	{ }
"\r\n" 	{ }
"\n" 	{ }
"\f" 	{ }

"program" { return new_symbol(sym.PROGRAM, yytext()); }
"break" { return new_symbol(sym.BREAK, yytext()); }
"class" { return new_symbol(sym.CLASS, yytext()); }
"abstract" { return new_symbol(sym.ABSTRACT, yytext()); }
"else" { return new_symbol(sym.ELSE, yytext()); }
"const" { return new_symbol(sym.CONST, yytext()); }
"if" { return new_symbol(sym.IF, yytext()); }
"new" { return new_symbol(sym.NEW, yytext()); }
"print" { return new_symbol(sym.PRINT, yytext()); }
"read" { return new_symbol(sym.READ, yytext()); }
"return" { return new_symbol(sym.RETURN, yytext()); }
"void" { return new_symbol(sym.VOID, yytext()); }
"for" { return new_symbol(sym.FOR, yytext()); }
"extends" { return new_symbol(sym.EXTENDS, yytext()); }
"continue" { return new_symbol(sym.CONTINUE, yytext()); }

"(" { return new_symbol(sym.LPARENTHESIS, yytext()); }
"++" { return new_symbol(sym.INCREMENT, yytext()); }
"+" { return new_symbol(sym.PLUS, yytext()); }
"--" { return new_symbol(sym.DECREMENT, yytext()); }
"-" { return new_symbol(sym.MINUS, yytext()); }
"*" { return new_symbol(sym.MULTIPLY, yytext()); }
"/" { return new_symbol(sym.DIVIDE, yytext()); }
"%" { return new_symbol(sym.MOD, yytext()); }
"==" { return new_symbol(sym.EQUALS, yytext()); }
"!=" { return new_symbol(sym.DIFFERS, yytext()); }
">" { return new_symbol(sym.GREATER, yytext()); }
">=" { return new_symbol(sym.GREATER_OR_EQUAL, yytext()); }
"<" { return new_symbol(sym.LESS, yytext()); }
"<=" { return new_symbol(sym.LESS_OR_EQUAL, yytext()); }
"&&" { return new_symbol(sym.AND, yytext()); }
"||" { return new_symbol(sym.OR, yytext()); }
"=" { return new_symbol(sym.ASSIGN, yytext()); }
";" { return new_symbol(sym.SEMI_COLON, yytext()); }
"," { return new_symbol(sym.COMMA, yytext()); }
"." { return new_symbol(sym.COLON, yytext()); }
")" { return new_symbol(sym.RPARENTHESIS, yytext()); }
"[" { return new_symbol(sym.LBRACKET, yytext()); }
"]" { return new_symbol(sym.RBRACKET, yytext()); }
"{" { return new_symbol(sym.LBRACE, yytext()); }
"}" { return new_symbol(sym.RBRACE, yytext()); }

"//" { yybegin(COMMENT); }
<COMMENT> "\r\n" { yybegin(YYINITIAL); }
<COMMENT> "\n" { yybegin(YYINITIAL); }
<COMMENT> . { yybegin(COMMENT); }

[a-z|A-Z][a-z|A-Z|0-9|_]* { return new_symbol(sym.IDENT, yytext()); }
[0-9]+ { return new_symbol(sym.NUMBER, new Integer(yytext())); }
\"\"\".\"\"\" { return new_symbol(sym.CHARACTER, yytext()); }
true|false { return new_symbol(sym.BOOL, yytext()); }

. { System.err.println("Leksicka greska ("+yytext()+") u liniji "+(yyline+1)); }

 