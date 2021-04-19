package ast.t;

public class TipoStruct extends Tipo{
    private String id;
    private int tam;
    
    public TipoStruct(String id) {
        super(Tipos.DEF);
        this.id = id;
    }  
    
    public TipoStruct(String idStruct, int tam) {
        super(Tipos.DEF);
        this.id= idStruct;
        this.tam = tam;
    }    
    
    public String getNombreRegistro(){
        return this.id;
    }
    
    public int getTam(){
        return this.tam;
    }

    public String toString() {
        return id.toString() + " (userdef)";
    }
}
