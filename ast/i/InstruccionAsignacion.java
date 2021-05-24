package ast.i;

import ast.e.Expresion;
import ast.e.Id;
import ast.e.ListIndex;
import java.util.ArrayList;
import asem.TablaSimbolos;
import ast.t.Tipo;
import generador_codigo.Bloque;
import generador_codigo.GeneradorCodigo;
import ast.e.List;

public class InstruccionAsignacion extends Instruccion {
    private Id identificador;
    private Expresion valor;
    private Object vinculo;
    
    public InstruccionAsignacion(Id identificador, Expresion valor) {
        this.identificador = identificador;
        this.valor = valor;
    }
    
    public TipoInstruccion getTipo() {
        return TipoInstruccion.ASIG;
    }

    public Id getId() {
        return this.identificador;
    }

    public int vinculacion(TablaSimbolos ts) {
        int errores = 0;
        errores += this.identificador.vinculacion(ts);
        errores += valor.vinculacion(ts);
        return errores;
    }

    public int chequea() {
        if(valor instanceof List){
            System.out.println("No esta implementado el analisis semantico para la asignacion de vectores completos");
            /*
            List lista = (List) valor;
            int errores = 0;      
            int i = 0;
            //Tipo tipo = lista.getTipo();
            Tipo tipo = identificador.getTipo();
            System.out.println(identificador);
            for(Expresion v : lista.getList()){
                Tipo valorTipo = v.getTipo();
                //System.out.println(valorTipo);
                if (!tipo.equals(valorTipo)) {
                    errores += 1;
                    System.err.println("Error de tipos. El identificador del vector es tipo " +
                              " pero la expresion en la posicion " +
                            i + " es tipo " + v.getTipo());
                }
                i += 1;
            }
            return errores;
            */
            return 0;
        }
        else{
            int errores = identificador.chequea();
            
            errores += valor.chequea();       

            Tipo tipoId = identificador.getTipo();
            Tipo tipoValor = valor.getTipo();
            
            if (!tipoId.equals(tipoValor)) {
                errores += 1;
                //idTipo=id.getFila();           
                System.err.println("Error de tipos. " + "El tipo del identificador es "
                    +identificador.getTipo()+" pero el de la expresion es " + valor.getTipo());
            }
            return errores;
        }
    }

    public String code_I(Bloque bloque, GeneradorCodigo gc) {
        String s = "";
        s += identificador.code_D(bloque, gc);
        s += valor.code_E(bloque, gc);
        s += "i32.store\n";
        return s;
    }
    
    public Expresion getValor() {
        return this.valor;
    }
    
    public String toString(int prof, ArrayList<Boolean> niveles) {
        String s = "";
        String b_prof = "";
        if(niveles.size() == prof) niveles.add(true);
        else niveles.set(prof,true);
        for(int i=0; i<prof-1; ++i){
            if(niveles.get(i)) b_prof += '|';
            b_prof += "   ";
        }
        b_prof += '|';
        if(niveles.size() == prof+1) niveles.add(false);
        else niveles.set(prof+1,false);
        s += b_prof + "---{Asignacion}\n";
        s += b_prof + "   " + "|" + "---" + "Identificador: " + identificador.toString() + '\n';
        s += b_prof + "   " + "|" + "---" + "Valor: " + valor.toString(prof+1,niveles) + '\n';
        niveles.set(prof,false);
        return s;
    }
    
}
