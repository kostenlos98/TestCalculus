package test;

import static org.junit.Assert.fail;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import excepciones.Error000;
import excepciones.Error001;
import excepciones.Error002;
import excepciones.Error005;
import modelo.Verificador;

public class VerificadorComandosTest {
	Verificador verificador;
	
	@Before
	public void setUp(){
		this.verificador = new Verificador();
	}
	
	@After
	public void tearDown() {
		this.verificador = null;
	}
	
	@Test
	public void verficarComandosTest_Clase_3(){
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
		String cadena = "s";
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
	public void verficarComandosTest_Clase_6(){
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
	public void verficarComandosTest_Clase_7(){
		String cadena = "s mat1 archivo.mat";
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
	public void verficarComandosTest_Clase_8(){
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
	public void verficarComandosTest_Clase_9(){
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
	public void verficarComandosTest_Clase_10(){
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
	public void verficarComandosTest_Clase_11(){
		String cadena = "r mat1 archivo.mat";
			try {
				verificador.verficaComando(cadena);
				fail("No deberia llega aca.");
			} catch (Error000 e) {
				System.out.println("Correcto");
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
	public void verficarComandosTest_Clase_22(){
		String cadena = "d archivo.mat";
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
	public void verficarComandosTest_Clase_23(){
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
	public void verficarComandosTest_Clase_1_13_15_16_17_18(){
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
	public void verficarComandosTest_Clase_1_12_17_18(){
		String cadena = "s mat1 mat2";
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
	public void verficarComandosTest_Clase_1_14_15_17_18(){
		String cadena = "m mat1 mat2 archivo.mat";
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
	public void verficarComandosTest_Clase_1_17_18_20(){
		String cadena = "d mat1";
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
	public void verficarComandosTest_Clase_2_15_16_17_18_21(){
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
