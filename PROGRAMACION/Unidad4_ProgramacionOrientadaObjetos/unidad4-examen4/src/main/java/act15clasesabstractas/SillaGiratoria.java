package act15clasesabstractas;

/**
 * Representa una silla giratoria que puede o no tener reposabrazos.
 */
public class SillaGiratoria extends Mueble {
    // ATRIBUTOS
    private boolean tieneReposabrazos;

    // CONSTRUCTOR PRINCIPAL
    public SillaGiratoria(double precioBase, String material, boolean tieneReposabrazos) {
        super(precioBase, material);
        this.tieneReposabrazos = tieneReposabrazos;
    }

    // GETTER
    public boolean isTieneReposabrazos() { return tieneReposabrazos; }

    // MÉTODOS
    @Override
    public double calcularPrecioFinal() {
        double precio = precioBase;
        if (tieneReposabrazos) {
            precio += 50.0;
        }
        return precio;
    }

    @Override
    public void transportar() {
        System.out.println("Transportando: " + toString());
    }

    @Override
    public String toString() {
        return "SillaGiratoria[material=" + material +
               ", precioBase=" + precioBase +
               (tieneReposabrazos ? ", con reposabrazos" : ", sin reposabrazos") +
               ", precioFinal=" + calcularPrecioFinal() + "]";
    }
}
