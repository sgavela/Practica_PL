package ast.i;

import ast.t.Tipo;

public class InstruccionReservaMemoria extends Instruccion {
    private Tipo tipo;
    private int tam;
    
    public InstruccionReservaMemoria(Tipo tipo, int tam) {
        this.tipo = tipo;
        this.tam = tam;
    }
    
    public TipoInstruccion getTipo() {
        return TipoInstruccion.RESMEM;
    }
    
    public String toString() {
        String s = "{{_Reserva_}{" + tipo + ',' + tam + "}}";
        return s;
    }
}
