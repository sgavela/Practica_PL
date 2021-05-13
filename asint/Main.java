package asint;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Iterator;

import alex.AnalizadorLexicoTiny;
import ast.ProgramaCompleto;
import asem.TablaSimbolos;

public class Main {
   public static void main(String[] args) throws Exception {
		Reader input = new InputStreamReader(new FileInputStream(args[0]));
		AnalizadorLexicoTiny alex = new AnalizadorLexicoTiny(input);
		AnalizadorSintacticoTiny asint = new AnalizadorSintacticoTiny(alex);

		ProgramaCompleto ast = (ProgramaCompleto) asint.parse().value;
		System.out.println(ast);

		TablaSimbolos ts = new TablaSimbolos();
		int errores = ast.vinculacion(ts);
		if(errores > 0) {
			System.err.println("Error en la vinculacion");
			return;
		}
		else{
			System.out.println("No se han encontrado errores en la vinculacion,"+
				" se pasa a la comprobacion de tipos");
		}

		errores += ast.chequea();
		if(errores > 0) {
			System.err.println("Error en la comprobacion de tipos");
			return;
		}
		else{
			System.out.println("No se han encontrado errores en la comprobacion de tipos,"+
				" se pasa a la generacion de codigo");
		}
	}  
} 
   
