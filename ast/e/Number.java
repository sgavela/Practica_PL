package ast.e;

import ast.t.Tipo;
import ast.t.Tipos;
import generador_codigo.Bloque;
import generador_codigo.GeneradorCodigo;

import java.util.ArrayList;
import asem.TablaSimbolos;

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

    public int vinculacion(TablaSimbolos ts) { return 0; }
    
    public int chequea() { return 0; };
    
    public String toString() {
        return s;
    }

    public String toString(int prof, ArrayList<Boolean> niveles) {
        return s;
    }

    public String code_E(Bloque bloque, GeneradorCodigo gc) {
        return "i32.const " + s + '\n';
    }
    
}
