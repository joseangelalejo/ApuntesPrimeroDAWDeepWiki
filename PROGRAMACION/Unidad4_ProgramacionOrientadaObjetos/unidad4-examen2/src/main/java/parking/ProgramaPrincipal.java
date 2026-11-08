package parking;
import calculos.CalculosParking;
public class ProgramaPrincipal {
    public static void main(String[] args) {
        int plazasTotales = 150;
        int plazasOcupadas = 30;
        int horas = 3;
        
        // Llamadas a los métodos de DatosParking
        int plazasLibresActuales = DatosParking.plazasLibres(plazasTotales, plazasOcupadas);
        String estadoActual = DatosParking.estadoParking(plazasTotales, plazasOcupadas);
        
        // Llamadas a los métodos de CalculosParking
        boolean esLarga = CalculosParking.esEstanciaLarga(horas);
        float precioFinal = CalculosParking.calcularPrecio(horas);
        double porcentajeOcupacionActual = CalculosParking.porcentajeOcupacion(plazasTotales, plazasOcupadas);
        
        // Mostrar información formateada
        System.out.printf("|== INFORMACIÓN DEL PARKING ==|%n");
        System.out.printf("     Plazas totales: %d%n", plazasTotales);
        System.out.printf("     Plazas ocupadas: %d%n", plazasOcupadas);
        System.out.printf("     Plazas libres: %d%n", plazasLibresActuales);
        System.out.printf("     Estado del parking: %s%n", estadoActual);
        System.out.printf("     Porcentaje de ocupación: %.2f%%%n", porcentajeOcupacionActual);
        System.out.printf("%n|== INFORMACIÓN DE LA ESTANCIA ==|%n");
        System.out.printf("     Horas de estancia: %d%n", horas);
        System.out.printf("     Tipo de estancia: %s%n", esLarga ? "LARGA" : "CORTA");
        System.out.printf("     Precio a pagar: %.2f euros%n", precioFinal);
    }
}
