package ast;

import ast.i.Instruccion;
import java.util.ArrayDeque;

public class CuerpoMain {
    private ArrayDeque<Instruccion> instrucciones;
    
    public CuerpoMain() {
        instrucciones = new ArrayDeque();
    }
    
    public CuerpoMain(ArrayDeque<Instruccion> instrucciones) {
        this.instrucciones = instrucciones;
    }
    
    public void addInstr(Instruccion instr) {
        instrucciones.add(instr);
    }
    
    public String toString() {
        String s = "{{_Main_}{";
        for(Instruccion inst: instrucciones) {
            s += inst.toString();
        }
        s += '}';
        return s;
    }
}
