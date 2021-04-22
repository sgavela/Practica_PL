package ast.i;

import ast.e.Expresion;
import java.util.ArrayList;

public class InstruccionIfElse extends Instruccion {
    private Expresion condicion;
    private Cuerpo cuerpo_then;
    private Cuerpo cuerpo_else;
    
    //Constructora
    public InstruccionIfElse(Expresion condicion, Cuerpo cuerpo_then) {
        this.condicion = condicion;
        this.cuerpo_then = cuerpo_then;
        this.cuerpo_else = null;
    }
    public InstruccionIfElse(Expresion condicion, Cuerpo cuerpo_then, Cuerpo cuerpo_else) {
        this.condicion = condicion;
        this.cuerpo_then = cuerpo_then;
        this.cuerpo_else = cuerpo_else;
    }
    
    public TipoInstruccion getTipo() {
        return TipoInstruccion.IFELSE;
    }
    
    public String toString(int prof, ArrayList<Boolean> niveles) {
        String s = "";
        String b_prof = "";
        if(niveles.size()<=prof) niveles.add(true);
        else niveles.set(prof,true);
        for(int i=0; i<prof-1; ++i){
            if(niveles.get(i)) b_prof += '|';
            b_prof += "   ";
        }
        b_prof += '|';
        s += b_prof + "---{If}\n";
        s += b_prof + "   " + "|" + "---" + "Condicion: " + condicion.toString(prof+1,niveles) + "\n";
        if(niveles.size()==prof+1) niveles.add(true);
        else niveles.set(prof+1,true);
        s += b_prof + "   " + "|" + "---" + "{Cuerpo}\n";
        for(Instruccion inst: cuerpo_then.getInstr()) {
            s += inst.toString(prof+2, niveles);
        }
        if(cuerpo_else != null) {
            s += b_prof + "{Else}\n";
            for(Instruccion inst: cuerpo_else.getInstr()){
                s += inst.toString(prof+1, niveles);
            }
        }
        niveles.set(prof+1,false);
        niveles.set(prof,false);
        return s;
    }
    
}
