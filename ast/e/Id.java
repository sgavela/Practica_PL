package ast.e;

import ast.t.Tipo;
import ast.t.Tipos;
import ast.t.TipoLista;
import asem.TablaSimbolos;
import java.util.ArrayList;
import asem.ExcepcionIdNoExistente;
import errors.ExcepcionTipoDesconocido;
import generador_codigo.Bloque;
import generador_codigo.GeneradorCodigo;
import ast.getTipoVinculo;

public class Id extends Expresion{
	private String s;
	private Tipo tipo;
    private Object vinculoId;
    protected int fila;
	
    public Id(String s, int fila) {
        this.s = s;
        this.fila = fila;
    }

    public Id(String s) {
        this.s = s;
    }

    public int getFila(){
        return fila;
    }
    
    public Tipo getTipo() {
        return this.tipo;
    }
    
    public String getS() {
        return s;
    }

    public Expresiones tipo() {
        return Expresiones.ID;
    }

    public int vinculacion(TablaSimbolos ts) {
        int errores = 0;
        try {
            vinculoId = ts.buscaId(s);
        } catch (ExcepcionIdNoExistente e) {
            errores = 1;
            System.err.println("El identificador " + s + " no existe");
        }
        return errores;
    }

    public int chequea() {
        try {
            tipo = (new getTipoVinculo(vinculoId)).getTipo();
            return 0;
        } catch (ExcepcionTipoDesconocido e) {
            System.err.println("Error en la comprobación de tipo del vínculo " + vinculoId
                    + " del identificador " + s);
            return 1;
        }
    }
    
    public String toString() {
        return s;
    }

    public String toString(int prof, ArrayList<Boolean> niveles) {
        return s;
    }

    public String code_D(Bloque bloque, GeneradorCodigo gc) {
        String s = "";
        for(int i=gc.getBloques().size()-1; i>=0; --i){
            if(gc.getBloques().get(i).hasId(this.s)){
                Integer realDirId = gc.getBloques().get(i).getDirId(this.s) * 4;
                s += "i32.const " + realDirId.toString() + '\n';
                Integer realDirInicio = gc.getBloques().get(i).getDirInicio() * 4;
                s += "i32.const " + realDirInicio.toString() + '\n';
                s += "i32.add\n";
                return s;
            }
        }
        return s;
    }

    public String code_E(Bloque bloque, GeneradorCodigo gc) {
        String s = "";
        s += this.code_D(bloque, gc);
        s += "i32.load\n";
        return s;
    }
}
