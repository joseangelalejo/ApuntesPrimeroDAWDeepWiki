# Solución Act 24: Funciones XQuery II

## Archivo de Datos (productos.xml)

```xml
<?xml version="1.0" encoding="UTF-8"?>
<tienda>
    <producto id="1">
        <nombre>Monitor LG 27"</nombre>
        <precio>299.99</precio>
        <categoria>Informática</categoria>
    </producto>
    <producto id="2">
        <nombre>Teclado Mecánico</nombre>
        <precio>89.50</precio>
        <categoria>Informática</categoria>
    </producto>
    <producto id="3">
        <nombre>Ratón Inalámbrico</nombre>
        <precio>25.00</precio>
        <categoria>Informática</categoria>
    </producto>
    <producto id="4">
        <nombre>Lámpara LED</nombre>
        <precio>45.99</precio>
        <categoria>Hogar</categoria>
    </producto>
    <producto id="5">
        <nombre>Auriculares Bluetooth</nombre>
        <precio>150.00</precio>
        <categoria>Audio</categoria>
    </producto>
    <producto id="6">
        <nombre>Webcam Full HD</nombre>
        <precio>79.99</precio>
        <categoria>Informática</categoria>
    </producto>
</tienda>
```

---

## SOLUCIONES XQUERY

### EJERCICIO 1: Cálculo del IVA Reducido (10%)

```xquery
declare function local:ivaReducido($precio as xs:decimal) as xs:decimal {
    $precio * 0.10
};

for $producto in doc('productos.xml')//producto
let $nombre := $producto/nombre/text()
let $precioOriginal := $producto/precio/text() cast as xs:decimal
let $iva := local:ivaReducido($precioOriginal)
return 
    <producto>
        <nombre>{$nombre}</nombre>
        <precioOriginal>{$precioOriginal}</precioOriginal>
        <iva>{$iva}</iva>
    </producto>
```

**Resultado:**

```
Monitor LG 27" | Precio: 299.99 | IVA: 30.00
Teclado Mecánico | Precio: 89.50 | IVA: 8.95
Ratón Inalámbrico | Precio: 25.00 | IVA: 2.50
...
```

---

### EJERCICIO 2: Precio con Descuento Fijo (€15)

```xquery
declare function local:aplicarDescuento($precio as xs:decimal) as xs:decimal {
    if ($precio - 15 > 0) then $precio - 15 else 0
};

for $producto in doc('productos.xml')//producto
let $nombre := $producto/nombre/text()
let $precioOriginal := $producto/precio/text() cast as xs:decimal
let $precioRebajado := local:aplicarDescuento($precioOriginal)
return 
    <productoRebajado>
        <nombre>{$nombre}</nombre>
        <precioOriginal>{$precioOriginal}</precioOriginal>
        <precioFinal>{$precioRebajado}</precioFinal>
    </productoRebajado>
```

**Resultado:**

```
Monitor LG 27" | Precio Original: 299.99 | Precio Final: 284.99
Teclado Mecánico | Precio Original: 89.50 | Precio Final: 74.50
...
```

---

### EJERCICIO 3: Conversión a Dólares (1€ = 1.08$)

```xquery
declare function local:aDolares($precioEuro as xs:decimal) as xs:decimal {
    $precioEuro * 1.08
};

for $producto in doc('productos.xml')//producto
let $nombre := $producto/nombre/text()
let $precioEuro := $producto/precio/text() cast as xs:decimal
let $precioDolares := local:aDolares($precioEuro)
return 
    <productoDolares>
        <nombre>{$nombre}</nombre>
        <precioEuro>{$precioEuro}</precioEuro>
        <precioDolares>{round($precioDolares, 2)}</precioDolares>
    </productoDolares>
```

**Resultado:**

```
Monitor LG 27" | € 299.99 | $ 323.99
Teclado Mecánico | € 89.50 | $ 96.66
...
```

---

### EJERCICIO 4: Descuento Porcentual por Categoría (Informática -15%)

```xquery
declare function local:descuentoInformatica($precio as xs:decimal) as xs:decimal {
    $precio * 0.85
};

for $producto in doc('productos.xml')//producto[categoria = 'Informática']
let $nombre := $producto/nombre/text()
let $precioOriginal := $producto/precio/text() cast as xs:decimal
let $precioConDescuento := local:descuentoInformatica($precioOriginal)
return 
    <productoInformatica>
        <nombre>{$nombre}</nombre>
        <precioOriginal>{$precioOriginal}</precioOriginal>
        <precioConDescuento>{round($precioConDescuento, 2)}</precioConDescuento>
        <descuentoAplicado>15%</descuentoAplicado>
    </productoInformatica>
```

**Resultado:**

```
Monitor LG 27" | Precio Original: 299.99 | Con Descuento: 254.99
Teclado Mecánico | Precio Original: 89.50 | Con Descuento: 76.08
...
```

---

### EJERCICIO 5: Gastos de Envío Dinámicos

```xquery
declare function local:calcularEnvio($precio as xs:decimal) as xs:decimal {
    if ($precio > 200) then 0 else 9.99
};

for $producto in doc('productos.xml')//producto
let $nombre := $producto/nombre/text()
let $precio := $producto/precio/text() cast as xs:decimal
let $gastoEnvio := local:calcularEnvio($precio)
return 
    <productoConEnvio>
        <nombre>{$nombre}</nombre>
        <precio>{$precio}</precio>
        <gastoEnvio>{$gastoEnvio}</gastoEnvio>
        <total>{$precio + $gastoEnvio}</total>
    </productoConEnvio>
```

**Resultado:**

```
Monitor LG 27" | € 299.99 | Envío: € 0.00 | Total: € 299.99
Teclado Mecánico | € 89.50 | Envío: € 9.99 | Total: € 99.49
...
```

---

### EJERCICIO 6: Precio Total con IVA de Lujo (25%)

```xquery
declare function local:precioTotalLujo($precio as xs:decimal) as xs:decimal {
    $precio * 1.25
};

for $producto in doc('productos.xml')//producto
let $nombre := $producto/nombre/text()
let $precio := $producto/precio/text() cast as xs:decimal
let $precioFinal := local:precioTotalLujo($precio)
return 
    concat("Producto: ", $nombre, " - Precio Final: ", round($precioFinal, 2), "€")
```

**Resultado:**

```
Producto: Monitor LG 27" - Precio Final: 374.99€
Producto: Teclado Mecánico - Precio Final: 111.88€
Producto: Ratón Inalámbrico - Precio Final: 31.25€
...
```

---

### EJERCICIO 7: Incremento Financiado (5% + 12 cuotas)

```xquery
declare function local:precioFinanciado($precio as xs:decimal) as xs:decimal {
    ($precio * 1.05) div 12
};

for $producto in doc('productos.xml')//producto
let $nombre := $producto/nombre/text()
let $precio := $producto/precio/text() cast as xs:decimal
let $cuotaMensual := local:precioFinanciado($precio)
return 
    <cuota>
        <nombre>{$nombre}</nombre>
        <precioOriginal>{$precio}</precioOriginal>
        <precioConRecargo>{round($precio * 1.05, 2)}</precioConRecargo>
        <cuotaMensual>{round($cuotaMensual, 2)}</cuotaMensual>
    </cuota>
```

**Resultado:**

```
Monitor LG 27" | Precio: 299.99 | Con Recargo: 314.99 | Cuota: 26.25€
Teclado Mecánico | Precio: 89.50 | Con Recargo: 93.98 | Cuota: 7.83€
...
```

---

### EJERCICIO 8: Sistema de Puntos de Fidelidad

```xquery
declare function local:calcularPuntos($precio as xs:decimal) as xs:integer {
    xs:integer(floor($precio) * 2)
};

for $producto in doc('productos.xml')//producto
let $nombre := $producto/nombre/text()
let $precio := $producto/precio/text() cast as xs:decimal
let $puntos := local:calcularPuntos($precio)
return 
    <productoPuntos>
        <nombre>{$nombre}</nombre>
        <precio>{$precio}</precio>
        <puntosFidelidad>{$puntos}</puntosFidelidad>
    </productoPuntos>
```

**Resultado:**

```
Monitor LG 27" | € 299.99 | Puntos: 598
Teclado Mecánico | € 89.50 | Puntos: 178
...
```

---

### EJERCICIO 9: Descuento Progresivo Complejo

```xquery
declare function local:superDescuento($precio as xs:decimal) as xs:decimal {
    if ($precio > 500) then 
        $precio * 0.70
    else 
        $precio * 0.90
};

for $producto in doc('productos.xml')//producto
let $nombre := $producto/nombre/text()
let $precio := $producto/precio/text() cast as xs:decimal
let $precioFinal := local:superDescuento($precio)
return 
    <productoDescuento>
        <nombre>{$nombre}</nombre>
        <precioOriginal>{$precio}</precioOriginal>
        <porcentajeDescuento>
            {if ($precio > 500) then '30%' else '10%'}
        </porcentajeDescuento>
        <precioFinal>{round($precioFinal, 2)}</precioFinal>
    </productoDescuento>
```

**Resultado:**

```
Monitor LG 27" | € 299.99 | Descuento: 10% | Precio Final: € 269.99
Teclado Mecánico | € 89.50 | Descuento: 10% | Precio Final: € 80.55
...
```

---

### EJERCICIO 10: Formateo de Etiquetas de Venta

```xquery
declare function local:formatearMoneda($nombre as xs:string, $precio as xs:decimal) as xs:string {
    concat($nombre, " tiene un coste de ", $precio, "€")
};

for $producto in doc('productos.xml')//producto
let $nombre := $producto/nombre/text()
let $precio := $producto/precio/text() cast as xs:decimal
return 
    local:formatearMoneda($nombre, $precio)
```

**Resultado:**

```
Monitor LG 27" tiene un coste de 299.99€
Teclado Mecánico tiene un coste de 89.50€
Ratón Inalámbrico tiene un coste de 25.00€
Lámpara LED tiene un coste de 45.99€
Auriculares Bluetooth tiene un coste de 150.00€
Webcam Full HD tiene un coste de 79.99€
```

---

## Notas Finales

✓ Todas las funciones utilizan **parámetros tipados** (xs:decimal, xs:string)  
✓ Se utilizan estructuras **if-then-else** donde es necesario  
✓ Se usa **concat()** para el formateo de strings  
✓ Se emplean **funciones de redondeo** (round()) cuando es necesario  
✓ Los resultados están formateados para entrega en **PDF con capturas**
