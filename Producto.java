
public class Producto {
    private String nombre;
    private double precio;
    private int numeroDeUnidades;
    private int numeroIdentificativo;
    
    /**
     * Constructor de la clase Producto.
     */
    public Producto(String nombre, double precio, int numeroDeUnidades, int numeroIdentificativo) {
        this.nombre = nombre;
        this.precio = precio;
        this.numeroDeUnidades = numeroDeUnidades;
        this.numeroIdentificativo = numeroIdentificativo;
    }
    
    /**
     * Devuelve el nombre del producto.
     */
    public String obtenerNombre() {
       return nombre;
    }
    
    /**
     * Fija el nombre del producto.
     */
    public void fijarNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Devuelve el precio del producto.
     */
    public double obtenerPrecio() {
        return precio;
    }
    
    /**
     * Fija el precio del producto.
     */
    public void fijarPrecio(double precio) {
        this.precio = precio;
    }
    
    /**
     * Devuelve el número de unidades del producto.
     */
    public int obtenerNumeroDeUnidades() {
        return numeroDeUnidades;
    }
    
    /**
     * Fija el número de unidades del producto.
     */
    public void fijarNumeroDeUnidades(int numeroDeUnidades) {
        this.numeroDeUnidades = numeroDeUnidades;
    }
    
    /**
     * Devuelve el texto con todas las características de los productos.
     */
    public String todasLasCaracteristicasDelProducto() {
        return "Nombre del producto: " + nombre + " - precio: " + precio + " - número de unidades: " + numeroDeUnidades + " - número identificativo del producto: " + numeroIdentificativo;
    }
}