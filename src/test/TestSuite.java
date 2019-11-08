package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ MatrizTest.class, CalculusTest.class, VerificadorComandosTest.class, ControladorTest.class, VerificadorTestDespersistirSinArchivo.class,
					VerificadorTestDespersistirConArchivo.class})

public class TestSuite 
{

}
