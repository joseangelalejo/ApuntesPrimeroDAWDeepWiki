# **Simulacro - Examen Practico U4 - MediaMarkt**

## **CONSULTAS MONOTABLA — 2 puntos**

### **1. Básica (Monotabla) — 0,20 puntos**

Mostrar el nombre, apellido1 y email de todos los clientes.

### **2. Fácil (Monotabla) — 0,30 puntos**

Mostrar todos los productos cuyo precio_venta en producto_variantes sea superior a 500 euros.

### **3. Media (Monotabla) — 0,40 puntos**

Obtener los empleados que estén en estado 'activo' y cuyo salario sea mayor o igual a 24000, mostrando:

- nombre
- apellido1
- salario
- estado_empleado

### **4. Difícil (Monotabla) — 0,50 puntos**

Listar las ventas realizadas entre '2026-02-15' y '2026-03-01', mostrando:

- id_venta
- fecha_venta
- subtotal
- descuento_total
- total

Ordena el resultado por fecha_venta descendente.

### **5. Muy difícil (Monotabla) — 0,60 puntos**

Mostrar las variantes de producto activas cuyo:

- precio_venta esté entre 100 y 800
- stock_minimo sea mayor o igual que 3
- y el color sea distinto de 'Negro'

Debe mostrarse:

- sku
- color
- capacidad
- precio_venta
- stock_minimo

Ordena por precio_venta ascendente y, en caso de empate, por sku.

---

## **COMPOSICIÓN INTERNA — 2 puntos**

### **1. Básica (Interna) — 0,20 puntos**

Mostrar el nombre de cada tienda junto con su dirección:

- nombre de la tienda
- calle
- numero
- codigo_postal

### **2. Fácil (Interna) — 0,30 puntos**

Mostrar los productos junto con su marca, mostrando:

- nombre del producto
- modelo
- nombre de la marca

### **3. Media (Interna) — 0,40 puntos**

Mostrar el detalle de ventas con:

- id_venta
- nombre del producto
- sku de la variante
- cantidad
- precio_unitario
- total_linea

### **4. Difícil (Interna) — 0,50 puntos**

Mostrar las compras a proveedor con:

- id_compra
- fecha_compra
- nombre_comercial del proveedor
- nombre del empleado que realizó la compra
- total

### **5. Muy difícil (Interna) — 0,60 puntos**

Mostrar todas las devoluciones detalladas indicando:

- id_devolucion
- fecha_devolucion
- nombre del cliente
- nombre del producto
- cantidad devuelta
- nombre del motivo de devolución
- estado_producto_devuelto

---

## **COMPOSICIÓN EXTERNA — 2 puntos**

### **1. Básica (Externa) — 0,20 puntos**

Mostrar todas las tiendas y, si tienen almacén asociado, el nombre del almacén.

### **2. Fácil (Externa) — 0,30 puntos**

Mostrar todos los clientes y, si tienen dirección registrada, indicar:

- nombre
- apellido1
- tipo_direccion
- id_direccion

### **3. Media (Externa) — 0,40 puntos**

Mostrar todos los productos y sus variantes, incluyendo también aquellos productos que no tengan variantes.

Debe mostrarse:

- nombre del producto
- modelo
- sku
- color
- capacidad

### **4. Difícil (Externa) — 0,50 puntos**

Mostrar todos los empleados y las ventas que hayan realizado, incluyendo también los empleados que no hayan vendido nada.

Debe mostrarse:

- nombre del empleado
- apellido1
- id_venta
- fecha_venta
- total

### **5. Muy difícil (Externa) — 0,60 puntos**

Mostrar todas las ventas junto con sus devoluciones, incluyendo también las ventas que no hayan sido devueltas.

Debe mostrarse:

- id_venta
- fecha_venta
- total de la venta
- id_devolucion
- fecha_devolucion
- importe_total de la devolución

Ordena por id_venta.

---

## **AGRUPAMIENTO Y FUNCIONES — RESUMEN — 2 puntos**

### **1. Básica (Resumen) — 0,20 puntos**

Contar cuántos clientes hay registrados en la base de datos.

### **2. Fácil (Resumen) — 0,30 puntos**

Mostrar cuántos empleados hay en cada tienda.

Debe mostrarse:

- id_tienda
- número de empleados

### **3. Media (Resumen) — 0,40 puntos**

Calcular, para cada método de pago:

- nombre del método
- número total de pagos
- importe total pagado

### **4. Difícil (Resumen) — 0,50 puntos**

Mostrar, para cada categoría de productos:

- nombre de la categoría
- número de productos
- peso medio de los productos

### **5. Muy difícil (Resumen) — 0,60 puntos**

Obtener, para cada tienda:

- nombre de la tienda
- número total de ventas
- suma total facturada
- importe medio por venta
- venta máxima
- venta mínima

Solo deben aparecer tiendas que tengan ventas registradas.

---

## **CONSULTAS CON SUBCONSULTAS — 2 puntos**

### **1. Básica (Subconsultas) — 0,20 puntos**

Mostrar los productos cuyo id_impuesto coincida con el impuesto llamado 'IVA General' usando subconsulta.

### **2. Fácil (Subconsultas) — 0,30 puntos**

Mostrar los empleados cuyo salario sea superior al salario medio de todos los empleados.

### **3. Media (Subconsultas) — 0,40 puntos**

Mostrar los clientes que han realizado al menos una venta, usando una subconsulta.

### **4. Difícil (Subconsultas) — 0,50 puntos**

Mostrar las variantes de producto cuyo precio_venta sea superior al precio medio de todas las variantes.

Debe mostrarse:

- sku
- precio_venta
- id_producto

### **5. Muy difícil (Subconsultas) — 0,60 puntos**

Mostrar los clientes cuyo importe total acumulado en compras sea superior al importe medio acumulado por cliente.

Debe mostrarse:

- id_cliente
- nombre
- apellido1
- total_acumulado
