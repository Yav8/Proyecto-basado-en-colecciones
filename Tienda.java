import java.util.ArrayList;

public class Tienda {
    private ArrayList<Producto> listaDeProductos;
    private int numeroIdentificativo;
    
    public Tienda() {
        listaDeProductos = new ArrayList<Producto>();
        numeroIdentificativo = 1;
    }
    
    public void añadirProductos(String nombre, double precio, int numeroDeUnidades) {
        listaDeProductos.add(new Producto(nombre, precio, numeroDeUnidades, numeroIdentificativo));
        numeroIdentificativo += 1;
    }
    
    public void mostrarCaracteristicasDeLosProductos() {
        for(Producto producto : listaDeProductos) {
            System.out.println(producto.todasLasCaracteristicasDelProducto());
        }
    }
}