package excepciones;

public class Error005 extends Exception {
    public Error005(String string, Throwable throwable, boolean b, boolean b1) {
        super(string, throwable, b, b1);
    }

    public Error005(Throwable throwable) {
        super(throwable);
    }

    public Error005(String string, Throwable throwable) {
        super(string, throwable);
    }

    public Error005(String string) {
        super(string);
    }

    public Error005() {
        super("Error005: Matriz de salida ya existe.");
        System.out.println(" Matriz de salida ya existe.");
    }
}
