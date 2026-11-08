# Premisa Actividad Evaluable 1 - Unidad 3

Actividad evaluable: Gestión sencilla de acceso a un parque de atracciones
Vas a crear un programa de consola que gestione de forma sencilla el acceso de las personas a un parque de atracciones.

## Requisitos

1. Petición de datos al inicio
   1. Al empezar, el programa debe:
      1. Saludar al usuario.
      2. Pedir su nombre.
      3. Pedir su edad.
      4. Pedir el día de la semana en el que quiere ir al parque (por ejemplo: Lunes, Martes, etc.).
   2. Comprobación de acceso según la edad
      1. Con la edad introducida, el programa debe mostrar uno de estos mensajes:
         1. Si la edad es mayor o igual que 18:
            1. Eres mayor de edad, puedes entrar sin acompañante.
         2. Si la edad es menor de 18:
            1. Eres menor de edad, necesitas un acompañante adulto.
   3. Pase especial de fin de semana
      1. Utilizando la edad y el día de la semana, el programa debe comprobar si:
         1. La persona es mayor de edad y además
         2. El día introducido es "Sábado" o "Domingo".
         3. Si se cumplen ambas condiciones, debe aparecer un mensaje adicional:
            1. Tienes acceso al pase especial de fin de semana.
   4. Comprobación del nombre
      1. El programa debe comparar el nombre introducido con el nombre "Jose".
         1. Si el nombre del usuario no es "Jose", se mostrará:
            1. Tu nombre es diferente de Jose.
   5. Menú de opciones
      1. Después de las comprobaciones anteriores, el programa debe mostrar un menú como el siguiente:
         1. 1 Ver información de precios
         2. 2 Ver atracciones disponibles
         3. 3 Salir
   6. El usuario introducirá un número (1, 2 o 3) para elegir una opción.
      1. Según el número introducido, el programa debe mostrar:
         1. Si elige 1: un mensaje informativo sobre los precios, por ejemplo:
            1. Los precios varían según la edad y el día de la semana.
         2. Si elige 2: un mensaje con algunas atracciones, por ejemplo:
            1. Atracciones disponibles: Montaña rusa, Noria, Casa del terror...
         3. Si elige 3:
            1. Saliendo del programa...
         4. Si elige cualquier otro número:
            1. Opción no válida.
   7. Repetición del menú
      1. Después de ejecutar la opción elegida, el menú debe volver a mostrarse.
      2. El programa debe seguir pidiendo opciones y mostrando el resultado correspondiente.
      3. El menú solo dejará de mostrarse cuando el usuario elija la opción 3 (Salir).

## Criterios de evaluación

Se valorará:

- Que el programa pida correctamente todos los datos al usuario.
- Que los mensajes mostrados dependan correctamente de la edad, el día de la semana y el nombre.
- Que el comportamiento especial de fin de semana se aplique solo cuando corresponde.
- Que el menú funcione correctamente, responda de forma adecuada a cada opción y se repita hasta que se elija salir.
- Que los mensajes sean claros y el programa resulte fácil de entender para la persona que lo usa.
