package ast;

import ast.i.Instruccion;
import java.util.ArrayDeque;

public class Cabecera {
    private ArrayDeque<Instruccion> instrucciones;
    
    public Cabecera() {
        this.instrucciones = new ArrayDeque();
    }
    
    public Cabecera(ArrayDeque<Instruccion> instrucciones) {
        this.instrucciones = instrucciones;
    }
    
    public void addInstr(Instruccion instruccion) {
        instrucciones.add(instruccion);
    }
    
    public String toString() {
        String s = "{{_Cabecera_}{";
        for(Instruccion inst: instrucciones) {
            s += inst.toString();
        }
        s += '}';
        return s;
    }
    
}
