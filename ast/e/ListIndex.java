package ast.e;

import ast.t.Tipo;
import java.util.ArrayList;
import java.util.ArrayDeque;
import asem.TablaSimbolos;
import errors.ExcepcionTipoDesconocido;
import asem.ExcepcionIdNoExistente;
import ast.getTipoVinculo;

public class ListIndex extends Expresion {
    private Id id;
    private Expresion idx;
    private Tipo tipoLista;
    private Object vinculoId;
    
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

    public int vinculacion(TablaSimbolos ts){
        int errores = 0;
        try {
            vinculoId = ts.buscaId(id.getS());
        } catch (ExcepcionIdNoExistente e) {
            errores = 1;
            System.err.println("El identificador "  + " no existe");
        }
        return errores;
    }

    public int chequea(){
        try {
            tipoLista = (new getTipoVinculo(vinculoId)).getTipo();            
            return 0;
        } catch (ExcepcionTipoDesconocido e) {
            System.err.println("Error en la comprobacion de tipo del vinculo " 
                    + " del identificador " );
            return 1;
        }
    }
    
    public Tipo getTipo(){
        return tipoLista;
    }
    
    public String toString() {
        String s = id.toString() + idx.toString();
        return s;
    }

    public String toString(int prof, ArrayList<Boolean> niveles) {
        String s = id.toString() + "[" + idx.toString() + "]";
        return s;
    }

    @Override
    public Expresiones tipo() {
        return Expresiones.ID;
    }
    
}
