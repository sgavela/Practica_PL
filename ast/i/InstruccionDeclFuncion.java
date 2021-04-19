package ast.i;

import ast.e.Id;
import ast.t.Tipo;
import ast.t.Tipo_Id;
import java.util.ArrayDeque;

public class InstruccionDeclFuncion extends Instruccion {
    private Tipo tipo;
    private Id id;
    private ArrayDeque<Tipo_Id> argumentos;
    private Cuerpo cuerpo;
    
    public InstruccionDeclFuncion(Tipo tipo, Id id, ArrayDeque<Tipo_Id> argumentos, Cuerpo cuerpo) {
        this.tipo = tipo;
        this.id = id;
        this.argumentos = argumentos;
        this.cuerpo = cuerpo;
    }
    
    public TipoInstruccion getTipo() {
        return TipoInstruccion.DECLFUN;
    }
    
    public String toString() {
        String s = "{{_fun_}{";
        for(Tipo_Id arg: argumentos){
            s += arg.getTipo().toString() + ' ' + arg.getNombre().toString() + ',';
        }
        s = s.substring(0, s.length()-1);
        s += "}{" + tipo.toString() + "}{";
        for(Instruccion inst: cuerpo.getInstr()) {
            s += inst.toString();
        }
        s += "}}";
        return s;
    }
    
}
