class DobleEtiq{
	String v;
	String f;
	public DobleEtiq(){
		v=Gen.nuevaEtiqueta();
		f=Gen.nuevaEtiqueta();
	}/*
	*no hacer mal uso del constructor de abajo 
	* Se ha hecho para poder intercambiar las etiquetas facilmente
	*/
	public DobleEtiq(String v,String f){
		this.v=v;					
		this.f=f;
	}
	public String v(){
		return v;
	}
	public String f(){
		return f;
	}
}
