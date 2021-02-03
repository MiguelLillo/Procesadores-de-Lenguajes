import java.security.KeyStore.Entry;
import java.util.*;
public class TablaSimbolos{

    private static Stack<HashMap<String, String>> ts=new Stack<HashMap<String, String>>();
    
    public static void nuevoNivel(){
        ts.push(new HashMap<String, String>());
    }
    public static void bajarNivel(){
        try{
            ts.pop();
        }catch(EmptyStackException e){
            System.out.println("No ha sido posible bajar más de nivel");
        }
    }
    public static  void addSimbolo(String nombre,String tipo )throws RuntimeException{
        Map<String, String> current= ts.peek();
        TablaSimbolos.buscarEnAmbito(nombre);

        current.put(nombre, tipo);
        /*for(String k: ts.peek().keySet()){
            System.out.println(k+": "+ts.peek().get(k));
        }*/

    }
    
    public static void buscarEnAmbito(String nombre){
        if(ts.peek().get(nombre)!=null){
            throw new RuntimeException("error;\n Variable ya declarada");
        }

    }
    public static  String buscarSimbolo(String nombre) throws RuntimeException{
        String res=null;
        if(!ts.empty()){
            int indice=ts.size()-1;
            
            while (indice>=0 && res==null){
                //System.out.println("Buscando en "+indice);
                /*
                for(String k: ts.get(indice).keySet()){
                    System.out.println(k+": "+ts.get(indice).get(k));
                }
                */
                res=ts.get(indice).get(nombre);
                indice--;
            }
            if(res==null){
                throw new RuntimeException("#error; \nVariable no declarada");
            }
        }
        //TablaSimbolos.mostrar();
        return res;
    }
    public static void mostrar(){
        String res=null;
        int indice=ts.size()-1;
            
        while (indice>=0 && res==null){ //recorrer pila
            System.out.println("Nivel "+indice);



            for(String k: ts.get(indice).keySet()){
                System.out.println(k+": "+ts.get(indice).get(k));
            }
            indice--;
        }

    }
    //metodo peek
//emptyStackException
}