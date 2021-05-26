package ast.e;

import ast.t.Tipo;
import ast.t.Tipos;
import generador_codigo.Bloque;
import generador_codigo.GeneradorCodigo;

import java.util.ArrayList;
import asem.TablaSimbolos;

public class Booleano extends Expresion{
    private String s;

    public Booleano(String s) {
        this.s = s;   
    }
    
    public Tipo getTipo(){
        return new Tipo(Tipos.BOOLEAN);
    }

    public int vinculacion(TablaSimbolos ts) { return 0; };
    
    public int chequea() { return 0; };

    public String toString() {
        return s;
    }

    public String code_E(Bloque bloque, GeneradorCodigo gc) {
        if(s.equals("true")) return "i32.const 1\n";
        else return "i32.const 0\n";
    }

    public String toString(int prof, ArrayList<Boolean> niveles) {
        return s;
    }

    public Expresiones tipo() {
        if(s.equals("true")) return Expresiones.TRUE;
        else return Expresiones.FALSE;
    }   

}
