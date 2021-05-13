package ast.t;

import ast.e.Id;
import asem.TablaSimbolos;

public class Tipo_Id {
    protected Tipo tipo;
    protected Id nombre;
    protected Object vinculo;
    
    public Tipo_Id(Tipo tipo, Id nombre) {
        this.tipo = tipo;
        this.nombre = nombre;
    }
    
    public Tipo getTipo() {
        return this.tipo;
    }
    
    public Id getNombre() {
        return this.nombre;
    }

    public int vinculacion(TablaSimbolos ts) {
        int errores = 0;
        return errores + ts.insertaId(nombre, this);
    }
        

    public int chequea() {
       return 0;
    }
}
