package modelo;

public class Matriz {
    private String nombre,descripcion;
    private int fila,columna;
    private double mat[][];
    
    public Matriz(){
        
    }
    
    /**
     * <b>Pre:</b> fila y columna deben ser mayores que 0. <br>
     * 
     * @param nombre
     * @param descripcion
     * @param fila
     * @param columna
     */
    
    public Matriz(String nombre, String descripcion, int fila, int columna) {
        
        assert fila > 0 : "Se quiso crear una Matriz con valor de fila negativo o cero.";
        assert columna > 0 : "Se quiso crear una Matriz con valor de columna negativo o cero.";
        
        
        this.nombre=nombre;
        this.descripcion=descripcion;
        this.fila=fila;
        this.columna=columna;
        this.mat = new double [fila][columna];
               
    }
    
    
    /**
     * Este metodo inserta un valor en la posicion [i,j] de la matriz.<br>
     * 
     * <b>Pre:</b> 0 <= i < this.fila, 0 <= j < this.columna.<br>
     * 
     * @param i Es la posición de la fila de la matriz.
     * @param j Es la posición de la columna de la matriz.
     * @param valor Es un valor double que se desea insertar en la posición [i,j] de la matriz.
     */
    public void inserta(int fila, int columna,double valor){
        assert fila >= 0 : "Se intenta insertar un valor en una fila negativa.";
        assert fila < this.fila : "Se intenta insertar un valor en una fila afuera de la matriz.";
        assert columna >= 0 : "Se intenta insertar un valor en una columna negativa.";
        assert columna < this.columna : "Se intenta insertar un valor en una fila afuera de la matriz.";
        
        this.mat[fila][columna]=valor;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public void setMat(double[][] mat) {
        this.mat = mat;
    }

    public double[][] getMat() {
        return mat;
    }
    
    /**
     * Retorna el valor de la matriz en la posicion [i,j].<br>
     *
     * <b>Pre:</b> 0 <= i < this.fila, 0 <= j < this.columna.<br>
     * 
     * @param i Es la posición de la fila de la matriz.
     * @param j Es la posición de la columna de la matriz. 
     * @return
     */
    
    public double getValor(int fila,int columna){
        
        assert fila >= 0 : "Se intenta acceder a un valor en una fila negativa.";
        assert fila < this.fila : "Se intenta acceder a un valor en una fila afuera de la matriz.";
        assert columna >= 0 : "Se intenta acceder a un valor en una columna negativa.";
        assert columna < this.columna : "Se intenta acceder a un valor en una fila afuera de la matriz.";
        
        
        return mat[fila][columna];
    }
    

    public String toString (){
        String cad="";
        int i,j;
        cad+= "Nombre: " + this.nombre + "\n" + "Descripcion: " + this.descripcion + "\n";
        for (i=0;i<this.fila;i++){
            for (j=0;j<this.columna;j++){
                cad+=mat[i][j]+",";
            }
            cad+="\n";
        }
        return cad;
    }
}
