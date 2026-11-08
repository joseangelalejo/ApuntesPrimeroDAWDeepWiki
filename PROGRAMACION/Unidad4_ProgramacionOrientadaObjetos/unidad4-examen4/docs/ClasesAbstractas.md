# Clases abstractas en Java

- [Clases abstractas en Java](#clases-abstractas-en-java)
  - [¿Qué es una clase abstracta?](#qué-es-una-clase-abstracta)
    - [¿Para qué se usa?](#para-qué-se-usa)
  - [Características clave](#características-clave)
  - [Relación con herencia y clases padre](#relación-con-herencia-y-clases-padre)
  - [¿Una clase abstracta puede obligar a cualquier clase a usar métodos?](#una-clase-abstracta-puede-obligar-a-cualquier-clase-a-usar-métodos)
  - [¿Qué métodos son obligatorios en la subclase?](#qué-métodos-son-obligatorios-en-la-subclase)

## ¿Qué es una clase abstracta?

Una **clase abstracta** es una clase que **no se puede instanciar directamente** (no puedes hacer `new MiClaseAbstracta()`), y sirve como **plantilla base** para otras clases.

### ¿Para qué se usa?

Una clase abstracta se usa cuando quieres:

- **Definir comportamiento común** (métodos y atributos) que comparten varias subclases.
- **Forzar a las subclases** a implementar ciertos métodos (a través de métodos abstractos).
- Dar una estructura/base que otras clases concretas (no abstractas) extienden y completan.

---

## Características clave

- Se declara con la palabra clave `abstract`:

  ```java
  public abstract class Animal { ... }
  ```

- Puede contener:
  - **Métodos concretos (con cuerpo)**
  - **Métodos abstractos (sin cuerpo)**

    ```java
    public abstract void hacerSonido();
    ```

- Si una clase tiene **al menos un método abstracto**, la clase **debe** declararse como `abstract`.

- Una clase abstracta **no puede instanciarse**:

  ```java
  Animal a = new Animal(); // ERROR
  ```

- Las clases que la **extienden** deben:
  - Implementar todos los métodos abstractos, o
  - Ser también declaradas `abstract`.

---

## Relación con herencia y clases padre

En Java, **heredar** es cuando una clase (hija/subclase) **extiende** a otra (padre/superclase) usando `extends`.

Una **clase abstracta** es un tipo especial de clase padre que:

- NO se puede instanciar directamente.
- Puede declarar métodos que **no tienen implementación** (métodos abstractos).
- Obliga a las subclases a implementar dichos métodos abstractos.

```java
public abstract class Animal {
    public abstract void hacerSonido();
}

public class Perro extends Animal {
    @Override
    public void hacerSonido() {
        System.out.println("Guau");
    }
}
```

En el ejemplo anterior, `Perro` **hereda** de `Animal` y debe implementar `hacerSonido()`.

---

## ¿Una clase abstracta puede obligar a cualquier clase a usar métodos?

No. Una clase abstracta solo puede “forzar” a las clases que la **extienden** (sus subclases).
Una clase que **no extiende** a la abstracta no está obligada a implementar nada de ella.

Si quieres obligar a clases que no tienen relación de herencia entre sí, usa una **interfaz**.

```java
public interface Sonoro {
    void hacerSonido();
}

public class Perro implements Sonoro { ... }
public class Alarma implements Sonoro { ... }
```

---

## ¿Qué métodos son obligatorios en la subclase?

Cuando una clase extiende una clase abstracta, **solo está obligada a implementar** los métodos que la clase abstracta define como `abstract`.

- **Métodos abstractos** → obligatorio implementar en la subclase (a menos que la subclase sea también abstracta).
- **Métodos con implementación** → opcional implementarlos (puedes sobrescribirlos si quieres cambiar el comportamiento).

```java
public abstract class Animal {
    public abstract void hacerSonido(); // obligatorio

    public void dormir() {              // opcional
        System.out.println("ZZZ...");
    }
}

public class Perro extends Animal {
    @Override
    public void hacerSonido() {
        System.out.println("Guau");
    }

    // No hace falta implementar dormir(), pero se podría:
    @Override
    public void dormir() {
        System.out.println("El perro duerme");
    }
}
```

> Resumen: **solo los métodos marcados como `abstract` son los que ‘forzan’ a la clase hija a implementarlos**.
