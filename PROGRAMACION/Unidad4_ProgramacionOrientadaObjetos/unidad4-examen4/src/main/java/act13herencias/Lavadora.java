package act13herencias;

public class Lavadora extends Electrodomestico {
    // ATRIBUTOS
    private int precio;
    private boolean aguaCaliente;

    // CONSTRUCTOR "BÁSICO" (agua fría por defecto)
    public Lavadora(String marca, int precio, double potencia) {
        super(TipoElectrodomestico.LAVADORA, marca, potencia);
        this.precio = Math.abs(precio);
        this.aguaCaliente = false;
    }

    // CONSTRUCTOR COMPLETO
    public Lavadora(String marca, int precio, double potencia, boolean aguaCaliente) {
        super(TipoElectrodomestico.LAVADORA, marca, potencia);
        this.precio = Math.abs(precio);
        this.aguaCaliente = aguaCaliente;
    }
    // GETTERS Y SETTERS
    // Getters
    public int getPrecio() { return precio; }
    public boolean isAguaCaliente() { return aguaCaliente; }
    // Setters
    public void setPrecio(int precio) { this.precio = Math.abs(precio); }
    public void setAguaCaliente(boolean aguaCaliente) { this.aguaCaliente = aguaCaliente; }
    // MÉTODOS SOLICITADOS
    // Sobreescritura de toString
    @Override   // Indica que este método sobreescribe un método de la clase padre
    public String toString() {
        return super.toString() + " - Precio: " + precio + " euros" + " - Agua caliente: " + (aguaCaliente ? "Sí" : "No");
    }
    // Sobreescritura de getConsumo: si la lavadora tiene agua caliente, el consumo se incrementa en un 20 %
    @Override
    public double getConsumo(int horas) {
        double pot = getPotencia();
        if (aguaCaliente) {
            pot += pot * 0.20; // +20 %
        }
        return horas * pot;
    }
    // No se sobreescribe getCosteConsumo porque el coste se calcula a partir del consumo, y el consumo ya se ha modificado para tener en cuenta el agua caliente. Por lo tanto, el coste se calculará correctamente al llamar a getCosteConsumo, sin necesidad de modificarlo.
}