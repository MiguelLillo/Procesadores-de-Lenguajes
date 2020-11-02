public class Yytoken {
    public final static int A = 257;
    public final static int B = 258;
    public final static int C = 259;
    public final static int D = 260;
    public final static int TOKEN_ERROR = 261;

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

    public String toString() {
         return "<"+token+","+lexema+">";
    }
}
