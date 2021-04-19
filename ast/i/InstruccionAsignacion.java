package ast.i;

import ast.e.Expresion;
import ast.e.Id;

public class InstruccionAsignacion extends Instruccion {
    private Id identificador;
    private Expresion valor;
    
    public InstruccionAsignacion(Id identificador, Expresion valor) {
        this.identificador = identificador;
        this.valor = valor;
    }
    
    public TipoInstruccion getTipo() {
        return TipoInstruccion.ASIG;
    }
    
    public String toString() {
        String s = "{{_Asignacion_}{" + identificador.toString() + ',' + valor.toString() + "}}";
        return s;
    }
    
}
