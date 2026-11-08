package practica2;

public class CalculosCalificaciones {
    // Método public static para calcular el promedio de tres notas.
        // Se debe recibir tres notas y devolver el promedio como double
        public static double calcularPromedio(double nota1, double nota2, double nota3) {
            return (nota1 + nota2 + nota3) / 3.0;
        }
    // Método estatic para determinar si el alumno está aprobado o no. Se recibe el promedio, y si es mayor o igual a 5.0 true, si nó, false.
        public static boolean estaAprobado (double promedio) {
            return (promedio >= 5.0 && promedio <= 10) ? true : false;
        }
}