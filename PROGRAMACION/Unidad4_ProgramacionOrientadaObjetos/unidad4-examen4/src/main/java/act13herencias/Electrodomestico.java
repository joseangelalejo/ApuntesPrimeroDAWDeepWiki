package act13herencias;

public class Electrodomestico {
    // ATRIBUTOS
    public enum TipoElectrodomestico { NEVERA, HORNO, LAVADORA, MICROONDAS, SECADORA }  // ENUM, para el tipo de electrodoméstico, con 4 posibles valores: moto, coche, eléctrico y camioneta
    private TipoElectrodomestico tipo;
    private String marca;
    private double potencia; // Se indica en kW por hora
    // CONSTRUCTOR PINCIPAL
    public Electrodomestico(TipoElectrodomestico tipo, String marca, double potencia) {
        this.tipo = (tipo == null ? TipoElectrodomestico.HORNO : tipo);
        this.marca = (marca.isEmpty()) ? "Peugeot" : marca;
        this.potencia = Math.abs(potencia);
    }
    // GETTERS Y SETTERS
    // Getters
    public TipoElectrodomestico getTipo() {return tipo;}
    public String getMarca() {return marca;}
    public double getPotencia() {return potencia;}
    // Setters
    public void setTipo(TipoElectrodomestico tipo) {this.tipo = (tipo == null ? TipoElectrodomestico.HORNO : tipo);}
    public void setMarca(String marca) {this.marca = (marca.isEmpty()) ? "Peugeot" : marca;}
    public void setPotencia(double potencia) {this.potencia = Math.abs(potencia);}

    // MÉTODOS SOLICITADOS
    // Método para devolver el consumo total de kW por cada electrodoméstico en un tiempo dado en horas
    public double getConsumo(int horas) {
        double consumoTotal = (potencia*horas);
        return consumoTotal;
    }
    // Método para tener el costal total por el consumo del electrodoméstico
    public double getCosteConsumo(int horas, double costeHora) {
        double consumoTotal = horas*costeHora * potencia;
        return consumoTotal;
    }
    // Sobreescritura de toString
    public String toString() {
        return "Tipo: " + tipo + " - Marca: " + marca + " - Potencia: " + potencia + " kw/h";

    }
}
