/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ast.e;

import ast.t.Tipo;

/**
 *
 * @author Usuario
 */
public class ListIndex extends Expresion {
    private Id id;
    private Expresion idx;
    private Tipo tipoLista;
    
    
    public ListIndex(Id id, Expresion idx, Tipo tipoLista) {
        this.id = id;
        this.idx = idx;
        this.tipoLista = tipoLista;
    }
    
    public String toString() {
        String s = id.toString() + '[' + idx.toString() + ']';
        return s;
    }

    @Override
    public Expresiones tipo() {
        return Expresiones.ID;
    }
    
}
