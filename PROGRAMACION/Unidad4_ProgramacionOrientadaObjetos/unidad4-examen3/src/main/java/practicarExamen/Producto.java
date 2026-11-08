package practicarExamen;

public class Producto {
    // ATRIBUTOS
    private final String codigo;
    private String nombre;
    private double precio;
    private int stock;
    private int codigoSeguridad;

    // CONSTRUCTOR PRINCIPAL
    public Producto(String codigo, String nombre, double precio, int stock, int codigoSeguridad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = (precio<0) ? -(precio) : precio;
        this.stock = (stock<0) ? -(stock) : stock;
        this.codigoSeguridad = codigoSeguridad;
    }
    // Constructor para stock en 0
    public Producto(String codigo, String nombre, double precio, int codigoSeguridad) {
        this(codigo, nombre, precio, 0, codigoSeguridad);
    }
    // GETTERS Y SETTERS
    // Getters
    public String getCodigo() {return codigo;}
    public String getNombre() {return nombre;}
    public double getPrecio() {return precio;}
    public int getStock() {return stock;}

    // Setters
    public void setNombre(String nombre) {
        this.nombre = (nombre.isEmpty()) ? "Nombre genérico" : nombre;
    }
    public void setPrecio(double precio) {
        this.precio = (precio<0) ? -(precio) : precio;
    }
    public void setStock(int stock) {
        this.stock = (stock < 0) ? -(stock) : stock;
    }

    // MÉTODOS SOLICITADOS
    // Método para agregar cantidad al stock
    public boolean agregarStock(int cantidad) {
        if (cantidad != 0) {
            stock += cantidad;
            return true;
        } else if (cantidad < 0) {
            stock += -(cantidad);
            return true;
        }
        return false;
    }
    // Método para vender productos
    public boolean vender(int cantidad) {
        if (stock > cantidad && cantidad != 0) {
            stock -= cantidad;
            return true;
        } else if (cantidad < 0) {
            stock -= -(cantidad);
            return true;
        }
        return false;
    }
    // Método para aplicar descuento si el código de seguridad es correcto
    public boolean aplicarDescuento(double porcentaje, int codigo) {
        if (codigoSeguridad == codigo) {
            porcentaje = porcentaje/100;
            precio = precio*porcentaje;
            return true;
        }
        System.out.println("Código de seguridad inválido");
        return false;
    }
    // Método para cambiar el código de seguridad actual si es correcto
    public boolean cambiarCodigoSeguridad(int actual, int nuevo) {
        if (actual == codigoSeguridad) {
            codigoSeguridad = nuevo;
            return true;
        }
        return false;
    }
}
