package ast.t;

import ast.e.Id;

public class Tipo_Id {
    protected Tipo tipo;
    protected Id nombre;
    
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
  
}
