import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;

public class Tienda {
    private ArrayList<Producto> listaDeProductos;
    private int numeroIdentificativo;

    /**
     * Constructor de la clase Tienda. Si el usuario lo desea,
     * puede obtener directamente una lista de productos si introduce
     * en el parámetro "datos.txt".
     */
    public Tienda(String textoArchivo) {
        listaDeProductos = new ArrayList<Producto>();
        numeroIdentificativo = 1;
        try {
            File archivo = new File(textoArchivo);
            Scanner sc = new Scanner(archivo);
            while(sc.hasNextLine()) {
                String[] arrayDePalabras = sc.nextLine().split(" # ");
                addProductos(arrayDePalabras[0], Double.parseDouble(arrayDePalabras[1]), Integer.parseInt(arrayDePalabras[2]));
            }
            sc.close();
        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Añade productos a la colección con valores reales.
     */
    public void addProductos(String nombre, double precio, int numeroDeUnidades) {
        if(precio >= 0 && numeroDeUnidades >= 0) {
            listaDeProductos.add(new Producto(nombre, precio, numeroDeUnidades, numeroIdentificativo));
            numeroIdentificativo += 1;
        }
    }

    /**
     * Muestra las características de todos los productos de la tienda.
     */
    public void mostrarCaracteristicasDeLosProductos() {
        for(Producto producto : listaDeProductos) {
            System.out.println(producto.todasLasCaracteristicasDelProducto());
        }
    }

    /**
     * Localiza y devuelve aquellos productos con el mayor precio y
     * los elimina de la colección introducida por el usuario.
     */
    public ArrayList<Producto> localizaLosProductosConMayorPrecio(ArrayList<Producto> coleccion) {
        ArrayList<Producto> productosConMayorPrecio = new ArrayList<Producto>();
        double precioMaximo = 0;
        int contador = 0;

        if(coleccion.size() > 0) {
            for(Producto producto : coleccion) {
                if(producto.obtenerPrecio() > precioMaximo) {
                    precioMaximo = producto.obtenerPrecio();
                }
            }

            while(contador < coleccion.size()) {
                if(coleccion.get(contador).obtenerPrecio() == precioMaximo) {
                    productosConMayorPrecio.add(coleccion.get(contador));
                    coleccion.remove(coleccion.get(contador));
                    contador -= 1;
                }
                contador += 1;
            }
        }

        return productosConMayorPrecio;
    }

    /**
     * Ordena de mayor a menor precio los productos de la tienda
     * y los muestra por pantalla.
     */
    public void mostrarlistaDeProductosOrdenadosDeMayorAMenorPorPrecio() {
        ArrayList<Producto> listaDeProductosOrdenadosDeMayorAMenorPorPrecio = new ArrayList<Producto>(); 
        ArrayList<Producto> copiaDeListaDeProductos = new ArrayList<Producto>();

        if(listaDeProductos.size() > 0) {
            copiaDeListaDeProductos.addAll(listaDeProductos);
            while(copiaDeListaDeProductos.size() != 0) {
                listaDeProductosOrdenadosDeMayorAMenorPorPrecio.addAll(localizaLosProductosConMayorPrecio(copiaDeListaDeProductos));
            }

            for(Producto producto : listaDeProductosOrdenadosDeMayorAMenorPorPrecio) {
                System.out.println(producto.todasLasCaracteristicasDelProducto());
            }
        }
    }

    /**
     * Localiza y devuelve los productos con menor número de unidades y
     * los elimina de la colección introducida por el usuario.
     */
    public ArrayList<Producto> localizaLosProductosConMenorNumeroDeUnidades(ArrayList<Producto> coleccion) {
        ArrayList<Producto> productosConMenorNumeroDeUnidades = new ArrayList<Producto>();
        int numeroDeUnidadesMinimo = 0;
        int contador = 0;

        if(coleccion.size() > 0) {
            numeroDeUnidadesMinimo = coleccion.get(0).obtenerNumeroDeUnidades();
            for(Producto producto : coleccion) {
                if(producto.obtenerNumeroDeUnidades() < numeroDeUnidadesMinimo) {
                    numeroDeUnidadesMinimo = producto.obtenerNumeroDeUnidades();
                }
            }

            while(contador < coleccion.size()) {
                if(coleccion.get(contador).obtenerNumeroDeUnidades() == numeroDeUnidadesMinimo) {
                    productosConMenorNumeroDeUnidades.add(coleccion.get(contador));
                    coleccion.remove(coleccion.get(contador));
                    contador -= 1;
                }
                contador += 1;
            }
        }

        return productosConMenorNumeroDeUnidades;
    }

    /**
     * Ordena de menor a mayor el número de unidades de los productos 
     * de la tienda y los muestra por pantalla.
     */
    public void mostrarListaDeProductosDeMenorAMayorNumeroDeUnidades() {
        ArrayList<Producto> listaDeProductosOrdenadosDeMenorAMayorPorNumeroDeUnidades = new ArrayList<Producto>(); 
        ArrayList<Producto> copiaDeListaDeProductos = new ArrayList<Producto>();

        if(listaDeProductos.size() > 0) {
            copiaDeListaDeProductos.addAll(listaDeProductos);
            while(copiaDeListaDeProductos.size() != 0) {
                listaDeProductosOrdenadosDeMenorAMayorPorNumeroDeUnidades.addAll(localizaLosProductosConMenorNumeroDeUnidades(copiaDeListaDeProductos));
            }

            for(Producto producto : listaDeProductosOrdenadosDeMenorAMayorPorNumeroDeUnidades) {
                System.out.println(producto.todasLasCaracteristicasDelProducto());
            }
        }
    }

    /**
     * Modifica el nombre, precio y número de unidades 
     * a través del número identificativo indicado por el usuario.
     */
    public void modificarCaracteristicasDeUnProducto(int numeroIdentificativo, String nombre, double precio, int numeroDeUnidades) {
        listaDeProductos.get(numeroIdentificativo - 1).fijarNombre(nombre);
        listaDeProductos.get(numeroIdentificativo - 1).fijarPrecio(precio);
        listaDeProductos.get(numeroIdentificativo - 1).fijarNumeroDeUnidades(numeroDeUnidades);
    }

    /**
     * Elimina los objetos que tengan menor número de unidades 
     * que el número introducido por el usuario usando un iterador.
     */
    public void eliminarProductosConMenorNumeroDeUnidadesUtilizandoUnIterador(int numeroDeUnidadesMinimas) {
        Iterator<Producto> it = listaDeProductos.iterator();

        while(it.hasNext()) {
            if(it.next().obtenerNumeroDeUnidades() < numeroDeUnidadesMinimas) {
                it.remove();
            }
        }
    }

    /**
     * Muestra los productos divididos por su número de unidades.
     */
    public void mostrarProductosDivididosPorNumeroDeUnidades() {
        HashSet<Integer> conjuntoDeNumerosDeUnidades = new HashSet<Integer>();

        for(Producto producto : listaDeProductos) {
            conjuntoDeNumerosDeUnidades.add(producto.obtenerNumeroDeUnidades());
        }

        for(int numeroDeUnidades : conjuntoDeNumerosDeUnidades) {
            System.out.println(numeroDeUnidades + ":");            
            for(Producto producto : listaDeProductos) {
                if(producto.obtenerNumeroDeUnidades() == numeroDeUnidades) {
                    System.out.println(producto.todasLasCaracteristicasDelProducto());
                }
            }
            System.out.println();
        }
    }
}