package ast.i;

import ast.e.Id;
import ast.t.Tipo;
import ast.t.Tipo_Id;
import java.util.ArrayDeque;
import java.util.ArrayList;
import asem.TablaSimbolos;
import ast.getTipoVinculo;
import ast.e.Expresion;
import ast.e.Id;

public class InstruccionDeclFuncion extends Instruccion {
    private Tipo tipo;
    private Id id;
    private ArrayDeque<Tipo_Id> argumentos;
    private Cuerpo cuerpo;
    private Expresion devolver;
    Object vinculoId;
    
    public InstruccionDeclFuncion(Tipo tipo, Id id, ArrayDeque<Tipo_Id> argumentos, Cuerpo cuerpo,
        Expresion devolver) {
        this.tipo = tipo;
        this.id = id;
        this.argumentos = argumentos;
        this.cuerpo = cuerpo;
        this.devolver = devolver;
    }
    
    public TipoInstruccion getTipoInstruccion() {
        return TipoInstruccion.DECLFUN;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public ArrayDeque<Tipo_Id> getArgumentos() {
        return argumentos;
    }

    public int vinculacion(TablaSimbolos ts){
        int errores = 0;
        errores += ts.insertaId(id, this);
        ts.abreBloque();
        for(Tipo_Id arg: argumentos){
            errores += arg.vinculacion(ts);           
        }
        errores += cuerpo.vinculacion(ts);
        if(devolver != null){
            errores += devolver.vinculacion(ts);
        }
        ts.cierraBloque();
        return errores;
    }

    public int chequea(){
        int errores = cuerpo.chequea();
        if(devolver != null){
            devolver.chequea();
            if(!devolver.getTipo().equals(tipo)){
                errores += 1;
                System.err.println("Error de tipos. " + "El tipo de la funcion es "
                +tipo+" pero el de la expresion que devuelve es " + devolver.getTipo());
            }
        }
        return errores;
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
        s += b_prof + "---{Declaracion funcion}\n";
        if(tipo == null) {
            s += b_prof + "   |---Tipo: " + "VOID" + '\n';
        }
        else {
            s += b_prof + "   |---Tipo: " + tipo.toString() + '\n';
        }
        s += b_prof + "   |---Identificador: " + id.toString() + '\n'; 
        for(Tipo_Id arg: argumentos){
            s += b_prof + "   |---Argumento: \n" + b_prof + "   |   |---Tipo: " + arg.getTipo().toString() + '\n';
            s += b_prof  + "   |   |---Identificador: " + arg.getNombre().toString() + '\n';
        }
        if(niveles.size() == prof+1) niveles.add(true);
        else niveles.set(prof+1,true);
        s += b_prof + "   |---{Cuerpo}\n";
        for(Instruccion inst: cuerpo.getInstr()) {
            s += inst.toString(prof+2, niveles);
        }
        if(devolver == null) {
            s += b_prof + "   |---Return: " + "VOID" + '\n';
        }
        else {
            s += b_prof + "   |---Return: " + devolver.toString() + '\n';
        }
        niveles.set(prof+1,false);
        niveles.set(prof,false);
        return s;
    }
    
}
