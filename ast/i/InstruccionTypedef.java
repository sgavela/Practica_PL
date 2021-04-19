package ast.i;

import ast.e.Id;
import ast.t.Tipo;

public class InstruccionTypedef extends Instruccion {
    private Tipo tipo;
    private Id alias;
    
    public InstruccionTypedef(Tipo tipo, Id alias) {
        this.tipo = tipo;
        this.alias = alias;
    }
    
    public TipoInstruccion getTipo() {
        return TipoInstruccion.TYPEDEF;
    }
    
    public String toString() {
        String s = "{{_Typedef_}{" + tipo.toString() + ',' + alias.toString() + "}}";
        return s;
    }
}
