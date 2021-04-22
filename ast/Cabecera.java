package ast;

import ast.i.Instruccion;
import java.util.ArrayDeque;
import java.util.ArrayList;

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
