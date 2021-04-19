package ast.i;

import ast.e.*;
import ast.e.Expresion;
import ast.i.Instruccion;
import ast.i.TipoInstruccion;
import ast.t.Tipo;
import ast.t.Tipo_Id;
import java.util.ArrayDeque;

public class InstruccionLlamadaFuncion extends Expresion {
    private Id id;
    private ArrayDeque<Tipo_Id> argumentos;
    private Tipo tipo;
    
   public InstruccionLlamadaFuncion(Id id, ArrayDeque<Tipo_Id> argumentos, Tipo tipo) {
       this.id = id;
       this.argumentos = argumentos;
       this.tipo = tipo;
   }
   
   public InstruccionLlamadaFuncion(Id id, ArrayDeque<Tipo_Id> argumentos) {
       this.id = id;
       this.argumentos = argumentos;
       this.tipo = null;
   }
   
   public Expresiones tipo() {
       return Expresiones.LLAMFUN;
   }
   
   public String toString() {
       String s = "{{_LlamadaFunc_}{" + id.toString() + ',' + '{';
       for(Tipo_Id arg: argumentos) {
           s += arg.getNombre().toString() + ',';
       }
       s = s.substring(0, s.length()-1);
       s += "}}}";
       return s;
   }
    
}
