package ast.i;

import ast.e.Expresion;
import ast.e.Id;
import ast.t.Tipo;
import java.util.ArrayList;

public class InstruccionDeclaracion extends Instruccion {
    private Tipo tipo;
    private Id id;
    private Expresion valor;
    
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
     
     public TipoInstruccion getTipo() {
         return TipoInstruccion.DECL;
     }

     public Tipo getTipoVar() {
        return this.tipo;
    }
    
    public Id getId() {
        return this.id;
    }
    
    public Expresion getValor() {
        return this.valor;
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
