package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import modelo.Calculus;
import modelo.Matriz;

public class CalculusTest 
{
	public static final double[][] M1 = {{1.0f, -2.0f},{0.0f,4.0f}};
	public static final double[][] M2 = {{5.0f, 6.0f},{7.0f,8.0f}};
	public static final double[][] M3 = {{6.0f, 4.0f},{7.0f,12.0f}};
	public static final double[][] M4 = {{-2.0f,4.0f}};
	public static final double[][] M5 = {{-10.0f,16.0f}};
	public static final double[][] M6 = {{-2.0f, 4.0f}};
	
	public static final Matriz M7 = new Matriz("M1","M1",2,2);
	
	
    @Before 
    public void setUp()
    {
    		
    }
    
    @After
    public void tearDown()
    {
     
    }
    
    @Test
    public void testSumar_Clase1y2() 
    {
    	Matriz matriz1 = new Matriz("matriz1","desc1",2,2);
    	matriz1.setMat(CalculusTest.M1);
    	Matriz matriz2 = new Matriz("matriz2","desc2",2,2);
    	matriz2.setMat(CalculusTest.M2);
    	Matriz matriz3;
    	matriz3 = Calculus.getInstance().sumar(matriz1, matriz2);
        Assert.assertNotNull(matriz3);
        Assert.assertArrayEquals(CalculusTest.M3,matriz3.getMat());
    }
    
    @Test
    public void testRestar_Clase1y2() 
    {
    	Matriz matriz1 = new Matriz("matriz1","desc1",2,2);
    	matriz1.setMat(CalculusTest.M3);
    	Matriz matriz2 = new Matriz("matriz2","desc2",2,2);
    	matriz2.setMat(CalculusTest.M2);
    	Matriz matriz3;
    	matriz3 = Calculus.getInstance().restar(matriz1, matriz2);
        Assert.assertNotNull(matriz3);
        Assert.assertArrayEquals(CalculusTest.M1,matriz3.getMat());
    }
    
    @Test
    public void testMultiplicar_Clase1y2() 
    {
    	Matriz matriz1 = new Matriz("matriz1","desc1",2,2);
    	matriz1.setMat(CalculusTest.M1);
    	Matriz matriz2 = new Matriz("matriz2","desc2",2,1);
    	matriz2.setMat(CalculusTest.M4);
    	Matriz matriz3;
    	matriz3 = Calculus.getInstance().multiplicar(matriz1, matriz2);
        Assert.assertNotNull(matriz3);
        Assert.assertArrayEquals(CalculusTest.M5,matriz3.getMat());
    }
    
    @Test
    public void testTraspuesta_Clase1y2() 
    {
    	Matriz matriz1 = new Matriz("matriz1","desc1",2,1);
    	matriz1.setMat(CalculusTest.M5);
    	Matriz matriz2;
    	matriz2 = Calculus.getInstance().traspuesta(matriz1);
        Assert.assertNotNull(matriz2);
        Assert.assertArrayEquals(CalculusTest.M6,matriz2.getMat());
    }
    
    @Test
    public void testDeterminante_Clase1y2() 
    {
    	Matriz matriz1 = new Matriz("matriz1","desc1",2,2);
    	matriz1.setMat(CalculusTest.M1);
    	double determinante;
    	determinante = Calculus.getInstance().determinante(matriz1);
        Assert.assertEquals(4.0, determinante, 0.01);
    }
    
    @Test
    public void testGetInstance()
    {
    	Assert.assertNotNull(Calculus.getInstance());
    }
    
    @Test
    public void testDeterminante_CAJABLANCA()
    {
    	double[][] mat1 = {{5.0f}};
    	double[][] mat2 = {{5.0f, 1.0f},{1.0f,5.0f}};
    	double[][] mat3 = {{5.0f, 1.0f, 0.0f},{1.0f,5.0f, 0.0f}, {2.0f,2.0f, 2.0f}};
    	Matriz matriz1 = new Matriz("matriz1","desc1",1,1);
    	Matriz matriz2 = new Matriz("matriz2","desc2",2,2);
    	Matriz matriz3 = new Matriz("matriz3","desc3",3,3);
    	matriz1.setMat(mat1);
    	matriz2.setMat(mat2);
    	matriz3.setMat(mat3);
    	double determinante_1, determinante_2, determinante_3;
    	determinante_1 = Calculus.getInstance().determinante(matriz1);
    	determinante_2 = Calculus.getInstance().determinante(matriz2);
    	determinante_3 = Calculus.getInstance().determinante(matriz3);
        Assert.assertEquals(5.0, determinante_1, 0.01);
        Assert.assertEquals(24.0, determinante_2, 0.01);
        Assert.assertEquals(48.0, determinante_3, 0.01);
    }
    
}
