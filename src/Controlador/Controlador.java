package Controlador;

import Vista.InterfazVista;
import Vista.Vista;

import excepciones.Error000;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Calculus;
import modelo.Matriz;
import modelo.Verificador;

public class Controlador implements ActionListener {
    private InterfazVista vista;
    
    
    public Controlador(Vista vista) {
        this.vista = vista;
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getActionCommand().equals(InterfazVista.EJECUTAR)) {
            String instruccion = vista.getInstruccion();
            if (instruccion != null && !instruccion.isEmpty()) {
                try {
                    Matriz resultado=null;
                    Verificador verificador = new Verificador();
                    verificador.verficaComando(instruccion);
                    verificador.lectura();
                    verificador.funcion();
                    
                    if(!verificador.getComando1().equalsIgnoreCase("D"))
                        resultado = verificador.getMatriz3();
                    else
                        vista.agregaDeterminante(verificador.getMatriz1() ,verificador.getDeterminante());
                        
                    if (resultado != null) {
                        vista.agregaResultado(verificador.getComando1(),verificador.getMatriz1(),verificador.getMatriz2(), resultado);
                    }
                    
                } catch (Exception e) {
                    vista.agregaError(e.getMessage());
                }
            } else {
                vista.muestraAlertaInstruccionInvalida();
            }
        }
    }
}