package generador_codigo;

import java.util.ArrayList;

import ast.i.Instruccion;

public class GeneradorCodigo {
    private ArrayList<Bloque> bloques;

    public GeneradorCodigo() {
        bloques = new ArrayList<>();
    }

    public void abreBloque(Bloque bloque_padre) {
        Bloque bloque = new Bloque(bloque_padre);
        this.bloques.add(bloque);
    }

    public void cierraBloque() {
        this.bloques.remove(bloques.size()-1);
    }

    public String generaCodigo(Instruccion ins) {
        String s = "";
        s += ins.code_I(bloques.get(bloques.size()-1), this);
        return s;
    }

    public Bloque getLastBloque() {
        return bloques.get(bloques.size()-1);
    }

    public ArrayList<Bloque> getBloques() {
        return this.bloques;
    }

}
