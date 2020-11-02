%%

%%
[a-zA-Z]*[aeiou][aeiou]+([a-zA-Z]*[aeiou])?/[,.-?¿!;:\n\t ]+	{
																return new Yytoken(Yytoken.A,yytext());
															}
[a-zA-Z]*[aeiou]/[,.-?¿!\n\t ]+					{
														return new Yytoken(Yytoken.B,yytext());
												}
[a-zA-Z]*[aeiou][aeiou]+[a-zA-Z]*/[,.-?¿!\n\t ]+	{
													return new Yytoken(Yytoken.C,yytext());
												}
[a-zA-Z]+/[,.-?¿!\n\t ]+						{
													return new Yytoken(Yytoken.D,yytext());
												}
.|\n	{}
