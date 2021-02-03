import java.io.FileReader;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.InputStreamReader;
import java.io.Reader;

import javax.swing.text.TabableView;

public class PLXC {

	public static PrintStream out;

	public static void main(String arg[]) {
		Yylex lex = null;
		try {
			Reader in = new InputStreamReader(System.in);
			out = System.out;
		if (arg.length>0) {
			in = new FileReader(arg[0]);
		}
		if (arg.length>1) {
			out = new PrintStream(new FileOutputStream(arg[1]));
		}
		parser p = new parser(new Yylex(in));
		Object result = p.parse().value;
		} catch (Exception e) {
			PLXC.out.print(e.getMessage());
			//e.printstacktrace()
		}
		/*if(arg[1].equals("-d")){

			TablaSimbolos.mostrar();
		}*/

	}
}
