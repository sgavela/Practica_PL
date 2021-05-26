java -cp jlex.jar JLex.Main alex/AnalizadorLexicoTiny.l
cd alex
del AnalizadorLexicoTiny.java 
ren AnalizadorLexicoTiny.l.java AnalizadorLexicoTiny.java
cd ../
java -cp cup.jar java_cup.Main -parser AnalizadorSintacticoTiny -symbols ClaseLexica -nopositions asint/Tiny.cup
cd asint
del AnalizadorSintacticoTiny.java 
del ClaseLexica.java
cd ../
move AnalizadorSintacticoTiny.java asint 
move ClaseLexica.java asint
javac -cp cup.jar alex/*.java asint/*.java ast/*.java ast/e/*.java ast/t/*.java ast/i/*.java errors/*.java asem/*.java generador_codigo/*.java
java -cp ".;cup.jar" asint.Main "Ficheros test"/test_generacion_basica3.txt
wat2wasm.exe codigo.wat
node main.js