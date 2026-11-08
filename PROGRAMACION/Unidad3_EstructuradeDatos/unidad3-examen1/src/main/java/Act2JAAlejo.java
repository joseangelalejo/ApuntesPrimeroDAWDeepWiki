import java.util.Scanner;
import java.util.Random;
@SuppressWarnings("unused")
public class Act2JAAlejo {
    public static void main(String[] args) {
        /*
        // Enunciado 1: Crea un array con 10 números enteros predefinidos. Calcula y muestra la suma de todos los elementos del array.
            int numeros[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
            int suma = 0;

            for (int i=0; i<numeros.length; i++) {
                suma+=numeros[i];
            }
            System.out.println("La suma de todos los elementos es " + suma);
        
        // Enunciado 2: Crea un array con 5 números decimales introducidos por el usuario.
            // Calcula y muestra la media de los valores del array.
            Scanner scanner2 = new Scanner(System.in);
            float numerosdec[] = new float[5];
            float media2 = 0;
            for (int i=0; i<numerosdec.length; i++) {
                System.out.println("Introduzca el número decimal " + (i+1) + " :");
                numerosdec[i] = scanner2.nextFloat();
            }
            // For para recorrer el array sumando los valores.
            for (int i = 0; i<numerosdec.length; i++) {
                media2+=numerosdec[i];
            }
            System.out.printf("\n La suma de los números es %.2f y su media %.2f", media2, (media2/2f));
        scanner2.close();
        
        // Enunciado 3: Declara un array con 8 números enteros.
            // Encuentra el número mayor y el número menor en el array. Muestra ambos valores.
            int numeros3[] = {4, 2, 3, 15, 5, 6, 7, 8};
            int imayor = numeros3[0];   // Inicializo imayor con el primer valor del array
            int imenor = numeros3[0];   // Inicializo imenor con el primer valor del array
            for (int i=0; i<numeros3.length; i++) { // Recorro el array
                if (numeros3[i]>imayor) {           // Si el valor en la posición i es mayor que imayor
                    imayor=numeros3[i];                 // Asigno el valor en la posición i a imayor
                } else if (numeros3[i]<imenor) {    // Si el valor en la posición i es menor que imenor
                    imenor=numeros3[i];                 // Asigno el valor en la posición i a imenor
                }
            }
            System.out.printf("\nEl número mayor es %d y el número menor es %d", imayor, imenor); // Imprimir numero mayor y menor
        
        // Enunciado 4: Crea un array con 7 números enteros.
            // Invierte los elementos del array, de manera que el primer elemento pase al final, el segundo al penúltimo, y así sucesivamente.
            // Muestra el array original y el invertido.
            int numeros4[] = {2,15,6,29,78,5,4,3};
            System.out.println("Array ordenado: ");
            for (int i = 0; i<numeros4.length; i++) {
                System.out.printf("     Ocurrencia %d: %d%n", (i+1), numeros4[i]);
            }
            // For para invertir el array
            System.out.println("\nArray invertido: ");
            for (int i = 0; i<numeros4.length / 2; i++) { // Bucle for correcto
                int j = numeros4.length-1-i;
                int temporal = numeros4[i]; // Variable temporal para almacenar el valor de la ocurrencia del array
                numeros4[i] = numeros4[j];  // Asigno a i el valor de j (inicio intercambio)
                numeros4[j] = temporal;     // Asigno a j el valor anterior de i (fin intercambio)
            }
            // For para mostrar el array invertido
            for (int k = 0; k < numeros4.length; k++) {
                System.out.printf("     Ocurrencia %d: %d%n", (k + 1), numeros4[k]);
            }
        
        // Enunciado 5: Crea un array de 10 números enteros predefinidos. Pide al usuario que introduzca un número.
            // Busca el número en el array y muestra un mensaje indicando si el número se encuentra o no, y en qué posición está si existe.
            int numeros5[] = {2,15,6,29,78,6,4,3,16,9};
            Scanner scanner5 = new Scanner(System.in);
            System.out.println("Introduce un número:");
            int numBuscado = scanner5.nextInt();
            int posiciones[] = new int[numeros5.length];
            int contpos = 0;
            // For para buscar el número en el array. Si se encuentra, muestro posición y cambio encontrado a true.
            for (int i=0; i<numeros5.length; i++) {
                if (numeros5[i] == numBuscado) {
                    posiciones[contpos] = i;
                    contpos++;
                }
            }           // DONE Arreglar FOR. Actualmente pausa tras encontrar la primera ocurrencia. Debe parar tras encontrar todas.
            // Si el número no se ha encontrado, entonces ocurrirá:
                if (contpos > 0) {
                    System.out.printf("El número %d se encuentra en las posiciones: \n", numBuscado);
                    for (int j = 0; j < contpos; j++) {
                        System.out.printf("     %d%n",posiciones[j]);
                    }
                    System.out.println("del array numeros5.");
                } else {
                    System.out.printf("El número %d no se encuentra en el array numeros5.%n", numBuscado);
                }
            scanner5.close();
        
        // Enunciado 6: Crea un array con 6 números enteros.
            // Desplaza todos los elementos una posición a la derecha. El último elemento debe pasar a la primera posición.
            // Muestra el array original y el desplazado.
            int numeros6[] = {2,15,6,29,78,5};
            System.out.println("Array original:");
            for (int i = 0; i < numeros6.length; i++) {
                System.out.printf("Ocurrencia %d: %d%n", (i + 1), numeros6[i]);
            }
            // Desplazamiento a la derecha
            int ultimo = numeros6[numeros6.length - 1];
            for (int i = numeros6.length - 1; i > 0; i--) {
                numeros6[i] = numeros6[i - 1];
            }
            numeros6[0] = ultimo;
            System.out.println("\nArray desplazado:");
            for (int i = 0; i < numeros6.length; i++) {
                System.out.printf("Ocurrencia %d: %d%n", (i + 1), numeros6[i]);
            }
        
        // Enunciado 7: Crea un array con 10 números enteros predefinidos.
            // Pide al usuario que introduzca la posición del elemento que desea eliminar.
            // Crea un nuevo array sin ese elemento y muestra el array actualizado.
            Scanner scanner7 = new Scanner(System.in);
            int numeros7[] = {2,15,6,29,78,5,4,3,16,9};
            System.out.println("Array original:");
            for (int i = 0; i < numeros7.length; i++) {
                System.out.printf("Ocurrencia %d: %d%n", (i), numeros7[i]);
            }
            System.out.println("Introduce la posición del elemento que quieres eliminar (0-9):");
            int pos7 = scanner7.nextInt();
            if (pos7 < 0 || pos7 >= numeros7.length) { // Validación de posición
                System.out.println("Posición inválida.");
            } else {
                int[] nuevoArray7 = new int[numeros7.length - 1];   // Nuevo array con una posición menos
                for (int i = 0, j = 0; i < numeros7.length; i++) {  // Bucle para copiar elementos excepto el de la posición a eliminar
                    if (i != pos7) {                                // Si i no es la posición a eliminar
                        nuevoArray7[j++] = numeros7[i];             // Copiar elemento "i"(dejando fuera el de la posición a eliminar)
                    }
                }
                System.out.println("Array actualizado:");
                for (int i = 0; i < nuevoArray7.length; i++) {
                    System.out.printf("Ocurrencia %d: %d%n", (i), nuevoArray7[i]);
                }
            }
            scanner7.close();
        
        // Enunciado 8: Crea un array de 8 números enteros.
            // Pide al usuario que introduzca un número y un valor para reemplazar.
            // Reemplaza todas las ocurrencias del número en el array por el valor dado y muestra el array actualizado.
            Scanner scanner8 = new Scanner(System.in);
            int numeros8[] = {24,89,3,6,7,8,1,4};
            System.out.println("Array actual");
            for (int i = 0; i<numeros8.length; i++) {
                System.out.printf(" Ocurrencia %d: %d%n", (i+1), numeros8[i]);
            }
            System.out.print("\nIntroduce el número(no la ocurrencia) que deseas reemplazar: ");
            int del8 = scanner8.nextInt();
            System.out.print("Introduce el número por el que deseas reemplazarlo: ");
            int sus8 = scanner8.nextInt();
            for (int i = 0; i<numeros8.length; i++) {
                if (numeros8[i] == del8) {
                    numeros8[i] = sus8;
                }
            }
            System.out.println("\nArray actualizado");
            for (int i = 0; i<numeros8.length; i++) {
                System.out.printf(" Ocurrencia %d: %d%n", (i+1), numeros8[i]);
            }
            scanner8.close();
        */
        // Enunciado 9: Crea un array con 15 números enteros generados de forma aleatoria (entre 1 y 100).
            // Cuenta cuántos de ellos son pares y cuántos son impares. Muestra el resultado.
            int aleatorio9[] = new int[15]; // Declaración de array con 15 enteros.
            Random rand9 = new Random();    // Función random "rand9" para crear números randoms al llamarla.
            // For para llenar el array con números aleatorios
                for (int i = 0; i<aleatorio9.length; i++) {
                    aleatorio9[i] = rand9.nextInt(101); // Números desde 0 hasta 100 inclusive (para incluir el 100 he aumentado a 101)
                }
            // For para mostrar los valores asignados
                for (int i = 0; i<aleatorio9.length; i++) {
                    System.out.printf("Ocurrencia %d: %d%n", (i+1), aleatorio9[i]);
                }
            int pares9 = 0;     // Contador pares
            int impares9 = 0;   // Contador impares
            // For para contar pares e impares
                for (int i = 0; i<aleatorio9.length; i++) {
                    if ((aleatorio9[i]%2) == 0) {
                        pares9++;
                    } else {
                        impares9++;
                    }
                }
            System.out.printf("Tenemos %d números pares y %d números impares", pares9, impares9);
                // PRUEBA ARRAYS Jose Angel - Imprimir pares encontrados e impares encontrados (Sin utilizar Arrays Collection)
                    // Nuevo array para pares. Su longitud será igual a la cantidad de pares encontrada
                    int arrayPares[] = new int[pares9];
                    // Nuevo array para impares. Su longitud será igual a la cantidad de impares encontrados
                    int arrayImpares[] = new int [impares9];
                    // Enteros que sustituyen a i en bucle for línea 196 para su correspondiente array.
                        int tempPares = 0;
                        int tempImpares = 0;
                    // For para asignar a cada array el valor de i según si son pares o impares
                    for (int i=0; i<aleatorio9.length; i++) {
                        if (((aleatorio9[i]%2) == 0)) {
                            arrayPares[tempPares] = aleatorio9[i];
                            tempPares++;
                        } else{
                            arrayImpares[tempImpares] = aleatorio9[i];
                            tempImpares++;
                        }
                    }
                    // Imprimir array de pares encontrados
                        System.out.println("\nPares encontrados");
                        for (int i = 0; i<arrayPares.length; i++) {
                            System.out.printf("     Ocurrencia %d: %d%n", (i+1), arrayPares[i]);
                        }
                    // Imprimir array de impares encontrados
                        System.out.println("Impares encontrados");
                        for (int i = 0; i<arrayImpares.length; i++) {
                            System.out.printf("     Ocurrencia %d: %d%n", (i+1), arrayImpares[i]);
                        }
        /*
        // Enunciado 10: Crea un array con 10 números enteros generados aleatoriamente entre 1 y 20.
            // Genera un segundo array donde cada elemento sea el cuadrado de los elementos del primer array.
            // Muestra ambos arrays.
            int aleatorio10[] = new int[10];
            Random rand10 = new Random();    // Función random "rand9" para crear números randoms al llamarla.
            // For para llenar el array con números aleatorios
                for (int i = 0; i<aleatorio10.length; i++) {
                    aleatorio10[i] = rand10.nextInt(21) + 1;    // ".nextInt()" indica en los paréntesis el máximo(exclusive).
                }                                                     // El mínimo siempre será 0. Para modificar el mínimo a 1, se suma +1
            // For para mostrar los valores asignados
                System.out.println("Array actual:");
                for (int i = 0; i<aleatorio10.length; i++) {
                    System.out.printf("     Ocurrencia %d: %d%n", (i+1), aleatorio10[i]);
                }
            // Creación de nuevo array. Con longitud igual al array inicial.
                int[] nuevoarray10 = new int[aleatorio10.length];
            // For para el nuevo array.
                for (int i = 0; i<nuevoarray10.length; i++) {       
                    nuevoarray10[i] = (int)Math.pow(aleatorio10[i], 2);         // Asigno los valores del array original elevado a 2 con Math.pow.
                }                                                               // Antes: nuevoarray10[i] = (aleatorio10[i])*2; Ahora es más "óptimo"/correcto 
            // For para mostrar el nuevo array
                System.out.println("\nNuevo array con valores al cuadrado: ");
                for (int i = 0; i<nuevoarray10.length; i++) {
                    System.out.printf("     Ocurrencia %d: %d%n", (i+1), nuevoarray10[i]);
                }
        */
    }
}
