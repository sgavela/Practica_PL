package ast;

import java.util.ArrayList;

public class ProgramaCompleto {
    private Cabecera cabecera;
    private CuerpoMain cmain;
    
    public ProgramaCompleto(Cabecera cabecera, CuerpoMain cmain) {
        this.cabecera = cabecera;
        this.cmain = cmain;
    }
    
    public String toString() {
        ArrayList<Boolean> niveles = new ArrayList<Boolean>();
        niveles.add(true);
        String s = "{Programa completo}\n";
        s += cabecera.toString(1, niveles) + cmain.toString(1, niveles);
        return s;
    }
}
