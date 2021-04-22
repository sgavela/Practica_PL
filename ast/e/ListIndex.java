package ast.e;

import ast.t.Tipo;
import java.util.ArrayList;

public class ListIndex extends Expresion {
    private Id id;
    private Expresion idx;
    private Tipo tipoLista;
    
    public ListIndex(Id id, Expresion idx) {
        this.id = id;
        this.idx = idx;
        this.tipoLista = null;
    }
    
    public ListIndex(Id id, Expresion idx, Tipo tipoLista) {
        this.id = id;
        this.idx = idx;
        this.tipoLista = tipoLista;
    }
    
    public String toString() {
        String s = id.toString() + '[' + idx.toString() + ']';
        return s;
    }

    public String toString(int prof, ArrayList<Boolean> niveles) {
        String s = id.toString() + '[' + idx.toString() + ']';
        return s;
    }

    @Override
    public Expresiones tipo() {
        return Expresiones.ID;
    }
    
}
