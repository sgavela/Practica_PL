package ast.e;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class List extends Expresion {
	private ArrayDeque<Expresion> l;

    public List() {
        l = new ArrayDeque<Expresion>();
    }

    public List(ArrayDeque<Expresion> l) {
        this.l = l;
    }

    public void addElem(Expresion e) {
        l.addFirst(e);
    }
   
    public ArrayDeque<Expresion> valores() {
        return l;
    }

    public String toString(int prof, ArrayList<Boolean> niveles) {
        return l.toString();
    }

    public String toString() {
        return l.toString();
    }

    @Override
    public Expresiones tipo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
