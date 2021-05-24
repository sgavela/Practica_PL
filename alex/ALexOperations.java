package alex;

import asint.ClaseLexica;

public class ALexOperations {
  private AnalizadorLexicoTiny alex;
  public ALexOperations(AnalizadorLexicoTiny alex) {
   this.alex = alex;   
  }
  public UnidadLexica unidadEnt() {
     return new UnidadLexica(alex.fila(),ClaseLexica.NUM,alex.lexema()); 
  } 
  public UnidadLexica unidadInt() {
     return new UnidadLexica(alex.fila(),ClaseLexica.INTEGER,alex.lexema()); 
  }
  public UnidadLexica unidadBool() {
     return new UnidadLexica(alex.fila(),ClaseLexica.BOOLEAN,alex.lexema()); 
  }

  public UnidadLexica unidadTrue() {
     return new UnidadLexica(alex.fila(),ClaseLexica.TRUE,"true"); 
  }  

  public UnidadLexica unidadFalse() {
     return new UnidadLexica(alex.fila(),ClaseLexica.FALSE,"false"); 
  }  

  public UnidadLexica unidadVector() {
     return new UnidadLexica(alex.fila(),ClaseLexica.LIST,"vector"); 
  }  

  public UnidadLexica unidadStruct() {
     return new UnidadLexica(alex.fila(),ClaseLexica.STRUCT,"struct"); 
  }  

  public UnidadLexica unidadTypedef() {
     return new UnidadLexica(alex.fila(),ClaseLexica.TYPEDEF,"typedef"); 
  }  

  public UnidadLexica unidadIf() {
     return new UnidadLexica(alex.fila(),ClaseLexica.IF,"if"); 
  }  

  public UnidadLexica unidadElse() {
     return new UnidadLexica(alex.fila(),ClaseLexica.ELSE,"else"); 
  }  

  public UnidadLexica unidadWhile() {
     return new UnidadLexica(alex.fila(),ClaseLexica.WHILE,"while"); 
  }  

  public UnidadLexica unidadFor() {
     return new UnidadLexica(alex.fila(),ClaseLexica.FOR,"for"); 
  }  

  public UnidadLexica unidadSwitch() {
     return new UnidadLexica(alex.fila(),ClaseLexica.SWITCH,"switch"); 
  }  
  
  public UnidadLexica unidadCase() {
     return new UnidadLexica(alex.fila(),ClaseLexica.CASE,"case"); 
  }  

  public UnidadLexica unidadBreak() {
     return new UnidadLexica(alex.fila(),ClaseLexica.BREAK,"break"); 
  }  

  public UnidadLexica unidadDefault() {
     return new UnidadLexica(alex.fila(),ClaseLexica.DEFAULT,"default"); 
  }  

  public UnidadLexica unidadFun() {
     return new UnidadLexica(alex.fila(),ClaseLexica.FUNCTION,"fun"); 
  }  

  public UnidadLexica unidadReturn() {
     return new UnidadLexica(alex.fila(),ClaseLexica.RETURN,"return"); 
  }  

  public UnidadLexica unidadVoid() {
     return new UnidadLexica(alex.fila(),ClaseLexica.VOID,"void"); 
  }  

  public UnidadLexica unidadNew() {
     return new UnidadLexica(alex.fila(),ClaseLexica.NEW,"new"); 
  }  

  public UnidadLexica unidadMain() {
     return new UnidadLexica(alex.fila(),ClaseLexica.MAIN,"main"); 
  }  

  public UnidadLexica unidadPrint() {
     return new UnidadLexica(alex.fila(), ClaseLexica.PRINT, "print");
  }

  public UnidadLexica unidadIdentificador() {
     return new UnidadLexica(alex.fila(),ClaseLexica.IDEN,alex.lexema()); 
  }  

  public UnidadLexica unidadSuma() {
     return new UnidadLexica(alex.fila(),ClaseLexica.SUM,"+"); 
  }  

  public UnidadLexica unidadResta() {
     return new UnidadLexica(alex.fila(),ClaseLexica.SUB,"-"); 
  }  

  public UnidadLexica unidadMult() {
     return new UnidadLexica(alex.fila(),ClaseLexica.MULT,"*"); 
  }  

  public UnidadLexica unidadDiv() {
     return new UnidadLexica(alex.fila(),ClaseLexica.DIV,"/"); 
  }  

  public UnidadLexica unidadMod() {
     return new UnidadLexica(alex.fila(),ClaseLexica.MOD,"%"); 
  }  

  public UnidadLexica unidadParentesisAp() {
     return new UnidadLexica(alex.fila(),ClaseLexica.PARAPERTURA,"("); 
  }  

  public UnidadLexica unidadParentesisCi() {
     return new UnidadLexica(alex.fila(),ClaseLexica.PARCIERRE,")"); 
  }  

  public UnidadLexica unidadLlaveAp() {
     return new UnidadLexica(alex.fila(),ClaseLexica.LLAVEAPERTURA,"{"); 
  }  

  public UnidadLexica unidadLlaveCi() {
     return new UnidadLexica(alex.fila(),ClaseLexica.LLAVECIERRE,"}"); 
  }  

  public UnidadLexica unidadCorAp() {
     return new UnidadLexica(alex.fila(),ClaseLexica.CORCHAPERTURA,"["); 
  }  

  public UnidadLexica unidadCorCi() {
     return new UnidadLexica(alex.fila(),ClaseLexica.CORCHCIERRE,"]"); 
  }  

  public UnidadLexica unidadMenor() {
     return new UnidadLexica(alex.fila(),ClaseLexica.MENOR,"<"); 
  }  

  public UnidadLexica unidadMayor() {
     return new UnidadLexica(alex.fila(),ClaseLexica.MAYOR,">"); 
  }  

  public UnidadLexica unidadMenorIgual() {
     return new UnidadLexica(alex.fila(),ClaseLexica.MENOROIGUAL,"<="); 
  }  

  public UnidadLexica unidadMayorIgual() {
     return new UnidadLexica(alex.fila(),ClaseLexica.MAYOROIGUAL,">="); 
  }  

  public UnidadLexica unidadIgual() {
     return new UnidadLexica(alex.fila(),ClaseLexica.IGUAL,"="); 
  }  

  public UnidadLexica unidadIgualIgual() {
     return new UnidadLexica(alex.fila(),ClaseLexica.IGUALIGUAL,"=="); 
  }  

  public UnidadLexica unidadNoIgual() {
     return new UnidadLexica(alex.fila(),ClaseLexica.NOIGUAL,"!="); 
  }  

  public UnidadLexica unidadAnd() {
     return new UnidadLexica(alex.fila(),ClaseLexica.AND,"&&"); 
  }  

  public UnidadLexica unidadOr() {
     return new UnidadLexica(alex.fila(),ClaseLexica.OR,"||"); 
  }  

  public UnidadLexica unidadNot() {
     return new UnidadLexica(alex.fila(),ClaseLexica.NOT,"!"); 
  }  

  public UnidadLexica unidadComa() {
     return new UnidadLexica(alex.fila(),ClaseLexica.COMA,","); 
  }

  public UnidadLexica unidadPuntoComa() {
     return new UnidadLexica(alex.fila(),ClaseLexica.PUNTOCOMA,";"); 
  }  

  public UnidadLexica unidadDosPuntos() {
     return new UnidadLexica(alex.fila(),ClaseLexica.DOSPUNTOS,":"); 
  }  

  public UnidadLexica unidadPunto() {
     return new UnidadLexica(alex.fila(),ClaseLexica.PUNTO,"."); 
  }  

  public UnidadLexica unidadAsterisco() {
     return new UnidadLexica(alex.fila(),ClaseLexica.ASTERISCO,"*"); 
  }  

  public UnidadLexica unidadAmpersand() {
     return new UnidadLexica(alex.fila(),ClaseLexica.AMPERSAND,"&"); 
  }  

  public UnidadLexica unidadBarraBaja() {
     return new UnidadLexica(alex.fila(),ClaseLexica.BARRABAJA,"_"); 
  }  
   
  public UnidadLexica unidadDollar() {
     return new UnidadLexica(alex.fila(),ClaseLexica.DOLLAR,"$"); 
  } 

  public UnidadLexica unidadEof() {
     return new UnidadLexica(alex.fila(),ClaseLexica.EOF, "<EOF>"); 
  }  
  public void error() {
    System.err.println("***"+alex.fila()+" Caracter inexperado: "+alex.lexema());
  }
}
