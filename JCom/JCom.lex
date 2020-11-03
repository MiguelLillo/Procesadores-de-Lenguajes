%%


%xstate LINEA, BLOQUE, DOCUMENTACION, NADA
%%
\"			{
				yybegin(NADA);
		}

\/\/		{
			yybegin(LINEA);
		}
\/\*\*	{
			yybegin(DOCUMENTACION);
		}
\/\*	{
			yybegin(BLOQUE);
		}


.|\n	{}


<LINEA>{
[^\n\t\r ]+	{

				return new Yytoken(Yytoken.LINEA,yytext());
			}
\n			{
				yybegin(YYINITIAL);
			}
.			{}


}
<NADA>{
\"		{
			yybegin(YYINITIAL);
		}
.|\n	{}
}
<DOCUMENTACION>{
[^ \t\r\n]	{
				return new Yytoken(Yytoken.DOC,yytext());
			}
\*\/	{
			yybegin(YYINITIAL);
		}
.|\n	{}

}
<BLOQUE>{
[^ \t\r\n]	{
				return new Yytoken(Yytoken.BLOQUE,yytext());
			}
\*\/	{
			yybegin(YYINITIAL);
		}
.|\n		{}


}
