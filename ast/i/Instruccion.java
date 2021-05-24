package ast.i;

import java.util.ArrayList;
import asem.TablaSimbolos;
import generador_codigo.Bloque;
import generador_codigo.GeneradorCodigo;

public abstract class Instruccion {
    public Instruccion(){}
    public abstract String toString(int prof, ArrayList<Boolean> niveles);
    //public abstract TipoInstruccion getTipo();

    public abstract int vinculacion(TablaSimbolos ts);    
    public abstract int chequea();
    public String code_I(Bloque bloque, GeneradorCodigo gc){throw new UnsupportedOperationException("code_I");}
}
