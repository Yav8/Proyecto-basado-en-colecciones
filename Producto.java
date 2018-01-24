
public class Producto {
    private String nombre;
    private double precio;
    private int numeroDeUnidades;
    
    public Producto(String nombre, double precio, int numeroDeUnidades) {
        this.nombre = nombre;
        this.precio = precio;
        this.numeroDeUnidades = numeroDeUnidades;
    }
    
    public String obtenerNombre() {
       return nombre;
    }
    
    public void fijarNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public double obtenerPrecio() {
        return precio;
    }
    
    public void fijarPrecio(double precio) {
        this.precio = precio;
    }
    
    public int obtenerNumeroDeUnidades() {
        return numeroDeUnidades;
    }
    
    public void fijarNumeroDeUnidades(int numeroDeUnidades) {
        this.numeroDeUnidades = numeroDeUnidades;
    }
    
    public String todasLasCaracteristicasDelProducto() {
        return "Nombre del producto: " + nombre + " - precio: " + precio + " - número de unidades: " + numeroDeUnidades;
    }
}