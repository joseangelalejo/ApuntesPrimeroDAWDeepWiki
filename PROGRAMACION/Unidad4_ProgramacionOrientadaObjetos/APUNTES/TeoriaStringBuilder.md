# **Teoría de `StringBuilder` en Java - JAAlejo**

## **1. ¿Qué es `StringBuilder`?**

`StringBuilder` es una clase de Java para **construir y modificar cadenas de texto (Strings) de forma eficiente**.

Mientras que un `String` en Java es **inmutable** (cada cambio genera un nuevo objeto), `StringBuilder` es **mutable**: permite cambiar su contenido sin crear instancias adicionales en cada operación.

> Ideal para concatenar o modificar texto en bucles o cuando se generan cadenas dinámicamente.

---

## **2. ¿Por qué usar `StringBuilder` en lugar de `String`?**

### Problema con `String` (inmutabilidad)

Cada vez que concatenas con `+` o `+=`, Java crea un nuevo objeto `String`:

```java
String s = "Hola";
s += " mundo"; // crea un nuevo String

// En un bucle se crean muchos objetos String temporales
for (int i = 0; i < 1000; i++) {
    s += i;
}
```

Esto es costoso en tiempo y memoria.

### Ventaja de `StringBuilder`

Con `StringBuilder`, las concatenaciones se realizan **en el mismo objeto**, evitando creación de muchos objetos temporales:

```java
StringBuilder sb = new StringBuilder();
for (int i = 0; i < 1000; i++) {
    sb.append(i);
}
String resultado = sb.toString();
```

Esto es mucho más eficiente cuando trabajas con texto que se modifica varias veces.

---

## **3. Cómo funciona internamente (`capacity` y `length`)**

`StringBuilder` guarda los caracteres en un **array interno de `char[]`** (buffer).

- **Longitud** (`length`): número de caracteres actualmente contenidos.
- **Capacidad** (`capacity`): tamaño del buffer que puede contener sin necesidad de reallocar.

Cuando se supera la capacidad, el buffer se redimensiona automáticamente (se copia a un array más grande).

La fórmula de crecimiento típica es:

```
newCapacity = (oldCapacity * 2) + 2
```

### Métodos útiles de capacidad

- `sb.capacity()` → capacidad actual del buffer.
- `sb.length()` → número de caracteres usados.
- `sb.ensureCapacity(min)` → asegura que la capacidad sea al menos `min`.
- `sb.trimToSize()` → recorta la capacidad al tamaño actual (`length`).

---

## **4. Constructores de `StringBuilder`**

```java
StringBuilder sb1 = new StringBuilder();          // capacidad inicial 16
StringBuilder sb2 = new StringBuilder(50);        // capacidad inicial 50
StringBuilder sb3 = new StringBuilder("Hola");  // capacidad inicial 20 (16+4)
```

---

## **5. Métodos principales (los más usados)**

### `append(...)` — añade al final

```java
StringBuilder sb = new StringBuilder();
sb.append("Hola");
sb.append(' ');
sb.append(123);

System.out.println(sb.toString()); // "Hola 123"
```

### `insert(int index, ...)` — inserta en una posición

```java
sb.insert(5, "mundo");
```

### `delete(int start, int end)` — elimina un rango

```java
sb.delete(2, 5); // elimina del índice 2 al 4 (end no incluido)
```

### `replace(int start, int end, String str)` — reemplaza un rango

```java
sb.replace(0, 4, "Adiós");
```

### `reverse()` — invierte el contenido

```java
sb.reverse();
```

### `toString()` — obtiene el `String` final

```java
String resultado = sb.toString();
```

### `setLength(int newLength)` — ajusta la longitud

- Si `newLength` es menor, se trunca.
- Si es mayor, se rellena con `\0` (carácter nulo).

```java
sb.setLength(0); // limpia el contenido
```

---

## **6. `StringBuilder` vs `StringBuffer`**

- `StringBuilder`: **no es thread-safe** (no sincroniza), por lo que es más rápido en aplicaciones de un solo hilo.
- `StringBuffer`: **sí es thread-safe** (métodos sincronizados), pero con un coste de rendimiento.

👉 Para la mayoría de los casos en programación sencilla o en una aplicación que no usa varios hilos, **usa `StringBuilder`**.

---

## **7. Ejemplo completo: construir un informe de datos**

```java
public class InformeDemo {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        sb.append("Informe de ventas\n");
        sb.append("================\n");

        for (int i = 1; i <= 5; i++) {
            sb.append("Cliente ").append(i).append(": ");
            sb.append("$" + (i * 10)).append("\n");
        }

        System.out.println(sb.toString());
    }
}
```

---

## **8. Buenas prácticas**

- Si sabes aproximadamente cuánto texto vas a manejar, **inicializa la capacidad** para evitar redimensiones frecuentes:

```java
StringBuilder sb = new StringBuilder(200);
```

- Usa `toString()` al final, no dentro del bucle.
- Si necesitas concatenar pocas cadenas (1–2), puedes usar `String` sin problema; el mayor beneficio de `StringBuilder` aparece cuando hay concatenaciones repetidas.

---

## **9. Resumen rápido**

- `StringBuilder` es mutable y eficiente para construir cadenas.
- Usa `append(...)` para concatenar sin crear objetos temporales.
- Mantén el trabajo de presentación separado (no mezcles `System.out.println` con la lógica del `StringBuilder` si quieres reutilizar el texto en otros contextos).
