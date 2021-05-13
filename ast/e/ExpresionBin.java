package ast.e;

import java.util.ArrayList;
import asem.TablaSimbolos;
import ast.e.Expresion;
import ast.t.Tipos;
import ast.t.Tipo;

public class ExpresionBin extends Expresion {
   private Expresion opnd1;
   private Expresion opnd2;
   private Expresiones tipoExpr;
   private Tipo tipo;
   
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

    public Tipo getTipo() {
        return this.tipo;
    }

    public int vinculacion(TablaSimbolos ts) {
        return opnd1.vinculacion(ts) + opnd2.vinculacion(ts);
    }

    public int chequea() {
        int errores = opnd1.chequea() + opnd2.chequea();
        
        Tipo t1 = opnd1.getTipo();
        Tipo t2 = opnd2.getTipo();

        tipo = new Tipo(Tipos.NULL);
        
        if (tipoExpr == Expresiones.AND || tipoExpr == Expresiones.OR) {
            if (t1.getTipo() != Tipos.BOOLEAN) {
                errores += 1;
                System.err.println("Error de tipos. La expresión " + opnd1.toString() + " no es booleana");
            }
            if (t2.getTipo() != Tipos.BOOLEAN) {
                errores += 1;
                System.err.println("Error de tipos. La expresión " + opnd2.toString() + " no es booleana");
            }
            else{
                tipo = new Tipo(Tipos.BOOLEAN);
            }
        }
        else if (tipoExpr == Expresiones.EQUAL || tipoExpr == Expresiones.NOT_EQUAL ||
                tipoExpr == Expresiones.GT || tipoExpr == Expresiones.LT ||
                tipoExpr == Expresiones.GEQ || tipoExpr == Expresiones.LEQ) {
            if (t1.getTipo() != Tipos.INTEGER) {
                errores += 1;
                System.err.println("Error de tipos. La expresión " + opnd1.toString() + " no es de tipo entero");
            }
            if (t2.getTipo() != Tipos.INTEGER) {
                errores += 1;
                System.err.println("Error de tipos. La expresión " + opnd2.toString() + " no es de tipo entero");
            }
            if (t1.getTipo() == Tipos.INTEGER && t2.getTipo() == Tipos.INTEGER) {
                tipo = new Tipo(Tipos.BOOLEAN);
            }
        }
        else if(tipoExpr == Expresiones.SUM || tipoExpr == Expresiones.SUB || 
            tipoExpr == Expresiones.MULT || tipoExpr == Expresiones.DIV ||
            tipoExpr == Expresiones.MOD){
                if (t1.getTipo() != Tipos.INTEGER) {
                    errores += 1;
                    System.err.println("Error de tipos. La expresion " + opnd1.toString() + " no es de tipo entero");
                }
                if (t2.getTipo() != Tipos.INTEGER) {
                    errores += 1;
                    System.err.println("Error de tipos. La expresion " + opnd2.toString() + " no es de tipo entero");
                }
                if (t1.getTipo() == Tipos.INTEGER && t2.getTipo() == Tipos.INTEGER) {
                    tipo = new Tipo(Tipos.INTEGER);
                }
            }
        return errores;
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
        s += b_prof + "   |---tipoExpr: " + tipoExpr.toString() + '\n';
        s += b_prof + "   |---Operando 1: " + opnd1.toString(prof+1,niveles) + '\n'; 
        s += b_prof + "   |---Operando 2: " + opnd2.toString(prof+1,niveles);
        niveles.set(prof,false);
        return s;
    }
}
