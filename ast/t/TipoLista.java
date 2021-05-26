package ast.t;

public class TipoLista extends Tipo{
    private Tipo tipoDeLaLista; 
    private int tam;
    
    public TipoLista(Tipo tipoDeLaLista, String n) {
        super(Tipos.LIST);
        this.tipoDeLaLista = tipoDeLaLista;
        this.tam = Integer.parseInt(n);
    }
    
    public Tipo getTipoDeLaLista(){
         return this.tipoDeLaLista;
     }

    public String toString() {
        return "vector<" + tipoDeLaLista.toString() + ',' + tam + '>';
    }
    
    public int length(){
        return tam;
    }

    //Para calcular lo que ocupa cada elemento de la lista (para generacion de codigo)
    public Integer size_elems() {
        Integer size = tam;
        if(tipoDeLaLista.getTipo() == Tipos.LIST) {
            size *= ((TipoLista) tipoDeLaLista).size_elems();
        }
        return size;
    }
   
}
