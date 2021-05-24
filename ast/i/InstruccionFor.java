package ast.i;

import ast.e.Expresion;
import ast.e.Id;
import java.util.ArrayList;
import asem.TablaSimbolos;
import ast.t.Tipos;
import generador_codigo.Bloque;
import generador_codigo.GeneradorCodigo;
import ast.t.Tipo;

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

    public int vinculacion(TablaSimbolos ts){
        int errores = id.vinculacion(ts);
        errores += valor_ini.vinculacion(ts);
        errores += condicion.vinculacion(ts);
        errores += paso.vinculacion(ts);
        ts.abreBloque();
        errores += cuerpo_for.vinculacion(ts);
        ts.cierraBloque();
        return errores;
    }

    public int chequea(){
        int errores = condicion.chequea();
        /*
        Tipo tipoId = id.getTipo();
        Tipo tipoValor = valor_ini.getTipo();
        if (!tipoId.equals(tipoValor)) {
            errores += 1;
            //idTipo=id.getFila();           
            System.err.println("Error de tipos. " + "El tipo del identificador es "
                +id.getTipo()+" pero el de la expresion es " + valor_ini.getTipo());
        }
        */
        errores += paso.chequea();
        if (condicion.getTipo().getTipo() != Tipos.BOOLEAN) {
            errores += 1;
            System.err.println("Error de tipos. La condición"
                    + " del bucle for tiene tipo " + condicion.getTipo().getTipo());
        }
        if (paso.getTipo().getTipo() != Tipos.INTEGER) {
            errores += 1;
            System.err.println("Error de tipos. El paso"
                    + " del bucle for tiene tipo " + paso.getTipo().getTipo());
        }
        errores += cuerpo_for.chequea();
        return errores;
    }

    public String code_I(Bloque bloque, GeneradorCodigo gc) {
        String s = "";
        s += "block\n";
        //Tratamos la asignacion inicial
        bloque.addDirId(id.getS(), 1);
        s += id.code_D(bloque, gc);
        s += valor_ini.code_E(bloque, gc);
        s += "i32.store\n";
        s += "loop\n";
        //Tratamos la condicion
        s += condicion.code_E(bloque, gc);
        s += "i32.eqz\n";
        s += "br_if 1\n";
        gc.abreBloque(bloque);
        for(Instruccion i: cuerpo_for.getInstr()){
           s += gc.generaCodigo(i);
        }
        //Tratamos la asignacion de paso
        s += id.code_D(bloque, gc);
        s += paso.code_E(bloque, gc);
        s += "i32.store\n";
        s += "br 0\n";
        gc.cierraBloque();
        s += "end\nend\n";
        return s;
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
