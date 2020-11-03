public class Yytoken {

	public final static int DOC = 127;
    public final static int BLOQUE = 128;
    public final static int LINEA = 10;

    private int token;
    private String lexema;

    public Yytoken(int token, String lexema) {
         this.token = token;
         this.lexema = lexema;
    }

    public int getToken()  {
         return token;
    }

    public String getLexema() {
         return lexema;
    }
	public int getLength(){
		return lexema.length();
	}

    public String toString() {
         return "<"+token+","+lexema+">";
    }
}
