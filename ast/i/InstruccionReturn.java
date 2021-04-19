package ast.i;

import ast.e.Expresion;

public class InstruccionReturn extends Instruccion {
    private Expresion e;
    
    public InstruccionReturn(Expresion e) {
        this.e = e;
    }
    
    public TipoInstruccion getTipo() {
        return TipoInstruccion.RETURN;
    }
    
    public String toString() {
        String s = "{{_Return_}{" + e.toString() + "}}";
        return s;
    }
}
