package calculos;

public class CalculosParking {
    // Esta clase contendrá métodos estáticos con lógica de cálculo
    public static boolean esEstanciaLarga(int horas) { // Método 1: Devuelve true si la estancia es de cinco horas o más.
        boolean esEstanciaLarga = false;
        if (horas>=5) {esEstanciaLarga=true;}
        return esEstanciaLarga;
    }
    public static float calcularPrecio(int horas){ // Método 2: Devuelve el precio a pagar en función de las horas
        float calcularPrecio;
        if (!esEstanciaLarga(horas)) {
            calcularPrecio = 2 + 1.5f*(horas-1);
        } else {
            calcularPrecio = 1.5f;
            if (horas>1) {
                calcularPrecio += 1*(horas-1);
            }
        }
        return calcularPrecio;
    }
    public static double porcentajeOcupacion(int plazasTotales, int plazasOcupadas){
        double porcentajeOcupacion = ((double)plazasOcupadas / plazasTotales) * 100.0;
        return porcentajeOcupacion;
    }
}
