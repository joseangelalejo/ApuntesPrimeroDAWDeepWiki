package practica6;

public class CalculosGeometricos {
    // Método para calcular área de cuadrado: devolver lado * lado
    public double areaCuadrado(double lado) {
        return lado * lado;
    }
    // Método para calcular perímetro de cuadrado: devolver lado * 4
    public double perimetroCuadrado(double lado) {
        return lado * 4;
    }
    // Método para calcular área de círculo: devolver π * radio^2
    public double areaCirculo(double radio) {
        return (Math.PI * radio * radio);
        // alternativamente:
            // return (Math.PI * Math.pow(radio, 2));
    }
    // Método para calcular perímetro de círculo: devolver 2 * π * radio
    public double perimetroCirculo (double radio) {
        return 2 * Math.PI * radio;
    }

}