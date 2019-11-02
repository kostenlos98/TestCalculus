package excepciones;

public class Error003 extends Exception {
    public Error003(String string, Throwable throwable, boolean b, boolean b1) {
        super(string, throwable, b, b1);
    }

    public Error003(Throwable throwable) {
        super(throwable);
    }

    public Error003(String string, Throwable throwable) {
        super(string, throwable);
    }

    public Error003(String string) {
        super(string);
    }

    public Error003() {
        super("Error003: Matriz inexistente");
        System.out.println("Matriz inexistente");
    }
}
