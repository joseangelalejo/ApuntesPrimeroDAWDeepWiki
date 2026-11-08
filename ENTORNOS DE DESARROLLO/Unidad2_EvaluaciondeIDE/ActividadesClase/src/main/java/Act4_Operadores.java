public class Act4_Operadores {
    public static void main(String[] args) {
        
        // Actividad 4 - Operadores lógicos - José Ángel Alejo Sillero
        // 1 Mayor de edad y con documento - Dado edad y tieneDNI, primir "Puede entrar" solo si edad >=18 y tieneDNI es true.
        
        int edad=20;
        boolean tieneDNI=true;

        if (edad>=18 && tieneDNI==true) {
            System.out.println("Puede entrar");
        } else {
            System.out.println("No puede entrar");
        }
        
        // 2 - Descuento por fidelidad o cupón - Con esClienteFrecuente y tieneCupon, mostrar "Descuento aplicado" si al menos una es verdadera.

        boolean esClienteFrecuente=true;
        boolean tieneCupon=true;

        if (esClienteFrecuente==true || tieneCupon==true) {
            System.out.println("Descuento aplicado");
        }
        
        // 3 - No es fin de semana - Con esFinDeSeamana, imprimir "A trabajar" solo si no es fin de semana.
        
        System.out.println("Ingrese un día de la semana con su equivalente numérico, del 1 al 7");
        int diaSemana=6; // Variable sustituto de un scanner para este ejemplo

        boolean esFinDeSemana=(diaSemana==6 || diaSemana==7);

        if (!esFinDeSemana) {
            System.out.println("A trabajar");
        } else {
            System.out.println("Es fin de semana. No se trabaja");
        }
        
        // 4 Rango válido - Dado nota (0-10), imprimir "Nota válida" solo si está dentro de rango. Si no está, "Nota inválida"
        
        System.out.println("Ingrese la nota");

        int nota=7;         // Reemplaza a un scanner para la nota introducida.

        if (nota>=0 && nota<=10) {
            System.out.println("Nota válida");

        } else {
            System.out.println("Nota inválida");
        }

        // 5 - Acceso por rol - Permitir acceso si rol es "ADMIN" o "EDITOR", y no está bloqueado.
        
        System.out.println("Ingrese su rol en letras mayúsculas y sin tilde");

        String rol = "ADMIN";       // Reemplaza a un scanner para el rol introducido.

        boolean acceso = true;      // Reemplaza a un scanner para si el usuario está bloqueado o no. true = no está bloqueado, false = está bloqueado

        if (rol=="ADMIN" || rol=="EDITOR" && acceso==true){
            System.out.println("Acceso permitido");
        }

        // 6 Par y positivo - Dado n, imprimir "Par y positivo" solo cuando sea par y positivo el número
        
        System.out.println("Ingrese su número entero para saber si es par o no, y si es positivo o no");

        int n = 7;      // Reemplaza a un scanner
        boolean positivo;
        boolean par;
        positivo = (n>0);
        par = (n%2==0);

        if (positivo && par) {
            System.out.println("Par y positivo");
        } else if (!positivo && par) {
            System.out.println("Es par, pero no es positivo");
        } else if (positivo && !par) {
            System.out.println("No es par, pero es positivo");
        } else {
            System.out.println("No es positivo ni par");
        }

        // 7 Validación de formulario mínima - Campos email, telefono. Requiere al menos uno vacío y que no estén ambos vacios.
        
        System.out.println("Ingrese su email");
        String email = "";    // Reemplaza a un scanner para el email
        
        System.out.println("Ingrese su teléfono");
        String telefono = "123456789";   // Reemplaza a un scanner para el telefono

        boolean emailVacio = email.isEmpty();       // isEmpty comprueba si la cadena está vacía.
        boolean telefonoVacio = telefono.isEmpty();

        if (emailVacio && telefonoVacio) {
            System.out.println("Ambos campos están vacíos");
        } else if (emailVacio || telefonoVacio) {
            System.out.println("Al menos un campo está vacío");
        } else {
            System.out.println("Formulario completo");
        }
        
        // 8 Estado de envío - Mostrar "Entregable" si pagado es true o si permisoEntrega es true (simula algun coste de ese entregable para evaluar).
        
        System.out.println("Estado de envío");
        float costeEntregable = 15f;

        System.out.println("Ingrese el pago realizado");
        float pago = 13f;                                      // Reemplaza a un scanner para saber si el pago realizado

        boolean pagado;
        if (pago>=costeEntregable) {
            pagado = true;
        } else {
            pagado = false;
        }
        boolean permisoEntrega = false;

        if (pagado==true && permisoEntrega==true) {
            System.out.println("Entregable");
        } else if (pagado==false && permisoEntrega==false) {
            System.out.println("Falta pago y permiso de entrega");
        } else if (pagado==false && permisoEntrega==true) {
            System.out.println("Entregable, pero falta pago");
        } else if (pagado== true && permisoEntrega==false) {
            System.out.println("Pagado, pero no tiene permiso de entrega");
        } else {
            System.out.println("No entregable");
        }

        // 9 Temperatura segura - Con una variable temp, imprimir "Alarma" si no está entre 18 y 27 inclusive.
        
        System.out.println("Indique la temperatura");

        float temperaturaInput = 25f;   // Reemplaza al scanner de temperatura


        if (temperaturaInput<18 || temperaturaInput>27){
            System.out.println("Alarma");
        } else {
            System.out.println("Temperatura segura");
        }

        // 10 Juego: Puede Atacar - Puede atacar si tieneArma y enemigo está en rango o no tiene escudo.

        System.out.println("Juego Puede Atacar");

        System.out.println("¿Tiene arma? Indica 1 para si, 2 para no");

        int tieneArmaInput = 1;    // Reemplaza al scanner
        boolean tieneArma;

        if (tieneArmaInput==1) {
            tieneArma = true;
        } else {
            tieneArma = false;
        }

        System.out.println("¿El enemigo está en rango? Indica 1 para si, 2 para no");
        int enemigoEnRangoInput = 2;   // Reemplaza al scanner. 
        boolean enemigoEnRango;

        if (enemigoEnRangoInput==1) {
            enemigoEnRango = true;
        } else {
            enemigoEnRango = false;
        }

        System.out.println("¿Tiene escudo? Indica 1 para si, 2 para no");
        int tieneEscudoInput = 2;  // Reemplaza al scanner
        boolean tieneEscudo;
        if (tieneEscudoInput==1) {      // El enemigo si tiene escudo
            tieneEscudo = true;
        } else {
            tieneEscudo = false;        // El enemigo no tiene escudo
        }

        if (tieneArma && (enemigoEnRango || !tieneEscudo)) {    // Puedes atacar si tienes arma y el enemigo o está en rango o no tiene escudo
            System.out.println("Puede atacar");
        } else {                                                // Se asume que no puede atacar porque no se cumple una de las condiciones anteriores
            System.out.println("No puede atacar");
        }

    }
    
}
