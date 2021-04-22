package ast.i;

import ast.e.Expresion;
import ast.e.Id;
import ast.t.Tipo;

import java.util.ArrayDeque;

public class InstruccionDeclVector extends Instruccion {
    private Tipo tipo;
    private Id id;
    private int tam; 
    private ArrayDeque<Expresion> valores;
    
    public InstruccionDeclVector(Tipo tipo, Id id, int tam) {
        this.tipo = tipo;
        this.id = id;
        this.tam = tam;
        this.valores = null;
    }
    
     public InstruccionDeclVector(Tipo tipo, Id id, int tam, ArrayDeque<Expresion> valores) {
        this.tipo = tipo;
        this.id = id;
        this.tam = tam;
        this.valores = valores;
    }
     
     public TipoInstruccion getTipo() {
         return TipoInstruccion.DECL;
     }

     public Tipo getTipoVar() {
        return this.tipo;
    }
    
    public Id getId() {
        return this.id;
    }
    
    public ArrayDeque<Expresion> getValores() {
        return this.valores;
    }
     
     public String toString() {
         String s = "{{_DeclaracionVector_}{" + tipo.toString() + ',' + id.toString();
         if(valores != null) {
             s += ',' + valores.toString();
         }
         s += "}}";
         return s;
     }
    
}
