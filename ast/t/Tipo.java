package ast.t;

public class Tipo {
private Tipos tipo;
    
    public Tipo(Tipos tipo) {
        this.tipo = tipo;
    }

    public Tipos getTipo() {
        return tipo;
    }
    
    public boolean igual_tipo(Tipo t) {
        return this.tipo == t.tipo;
    }
}
