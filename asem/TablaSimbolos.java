package asem;

import ast.e.Id;
import java.util.ArrayList;

public class TablaSimbolos {
    private ArrayList<Marco> marcos;
    
    public TablaSimbolos(){
        this.marcos = new ArrayList<>();
    }
    
    public void abreBloque(){
        marcos.add(new Marco());
    }
    
    public void cierraBloque() {
        marcos.remove(marcos.size() - 1);
    }
    
    public int insertaId(Id id, Object puntero) {
        Marco marcoActual = marcos.get(marcos.size() - 1);
        if (marcoActual.buscarIdentificador(id.toString()) != null) {
           System.err.println("Error. " + " Identificador " + id + " repetido");
           return 1;
        }
        else {
           marcos.get(marcos.size() - 1).addEntrada(id.toString(), puntero);
           return 0;
        }  
    }
    
    public int eliminaId(String id) {
        Marco marcoActual = marcos.get(marcos.size() - 1);
        if (marcoActual.buscarIdentificador(id) != null) {
           marcoActual.borrarEntrada(id);
           return 0;
        } else {
           System.err.println("Error. Imposible eliminar " + id + "del marco, ya que no existe.");
           return 1;
        }  
    }
    
    public Object buscaId(String id) throws ExcepcionIdNoExistente {
        for (int i = marcos.size() -1; i >= 0; --i) {
            Object res = marcos.get(i).buscarIdentificador(id);
            if (res != null) {
                return res;
            }
        }
        throw new ExcepcionIdNoExistente(id);
    }
}

