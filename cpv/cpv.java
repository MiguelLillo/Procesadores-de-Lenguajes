import java.io.IOException;
import java.io.FileReader;

public class cpv {
    /**
     * Llama al analizador sintactico, usando el nombre del fichero que se le pasa como
     * primer argumento, si no se le pasa ningun argumento usa la entrada estandar.
     */
    static int nA=0;
    static int nB=0;
    static int nC=0;
    static int nD=0;
	private static void A(){
		nA++;
	}
	private static void B(){
		nB++;
	}
	private static void C(){
		nC++;
	}
	private static void D(){
		nD++;
	}
     
    public static void main(String arg[]) {
        Yylex lex = null; 
        try {
            if (arg.length>0) {
                lex = new Yylex(new FileReader(arg[0]));
            } else {
                throw new IOException("No se ha encontrado la entrada");
                //lex = new Yylex(System.in);
            }
			if (lex!=null) {
				Yytoken yytoken = null;
				while ((yytoken = lex.yylex()) != null  ) {
					if(yytoken.getToken()==Yytoken.A){
						A();
					}
					if(yytoken.getToken()==Yytoken.B){
						B();
					}
					if(yytoken.getToken()==Yytoken.C){
						C();
					}
					if(yytoken.getToken()==Yytoken.D){
						D();
					}
				}
				System.out.println("A "+nA);
				System.out.println("B "+nB);
				System.out.println("C "+nC);
				System.out.println("D "+nD);
			}
        } catch (IOException e) {
            System.out.println("Error al abrir el fichero de entrada");            
        }
    }
}
