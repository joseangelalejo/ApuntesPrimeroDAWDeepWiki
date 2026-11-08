-- ===== CONSULTAS DE PRÁCTICA - BBDD MEDIAMARK =====
-- Descripción: 130 consultas organizadas por tipo y dificultad
-- ===== BASE DE DATOS =====
USE mediamark_db;
-- ===== BLOQUE 1: CONSULTAS MONOTABLA =====
-- ===== BÁSICAS =====
-- 1. Mostrar el nombre, apellido1 y email de todos los empleados activos.
SELECT nombre,
    apellido1,
    email
FROM empleados
WHERE estado_empleado = 'activo';
-- 2. Mostrar el nombre y porcentaje de todos los impuestos activos.
SELECT nombre,
    porcentaje
FROM impuestos
WHERE activo = TRUE;
-- 3. Mostrar el nombre y país de origen de todas las marcas activas.
SELECT nombre,
    pais_origen
FROM marcas
WHERE activa = TRUE;
-- 4. Mostrar el nombre y descripción de todos los departamentos.
SELECT nombre,
    descripcion
FROM departamentos;
-- 5. Mostrar el nombre y código de todas las tiendas activas.
SELECT nombre,
    codigo_tienda
FROM tiendas
WHERE activa = TRUE;
-- 6. Mostrar los cargos existentes ordenados alfabéticamente.
SELECT nombre,
    descripcion
FROM cargos
ORDER BY nombre ASC;
-- 7. Mostrar todos los métodos de pago activos.
SELECT nombre,
    descripcion
FROM metodos_pago
WHERE activo = TRUE;
-- 8. Mostrar el nombre, apellido1 y fecha de nacimiento de todos los clientes.
SELECT nombre,
    apellido1,
    fecha_nacimiento
FROM clientes;
-- ===== FÁCILES =====
-- 9. Mostrar todos los productos cuya garantía sea mayor de 24 meses.
SELECT nombre,
    modelo,
    garantia_meses
FROM productos
WHERE garantia_meses > 24;
-- 10. Mostrar los clientes que aceptan marketing, con su nombre y email.
SELECT nombre,
    apellido1,
    email
FROM clientes
WHERE acepta_marketing = TRUE;
-- 11. Mostrar las variantes cuyo precio de coste sea superior a 500 euros.
SELECT sku,
    color,
    capacidad,
    precio_coste
FROM producto_variantes
WHERE precio_coste > 500;
-- 12. Mostrar los proveedores cuyo estado sea 'activo'.
SELECT nombre_comercial,
    persona_contacto,
    email
FROM proveedores
WHERE estado_proveedor = 'activo';
-- 13. Mostrar los movimientos de inventario de tipo 'entrada'.
SELECT id_movimiento,
    id_almacen,
    id_variante,
    cantidad,
    fecha_movimiento
FROM movimientos_inventario
WHERE tipo_movimiento = 'entrada';
-- 14. Mostrar las ventas con un descuento total mayor que 0.
SELECT id_venta,
    fecha_venta,
    descuento_total,
    total
FROM ventas
WHERE descuento_total > 0;
-- 15. Mostrar los clientes con más de 100 puntos de fidelidad, ordenados por puntos descendente.
SELECT nombre,
    apellido1,
    puntos_fidelidad
FROM clientes
WHERE puntos_fidelidad > 100
ORDER BY puntos_fidelidad DESC;
-- 16. Mostrar los almacenes de tipo 'tienda'.
SELECT nombre,
    tipo_almacen
FROM almacenes
WHERE tipo_almacen = 'tienda';
-- ===== MEDIAS =====
-- 17. Obtener los empleados del departamento de Ventas (id=2) con salario superior a 22000.
SELECT nombre,
    apellido1,
    salario,
    id_departamento
FROM empleados
WHERE id_departamento = 2
    AND salario > 22000;
-- 18. Mostrar las variantes activas de color 'Negro' cuyo precio de venta sea menor de 100 euros.
SELECT sku,
    color,
    precio_venta
FROM producto_variantes
WHERE activa = TRUE
    AND color = 'Negro'
    AND precio_venta < 100;
-- 19. Mostrar los productos activos de la categoría Smartphones (id=9).
SELECT nombre,
    modelo,
    sku_base
FROM productos
WHERE activo = TRUE
    AND id_categoria = 9;
-- 20. Mostrar los pagos con estado 'aceptado' y un importe superior a 500 euros.
SELECT id_pago,
    id_venta,
    importe,
    estado_pago
FROM pagos
WHERE estado_pago = 'aceptado'
    AND importe > 500;
-- 21. Mostrar las devoluciones con estado 'aprobada', indicando id_devolucion, id_venta e importe_total.
SELECT id_devolucion,
    id_venta,
    importe_total,
    estado_devolucion
FROM devoluciones_clientes
WHERE estado_devolucion = 'aprobada';
-- 22. Obtener las compras a proveedor realizadas durante enero de 2026.
SELECT id_compra,
    id_proveedor,
    fecha_compra,
    total
FROM compras_proveedor
WHERE fecha_compra BETWEEN '2026-01-01' AND '2026-01-31 23:59:59';
-- 23. Mostrar las ventas con estado 'pagada' cuyo total supere los 1000 euros.
SELECT id_venta,
    fecha_venta,
    total,
    estado_venta
FROM ventas
WHERE estado_venta = 'pagada'
    AND total > 1000;
-- ===== DIFÍCILES =====
-- 24. Listar las variantes activas con precio de venta entre 200 y 700 euros, ordenadas por precio ascendente.
SELECT sku,
    color,
    capacidad,
    precio_venta,
    stock_minimo
FROM producto_variantes
WHERE activa = TRUE
    AND precio_venta BETWEEN 200 AND 700
ORDER BY precio_venta ASC;
-- 25. Mostrar los empleados contratados antes de 2020 con salario mayor de 25000, ordenados por fecha de contratación.
SELECT nombre,
    apellido1,
    fecha_contratacion,
    salario
FROM empleados
WHERE fecha_contratacion < '2020-01-01'
    AND salario > 25000
ORDER BY fecha_contratacion ASC;
-- 26. Listar los reembolsos procesados entre el 1 y el 10 de marzo de 2026, ordenados por fecha ascendente.
SELECT id_reembolso,
    id_devolucion,
    importe,
    metodo_reembolso,
    fecha_reembolso
FROM reembolsos
WHERE estado_reembolso = 'procesado'
    AND fecha_reembolso BETWEEN '2026-03-01' AND '2026-03-10 23:59:59'
ORDER BY fecha_reembolso ASC;
-- 27. Mostrar los movimientos del almacén 1 de tipo 'salida' o 'reserva', ordenados por fecha descendente.
SELECT id_movimiento,
    tipo_movimiento,
    id_variante,
    cantidad,
    fecha_movimiento
FROM movimientos_inventario
WHERE id_almacen = 1
    AND tipo_movimiento IN ('salida', 'reserva')
ORDER BY fecha_movimiento DESC;
-- ===== MUY DIFÍCILES =====
-- 28. Mostrar las variantes activas cuyo margen bruto (precio_venta - precio_coste) supere 200 euros,
--     ordenadas por margen descendente.
SELECT sku,
    color,
    precio_coste,
    precio_venta,
    (precio_venta - precio_coste) AS margen
FROM producto_variantes
WHERE activa = TRUE
    AND (precio_venta - precio_coste) > 200
ORDER BY margen DESC;
-- 29. Mostrar las ventas de febrero de 2026 con descuento mayor que 0,
--     ordenadas por descuento descendente y luego por total descendente.
SELECT id_venta,
    fecha_venta,
    subtotal,
    descuento_total,
    impuestos_total,
    total
FROM ventas
WHERE fecha_venta BETWEEN '2026-02-01' AND '2026-02-28 23:59:59'
    AND descuento_total > 0
ORDER BY descuento_total DESC,
    total DESC;
-- 30. Listar los clientes registrados en 2023 con puntos de fidelidad entre 50 y 150
--     que acepten marketing, ordenados por puntos descendente.
SELECT nombre,
    apellido1,
    email,
    puntos_fidelidad,
    fecha_registro
FROM clientes
WHERE fecha_registro BETWEEN '2023-01-01' AND '2023-12-31 23:59:59'
    AND puntos_fidelidad BETWEEN 50 AND 150
    AND acepta_marketing = TRUE
ORDER BY puntos_fidelidad DESC;
-- ===== BLOQUE 2: COMPOSICIÓN INTERNA (JOIN / INNER JOIN) =====
-- ===== BÁSICAS =====
-- 31. Mostrar el nombre de cada empleado junto con el nombre de su tienda.
SELECT e.nombre,
    e.apellido1,
    t.nombre AS tienda
FROM empleados e
    JOIN tiendas t ON e.id_tienda = t.id_tienda;
-- 32. Mostrar el nombre de cada producto junto con el nombre de su categoría.
SELECT p.nombre,
    p.modelo,
    c.nombre AS categoria
FROM productos p
    JOIN categorias c ON p.id_categoria = c.id_categoria;
-- 33. Mostrar las ventas con el nombre de la tienda donde se realizaron.
SELECT v.id_venta,
    v.fecha_venta,
    t.nombre AS tienda,
    v.total
FROM ventas v
    JOIN tiendas t ON v.id_tienda = t.id_tienda;
-- 34. Mostrar cada almacén de tipo tienda junto con el nombre de la tienda a la que pertenece.
SELECT a.nombre AS almacen,
    a.tipo_almacen,
    t.nombre AS tienda
FROM almacenes a
    JOIN tiendas t ON a.id_tienda = t.id_tienda;
-- ===== FÁCILES =====
-- 35. Mostrar las variantes de producto con el nombre del producto al que pertenecen.
SELECT pv.sku,
    pv.color,
    pv.capacidad,
    pv.precio_venta,
    p.nombre AS producto
FROM producto_variantes pv
    JOIN productos p ON pv.id_producto = p.id_producto;
-- 36. Mostrar los pagos con el nombre del método de pago utilizado.
SELECT pa.id_pago,
    pa.id_venta,
    mp.nombre AS metodo,
    pa.importe,
    pa.estado_pago
FROM pagos pa
    JOIN metodos_pago mp ON pa.id_metodo_pago = mp.id_metodo_pago;
-- 37. Mostrar las devoluciones con el nombre del cliente y la venta asociada.
SELECT d.id_devolucion,
    d.fecha_devolucion,
    c.nombre,
    c.apellido1,
    d.id_venta,
    d.importe_total
FROM devoluciones_clientes d
    JOIN clientes c ON d.id_cliente = c.id_cliente;
-- 38. Mostrar cada producto junto con su impuesto asociado (nombre y porcentaje).
SELECT p.nombre,
    p.modelo,
    i.nombre AS impuesto,
    i.porcentaje
FROM productos p
    JOIN impuestos i ON p.id_impuesto = i.id_impuesto;
-- ===== MEDIAS =====
-- 39. Mostrar el inventario de cada almacén con nombre del almacén, SKU de la variante y stock disponible.
SELECT a.nombre AS almacen,
    pv.sku,
    inv.stock_actual,
    inv.stock_disponible
FROM inventario inv
    JOIN almacenes a ON inv.id_almacen = a.id_almacen
    JOIN producto_variantes pv ON inv.id_variante = pv.id_variante;
-- 40. Mostrar las ventas con nombre del cliente y nombre del empleado que las realizó.
SELECT v.id_venta,
    v.fecha_venta,
    c.nombre AS cliente,
    e.nombre AS empleado,
    v.total
FROM ventas v
    JOIN clientes c ON v.id_cliente = c.id_cliente
    JOIN empleados e ON v.id_empleado = e.id_empleado;
-- 41. Mostrar el detalle de compras a proveedor con nombre del proveedor y cantidad comprada por variante.
SELECT cp.id_compra,
    pr.nombre_comercial,
    pv.sku,
    cpd.cantidad,
    cpd.precio_unitario
FROM compras_proveedor_detalle cpd
    JOIN compras_proveedor cp ON cpd.id_compra = cp.id_compra
    JOIN proveedores pr ON cp.id_proveedor = pr.id_proveedor
    JOIN producto_variantes pv ON cpd.id_variante = pv.id_variante;
-- 42. Mostrar las devoluciones con el motivo de devolución y el estado del producto devuelto.
SELECT d.id_devolucion,
    d.fecha_devolucion,
    md.nombre AS motivo,
    dd.cantidad,
    dd.estado_producto_devuelto
FROM devoluciones_clientes_detalle dd
    JOIN devoluciones_clientes d ON dd.id_devolucion = d.id_devolucion
    JOIN motivos_devolucion md ON dd.id_motivo_devolucion = md.id_motivo_devolucion;
-- 43. Mostrar los empleados junto con su departamento y cargo.
SELECT e.nombre,
    e.apellido1,
    d.nombre AS departamento,
    c.nombre AS cargo
FROM empleados e
    JOIN departamentos d ON e.id_departamento = d.id_departamento
    JOIN cargos c ON e.id_cargo = c.id_cargo;
-- ===== DIFÍCILES =====
-- 44. Mostrar las ventas con nombre de tienda, nombre del cliente y método de pago utilizado.
SELECT v.id_venta,
    t.nombre AS tienda,
    c.nombre AS cliente,
    mp.nombre AS metodo_pago,
    v.total
FROM ventas v
    JOIN tiendas t ON v.id_tienda = t.id_tienda
    JOIN clientes c ON v.id_cliente = c.id_cliente
    JOIN pagos p ON p.id_venta = v.id_venta
    JOIN metodos_pago mp ON p.id_metodo_pago = mp.id_metodo_pago;
-- 45. Mostrar los reembolsos con el nombre del cliente, la venta original y el importe reembolsado.
SELECT r.id_reembolso,
    c.nombre,
    c.apellido1,
    v.id_venta,
    r.importe,
    r.metodo_reembolso
FROM reembolsos r
    JOIN devoluciones_clientes dc ON r.id_devolucion = dc.id_devolucion
    JOIN clientes c ON dc.id_cliente = c.id_cliente
    JOIN ventas v ON dc.id_venta = v.id_venta;
-- 46. Mostrar el detalle de ventas incluyendo nombre de tienda, nombre del producto, marca y precio vendido.
SELECT t.nombre AS tienda,
    p.nombre AS producto,
    m.nombre AS marca,
    vd.cantidad,
    vd.precio_unitario,
    vd.total_linea
FROM ventas_detalle vd
    JOIN ventas v ON vd.id_venta = v.id_venta
    JOIN tiendas t ON v.id_tienda = t.id_tienda
    JOIN producto_variantes pv ON vd.id_variante = pv.id_variante
    JOIN productos p ON pv.id_producto = p.id_producto
    JOIN marcas m ON p.id_marca = m.id_marca;
-- ===== MUY DIFÍCILES =====
-- 47. Mostrar todos los empleados con su jefe directo (nombre y apellido del jefe).
SELECT e.nombre AS empleado,
    e.apellido1 AS apellido_empleado,
    j.nombre AS jefe,
    j.apellido1 AS apellido_jefe
FROM empleados e
    JOIN empleados j ON e.id_jefe = j.id_empleado;
-- 48. Mostrar las devoluciones con nombre del cliente, empleado que la gestionó,
--     producto devuelto y motivo.
SELECT dc.id_devolucion,
    c.nombre AS cliente,
    e.nombre AS empleado,
    p.nombre AS producto,
    md.nombre AS motivo,
    dcd.estado_producto_devuelto
FROM devoluciones_clientes dc
    JOIN clientes c ON dc.id_cliente = c.id_cliente
    JOIN empleados e ON dc.id_empleado_gestiona = e.id_empleado
    JOIN devoluciones_clientes_detalle dcd ON dc.id_devolucion = dcd.id_devolucion
    JOIN ventas_detalle vd ON dcd.id_venta_detalle = vd.id_venta_detalle
    JOIN producto_variantes pv ON vd.id_variante = pv.id_variante
    JOIN productos p ON pv.id_producto = p.id_producto
    JOIN motivos_devolucion md ON dcd.id_motivo_devolucion = md.id_motivo_devolucion;
-- ===== BLOQUE 3: COMPOSICIÓN EXTERNA (LEFT JOIN) =====
-- ===== BÁSICAS =====
-- 49. Mostrar todos los productos y, si tienen variantes, mostrar el SKU de la variante.
SELECT p.nombre,
    p.modelo,
    pv.sku
FROM productos p
    LEFT JOIN producto_variantes pv ON p.id_producto = pv.id_producto;
-- 50. Mostrar todos los clientes y, si han realizado alguna venta, mostrar el id_venta.
SELECT c.nombre,
    c.apellido1,
    v.id_venta
FROM clientes c
    LEFT JOIN ventas v ON c.id_cliente = v.id_cliente;
-- 51. Mostrar todos los almacenes y, si tienen inventario registrado, mostrar el id_variante y el stock.
SELECT a.nombre AS almacen,
    inv.id_variante,
    inv.stock_actual
FROM almacenes a
    LEFT JOIN inventario inv ON a.id_almacen = inv.id_almacen;
-- 52. Mostrar todos los motivos de devolución y, si hay devoluciones con ese motivo, mostrar el id_devolucion.
SELECT md.nombre AS motivo,
    dcd.id_devolucion
FROM motivos_devolucion md
    LEFT JOIN devoluciones_clientes_detalle dcd ON md.id_motivo_devolucion = dcd.id_motivo_devolucion;
-- ===== FÁCILES =====
-- 53. Mostrar todos los empleados y, si han autorizado algún pago, mostrar el id_pago correspondiente.
SELECT e.nombre,
    e.apellido1,
    p.id_pago
FROM empleados e
    LEFT JOIN pagos p ON e.id_empleado = p.autorizado_por;
-- 54. Mostrar todas las ventas y, si tienen devolución asociada, mostrar el id_devolucion y el estado.
SELECT v.id_venta,
    v.total,
    d.id_devolucion,
    d.estado_devolucion
FROM ventas v
    LEFT JOIN devoluciones_clientes d ON v.id_venta = d.id_venta;
-- 55. Mostrar todos los proveedores y, si tienen productos asociados, mostrar el id_variante.
SELECT pr.nombre_comercial,
    pp.id_variante
FROM proveedores pr
    LEFT JOIN proveedores_productos pp ON pr.id_proveedor = pp.id_proveedor;
-- 56. Mostrar todas las categorías y, si tienen productos, mostrar el nombre del producto.
SELECT cat.nombre AS categoria,
    p.nombre AS producto
FROM categorias cat
    LEFT JOIN productos p ON cat.id_categoria = p.id_categoria;
-- ===== MEDIAS =====
-- 57. Mostrar todos los productos con sus variantes activas,
--     incluyendo también los productos sin variantes activas.
SELECT p.nombre,
    p.modelo,
    pv.sku,
    pv.color,
    pv.precio_venta
FROM productos p
    LEFT JOIN producto_variantes pv ON p.id_producto = pv.id_producto
    AND pv.activa = TRUE;
-- 58. Mostrar todos los clientes con su dirección principal (si la tienen).
SELECT c.nombre,
    c.apellido1,
    cd.tipo_direccion,
    d.calle,
    d.numero
FROM clientes c
    LEFT JOIN clientes_direcciones cd ON c.id_cliente = cd.id_cliente
    AND cd.es_principal = TRUE
    LEFT JOIN direcciones d ON cd.id_direccion = d.id_direccion;
-- 59. Mostrar todos los empleados y las devoluciones que hayan gestionado,
--     incluyendo los que no gestionaron ninguna.
SELECT e.nombre,
    e.apellido1,
    dc.id_devolucion,
    dc.estado_devolucion
FROM empleados e
    LEFT JOIN devoluciones_clientes dc ON e.id_empleado = dc.id_empleado_gestiona;
-- 60. Mostrar todas las marcas y los productos de cada una, incluyendo marcas sin productos.
SELECT m.nombre AS marca,
    p.nombre AS producto,
    p.modelo
FROM marcas m
    LEFT JOIN productos p ON m.id_marca = p.id_marca;
-- ===== DIFÍCILES =====
-- 61. Mostrar todos los empleados con sus ventas, incluyendo empleados que no han vendido,
--     mostrando también el nombre de la tienda.
SELECT e.nombre,
    e.apellido1,
    t.nombre AS tienda,
    v.id_venta,
    v.total
FROM empleados e
    JOIN tiendas t ON e.id_tienda = t.id_tienda
    LEFT JOIN ventas v ON e.id_empleado = v.id_empleado;
-- 62. Mostrar todos los proveedores y las compras realizadas a cada uno,
--     incluyendo proveedores sin compras.
SELECT pr.nombre_comercial,
    cp.id_compra,
    cp.fecha_compra,
    cp.total
FROM proveedores pr
    LEFT JOIN compras_proveedor cp ON pr.id_proveedor = cp.id_proveedor;
-- 63. Mostrar todas las variantes y su inventario en almacenes,
--     incluyendo variantes sin stock registrado.
SELECT pv.sku,
    pv.color,
    a.nombre AS almacen,
    inv.stock_actual
FROM producto_variantes pv
    LEFT JOIN inventario inv ON pv.id_variante = inv.id_variante
    LEFT JOIN almacenes a ON inv.id_almacen = a.id_almacen;
-- ===== MUY DIFÍCILES =====
-- 64. Mostrar todas las ventas con sus pagos y reembolsos asociados (si los hay).
SELECT v.id_venta,
    v.total,
    p.id_pago,
    mp.nombre AS metodo_pago,
    r.id_reembolso,
    r.importe AS importe_reembolso
FROM ventas v
    LEFT JOIN pagos p ON v.id_venta = p.id_venta
    LEFT JOIN metodos_pago mp ON p.id_metodo_pago = mp.id_metodo_pago
    LEFT JOIN reembolsos r ON p.id_pago = r.id_pago;
-- 65. Mostrar todos los clientes con sus ventas y devoluciones,
--     incluyendo clientes sin actividad, ordenados por id_cliente.
SELECT c.nombre,
    c.apellido1,
    v.id_venta,
    v.total,
    d.id_devolucion,
    d.importe_total
FROM clientes c
    LEFT JOIN ventas v ON c.id_cliente = v.id_cliente
    LEFT JOIN devoluciones_clientes d ON v.id_venta = d.id_venta
ORDER BY c.id_cliente;
-- ===== BLOQUE 4: AGRUPAMIENTO Y FUNCIONES (GROUP BY) =====
-- ===== BÁSICAS =====
-- 66. Contar cuántos proveedores hay registrados.
SELECT COUNT(*) AS total_proveedores
FROM proveedores;
-- 67. Contar cuántos productos activos hay en la base de datos.
SELECT COUNT(*) AS total_productos
FROM productos
WHERE activo = TRUE;
-- 68. Mostrar el salario máximo, mínimo y medio de todos los empleados.
SELECT MAX(salario) AS salario_max,
    MIN(salario) AS salario_min,
    AVG(salario) AS salario_medio
FROM empleados;
-- 69. Contar cuántas variantes de producto hay por cada producto.
SELECT id_producto,
    COUNT(*) AS num_variantes
FROM producto_variantes
GROUP BY id_producto;
-- ===== FÁCILES =====
-- 70. Mostrar cuántos clientes hay por estado.
SELECT estado_cliente,
    COUNT(*) AS total
FROM clientes
GROUP BY estado_cliente;
-- 71. Mostrar el total facturado por cada tienda.
SELECT id_tienda,
    SUM(total) AS total_facturado
FROM ventas
GROUP BY id_tienda;
-- 72. Mostrar el número de ventas realizadas por cada empleado.
SELECT id_empleado,
    COUNT(*) AS num_ventas
FROM ventas
GROUP BY id_empleado;
-- 73. Mostrar la suma total de stock disponible por almacén.
SELECT id_almacen,
    SUM(stock_disponible) AS total_stock
FROM inventario
GROUP BY id_almacen;
-- ===== MEDIAS =====
-- 74. Calcular, para cada marca, el número de productos y el peso medio.
SELECT id_marca,
    COUNT(*) AS num_productos,
    AVG(peso) AS peso_medio
FROM productos
GROUP BY id_marca;
-- 75. Mostrar el importe total reembolsado por método de reembolso.
SELECT metodo_reembolso,
    COUNT(*) AS num_reembolsos,
    SUM(importe) AS total_reembolsado
FROM reembolsos
GROUP BY metodo_reembolso;
-- 76. Mostrar el número de devoluciones por motivo.
SELECT id_motivo_devolucion,
    COUNT(*) AS total_devoluciones
FROM devoluciones_clientes_detalle
GROUP BY id_motivo_devolucion;
-- 77. Calcular el total comprado a cada proveedor (suma del campo total de compras_proveedor).
SELECT id_proveedor,
    COUNT(*) AS num_compras,
    SUM(total) AS total_comprado
FROM compras_proveedor
GROUP BY id_proveedor;
-- 78. Mostrar el precio de venta máximo, mínimo y medio por cada producto.
SELECT id_producto,
    MAX(precio_venta) AS precio_max,
    MIN(precio_venta) AS precio_min,
    AVG(precio_venta) AS precio_medio
FROM producto_variantes
GROUP BY id_producto;
-- ===== DIFÍCILES =====
-- 79. Mostrar, para cada tienda, el número de empleados por departamento.
SELECT id_tienda,
    id_departamento,
    COUNT(*) AS num_empleados
FROM empleados
GROUP BY id_tienda,
    id_departamento
ORDER BY id_tienda,
    id_departamento;
-- 80. Mostrar los métodos de pago con más de 3 usos, indicando cuántas veces se han utilizado.
SELECT id_metodo_pago,
    COUNT(*) AS usos
FROM pagos
GROUP BY id_metodo_pago
HAVING COUNT(*) > 3;
-- 81. Mostrar el total vendido por tienda en febrero de 2026,
--     solo para tiendas con más de 3 ventas ese mes.
SELECT id_tienda,
    COUNT(*) AS num_ventas,
    SUM(total) AS total_mes
FROM ventas
WHERE fecha_venta BETWEEN '2026-02-01' AND '2026-02-28 23:59:59'
GROUP BY id_tienda
HAVING COUNT(*) > 3;
-- 82. Mostrar las categorías con más de 2 productos activos.
SELECT id_categoria,
    COUNT(*) AS num_productos
FROM productos
WHERE activo = TRUE
GROUP BY id_categoria
HAVING COUNT(*) > 2;
-- ===== MUY DIFÍCILES =====
-- 83. Obtener, para cada cliente, el número de compras, el total gastado y el ticket medio.
SELECT id_cliente,
    COUNT(*) AS num_ventas,
    SUM(total) AS total_gastado,
    AVG(total) AS ticket_medio
FROM ventas
GROUP BY id_cliente;
-- 84. Mostrar, para cada tipo de movimiento de inventario,
--     la cantidad total movida y el número de movimientos.
SELECT tipo_movimiento,
    COUNT(*) AS num_movimientos,
    SUM(cantidad) AS cantidad_total
FROM movimientos_inventario
GROUP BY tipo_movimiento;
-- 85. Obtener las marcas que tienen más de 3 variantes activas en total,
--     mostrando el nombre de la marca.
SELECT m.nombre AS marca,
    COUNT(pv.id_variante) AS num_variantes
FROM marcas m
    JOIN productos p ON m.id_marca = p.id_marca
    JOIN producto_variantes pv ON p.id_producto = pv.id_producto
    AND pv.activa = TRUE
GROUP BY m.id_marca,
    m.nombre
HAVING COUNT(pv.id_variante) > 3;
-- 86. Para cada tienda, mostrar el número total de ventas, la suma facturada,
--     el máximo y mínimo por venta, y el ticket medio.
--     Solo deben aparecer tiendas con al menos 4 ventas.
SELECT t.nombre AS tienda,
    COUNT(v.id_venta) AS num_ventas,
    SUM(v.total) AS total_facturado,
    MAX(v.total) AS venta_max,
    MIN(v.total) AS venta_min,
    AVG(v.total) AS ticket_medio
FROM tiendas t
    JOIN ventas v ON t.id_tienda = v.id_tienda
GROUP BY t.id_tienda,
    t.nombre
HAVING COUNT(v.id_venta) >= 4;
-- ===== BLOQUE 5: SUBCONSULTAS =====
-- ===== BÁSICAS =====
-- 87. Mostrar los empleados que trabajan en la tienda con código 'MAD-001' usando subconsulta.
SELECT nombre,
    apellido1,
    email
FROM empleados
WHERE id_tienda = (
        SELECT id_tienda
        FROM tiendas
        WHERE codigo_tienda = 'MAD-001'
    );
-- 88. Mostrar los productos de la marca 'Samsung' usando subconsulta.
SELECT nombre,
    modelo,
    sku_base
FROM productos
WHERE id_marca = (
        SELECT id_marca
        FROM marcas
        WHERE nombre = 'Samsung'
    );
-- 89. Mostrar las variantes del producto llamado 'iPhone 15' usando subconsulta.
SELECT sku,
    color,
    capacidad,
    precio_venta
FROM producto_variantes
WHERE id_producto = (
        SELECT id_producto
        FROM productos
        WHERE nombre = 'iPhone 15'
    );
-- 90. Mostrar los almacenes de tipo 'tienda' asociados a tiendas activas, usando subconsulta.
SELECT nombre,
    tipo_almacen
FROM almacenes
WHERE id_tienda IN (
        SELECT id_tienda
        FROM tiendas
        WHERE activa = TRUE
    );
-- ===== FÁCILES =====
-- 91. Mostrar los clientes que han realizado alguna devolución, usando subconsulta.
SELECT nombre,
    apellido1,
    email
FROM clientes
WHERE id_cliente IN (
        SELECT id_cliente
        FROM devoluciones_clientes
        WHERE id_cliente IS NOT NULL
    );
-- 92. Mostrar las ventas cuyo total supere el total medio de todas las ventas.
SELECT id_venta,
    fecha_venta,
    total
FROM ventas
WHERE total > (
        SELECT AVG(total)
        FROM ventas
    );
-- 93. Mostrar los productos cuyo peso sea superior al peso medio de todos los productos.
SELECT nombre,
    modelo,
    peso
FROM productos
WHERE peso > (
        SELECT AVG(peso)
        FROM productos
        WHERE peso IS NOT NULL
    );
-- 94. Mostrar los empleados que ganan más que el empleado con id_empleado = 12.
SELECT nombre,
    apellido1,
    salario
FROM empleados
WHERE salario > (
        SELECT salario
        FROM empleados
        WHERE id_empleado = 12
    );
-- ===== MEDIAS =====
-- 95. Mostrar los clientes que NO han realizado ninguna compra, usando subconsulta.
SELECT nombre,
    apellido1,
    email
FROM clientes
WHERE id_cliente NOT IN (
        SELECT id_cliente
        FROM ventas
        WHERE id_cliente IS NOT NULL
    );
-- 96. Mostrar las variantes cuyo precio de venta sea igual al precio máximo de todas las variantes.
SELECT sku,
    color,
    precio_venta
FROM producto_variantes
WHERE precio_venta = (
        SELECT MAX(precio_venta)
        FROM producto_variantes
    );
-- 97. Mostrar los productos que tienen al menos una variante activa.
SELECT nombre,
    modelo
FROM productos
WHERE id_producto IN (
        SELECT id_producto
        FROM producto_variantes
        WHERE activa = TRUE
    );
-- 98. Mostrar los proveedores que han recibido al menos una compra.
SELECT nombre_comercial,
    persona_contacto
FROM proveedores
WHERE id_proveedor IN (
        SELECT id_proveedor
        FROM compras_proveedor
    );
-- ===== DIFÍCILES =====
-- 99. Mostrar las variantes cuyo precio de venta sea superior al precio medio de su mismo producto.
SELECT pv.sku,
    pv.id_producto,
    pv.precio_venta
FROM producto_variantes pv
WHERE pv.precio_venta > (
        SELECT AVG(pv2.precio_venta)
        FROM producto_variantes pv2
        WHERE pv2.id_producto = pv.id_producto
    );
-- 100. Mostrar los empleados que han gestionado devoluciones de productos defectuosos.
SELECT DISTINCT e.nombre,
    e.apellido1
FROM empleados e
WHERE e.id_empleado IN (
        SELECT dc.id_empleado_gestiona
        FROM devoluciones_clientes dc
            JOIN devoluciones_clientes_detalle dcd ON dc.id_devolucion = dcd.id_devolucion
        WHERE dcd.id_motivo_devolucion = (
                SELECT id_motivo_devolucion
                FROM motivos_devolucion
                WHERE nombre = 'Producto defectuoso'
            )
    );
-- 101. Mostrar las tiendas cuya facturación total supera la facturación media por tienda.
SELECT id_tienda,
    SUM(total) AS total_tienda
FROM ventas
GROUP BY id_tienda
HAVING SUM(total) > (
        SELECT AVG(total_tienda)
        FROM (
                SELECT SUM(total) AS total_tienda
                FROM ventas
                GROUP BY id_tienda
            ) sub
    );
-- 102. Mostrar los clientes cuyo número de ventas sea superior a la media de ventas por cliente.
SELECT id_cliente,
    COUNT(*) AS num_ventas
FROM ventas
GROUP BY id_cliente
HAVING COUNT(*) > (
        SELECT AVG(cnt)
        FROM (
                SELECT COUNT(*) AS cnt
                FROM ventas
                GROUP BY id_cliente
            ) sub
    );
-- ===== MUY DIFÍCILES =====
-- 103. Mostrar los clientes cuyo total acumulado en ventas sea superior
--      al total acumulado medio por cliente.
SELECT c.id_cliente,
    c.nombre,
    c.apellido1,
    SUM(v.total) AS total_acumulado
FROM clientes c
    JOIN ventas v ON c.id_cliente = v.id_cliente
GROUP BY c.id_cliente,
    c.nombre,
    c.apellido1
HAVING SUM(v.total) > (
        SELECT AVG(total_cliente)
        FROM (
                SELECT SUM(total) AS total_cliente
                FROM ventas
                WHERE id_cliente IS NOT NULL
                GROUP BY id_cliente
            ) sub
    );
-- 104. Mostrar los productos que se han vendido en más de una tienda diferente.
SELECT p.nombre,
    p.modelo,
    COUNT(DISTINCT v.id_tienda) AS num_tiendas
FROM productos p
    JOIN producto_variantes pv ON p.id_producto = pv.id_producto
    JOIN ventas_detalle vd ON pv.id_variante = vd.id_variante
    JOIN ventas v ON vd.id_venta = v.id_venta
GROUP BY p.id_producto,
    p.nombre,
    p.modelo
HAVING COUNT(DISTINCT v.id_tienda) > 1;
-- 105. Mostrar las variantes que nunca han sido devueltas.
SELECT sku,
    color,
    precio_venta
FROM producto_variantes
WHERE id_variante NOT IN (
        SELECT DISTINCT pv.id_variante
        FROM producto_variantes pv
            JOIN ventas_detalle vd ON pv.id_variante = vd.id_variante
            JOIN devoluciones_clientes_detalle dcd ON vd.id_venta_detalle = dcd.id_venta_detalle
    );
-- ===== BLOQUE 6: CONSULTAS EXTRA DE PRÁCTICA =====
-- 106. Mostrar los empleados de la tienda de Barcelona junto con su cargo.
SELECT e.nombre,
    e.apellido1,
    c.nombre AS cargo
FROM empleados e
    JOIN cargos c ON e.id_cargo = c.id_cargo
WHERE e.id_tienda = (
        SELECT id_tienda
        FROM tiendas
        WHERE codigo_tienda = 'BCN-001'
    );
-- 107. Mostrar las ventas de marzo de 2026 con el nombre del cliente y el total.
SELECT v.id_venta,
    c.nombre,
    c.apellido1,
    v.fecha_venta,
    v.total
FROM ventas v
    JOIN clientes c ON v.id_cliente = c.id_cliente
WHERE v.fecha_venta >= '2026-03-01'
    AND v.fecha_venta < '2026-04-01';
-- 108. Mostrar todos los productos con su categoría y la categoría padre (si la tienen).
SELECT p.nombre,
    c.nombre AS categoria,
    cp.nombre AS categoria_padre
FROM productos p
    JOIN categorias c ON p.id_categoria = c.id_categoria
    LEFT JOIN categorias cp ON c.id_categoria_padre = cp.id_categoria;
-- 109. Mostrar las 5 variantes más caras activas.
SELECT sku,
    color,
    capacidad,
    precio_venta
FROM producto_variantes
WHERE activa = TRUE
ORDER BY precio_venta DESC
LIMIT 5;
-- 110. Contar cuántas devoluciones hay por estado.
SELECT estado_devolucion,
    COUNT(*) AS total
FROM devoluciones_clientes
GROUP BY estado_devolucion;
-- 111. Mostrar los clientes con 0 puntos de fidelidad.
SELECT nombre,
    apellido1,
    email,
    puntos_fidelidad
FROM clientes
WHERE puntos_fidelidad = 0;
-- 112. Mostrar el total comprado a proveedores en enero de 2026.
SELECT SUM(total) AS total_enero
FROM compras_proveedor
WHERE MONTH(fecha_compra) = 1
    AND YEAR(fecha_compra) = 2026;
-- 113. Mostrar los productos de las categorías 'Smartphones' y 'Tablets'.
SELECT p.nombre,
    p.modelo,
    c.nombre AS categoria
FROM productos p
    JOIN categorias c ON p.id_categoria = c.id_categoria
WHERE c.nombre IN ('Smartphones', 'Tablets');
-- 114. Mostrar las ventas donde se vendieron más de 1 unidad de algún artículo.
SELECT DISTINCT v.id_venta,
    v.fecha_venta,
    v.total
FROM ventas v
    JOIN ventas_detalle vd ON v.id_venta = vd.id_venta
WHERE vd.cantidad > 1;
-- 115. Mostrar el stock total disponible por producto sumando todos los almacenes,
--      ordenado de mayor a menor.
SELECT p.nombre,
    SUM(inv.stock_disponible) AS stock_total
FROM productos p
    JOIN producto_variantes pv ON p.id_producto = pv.id_producto
    JOIN inventario inv ON pv.id_variante = inv.id_variante
GROUP BY p.id_producto,
    p.nombre
ORDER BY stock_total DESC;
-- 116. Mostrar los empleados sin jefe asignado (los gerentes).
SELECT nombre,
    apellido1,
    id_tienda
FROM empleados
WHERE id_jefe IS NULL;
-- 117. Mostrar cuántos reembolsos se han realizado por cada método y el total reembolsado.
SELECT metodo_reembolso,
    COUNT(*) AS num_reembolsos,
    SUM(importe) AS total
FROM reembolsos
GROUP BY metodo_reembolso;
-- 118. Mostrar las devoluciones con estado 'reembolsada' junto con el importe del reembolso.
SELECT dc.id_devolucion,
    dc.fecha_devolucion,
    dc.importe_total,
    r.importe AS importe_reembolsado,
    r.metodo_reembolso
FROM devoluciones_clientes dc
    JOIN reembolsos r ON dc.id_devolucion = r.id_devolucion
WHERE dc.estado_devolucion = 'reembolsada';
-- 119. Mostrar todos los productos que pesan más de 10 kg, ordenados por peso descendente.
SELECT nombre,
    modelo,
    peso
FROM productos
WHERE peso > 10
ORDER BY peso DESC;
-- 120. Mostrar el número de variantes por color, ordenado de mayor a menor.
SELECT color,
    COUNT(*) AS num_variantes
FROM producto_variantes
WHERE color IS NOT NULL
GROUP BY color
ORDER BY num_variantes DESC;
-- 121. Mostrar los empleados contratados en el año 2021.
SELECT nombre,
    apellido1,
    fecha_contratacion,
    id_tienda
FROM empleados
WHERE YEAR(fecha_contratacion) = 2021;
-- 122. Mostrar los clientes registrados en 2024 ordenados por puntos de fidelidad descendente.
SELECT nombre,
    apellido1,
    puntos_fidelidad,
    fecha_registro
FROM clientes
WHERE YEAR(fecha_registro) = 2024
ORDER BY puntos_fidelidad DESC;
-- 123. Mostrar las compras cuyo total supere los 10000 euros, ordenadas por total descendente.
SELECT id_compra,
    id_proveedor,
    fecha_compra,
    total
FROM compras_proveedor
WHERE total > 10000
ORDER BY total DESC;
-- 124. Mostrar las tiendas junto con el número de empleados que tienen.
SELECT t.nombre AS tienda,
    COUNT(e.id_empleado) AS num_empleados
FROM tiendas t
    LEFT JOIN empleados e ON t.id_tienda = e.id_tienda
GROUP BY t.id_tienda,
    t.nombre;
-- 125. Mostrar los productos que no tienen ningún movimiento de inventario registrado.
SELECT p.nombre,
    p.modelo
FROM productos p
    JOIN producto_variantes pv ON p.id_producto = pv.id_producto
WHERE pv.id_variante NOT IN (
        SELECT DISTINCT id_variante
        FROM movimientos_inventario
    );
-- 126. Mostrar el margen medio por categoría de producto.
SELECT c.nombre AS categoria,
    AVG(pv.precio_venta - pv.precio_coste) AS margen_medio
FROM categorias c
    JOIN productos p ON c.id_categoria = p.id_categoria
    JOIN producto_variantes pv ON p.id_producto = pv.id_producto
GROUP BY c.id_categoria,
    c.nombre;
-- 127. Mostrar todos los pagos realizados con Bizum o PayPal.
SELECT p.id_pago,
    p.id_venta,
    mp.nombre AS metodo,
    p.importe
FROM pagos p
    JOIN metodos_pago mp ON p.id_metodo_pago = mp.id_metodo_pago
WHERE mp.nombre IN ('Bizum', 'PayPal');
-- 128. Mostrar los empleados cuyo salario esté por debajo del salario mínimo de los gerentes.
SELECT nombre,
    apellido1,
    salario
FROM empleados
WHERE salario < (
        SELECT MIN(salario)
        FROM empleados
        WHERE id_cargo = (
                SELECT id_cargo
                FROM cargos
                WHERE nombre = 'Gerente de tienda'
            )
    );
-- 129. Mostrar las ventas realizadas en fin de semana (sábado o domingo).
--      (En MySQL: 1 = Domingo, 7 = Sábado)
SELECT id_venta,
    fecha_venta,
    total
FROM ventas
WHERE DAYOFWEEK(fecha_venta) IN (1, 7);
-- 130. Mostrar el detalle de cada venta con el nombre del producto, la cantidad vendida
--      y si ese producto tiene alguna devolución asociada en esa venta.
SELECT vd.id_venta,
    p.nombre AS producto,
    vd.cantidad,
    CASE
        WHEN dcd.id_devolucion_detalle IS NOT NULL THEN 'Sí'
        ELSE 'No'
    END AS tiene_devolucion
FROM ventas_detalle vd
    JOIN producto_variantes pv ON vd.id_variante = pv.id_variante
    JOIN productos p ON pv.id_producto = p.id_producto
    LEFT JOIN devoluciones_clientes_detalle dcd ON vd.id_venta_detalle = dcd.id_venta_detalle
ORDER BY vd.id_venta;