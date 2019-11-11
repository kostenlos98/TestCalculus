package test;

import static org.junit.Assert.fail;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import excepciones.Error000;
import excepciones.Error001;
import excepciones.Error002;
import excepciones.Error003;
import excepciones.Error005;
import modelo.Verificador;

public class VerificadorTestDespersistirConArchivo {
	Verificador verificador;
	
	@Before
	public void setUp(){
		this.verificador = new Verificador();
		File archivo;
		//Creacion de dos archivos iguales.
		try {
			String sCarpAct = System.getProperty("user.dir"),cad="";
			File carpetaDatos = new File(sCarpAct+"\\Datos");
			if(!carpetaDatos.exists())
				carpetaDatos.mkdir();
			archivo = new File(sCarpAct+"\\Datos\\mat1.mat");
			this.crearArchivo(archivo);
			archivo = new File(sCarpAct+"\\Datos\\mat2.mat");
			this.crearArchivo(archivo);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@After
	public void tearDown() {
		//Eliminacion de los dos archivos.
		File archivo;
		this.verificador = null;
		String sCarpAct = System.getProperty("user.dir"),cad="";
		archivo = new File(sCarpAct+"\\Datos\\mat1.mat");
		archivo.delete();
		archivo = new File(sCarpAct+"\\Datos\\mat2.mat");
		archivo.delete();
	}
	
	private void crearArchivo(File archivo) throws IOException{
		FileWriter escritor;
		BufferedWriter buffEscritor;
		if(!archivo.exists()) 
			archivo.createNewFile();
		escritor = new FileWriter(archivo);
		buffEscritor = new BufferedWriter(escritor);
		buffEscritor.write("Generico");
		buffEscritor.newLine();
		buffEscritor.write("Numeros");
		buffEscritor.newLine();
		buffEscritor.write("2,2");
		buffEscritor.newLine();
		buffEscritor.write("1,1");
		buffEscritor.newLine();
		buffEscritor.write("1,1");
		buffEscritor.close();
		escritor.close();
	}
	
	@Test
	public void despersistirConArchivoTest_1_2() {
		try {
			verificador.verficaComando("s mat1 mat2");
			verificador.lectura();							
		} catch (Error000 e) {
			fail("No deberia entrar aca");
		} catch (Error002 e) {
			fail("No deberia entrar aca");
		} catch (Error005 e) {
			fail("No deberia entrar aca");
		} catch (Error001 e) {
			fail("No deberia entrar aca");
		} catch (IOException e) {
			fail("No deberia entrar aca");
		} catch (Error003 e) {
			fail("No deberia dar error.");
		} 
	}

	@Test
	public void despersistirConArchivoTest_3(){
		String cadena = "d mat1";
		try {
			verificador.verficaComando(cadena);
			verificador.lectura();		
		} catch (Error000 e) {
			fail("No deberia entrar aca.");
			e.printStackTrace();
		} catch (Error002 e) {
			fail("No deberia entrar aca.");
			e.printStackTrace();
		} catch (Error005 e) {
			fail("No deberia entrar aca.");
			e.printStackTrace();
		} catch (Error001 e) {
			fail("No deberia entrar aca.");
			e.printStackTrace();
		} catch (IOException e) {
			fail("No deberia entrar aca.");
			e.printStackTrace();
		} catch (Error003 e) {
			fail("No deberia entrar aca.");
		}
	}
	
	@Test
	public void despersistirConArchivoTest_4_5(){
		String cadena = "r mat3 mat5";
		try {
			verificador.verficaComando(cadena);
			verificador.lectura();		
			fail("No deberia entrar aca.");
		} catch (Error000 e) {
			fail("No deberia entrar aca.");
			e.printStackTrace();
		} catch (Error002 e) {
			fail("No deberia entrar aca.");
			e.printStackTrace();
		} catch (Error005 e) {
			fail("No deberia entrar aca.");
			e.printStackTrace();
		} catch (Error001 e) {
			fail("No deberia entrar aca.");
			e.printStackTrace();
		} catch (IOException e) {
			fail("No deberia entrar aca.");
			e.printStackTrace();
		} catch (Error003 e) {
			System.out.println("Correcto.");
		}
	}
	
	@Test
	public void despersistirConArchivoTest_1_5(){
		String cadena = "m mat1 mat3";
		try {
			verificador.verficaComando(cadena);
			verificador.lectura();		
			fail("No deberia entrar aca.");
		} catch (Error000 e) {
			fail("No deberia entrar aca.");
			e.printStackTrace();
		} catch (Error002 e) {
			fail("No deberia entrar aca.");
			e.printStackTrace();
		} catch (Error005 e) {
			fail("No deberia entrar aca.");
			e.printStackTrace();
		} catch (Error001 e) {
			fail("No deberia entrar aca.");
			e.printStackTrace();
		} catch (IOException e) {
			fail("No deberia entrar aca.");
			e.printStackTrace();
		} catch (Error003 e) {
			System.out.println("Correcto.");
		}
	}

	@Test
	public void despersistirConArchivoTest_6(){
		String cadena = "t mat3";
		try {
			verificador.verficaComando(cadena);
			verificador.lectura();		
			fail("No deberia entrar aca.");
		} catch (Error000 e) {
			fail("No deberia entrar aca.");
			e.printStackTrace();
		} catch (Error002 e) {
			fail("No deberia entrar aca.");
			e.printStackTrace();
		} catch (Error005 e) {
			fail("No deberia entrar aca.");
			e.printStackTrace();
		} catch (Error001 e) {
			fail("No deberia entrar aca.");
			e.printStackTrace();
		} catch (IOException e) {
			fail("No deberia entrar aca.");
			e.printStackTrace();
		} catch (Error003 e) {
			System.out.println("Correcto.");
		}
	}
}

