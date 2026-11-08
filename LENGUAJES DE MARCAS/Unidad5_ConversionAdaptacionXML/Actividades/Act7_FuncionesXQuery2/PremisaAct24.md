# Actividad 204: Funciones XQuery II

## EJERCICIO 1: Cálculo del IVA Reducido

Crea una función llamada local:ivaReducido($precio as xs:decimal) que calcule el 10% de IVA de un importe. Luego, realiza una consulta FLWOR que devuelva el nombre del producto, su precio original y el valor correspondiente al IVA de cada uno.

## EJERCICIO 2: Precio con Descuento Fijo

Define una función llamada local:aplicarDescuento($precio as xs:decimal) que reste un importe fijo de 15 euros al precio recibido como parámetro. Utilízala en una consulta FLWOR para listar el nombre de todos los productos junto a su nuevo precio rebajado.

## EJERCICIO 3: Conversión de Divisa (Dólares)

Crea una función llamada local:aDolares($precioEuro as xs:decimal) que multiplique el precio en euros por 1.08 para obtener su valor equivalente en dólares. Muestra mediante un bloque FLWOR el nombre de cada artículo y su precio final convertido.

## EJERCICIO 4: Descuento Porcentual Aplicado por Categoría

Crea una función llamada local:descuentoInformatica($precio as xs:decimal) que descuente un 15% al precio recibido. Genera una consulta FLWOR que filtre únicamente los productos de la categoría "Informática" y devuelva su nombre junto al precio tras aplicar la función.

## EJERCICIO 5: Gastos de Envío Dinámicos

Define una función llamada local:calcularEnvio($precio as xs:decimal) que devuelva 0 si el producto cuesta más de 200 euros, y 9.99 si cuesta una cantidad igual o inferior. Utiliza un FLWOR para listar los productos indicando el nombre y su respectivo coste de transporte.

## EJERCICIO 6: Precio Total con IVA de Lujo

Crea una función llamada local:precioTotalLujo($precio as xs:decimal) que sume un 25% de impuestos al precio base. Haz una consulta FLWOR que devuelva para cada producto una cadena formateada obligatoriamente mediante la función concat() con la estructura: "Producto: [Nombre] - Precio Final: [Precio con 25%]".

## EJERCICIO 7: Incremento por Pago Financiado

Define una función local:precioFinanciado($precio as xs:decimal) que aplique un recargo del 5% de interés al precio del producto y lo divida entre 12 cuotas. Mediante un bloque FLWOR, obtén el nombre de los artículos y la cuota mensual exacta que se pagaría por cada uno.

## EJERCICIO 8: Sistema de Puntos de Fidelidad

Crea una función local:calcularPuntos($precio as xs:decimal) que asigne 2 puntos por cada euro entero que cueste el producto. Utiliza FLWOR para listar los nombres de los productos junto a los puntos totales que acumularía un cliente con su compra.

## EJERCICIO 9: Descuento Progresivo Complejo

Crea una función llamada local:superDescuento($precio as xs:decimal) que implemente una estructura condicional if-then-else interna: si el producto supera los 500 euros se le descuenta un 30%, en caso contrario se descuenta un 10%. Usa FLWOR para mostrar el nombre y el precio final de toda la tienda.

## EJERCICIO 10: Formateo de Etiquetas de Venta

Define una función de dos parámetros llamada local:formatearMoneda($nombre as xs:string, $precio as xs:decimal) que devuelva un string unificado con la estructura: "[NOMBRE] tiene un coste de [PRECIO] €". Invoca esta función dentro del retorno del bucle FLWOR.

> MODO DE ENTREGA

Entregar un documentos pdf con capturas de la función XQUERY y el resultado obtenido en la consulta XML.
