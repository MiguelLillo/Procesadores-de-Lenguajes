import java.io.IOException;
import java.io.FileReader;

public class JCom {

	static int nLinea=0;	//10
	static int nBloque=0;	//128
	static int nDoc=0;	//127

	public static void linea(int n){
		nLinea+=n;
	}
	public static void bloque(int n){
		nBloque+=n;
	}
	public static void doc(int n){
		nDoc+=n;
	}
/**
Esto es para documentar. 23
*/

/* Esto es un bloque. 17 

*/
	public static void main(String arg[]) {
		if (arg.length>0) {
			try {
				Yylex lex = new Yylex(new FileReader(arg[0]));
				Yytoken yytoken = null;
				while ((yytoken = lex.yylex()) != null  ){

					if(yytoken.getToken()==128){ //palabra

						bloque(yytoken.getLength());

					}else if(yytoken.getToken()==10){

						linea(yytoken.getLength());

					}else if(yytoken.getToken()==127){
						doc(yytoken.getLength());
					}
				}
				System.out.println("//"+"\t"+nLinea);
				System.out.println("/*"+"\t"+nBloque);
				System.out.println("/**"+"\t"+nDoc);
			} catch (IOException e) {
			}
		}
	}
}
