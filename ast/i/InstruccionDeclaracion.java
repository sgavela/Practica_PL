package ast.i;

import ast.e.Expresion;
import ast.e.Id;
import ast.e.ListIndex;
import ast.t.Tipo;
import ast.t.Tipos;

import java.util.ArrayList;
import asem.TablaSimbolos;
import asem.ExcepcionIdNoExistente;
import errors.ExcepcionTipoDesconocido;
import generador_codigo.Bloque;
import generador_codigo.GeneradorCodigo;

public class InstruccionDeclaracion extends Instruccion {
    protected Tipo tipo;
    private Id id;
    private Expresion valor;
    private Object vinculoId;
    
    public InstruccionDeclaracion(Tipo tipo, Id id) {
        this.tipo = tipo;
        this.id = id;
        this.valor = null;
    }
    
     public InstruccionDeclaracion(Tipo tipo, Id id, Expresion valor) {
        this.tipo = tipo;
        this.id = id;
        this.valor = valor;
    }
     
    public TipoInstruccion getTipoInstruccion() {
         return TipoInstruccion.DECL;
     }

    public Tipo getTipo(){
        return this.tipo;
    }
    
    public Id getId() {
        return this.id;
    }
    
    public Expresion getValor() {
        return this.valor;
    }

    public int vinculacion(TablaSimbolos ts) {
        if(valor==null){
            int errores = 0;
            return errores + ts.insertaId(id, this);
        }
        else{
            int errores = ts.insertaId(id, this);
            errores += valor.vinculacion(ts);
            return errores;
        }
    }
    
    public int chequea() {
        if(valor==null){
            return 0;
        }
        else{
            int errores = valor.chequea();
            Tipo tipoTipo = this.tipo;
            Tipo valorTipo = valor.getTipo();
            //System.out.println(valor);
            if (!tipoTipo.equals(valorTipo)) {
                errores += 1;
                System.err.println("Error en la declaracion, el identificador es tipo " +
                        this.tipo + " pero la expresion es tipo " + valor.getTipo());
            }
            return errores;
        }
    }

    public String code_I(Bloque bloque, GeneradorCodigo gc) {
        String s = "";
        bloque.addDirId(id.getS(), 1);
        if(valor == null) {
            s += id.code_D(bloque, gc);
            //Le ponemos 0 por defecto
            s += "i32.const 0\n";
            s += "i32.store\n";
        } 
        else {
            s += id.code_D(bloque, gc);
            s += valor.code_E(bloque, gc);
            s += "i32.store\n";
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
        s += b_prof + "---{Declaracion}\n";
        if(niveles.size() == prof+1) niveles.add(false);
        else niveles.set(prof+1,false);
        s += b_prof + "   " + "|" + "---" + "Tipo: " + tipo.toString() + '\n';
        s += b_prof + "   " + "|" + "---" + "Identificador: " + id.toString() + '\n';
        if(valor != null) {
            s += b_prof + "   " + "|" + "---" + "Valor: " + valor.toString(prof+1,niveles) + '\n';
        }
        niveles.set(prof,false);
        return s;
    }
    
}
