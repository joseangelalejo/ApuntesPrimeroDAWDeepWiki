# U5 — Control de Excepciones y Lectura/Escritura de Archivos en Java

## Índice

- [U5 — Control de Excepciones y Lectura/Escritura de Archivos en Java](#u5--control-de-excepciones-y-lecturaescritura-de-archivos-en-java)
  - [Índice](#índice)
  - [1. Jerarquía de Throwable](#1-jerarquía-de-throwable)
  - [2. Tipos de excepciones: Checked vs Unchecked](#2-tipos-de-excepciones-checked-vs-unchecked)
  - [3. Manejo de excepciones: try-catch-finally](#3-manejo-de-excepciones-try-catch-finally)
    - [3.1 Estructura básica](#31-estructura-básica)
    - [3.2 Orden de ejecución de los bloques](#32-orden-de-ejecución-de-los-bloques)
    - [3.3 Multi-catch y catch genérico](#33-multi-catch-y-catch-genérico)
    - [3.4 El bloque `finally`](#34-el-bloque-finally)
  - [4. Lanzamiento y propagación: throw / throws](#4-lanzamiento-y-propagación-throw--throws)
    - [`throw` — lanzar una excepción manualmente](#throw--lanzar-una-excepción-manualmente)
    - [`throws` — declarar que un método puede lanzar una excepción](#throws--declarar-que-un-método-puede-lanzar-una-excepción)
    - [Propagación de excepciones](#propagación-de-excepciones)
  - [5. Excepciones personalizadas](#5-excepciones-personalizadas)
    - [5.1 Excepción básica (checked — extiende Exception)](#51-excepción-básica-checked--extiende-exception)
    - [5.2 Excepción con datos extra](#52-excepción-con-datos-extra)
    - [5.3 Excepción unchecked (extiende RuntimeException)](#53-excepción-unchecked-extiende-runtimeexception)
  - [6. Excepciones más comunes en Java](#6-excepciones-más-comunes-en-java)
  - [7. Clase File — Operaciones sobre el sistema de archivos](#7-clase-file--operaciones-sobre-el-sistema-de-archivos)
    - [7.1 Métodos principales](#71-métodos-principales)
    - [7.2 Ejemplo práctico (Act.2) — borrado recursivo](#72-ejemplo-práctico-act2--borrado-recursivo)
  - [8. Lectura y escritura con FileReader / FileWriter](#8-lectura-y-escritura-con-filereader--filewriter)
  - [9. BufferedReader y BufferedWriter (con buffer)](#9-bufferedreader-y-bufferedwriter-con-buffer)
    - [9.1 Por qué usar Buffered](#91-por-qué-usar-buffered)
    - [9.2 BufferedReader](#92-bufferedreader)
    - [9.3 BufferedWriter](#93-bufferedwriter)
    - [9.4 Patrón try-with-resources (la forma correcta)](#94-patrón-try-with-resources-la-forma-correcta)
  - [10. Casos prácticos resueltos](#10-casos-prácticos-resueltos)
    - [Act.1 — Excepciones personalizadas](#act1--excepciones-personalizadas)
      - [Ejercicio 1: CuentaBancaria con SaldoInsuficienteException](#ejercicio-1-cuentabancaria-con-saldoinsuficienteexception)
      - [Ejercicio 2: Usuario con ContrasenaInvalidaException](#ejercicio-2-usuario-con-contrasenainvalidaexception)
    - [Act.3 — Gestión de alumnos con fichero](#act3--gestión-de-alumnos-con-fichero)
  - [11. Referencia rápida y errores comunes](#11-referencia-rápida-y-errores-comunes)
    - [Diferencias clave a memorizar](#diferencias-clave-a-memorizar)
    - [Errores comunes de examen](#errores-comunes-de-examen)

---

## 1. Jerarquía de Throwable

Todo lo que se puede lanzar en Java extiende de `Throwable`:

```
Throwable
├── Error                        ← problemas del sistema, NO se capturan
│   ├── OutOfMemoryError
│   └── StackOverflowError
└── Exception                   ← situaciones recuperables, SÍ se capturan
    ├── IOException              (checked)
    ├── SQLException             (checked)
    ├── ClassNotFoundException   (checked)
    └── RuntimeException         (unchecked)
        ├── ArithmeticException
        ├── NullPointerException
        ├── NumberFormatException
        ├── ArrayIndexOutOfBoundsException
        └── IllegalArgumentException
```

- **Error vs Excepción:**
  - **Error** — problema del sistema (falta de memoria, error de hardware). El programador no puede resolverlo. El programa se detiene.
  - **Excepción** — situación que la aplicación puede manejar de forma controlada.

---

## 2. Tipos de excepciones: Checked vs Unchecked

| Característica                    | Checked                                     | Unchecked                                         |
|-----------------------------------|---------------------------------------------|---------------------------------------------------|
| Clase base                        | `Exception`                                 | `RuntimeException`                                |
| El compilador obliga a manejarlas | ✅ Sí                                        | ❌ No                                              |
| Cómo manejarlas                   | `try-catch` o declarar `throws`             | Optativo                                          |
| Cuándo ocurren                    | Situaciones externas previsibles (I/O, red) | Errores de programación (índice incorrecto, nulo) |
| Ejemplos                          | `IOException`, `SQLException`               | `NullPointerException`, `ArithmeticException`     |

> **Regla práctica:** Si extiendes de `Exception` → checked (obliga al llamante a manejarla). Si extiendes de `RuntimeException` → unchecked (flexible, no obliga).

---

## 3. Manejo de excepciones: try-catch-finally

### 3.1 Estructura básica

```java
try {
    // Código que puede lanzar una excepción
    int resultado = dividir(10, 0);
} catch (ArithmeticException e) {
    // Se ejecuta si ocurre ArithmeticException
    System.out.println("No se puede dividir por cero: " + e.getMessage());
} catch (NullPointerException e) {
    // Se ejecuta si ocurre NullPointerException
    System.out.println("Referencia nula: " + e.getMessage());
} catch (Exception e) {
    // Captura cualquier otra excepción no prevista
    System.out.println("Error inesperado: " + e.getClass().getSimpleName());
} finally {
    // Se ejecuta SIEMPRE, haya o no excepción
    System.out.println("Operación finalizada.");
}
```

### 3.2 Orden de ejecución de los bloques

| Caso                   | Orden de ejecución                                        |
|------------------------|-----------------------------------------------------------|
| Sin excepción          | try → finally → código siguiente                          |
| Excepción capturada    | try (hasta el error) → catch → finally → código siguiente |
| Excepción NO capturada | try (hasta el error) → finally → programa termina         |

> ⚠️ El código **después** del try-catch no se ejecuta si hay una excepción no capturada.

### 3.3 Multi-catch y catch genérico

El **orden importa**: primero las excepciones más específicas, después las más generales. Si pones `Exception` primero, captura todo y los `catch` específicos nunca se ejecutan.

```java
try {
    // código
} catch (ArithmeticException e) {    // ← más específica, primero
    System.out.println("Aritmético");
} catch (RuntimeException e) {       // ← más general
    System.out.println("Runtime");
} catch (Exception e) {              // ← genérico, siempre al final
    System.out.println("General: " + e.getMessage());
}
```

**Multi-catch en una línea** (Java 7+):

```java
} catch (ArithmeticException | NullPointerException e) {
    System.out.println("Error aritmético o nulo");
}
```

### 3.4 El bloque `finally`

- Se ejecuta **siempre**, tanto si hubo excepción como si no.
- Incluso si hay un `return` dentro del `try` o del `catch`, el `finally` se ejecuta antes de devolver el valor.
- **Excepciones donde NO se ejecuta:** `System.exit()`, kill del proceso, error de hardware crítico.
- **Uso principal:** cerrar recursos externos que el recolector de basura de Java no puede gestionar: ficheros, conexiones a BD, sockets de red.

```java
BufferedReader br = null;
try {
    br = new BufferedReader(new FileReader("datos.txt"));
    // leer...
} catch (IOException e) {
    System.out.println("Error de lectura: " + e.getMessage());
} finally {
    if (br != null) {
        try { br.close(); } catch (IOException e) { /* ignorar */ }
    }
}
```

> **Alternativa moderna:** usa `try-with-resources` (ver sección 9.4) — cierra el recurso automáticamente sin necesitar `finally`.

---

## 4. Lanzamiento y propagación: throw / throws

### `throw` — lanzar una excepción manualmente

```java
if (cantidad > saldo) {
    throw new SaldoInsuficienteException("Saldo insuficiente para retirar " + cantidad);
}
```

### `throws` — declarar que un método puede lanzar una excepción

Obligatorio para excepciones **checked** si no las capturas dentro del método:

```java
public double retirar(double cantidad) throws SaldoInsuficienteException {
    if (cantidad > saldo) {
        throw new SaldoInsuficienteException();
    }
    saldo -= cantidad;
    return cantidad;
}
```

El llamante **debe** manejarla:

```java
try {
    cuenta.retirar(500);
} catch (SaldoInsuficienteException e) {
    System.out.println(e.getMessage());
}
```

### Propagación de excepciones

Si un método no captura una excepción, se propaga hacia arriba en la pila de llamadas hasta que alguien la capture o el programa termine.

```
main() → metodoA() → metodoB()
                          ↑
                    lanza excepción
                          ↓ propaga hacia main()
main() la captura o el programa termina
```

- **Cuándo propagar vs capturar:**
  - **Capturar:** cuando puedes hacer algo útil (mostrar mensaje, reintentar, registrar).
  - **Propagar:** cuando el error es crítico o el nivel actual no sabe cómo manejarlo.

---

## 5. Excepciones personalizadas

### 5.1 Excepción básica (checked — extiende Exception)

```java
// Definición
public class SaldoInsuficienteException extends Exception {
    public SaldoInsuficienteException() {
        super("Saldo insuficiente");
    }
    // Constructor adicional con mensaje personalizado
    public SaldoInsuficienteException(String mensaje) {
        super(mensaje);
    }
}
```

```java
// Uso
throw new SaldoInsuficienteException();
// o
throw new SaldoInsuficienteException("Necesitas al menos 100€");
```

### 5.2 Excepción con datos extra

Útil para añadir información de contexto al error (código de error, campo afectado, etc.):

```java
public class MiExcepcionConCodigo extends Exception {
    private int codigoError;

    public MiExcepcionConCodigo(String mensaje, int codigoError) {
        super(mensaje);                    // pasa el mensaje a Exception
        this.codigoError = codigoError;    // dato extra propio
    }

    public int getCodigoError() {
        return codigoError;
    }
}
```

```java
// Uso
try {
    throw new MiExcepcionConCodigo("Número fuera de rango", 1001);
} catch (MiExcepcionConCodigo e) {
    System.out.println(e.getMessage() + " — Código: " + e.getCodigoError());
}
```

### 5.3 Excepción unchecked (extiende RuntimeException)

No obliga al llamante a capturarla ni a declararla con `throws`:

```java
public class DatoInvalidoException extends RuntimeException {
    public DatoInvalidoException(String mensaje) {
        super(mensaje);
    }
}
```

---

## 6. Excepciones más comunes en Java

| Excepción                        | Causa típica                                                                  |
|----------------------------------|-------------------------------------------------------------------------------|
| `ArithmeticException`            | División por cero: `10 / 0`                                                   |
| `NullPointerException`           | Llamar a un método sobre una referencia `null`: `String s = null; s.length()` |
| `NumberFormatException`          | Convertir texto no numérico: `Integer.parseInt("abc")`                        |
| `ArrayIndexOutOfBoundsException` | Acceder a índice fuera del array: `arr[10]` con array de 5                    |
| `ClassCastException`             | Casting incorrecto: `(String) objeto_que_no_es_string`                        |
| `IOException`                    | Error de lectura/escritura de archivos                                        |
| `FileNotFoundException`          | El archivo especificado no existe                                             |
| `StackOverflowError`             | Recursión infinita                                                            |

---

## 7. Clase File — Operaciones sobre el sistema de archivos

`java.io.File` representa una **ruta** (puede ser un archivo o directorio). No lee ni escribe contenido, solo gestiona la estructura del sistema de archivos.

### 7.1 Métodos principales

```java
File f = new File("ruta/al/archivo.txt");
File d = new File("ruta/al/directorio");
```

| Método                  | Descripción                        | Devuelve  |
|-------------------------|------------------------------------|-----------|
| `f.exists()`            | ¿Existe la ruta?                   | `boolean` |
| `f.isFile()`            | ¿Es un archivo?                    | `boolean` |
| `f.isDirectory()`       | ¿Es un directorio?                 | `boolean` |
| `f.canRead()`           | ¿Permiso de lectura?               | `boolean` |
| `f.canWrite()`          | ¿Permiso de escritura?             | `boolean` |
| `f.getName()`           | Nombre del archivo/dir             | `String`  |
| `f.getAbsolutePath()`   | Ruta absoluta completa             | `String`  |
| `f.length()`            | Tamaño en bytes                    | `long`    |
| `d.listFiles()`         | Contenido del directorio           | `File[]`  |
| `d.mkdir()`             | Crea un directorio (un nivel)      | `boolean` |
| `d.mkdirs()`            | Crea directorios anidados          | `boolean` |
| `f.delete()`            | Elimina archivo o directorio vacío | `boolean` |
| `f.renameTo(File dest)` | Renombra/mueve                     | `boolean` |
| `f.createNewFile()`     | Crea un archivo vacío              | `boolean` |

### 7.2 Ejemplo práctico (Act.2) — borrado recursivo

Para borrar un directorio con contenido hay que borrar primero todo lo que hay dentro (recursión):

```java
// Eliminar archivos .txt mayores de 200 bytes (recursivo en subdirectorios)
public static void eliminarTxtGrandes(File directorio) {
    File[] elementos = directorio.listFiles();
    if (elementos == null) return;

    for (File elemento : elementos) {
        if (elemento.isDirectory()) {
            eliminarTxtGrandes(elemento);   // recursión en subdirectorios
        } else if (elemento.isFile()
                && elemento.getName().toLowerCase().endsWith(".txt")
                && elemento.length() > 200) {
            elemento.delete();
        }
    }
}

// Borrar directorio completo de forma recursiva
public static boolean borrarRecursivo(File archivo) {
    File[] elementos = archivo.listFiles();
    if (elementos != null) {
        for (File elemento : elementos) {
            borrarRecursivo(elemento);  // primero vaciamos el contenido
        }
    }
    return archivo.delete();            // luego borramos el dir ya vacío
}
```

---

## 8. Lectura y escritura con FileReader / FileWriter

Para archivos de texto, carácter a carácter. Útil para archivos pequeños:

```java
// LECTURA — FileReader
try (FileReader fr = new FileReader("datos.txt")) {
    int caracter;
    while ((caracter = fr.read()) != -1) {
        System.out.print((char) caracter);
    }
} catch (IOException e) {
    System.out.println("Error: " + e.getMessage());
}

// ESCRITURA — FileWriter
// false = sobreescribe (por defecto), true = añade al final (append)
try (FileWriter fw = new FileWriter("salida.txt", false)) {
    fw.write("Hola mundo\n");
} catch (IOException e) {
    System.out.println("Error: " + e.getMessage());
}
```

> **Inconveniente:** cada `read()` es un acceso a disco. Para archivos grandes, usar **BufferedReader/Writer**.

---

## 9. BufferedReader y BufferedWriter (con buffer)

### 9.1 Por qué usar Buffered

- `FileReader`/`FileWriter` acceden al disco en cada operación, lo que es lento. Las clases `Buffered` añaden un **buffer intermedio en memoria**:
  - **Escritura:** acumula datos en memoria y escribe al disco de una vez cuando el buffer se llena.
  - **Lectura:** lee un bloque grande de disco y lo sirve desde memoria; solo vuelve al disco cuando se agota el buffer.
  - **Ventaja extra de `BufferedReader`:** puede leer **líneas completas** con `readLine()`.

### 9.2 BufferedReader

```java
// Creación (envuelve un FileReader)
BufferedReader br = new BufferedReader(new FileReader("datos.txt"));

// Leer línea a línea (readLine devuelve null al llegar al final del archivo)
String linea;
while ((linea = br.readLine()) != null) {
    System.out.println(linea);
}

br.close();
```

**Métodos principales de BufferedReader:**

| Método                 | Descripción                                                  |
|------------------------|--------------------------------------------------------------|
| `String readLine()`    | Lee una línea completa. Devuelve `null` al final del archivo |
| `int read()`           | Lee un carácter (devuelve entero, castear a `char`)          |
| `boolean ready()`      | `true` si hay más datos para leer                            |
| `void mark(int limit)` | Marca la posición actual (para poder volver)                 |
| `void reset()`         | Vuelve a la posición marcada con `mark()`                    |
| `void close()`         | Cierra el buffer y el FileReader                             |

### 9.3 BufferedWriter

```java
// Modo sobreescritura (por defecto)
BufferedWriter bw = new BufferedWriter(new FileWriter("salida.txt"));

// Modo append (añadir al final del archivo, no sobreescribir)
BufferedWriter bw = new BufferedWriter(new FileWriter("salida.txt", true));

// Escritura
bw.write("Contenido de la línea");
bw.newLine();    // salto de línea (independiente del SO)
bw.flush();      // fuerza volcado del buffer al disco
bw.close();      // flush + cierre
```

**Métodos principales de BufferedWriter:**

| Método                                   | Descripción                                          |
|------------------------------------------|------------------------------------------------------|
| `void write(String s)`                   | Escribe una cadena en el buffer                      |
| `void write(String s, int pos, int len)` | Escribe parte de una cadena                          |
| `void write(int c)`                      | Escribe un carácter                                  |
| `void newLine()`                         | Escribe salto de línea (compatible con todos los SO) |
| `void flush()`                           | Vuelca el buffer al disco sin cerrarlo               |
| `void close()`                           | Flush + cierre del buffer                            |

### 9.4 Patrón try-with-resources (la forma correcta)

Java 7+ permite declarar recursos en el `try` y los cierra automáticamente al salir del bloque, sin necesitar `finally`:

```java
// LECTURA con try-with-resources
try (BufferedReader br = new BufferedReader(new FileReader("alumnos.txt"))) {
    String linea;
    while ((linea = br.readLine()) != null) {
        String[] partes = linea.split(";");
        // procesar partes[0], partes[1], partes[2]...
    }
} catch (IOException e) {
    System.out.println("Error al leer: " + e.getMessage());
}
// br se cierra automáticamente aquí

// ESCRITURA con try-with-resources
try (BufferedWriter bw = new BufferedWriter(new FileWriter("alumnos.txt"))) {
    bw.write("Jose;20;1DAW");
    bw.newLine();
} catch (IOException e) {
    System.out.println("Error al escribir: " + e.getMessage());
}
```

> ⚠️ `new FileWriter("archivo.txt")` sin `true` **sobreescribe** el archivo. Con `true` añade al final.

---

## 10. Casos prácticos resueltos

### Act.1 — Excepciones personalizadas

#### Ejercicio 1: CuentaBancaria con SaldoInsuficienteException

```java
// 1. Clase de excepción
public class SaldoInsuficienteException extends Exception {
    public SaldoInsuficienteException() {
        super("Saldo insuficiente");
    }
}

// 2. Clase con lógica de negocio
public class CuentaBancaria {
    private double saldo;

    public CuentaBancaria(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public double retirar(double cantidad) throws SaldoInsuficienteException {
        if (cantidad > saldo) {
            throw new SaldoInsuficienteException();
        }
        saldo -= cantidad;
        return cantidad;
    }
}

// 3. Main
public class Main {
    public static void main(String[] args) {
        CuentaBancaria cuenta = new CuentaBancaria(100.0);
        try {
            cuenta.retirar(200.0);
        } catch (SaldoInsuficienteException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
```

#### Ejercicio 2: Usuario con ContrasenaInvalidaException

```java
public class ContrasenaInvalidaException extends Exception {
    public ContrasenaInvalidaException() { super("Contraseña inválida"); }
    public ContrasenaInvalidaException(String mensaje) { super(mensaje); }
}

public class Usuario {
    private String contrasena;

    public Usuario(String contrasena) throws ContrasenaInvalidaException {
        setContrasena(contrasena);  // el constructor llama al setter con validación
    }

    public void setContrasena(String contrasena) throws ContrasenaInvalidaException {
        validarContrasena(contrasena);
        this.contrasena = contrasena;
    }

    private void validarContrasena(String contrasena) throws ContrasenaInvalidaException {
        if (contrasena == null || contrasena.length() < 8) {
            throw new ContrasenaInvalidaException("Mínimo 8 caracteres");
        }
        boolean tieneNumero = false;
        for (char c : contrasena.toCharArray()) {  // .toCharArray() → array de char
            if (Character.isDigit(c)) {
                tieneNumero = true;
                break;
            }
        }
        if (!tieneNumero) {
            throw new ContrasenaInvalidaException("Debe contener al menos un número");
        }
    }
}
```

---

### Act.3 — Gestión de alumnos con fichero

Patrón completo de lectura/escritura sobre fichero con objetos:

```java
// Clase alumno (POJO)
public class alumno {
    private String nombre;
    private int edad;
    private String curso;

    public alumno(String nombre, int edad, String curso) {
        this.nombre = nombre;
        this.edad = edad;
        this.curso = curso;
    }

    // Getters, setters y toString en formato fichero
    @Override
    public String toString() {
        return nombre + ";" + edad + ";" + curso;
    }
}

// GestorAlumnos — lectura y escritura
public class GestorAlumnos {
    private static final String ARCHIVO = "alumnos.txt";

    // CARGAR desde fichero
    private void cargarAlumnos() {
        File archivo = new File(ARCHIVO);
        if (!archivo.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty()) continue;
                String[] partes = linea.split(";");
                if (partes.length != 3) continue;

                String nombre = partes[0].trim();
                int edad = Integer.parseInt(partes[1].trim());  // puede lanzar NumberFormatException
                String curso = partes[2].trim();

                agregarAlumnoArray(new alumno(nombre, edad, curso));
            }
        } catch (IOException e) {
            System.out.println("Error al leer: " + e.getMessage());
        }
    }

    // GUARDAR en fichero (sobreescribe con todo el array)
    private boolean guardarAlumnos() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO))) {
            for (int i = 0; i < totalAlumnos; i++) {
                bw.write(alumnos[i].toString());  // usa el toString() del alumno
                bw.newLine();
            }
            return true;
        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
            return false;
        }
    }
}
```

---

## 11. Referencia rápida y errores comunes

### Diferencias clave a memorizar

| Concepto                    | Descripción rápida                                            |
|-----------------------------|---------------------------------------------------------------|
| `throw`                     | Lanza una excepción (crea y dispara el objeto)                |
| `throws`                    | Declara en la firma del método que puede lanzar una excepción |
| `try`                       | Bloque con código que puede fallar                            |
| `catch`                     | Captura una excepción concreta                                |
| `finally`                   | Se ejecuta siempre, haya o no excepción                       |
| `extends Exception`         | Crea excepción checked (obliga a manejarla)                   |
| `extends RuntimeException`  | Crea excepción unchecked (no obliga)                          |
| `FileWriter("f.txt")`       | Sobreescribe el archivo                                       |
| `FileWriter("f.txt", true)` | Añade al final (append)                                       |
| `readLine()`                | Devuelve `null` al llegar al final del archivo                |
| `new File("ruta")`          | No crea el archivo, solo la referencia de ruta                |
| `f.createNewFile()`         | Crea el archivo vacío en disco                                |

### Errores comunes de examen

| Error                                                         | Causa                                            | Solución                                            |
|---------------------------------------------------------------|--------------------------------------------------|-----------------------------------------------------|
| `catch (Exception e)` antes que los específicos               | Captura todo y los específicos nunca se ejecutan | Poner `catch (Exception e)` siempre al final        |
| Olvidar `throws` en la firma del método con excepción checked | El compilador da error                           | Añadir `throws MiExcepcion` en la firma             |
| `new FileWriter("f.txt")` borra el contenido existente        | Modo sobreescritura por defecto                  | Usar `new FileWriter("f.txt", true)` para append    |
| `readLine()` devuelve `null` y se llama `null.split(";")`     | NullPointerException                             | Siempre comprobar `if (linea != null)`              |
| No cerrar el BufferedReader/Writer                            | Pérdida de datos o archivo bloqueado             | Usar try-with-resources o `finally { br.close(); }` |
| `f.delete()` falla en directorio no vacío                     | `delete()` solo borra directorios vacíos         | Hacer borrado recursivo primero                     |
| Excepción checked no capturada en `main`                      | Error de compilación                             | Añadir `try-catch` o `throws` en la firma de `main` |

---

> **Consejo de examen:** Cuando crees una excepción personalizada, recuerda los tres pasos: (1) clase que extiende `Exception` o `RuntimeException`, (2) constructor que llama a `super(mensaje)`, (3) `throw new TuExcepcion()` donde corresponda y `throws TuExcepcion` en la firma del método si es checked.
