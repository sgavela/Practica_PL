package ast;

import java.util.ArrayList;
import asem.TablaSimbolos;

public class ProgramaCompleto {
    private Cabecera cabecera;
    private CuerpoMain cmain;
    
    public ProgramaCompleto(Cabecera cabecera, CuerpoMain cmain) {
        this.cabecera = cabecera;
        this.cmain = cmain;
    }

    public int vinculacion(TablaSimbolos ts) {
        ts.abreBloque();
        int errores = cabecera.vinculacion(ts);
        errores += cmain.vinculacion(ts);
        ts.cierraBloque();
        return errores;
    }
    
    public int chequea() {
        int errores = cabecera.chequea();
        errores += cmain.chequea();
        return errores;
    }
    
    public String toString() {
        ArrayList<Boolean> niveles = new ArrayList<Boolean>();
        niveles.add(true);
        String s = "{Programa completo}\n";
        s += cabecera.toString(1, niveles) + cmain.toString(1, niveles);
        return s;
    }
}
