package Vista;

import java.awt.event.ActionListener;

import modelo.Matriz;

public interface InterfazVista {
    static final String EJECUTAR = "EJECUTAR";
    
    public void setControlador(ActionListener c);
    public void arranca();
    public void muestraAlertaInstruccionInvalida();
    public String getInstruccion();
    public void agregaError(String mensajeError);

    public void agregaDeterminante(Matriz matriz, double d);

    public void agregaResultado(String string, Matriz matriz, Matriz matriz1, Matriz resultado);
}
