public class Gen{
	private static int temp=0;
	private static int eti=0;
	
	public final static int SUMA=	101;
	public final static int RESTA=	102;
	public final static int MULT=	103;
	public final static int DIV=		104;
	public final static int MOD=		105;
	public final static int IFMENOR=	106;
	public final static int IFIGUAL=	107;
	public final static int GOTO=	108;
	public final static int PRINT=	109;
	public final static int LABEL=	110;
	public final static int ASIG=	111;
	/*
	 *	para generar el nombre de una nueva variable
	 */
	public static String nuevaTemp(){
		temp++;
		return "t"+temp;
	}	
	public static String nuevaEtiqueta(){
		eti++;
		return "L"+eti;
	}
	public static void gc(int op,String arg1,String arg2,String res){
		switch(op){
		case SUMA:	PLC.out.println(res+"="+arg1+"+"+arg2+";");
					break;
		case RESTA:	PLC.out.println(res+"="+arg1+"-"+arg2+";");
					break;
		case MULT:	PLC.out.println(res+"="+arg1+"*"+arg2+";");
					break;			
		case DIV:	PLC.out.println(res+"="+arg1+"/"+arg2+";");
					break;			
		case MOD:	PLC.out.println(res+"="+arg1+"%"+arg2+";");
					break;			
		case IFMENOR:PLC.out.println("if ("+arg1+"<"+arg2+") goto "+res+";");
					break;			
		case IFIGUAL:PLC.out.println("if ("+arg1+"=="+arg2+") goto "+res+";");
					break;			
		case GOTO:	PLC.out.println("goto "+res+";");
					break;			
		case PRINT:	PLC.out.println("print "+res+";");
					break;			
		case LABEL:	PLC.out.println(res+":");
					break;			
		case ASIG:	PLC.out.println(res+"="+arg1+";");
					break;
		default:	PLC.out.println("error");
			
		}
	}








}
