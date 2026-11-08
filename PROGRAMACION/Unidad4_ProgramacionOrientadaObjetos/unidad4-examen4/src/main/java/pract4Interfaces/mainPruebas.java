package pract4Interfaces;

public class mainPruebas {
    public static void main(String[] args) {
        System.out.println();
        // Instancias de Producto
        Producto p1 = new Producto("Leche", 1);
        Producto p2 = new Producto("Huevos", 3);
        Producto p3 = new Producto("Azucar", 1);
        // Instancias de Pedido
        Pedido pedido = new Pedido();
        pedido.agregarLinea(p2, 5);
        pedido.agregarLinea(p3, 3);
        pedido.agregarLinea(p1, 5);
        // Muestra de resumen
        System.out.println("Resumen del pedido:");
        System.out.println(pedido.resumen());
    }
}
