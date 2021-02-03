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
	public final static int DECL=	112;
	public final static int DECLSIMP=	113;
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
		case SUMA:	PLXC.out.println(res+"="+arg1+"+"+arg2+";");
					break;
		case RESTA:	PLXC.out.println(res+"="+arg1+"-"+arg2+";");
					break;
		case MULT:	PLXC.out.println(res+"="+arg1+"*"+arg2+";");
					break;			
		case DIV:	PLXC.out.println(res+"="+arg1+"/"+arg2+";");
					break;			
		case MOD:	PLXC.out.println(res+"="+arg1+"%"+arg2+";");
					break;			
		case IFMENOR:PLXC.out.println("if ("+arg1+"<"+arg2+") goto "+res+";");
					break;			
		case IFIGUAL:PLXC.out.println("if ("+arg1+"=="+arg2+") goto "+res+";");
					break;			
		case GOTO:	PLXC.out.println("goto "+res+";");
					break;			
		case PRINT:	PLXC.out.println("print "+res+";");
					break;			
		case LABEL:	PLXC.out.println(res+":");
					break;			
		case ASIG:	PLXC.out.println(res+"="+arg1+";");
					break;
		default:	PLXC.out.println("error");
			
		}
	}








}
