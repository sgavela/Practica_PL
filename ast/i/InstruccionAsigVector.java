package ast.i;

import ast.e.Expresion;
import ast.e.Id;
import java.util.ArrayList;
import java.util.ArrayDeque;

public class InstruccionAsigVector extends Instruccion {
    private Id id;
    private ArrayDeque<Expresion> valores;
    
    public InstruccionAsigVector(Id id, ArrayDeque<Expresion> valores) {
        this.id = id;
        this.valores = valores;
    }
    
    public TipoInstruccion getTipo() {
        return TipoInstruccion.ASIG;
    }

    public Id getId() {
        return this.id;
    }
    
    public ArrayDeque<Expresion> getValores() {
        return this.valores;
    }
    
    public String toString(int prof, ArrayList<Boolean> niveles) {
        String s = "";
        String b_prof = "";
        if(niveles.size() == prof) niveles.add(true);
        else niveles.set(prof,true);
        for(int i=0; i<prof-1; ++i){
            if(niveles.get(i)) b_prof += '|';
            b_prof += "   ";
        }
        b_prof += '|';
        s += b_prof + "---" +  "{Asignacion vector}\n";
        s += b_prof + "   |---Identificador: " + id.toString() + '\n';
        if(niveles.size() == prof+1) niveles.add(true);
        else niveles.set(prof+1,true);
        if(valores != null) {
            s += b_prof + "   |---Valor:\n";
            for(Expresion v: valores) {
                s += b_prof + "   |   |---Elemento: " + v.toString(prof+2,niveles) + '\n';
            }
        }
        niveles.set(prof+1,false);
        niveles.set(prof,false);
        return s;
     }
    
}
