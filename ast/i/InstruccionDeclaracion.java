package ast.i;

import ast.e.Expresion;
import ast.e.Id;
import ast.t.Tipo;

public class InstruccionDeclaracion extends Instruccion {
    private Tipo tipo;
    private Id id;
    private Expresion valor;
    
    public InstruccionDeclaracion(Tipo tipo, Id id) {
        this.tipo = tipo;
        this.id = id;
        this.valor = null;
    }
    
     public InstruccionDeclaracion(Tipo tipo, Id id, Expresion valor) {
        this.tipo = tipo;
        this.id = id;
        this.valor = valor;
    }
     
     public TipoInstruccion getTipo() {
         return TipoInstruccion.DECL;
     }
     
     public String toString() {
         String s = "{{_Declaracion_}{" + tipo.toString() + ',' + id.toString();
         if(valor != null) {
             s += ',' + valor.toString();
         }
         s += "}}";
         return s;
     }
    
}
