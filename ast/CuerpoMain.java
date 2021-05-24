package ast;

import ast.i.Instruccion;
import generador_codigo.GeneradorCodigo;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import asem.TablaSimbolos;

public class CuerpoMain {
    private ArrayDeque<Instruccion> instrucciones;
    
    public CuerpoMain() {
        instrucciones = new ArrayDeque();
    }
    
    public CuerpoMain(ArrayDeque<Instruccion> instrucciones) {
        this.instrucciones = instrucciones;
    }
    
    public void addInstr(Instruccion instr) {
        instrucciones.addFirst(instr);
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
        String s = "|---{Main}\n";
        niveles.set(1,true);
        for(Instruccion inst: instrucciones) {
            s += inst.toString(prof+1,niveles);
        }
        niveles.set(1,false);
        return s;
    }
}
