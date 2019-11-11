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
import excepciones.Error005;
import modelo.Verificador;

public class VerificadorComandosTestConArchivos {
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
			archivo.createNewFile();
			archivo = new File(sCarpAct+"\\Datos\\mat2.mat");
			archivo.createNewFile();
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
	
	@Test
	public void verficarComandosTest_Clase_3_V1(){
		String cadena = "s mat1 mat2 mat3 archivo.mat resta";
			try {
				verificador.verficaComando(cadena);
				fail("No deberia llega aca.");
			} catch (Error000 e) {
				System.out.println("Correcto");
			} catch (Error002 e) {
				fail("No deberia entrar aca.");
			} catch (Error005 e) {
				fail("No deberia entrar aca.");
			} catch (Error001 e) {
				fail("No deberia entrar aca.");
			} catch (IOException e) {
				fail("No deberia entrar aca.");
			}
		
	}
	
	@Test
	public void verficarComandosTest_Clase_3_V2(){
		String cadena = "r mat1 archivo.mat";
			try {
				verificador.verficaComando(cadena);
				fail("No deberia llega aca.");
			} catch (Error000 e) {
				System.out.println("Correcto");
			} catch (Error002 e) {
				fail("No deberia entrar aca.");
			} catch (Error005 e) {
				fail("No deberia entrar aca.");
			} catch (Error001 e) {
				fail("No deberia entrar aca.");
			} catch (IOException e) {
				fail("No deberia entrar aca.");
			}
		
	}
	
	@Test
	public void verficarComandosTest_Clase_5(){
		String cadena = "m mat1";
			try {
				verificador.verficaComando(cadena);
				fail("No deberia llega aca.");
			} catch (Error000 e) {
				System.out.println("Correcto");
			} catch (Error002 e) {
				fail("No deberia entrar aca.");
			} catch (Error005 e) {
				fail("No deberia entrar aca.");
			} catch (Error001 e) {
				fail("No deberia entrar aca.");
			} catch (IOException e) {
				fail("No deberia entrar aca.");
			}
		
	}
	
	@Test
	public void verficarComandosTest_Clase_4(){
		String cadena = "st";
			try {
				verificador.verficaComando(cadena);
				fail("No deberia llega aca.");
			} catch (Error000 e) {
				System.out.println("Correcto");
			} catch (Error002 e) {
				fail("No deberia entrar aca.");
			} catch (Error005 e) {
				fail("No deberia entrar aca.");
			} catch (Error001 e) {
				fail("No deberia entrar aca.");
			} catch (IOException e) {
				fail("No deberia entrar aca.");
			}
		
	}
	
	@Test
	public void verficarComandosTest_Clase_6_V1(){
		String cadena = "mat1 mat2 s archivo.mat";
			try {
				verificador.verficaComando(cadena);
				fail("No deberia llega aca.");
			} catch (Error000 e) {
				System.out.println("Correcto");
			} catch (Error002 e) {
				fail("No deberia entrar aca.");
			} catch (Error005 e) {
				fail("No deberia entrar aca.");
			} catch (Error001 e) {
				fail("No deberia entrar aca.");
			} catch (IOException e) {
				fail("No deberia entrar aca.");
			}
		
	}
	
	
	@Test
	public void verficarComandosTest_Clase_6_V2(){
		String cadena = "t mat1 mat3.mat resta";
			try {
				verificador.verficaComando(cadena);
				fail("No deberia llega aca.");
			} catch (Error000 e) {
				System.out.println("Correcto");
			} catch (Error002 e) {
				fail("No deberia entrar aca.");
			} catch (Error005 e) {
				fail("No deberia entrar aca.");
			} catch (Error001 e) {
				fail("No deberia entrar aca.");
			} catch (IOException e) {
				fail("No deberia entrar aca.");
			}
		
	}
	
	@Test
	public void verficarComandosTest_Clase_6_V3(){
		String cadena = "r mat1 mat2 mat3.mat s";
			try {
				verificador.verficaComando(cadena);
				fail("No deberia llega aca.");
			} catch (Error000 e) {
				System.out.println("Correcto");
			} catch (Error002 e) {
				fail("No deberia entrar aca.");
			} catch (Error005 e) {
				fail("No deberia entrar aca.");
			} catch (Error001 e) {
				fail("No deberia entrar aca.");
			} catch (IOException e) {
				fail("No deberia entrar aca.");
			}
		
	}
	
	@Test
	public void verficarComandosTest_Clase_7(){
		String cadena = "s mat1 mat2 mat3 archivo.dat";
			try {
				verificador.verficaComando(cadena);
				fail("No deberia llega aca.");
			} catch (Error000 e) {
				fail("No deberia entrar aca.");
			} catch (Error002 e) {
				System.out.println("Correcto");
			} catch (Error005 e) {
				fail("No deberia entrar aca.");
			} catch (Error001 e) {
				fail("No deberia entrar aca.");
			} catch (IOException e) {
				fail("No deberia entrar aca.");
			}	
	}
	
	@Test
	public void verficarComandosTest_Clase_7_V2(){
		String cadena = "t mat1 mat3 mat3.txt";
			try {
				verificador.verficaComando(cadena);
				fail("No deberia llega aca.");
			} catch (Error000 e) {
				fail("No deberia llega aca.");
			} catch (Error002 e) {
				System.out.println("Correcto");
			} catch (Error005 e) {
				System.out.println("Correcto.");
			} catch (Error001 e) {
				fail("No deberia entrar aca.");
			} catch (IOException e) {
				fail("No deberia entrar aca.");
			}
	}
	
	@Test
	public void verficarComandosTest_Clase_8(){
		String cadena = "f mat1 mat2 mat3 archivo.mat";
			try {
				verificador.verficaComando(cadena);
				fail("No deberia llega aca.");
			} catch (Error000 e) {
				fail("No deberia entrar aca.");
			} catch (Error002 e) {
				fail("No deberia entrar aca.");
			} catch (Error005 e) {
				fail("No deberia entrar aca.");
			} catch (Error001 e) {
				System.out.println("Correcto.");
			} catch (IOException e) {
				fail("No deberia entrar aca.");
			}
	}
	
	@Test
	public void verficarComandosTest_Clase_9_V1(){
		String cadena = "t mat1 mat1.mat";
			try {
				verificador.verficaComando(cadena);
				fail("No deberia llega aca.");
			} catch (Error000 e) {
				fail("No deberia llega aca.");
			} catch (Error002 e) {
				fail("No deberia entrar aca.");
			} catch (Error005 e) {
				System.out.println("Correcto.");
			} catch (Error001 e) {
				fail("No deberia entrar aca.");
			} catch (IOException e) {
				fail("No deberia entrar aca.");
			}
	}
	
	@Test
	public void verficarComandosTest_Clase_9_V2(){
		String cadena = "r mat1 mat2 mat1.mat";
			try {
				verificador.verficaComando(cadena);
				fail("No deberia llega aca.");
			} catch (Error000 e) {
				fail("No deberia llega aca.");
			} catch (Error002 e) {
				fail("No deberia entrar aca.");
			} catch (Error005 e) {
				System.out.println("Correcto.");
			} catch (Error001 e) {
				fail("No deberia entrar aca.");
			} catch (IOException e) {
				fail("No deberia entrar aca.");
			}
	}
	
	@Test
	public void verficarComandosTest_Clase_15(){
		String cadena = "t archivo.mat";
			try {
				verificador.verficaComando(cadena);
				fail("No deberia llega aca.");
			} catch (Error000 e) {
				System.out.println("Correcto");
			} catch (Error002 e) {
				fail("No deberia entrar aca.");
			} catch (Error005 e) {
				fail("No deberia entrar aca.");
			} catch (Error001 e) {
				fail("No deberia entrar aca.");
			} catch (IOException e) {
				fail("No deberia entrar aca.");
			}
	}
	
	@Test
	public void verficarComandosTest_Clase_1_10_11_12_13(){
		String cadena = "r mat1 mat2 mat3 archivo.mat";
			try {
				verificador.verficaComando(cadena);
			} catch (Error000 e) {
				fail("No deberia entrar aca.");
			} catch (Error002 e) {
				fail("No deberia entrar aca.");
			} catch (Error005 e) {
				fail("No deberia entrar aca.");
				e.printStackTrace();
			} catch (Error001 e) {
				fail("No deberia entrar aca.");
			} catch (IOException e) {
				fail("No deberia entrar aca.");
			}
		
	}
	
	@Test
	public void verficarComandosTest_Clase_2_11_13_14(){
		String cadena = "d mat1 archivo.mat";
			try {
				verificador.verficaComando(cadena);
			} catch (Error000 e) {
				fail("No deberia entrar aca.");
			} catch (Error002 e) {
				fail("No deberia entrar aca.");
			} catch (Error005 e) {
				fail("No deberia entrar aca.");
			} catch (Error001 e) {
				fail("No deberia entrar aca.");
			} catch (IOException e) {
				fail("No deberia entrar aca.");
			}
	}
	
	@Test
	public void verficarComandosTest_Clase_2_11_13_14_V2(){
		String cadena = "t mat2 mat3 archivo.mat";
			try {
				verificador.verficaComando(cadena);
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
			}
	}
}
