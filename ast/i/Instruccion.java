package ast.i;

import java.util.ArrayList;

public abstract class Instruccion {
    public Instruccion(){}
    public abstract String toString(int prof, ArrayList<Boolean> niveles);
    public abstract TipoInstruccion getTipo();
}
