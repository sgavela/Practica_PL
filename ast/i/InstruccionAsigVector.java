package ast.i;

import ast.e.Expresion;
import ast.e.Id;
import java.util.ArrayList;
import java.util.ArrayDeque;
import asem.TablaSimbolos;
import ast.t.Tipo;
import generador_codigo.Bloque;
import generador_codigo.GeneradorCodigo;
import asem.ExcepcionIdNoExistente;

public class InstruccionAsigVector extends Instruccion {
    private Id id;
    private ArrayDeque<Expresion> valores;
    public Object vinculo;
    private Tipo tipo;
    
    public InstruccionAsigVector(Id id, ArrayDeque<Expresion> valores) {
        this.id = id;
        this.valores = valores;
    }
    
    public TipoInstruccion getTipo() {
        return TipoInstruccion.ASIG;
    }

    public Id getId() {
        return this.id;
    }
    
    public ArrayDeque<Expresion> getValores() {
        return this.valores;
    }

    public int vinculacion(TablaSimbolos ts){
        int errores = 0;
        try {
            vinculo = ts.buscaId(id.toString());
            InstruccionDeclVector vinculoVector = (InstruccionDeclVector) vinculo;
            tipo = vinculoVector.getTipo();
        } catch (ExcepcionIdNoExistente e) {
            errores += 1;
            System.err.println("Error en la fila "+ ". La función " + id + " no existe");
        }
        return errores;
    }

    public int chequea(){
        int errores = 0;      
        int i = 0;
        for(Expresion valor : valores){
            Tipo valorTipo = valor.getTipo();
            if (!tipo.equals(valorTipo)) {
                errores += 1;
                System.err.println("Error de tipos. El identificador del vector es tipo " +
                        tipo + " pero la expresion en la posicion " +
                        i + " es tipo " + valor.getTipo());
            }
            i += 1;
        }
        return errores;
    }

    public String code_I(Bloque bloque, GeneradorCodigo gc) {
        String s = "";
        if(this.valores != null){
            for(Integer i=0; i<valores.size(); ++i){
                s += id.code_D(bloque, gc);
                s += "i32.const ";
                s += i.toString() + "\n";
                s += "i32.const 4\n";
                s += "i32.mul\n";
                s += "i32.add\n";
                s += valores.pollFirst().code_E(bloque, gc);
                s += "i32.store\n";
            }        
        }
        return s;
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
        s += b_prof + "---" +  "{Asignacion vector}\n";
        s += b_prof + "   |---Identificador: " + id.toString() + '\n';
        if(niveles.size() == prof+1) niveles.add(true);
        else niveles.set(prof+1,true);
        if(valores != null) {
            s += b_prof + "   |---Valor:\n";
            for(Expresion v: valores) {
                s += b_prof + "   |   |---Elemento: " + v.toString(prof+2,niveles) + '\n';
            }
        }
        niveles.set(prof+1,false);
        niveles.set(prof,false);
        return s;
     }
    
}
