package ast.e;

import ast.e.Expresion;
import ast.i.Instruccion;
import ast.i.TipoInstruccion;
import ast.t.Tipo;
import ast.t.Tipo_Id;
import java.util.ArrayDeque;

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
   
   public String toString() {
       String s = "{{_LlamadaFunc_}{" + id.toString() + ',' + '{';
       for(Expresion arg: argumentos) {
           s += arg.toString() + ',';
       }
       s = s.substring(0, s.length()-1);
       s += "}}}";
       return s;
   }
    
}