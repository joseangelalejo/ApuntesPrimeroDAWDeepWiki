@SuppressWarnings({"unused", "all"})
public class ApuntesMarga {

    public static void main(String[] args) {

        // Para hacer conversiones de tipodatos, hacemos un Casting, utilizando un tipodato primitivo FLOAT
        //String cadena = "1.4";

        String cadena = "1.4";
        String cadena2 = "";
        String cadena3 = "";                    // Si no asignamos al String cadena3 un valor, al intentar imprimir dará error. Ej: String cadena3; | Para que funcione lo haremos como indicamos al inicio de esta linea.
        String cadena4 ="Hola\\mundo";          // Usar \\ dentro del valor nos mostrará una \
        String cadena5 ="Hola \nmundo";         // Usar \n nos hará un salto de linea 
        Float num = 1.4f;
       
        //Si queremos hacer conversiones de Tipodato, dependerá del Dato Origen y el Dato Salida

            // Si tenemos un primitivo y lo queremos convertir en otro primitivo utilizamos la función CASTING, que será Implicito o Explícito:
        
                // Aquí hacemos un casting explícito, ya que float es mayor que int
                int numEntero= (int) num.floatValue(); 
                System.out.println(numEntero);

                // Si hacemos un casting implícito, sería al contrario, de un int a un float, ya que float es mayor que int, ejemplo:
                float numFloat=numEntero;               
                System.out.println(numFloat);

            //Si tenemos un dato de origen Objeto y lo queremos convertir en un dato primitivo utilizamos los métodos de envoltorio (wrapper), que son los siguientes:
                
                //El comando seria NombreClase.valueOf(Dato a convertir)

                    // De String a int
                    int numEntero2 = Integer.parseInt(cadena);
                    System.out.println(numEntero2);

                    // De String a float
                    float numFloat2 = Float.parseFloat(cadena);
                    System.out.println(numFloat2);

                    // De String a double
                    double numDouble = Double.parseDouble(cadena);
                    System.out.println(numDouble);

                    // De String a boolean
                    boolean numBoolean = Boolean.parseBoolean(cadena2);
                    System.out.println(numBoolean);

            //Si tenemos un tipodato primitivo y lo queremos convertir a un objeto  utilizamos los métodos de envoltorio (wrapper), que son los siguientes:
            
        //
        
	}
}

