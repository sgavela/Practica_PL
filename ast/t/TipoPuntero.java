package ast.t;

public class TipoPuntero extends Tipo {
	private Tipo tipoPuntero;

    public TipoPuntero(Tipo tipoPuntero) {
        super(Tipos.PUNT);
        this.tipoPuntero = tipoPuntero;
    }
    
    public Tipo getTipoPuntero() {
        return this.tipoPuntero;
    }
    
    public int getTam(){
       return 1;
   }
    
    public String toString(){
        return tipoPuntero.toString() + '$';
    }
}
