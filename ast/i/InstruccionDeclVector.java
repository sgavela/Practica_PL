package ast.i;

import ast.e.Expresion;
import ast.e.Id;
import ast.t.Tipo;
import ast.t.TipoLista;
import ast.t.Tipos;
import generador_codigo.Bloque;
import generador_codigo.GeneradorCodigo;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import asem.TablaSimbolos;

public class InstruccionDeclVector extends Instruccion {
    private Tipo tipo;
    private Id id;
    private int tam; 
    private ArrayDeque<Expresion> valores;
    Object vinculoId;
    
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
     
     public TipoInstruccion getTipoInstruccion() {
         return TipoInstruccion.DECL;
     }

    public Tipo getTipo(){
        return this.tipo;
    }

    public int getTam(){
        return this.tam;
    }
    
    public Id getId() {
        return this.id;
    }
    
    public ArrayDeque<Expresion> getValores() {
        return this.valores;
    }

    public int vinculacion(TablaSimbolos ts){
        int errores = ts.insertaId(id, this);
        if(valores != null) {
            for(Expresion valor : valores){            
                errores += valor.vinculacion(ts);
            }
        }
        return errores;
    }
    public int chequea(){
        int errores = 0;
        Tipo tipoTipo = this.tipo;
        //Iterator valor = valores.iterator();
        int i = 0;
        if(valores != null){
            for(Expresion valor : valores){
                errores += valor.chequea();
                Tipo valorTipo = valor.getTipo();
                if (!tipoTipo.equals(valorTipo)) {
                    errores += 1;
                    System.err.println("Error de tipos. El identificador del vector es tipo " +
                            this.tipo + " pero la expresion en la posicion " +
                            i + " es tipo " + valor.getTipo());
                }
                i += 1;
            }
        }
        else {
            i = tam;
        }
        if(i != tam){
            errores += 1;
            System.err.println("Error de tipos. El tamanio declarado para el vector " + id.toString() 
                        + " es " + tam + " pero hay " + i + " elementos en la declaracion.");
        }
        return errores;
    }

    public String code_I(Bloque bloque, GeneradorCodigo gc) {
        String s = "";
        bloque.addDirId(id.getS(), tam);
        if(this.valores != null){
            for(Integer i=0; i<tam; ++i){
                s += id.code_D(bloque, gc);
                s += "i32.const ";
                s += i.toString() + "\n";
                s += "i32.const 4\n";
                s += "i32.mul\n";
                s += "i32.add\n";
                s += valores.pollFirst().code_E(bloque, gc);
                s += "i32.store\n";
            }        
        }
        return s;
    }
     
     public String toString(int prof, ArrayList<Boolean> niveles) {
        String s = "";
        String b_prof = "";
        if(niveles.size() == prof) niveles.add(true);
        else niveles.set(prof,true);
        for(int i=0; i<prof-1; ++i){
            if(niveles.get(i)) b_prof += '|';
            b_prof += "   ";
        }
        b_prof += '|';
        s += b_prof + "---" +  "{Declaracion vector}\n";
        s += b_prof + "   |---Tipo: " + tipo.toString() + '\n';
        s += b_prof + "   |---Identificador: " + id.toString() + '\n';
        if(niveles.size() == prof+1) niveles.add(true);
        else niveles.set(prof+1,true);
        if(valores != null) {
            s += b_prof + "   |---Valor:\n";
            for(Expresion v: valores) {
                s += b_prof + "   |   |---Elemento: " + v.toString(prof+2,niveles) + '\n';
            }
        }
        niveles.set(prof+1,false);
        niveles.set(prof,false);
        return s;
     }
    
}
