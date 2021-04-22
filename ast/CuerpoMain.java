package ast;

import ast.i.Instruccion;
import java.util.ArrayDeque;
import java.util.ArrayList;

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
