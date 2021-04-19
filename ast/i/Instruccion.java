package ast.i;

public abstract class Instruccion {
    public Instruccion(){}
    public abstract String toString();
    public abstract TipoInstruccion getTipo();
}
