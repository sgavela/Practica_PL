package ast.e;

import ast.t.Tipo;
import java.util.ArrayList;
import java.util.ArrayDeque;

public class ListIndex extends Expresion {
    private Id id;
    private ArrayDeque<Expresion> idx;
    private Tipo tipoLista;
    
    public ListIndex(Id id, ArrayDeque<Expresion> idx) {
        this.id = id;
        this.idx = idx;
        this.tipoLista = null;
    }
    
    public ListIndex(Id id, ArrayDeque<Expresion> idx, Tipo tipoLista) {
        this.id = id;
        this.idx = idx;
        this.tipoLista = tipoLista;
    }
    
    public String toString() {
        String s = id.toString() + idx.toString();
        return s;
    }

    public String toString(int prof, ArrayList<Boolean> niveles) {
        String s = id.toString() + idx.toString();
        return s;
    }

    @Override
    public Expresiones tipo() {
        return Expresiones.ID;
    }
    
}
