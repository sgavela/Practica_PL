package ast.e;

import java.util.ArrayDeque;
import java.util.ArrayList;
import asem.TablaSimbolos;
import ast.i.InstruccionDeclVector;
import ast.t.Tipo;
import ast.t.Tipos;
import ast.t.TipoLista;
import generador_codigo.Bloque;
import generador_codigo.GeneradorCodigo;

public class List extends Expresion {
	private ArrayDeque<Expresion> l;
    private Tipo tipoLista;
    private Object vinculo;

    public List() {
        l = new ArrayDeque<Expresion>();
    }

    public List(ArrayDeque<Expresion> l) {
        this.l = l;
    }

    public ArrayDeque<Expresion> getList() {
        return l;
    }

    public void addElem(Expresion e) {
        l.addFirst(e);
    }
   
    public ArrayDeque<Expresion> valores() {
        return l;
    }

    public String toString(int prof, ArrayList<Boolean> niveles) {
        return l.toString();
    }

    public int vinculacion(TablaSimbolos ts) {
        return 0;
    }

    public int chequea() {
        int errores = 0;
        InstruccionDeclVector vinculoVector = (InstruccionDeclVector) vinculo;
        tipoLista = vinculoVector.getTipo();       
        int i = 0;
        for(Expresion valor : l){
            Tipo valorTipo = valor.getTipo();
            if (!tipoLista.equals(valorTipo)) {
                errores += 1;
                System.err.println("Error de tipos. El identificador del vector es tipo " +
                        this.tipoLista + " pero la expresion en la posicion " +
                        i + " es tipo " + valor.getTipo());
            }
            i += 1;
        }
        if(i != vinculoVector.getTam()){
            errores += 1;
            System.err.println("Error de tipos. El tamanio declarado para el vector " + vinculoVector.getId() 
                        + " es " + vinculoVector.getValores().size() + " pero hay " + i + " elementos en la declaracion.");
        }
        return errores;
    }

    //Codigo de expresion de una lista en la forma [1,3,6,4] (no confundir con code_D de una lista como identificador)
    public String code_E(Bloque bloque, GeneradorCodigo gc) {
        String s = "";
        for(Expresion e: l) {
            s += e.code_E(bloque, gc);
        }
        return s;
    }

    public Tipo getTipo(){return tipoLista;}

    public String toString() {
        return l.toString();
    }

    @Override
    public Expresiones tipo() {
        return Expresiones.LIST;
    }

}
