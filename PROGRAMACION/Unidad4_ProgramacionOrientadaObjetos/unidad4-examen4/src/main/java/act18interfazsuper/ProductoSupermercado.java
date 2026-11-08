package act18interfazsuper;

public interface ProductoSupermercado {
    // Métodos comunes a todos los productos del supermercado
    String getMarca();  // Obtener marca. Por ejemplo: "Coca-Cola", "Kellogg's", "Don Limpio"

    double getPrecio(); // Obtener precio actual (después de descuentos)

    /**
     * Aplicar un descuento porcentual al precio.
     *
     * @param porcentaje por ejemplo 10 para un 10%
     */
    void aplicarDescuento(double porcentaje); 
        // Aplica un descuento porcentual al precio actual. Se debe tratar con decimales (p.ej., 10.5% = 10.5) o dividir por 100 dentro del método.
}
