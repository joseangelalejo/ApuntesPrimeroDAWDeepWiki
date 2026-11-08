package pract2Interfaces;

public class mainPruebas {
    public static void main(String[] args) {
        // Crear instancias de las figuras
        FiguraGeometrica circulo = new Circulo("Rojo", "Mi Círculo", 5);
        FiguraGeometrica rectangulo = new Rectangulo("Azul", "Mi Rectángulo", 4, 6);
        FiguraGeometrica triangulo = new Triangulo("Azul", "Mi Triangulo", 12, 12, 12, 8, 12);
        // Array de FiguraGeometrica
        FiguraGeometrica[] figuras = {circulo, rectangulo, triangulo};
        // Recorrer el array y mostrar información de cada figura
        System.out.println();
        for (FiguraGeometrica figura : figuras) {
            figura.mostrarInformacion();
            System.out.println("Área: " + figura.calcularArea());
            System.out.println("Perímetro: " + figura.calcularPerimetro());
            figura.dibujar();
            System.out.println("-----------------------------------");
        }
    }
}
