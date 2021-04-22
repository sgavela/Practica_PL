package ast.e;

import ast.t.Tipo;
import ast.t.Tipos;
import java.util.ArrayList;

public class Booleano extends Expresion{
    private String s;

    public Booleano(String s) {
        this.s = s;   
    }
    
    public Tipo getTipo(){
        return new Tipo(Tipos.BOOLEAN);
    }

    public String toString() {
        return s;
    }

    public String toString(int prof, ArrayList<Boolean> niveles) {
        return s;
    }

    public Expresiones tipo() {
        if(s.equals("true")) return Expresiones.TRUE;
        else return Expresiones.FALSE;
    }   

}
