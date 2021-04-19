package ast.i;

import ast.e.Expresion;
import ast.e.Id;

public class InstruccionFor extends Instruccion {
    private Id id;
    private Expresion valor_ini;
    private Expresion condicion;
    private Expresion paso;
    private Cuerpo cuerpo_for;
    
    public InstruccionFor(Id id, Expresion valor_ini, Expresion condicion, Expresion paso, Cuerpo cuerpo_for) {
        this.id = id;
        this.valor_ini = valor_ini;
        this.condicion = condicion;
        this.paso = paso;
        this.cuerpo_for = cuerpo_for;
    }
    
    public TipoInstruccion getTipo() {
        return TipoInstruccion.FOR;
    }
    
    public String toString(){
        String s = "{{_For_}{" + valor_ini.toString() + ';' + condicion.toString() + ';' + paso.toString() + "}{";
        for(Instruccion inst: cuerpo_for.getInstr()) {
            s += inst.toString();
        }
        s += "}}";
        return s;
    }
}
