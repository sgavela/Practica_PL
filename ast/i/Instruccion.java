package ast.i;

import java.util.ArrayList;
import asem.TablaSimbolos;

public abstract class Instruccion {
    public Instruccion(){}
    public abstract String toString(int prof, ArrayList<Boolean> niveles);
    //public abstract TipoInstruccion getTipo();

    public abstract int vinculacion(TablaSimbolos ts);    
    public abstract int chequea();
}
