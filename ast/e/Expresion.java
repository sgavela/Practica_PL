package ast.e;

import java.util.ArrayList;
import asem.TablaSimbolos;
import ast.t.Tipo;

public abstract class Expresion {
   public abstract Expresiones tipo(); 
   public Expresion opnd1() {throw new UnsupportedOperationException("opnd1");} 
   public Expresion opnd2() {throw new UnsupportedOperationException("opnd2");} 
   public abstract int vinculacion(TablaSimbolos ts);
   public abstract int chequea();
   public abstract Tipo getTipo();
   public String num() {throw new UnsupportedOperationException("num");}
   public String toString(int prof, ArrayList<Boolean> niveles) {throw new UnsupportedOperationException("toString");}
   public String toString() {throw new UnsupportedOperationException("toString");}
}
