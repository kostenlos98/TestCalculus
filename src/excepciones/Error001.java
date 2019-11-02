package excepciones;

public class Error001 extends Exception {
    public Error001(String string, Throwable throwable, boolean b, boolean b1) {
        super(string, throwable, b, b1);
    }

    public Error001(Throwable throwable) {
        super(throwable);
    }

    public Error001(String string, Throwable throwable) {
        super(string, throwable);
    }

    public Error001(String string) {
        super(string);
    }

    public Error001() {
        super("Error001: Operación no conocida: En el lugar donde se espera la palabra\n" + 
        "reservada que indica la operación no figura una palabra válida.");
        System.out.println(" Operación no conocida: En el lugar donde se espera la palabra\n" + 
        "reservada que indica la operación no figura una palabra válida.");
    }
}