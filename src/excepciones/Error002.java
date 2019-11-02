package excepciones;

public class Error002 extends Exception {
    public Error002(String string, Throwable throwable, boolean b, boolean b1) {
        super(string, throwable, b, b1);
    }

    public Error002(Throwable throwable) {
        super(throwable);
    }

    public Error002(String string, Throwable throwable) {
        super(string, throwable);
    }

    public Error002(String string) {
        super(string);
    }

    public Error002() {
        super("Error002: Dispositivo no conocido: En el lugar donde se espera la palabra\n" + 
        "reservada indicando un dispositivo no figura una palabra válida, o el formato de\n" + 
        "archivo no es .mat ");
        System.out.println(" Dispositivo no conocido: En el lugar donde se espera la palabra\n" + 
        "reservada indicando un dispositivo no figura una palabra válida, o el formato de\n" + 
        "archivo no es .mat ");
    }
}
