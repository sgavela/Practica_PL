package ast.i;

import ast.e.Expresion;
import generador_codigo.Bloque;
import generador_codigo.GeneradorCodigo;

import java.util.ArrayList;
import asem.TablaSimbolos;

public class InstruccionPrint extends Instruccion {
    private Expresion e;
    
    public InstruccionPrint(Expresion e) {
        this.e = e;
    }
    
    public TipoInstruccion getTipo() {
        return TipoInstruccion.PRINT;
    }

    public int vinculacion(TablaSimbolos ts){
        int errores = 0;
        errores += this.e.vinculacion(ts);
        return errores;
    }
    public int chequea(){
        /*
        if (e != null) {
            return e.chequea(); 
        }
        else*/ return 0;
    }

    public String code_I(Bloque bloque, GeneradorCodigo gc) {
        String s = "";
        s += this.e.code_E(bloque, gc);
        s += "call $print\n";
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
        if(niveles.size() == prof+1) niveles.add(false);
        else niveles.set(prof+1,false);
        s += b_prof + "---{Print}\n";
        s += b_prof + "   " + "|" + "---" + "Valor: " + e.toString(prof+1,niveles) + '\n';
        niveles.set(prof,false);
        return s;
    }
}
