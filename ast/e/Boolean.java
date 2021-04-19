package ast.e;

import ast.t.Tipo;
import ast.t.Tipos;

public class Boolean extends Expresion{
    private String s;

    public Boolean(String s) {
        this.s = s;   
    }
    
    public Tipo getTipo(){
        return new Tipo(Tipos.BOOLEAN);
    }
    
    public String toString() {
        return s;
    }

    public Expresiones tipo() {
        if(s.equals("true")) return Expresiones.TRUE;
        else return Expresiones.FALSE;
    }   

}
