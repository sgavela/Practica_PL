package ast.i;

import ast.e.Expresion;
import java.util.ArrayList;
import asem.TablaSimbolos;
import ast.t.Tipos;
import generador_codigo.Bloque;
import generador_codigo.GeneradorCodigo;
import ast.t.Tipo;

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

    public int vinculacion(TablaSimbolos ts) {
        int errores = condicion.vinculacion(ts);
        //Después creamos un ámbito para cada bloque 
        ts.abreBloque();
        errores += cuerpo_then.vinculacion(ts);
        ts.cierraBloque();
        
        //En caso de tener un bloque else lo procesamos
        if (cuerpo_else != null) {
            ts.abreBloque();
            errores += cuerpo_else.vinculacion(ts);
            ts.cierraBloque();
        }
        return errores;
    }

    public int chequea() {
        //Comprobamos que coinciden el tipo de la declaración con el de la expresión
        int errores = condicion.chequea();

        Tipo tipoCond = condicion.getTipo();

        if (tipoCond != null && !tipoCond.equals(new Tipo(Tipos.BOOLEAN))) {
            errores += 1;
            System.err.println("Error de tipos. En el condicional el tipo de la condición es " + tipoCond.getTipo() +
                                     " y no booleano");
        }

        errores += cuerpo_then.chequea();
        if (cuerpo_else != null) {
            errores += cuerpo_else.chequea();
        }
        return errores;
    }

    public String code_I(Bloque bloque, GeneradorCodigo gc) {
        String s = "";
        s += condicion.code_E(bloque, gc);
        s += "if\n";
        gc.abreBloque(bloque);
        for(Instruccion i: cuerpo_then.getInstr()) {
            s += gc.generaCodigo(i);
        }
        gc.cierraBloque();
        if(cuerpo_else != null) {
            s += "else\n";
            gc.abreBloque(bloque);
            for(Instruccion i: cuerpo_else.getInstr()) {
                s += gc.generaCodigo(i);
            }
            gc.cierraBloque();
        }
        s += "end\n";
        return s;
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
