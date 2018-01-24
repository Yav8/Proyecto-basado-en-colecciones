
public class Producto {
    private String nombre;
    private double precio;
    private int numeroDeUnidades;
    private int numeroIdentificativo;
    
    public Producto(String nombre, double precio, int numeroDeUnidades, int numeroIdentificativo) {
        this.nombre = nombre;
        this.precio = precio;
        this.numeroDeUnidades = numeroDeUnidades;
        this.numeroIdentificativo = numeroIdentificativo;
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
        return "Nombre del producto: " + nombre + " - precio: " + precio + " - número de unidades: " + numeroDeUnidades + " - número identificativo del producto: " + numeroIdentificativo;
    }
}