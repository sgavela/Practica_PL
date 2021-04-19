package ast;

public class ProgramaCompleto {
    private Cabecera cabecera;
    private CuerpoMain cmain;
    
    public ProgramaCompleto(Cabecera cabecera, CuerpoMain cmain) {
        this.cabecera = cabecera;
        this.cmain = cmain;
    }
    
    public String toString() {
        String s = cabecera.toString() + cmain.toString();
        return s;
    }
}
