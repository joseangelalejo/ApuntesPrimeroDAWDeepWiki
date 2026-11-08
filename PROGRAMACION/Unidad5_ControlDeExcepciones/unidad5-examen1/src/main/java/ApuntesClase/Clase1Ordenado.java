package ApuntesClase;

public class Clase1Ordenado {
    public static void main(String[] args) throws MiExcepcion {
        // 1) División por cero -> ArithmeticException
        manejarDivision(10, 0);
        // 2) NPE simulado -> NullPointerException
        manejarCadena(null);
        // 3) Excepción genérica -> NumberFormatException (no capturada antes)
        manejarConversion("abc");

        // Ejemplo básico de manejo de excepciones
        try {   // Dentro del try ponemos el código que puede generar una excepción
            int resultado = dividir(10, 0);
            System.out.println("Resultado: " + resultado);
        } catch (ArithmeticException e) {   // Parámetros de la excepción: Aquí capturamos la excepción específica que puede ocurrir
            System.out.println("Error: No se puede dividir por cero.");
        } catch (NullPointerException e) {
            System.out.println("Error: Referencia nula.");
        } catch (Exception e) {  // general
            System.out.println("Error: Ocurrió un error inesperado.");
        }
        /** Tras el catch tenemos los parámetros de la excepción:
         * - El tipo de excepción que queremos capturar (en este caso, ArithmeticException).
         * - Una variable (en este caso, 'e') que representa la excepción capturada(a modo de nombre) 
         *  y que podemos usar para obtener más información sobre el error.
         */

        // Ejemplo de manejo de una excepción personalizada
        try {
            metodoConMiExcepcion();
        } catch (MiExcepcion e) {
            System.out.println("Capturada MiExcepcion: " + e.getMessage());
        }

        // Ejemplo de manejo de una excepción personalizada con código de error para rango numerico
        try {
            throw new MiExcepcionConCodigo("Número fuera de rango", 1001);
        } catch (MiExcepcionConCodigo e) {
            System.out.println("Capturada MiExcepcionConCodigo: " + e.getMessage() + ", Código: " + e.getCodigoError());
        }

        /** Lanzar excepcion unchecked sin capturarla
         *  - Para poder lanzar una excepción sin capturarla, debe ser unchecked, es decir, debe extender de RuntimeException.
         *  - En este caso, MiExcepcion extiende de Exception, lo que la convierte en una checked exception, 
         *  así que el método main debe declarar que lanza MiExcepcion con 'throws MiExcepcion'.
        */
        throw new MiExcepcion("Excepción no capturada");
        /** Al lanzar esta excepción sin capturarla, el programa terminará abruptamente y se mostrará el mensaje de error en la consola.
         * - Esto se llama PROPAGACIÓN DE EXCEPCIONES: la excepción se propaga hacia arriba en la pila de llamadas hasta que es 
         *  capturada o hasta que el programa termina.
         * - La propagación tiene las siguientes diferencias respecto a usar catch:
         *   - Si capturamos la excepción con catch, podemos manejarla de manera controlada, mostrar un mensaje amigable al usuario,
         *  registrar el error, intentar una recuperación, etc.
         *  - Si dejamos que la excepción se propague sin capturarla, el programa terminará abruptamente y se mostrará un 
         *  mensaje de error genérico, lo que no es ideal para la experiencia del usuario ni para el mantenimiento del código.
         * - En general, es recomendable capturar las excepciones que se esperan y manejar adecuadamente los errores, mientras 
         *  que las excepciones inesperadas o críticas pueden dejarse propagarse para que el programa termine de manera segura.
         * - En el caso de las excepciones personalizadas, si son checked, obligan a los desarrolladores a manejarlas o 
         *  declararlas, lo que puede mejorar la robustez del código al forzar un manejo explícito de ciertos errores específicos de la aplicación.
         * - En resumen: la propagación de excepciones es una característica fundamental de Java que permite manejar errores de manera 
         *  flexible, pero es importante usarla con cuidado para evitar que el programa termine de manera inesperada y para 
         *  proporcionar una buena experiencia al usuario.
         *  - Errores críticos: aquellos que no se pueden recuperar y que obligan a la terminación del programa, como OutOfMemoryError, StackOverflowError, etc.
         *  Haremos una propagación controlada de excepciones, capturando las que se esperan y dejando que las críticas terminen el programa de manera segura.
         *  - Errores no críticos: aquellos que se pueden manejar y recuperar, como IOException, SQLException, etc.
         *  Los capturamos para manejar el error de manera controlada, mostrar mensajes amigables, registrar el error, etc. 
         */
    }

    /** Métodos para manejar diferentes casos de excepciones, "multi-catch" y genéricas.
     * Permite recoger excepciones concretas (ArithmeticException, NullPointerException) 
     * y una genérica (Exception) para cualquier otro error no previsto.
     * Es importante el orden: primero las excepciones específicas y luego la genérica,
     * porque si ponemos la genérica antes, capturaría todas las excepciones y 
     * las específicas nunca se ejecutarían.
     */ 

    public static void manejarDivision(int a, int b) {
        try {
            int resultado = dividir(a, b);
            System.out.println("Resultado división: " + resultado);
        } catch (ArithmeticException e) {
            System.out.println("Error/Aritmético: no se puede dividir por cero.");
        } catch (NullPointerException e) {
            System.out.println("Error/NullPointer: referencia nula en dividir.");
        } catch (Exception e) { // genérico para resto
            System.out.println("Error/General: " + e.getClass().getSimpleName());
        } finally {
            System.out.println("Operación de división finalizada.");
        }
        /** Finally: bloque que se ejecuta siempre, haya o no excepción. 
         * Se usa para liberar recursos, cerrar conexiones, etc.
         * El único caso en que no se ejecuta es si el programa termina
         * abruptamente (System.exit()) o si el hilo es interrumpido 
         * mientras se ejecuta el finally, un kill del proceso, error de hardware, etc.
         * El finally se ejecuta incluso si el try o catch tiene un return, 
         * lo que garantiza la limpieza de recursos.
         * Cuando hablamos de limpieza de recursos, nos referimos a cerrar archivos, 
         * conexiones de base de datos, liberar memoria, etc.
         * Esta limpieza se produce porque cuando java detecta que un recurso ya no 
         * se va a usar, lo marca para que el recolector de basura lo elimine,
         * pero si el recurso es algo externo (como un archivo abierto o una conexión de red), 
         * el recolector de basura no puede gestionarlo, por lo que es responsabilidad 
         * del programador cerrarlo explícitamente.
         */
    }

    // Método de ejemplo. Maneja una cadena y su longitud.
    public static void manejarCadena(String s) {
        try {
            int longitud = s.length(); // lanza NPE si s == null
            System.out.println("Longitud: " + longitud);
        } catch (NullPointerException e) {
            System.out.println("Error: cadena es nula.");
        } catch (Exception e) {
            System.out.println("Error genérico: " + e.getMessage());
        }
    }

    // Método de ejemplo. Convierte un texto a número.
    public static void manejarConversion(String texto) {
        try {
            int n = Integer.parseInt(texto); // lanza NumberFormatException
            System.out.println("Número: " + n);
        } catch (ArithmeticException e) {
            System.out.println("No puede ocurrir aquí");
        } catch (NullPointerException e) {
            System.out.println("No puede ocurrir aquí");
        } catch (Exception e) { // captura lo que no encajó antes
            System.out.println("Error inesperado: " + e.getClass().getSimpleName());
        }
    }

    // Método de ejemplo. Divide dos enteros.
    public static int dividir(int a, int b) {
        return a / b;
    }

    // Método que lanza nuestra excepción personalizada
    public static void metodoConMiExcepcion() throws MiExcepcion {
        throw new MiExcepcion("Este es un error personalizado.");
    }

    /**Además, podemos crear nuestras propias excepciones personalizadas:
     * - Serán clases que extiendan de Exception o RuntimeException.
     * - Nos permiten definir errores específicos para nuestro dominio de aplicación.
     * Ejemplo:
     *  */ 
    public static class MiExcepcion extends Exception {
        public MiExcepcion(String mensaje) {
            super(mensaje);
        }
    }

    /** Cabe destacar que las excepciones personalizadas pueden ser checked (si extienden de Exception)
     *  o unchecked (si extienden de RuntimeException).
     * - Las checked exceptions deben ser declaradas en la firma del método con 'throws' y obligan 
     * al llamante a manejarlas o declararlas también.
     * - Las unchecked exceptions no requieren declaración y pueden propagarse sin ser capturadas, lo que 
     * las hace más flexibles pero también más propensas a errores si no se manejan adecuadamente.
     * Las clases de excepciones personalizadas nos permiten encapsular información adicional sobre 
     * el error, como códigos de error, detalles específicos del contexto, etc., lo que facilita el 
     * manejo de errores en aplicaciones complejas.
     * En dicha clase debemos proporcionar constructores que normalmente harán super (mensaje) para pasar 
     * el mensaje de error a la clase base Exception, y podemos agregar métodos adicionales para obtener 
     * información específica sobre el error.
     * Por ejemplo:
     */
    public static class MiExcepcionConCodigo extends Exception {
        private int codigoError;
        public MiExcepcionConCodigo(String mensaje, int codigoError) {
            super(mensaje);     // Heredamos el mensaje de la clase base
            this.codigoError = codigoError;
        }
        public int getCodigoError() {
            return codigoError;
        }
    }
}
