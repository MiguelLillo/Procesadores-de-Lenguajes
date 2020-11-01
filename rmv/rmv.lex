
%%
%int
%{
private String nVar="";
private StringBuilder aux=new StringBuilder("");
private char estadoAnt;
public static class Debug{
	public static void print(String s){
	//	System.out.println("Debug:"+ s);
	}
}
%}

%xstate DEFVAR, COMILLAS, ESCAPE,COMILLAS2
%%
[a-zA-Z_][a-zA-Z0-9_]*\=	{
								Debug.print("INITIAL_1");
								nVar=yytext().substring(0,yylength()-1);
								yybegin(DEFVAR);

							}
\$[a-zA-Z_][a-zA-Z0-9_]*	{
								Debug.print("INITIAL_2");
								System.out.print(TablaSimbolos.get(yytext().substring(0,yylength())));
							}

.|\n						{
								Debug.print("INITIAL_3");
								System.out.print(yytext());
							}
<DEFVAR>{
\$[a-zA-Z_][a-zA-Z0-9_]*	{
								Debug.print("DEFVAR_1");
								Debug.print("Definimos la variable "+nVar+" con el contenido "+ yytext());
								aux.append(TablaSimbolos.get(yytext()));
							}

[^\$\t\n\r\;\" \\]+			{
								Debug.print("DEFVAR_2");
								aux.append(yytext());
							}
[\t\n\r\; ]					{
								Debug.print("DEFVAR_3");
								TablaSimbolos.put(nVar,aux.toString());
								nVar="";
								aux=new StringBuilder("");
								yybegin(YYINITIAL);
							}
\"							{
Debug.print("DEFVAR_4");
								yybegin(COMILLAS);
							}
\\							{
								Debug.print("DEFVAR_5");
								estadoAnt='d';
								yybegin(ESCAPE);
							}
}
<COMILLAS>{
\$[a-zA-Z_][a-zA-Z0-9_]*	{
								Debug.print("COMILLAS_1");
								Debug.print("Definimos la variable "+nVar+"con el contenido"+ yytext());
								aux.append(TablaSimbolos.get(yytext()));

							}
[^\"\$\\]+					{
								Debug.print("COMILLAS_2");
								aux.append(yytext());
							}
\"\;?						{
					Debug.print("COMILLAS_3");
								TablaSimbolos.put(nVar,aux.toString());
								nVar="";
								aux=new StringBuilder("");
								yybegin(YYINITIAL);
							}
\\							{
								Debug.print("COMILLAS_4");
								estadoAnt='c';
								yybegin(ESCAPE);
							}

}
<ESCAPE>{
[\;\"\$]					{
								aux.append("\\"+yytext());
								if(estadoAnt=='c'){
									yybegin(COMILLAS);
								}else if(estadoAnt=='d'){
									yybegin(DEFVAR);
								}

							}

}
