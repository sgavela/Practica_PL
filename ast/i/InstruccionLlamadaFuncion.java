package ast.i;

import ast.e.*;
import ast.e.Expresion;
import ast.i.Instruccion;
import ast.i.TipoInstruccion;
import ast.i.InstruccionDeclFuncion;
import ast.t.Tipo;
import ast.t.Tipo_Id;
import asem.TablaSimbolos;
import asem.ExcepcionIdNoExistente;

import java.beans.Expression;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;

public class InstruccionLlamadaFuncion extends Instruccion {
    private Id id;
    private ArrayDeque<Expresion> argumentos;
    private Tipo tipo;

    private Object vinculo;
    private ArrayDeque<Tipo_Id> vinculoArgumentos;
    
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

   public int vinculacion(TablaSimbolos ts){
        int errores = 0;
        try {
            vinculo = ts.buscaId(id.toString());
            InstruccionDeclFuncion vinculoFuncion = (InstruccionDeclFuncion) vinculo;
            vinculoArgumentos = vinculoFuncion.getArgumentos();

            if (argumentos.size() != vinculoArgumentos.size()) {
                errores += 1;
                System.err.println("Error de tipos. El numero de argumentos del procedimiento "
                        + id + " es " + vinculoArgumentos.size() + " pero en la llamada hay "+ 
                        argumentos.size() + " argumentos.");
            } 
            for(Expresion arg : argumentos){
                errores += arg.vinculacion(ts);
            }
        } catch (ExcepcionIdNoExistente e) {
            errores += 1;
            System.err.println("Error en la fila "+ ". La función " + id + " no existe");
        }
        return errores;
   }

   public int chequea(){
       InstruccionDeclFuncion vinculoFuncion = (InstruccionDeclFuncion) vinculo;
       this.tipo = vinculoFuncion.getTipo();
       
       int errores = 0;
       Iterator<Tipo_Id> vinculoArgumentosIt = vinculoArgumentos.iterator();
       int i = 0;
       for(Expresion exp : argumentos){
            Tipo_Id arg = vinculoArgumentosIt.next();
            errores += exp.chequea();
            Tipo tipoExpr = exp.getTipo();
            Tipo tipoArg = arg.getTipo();
            if (!tipoExpr.equals(tipoArg)) {
                errores += 1;
                System.err.println("Error de tipos. El argumento numero " + i + " de la funcion "
                        + id.toString() + " es de tipo " +
                        arg.getTipo().toString() + " pero se ha introducido una expresion de tipo " +
                        tipoExpr.toString());
            }
       }
       return errores;
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
