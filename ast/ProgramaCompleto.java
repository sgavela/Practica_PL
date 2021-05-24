package ast;

import java.util.ArrayList;
import asem.TablaSimbolos;
import generador_codigo.GeneradorCodigo;

public class ProgramaCompleto {
    private Cabecera cabecera;
    private CuerpoMain cmain;
    
    public ProgramaCompleto(Cabecera cabecera, CuerpoMain cmain) {
        this.cabecera = cabecera;
        this.cmain = cmain;
    }

    public int vinculacion(TablaSimbolos ts) {
        ts.abreBloque();
        int errores = cabecera.vinculacion(ts);
        errores += cmain.vinculacion(ts);
        ts.cierraBloque();
        return errores;
    }
    
    public int chequea() {
        int errores = cabecera.chequea();
        errores += cmain.chequea();
        return errores;
    } 

    public String genera_codigo(GeneradorCodigo gc) {
        String s = "(module\n(import \"runtime\" \"print\" (func $print (param i32)))\n";
        s += "(memory 2000)\n(global $SP (mut i32) (i32.const 0)) ;; start of stack\n";
        s += "(global $MP (mut i32) (i32.const 0)) ;; mark pointer\n";
        s += "(global $NP (mut i32) (i32.const 131071996)) ;; heap 2000*64*1024-4\n";
        s += "(func $reserveStack (param $size i32)\n";
        s += "(result i32)\n";
        s += "get_global $MP\nget_global $SP\nset_global $MP\nget_global $SP\nget_local $size\ni32.add\nset_global $SP\n)\n";
        //s += "get_global $SP\nget_global $NP\ni32.gt_u\nif\ni32.const 3\ncall $exception\nend\n)\n";
        s += "(start $init)\n(func $init\n";
        gc.abreBloque(null);
        s += cabecera.genera_codigo(gc);
        gc.abreBloque(gc.getLastBloque());
        s += cmain.genera_codigo(gc);
        s += ")\n(export \"init\" (func $init))\n)\n";
        gc.cierraBloque();
        gc.cierraBloque();
        return s;
    }
    
    public String toString() {
        ArrayList<Boolean> niveles = new ArrayList<Boolean>();
        niveles.add(true);
        String s = "{Programa completo}\n";
        s += cabecera.toString(1, niveles) + cmain.toString(1, niveles);
        return s;
    }
}
