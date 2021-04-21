package ast.i;

import ast.e.*;
import ast.e.Expresion;
import ast.i.Instruccion;
import ast.i.TipoInstruccion;
import ast.t.Tipo;
import ast.t.Tipo_Id;

import java.beans.Expression;
import java.util.ArrayDeque;

public class InstruccionLlamadaFuncion extends Instruccion {
    private Id id;
    private ArrayDeque<Expresion> argumentos;
    private Tipo tipo;
    
   public InstruccionLlamadaFuncion(Id id, ArrayDeque<Expresion> argumentos, Tipo tipo) {
       this.id = id;
       this.argumentos = argumentos;
       this.tipo = tipo;
   }
   
   public InstruccionLlamadaFuncion(Id id, ArrayDeque<Expresion> argumentos) {
       this.id = id;
       this.argumentos = argumentos;
       this.tipo = null;
   }
   
   public TipoInstruccion getTipo() {
       return TipoInstruccion.LLAMFUN;
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
