package modelo;

import excepciones.Error000;
import excepciones.Error001;
import excepciones.Error002;
import excepciones.Error003;

import excepciones.Error004;

import excepciones.Error005;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Verificador {
    private String comando1;
    private Matriz matriz1,matriz2,matriz3;
    private String comando2=null,comando3=null,comando4=null,comando5=null;
    private double determinante;
    private boolean error=false;
    
    public Verificador(){
        
    }


    public String getComando1() {
        return comando1;
    }

    public Matriz getMatriz1() {
        return matriz1;
    }

    public Matriz getMatriz2() {
        return matriz2;
    }

    public Matriz getMatriz3() {
        return matriz3;
    }

    public String getComando2() {
        return comando2;
    }

    public String getComando3() {
        return comando3;
    }

    public String getComando4() {
        return comando4;
    }

    public String getComando5() {
        return comando5;
    }

    public boolean isError() {
        return error;
    }


    public double getDeterminante() {
        return determinante;
    }
    
    /**
         *
         * @param cadena
         * @throws Error000
         * @throws Error002
         * @throws Error005
         * @throws Error001
         * @throws IOException
         * Verifica que el comando mandando sea el correcto, si no lo es lanza excepciones.
         * <b>Pre:</b>Cadena!=null.
         * Si la operacion es el determinante, no puede venir con el nombre de la matriz o nombre de un archivo ( ya que esta mal crear el archivo con solo un dato). No dice nada pero lo elegimos asi.
         * <br>
         * 
         * <b>Post:</b>Si hay error lanza la excepcion correspondiente, sino el programa sigue su ejecucion.<br>
         */

    public void verficaComando(String cadena) throws Error000, Error002, Error005,Error001, IOException {
        String [] vecStrings;
        vecStrings=cadena.split(" ");
        
        assert cadena!=null : "El comando recibido es nulo";

        if (vecStrings.length>=6)
            throw new Error000();
    
        
        
        if  (vecStrings.length >= 2){
            this.comando1=vecStrings[0];
            this.comando1=comando1.toUpperCase();
            this.comando2=vecStrings[1];
        }
        else
            throw new Error000();
        
        switch(this.comando1.charAt(0)){
        case 'S':
        case 'R':
        case 'M':
        if (vecStrings.length<=2)
        throw new Error000();
        break;
        }
        
        
        if  (vecStrings.length >= 3) 
            this.comando3=vecStrings[2];
        if  (vecStrings.length >= 3 && vecStrings[0].equalsIgnoreCase("D")) 
            throw new Error000();

        if  (vecStrings.length >= 4) 
            this.comando4=vecStrings[3];
        if  (vecStrings.length >= 5) 
            this.comando5=vecStrings[4];
        
        
        if (this.comando1!=null && this.comando1.length()==1){
            
            if (verificaExtension(comando2)){
                throw new Error000();
            }
            
            
            switch(this.comando1.charAt(0)){
            
            case 'D':
            case 'T':
               
                    if (vecStrings.length >=3 && vecStrings[2]!=null){ // SI ES NULO SIGNIFICA QUE NO HAY OPCIONALES
                        
                         // "MATRIZ SALIDA"
                        
                        if (verificaExtension(comando3)){ // SI TERMINA EN .MAT ES EL DISPOSITIVO
                            if (this.comando4!=null)
                                throw new Error000(); //SI ESTE TMB TERMINA EN .MAT HAY ERROR
                            else
                                this.comando5=comando3; //SI TERMINA EN .MAT SIGNIFICA QUE ES EL DISPOSITIVO ( NOMBRE DEL ARCHIVO)
                        }
                        else{ //ES DECIR QUE ES EL NOMBRE DE LA MATRIZ DE SALIDA
                            
                                if (comando4!=null && !verificaExtension(comando4)) //SI NO ES NULO Y NO TERMINA EN .MAT ESTA MAL FORMADO EL COMANDO
                                    throw new Error000();
                                else
                                    if (comando4!=null)
                                        comando5=comando4;  //HAY Q CREAR UN ARCHIVO Y GUARDAR LA MATRIZ
                        }
                    }
            
            break;
            case 'S': 
            case 'M':
            case 'R':
                
                if (verificaExtension(comando3) || verificaExtension(comando2))
                    throw new Error000();
                
                if (vecStrings.length >=4 && vecStrings[3]!=null){ // SI ES NULO SIGNIFICA QUE NO HAY OPCIONALES
                                        
                    if (verificaExtension(comando4)){ // SI TERMINA EN .MAT ES EL DISPOSITIVO
                        if (this.comando5!=null)
                            throw new Error000();
                    
                        this.comando5=comando4;
                        
    
                    }
                    else{
                        if (comando5!=null)
                            if (!verificaExtension(comando5))
                                throw new Error002();
                        
                    }
                    String sCarpAct = System.getProperty("user.dir"),cad="";
                    System.out.println("Carpeta del usuario = " + sCarpAct);

                    //Listemos todas las carpetas y archivos de la carpeta actual

                    File carpeta = new File(sCarpAct+"/Datos");
                    
                    File fichero = null;
                    BufferedWriter bw = null;
                  
                    File archivo = new File(carpeta+"/"+comando5);
                    if (archivo.exists() && comando5!=null)
                        throw new Error005();
 
                    
                }
                
                
                break;
            
            default : throw new Error001();
            }
        }
        
        else
            throw new Error000();

     
    }
    
    /**
     *
     * @param cadena
     * @return
     * Comprueba si el string termina en .mat para asegurarse que se especifico la matriz de salida
     * <b>Pre:</b> Cadena!=null.<br>
     * <b>Post:</b>Devuelve true o false dependiendo el caso .<br>
     * Invariante: Cadena no varia.
     */
    
    public boolean verificaExtension(String cadena){
        int largo,i;
        
        if (cadena != null){
        largo=cadena.length();
        
        
            if (cadena.endsWith(".mat"))
                return true;
            else
                return false;
    
        
        }
        else
            return false;

       // if (cadena.charAt(largo-3)=='.' )
            //&& cadena.charAt(largo-2)=='m' && cadena.charAt(largo-1)=='a' && cadena.charAt(largo-0)=='t' )
              
    }
    
    /**
     *
     * @throws IOException
     * @throws Error003
     * @throws Error001
     * Lee el o los archivos dependiendo la operacion. 
     *  <b>Pre:</b>Los archivos si existen, estan escritos de forma correcta (como dice que esta compuesto en la SRS).<br>
     *  Matriz1 y Matriz2 son nulas
     * <b>Post:</b>Crea y carga las matrices. .<br>
     */
    
    
    public void lectura() throws IOException,Error003, Error001 {
        
        String nombre,descripcion,linea;
        int i,j,fila,columna;
        double valor;
        File archivo1=null,archivo2=null;
        FileReader fr;
        BufferedReader br;
        
        // --------------------
        
        String sCarpAct = System.getProperty("user.dir");
        System.out.println("Carpeta del usuario = " + sCarpAct);

        //Listemos todas las carpetas y archivos de la carpeta actual

         File carpeta = new File(sCarpAct+"/Datos");
         String[] listado = carpeta.list();
         
         if (listado == null || listado.length == 0) {
        System.out.println("No hay elementos dentro de la carpeta actual");
            return;
         }
        else {
            i=0;
            while ( i< listado.length && (archivo1==null  ||  archivo2==null  &&(comando1.equalsIgnoreCase("S") || comando1.equalsIgnoreCase("M") || comando1.equalsIgnoreCase("R") ) ) ) {
                
                if (listado[i].equalsIgnoreCase(this.comando2+".txt") || listado[i].equalsIgnoreCase(this.comando2+".mat"))
                    archivo1= new File (carpeta+"/"+listado[i]);
                    
                else {
                    if (listado[i].equalsIgnoreCase(this.comando3+".txt") || listado[i].equalsIgnoreCase(this.comando3+".mat"))
                        archivo2= new File (carpeta+"/"+listado[i]);
                }
                    
                i++;
            }
        }
        
        
            

        
        
        if (archivo1!=null){  
            try {
            fr = new FileReader(archivo1);
            br = new BufferedReader (fr);
            nombre=br.readLine();
            descripcion=br.readLine();
            linea= br.readLine();
                
            String [] vecStrings;
            vecStrings=linea.split(",");
            
            fila=Integer.parseInt( vecStrings[0]);
            columna=Integer.parseInt( vecStrings[1]);
            
            matriz1= new Matriz (nombre,descripcion,fila,columna);
                
            for (i=0;i<fila;i++){
                linea=br.readLine();
                vecStrings=linea.split(",");
                for (j=0;j<columna;j++){
                    valor=Double.parseDouble(vecStrings[j]);
                    
                    matriz1.inserta(i, j, valor);
                 }
            }
                fr.close();
                br.close();
            } 
            catch (Exception e){
                e.printStackTrace();
            }
            
            
          
        }
        else throw new Error003();
                
            
           
        if (comando1.equalsIgnoreCase("S") || comando1.equalsIgnoreCase("M") || comando1.equalsIgnoreCase("R")){ //esto es que archivo2 es necesario
            String nombre2,descripcion2;
            //File archivo2 = new File (archivo2);  //no se si esta bien esto
            FileReader fr2;
            BufferedReader br2;
            
            if (archivo2!=null) {
                
                try {
                
                fr2 = new FileReader(archivo2);
                br2 = new BufferedReader (fr2);    
                    
                    
                nombre=br2.readLine();
                descripcion=br2.readLine();
                linea= br2.readLine();
                    
                String [] vecStrings;
                vecStrings=linea.split(",");
                
                fila=Integer.parseInt( vecStrings[0]);
                columna=Integer.parseInt( vecStrings[1]);
                
                matriz2= new Matriz (nombre,descripcion,fila,columna);
                    
                for (i=0;i<fila;i++){
                    linea=br2.readLine();
                    vecStrings=linea.split(",");
                    for (j=0;j<columna;j++){
                        valor=Double.parseDouble(vecStrings[j]);
                        
                        matriz2.inserta(i, j, valor);
                     }
                }
                    fr2.close();
                    br2.close();
                } 
                catch (Exception e){
                    e.printStackTrace();
                }
            
                
            }
            else throw new Error003();
            
        }
    }
    /**
     *
     * @throws Error004
     * @throws Error003
     * @throws Error005
     *  <b>Pre:</b>La matriz o matrices estan cargadas correctamente, la operacion es correcta, .<br>
     * <b>Post:</b> El determinante varia o la matriz3 se crea. Si comando5!=null se crea un archivo (si no existe) con la matriz3.<br>
     * Invariantes: La Matriz1 y Matriz2 no varian.
     * 
     */
    
    
    public void funcion () throws Error004, Error003,Error005 {
        
        
              
        
        if (comando1.equalsIgnoreCase("D")){
            if (matriz1.getColumna()==matriz1.getFila())
                determinante = Calculus.getInstance().determinante( matriz1);
            else
                throw new Error004();
        }
        else
            if (comando1.equalsIgnoreCase("T")){
                matriz3=Calculus.getInstance().traspuesta( matriz1);
            }
            else{
                if (comando1.equalsIgnoreCase("S")){
                    
                    if (matriz1.getNombre()==null || matriz2.getNombre()==null)
                        throw new Error003();
                    
                    if (matriz1.getColumna()!=matriz2.getColumna() || matriz1.getFila()!=matriz2.getFila()) //SON DISTINTAS NO PUEDO SUMARLAS
                        throw new Error004();
                    else 
                        matriz3=Calculus.getInstance().sumar( matriz1,  matriz2);
                }
                else{
                    if (comando1.equalsIgnoreCase("M")){
                        if (matriz1.getNombre()==null || matriz2.getNombre()==null)
                            throw new Error003();
                        
                        if (matriz1.getColumna()==matriz2.getFila())
                            matriz3=Calculus.getInstance().multiplicar( matriz1,  matriz2);
                        else
                            throw new Error004();
                    }
                    else
                        if (comando1.equalsIgnoreCase("R")){
                            if (matriz1.getNombre()==null || matriz2.getNombre()==null)
                                throw new Error003();
                            
                            if (matriz1.getColumna()!=matriz2.getColumna() || matriz1.getFila()!=matriz2.getFila()) //SON DISTINTAS NO PUEDO Restarlas
                                throw new Error004();
                            else 
                                matriz3=Calculus.getInstance().restar( matriz1,  matriz2);
                        }
            
                }
        
        }
       
        //AHORA TENGO Q ESCRIBIR EL ARCHIVO,ES DECIR (DISPOSITIVO Q SERIA COMANDO5 EXISTE)
        if (comando4!=null && !comando4.endsWith(".mat") && (comando1.equalsIgnoreCase("S") || comando1.equalsIgnoreCase("M") || comando1.equalsIgnoreCase("R")))
            matriz3.setNombre(comando4);
        else
            if (comando3!=null && !comando3.endsWith(".mat") && comando1.equalsIgnoreCase("T") )
                matriz3.setNombre(comando3);
        
        
        if (comando5!=null){
            
            
            String sCarpAct = System.getProperty("user.dir"),cad="";
            System.out.println("Carpeta del usuario = " + sCarpAct);

            //Listemos todas las carpetas y archivos de la carpeta actual

            File carpeta = new File(sCarpAct+"/Datos");
            
            File fichero = null;
            BufferedWriter bw = null;
            try
            {
               
                
                File archivo = new File(carpeta+"/"+comando5);
                bw = new BufferedWriter(new FileWriter(archivo));
            
                
                bw.write(matriz3.getNombre() + "\n" + matriz3.getDescripcion() + "\n");
                bw.write(matriz3.getFila()+","+matriz3.getColumna()+"\n");
                for (int i = 0; i < matriz3.getFila(); i++){
                    cad="";
                    for (int j=0;j<matriz3.getColumna();j++)
                        cad+=(matriz3.getValor(i, j) + ",");
                    bw.write(cad+"\n");
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
               try {
               // Nuevamente aprovechamos el finally para 
               // asegurarnos que se cierra el fichero.
                if (null != bw)
                  bw.close();
                
               } catch (Exception e2) {
                  e2.printStackTrace();
               }
            }
        }
        if (!comando1.equalsIgnoreCase("D"))
            System.out.println(matriz3.toString());
        else
            System.out.println("Determinante: "+determinante);
    }
    
}
