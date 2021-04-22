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
   
}
