# Introducción a los Shell Scripts

- [Introducción a los Shell Scripts](#introducción-a-los-shell-scripts)
  - [Qué es un Shell Script y generación procedural](#qué-es-un-shell-script-y-generación-procedural)
  - [Escribir y ejecutar un script](#escribir-y-ejecutar-un-script)
  - [Variables de Sistema y Variables Definidas por el Usuario](#variables-de-sistema-y-variables-definidas-por-el-usuario)
    - [Variables de Sistema](#variables-de-sistema)
    - [Variable Echo](#variable-echo)
    - [Variable READ](#variable-read)
    - [Variables Definidas por el Usuario](#variables-definidas-por-el-usuario)
    - [Operaciones aritméticas básicas](#operaciones-aritméticas-básicas)
    - [Redirección de Entrada y Salida](#redirección-de-entrada-y-salida)
    - [Utilizar comandos dentro de un echo](#utilizar-comandos-dentro-de-un-echo)
    - [Estructuras de control](#estructuras-de-control)
      - [Estructura de control de flujo. IF](#estructura-de-control-de-flujo-if)
      - [Expresiones para evaluar condiciones](#expresiones-para-evaluar-condiciones)
      - [Estructura de control bucles While](#estructura-de-control-bucles-while)
      - [Estructura de control bucle FOR](#estructura-de-control-bucle-for)
      - [Switch Case](#switch-case)
    - [PATRONES](#patrones)

---
<div style="page-break-after: always;"></div>

## Qué es un Shell Script y generación procedural

Los shell Scripts son **archivos de texto que contienen una serie de comandos que el intérprete de comandos (shell) puede ejecutar**. Son una herramienta poderosa para automatizar tareas repetitivas, gestionar sistemas y realizar configuraciones.

Los shell Scripts se **basan en la generación procedural**, lo que significa que **los comandos se ejecutan en un orden específico, uno tras otro**. Esto permite a los usuarios crear secuencias de comandos que pueden realizar tareas complejas de manera eficiente.

El **objetivo** de los shell Scripts es **automatizar tareas que de otro modo requerirían intervención manual**, lo que ahorra tiempo y reduce la posibilidad de errores humanos. Los scripts pueden incluir comandos para manipular archivos, gestionar procesos, configurar sistemas y mucho más.

## Escribir y ejecutar un script

Para **crear un shell script** se crea un archivo de texto con extensión `.sh`. Por ejemplo, `mi_script.sh`.

Se debe tener en cuenta que los scripts en Línux utilizan la extensión `.sh` y en Windows `.bash`.

Después de crear el archivo, es necesario **darle permisos de ejecución**. Esto se puede hacer con el comando `chmod +x archivo.sh`. Por ejemplo:

```bash
chmod +x mi_script.sh
```

Y **usamos `chmod 755 archivo.sh`** para dar permisos de lectura, escritura y ejecución al propietario, y permisos de lectura y ejecución al grupo y a otros usuarios.

A continuación, **escribimos los comandos que queremos que el script ejecute** utilizando un editor de texto como `nano` o `vim`. Por ejemplo:

```bash
#!/bin/bash
# Mi primer script

clear
echo "Hola, mundo!"
```

**La primera línea `#!/bin/bash` es conocida como shebang y le indica al sistema que use el intérprete de Bash para ejecutar el script.**

**En la segunda línea se suele agregar un comentario que describe el propósito del script.**

Los **comentarios se indican con el símbolo `#`** y no son ejecutados por el shell.

A continuación, se suele agregar el comando `clear` para limpiar la consola antes de mostrar cualquier salida.

Por último, se agregan los comandos que queremos ejecutar, como `echo` para imprimir texto en la terminal.

Por último, para **ejecutar el script**, se puede hacer de dos maneras:

**Usando `./` seguido del nombre del script** (si el script está en el directorio actual):

>```bash
>./mi_script.sh
>```

**Usando `bash` seguido del nombre del script**:

>```bash
>bash mi_script.sh
>```

## Variables de Sistema y Variables Definidas por el Usuario

Las **variables de sistema** son variables predefinidas por el sistema operativo que contienen información sobre el entorno del sistema. Se definen en mayúsculas.

Las **Variables Definidas por el Usuario** son variables que los usuarios pueden crear y definir para almacenar valores específicos que pueden ser utilizados en sus scripts. Se definen en minúsculas.

### Variables de Sistema

Para utilizar una variable de sistema se utiliza el símbolo `$` seguido del nombre de la variable. Por ejemplo, para imprimir el nombre del usuario actual, se puede usar la variable `$USER`:

```bash
echo "El usuario actual es: $USER"
```

### Variable Echo

Se utiliza para imprimir texto o valores en la terminal. La sintaxis básica es `echo [opciones] [cadena_de_texto]`.

Algunas opciones comunes de `echo` incluyen:

- `-n`: No agrega una nueva línea al final de la salida.
- `-e`: Habilita la interpretación de secuencias de escape (dentro de la cadena de texto), como:
  - `\n`: Salto de línea
  - `\t`: Tabulación horizontal.
  - `\v`: Tabulación vertical. (la tabulación vertical mueve el texto hacia abajo en la misma columna, no funciona de la misma manera que las tabulaciones horizontales).
  - `\a`: Alerta (sonido).

### Variable READ

Se utiliza para leer la entrada del usuario desde la terminal y asignarla a una variable. La sintaxis básica es `read [opciones] nombre_variable`. Es el equivalente al Scanner en Java.

El dato que se lee se almacena en una variable, que se especifica después del comando `read`.

A la hora de imprimir el valor almacenado en la variable, se utiliza el símbolo `$` seguido del nombre de la variable.

Por ejemplo, para leer el nombre del usuario y almacenarlo en una variable llamada `nombre` para a continuación imprimirlo, se puede hacer lo siguiente:

```bash
echo "Por favor, ingresa tu nombre:"
read nombre
echo "Hola, $nombre! Bienvenido."
```

Si queremos que el dato se lea sin mostrarlo en la terminal (por ejemplo, para contraseñas), se puede usar la opción `-s`:

```bash
echo "Por favor, ingresa tu contraseña:"
read -s contraseña
echo "Contraseña recibida."
```

Si queremos que el dato introducido se muestre en la misma línea que el mensaje, podemos hacer utilizando la opción `-n` en el comando `echo`:

```bash
echo -n "Por favor, ingresa tu nombre: "
read nombre
echo "Hola, $nombre! Bienvenido."
```

### Variables Definidas por el Usuario

Para definir una variable de usuario, se asigna un valor a un nombre de variable sin espacios alrededor del signo `=`. La sintaxis sería `nombre_variable=valor`. Es importante no dejar espacios entre el nombre de la variable, el signo `=` y el valor.

Por ejemplo, para **definir(crear) una variable** llamada `mi_variable` con el valor `Hola`, se haría de la siguiente manera:

```bash
mi_variable="Hola"
```

Para imprimir el valor de la variable, se utiliza  `echo` seguido del símbolo `$` y el nombre de la variable.

```bash
echo $mi_variable # Mostrará `Hola` en la terminal
```

### Operaciones aritméticas básicas

Si queremos hacer operaciones aritméticas básicas, primero debemos definir las variables con valores numéricos. Para hacer la suma, resta, multiplicación o división, podemos usar la sintaxis `$(( expresión ))`, donde `expresión` es la operación que queremos realizar.

Por ejemplo:

```bash
num1=10
num2=5
suma=$((num1 + num2))
echo "La suma es: $suma"
```

Si queremos que los valores los introduzca el usuario, tendremos que usar el comando `read` para leer los valores y luego realizar la operación aritmética. Por ejemplo:

```bash
echo -n "Ingresa el primer número: "
read num1

echo -n "Ingresa el segundo número: "
read num2

suma=$((num1 + num2))
echo "La suma es: $suma"
```

Primero indicamos al usuario que ingrese los números, luego leemos los valores con `read` y finalmente realizamos la suma y mostramos el resultado.

Para realizar otras operaciones, simplemente cambiamos el operador en la expresión aritmética:

```bash
echo -n "Ingresa el primer número: "
read num1

echo -n "Ingresa el segundo número: "
read num2

resta=$((num1 - num2))
echo "La resta es: $resta"

multiplicacion=$((num1 * num2))
echo "La multiplicación es: $multiplicacion"

division=$((num1 / num2))
echo "La división es: $division"
```

Hay que tener en cuenta que la división entre enteros en Bash descarta los decimales. Para que la división incluya decimales se utilizan herramientas que aún no hemos visto.

### Redirección de Entrada y Salida

Es posible redirigir la entrada y salida de los comandos en un script utilizando los operadores `>`, `>>`, `<`.

- `>`: Redirige la salida estándar a un archivo, sobrescribiendo su contenido.
  - Sintaxis básica: `comando > archivo_salida`
- `<`: Redirige la entrada estándar desde un archivo y no desde el teclado.
  - Sintaxis básica: `comando < archivo_entrada`
- `>>`: Redirige la salida estándar a un archivo, pero en lugar de sobrescribir, añade el contenido al final del archivo.
  - Sintaxis básica: `comando >> archivo_salida`.

Por ejemplo, para redirigir la salida de un comando `echo` a un archivo llamado `salida.txt`, se puede hacer lo siguiente:

```bash
echo "Hola, mundo!" > salida.txt
```

Esto creará el archivo `salida.txt` (o lo sobrescribirá si ya existe) con el contenido "Hola, mundo!".

Si queremos redireccionar la salida de una suma a un archivo, podemos hacer lo siguiente:

```bash
echo -n "Ingresa el primer número: "
read num1
echo -n "Ingresa el segundo número: "
read num2
suma=$((num1 + num2))
echo "La suma es: $suma" > resultado_suma.txt
```

Si no queremos sobrescribir el archivo, sino añadir la salida al final del archivo, usamos `>>`:

```bash
echo "La suma es: $suma" >> resultado_suma.txt
```

### Utilizar comandos dentro de un echo

Se pueden utilizar comandos dentro de un `echo` para mostrar el resultado de esos comandos en la terminal. Esto se logra utilizando la sintaxis `$(comando)` o las comillas invertidas `` `comando` ``.

Por ejemplo, para mostrar la fecha y hora actual utilizando el comando `date`, se puede hacer lo siguiente:

```bash
echo "La fecha y hora actual es: $(date)"
```

### Estructuras de control

#### Estructura de control de flujo. IF

Para crear una estructura de control `if` en un shell script, se utiliza la siguiente sintaxis básica: `if [ condición ]; then ... fi`.

Aquí, `condición` es una expresión que se evalúa como verdadera o falsa. Si la condición es verdadera, se ejecutan los comandos dentro del bloque `then`. El bloque `fi` indica el final de la estructura `if`.

Si queremos distinguir entre dos opciones (si se cumple o no la condición), podemos usar la estructura `if...then...else...fi`.

Si tenemos que evaluar múltiples condiciones utilizamos `elif` (else if) para agregar condiciones adicionales.

Ejemplo de estructura básica de `if`:

```bash
echo -n "Ingresa un número: "
read numero

if [ $numero -gt 0 ]; then      # Primera condición. Si es verdadera se ejecuta el then, si no, se pasa al elif
    echo "El número es positivo."
elif [ $numero -lt 0 ]; then    # Segunda condición. Si es verdadera se ejecuta el then, si no, se pasa al else
    echo "El número es negativo."
else                            # Si no se cumple ninguna de las anteriores
    echo "El número es cero."
fi                              # Fin de la estructura if
```

> En este ejemplo, se lee un número del usuario y se evalúa si es positivo, negativo o cero utilizando la estructura `if...elif...else...fi`. Dependiendo del resultado de la evaluación, se imprime el mensaje correspondiente en la terminal.

#### Expresiones para evaluar condiciones

Tenemos distintas expresiones para evaluar condiciones, utilizadas dentro de las estructuras de control, como:

- **Expresiones numéricas**:
  - `-eq`: igual a
  - `-ne`: no igual a
  - `-gt`: mayor que
  - `-ge`: mayor o igual que
  - `-lt`: menor que
  - `-le`: menor o igual que

**Para comparar carácteres o cadenas de texto**, usamos `=` para igualdad y `!=` para desigualdad.

Por ejemplo:

```bash
echo -n "Ingresa una letra: "
read letra
if [ "$letra" = "a" ]; then
    echo "Has ingresado la letra 'a'."
else
    echo "No has ingresado la letra 'a'."
fi
```

Para **comprobar si existe un directorio**, usamos la expresión `-d`.

Para **comprobar si existe un arcihvo**, usamos la expresión `-f`.

Si quisieramos, por ejemplo, hacer un script que cree una carpeta, podríamos hacer lo siguiente:

```bash
echo -n "Ingresa el nombre de la carpeta a crear: "
read nombre_carpeta

if [ -d "$nombre_carpeta" ]; then
    echo "La carpeta '$nombre_carpeta' ya existe."
else
    mkdir "$nombre_carpeta"
    echo "La carpeta '$nombre_carpeta' ha sido creada."
fi
```

Podemos utilizar la virgulilla `~` para referirnos al directorio home del usuario actual.

Si queremos comprobar si existe un archivo en lugar de una carpeta, usamos `-f` en lugar de `-d`.

Para agregar por ejemplo la fecha y hora de la creación de la carpeta al mensaje, podemos usar el comando `date` dentro del `echo`:

```bash
echo -n "Ingresa el nombre de la carpeta a crear: "
read nombre_carpeta

if [ -d "$nombre_carpeta" ]; then
    echo "La carpeta '$nombre_carpeta' ya existe."
else
    mkdir "$nombre_carpeta"
    echo "La carpeta '$nombre_carpeta' ha sido creada el $(date)."
fi
```

Para comprobar si un archivo o carpeta existe o no existe en una ruta determinada, podemos usar `-e` para comprobar si existe y `! -e` para comprobar si no existe.

La ruta que indique el usuario en el read puede ser absoluta o relativa. Es buena práctica indicar al usuario que puede introducir una ruta absoluta o relativa y, imprimir la ruta en la que se encuentra actualmente con pwd.

```bash
echo "Estás en la ruta: $(pwd)"
echo -n "Introduce la ruta del archivo o carpeta: "
read ruta
if [ -e "$ruta" ]; then
    echo "El archivo o carpeta '$ruta' existe."
else
    echo "El archivo o carpeta '$ruta' no existe."
fi
```

#### Estructura de control bucles While

La estructura de control `while` se utiliza para ejecutar un bloque de comandos repetidamente mientras una condición sea verdadera. La sintaxis básica es: `while [ condición ]; do ... done`. `do` indica el inicio del bloque de comandos que se ejecutarán mientras la condición sea verdadera, y `done` indica el final del bloque. Por ejemplo:

```bash
contador=1
while [ $contador -le 5 ]; do
  echo "Contador: $contador"
  contador=$((contador + 1))
done
```

> En este ejemplo, el bucle `while` imprimirá los números del 1 al 5. La variable `contador` se incrementa en cada iteración hasta que la condición `$contador -le 5` ya no sea verdadera.

#### Estructura de control bucle FOR

FOR se utiliza de la misma manera que en Java. Se utiliza para iterar sobre una lista de elementos o un rango de números, por tanto **solo admite numeros enteros**.

Es importante **respetar los espacios y la sintáxis correcta** para que el bucle funcione adecuadamente.

La **sintáxis básica es**:

```bash
for (( inicializacion; condicion; incremento ))
do
  # Comandos a ejecutar en cada iteración
done
```

Por ejemplo, para imprimir números del 1 al 5:

```bash
for (( i=1; i<=5; i++ ))
do
  echo "Número: $i"
done
```

Para crear 20 carpetas:

```bash
echo "Cuantas carpetas quieres crear"
read num #Variable para cantidad de carpetas

for (( i=0; i<$num; i++))
do
mkdir carpeta$i # $i agrega al final del nombre de la carpeta el numero, así no dará error.
done
```

Si preguntaramos al usuario el nombre que quiere para la carpeta y la ruta en que quiere ubicarla (comprobando que la ruta y el nombre son correctos), un código valido sería:

```bash
echo "Cuantas carpetas quieres crear"
read num #Variable para cantidad de carpetas

for (( i=0; i<$num; i++))
do
echo "Donde quieres crear la carpeta"
read ruta
while [ ! -d $ruta ]  # Entrará al bucle si la ruta no es correcta
do
echo "Introduce otra ruta"
read ruta
done

echo "Nombre de carpeta"
read nombre
while [ ! -d $nombre ]  # Entrará al bucle si la carpeta no existe.
do
echo "Introduce otro nombre"
read nombre
done

mkdir $ruta/$nombre # Como hemos comprobado que la ruta y el nombre son correctos, se crea la carpeta.
done  # Fin del bucle for.
```

Antes de cerrar el bucle `for`, se puede agregar un mensaje para dar la opción de continuar o salir del bucle, utilizando un `if` dentro del `for` y comprobando con entero. Por ejemplo:

```bash
echo "Quieres seguir creando carpetas? (1 para sí, 0 para no)"
read opcion
if [ $opcion -eq 0 ]; then
    break  # Sale del bucle for si la opción es 0
fi
```

#### Switch Case

Switch Case se utiliza para ejecutar diferentes bloques de código basados en el valor de una variable o expresión. La sintaxis básica es:

```bash
case variable in
  patrón1)
    # Comandos para patrón1
    ;;
  patrón2)
    # Comandos para patrón2
    ;;
  *)
    # Comandos para cualquier otro caso
    ;;
esac
```

Un ejemplo:

>**Nota: `read -p` permite mostrar un mensaje y leer la entrada** del usuario en la misma línea. Sería una combinación de `echo` y `read`. Al final del read indicamos la variable donde se almacenará el valor introducido por el usuario. En este caso, la variable es `caracter`.

```bash
#!/bin/bash
read -p "Introduzca un carácter alfanumérico: " caracter

case $caracter in
  [A-Z])
    echo "Has introducido una letra mayuscula"
    ;;  # La doble comilla actúa como un break de Java.
  [a-z])
    echo "Has introducido una letra minúscula."
    ;;
  [0-9])
    echo "Has introducido un número."
    ;;
  *)    # Actúa como el default de Java.
    echo "Has introducido un carácter especial."
    ;;
esac  # Para salir del Switch Case
```

> **Para examen: Saber la estructura básica de IF, WHILE, FOR y SWITCH CASE, y aprender las expresiones para evaluar condiciones** (numéricas, comprobar si existe un directorio o archivo...).

### PATRONES

Los **patrones son secuencias de caracteres que se utilizan para buscar y manipular texto en archivos o cadenas**. En los shell scripts, los patrones se utilizan comúnmente con comandos como `grep`, `sed` y `awk` para realizar operaciones de búsqueda y reemplazo.

Script para validar si la cadena de caracteres introducida en consola cumple con el requisito establecido en la condición o no.

La **comparación se realiza con un patrón. Para ello utilizamos el comando `[[ ]]` y el operador `=~` para comparar la variable con el patrón en el IF**. El patrón se define entre corchetes `[]`.

```bash
echo "Introduce dato"
read dato

if [[ $dato =~ [0-9] ]]
then
echo "Correcto"
else
echo "Incorrecto"
fi
```

> En este ejemplo, el script solicita al usuario que introduzca un dato y luego verifica si el dato contiene al menos un dígito (0-9) utilizando el patrón `[0-9]`. Si el dato cumple con el patrón, se imprime "Correcto"; de lo contrario, se imprime "Incorrecto".
>
> Si introducimos por ejemplo "abc123", el resultado será "Correcto" porque contiene dígitos. Si introducimos "abc", el resultado será "Incorrecto" porque no contiene ningún dígito.

Si lo que queremos es **verificar que el número introducido está al final de la cadena**, el patrón sería `[0-9]$`, donde el símbolo `$` indica el final de la cadena.

```bash
echo "Introduce dato"
read dato

if [[ $dato =~ [0-9]$ ]]
then
echo "Correcto"
else
echo "Incorrecto"
fi
```

> En este caso, si el usuario introduce "abc123", el resultado será "Correcto" porque la cadena termina con un dígito.
>
> Si introduce "123abc", el resultado será "Incorrecto" porque la cadena no termina con un dígito.

Si quisieramos **verificar que el número está al principio de la cadena**, el patrón sería `^[0-9]`, donde el símbolo `^` indica el inicio de la cadena.

```bash
echo "Introduce dato"
read dato

if [[ $dato =~ ^[0-9] ]]
then
echo "Correcto"
else
echo "Incorrecto"
fi
```

> En este caso, si el usuario introduce "123abc", el resultado será "Correcto" porque la cadena comienza con un dígito.
>
> Si introduce "abc123", el resultado será "Incorrecto" porque la cadena no comienza con un dígito.

Si queremos **verificar que la cadena contiene solo dígitos**, el patrón sería `^[0-9]+$`, **donde el símbolo `+` indica que debe haber al menos un dígito**.

```bash
echo "Introduce dato"
read dato
if [[ $dato =~ ^[0-9]+$ ]]
then
echo "Correcto"
else
echo "Incorrecto"
fi
```

> En este caso, si el usuario introduce "12345", el resultado será "Correcto" porque la cadena contiene solo dígitos.
> Si introduce "123abc", el resultado será "Incorrecto" porque la cadena contiene caracteres no numéricos.
> Si introduce "abc", el resultado será "Incorrecto" porque la cadena no contiene ningún dígito.
> Si introduce una cadena vacía, el resultado será "Incorrecto" porque la cadena no contiene ningún dígito.
> Si introducimos "123abc123", el resultado será "Incorrecto" porque la cadena contiene caracteres no numéricos.

**Si queremos verificar que la cadena contiene solo letras mayúsculas**, el patrón sería `^[A-Z]+$`.

```bash
echo "Introduce dato"
read dato

if [[ $dato =~ ^[A-Z]+$ ]]
then
echo "Correcto"
else
echo "Incorrecto"
fi
```

> En este caso, si el usuario introduce "ABCDE", el resultado será "Correcto" porque la cadena contiene solo letras mayúsculas.

Si **queremos verificar que la cadena contiene solo letras minúsculas**, el patrón sería `^[a-z]+$`.

```bash
echo "Introduce dato"
read dato
if [[ $dato =~ ^[a-z]+$ ]]
then
echo "Correcto"
else
echo "Incorrecto"
fi
```

> En este caso, si el usuario introduce "abcde", el resultado será "Correcto" porque la cadena contiene solo letras minúsculas.

Si queremos verificar que **el patron introducido empieza y acaba por numeros y contiene letras mayusculas y minusculas en medio**, el patrón sería `^[0-9]+[a-zA-Z]+[0-9]+$`.

```bash
echo "Introduce dato"
read dato
if [[ $dato =~ ^[0-9]+[a-zA-Z]+[0-9]+$ ]]
then
echo "Correcto"
else
echo "Incorrecto"
fi
```

> En este caso, si el usuario introduce "1abc2", el resultado será "Correcto" porque la cadena comienza y termina con dígitos y contiene letras en medio.

Si en el ejemplo anteriro además queremos **verificar que el patrón introducido debe contener un máximo de X digitos**, por ejemplo 5 digitos, el patrón sería `^[0-9]{1,5}[a-zA-Z]+[0-9]{1,5}$`.

```bash
echo "Introduce dato"
read dato

if [[ $dato =~ ^[0-9]{1,5}[a-zA-Z]+[0-9]{1,5}$ ]]
then
echo "Correcto"
else
echo "Incorrecto"
fi
```

> En este caso, si el usuario introduce "123ab45", el resultado será "Correcto" porque la cadena comienza y termina con un máximo de 5 dígitos y contiene letras en medio.

Si por ejemplo, quisieramos **verificar un número de teléfono español**, pero sin contemplar el prefijo 34, el patrón sería `^[6|7][0-9]{8}$`.

```bash
echo "Introduce número de teléfono"
read telefono
if [[ $telefono =~ ^[6|7][0-9]{8}$ ]]
then
echo "Número de teléfono válido"
else
echo "Número de teléfono inválido"
fi
```

> Aquí, el patrón verifica que el número de teléfono comienza con un dígito `6` o `7`, seguido de exactamente 8 dígitos (0-9), lo que da un total de 9 dígitos.

- Por tanto, los números de teléfono válidos podrían ser:
  - `612345678`
  - `712345678`
  - `699999999`

Si lo que **queremos es que el mínimo de dígitos sea 9** el patrón sería `^[6|7][0-9]{8,}$`.

```bash
echo "Introduce número de teléfono"
read telefono
if [[ $telefono =~ ^[6|7][0-9]{8,}$ ]]
then
echo "Número de teléfono válido"
else
echo "Número de teléfono inválido"
fi
```

Si quisieramos **introducir mínimo y máximo de dígitos, por ejemplo entre 9 y 12 dígitos, el patrón sería** `^[6|7][0-9]{8,11}$`.

```bash
echo "Introduce número de teléfono"
read telefono
if [[ $telefono =~ ^[6|7][0-9]{8,11}$ ]]
then
echo "Número de teléfono válido"
else
echo "Número de teléfono inválido"
fi
```

> Aquí, el patrón verifica que el número de teléfono comienza con un dígito `6` o `7`, seguido de entre 8 y 11 dígitos (0-9), lo que da un total de entre 9 y 12 dígitos.

- Algunos ejemplos de números de teléfono válidos podrían ser:
  - `612345678`
  - `71234567890`
  - `699999999999`
- Algunos ejemplos de números de teléfono inválidos podrían ser:
  - `512345678` (no comienza con 6 o 7)
  - `61234567` (menos de 9 dígitos)
  - `7123456789012` (más de 12 dígitos)

> **Consideración examen**: No va a pedir que una verificación de patrón sea muy compleja, en el caso del número de teléfono no pedirá que se verifique el prefijo 34, solo que empiece por 6 o 7 y tenga entre 9 y 12 dígitos.

Si **quisieramos verificar números positivos y negativos enteros**, el patrón sería `^[-+]?[0-9]+$`.

```bash
echo "Introduce un número entero"
read numero
if [[ $numero =~ ^[-+]?[0-9]+$ ]]
then
echo "Número entero válido"
else
echo "Número entero inválido"
fi
```

> En este caso, el patrón verifica que el número puede comenzar opcionalmente con un signo `-` (negativo) o `+` (positivo), seguido de uno o más dígitos (0-9). No aceptará decimales.

Si **queremos que el número pueda ser decimal**, el patrón sería `^[-+]?[0-9]*\.?[0-9]+$`.

```bash
echo "Introduce un número decimal"
read numero
if [[ $numero =~ ^[-+]?[0-9]*\.?[0-9]+$ ]]
then
echo "Número decimal válido"
else
echo "Número decimal inválido"
fi
```

> En este caso, el patrón verifica que el número puede comenzar opcionalmente con un signo `-` (negativo) o `+` (positivo), seguido de cero o más dígitos (0-9), un punto decimal opcional (`.`) y uno o más dígitos (0-9) después del punto decimal. Esto permite números enteros y decimales tanto positivos como negativos.

Si quisieramos además **permitir carácteres especiales como `_`, `-`, `.`, `,` en el número (decimal o entero)**, el patrón sería `^[-+]?([0-9]|[_\-,\.])*[0-9]+$`.

```bash
echo "Introduce un número (entero o decimal) con carácteres especiales"
read numero
if [[ $numero =~ ^[-+]?([0-9]|[_\-,\.])*[0-9]+$ ]]
then
echo "Número válido"
else
echo "Número inválido"
fi
```

> En este caso, el patrón verifica que el número puede comenzar opcionalmente con un signo `-` (negativo) o `+` (positivo), seguido de una combinación de dígitos (0-9) y los caracteres especiales `_`, `-`, `.`, `,`, y termina con uno o más dígitos (0-9). Esto permite números enteros y decimales tanto positivos como negativos, con la inclusión de los caracteres especiales mencionados.

Si **quisieramos verificar una dirección de correo electrónico** que comience con letras, números, puntos, guiones o guiones bajos, seguida del símbolo `@`, luego un dominio que solo podrá ser gmail o hotmail, y finalmente un sufijo de dominio como `.com`, `.es` o `.org`, el patrón sería `^[a-zA-Z0-9._%+-]+@(gmail|hotmail)\.(com|es|org)$`.

```bash
echo "Introduce una dirección de correo electrónico"
read email
if [[ $email =~ ^[a-zA-Z0-9._%+-]+@(gmail|hotmail)\.(com|es|org)$ ]]
then
echo "Correo electrónico válido"
else
echo "Correo electrónico inválido"
fi
```

Si **quisieramos permitir más dominios, simplemente los añadimos** en la parte correspondiente del patrón, separados por el símbolo `|`. Por ejemplo, para añadir yahoo y outlook, el patrón sería `^[a-zA-Z0-9._%+-]+@(gmail|hotmail|yahoo|outlook)\.(com|es|org)$`.

```bash
echo "Introduce una dirección de correo electrónico"
read email

if [[ $email =~ ^[a-zA-Z0-9._%+-]+@(gmail|hotmail|yahoo|outlook)\.(com|es|org)$ ]]
then
echo "Correo electrónico válido"
else
echo "Correo electrónico inválido"
fi
```

Si **queremos que el nombre del correo hasta el símbolo `@` no pueda contener números** el patrón sería `^[a-zA-Z._%+-]+@(gmail|hotmail|yahoo|outlook)\.(com|es|org)$`.

```bash
echo "Introduce una dirección de correo electrónico"
read email

if [[ $email =~ ^[a-zA-Z._%+-]+@(gmail|hotmail|yahoo|outlook)\.(com|es|org)$ ]]
then
echo "Correo electrónico válido"
else
echo "Correo electrónico inválido"
fi
```

> En este caso, el patrón verifica que la dirección de correo electrónico comienza con una combinación de letras (mayúsculas y minúsculas), puntos, guiones, guiones bajos y otros caracteres permitidos, seguida del símbolo `@`, luego un dominio que puede ser `gmail`, `hotmail`, `yahoo` o `outlook`, y finalmente un sufijo de dominio como `.com`, `.es` o `.org`. No se permiten números en la parte del nombre del correo electrónico antes del símbolo `@`.
