
public class Producto {
    private String nombre;
    private double precio;
    private int numeroDeUnidades;
    
    public Producto() {
        nombre = "";
        precio = 0;
        numeroDeUnidades = 0;
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
}