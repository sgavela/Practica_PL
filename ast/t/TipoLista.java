package ast.t;

public class TipoLista extends Tipo{
    private Tipo tipoLista; 
    private int tam;
    
    public TipoLista(Tipo tipo, String n) {
        super(Tipos.LIST);
        this.tipoLista = tipoLista;
        this.tam = Integer.parseInt(n);
    }
    
    public Tipo getTipoLista(){
         return this.tipoLista;
     }

    public String toString() {
        return "vector<" + tipoLista.toString() + ',' + tam + '>';
    }
    
    public int length(){
        return tam;
    }
   
}
