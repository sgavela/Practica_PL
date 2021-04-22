package ast.e;

import ast.e.Expresion;
import ast.i.Instruccion;
import ast.i.TipoInstruccion;
import ast.t.Tipo;
import ast.t.Tipo_Id;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class ExpresionLlamadaFuncion extends Expresion {
    private Id id;
    private ArrayDeque<Expresion> argumentos;
    private Tipo tipo;
    
   public ExpresionLlamadaFuncion(Id id, ArrayDeque<Expresion> argumentos) {
       this.id = id;
       this.argumentos = argumentos;
   }
   
   public Expresiones tipo() {
       return Expresiones.LLAMFUN;
   }
   
   public String toString(int prof, ArrayList<Boolean> niveles) {
    String s = "Llamada funcion\n";
    String b_prof = "";
    if(niveles.size()==prof) niveles.add(true);
    else niveles.set(prof,true);
    for(int i=0; i<prof-1; ++i){
        if(niveles.get(i)) b_prof += '|';
        b_prof += "   ";
    }
    if(niveles.size()==prof+1) niveles.add(false);
    else niveles.set(prof+1,false);
    b_prof += '|';
    s += b_prof + "   |---Identificador: " + id.toString(prof+1,niveles) + '\n';
    for(Expresion arg: argumentos) {
        s += b_prof + "   |---Argumento: " + arg.toString(prof+1,niveles) + '\n';
    }
    s = s.substring(0, s.length()-1);
    niveles.set(prof,false);
    return s;
   }
    
}