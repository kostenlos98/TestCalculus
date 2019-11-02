package Vista;

import Controlador.Controlador;

import excepciones.Error000;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import java.awt.GridLayout;
import java.awt.TextField;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import modelo.Matriz;

public class Vista extends JFrame implements InterfazVista {
    Controlador controlador;
    JButton ejecutarBoton = new JButton("Ejecutar");
    JTextArea instruccionField = new JTextArea();
    JTextArea errorField = new JTextArea();
    JTextArea resultadosField = new JTextArea();
    
    public Vista(String arg0) {
        super(arg0);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contenedorPrincipal = this.getContentPane();
        contenedorPrincipal.setLayout(new BorderLayout());
        JPanel panelNorte = new JPanel();
        JPanel panelOeste = new JPanel();
        JPanel subPanelOeste = new JPanel();
        subPanelOeste.setLayout(new BorderLayout());
        panelOeste.setLayout(new GridLayout(6,1,0,0));
        JLabel posiblesInstruccionesLabel = new JLabel("Instrucciones posibles: ");
        posiblesInstruccionesLabel.setBorder(new LineBorder(Color.BLACK));
        JLabel restaLabel = new JLabel("Resta -> R");
        JLabel sumaLabel = new JLabel("Suma -> S");
        JLabel determinanteLabel = new JLabel("Determinante -> D");
        JLabel trasposicionLabel = new JLabel("Traspuesta -> T");
        JLabel multiplicacionLabel = new JLabel("Multiplicacion -> M");
        panelOeste.add(posiblesInstruccionesLabel);
        panelOeste.add(restaLabel);
        panelOeste.add(sumaLabel);
        panelOeste.add(determinanteLabel);
        panelOeste.add(trasposicionLabel);
        panelOeste.add(multiplicacionLabel);
        subPanelOeste.add(panelOeste, BorderLayout.NORTH);
        contenedorPrincipal.add(subPanelOeste, BorderLayout.WEST);
        panelNorte.setLayout(new BorderLayout());
        instruccionField.setBorder(new LineBorder(Color.BLACK));
        instruccionField.setForeground(Color.BLACK);
        panelNorte.add(instruccionField, BorderLayout.CENTER);
        panelNorte.add(this.ejecutarBoton, BorderLayout.EAST);
        contenedorPrincipal.add(panelNorte, BorderLayout.NORTH);
        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new GridLayout(1,2,0,0));
        JPanel errorPanel = new JPanel();
        errorPanel.setLayout(new BorderLayout());
        JLabel errorLabel = new JLabel("Errores");
        errorLabel.setBorder(new LineBorder(Color.BLACK));
        errorField.setBorder(new LineBorder(Color.BLACK));
        errorField.setEnabled(false);
        errorField.setForeground(Color.BLACK);
        errorPanel.add(errorLabel, BorderLayout.NORTH);
        errorPanel.add(errorField, BorderLayout.CENTER);
        JPanel resultadosPanel = new JPanel();
        JLabel resultadosLabel = new JLabel("Resultados");
        resultadosLabel.setBorder(new LineBorder(Color.BLACK));
        resultadosPanel.setLayout(new BorderLayout());
        resultadosPanel.add(resultadosLabel, BorderLayout.NORTH);
        resultadosPanel.add(resultadosField, BorderLayout.CENTER);
        resultadosField.setEnabled(false);
        resultadosField.setBorder(new LineBorder(Color.BLACK));
        panelCentral.add(resultadosPanel);
        panelCentral.add(errorPanel);
        contenedorPrincipal.add(panelCentral, BorderLayout.CENTER);
    }
    
    public void setControlador(ActionListener c) {
        this.controlador = (Controlador) c;
        this.ejecutarBoton.addActionListener(c);
        this.ejecutarBoton.setActionCommand("EJECUTAR");
    }
    
    public void arranca(){
         pack();
        setBounds(200,200,900,500);
        setLocationRelativeTo(null);
        setVisible(true);
     }
    
    public String getInstruccion() {
        return this.instruccionField.getText();
    }

    
    public void agregaResultado(String operacion,Matriz matriz1,Matriz matriz2,Matriz matrizResultado) {
    
            switch(operacion.charAt(0)){
            case 'T':
                this.resultadosField.setText("Traspuesta de: \n\n" + matriz1.toString() + "\n Es:\n\n");
            break;
            case 'S':this.resultadosField.setText("La suma entre la matriz: \n\n" + matriz1.toString() + "\nY la matriz:\n\n "+ matriz2.toString()+ " Es:\n\n");

            break;
            case 'M':this.resultadosField.setText("La multiplicacion entre la matriz: \n\n" + matriz1.toString() + "\nY la matriz:\n\n "+ matriz2.toString()+ "Es:\n\n");
            break;
            case 'R':this.resultadosField.setText("La resta entre la matriz: \n\n" + matriz1.toString() + "\nY la matriz:\n \n"+ matriz2.toString()+ " Es:\n\n");
    
    
        }
        
        this.resultadosField.append(matrizResultado.toString());
    
    }
    public void agregaDeterminante(Matriz matriz,double determinante){
        this.resultadosField.setText("Determinante de \n" + matriz.toString()+ "\nEs igual a:" + determinante);
    }
    
    public void agregaError(String mensajeError) {
        this.errorField.append(mensajeError + "\n");
    }
    
    public void muestraAlertaInstruccionInvalida() {
        JOptionPane.showMessageDialog(null, "La instruccion no debe estar en blanco");
    }
   
    
}
