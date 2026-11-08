package practicarExamen;

public class ReservaVuelo {
    // ATRIBUTOS
    private final String numeroReserva;
    private String pasajero;
    private String vuelo;
    private String asiento;
    private double precio;
    private boolean pagado;
    private int codigoSeguro;
    // CONSTRUCTOR PRINCIPAL
    public ReservaVuelo(String numeroReserva, String pasajero, String vuelo, String asiento, double precio, boolean pagado, int codigoSeguro) {
        this.numeroReserva = numeroReserva;
        this.pasajero = pasajero;
        this.vuelo = vuelo;
        this.asiento = asiento;
        this.precio = Math.abs(precio);
        this.pagado = pagado;
        this.codigoSeguro = codigoSeguro;
    }
    // Constructor con pagado en false
    public ReservaVuelo(String numeroReserva, String pasajero, String vuelo, String asiento, double precio, int codigoSeguro) {
        this(numeroReserva, pasajero, vuelo, asiento, precio, false, codigoSeguro);
    }
    // GETTERS Y SETTERS
    // Getters
    public String getNumeroReserva() {return numeroReserva;}
    public String getPasajero() {return pasajero;}
    public String getVuelo() {return vuelo;}
    public String getAsiento() {return asiento;}
    public double getPrecio() {return precio;}
    public boolean isPagado() {return pagado;}
    // No se incluye get de codigoSeguro por motivos de seguridad

    // Setters
    public void setPasajero(String pasajero) {this.pasajero = pasajero;}
    public void setVuelo(String vuelo) {this.vuelo = vuelo;}
    public void setAsiento(String asiento) {this.asiento = asiento;}
    public void setPrecio(double precio) {this.precio = Math.abs(precio);}
    public void setPagado(boolean pagado) {this.pagado = pagado;}
    public void setCodigoSeguro(int codigoSeguro) {this.codigoSeguro = codigoSeguro;}

    // MÉTODOS SOLICITADOS
    // Métodos para pagar la reserva
    public void pagarReserva() {
        pagado = true;
    }
    // Método para cambiar asiento si es válido y no está pagado
    public boolean cambiarAsiento(String nuevoAsiento, int codigo) {
        if (this.codigoSeguro == codigo) {
            asiento = nuevoAsiento;
            return true;
        }
        return false;
    }
    // Método para cancelar reserva si el código es correcto
    public boolean cancelarReserva(int codigo) {
        if (this.codigoSeguro == codigo) {
            asiento = null;
            pagado = false;
        }
        return false;
    }
    // Método para mostrar el estado de la reserva
    public void mostrarDetalles() {
        System.out.println("Numero de reserva: " + numeroReserva + " - Pasajero: " + pasajero + " - Vuelo: " + vuelo + " - Asiento: " + asiento + " - Pagado: " + ((pagado) ? "Si" : "No"));
    }
}
