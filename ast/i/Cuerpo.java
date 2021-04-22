package ast.i;

import ast.i.Instruccion;
import java.util.ArrayDeque;
import java.util.ArrayList;

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

    public String toString(int prof, ArrayList<Boolean> niveles) {
        String s = "";
        for(Instruccion inst: instrucciones) {
            s += inst.toString();
        }
        return s;
    }
}
