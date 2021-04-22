package ast.i;

import ast.t.Tipo;
import java.util.ArrayList;

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
    
    public String toString(int prof, ArrayList<Boolean> niveles) {
        String s = "{{_Reserva_}{" + tipo + ',' + tam + "}}";
        return s;
    }
}
