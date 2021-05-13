package ast.i;

import ast.e.Id;
import ast.t.Tipo_Id;
import java.util.ArrayDeque;
import java.util.ArrayList;
import asem.TablaSimbolos;

public class InstruccionDeclStruct extends Instruccion {
    private Id id;
    private ArrayDeque<Instruccion> declaraciones;
    
    public InstruccionDeclStruct(Id id, ArrayDeque<Instruccion> declaraciones) {
        this.id = id;
        this.declaraciones = declaraciones;
    }
    
    public TipoInstruccion getTipo() {
        return TipoInstruccion.DECLSTRUCT;
    }

    public int vinculacion(TablaSimbolos ts){
        System.out.println("No esta implementado el analizador semantico para structs");
        return 0;
    }
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
        s += b_prof + "---" + "{Struct}\n";
        if(niveles.size() == prof+1) niveles.add(true);
        else niveles.set(prof+1,true);
        for(Instruccion declaracion : declaraciones) {
            s += declaracion.toString(prof+1,niveles);
        }
        niveles.set(prof,false);
        return s;
    }
}
