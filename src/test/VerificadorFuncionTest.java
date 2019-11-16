package test;

import excepciones.Error004;
import excepciones.Error005;
import java.io.*;
import modelo.Verificador;
import modelo.Matriz;
import org.junit.*;
import static org.junit.Assert.*;

public class VerificadorFuncionTest {
    private Verificador verificador;

    // defino el directorio de datos
    private final File carpeta = new File(System.getProperty("user.dir") + "\\Datos");
    
    // defino las matrices de que voy a usar en los test
    private final String[][] matrices = {
	{"matrizA", "matriz de prueba", "2,2", "1,3", "7,19"},
	{"matrizB", "matriz de prueba", "2,2", "2,6", "5,13"},
	{"matrizC", "matriz de prueba", "3,2", "4,0", "1,6", "3,15"}
    };
    
    
    /**
     * <b>Post</b>: Se crea el directorio Datos
     */
    private void crearDirectorioDatos() {
	if (!this.carpeta.exists()) {
	    this.carpeta.mkdir();
	}
    }
        
    /**
     * <b>Post</b>: Se eliminan todos los archivos del directorio Datos
     */
    private void vaciarDirectorioDatos() {
	File[] files = this.carpeta.listFiles();
	if (files != null) {
	    for (File f : files) {
		if (!f.isDirectory()) {
		    f.delete();
		}
	    }
	}
    }
        
    /**
     * <b>Pre</b>: El directorio existe, las matrices no existen.
     * <b>Post</b>: Creo las matrices establecidas para los casos de prueba en el directorio Datos
     */
    private void crearMatrices() throws IOException {
	FileWriter escritor;
	BufferedWriter buffEscritor;

	for (int i = 0; i < this.matrices.length; i++) {
	    String path = this.carpeta.getPath() + "\\" + this.matrices[i][0] + ".mat";

	    File archivo = new File(path);
	    archivo.createNewFile();

	    escritor = new FileWriter(path);
	    buffEscritor = new BufferedWriter(escritor);

	    for (int j = 0; j < this.matrices[i].length; j++) {
		buffEscritor.write(this.matrices[i][j]);
		buffEscritor.newLine();
	    }

	    buffEscritor.close();
	    escritor.close();
	}
    }

    
    
    
    @Before
    public void setUp() {
	this.verificador = new Verificador();
	try {
	    this.crearDirectorioDatos();
	    this.vaciarDirectorioDatos(); // en caso de que haya matrices que coinciden en nombre
	    this.crearMatrices();
	} catch (IOException e) {
	    fail("No se pudo establecer el escenario (método setUp)");
	}
    }
    
    
    @After
    public void tearDown() {
	this.verificador = null;
    }
    
    
    
    /**
     * Verifica el invariante del método funcion()
     * @param oldM1 Matriz1 antes de que comienze el test
     * @param oldM2 Matriz2 antes de que comienze el test
     * @param test String que caracterice al test (título)
     */
    private void verificarInvariante(Matriz oldM1, Matriz oldM2, String test) {
	assertEquals("No se verifica invariante en " + test + " - la matriz 1 se modificó", oldM1, this.verificador.getMatriz1());
	assertEquals("No se verifica invariante en " + test + " - la matriz 2 se modificó", oldM2, this.verificador.getMatriz2());
    }
    
    
    
    /* ====================================================
	    TEST DE CAJA NEGRA
    ==================================================== */
    @Test
    public void testEscenario1() {
	final int n = 1;
	
	// establezco el escenario
	try {
	    String comando = "D matrizA";
	    this.verificador.verficaComando(comando);
	    this.verificador.lectura();
	} catch (Exception e) {
	    fail("No se pudo establecer el escenario " + n);
	}
	
	// para verificar invariante
	final Matriz oldM1 = this.verificador.getMatriz1();
	final Matriz oldM2 = this.verificador.getMatriz2();
	
	// test
	double detViejo = this.verificador.getDeterminante();
	try{
	    this.verificador.funcion();
	    double detModificado = this.verificador.getDeterminante();
	    System.out.println(String.format("testEscenario %d | valor pre: %.2f | valor post: %.2f", n, detViejo, detModificado));
	    assertTrue(detViejo != detModificado); // se ha modificado el determinante
	    
	    this.verificarInvariante(oldM1, oldM2, "testEscenario" + n);
	} catch (Error004 ex) {
	    fail("testEscenario" + n + " lanza Error004, debería ejecutarse correctamente");
	} catch (Error005 ex) {
	    fail("testEscenario" + n + " lanza Error005, debería ejecutarse correctamente");
	} catch (Exception e) {
	    fail("testEscenario" + n + " crashea, debería ejecutarse correctamente");
	}
    }
    
    @Test
    public void testEscenario2() {
	final int n = 2;
	
	// establezco el escenario
	try {
	    String comando = "S matrizA matrizB";
	    this.verificador.verficaComando(comando);
	    this.verificador.lectura();
	} catch (Exception e) {
	    fail("No se pudo establecer el escenario " + n);
	}
	
	// para verificar invariante
	final Matriz oldM1 = this.verificador.getMatriz1();
	final Matriz oldM2 = this.verificador.getMatriz2();
	
	// test
	Matriz mat3Viejo = this.verificador.getMatriz3();
	try{
	    this.verificador.funcion();
	    Matriz mat3Nuevo = this.verificador.getMatriz3();
	    assertTrue(mat3Viejo != mat3Nuevo);  // se ha creado la matriz 3 (cambia la referencia al objeto Matriz)
	    
	    this.verificarInvariante(oldM1, oldM2, "testEscenario" + n);
	} catch (Error004 ex) {
	    fail("testEscenario" + n + " lanza Error004, debería ejecutarse correctamente");
	} catch (Error005 ex) {
	    fail("testEscenario" + n + " lanza Error005, debería ejecutarse correctamente");
	} catch (Exception e) {
	    fail("testEscenario" + n + " crashea, debería ejecutarse correctamente");
	}
    }
    
    @Test
    public void testEscenario3() {
	final int n = 3;
	
	// establezco el escenario
	try {
	    String comando = "S matrizA matrizC";
	    this.verificador.verficaComando(comando);
	    this.verificador.lectura();
	} catch (Exception e) {
	    fail("No se pudo establecer el escenario " + n);
	}
	
	// test
	try{
	    this.verificador.funcion();
	    fail("testEscenario" + n + " se ejecuta correctamente, debería lanzar Error004");
	} catch (Error004 ex) {
	    System.out.println("testEscenario" + n + " OK: lanza Error004");
	} catch (Error005 ex) {
	    fail("testEscenario" + n + " lanza Error005, debería lanzar Error004");
	} catch (Exception e) {
	    fail("testEscenario" + n + " crashea, debería lanzar Error004");
	}
    }
    
    @Test
    public void testEscenario4() {
	final int n = 4;
	
	// establezco el escenario
	try {
	    // creo la matriz necesaria para causar Error005
	    File matRes = new File(this.carpeta.getPath() + "\\matRes.mat");
	    matRes.createNewFile();
	    
	    String comando = "S matrizA matrizB matRes.mat";
	    this.verificador.verficaComando(comando);
	    this.verificador.lectura();
	} catch (Exception e) {
	    fail("No se pudo establecer el escenario " + n);
	}
	
	// test
	try{
	    this.verificador.funcion();
	    fail("testEscenario" + n + " se ejecuta correctamente, debería lanzar Error005");
	} catch (Error004 ex) {
	    fail("testEscenario" + n + " lanza Error004, debería lanzar Error005");
	} catch (Error005 ex) {
	    System.out.println("testEscenario" + n + " OK: lanza Error005");
	} catch (Exception e) {
	    fail("testEscenario" + n + " crashea, debería lanzar Error005");
	}
    }
    
    
    
    /* ====================================================
	    TEST DE CAJA BLANCA
    ==================================================== */
    @Test
    public void testC2() {
	final int n = 2;
	
	// establezco el escenario
	try {
	    String comando = "D matrizC";
	    this.verificador.verficaComando(comando);
	    this.verificador.lectura();
	} catch (Exception e) {
	    fail("No se pudo establecer el escenario para el testC" + n);
	}
	
	// test
	try{
	    this.verificador.funcion();
	    fail("testC" + n + " se ejecuta correctamente, debería lanzar Error004");
	} catch (Error004 ex) {
	    System.out.println("testC" + n + " OK: lanza Error004");
	} catch (Error005 ex) {
	    fail("testC" + n + " lanza Error005, debería lanzar Error004");
	} catch (Exception e) {
	    fail("testC" + n + " crashea, debería lanzar Error004");
	}
    }
    
    @Test
    public void testC3() {
	final int n = 3;
	
	// establezco el escenario
	try {
	    String comando = "T matrizC";
	    this.verificador.verficaComando(comando);
	    this.verificador.lectura();
	} catch (Exception e) {
	    fail("No se pudo establecer el escenario para el testC" + n);
	}
	
	// para verificar invariante
	final Matriz oldM1 = this.verificador.getMatriz1();
	final Matriz oldM2 = this.verificador.getMatriz2();
	
	// test
	Matriz mat3Viejo = this.verificador.getMatriz3();
	try{
	    this.verificador.funcion();
	    Matriz mat3Nuevo = this.verificador.getMatriz3();
	    assertTrue(mat3Viejo != mat3Nuevo);  // se ha creado la matriz 3 (cambia la referencia al objeto Matriz)
	    
	    this.verificarInvariante(oldM1, oldM2, "testC" + n);
	} catch (Error004 ex) {
	    fail("testC" + n + " lanza Error004, debería ejecutarse correctamente");
	} catch (Error005 ex) {
	    fail("testC" + n + " lanza Error005, debería ejecutarse correctamente");
	} catch (Exception e) {
	    fail("testC" + n + " crashea, debería ejecutarse correctamente");
	}
    }
    
    @Test
    public void testC6() {
	final int n = 6;
	
	// establezco el escenario
	try {
	    String comando = "S matrizA matrizB matC6.mat";
	    this.verificador.verficaComando(comando);
	    this.verificador.lectura();
	} catch (Exception e) {
	    fail("No se pudo establecer el escenario para el testC" + n);
	}
	
	// para verificar invariante
	final Matriz oldM1 = this.verificador.getMatriz1();
	final Matriz oldM2 = this.verificador.getMatriz2();
	
	// test
	Matriz mat3Viejo = this.verificador.getMatriz3();
	try{
	    this.verificador.funcion();
	    Matriz mat3Nuevo = this.verificador.getMatriz3();
	    assertTrue(mat3Viejo != mat3Nuevo);  // se ha creado la matriz 3 (cambia la referencia al objeto Matriz)
	    
	    this.verificarInvariante(oldM1, oldM2, "testC" + n);
	} catch (Error004 ex) {
	    fail("testC" + n + " lanza Error004, debería ejecutarse correctamente");
	} catch (Error005 ex) {
	    fail("testC" + n + " lanza Error005, debería ejecutarse correctamente");
	} catch (Exception e) {
	    fail("testC" + n + " crashea, debería ejecutarse correctamente");
	}
    }
    
    @Test
    public void testC8() {
	final int n = 8;
	
	// establezco el escenario
	try {
	    String comando = "M matrizA matrizC";
	    this.verificador.verficaComando(comando);
	    this.verificador.lectura();
	} catch (Exception e) {
	    fail("No se pudo establecer el escenario para el testC" + n);
	}
	
	// test
	try{
	    this.verificador.funcion();
	    fail("testC" + n + " se ejecuta correctamente, debería lanzar Error004");
	} catch (Error004 ex) {
	    System.out.println("testC" + n + " OK: lanza Error004");
	} catch (Error005 ex) {
	    fail("testC" + n + " lanza Error005, debería lanzar Error004");
	} catch (Exception e) {
	    fail("testC" + n + " crashea, debería lanzar Error004");
	}
    }
    
    @Test
    public void testC9() {
	final int n = 9;
	
	// establezco el escenario
	try {
	    String comando = "M matrizA matrizB";
	    this.verificador.verficaComando(comando);
	    this.verificador.lectura();
	} catch (Exception e) {
	    fail("No se pudo establecer el escenario para el testC" + n);
	}
	
	// para verificar invariante
	final Matriz oldM1 = this.verificador.getMatriz1();
	final Matriz oldM2 = this.verificador.getMatriz2();
	
	// test
	Matriz mat3Viejo = this.verificador.getMatriz3();
	try{
	    this.verificador.funcion();
	    Matriz mat3Nuevo = this.verificador.getMatriz3();
	    assertTrue(mat3Viejo != mat3Nuevo);  // se ha creado la matriz 3 (cambia la referencia al objeto Matriz)
	    
	    this.verificarInvariante(oldM1, oldM2, "testC" + n);
	} catch (Error004 ex) {
	    fail("testC" + n + " lanza Error004, debería ejecutarse correctamente");
	} catch (Error005 ex) {
	    fail("testC" + n + " lanza Error005, debería ejecutarse correctamente");
	} catch (Exception e) {
	    fail("testC" + n + " crashea, debería ejecutarse correctamente");
	}
    }
    
    @Test
    public void testC11() {
	final int n = 11;
	
	// establezco el escenario
	try {
	    String comando = "R matrizA matrizC";
	    this.verificador.verficaComando(comando);
	    this.verificador.lectura();
	} catch (Exception e) {
	    fail("No se pudo establecer el escenario para el testC" + n);
	}
	
	// test
	try{
	    this.verificador.funcion();
	    fail("testC" + n + " se ejecuta correctamente, debería lanzar Error004");
	} catch (Error004 ex) {
	    System.out.println("testC" + n + " OK: lanza Error004");
	} catch (Error005 ex) {
	    fail("testC" + n + " lanza Error005, debería lanzar Error004");
	} catch (Exception e) {
	    fail("testC" + n + " crashea, debería lanzar Error004");
	}
    }
    
    @Test
    public void testC12() {
	final int n = 12;
	
	// establezco el escenario
	try {
	    String comando = "R matrizA matrizB";
	    this.verificador.verficaComando(comando);
	    this.verificador.lectura();
	} catch (Exception e) {
	    fail("No se pudo establecer el escenario para el testC" + n);
	}
	
	// para verificar invariante
	final Matriz oldM1 = this.verificador.getMatriz1();
	final Matriz oldM2 = this.verificador.getMatriz2();
	
	// test
	Matriz mat3Viejo = this.verificador.getMatriz3();
	try{
	    this.verificador.funcion();
	    Matriz mat3Nuevo = this.verificador.getMatriz3();
	    assertTrue(mat3Viejo != mat3Nuevo);  // se ha creado la matriz 3 (cambia la referencia al objeto Matriz)
	    
	    this.verificarInvariante(oldM1, oldM2, "testC" + n);
	} catch (Error004 ex) {
	    fail("testC" + n + " lanza Error004, debería ejecutarse correctamente");
	} catch (Error005 ex) {
	    fail("testC" + n + " lanza Error005, debería ejecutarse correctamente");
	} catch (Exception e) {
	    fail("testC" + n + " crashea, debería ejecutarse correctamente");
	}
    }
    
    
    
    /* ====================================================
	    TEST DE PERSISTENCIA
    ==================================================== */
    @Test
    public void testPersSuma() {
	final String n = "Suma";
	final String arch = "marRes.mat";
	
	// establezco el escenario
	try {
	    String comando = "S matrizA matrizB " + arch;
	    this.verificador.verficaComando(comando);
	    this.verificador.lectura();
	} catch (Exception e) {
	    fail("No se pudo establecer el escenario para el testPers" + n);
	}
	
	// para verificar invariante
	final Matriz oldM1 = this.verificador.getMatriz1();
	final Matriz oldM2 = this.verificador.getMatriz2();
	
	// test
	try{
	    this.verificador.funcion();
	    File matRes = new File(this.carpeta.getPath() + "\\" + arch);
	    assertTrue("testPers" + n + ": no se creo el archivo " + arch, matRes.exists());
	    
	    this.verificarInvariante(oldM1, oldM2, "testPers" + n);
	} catch (Error004 ex) {
	    fail("testPers" + n + " lanza Error004, debería ejecutarse correctamente");
	} catch (Error005 ex) {
	    fail("testPers" + n + " lanza Error005, debería ejecutarse correctamente");
	} catch (Exception e) {
	    fail("testPers" + n + " crashea, debería ejecutarse correctamente");
	}
    }
    
    @Test
    public void testPersResta() {
	final String n = "Resta";
	final String arch = "marRes.mat";
	
	// establezco el escenario
	try {
	    String comando = "R matrizA matrizB " + arch;
	    this.verificador.verficaComando(comando);
	    this.verificador.lectura();
	} catch (Exception e) {
	    fail("No se pudo establecer el escenario para el testPers" + n);
	}
	
	// para verificar invariante
	final Matriz oldM1 = this.verificador.getMatriz1();
	final Matriz oldM2 = this.verificador.getMatriz2();
	
	// test
	try{
	    this.verificador.funcion();
	    File matRes = new File(this.carpeta.getPath() + "\\" + arch);
	    assertTrue("testPers" + n + ": no se creo el archivo " + arch, matRes.exists());
	    
	    this.verificarInvariante(oldM1, oldM2, "testPers" + n);
	} catch (Error004 ex) {
	    fail("testPers" + n + " lanza Error004, debería ejecutarse correctamente");
	} catch (Error005 ex) {
	    fail("testPers" + n + " lanza Error005, debería ejecutarse correctamente");
	} catch (Exception e) {
	    fail("testPers" + n + " crashea, debería ejecutarse correctamente");
	}
    }
    
    @Test
    public void testPersMult() {
	final String n = "Mult";
	final String arch = "marRes.mat";
	
	// establezco el escenario
	try {
	    String comando = "M matrizA matrizB " + arch;
	    this.verificador.verficaComando(comando);
	    this.verificador.lectura();
	} catch (Exception e) {
	    fail("No se pudo establecer el escenario para el testPers" + n);
	}
	
	// para verificar invariante
	final Matriz oldM1 = this.verificador.getMatriz1();
	final Matriz oldM2 = this.verificador.getMatriz2();
	
	// test
	try{
	    this.verificador.funcion();
	    File matRes = new File(this.carpeta.getPath() + "\\" + arch);
	    assertTrue("testPers" + n + ": no se creo el archivo " + arch, matRes.exists());
	    
	    this.verificarInvariante(oldM1, oldM2, "testPers" + n);
	} catch (Error004 ex) {
	    fail("testPers" + n + " lanza Error004, debería ejecutarse correctamente");
	} catch (Error005 ex) {
	    fail("testPers" + n + " lanza Error005, debería ejecutarse correctamente");
	} catch (Exception e) {
	    fail("testPers" + n + " crashea, debería ejecutarse correctamente");
	}
    }
    
    @Test
    public void testPersTrasp() {
	final String n = "Trasp";
	final String arch = "marRes.mat";
	
	// establezco el escenario
	try {
	    String comando = "T matrizA " + arch;
	    this.verificador.verficaComando(comando);
	    this.verificador.lectura();
	} catch (Exception e) {
	    fail("No se pudo establecer el escenario para el testPers" + n);
	}
	
	// para verificar invariante
	final Matriz oldM1 = this.verificador.getMatriz1();
	final Matriz oldM2 = this.verificador.getMatriz2();
	
	// test
	try{
	    this.verificador.funcion();
	    File matRes = new File(this.carpeta.getPath() + "\\" + arch);
	    assertTrue("testPers" + n + ": no se creo el archivo " + arch, matRes.exists());
	    
	    this.verificarInvariante(oldM1, oldM2, "testPers" + n);
	} catch (Error004 ex) {
	    fail("testPers" + n + " lanza Error004, debería ejecutarse correctamente");
	} catch (Error005 ex) {
	    fail("testPers" + n + " lanza Error005, debería ejecutarse correctamente");
	} catch (Exception e) {
	    fail("testPers" + n + " crashea, debería ejecutarse correctamente");
	}
    }
}
