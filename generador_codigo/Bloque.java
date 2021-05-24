package generador_codigo;

import java.util.HashMap;
import java.util.Map;

import ast.e.Id;

public class Bloque {
    //Par identificador - dirección local del identificador
    private Map<String,Integer> direccion_identificador = new HashMap<>();
    //Bloque padre en caso de anidamiento
    private Bloque bloque_padre;
    private int next_direccion;
    //Dirección real de inicio del bloque 
    private int dir_inicio;

    public Bloque(Bloque bloque_padre) {
        this.bloque_padre = bloque_padre;
        this.next_direccion = 0;
        if(this.bloque_padre != null) {
            dir_inicio = this.bloque_padre.getDirInicio() + this.bloque_padre.getNextDir();
        }
        else {
            dir_inicio = 0;
        }
    }

    public int getNextDir() {
        return next_direccion;
    }

    public void addDirId(String id, int size) {
        direccion_identificador.put(id, next_direccion);
        next_direccion+=size;
    }

    public Integer getDirId(String id) {
        return direccion_identificador.get(id);
    }

    public Integer getDirInicio() {
        return Integer.valueOf(dir_inicio);
    }

    public boolean hasId(String id) {
        return direccion_identificador.containsKey(id);
    }
    //Al final de la ejecucion de un bloque, next_direccion es igual al tamaño de memoria que necesita 
     public int tamBloque() {
         return next_direccion;
     }

}