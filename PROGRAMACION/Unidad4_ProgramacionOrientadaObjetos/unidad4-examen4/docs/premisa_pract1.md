# Premisa pract1 - Interfaces simples

Crea un conjunto de **interfaces** y clases que modelen distintos tipos de **dispositivos electrónicos**.

## Objetivo

Trabajar con **interfaces**, sus métodos y cómo las clases las implementan.

> 🔧 Esta actividad está alineada con lo visto en clase sobre el uso de interfaces y la palabra clave `implements`.

## Enunciado

1. Define una interfaz `Encendible` con:
   - método `void encender()`
   - método `void apagar()`

2. Define una interfaz `ConectableWiFi` con:
   - método `void conectar(String red)`
   - método `void desconectar()`

3. Crea las clases:
   - `Televisor`
   - `Lampara`
   - `Router`

4. Reglas:
   - `Televisor` implementa `Encendible` y `ConectableWiFi`.
   - `Lampara` implementa solo `Encendible`.
   - `Router` implementa solo `ConectableWiFi`.

5. Añade un `main` que:
   - Cree un `Televisor`, una `Lampara` y un `Router`.
   - Pruebe encender/apagar y conectar/desconectar donde aplique.

---

✅ **Consejo:** Para comprobar que las interfaces funcionan, crea un método estático que reciba `Encendible` o `ConectableWiFi` y llame a los métodos correspondientes, demostrando polimorfismo.
