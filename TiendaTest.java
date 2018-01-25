

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class TiendaTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class TiendaTest
{
    /**
     * Default constructor for test class TiendaTest
     */
    public TiendaTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void Test()
    {
        Tienda tienda1 = new Tienda();        
        tienda1.addProductos("Caja de bombones", 10, 5);
        tienda1.addProductos("Colonia", 8, 10);
        tienda1.addProductos("Cartón de leche", 1, 20);
        tienda1.addProductos("Jabón de manos", 3.50, 25);
        tienda1.addProductos("Barra de pan", 0.70, 3);
        System.out.println("Mostramos las características de los productos:");
        tienda1.mostrarCaracteristicasDeLosProductos();
        System.out.println();
        System.out.println("Mostramos los productos ordenados de mayor a menor por precio:");
        tienda1.mostrarlistaDeProductosOrdenadosDeMayorAMenorPorPrecio();
        System.out.println();
        System.out.println("Mostramos los productos ordenados de menor a mayor por el número de unidades:");
        tienda1.mostrarListaDeProductosDeMenorAMayorNumeroDeUnidades();
        System.out.println();
        tienda1.modificarCaracteristicasDeUnProducto(3, "", 0, 0);
        tienda1.modificarCaracteristicasDeUnProducto(2, "Colonia", 8.50, 10);
        System.out.println("Modificadas las características de los productos con números identificativos 3 y 2:");
        System.out.println("El objeto con el número identificativo 3 tiene en nombre un texto vacío, en precio 0 y en número de unidades 0.");
        System.out.println("El objeto con el número identificativo 2 sigue teniendo en nombre Colonia, en precio 8.50 y en número de unidades sigue teniendo 10.");
        System.out.println();
        System.out.println("Eliminamos los productos con número de unidades inferior a 10.");
        tienda1.eliminarProductosConMenorNumeroDeUnidadesUtilizandoUnIterador(10);
        System.out.println();
        System.out.println("Mostramos los productos que quedan tras realizar la limpieza.");
        tienda1.mostrarCaracteristicasDeLosProductos();
    }
}

