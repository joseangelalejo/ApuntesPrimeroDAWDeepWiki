# Ejercicios refactorización

## Ejercicio 1 – Datos de un estudiante

📝 Enunciado
El siguiente programa imprime los datos de un estudiante. Refactoriza el código creando un método que reciba los datos como parámetros y los muestre por pantalla.
Código inicial

```java
public class Estudiante {

   public static void main(String[] args) {

       String nombre = "Ana";
       int edad = 19;
       double nota = 8.5;

       System.out.println("Nombre: " + nombre);
       System.out.println("Edad: " + edad);
       System.out.println("Nota: " + nota);
   }
}
```

- **Código refactorizado JAAlejo:**

```java
public class Estudiante {

   public static void main(String[] args) {

       String nombre = "Ana";
       int edad = 19;
       double nota = 8.5;

       mostrarDatos(nombre, edad, nota);
   }

   public static void mostrarDatos(String nombre, int edad, double nota) {
       System.out.println("Nombre: " + nombre);
       System.out.println("Edad: " + edad);
       System.out.println("Nota: " + nota);
   }
}
```

## Ejercicio 2 – Cálculo del área de un rectángulo

📝 Enunciado
Refactoriza el siguiente código creando un método que calcule el área del rectángulo.
Código inicial

```java
public class Rectangulo {

   public static void main(String[] args) {

       double base = 5;
       double altura = 3;

       double area = base * altura;

       System.out.println("El área es: " + area);
   }
}
```

- **Código refactorizado JAAlejo:**

```java
public class Rectangulo {

   public static void main(String[] args) {

       double base = 5;
       double altura = 3;

       double area = calcularArea(base, altura);

       System.out.println("El área es: " + area);
   }

   public static double calcularArea(double base, double altura) {
       return base * altura;
   }
}
```

## Ejercicio 3 – Mostrar tabla de multiplicar

📝 Enunciado
El programa muestra la tabla del 5. Refactorízalo creando un método que reciba el número como parámetro.
Código inicial

```java
public class Tabla {

   public static void main(String[] args) {

       int numero = 5;

       for(int i = 1; i <= 10; i++) {
           System.out.println(numero + " x " + i + " = " + (numero * i));
       }
   }
}
```

- **Código refactorizado JAAlejo:**

```java
public class Tabla {

   public static void main(String[] args) {

       int numero = 5;

       mostrarTabla(numero);
   }

   public static void mostrarTabla(int numero) {
       for(int i = 1; i <= 10; i++) {
           System.out.println(numero + " x " + i + " = " + (numero * i));
       }
   }
}
```

## Ejercicio 4 – Cálculo de salario con horas extra

📝 Enunciado
Refactoriza el código creando un método que calcule el salario total.
Código inicial

```java
public class Salario {

   public static void main(String[] args) {

       int horas = 45;
       double precioHora = 10;

       double salario;

       if(horas > 40) {
           salario = (40 * precioHora) + ((horas - 40) * precioHora * 1.5);
       } else {
           salario = horas * precioHora;
       }

       System.out.println("Salario total: " + salario);
   }
}
```

- **Código refactorizado JAAlejo:**

```java
public class Salario {

    public static void main(String[] args) {

         int horas = 45;
         double precioHora = 10;

         double salario = calcularSalario(horas, precioHora);

         System.out.println("Salario total: " + salario);
    }

    public static double calcularSalario(int horas, double precioHora) {
         if(horas > 40) {
              return (40 * precioHora) + ((horas - 40) * precioHora * 1.5);
         } else {
              return horas * precioHora;
         }
    }
}
```

## Ejercicio 5 – Validar número par

📝 Enunciado
Refactoriza el código creando un método que devuelva si el número es par o impar.
Código inicial

```java
public class ParImpar {

   public static void main(String[] args) {

       int numero = 7;

       if(numero % 2 == 0) {
           System.out.println("Es par");
       } else {
           System.out.println("Es impar");
       }
   }
}
```

- **Código refactorizado JAAlejo:**

```java
public class ParImpar {

    public static void main(String[] args) {

         int numero = 7;

         if(esPar(numero)) {
              System.out.println("Es par");
         } else {
              System.out.println("Es impar");
         }
    }

    public static boolean esPar(int numero) {
         return numero % 2 == 0;
    }
}
```
