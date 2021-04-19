package ast.i;

import ast.e.Expresion;
import java.util.HashMap;
import java.util.List;

public class InstruccionSwitch extends Instruccion {
    private Expresion exp_caso;
    private HashMap<Expresion, Cuerpo> casos;
    private Cuerpo cuerpo_default;
    
    public InstruccionSwitch(Expresion exp_caso, HashMap<Expresion, Cuerpo> casos, Cuerpo cuerpo_default) {
        this.exp_caso = exp_caso;
        this.casos = casos;
        this.cuerpo_default = cuerpo_default;
    }
    
    public TipoInstruccion getTipo() {
        return TipoInstruccion.SWITCH;
    }
    
    public String toString() {
        String s = "{{_Switch_}{" + exp_caso.toString() + "}{";
        for(Expresion exp: casos.keySet()) {
            s += "{_Caso_}{" + exp.toString() + "}{";
            for(Instruccion inst: casos.get(exp).getInstr()) {
                s += inst.toString();
            }
            s += "}";
        }
        s += "{_Default_}{";
        for(Instruccion inst: cuerpo_default.getInstr()) {
            s += inst.toString();
        }
        s += "}}";
        return s;
    }
    
}
