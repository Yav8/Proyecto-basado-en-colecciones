import java.util.ArrayList;

public class Tienda {
    private ArrayList<Producto> listaDeProductos;
    private int numeroIdentificativo;
    
    public Tienda() {
        listaDeProductos = new ArrayList<Producto>();
        numeroIdentificativo = 1;
    }
    
    public void addProductos(String nombre, double precio, int numeroDeUnidades) {
        if(precio >= 0 && numeroDeUnidades >= 0) {
            listaDeProductos.add(new Producto(nombre, precio, numeroDeUnidades, numeroIdentificativo));
            numeroIdentificativo += 1;
        }
    }
    
    public void mostrarCaracteristicasDeLosProductos() {
        for(Producto producto : listaDeProductos) {
            System.out.println(producto.todasLasCaracteristicasDelProducto());
        }
    }
    
    public ArrayList<Producto> localizaElProductoOrdenadoDeMayorAMenorPorPrecio(ArrayList<Producto> coleccion) {
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

    public void mostrarlistaDeProductosOrdenadosDeMayorAMenorPorPrecio() {
        ArrayList<Producto> listaDeProductosOrdenadosDeMayorAMenorPorPrecio = new ArrayList<Producto>(); 
        ArrayList<Producto> copiaDeListaDeProductos = new ArrayList<Producto>();
        
        if(listaDeProductos.size() > 0) {
            copiaDeListaDeProductos.addAll(listaDeProductos);
            while(copiaDeListaDeProductos.size() != 0) {
                listaDeProductosOrdenadosDeMayorAMenorPorPrecio.addAll(localizaElProductoOrdenadoDeMayorAMenorPorPrecio(copiaDeListaDeProductos));
            }
            
            for(Producto producto : listaDeProductosOrdenadosDeMayorAMenorPorPrecio) {
                System.out.println(producto.todasLasCaracteristicasDelProducto());
            }
        }
    }
    
    public ArrayList<Producto> localizaElProductoOrdenadoDeMenorAMayorPorNumeroDeUnidades(ArrayList<Producto> coleccion) {
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
    
    public void mostrarListaDeProductosConMenorNumeroDeUnidades() {
        ArrayList<Producto> listaDeProductosOrdenadosDeMenorAMayorPorNumeroDeUnidades = new ArrayList<Producto>(); 
        ArrayList<Producto> copiaDeListaDeProductos = new ArrayList<Producto>();
        
        if(listaDeProductos.size() > 0) {
            copiaDeListaDeProductos.addAll(listaDeProductos);
            while(copiaDeListaDeProductos.size() != 0) {
                listaDeProductosOrdenadosDeMenorAMayorPorNumeroDeUnidades.addAll(localizaElProductoOrdenadoDeMenorAMayorPorNumeroDeUnidades(copiaDeListaDeProductos));
            }
            
            for(Producto producto : listaDeProductosOrdenadosDeMenorAMayorPorNumeroDeUnidades) {
                System.out.println(producto.todasLasCaracteristicasDelProducto());
            }
        }
    }
}