package ast.i;

import ast.i.Instruccion;
import generador_codigo.Bloque;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import asem.TablaSimbolos;

public class Cuerpo {
	private ArrayDeque<Instruccion> instrucciones;
    
    public Cuerpo() {
        this.instrucciones = new ArrayDeque<Instruccion>();
    }
    
    public void addInstr(Instruccion inst) {
        this.instrucciones.addFirst(inst);
    }
    
    public ArrayDeque<Instruccion> getInstr() {
        return this.instrucciones;
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

    public String toString(int prof, ArrayList<Boolean> niveles) {
        String s = "";
        for(Instruccion inst: instrucciones) {
            s += inst.toString();
        }
        return s;
    }
}
