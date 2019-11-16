package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    MatrizTest.class, CalculusTest.class,
    VerificadorComandosTestConArchivos.class, /*VerificadorComandosTestSinArchivos.class,*/
    ControladorTest.class,
    VerificadorTestDespersistirSinArchivo.class, VerificadorTestDespersistirConArchivo.class,
    VerificadorFuncionTest.class})
public class TestSuite 
{

}
