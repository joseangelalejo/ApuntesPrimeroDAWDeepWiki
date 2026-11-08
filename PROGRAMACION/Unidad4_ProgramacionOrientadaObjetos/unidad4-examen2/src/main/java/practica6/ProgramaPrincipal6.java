package practica6;

public class ProgramaPrincipal6 {
    public static void main(String[] args) {
        // 1. Crear una instancia de la clase DatosGeometricos
        DatosGeometricos datos1 = new DatosGeometricos();
        // 2. Asignar valores a los campos lado y radio de la instancia (por ejemplo, lado=5.0, radio=3.0)
        datos1.lado = 20;
        datos1.radio = 15;
        // 3. Crear una instancia de la clase CalculosGeometricos
        CalculosGeometricos calc1 = new CalculosGeometricos();
        // 4. Llamar al método areaCuadrado pasando el lado de DatosGeometricos e imprimir el resultado
        System.out.println("El area del cuadrado es: " + calc1.areaCuadrado(datos1.lado));
        // 5. Llamar al método perimetroCuadrado pasando el lado de DatosGeometricos e imprimir el resultado
        System.out.println("El perímetro del cuadrado es: " + calc1.perimetroCuadrado(datos1.lado));
        // 6. Llamar al método areaCirculo pasando el radio de DatosGeometricos e imprimir el resultado
        System.out.println(("El área del círculo es: ") + calc1.areaCirculo(datos1.radio));
        // 7. Llamar al método perimetroCirculo pasando el radio de DatosGeometricos e imprimir el resultado
        System.out.println("El perímetro del círculo es: " + calc1.perimetroCirculo(datos1.radio));
    }
}