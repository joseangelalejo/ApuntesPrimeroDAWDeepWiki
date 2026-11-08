package practicarExamen;
public class Habitacion {
    // ATRIBUTOS
    private final int numero;   // Final para que no pueda modificarse según premisa
    private String tipo;
    private double precioNoche;
    private boolean reservada;
    private String huesped;
    private int pinAcceso;
    // CONSTRUCTOR PRINCIPAL
    public Habitacion(int numero, String tipo, double precioNoche, int pinAcceso) {
        this.numero = numero;
        this.tipo = tipo;
        this.precioNoche = Math.abs(precioNoche); // Función Math.abs para evitar que sea negativo. Se podría usar un if o un ternario, pero así contempla mejor negativos
        this.pinAcceso = pinAcceso;
        this.reservada = false;
        this.huesped = null;
    }
    // Constructor con precio inicializado en 100
    public Habitacion(int numero, String tipo, int pinAcceso) {
        this(numero, tipo, 100.0, pinAcceso);
    }
    // GETTERS Y SETTERS
    // Getters (no hay getter de pin; el número y el código son inmutables)
    public int getNumero() {return numero;}
    public String getTipo() {return tipo;}
    public double getPrecioNoche() {return precioNoche;}
    public boolean isReservada() {return reservada;}
    public String getHuesped() {return huesped;}
    // No se crea un get para pin por motivos de seguridad, no debería poderse consultar directamente
    
    // Setters con validaciones, sin exponer setReservada ni setHuesped
    public void setTipo(String tipo) {this.tipo = tipo;}
    public void setPrecioNoche(double precioNoche) {this.precioNoche = Math.abs(precioNoche);}

    // MÉTODOS SOLICITADOS
    // Método para reservar la habitación si está disponible
    public boolean reservar(String nombreHuesped) {
        if (!reservada && nombreHuesped != null && !nombreHuesped.isEmpty()) {
            reservada = true;
            huesped = nombreHuesped;
            return true;
        }
        return false;
    }
    // Método para liberar la habitación si el pin es correcto
    public boolean liberar(int pin) {
        if (pinAcceso == pin && reservada) {
            reservada = false;
            huesped = null;
            return true;
        }
        return false;
    }
    // Método para mostrar si la habitación está reservada y por quién
    public void mostrarEstado() {
        String msg = reservada ? "Habitación reservada por " + huesped : "Habitación libre";
        System.out.println(msg);
    }
    // Método para cambiar el pin si el actual es correcto
    public boolean cambiarPin(int actual, int nuevo) {
        if (pinAcceso == actual) {
            pinAcceso = nuevo;
            return true;
        }
        return false;
    }
}
