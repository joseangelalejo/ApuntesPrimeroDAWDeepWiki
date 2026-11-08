package act16clasesabstractas;

public class mainPruebas {
    public static void main(String[] args) {
        // arreglo con distintas figuras
        FiguraGeometrica[] figuras = new FiguraGeometrica[] {
                new Rectangulo("Rect1", "rojo", 3, 4),
                new Circulo("Circ1", "azul", 2.5),
                new Triangulo("Tri1", "verde", 3, 4, 5, 3, 4)
        };

        for (FiguraGeometrica f : figuras) {
            f.mostrarInformacion();
            System.out.println("Área: " + f.calcularArea());
            System.out.println("Perímetro: " + f.calcularPerimetro());
            f.dibujar();
            System.out.println();
        }
    }
}
