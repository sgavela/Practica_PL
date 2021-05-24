package ast.i;

import ast.e.Expresion;
import java.util.ArrayList;
import asem.TablaSimbolos;
import ast.t.Tipos;
import generador_codigo.Bloque;
import generador_codigo.GeneradorCodigo;

public class InstruccionWhile extends Instruccion {
    private Expresion condicion;
    private Cuerpo cuerpo_while;
    
    public InstruccionWhile(Expresion condicion, Cuerpo cuerpo_while) {
        this.condicion = condicion;
        this.cuerpo_while = cuerpo_while;
    }
    
    public TipoInstruccion getTipo() {
        return TipoInstruccion.WHILE;
    }

    public int vinculacion(TablaSimbolos ts) {
        int errores = condicion.vinculacion(ts);
        ts.abreBloque();
        errores += cuerpo_while.vinculacion(ts);
        ts.cierraBloque();
        return errores;
    }

    public int chequea() {
        int errores = condicion.chequea();
        if (condicion.getTipo().getTipo() != Tipos.BOOLEAN) {
            errores += 1;
            System.err.println("Error de tipos. La condición"
                    + " del bucle tiene tipo " + condicion.getTipo().getTipo());
        }
        errores += cuerpo_while.chequea();
        return errores;
    }

    public String code_I(Bloque bloque, GeneradorCodigo gc) {
        String s = "";
        s += "block\nloop\n";
        s += condicion.code_E(bloque, gc);
        s += "i32.eqz\n";
        s += "br_if 1\n";
        gc.abreBloque(bloque);
        for(Instruccion i: cuerpo_while.getInstr()){
            s += gc.generaCodigo(i);
        }
        s += "br 0\n";
        gc.cierraBloque();
        s += "end\nend\n";
        return s;
    }
    
    public String toString(int prof, ArrayList<Boolean> niveles) {
        String s = "";
        String b_prof = "";
        if(niveles.size()==prof) niveles.add(true);
        else niveles.set(prof,true);
        for(int i=0; i<prof-1; ++i){
            if(niveles.get(i)) b_prof += '|';
            b_prof += "   ";
        }
        b_prof += '|';
        s += b_prof + "---{While}\n";
        s += b_prof + "   " + "|" + "---" + "Condicion: " + condicion.toString(prof+1,niveles) + "\n";
        if(niveles.size() == prof+1) niveles.add(true);
        else niveles.set(prof+1,true);
        s += b_prof + "   " + "|" + "---" + "{Cuerpo}\n";
        for(Instruccion inst: cuerpo_while.getInstr()) {
            s += inst.toString(prof+2, niveles);
        }
        niveles.set(prof+1,false);
        niveles.set(prof,false);
        return s;
    }
    
}
