package ast.i;

import ast.i.Instruccion;
import java.util.ArrayDeque;

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
}
