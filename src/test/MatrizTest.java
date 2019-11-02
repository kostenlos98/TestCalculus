package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import modelo.Matriz;

public class MatrizTest 
{
    @Before 
    public void setUp()
    {
    		
    }
    
    @After
    public void tearDown()
    {
     
    }
    
    @Test
    public void testConstructorMatrizClase_1()
    {
    	String nombre = "m1";
    	String desc   = "d1";
    	int fila = 2;
    	int col  = 2;
    	Matriz m = null;
    	
    	try
    	{
    		m = new Matriz(nombre, desc, fila, col);
    	}
    	catch (Exception e)
    	{
    		Assert.fail("Crashea por causas desconocidas, no construye el objeto correctamente");
    	}
    	Assert.assertNotNull(m);
    	Assert.assertEquals(m.getNombre(), nombre);
    	Assert.assertEquals(m.getDescripcion(), desc);
    	Assert.assertEquals(m.getFila(), fila);
    	Assert.assertEquals(m.getColumna(), col);
    	
    	double[][] mat = m.getMat();
    	
    	Assert.assertNotNull(mat);
    	Assert.assertEquals(mat.length,col);
    	Assert.assertEquals(mat[0].length,fila);
    }
    
    @Test
    public void testConstructorMatrizClase_2_1()
    {
    	try
    	{
    		Matriz m = new Matriz(null, "d1", 2, 2);
    		Assert.fail("El metodo no puede terminar normalmente si el nombre es NULO");
    	}
    	catch (Exception e)
    	{
    		Assert.fail("Deberia lanzarse excepcion de nombre invalido pero no lo hace y crashea");
    	}
    }

    @Test
    public void testConstructorMatrizClase_2_2()
    {
    	try
    	{
    		Matriz m = new Matriz("", "d1", 2, 2);
    		Assert.fail("El metodo no puede terminar normalmente si el nombre es VACIO");
    	}
    	catch (Exception e)
    	{
    		Assert.fail("Deberia lanzarse excepcion de nombre invalido pero no lo hace y crashea");
    	}
    }
    
        @Test
    public void testConstructorMatrizClase_3_1()
    {
    	try
    	{
    		Matriz m = new Matriz("n1", null, 2, 2);
    		Assert.fail("El metodo no puede terminar normalmente si la descripcion es NULA");
    	}
    	catch (Exception e)
    	{
    		Assert.fail("Deberia lanzarse excepcion de descripcion invalida pero no lo hace y crashea");
    	}
    }

    @Test
    public void testConstructorMatrizClase_3_2()
    {
    	try
    	{
    		Matriz m = new Matriz("n1", "", 2, 2);
    		Assert.fail("El metodo no puede terminar normalmente si la descripcion es VACIA");
    	}
    	catch (Exception e)
    	{
    		Assert.fail("Deberia lanzarse excepcion de descripcion invalida pero no lo hace y crashea");
    	}
    }
    
    @Test
    public void testInsertaClase1_1()
    {
    	Matriz m = new Matriz("n1", "d2", 7, 7);
    	double [][] mat;
    	
    	try
    	{
    		m.inserta(6, 6, 6.0);
    	}
    	catch (Exception e)
    	{
    		Assert.fail("Crashea por causas desconocidas, no inserta el valor correctamente");
    	}
    	mat = m.getMat();
    	
    	Assert.assertEquals(6.0, mat[6][6], 0.00001);
    }
    
    @Test
    public void testGetValorClase1_1()
    {
    	Matriz m = new Matriz("n1", "d2", 7, 7);
    	double v = 0;
    	
    	m.inserta(6, 6, 6.0);
    	try
    	{
    		v = m.getValor(6,6);
    	}
    	catch (Exception e)
    	{
    		Assert.fail("Crashea por causas desconocidas, no inserta el valor correctamente");
    	}
    	Assert.assertEquals(6.0, v, 0.00001);
    }
    
    public void nada()
    {
    	
    }
}
