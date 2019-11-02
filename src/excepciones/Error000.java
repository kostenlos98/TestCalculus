package excepciones;

public class Error000 extends Exception {
   

    public Error000() {
        super("Error000: Comando mal formado: No cumple con la sintaxis descrita (faltan\n" + 
        "matrices, operaciones, dispositivos, operadores ó están en orden equivocado).");
        System.out.println( "Comando mal formado: No cumple con la sintaxis descrita (faltan\n" + 
        "matrices, operaciones, dispositivos, operadores ó están en orden equivocado).");
    }
}
