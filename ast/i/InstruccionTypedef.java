package ast.i;

import ast.e.Id;
import ast.t.Tipo;
import java.util.ArrayList;
import asem.TablaSimbolos;

public class InstruccionTypedef extends Instruccion {
    private Tipo tipo;
    private Id alias;
    
    public InstruccionTypedef(Tipo tipo, Id alias) {
        this.tipo = tipo;
        this.alias = alias;
    }
    
    public TipoInstruccion getTipo() {
        return TipoInstruccion.TYPEDEF;
    }

    public int vinculacion(TablaSimbolos ts){return 0;}
    public int chequea(){return 0;}
    
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
        s += b_prof + "---{Typedef}\n";
        s += b_prof + "   " + "|" + "---" + "Tipo: " + tipo.toString() + '\n';
        s += b_prof + "   " + "|" + "---" + "Alias: " + alias.toString() + '\n';
        niveles.set(prof,false);
        return s;
    }
}
