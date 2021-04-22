package ast.i;

import ast.e.*;
import ast.e.Expresion;
import ast.i.Instruccion;
import ast.i.TipoInstruccion;
import ast.t.Tipo;
import ast.t.Tipo_Id;

import java.beans.Expression;
import java.util.ArrayDeque;
import java.util.ArrayList;

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
   
   public String toString(int prof, ArrayList<Boolean> niveles) {
       String s = "";
       String b_prof = "";
       if(niveles.size()==prof) niveles.add(true);
       else niveles.set(prof,true);
       for(int i=0; i<prof-1; ++i){
           if(niveles.get(i)) b_prof += '|';
           b_prof += "   ";
       }
       b_prof += '|';
       s += b_prof +  "---{Llamada funcion}\n";
       if(niveles.size()==prof+1) niveles.add(false);
       else niveles.set(prof+1,false);
       s += b_prof + "   |---Identificador: " + id.toString(prof+1,niveles) + '\n';
       for(Expresion arg: argumentos) {
           s += b_prof + "   |---Argumento: " + arg.toString(prof+1,niveles) + '\n';
       }
       niveles.set(prof,false);
       return s;
   }
    
}
