package test;

import java.io.File;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.fail;

import excepciones.Error000;
import excepciones.Error001;
import excepciones.Error002;
import excepciones.Error003;
import excepciones.Error005;
import modelo.Verificador;

public class VerificadorTestDespersistirSinArchivo {
	
	@Before
	public void setUp() {
		String sCarpAct = System.getProperty("user.dir");
		File carpetaDatos = new File(sCarpAct+"\\Datos");
		if(!carpetaDatos.exists())
			carpetaDatos.mkdir();
		File archivo = new File(sCarpAct+"\\Datos\\mat1.txt");
		File archivo2 = new File(sCarpAct+"\\Datos\\mat2.txt");
		if(archivo.exists()) 
			archivo.delete();
		if(archivo2.exists())
			archivo2.delete();
	}
	
	@Test
	public void despersistirSinArchivoTest_1() {
		Verificador verificador = new Verificador();
		try {
			verificador.verficaComando("s mat1 mat2");
			verificador.lectura();						
			fail("Deberia dar error.");
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
			System.out.println("Correcto");
		}
	}
	
	@Test
	public void despersistirSinArchivoTest_2() {
		Verificador verificador = new Verificador();
		try {
			verificador.verficaComando("d mat1");
			verificador.lectura();						
			fail("Deberia dar error.");
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
			System.out.println("Correcto");
		}
	}
}

