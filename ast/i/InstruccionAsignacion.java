package ast.i;

import ast.e.Expresion;
import ast.e.Id;
import java.util.ArrayList;

public class InstruccionAsignacion extends Instruccion {
    private Id identificador;
    private Expresion valor;
    
    public InstruccionAsignacion(Id identificador, Expresion valor) {
        this.identificador = identificador;
        this.valor = valor;
    }
    
    public TipoInstruccion getTipo() {
        return TipoInstruccion.ASIG;
    }

    public Id getId() {
        return this.identificador;
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
        if(niveles.size() == prof+1) niveles.add(false);
        else niveles.set(prof+1,false);
        s += b_prof + "---{Asignacion}\n";
        s += b_prof + "   " + "|" + "---" + "Identificador: " + identificador.toString() + '\n';
        s += b_prof + "   " + "|" + "---" + "Valor: " + valor.toString(prof+1,niveles) + '\n';
        niveles.set(prof,false);
        return s;
    }
    
}
