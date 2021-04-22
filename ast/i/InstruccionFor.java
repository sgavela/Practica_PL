package ast.i;

import ast.e.Expresion;
import ast.e.Id;
import java.util.ArrayList;

public class InstruccionFor extends Instruccion {
    private Id id;
    private Expresion valor_ini;
    private Expresion condicion;
    private Expresion paso;
    private Cuerpo cuerpo_for;
    
    public InstruccionFor(Id id, Expresion valor_ini, Expresion condicion, Expresion paso, Cuerpo cuerpo_for) {
        this.id = id;
        this.valor_ini = valor_ini;
        this.condicion = condicion;
        this.paso = paso;
        this.cuerpo_for = cuerpo_for;
    }
    
    public TipoInstruccion getTipo() {
        return TipoInstruccion.FOR;
    }
    
    public String toString(int prof, ArrayList<Boolean> niveles){
        String s = "";
        String b_prof = "";
        if(niveles.size()<=prof) niveles.add(true);
        else niveles.set(prof,true);
        for(int i=0; i<prof-1; ++i){
            if(niveles.get(i)) b_prof += '|';
            b_prof += "   ";
        }
        b_prof += '|';
        s += b_prof + "---{For}\n";
        s += b_prof + "   " + "|" + "---" + "Identificador: " + id.toString() + "\n";
        s += b_prof + "   " + "|" + "---" + "Valor inicial: " + valor_ini.toString(prof+1,niveles) + "\n";
        s += b_prof + "   " + "|" + "---" + "Condicion: " + condicion.toString(prof+1,niveles) + "\n";
        s += b_prof + "   " + "|" + "---" + "Paso: " + paso.toString(prof+1,niveles) + "\n";
        if(niveles.size()==prof+1) niveles.add(true);
        else niveles.set(prof+1,true);
        s += b_prof + "   " + "|" + "---" + "{Cuerpo}\n";
        for(Instruccion inst: cuerpo_for.getInstr()) {
            s += inst.toString(prof+2, niveles);
        }
        niveles.set(prof+1,false);
        niveles.set(prof,false);
        return s;
    }
}
