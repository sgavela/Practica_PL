package ast.e;

import ast.t.Tipo;

public class Id extends Expresion{
	private String s;
	private Tipo tipo;
	
    public Id(String s) {
        this.s = s;
    }
    
    public Tipo getTipo() {
        return this.tipo;
    }
    
    public Expresiones tipo() {
        return Expresiones.ID;
    }
    
    public String toString() {
        return s;
    }
}
