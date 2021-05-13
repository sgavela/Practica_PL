package ast.e;

import ast.t.Tipo;
import asem.TablaSimbolos;
import java.util.ArrayList;
import asem.ExcepcionIdNoExistente;
import errors.ExcepcionTipoDesconocido;
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
}
