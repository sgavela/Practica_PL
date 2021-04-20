package ast.i;

import ast.e.Id;
import ast.t.Tipo_Id;
import java.util.ArrayDeque;

public class InstruccionDeclStruct extends Instruccion {
    private Id id;
    private ArrayDeque<Instruccion> declaraciones;
    
    public InstruccionDeclStruct(Id id, ArrayDeque<Instruccion> declaraciones) {
        this.id = id;
        this.declaraciones = declaraciones;
    }
    
    public TipoInstruccion getTipo() {
        return TipoInstruccion.DECLSTRUCT;
    }
    
    public String toString() {
        String aux = "{{_Stru__}";
        
        for(Instruccion declaracion : declaraciones) {
            aux += declaracion.toString();
        }
        aux += "}";
        
        return aux;
    }
}
