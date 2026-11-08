public class Actividad2_Tarifa {
    public static void main(String[] args) {
        // === Cambia estos valores ===
        int edad = 70;
        boolean esEstudiante = true;
        
        // === Lógica de tarifa ===
        double tarifa;
        if (edad < 12) {
            tarifa = 2.0;   // infantil
        } else if (edad <= 25 && esEstudiante) {
            tarifa = 3.0;   // joven estudiante
        } else if (edad >= 65) {
            tarifa = 2.5;   // tercera edad
        } else {
            tarifa = 5.0;   //general
        }
        
        // === Salida ===
        System.out.println("Edad: " + edad);
        System.out.println("Es estudiante?: " + esEstudiante);
        System.out.println("Tarifa asignada: " + tarifa);
        
    }
}
