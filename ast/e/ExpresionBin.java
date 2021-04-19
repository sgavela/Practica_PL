package ast.e;

public class ExpresionBin extends Expresion {
   private Expresion opnd1;
   private Expresion opnd2;
   private Expresiones tipoExpr;
   
   public ExpresionBin(Expresion opnd1, Expresion opnd2, Expresiones tipoExpr) {
     this.opnd1 = opnd1;
     this.opnd2 = opnd2;
     this.tipoExpr = tipoExpr;
   }
   public Expresion opnd1() {return opnd1;}
   public Expresion opnd2() {return opnd2;} 

    public Expresiones tipo() {
        return tipoExpr;
    }
    
    public String toString() {
        String s = opnd1.toString() + ' ' + tipoExpr.toString() + ' ' + opnd2.toString();
        return s;
    }
}
