package Main;

import Controlador.Controlador;
import Vista.Vista;

public class Principal {

    public static void main(String[] args) {
        Vista ventana = new Vista("probando");
        Controlador controlador = new Controlador(ventana);
        ventana.setControlador(controlador);
        ventana.arranca();
    }
}
