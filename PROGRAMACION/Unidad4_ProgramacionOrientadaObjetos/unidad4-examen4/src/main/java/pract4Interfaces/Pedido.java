package pract4Interfaces;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private List<LineaPedido> lineas = new ArrayList<>();

    public void agregarLinea(Producto producto, int cantidad) {
        lineas.add(new LineaPedido(producto, cantidad));
    }
    // MÉTODO para obtener el subtotal de cada línea
    public double total() {
        double suma = 0;
        for (LineaPedido lp : lineas) {
            suma += lp.subtotal();
        }
        return suma;
    }
    // Método que devuelve tanto el texto con cada linea como su total
    public String resumen() {
        StringBuilder sb = new StringBuilder();
        for (LineaPedido lp : lineas) {
            sb.append(lp.mostrarDetalle()).append("\n");
        }
        sb.append("Total: ").append(total());
        return sb.toString();
    }
}
