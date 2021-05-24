package ast;

import ast.i.Instruccion;
import generador_codigo.GeneradorCodigo;

import java.util.ArrayDeque;
import java.util.ArrayList;
import asem.TablaSimbolos;
import java.util.Iterator;

public class Cabecera {
    private ArrayDeque<Instruccion> instrucciones;
    
    public Cabecera() {
        this.instrucciones = new ArrayDeque();
    }
    
    public Cabecera(ArrayDeque<Instruccion> instrucciones) {
        this.instrucciones = instrucciones;
    }
    
    public void addInstr(Instruccion instruccion) {
        instrucciones.addFirst(instruccion);
    }

    public int vinculacion(TablaSimbolos ts){
        Iterator<Instruccion> instruccionesIt = instrucciones.iterator();
        int errores = 0;
 
        while(instruccionesIt.hasNext()){
            Instruccion ins = instruccionesIt.next();
            errores += ins.vinculacion(ts);
        }
        
        return errores;
    }
    
    public int chequea(){
        int errores = 0;
        Iterator<Instruccion> instruccionesIt = instrucciones.iterator();

        while(instruccionesIt.hasNext()){
            Instruccion ins = instruccionesIt.next();
            errores += ins.chequea();
        }
        return errores;
    }

    public String genera_codigo(GeneradorCodigo gc) {
        String s = "";
        Iterator<Instruccion> instruccionesIt = instrucciones.iterator();
        while(instruccionesIt.hasNext()){
            Instruccion ins = instruccionesIt.next();
            s += gc.generaCodigo(ins);
        }
        return s;
    }
    
    public String toString(int prof, ArrayList<Boolean> niveles) {
        String s = "|---{Cabecera}\n";
        niveles.add(true);
        for(Instruccion inst: instrucciones) {
            s += inst.toString(prof+1, niveles);
        }
        niveles.set(1,false);
        return s;
    }
    
}
