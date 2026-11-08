public class ED_EstructuraSwitchPruebas {
    public static void main(String[] args) {
        
        int opcion = 2;                                             //  Creamos una variable opción inicializada a 2.

        switch (opcion) {                                           //  Evaluamos el valor de la variable opción.
            case 1:                                                 //  Si opción es igual a 1.
                System.out.println("Opción 1 seleccionada.");
                break;                                              //  Salimos del switch.
            case 2:                                                 //  Si opción es igual a 2.
                System.out.println("Opción 2 seleccionada.");
                break;                                              //  Salimos del switch.
            default:                                                //  Si ninguna de las opciones anteriores coincide.
                System.out.println("Opción no válida.");
                break;                                              //  Salimos del switch.
        }
    }
}
