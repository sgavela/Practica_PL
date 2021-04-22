package ast.e;

import ast.t.Tipo;
import ast.t.Tipos;
import java.util.ArrayList;

public class Number extends Expresion {
	
	private String s;
	
    public Number(String s) {
        this.s = s;
    }
    
    public Tipo getTipo(){
        return new Tipo(Tipos.INTEGER);
    }
    
    public Expresiones tipo() {
        return Expresiones.NUM;
    }
    
    public String toString() {
        return s;
    }

    public String toString(int prof, ArrayList<Boolean> niveles) {
        return s;
    }
    
}
