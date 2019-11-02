package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Invariante de clase: Matriz1 y Matriz2 no varian nunca.
 * 
 */
public class Calculus {
    private static Calculus instancia=null;

    
    public static  Calculus getInstance(){
        if (instancia==null)
            instancia= new Calculus();
        
        return instancia;
    }
    
    private Calculus() {
        super();
    }
    //TODO Es precondicion en todas que las dimensiones de las matrices sean mayores a cero?.
    /**
     * Este metodo suma una matriz con otra, elemento a elemento, y lo retorna en una matriz.<br>
     *
     * <b>Pre:</b> Dimensiones de matriz1 y matriz2 iguales y mayores a cero.<br>
     * <b>Post:</b> Devuelve una matriz con las mismas dimensiones que matriz1 y matriz2.<br>
     *
     * @param matriz1 Es la primer matriz, debe ser != null.
     * @param matriz2 Es la segunda matriz, debe ser != null.
     * @return
     */
    public Matriz sumar (Matriz matriz1, Matriz matriz2){
        //
        assert matriz1 != null : "Primer matriz parametro es null.";
        assert matriz2 != null : "Segunda matriz parametro es null.";
        assert matriz1.getColumna() == matriz2.getColumna() : "Cantidad de columnas de las matrices diferente";
        assert matriz1.getFila() == matriz2.getFila() : "Cantidad de filas de las matrices diferente.";
        //
        Matriz matriz3=new Matriz("Matriz resultante","Matriz resultante",matriz1.getFila(),matriz1.getColumna());
        
            int i,j;
            for (i=0;i<matriz1.getFila();i++){
                for(j=0;j<matriz1.getColumna();j++){
                    matriz3.inserta(i,j,matriz1.getValor(i,j)+matriz2.getValor(i, j));
                }
            }
        
            
        return matriz3;
    }
    /**
     * Resta la matriz2 a la matriz1 elemento a elemento, y lo retorna en una matriz.<br>
     *
     * <b>Pre:</b> dimensiones de matriz1 y matriz2 iguales.<br>
     * <b>Post:</b> devuelte una matriz con las mismas dimensiones que matriz1 y matriz2.<br>
     * 
     * @param matriz1 Es la primer matriz, debe ser != null.
     * @param matriz2 Es la segunda matriz, debe ser != null.
     * @return
     */
    public Matriz restar(Matriz matriz1, Matriz matriz2){
        
        
        //
        assert matriz1 != null : "Primer matriz parametro es null.";
        assert matriz2 != null : "Segunda matriz parametro es null.";
        assert matriz1.getColumna() == matriz2.getColumna() : "Cantidad de columnas de las matrices diferente";
        assert matriz1.getFila() == matriz2.getFila() : "Cantidad de filas de las matrices diferente.";
        //
        
        Matriz matriz3=new Matriz("Matriz resultante","Matriz resultante",matriz1.getFila(),matriz1.getColumna());
        int i,j;
        
        for (i=0;i<matriz1.getFila();i++){
            for(j=0;j<matriz1.getColumna();j++){
                matriz3.inserta(i,j,matriz1.getValor(i,j)-matriz2.getValor(i, j));
            }
        }
       
        
        return matriz3;
    }
    /**
     * Devuelve la matriz traspuesta de la matriz1.<br>
     * 
     * <b>Post:</b> Devuelve una Matriz != null que es la matriz traspuesta, y sus dimensiones estan invertidas.<br>
     * 
     * @param matriz1 Es la matriz a trasponer, debe ser != null.
     * @return
     */
    public Matriz traspuesta(Matriz matriz1){
        
        //
        assert matriz1 != null : "La matriz parametro es null.";
        //
        
        Matriz matriz3=new Matriz("Matriz resultante","Matriz resultante",matriz1.getFila(),matriz1.getColumna());

        int i,j;
        
        for (i=0;i<matriz1.getFila();i++){
            for (j=0;j<matriz1.getColumna();j++){
                matriz3.inserta(j, i, matriz1.getValor(i, j));
            }
        }
     
     
        return matriz3;   
    }
    /**
     * Devuelve el resultado del determinante de una matriz.<br>
     * 
     * <b>Pre:</b> La matriz debe ser cuadrada (N x N).<br>
     * No puede ser de dimensiones mayores a 3 x 3 (por implementacion).<br>
     * 
     * @param matriz1 Es la matriz de la cual se calcula el determinante, debe ser != null.
     * @return
     */
    public double determinante(Matriz matriz1){
        double valor=0;
        
        //
        assert matriz1 != null : "La matriz parametro es null.";
        assert matriz1.getFila() == matriz1.getColumna() : "La matriz parametro no es cuadrada.";
        //
        
        switch(matriz1.getFila()){
        case 1: valor= matriz1.getValor(0, 0);
            break;
        case 2: valor = matriz1.getValor(0, 0)* matriz1.getValor(1, 1) - matriz1.getValor(0, 1) * matriz1.getValor(1, 0);
            break;
        case 3:
            valor += matriz1.getValor(1, 1)* matriz1.getValor(2, 2) * matriz1.getValor(3, 3);
            valor += matriz1.getValor(1, 2)* matriz1.getValor(2, 3) * matriz1.getValor(3, 1);
            valor += matriz1.getValor(1, 3)* matriz1.getValor(2, 1) * matriz1.getValor(3, 2);
            valor -= matriz1.getValor(1, 3)* matriz1.getValor(2, 2) * matriz1.getValor(3, 1);
            valor -= matriz1.getValor(1, 1)* matriz1.getValor(2, 3) * matriz1.getValor(3, 2);
            valor -= matriz1.getValor(1, 2)* matriz1.getValor(2, 1) * matriz1.getValor(3, 3);
            break;
        default:
            
            break;
        
            
        }
        
        return valor;
    }
    
    /**
     * Devuelve el resultado de la multiplicacion matricial de dos matrices, en una Matriz.<br>
     * 
     * <b>Pre:</b> Cantidad de columnas de la matriz1 == cantidad de filas de la matriz2.<br>
     * 
     * <b>Post:</b> Retorna una Matriz de dimensiones M x P.
     * 
     * @param matriz1 Es la primer matriz, debe ser != null.
     * @param matriz2 Es la segunda matriz, debe ser != null.
     * @return 
     */

    public Matriz multiplicar(Matriz matriz1,Matriz matriz2){
        
        //
        assert matriz1 != null : "Primer matriz parametro es null.";
        assert matriz2 != null : "Segunda matriz parametro es null.";
        
        
        Matriz matriz3=new Matriz("Matriz resultante","Matriz resultante",matriz1.getFila(),matriz2.getColumna());
        int i,j,k;
        int valor;
        
        for ( i = 0; i < matriz1.getFila(); i++) {
            
            for ( j = 0; j < matriz2.getColumna(); j++) {
                valor=0;
                for ( k = 0; k <matriz1.getColumna(); k++) {
                    // aquí se multiplica la matriz
                    valor += matriz1.getValor(i,k) * matriz2.getValor(k,j);
                }
                    matriz3.inserta(i,j,valor);
            }
        }

        return matriz3;
    }
    
}
