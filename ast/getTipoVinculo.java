package ast;

import errors.ExcepcionTipoDesconocido;
import ast.i.InstruccionDeclaracion;
import ast.i.InstruccionDeclVector;
import ast.t.Tipo;
import ast.e.ListIndex;
import ast.i.InstruccionDeclFuncion;
import ast.t.Tipo_Id;

public class getTipoVinculo {
    private Object vinculo;
    
    public getTipoVinculo(Object vinculo) {
        this.vinculo = vinculo;
    }

    public Tipo getTipo() throws ExcepcionTipoDesconocido {
        if (vinculo instanceof InstruccionDeclaracion) {
            InstruccionDeclaracion vinculoIdDec = (InstruccionDeclaracion) vinculo;
            return vinculoIdDec.getTipo();
        }     
        else if (vinculo instanceof InstruccionDeclVector) {
            InstruccionDeclVector vinculoIdDec = (InstruccionDeclVector) vinculo;
            return vinculoIdDec.getTipo();
        }
        else if (vinculo instanceof Tipo_Id) {
            Tipo_Id vinculoIdDec = (Tipo_Id) vinculo;
            return vinculoIdDec.getTipo();
        }
        else if (vinculo instanceof InstruccionDeclFuncion) {
            InstruccionDeclFuncion vinculoIdDec = (InstruccionDeclFuncion) vinculo;
            return vinculoIdDec.getTipo();
        }           
        else throw new ExcepcionTipoDesconocido();
    }
}
