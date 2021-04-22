package ast.e;

import java.util.ArrayList;

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
        return opnd1.toString() + ' ' + tipoExpr.toString() + ' ' + opnd2.toString();
    }
    
    public String toString(int prof, ArrayList<Boolean> niveles) {
        String s = opnd1.toString() + ' ' + tipoExpr.toString() + ' ' + opnd2.toString() + '\n';
        String b_prof = "";
        if(niveles.size() == prof) niveles.add(true);
        else niveles.set(prof,true);
        for(int i=0; i<prof-1; ++i){
            if(niveles.get(i)) b_prof += '|';
            b_prof += "   ";
        }
        if(niveles.size() == prof+1) niveles.add(false);
        else niveles.set(prof+1,false);
        b_prof += '|';
        s += b_prof + "   |---Operacion: " + tipoExpr.toString() + '\n';
        s += b_prof + "   |---Operando 1: " + opnd1.toString(prof+1,niveles) + '\n'; 
        s += b_prof + "   |---Operando 2: " + opnd2.toString(prof+1,niveles);
        niveles.set(prof,false);
        return s;
    }
}
