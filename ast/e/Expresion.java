package ast.e;

public abstract class Expresion {
   public abstract Expresiones tipo(); 
   public Expresion opnd1() {throw new UnsupportedOperationException("opnd1");} 
   public Expresion opnd2() {throw new UnsupportedOperationException("opnd2");} 
   public String num() {throw new UnsupportedOperationException("num");}
}
