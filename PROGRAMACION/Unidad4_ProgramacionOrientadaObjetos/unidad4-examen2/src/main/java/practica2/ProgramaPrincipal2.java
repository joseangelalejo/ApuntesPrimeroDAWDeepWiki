package practica2;

public class ProgramaPrincipal2 {
    public static void main(String[] args) {
        // Instancia de DatosCalificaciones con valores de ejemplo
        DatosCalificaciones alumno1 = new DatosCalificaciones(7.5, 2.0, 5.0);
        
        // Llamada a método static de CalculosCalificaciones para obtener el promedio
        double promedio = CalculosCalificaciones.calcularPromedio(alumno1.nota1, alumno1.nota2, alumno1.nota3);

        // Llamada a métodos static de CalculosCalificaciones para calcular el promedio y determinar si aprueba o no
        if (CalculosCalificaciones.estaAprobado(promedio)) {
            System.out.println("El alumno está aprobado");
        } else {
            System.out.println("El alumno está suspenso");
        }
        
        System.out.println(""); // Línea vacia para hacer una pausa antes de salir del programa
    }
}