package ast.e;

import ast.t.Tipo;
import ast.t.Tipo_Id;
import java.util.ArrayDeque;
import asem.TablaSimbolos;

public class ASExpresion {
      public Expresion suma(Expresion opnd1, Expresion opnd2) {return new ExpresionBin(opnd1,opnd2, Expresiones.SUM);}
      public Expresion resta(Expresion opnd1, Expresion opnd2) {return new ExpresionBin(opnd1,opnd2, Expresiones.SUB);}
      public Expresion mul(Expresion opnd1, Expresion opnd2) {return new ExpresionBin(opnd1,opnd2, Expresiones.MULT);}
      public Expresion div(Expresion opnd1, Expresion opnd2) {return new ExpresionBin(opnd1,opnd2, Expresiones.DIV);}
      public Expresion mod(Expresion opnd1, Expresion opnd2) {return new ExpresionBin(opnd1,opnd2, Expresiones.MOD);}
      
      public Expresion and(Expresion opnd1, Expresion opnd2) {return new ExpresionBin(opnd1,opnd2, Expresiones.AND);}
      public Expresion or(Expresion opnd1, Expresion opnd2) {return new ExpresionBin(opnd1,opnd2, Expresiones.OR);}
      public Expresion equals(Expresion opnd1, Expresion opnd2) {return new ExpresionBin(opnd1,opnd2, Expresiones.EQUAL);}
      public Expresion nequals(Expresion opnd1, Expresion opnd2) {return new ExpresionBin(opnd1,opnd2, Expresiones.NOT_EQUAL);}
      public Expresion not(Expresion opnd1) {return new ExpresionBin(opnd1,null, Expresiones.NOT);}
      public Expresion lt(Expresion opnd1, Expresion opnd2) {return new ExpresionBin(opnd1,opnd2, Expresiones.LT);}
      public Expresion gt(Expresion opnd1, Expresion opnd2) {return new ExpresionBin(opnd1,opnd2, Expresiones.GT);}
      public Expresion leq(Expresion opnd1, Expresion opnd2) {return new ExpresionBin(opnd1,opnd2, Expresiones.LEQ);}
      public Expresion geq(Expresion opnd1, Expresion opnd2) {return new ExpresionBin(opnd1,opnd2, Expresiones.GEQ);}
      
      public Expresion bool_true() {return new Booleano("true");}
      public Expresion bool_false() {return new Booleano("false");}
      public Expresion num(String n) {return new Number(n);}
      public Expresion fun(Id id, ArrayDeque<Expresion> args) {return new ExpresionLlamadaFuncion(id, args);}
      //public Expresion crea_iden(String id) {return new Id(id);}
     

}
