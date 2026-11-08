public class Act4 {
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        // Ejercicio 1 – Número mayor de edad
        int edad = 20;
        String mayorEdad = (edad >= 18) ? "Es mayor de edad" : "Es menor de edad";
        System.out.println("Edad: " + edad + " -> " + mayorEdad);

        // Ejercicio 2 – Número positivo o negativo
        int num = -5;
        boolean esPositivo = num > 0;
        String signo = (num > 0) ? "Positivo" : "Negativo";
        System.out.println("Número: " + num + " -> " + signo);

        // Ejercicio 3 – Número mayor entre dos valores
        int n1 = 8;
        int n2 = 12;
        String comparacion = (n1 > n2) ? "n1 es mayor" : "n2 es mayor o iguales";
        System.out.println("n1: " + n1 + ", n2: " + n2 + " -> " + comparacion);

        // Ejercicio 4 – Aprobado o suspenso
        double nota = 4.7;
        String resultadoNota = (nota >= 5) ? "Aprobado" : "Suspenso";
        System.out.println("Nota: " + nota + " -> " + resultadoNota);

        // Ejercicio 5 – Descuento en compra
        double importe = 120.0;
        double precioFinal = (importe > 100) ? importe * 0.9 : importe;
        System.out.println("Importe: " + importe + " -> Precio final: " + precioFinal);
    }
}
