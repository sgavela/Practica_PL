package ast.i;

import ast.e.Id;
import ast.t.Tipo_Id;
import java.util.ArrayDeque;

public class InstruccionDeclStruct extends Instruccion {
    private Id id;
    private ArrayDeque<Tipo_Id> campos;
    
    public InstruccionDeclStruct(Id id, ArrayDeque<Tipo_Id> campos) {
        this.id = id;
        this.campos = campos;
    }
    
    public TipoInstruccion getTipo() {
        return TipoInstruccion.DECLSTRUCT;
    }
    
    public String toString() {
        String s = "{{Struct}{";
        for(Tipo_Id t_i: campos) {
            s += t_i.getTipo().toString() + ' ' + t_i.getNombre().toString() + ',';
        }
        s = s.substring(0,s.length()-1);
        s += "}}";
        return s;
    }
}
