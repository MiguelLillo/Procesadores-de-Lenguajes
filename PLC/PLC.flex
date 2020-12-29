import java_cup.runtime.*;
%%
%cup

%%
\{						{ return new Symbol(sym.ALL); }
\}						{ return new Symbol(sym.CLL); }
\(						{ return new Symbol(sym.AP); }
\)						{ return new Symbol(sym.CP); }
\;						{ return new Symbol(sym.PYC); }
\,						{ return new Symbol(sym.COMA); }
\:						{ return new Symbol(sym.DP); }
\?						{ return new Symbol(sym.signo_int); }
\!						{ return new Symbol(sym.NOT); }
\+						{ return new Symbol(sym.MAS); }
\+\+					{ return new Symbol(sym.INC); }
\-						{ return new Symbol(sym.MENOS); }
\-\-					{ return new Symbol(sym.DECR); }
\*						{ return new Symbol(sym.POR); }
\/						{ return new Symbol(sym.DIV); }
\%						{ return new Symbol(sym.MOD); }

\<						{ return new Symbol(sym.LT); }	//Less than
\<\=					{ return new Symbol(sym.LQ); } 	//or equal
\>						{ return new Symbol(sym.GT); }	//greater
\>\=					{ return new Symbol(sym.GQ); }
\&\&					{ return new Symbol(sym.AND); }
\|\|					{ return new Symbol(sym.OR); }
\=						{ return new Symbol(sym.ASIG); }
\=\=					{ return new Symbol(sym.EQUALS); }
\!\=					{ return new Symbol(sym.NOTEQUALS); }


"if"					{ return new Symbol(sym.IF); }
"else"					{ return new Symbol(sym.ELSE); }
"elseif"				{ return new Symbol(sym.ELSEIF); }
"while"					{ return new Symbol(sym.WHILE); }
"do"					{ return new Symbol(sym.DO); }
"for"					{ return new Symbol(sym.FOR); }
"print"					{ return new Symbol(sym.PRINT); }
"true"					{ return new Symbol(sym.TRUE); }
"false"					{ return new Symbol(sym.FALSE); }
"switch"				{ return new Symbol(sym.SWITCH); }
"case"					{ return new Symbol(sym.CASE); }
"break"					{ return new Symbol(sym.BREAK); }
"default"				{ return new Symbol(sym.DEFAULT); }
"int"					{ return new Symbol(sym.INT); }
"char"					{ return new Symbol(sym.CHAR); }
"typedef"				{ return new Symbol(sym.TYPEDEF); }

[a-zA-Z_][a-zA-Z0-9_]*	{ return new Symbol(sym.IDENT,yytext()); }
(0|[1-9][0-9]*)		{ return new Symbol(sym.ENTERO, Integer.parseInt(yytext())); }
\/\/.*					{  } //comentarios de linea
[^\n\r\t\ ]				{return new Symbol (sym.CARACTER,yytext());}
\r|\n					{  }
\ |\t|\f				{  }
[^]						{ throw new Error("Illegal character <"+yytext()+">"); }

