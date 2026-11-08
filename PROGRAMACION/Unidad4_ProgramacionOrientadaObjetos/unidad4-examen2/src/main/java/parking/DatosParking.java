package parking;

public class DatosParking {
    // Esta clase tendrá metodos estáticos que devuelvan información sobre el estado del parking.
    // Método 1: Devuelve el número de plazas libres

    public static int plazasLibres(int plazasTotales, int plazasOcupadas) {
        int plazaslibres = plazasTotales-plazasOcupadas;
        return plazaslibres;
    }
    // Método 2: Devuelve true si el parking está completo y false en caso contrario
    public static boolean parkingCompleto(int plazasTotales, int plazasOcupadas) {
        boolean parkingCompleto = false;
        if (plazasTotales==plazasOcupadas) {
            parkingCompleto=true;
        }
        return parkingCompleto;
    }
    // Método 3: Devuelve un String con uno de los siguientes valores: "COMPLETO", "CASI COMPLETO" si quedan cinco plazas o menos, o "DISPONIBLE"
    public static String estadoParking(int plazasTotales, int plazasOcupadas) {
        String estadoParking = "";
        if (parkingCompleto(plazasTotales,plazasOcupadas) == true) {
            estadoParking = "COMPLETO D:";
        } else if (plazasLibres(plazasTotales, plazasOcupadas)<=5) {
            estadoParking = "CASI COMPLETO V:";
        } else {
            estadoParking = "DISPONIBLE";
        }
        return estadoParking;
    }
}
