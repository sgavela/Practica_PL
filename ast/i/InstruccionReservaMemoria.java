package ast.i;

import ast.e.Id;
import java.util.ArrayList;
import asem.TablaSimbolos;

public class InstruccionReservaMemoria extends Instruccion {
    private Id id;
    private int tam;
    
    public InstruccionReservaMemoria(Id id, String tam) {
        this.id = id;
        this.tam = Integer.parseInt(tam);
    }
    
    public TipoInstruccion getTipo() {
        return TipoInstruccion.RESMEM;
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
        s += b_prof + "---{Reserva memoria}\n";
        s += b_prof + "   " + "|" + "---" + "Identificador: " + id.toString() + '\n';
        s += b_prof + "   " + "|" + "---" + "Espacio: " + tam + '\n';
        niveles.set(prof,false);
        return s;
    }
}
