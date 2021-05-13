package ast.i;

import ast.e.Expresion;
import java.util.ArrayList;
import asem.TablaSimbolos;

public class InstruccionReturn extends Instruccion {
    private Expresion e;
    
    public InstruccionReturn(Expresion e) {
        this.e = e;
    }
    
    public TipoInstruccion getTipo() {
        return TipoInstruccion.RETURN;
    }

    public int vinculacion(TablaSimbolos ts){
        /*if (e != null) {
            return e.vinculacion(ts);
        }*/
        return 0;
    }
    public int chequea(){
        /*
        if (e != null) {
            return e.chequea(); 
        }
        else*/ return 0;
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
        s += b_prof + "---{Return}\n";
        s += b_prof + "   " + "|" + "---" + "Valor: " + e.toString(prof+1,niveles) + '\n';
        niveles.set(prof,false);
        return s;
    }
}
