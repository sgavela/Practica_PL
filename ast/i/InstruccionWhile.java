package ast.i;

import ast.e.Expresion;

public class InstruccionWhile extends Instruccion {
    private Expresion condicion;
    private Cuerpo cuerpo_while;
    
    public InstruccionWhile(Expresion condicion, Cuerpo cuerpo_while) {
        this.condicion = condicion;
        this.cuerpo_while = cuerpo_while;
    }
    
    public TipoInstruccion getTipo() {
        return TipoInstruccion.WHILE;
    }
    
    public String toString() {
        String s = "{{ While }{" + condicion.toString() + "}{";
        for(Instruccion inst: cuerpo_while.getInstr()) {
            s += inst.toString();
        }
        s += "}}";
        return s;
    }
    
}
