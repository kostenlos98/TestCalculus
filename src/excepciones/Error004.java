package excepciones;

public class Error004 extends Exception {
    public Error004(String string, Throwable throwable, boolean b, boolean b1) {
        super(string, throwable, b, b1);
    }

    public Error004(Throwable throwable) {
        super(throwable);
    }

    public Error004(String string, Throwable throwable) {
        super(string, throwable);
    }

    public Error004(String string) {
        super(string);
    }

    public Error004() {
        super("Error004: Operación no realizable: dimensiones inconsistentes.");
        System.out.println(" Operación no realizable: dimensiones inconsistentes.");
    }
}
