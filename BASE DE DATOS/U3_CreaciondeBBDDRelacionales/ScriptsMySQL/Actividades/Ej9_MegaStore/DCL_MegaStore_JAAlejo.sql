-- ===== MEGASTORE DLC - DATA CONTROL LANGUAGE =====
-- Autor: José Ángel Alejo Sillero
-- Descripción: Control de acceso basado en roles (RBAC) para MegaStore

USE megastore;

-- ===== CREACIÓN DE USUARIOS =====
/* Usuarios del sistema MegaStore
   Cada usuario tiene una función específica en la organización
   Se asignan roles para gestionar permisos granulares
*/

CREATE USER IF NOT EXISTS 'cat_mgr'@'localhost' IDENTIFIED BY 'cat_mgr_password_2024';
CREATE USER IF NOT EXISTS 'web_sales'@'localhost' IDENTIFIED BY 'web_sales_password_2024';
CREATE USER IF NOT EXISTS 'store_cashier'@'localhost' IDENTIFIED BY 'store_cashier_password_2024';
CREATE USER IF NOT EXISTS 'warehouse_op'@'localhost' IDENTIFIED BY 'warehouse_op_password_2024';
CREATE USER IF NOT EXISTS 'logistics_op'@'localhost' IDENTIFIED BY 'logistics_op_password_2024';

-- ===== CREACIÓN DE ROLES =====
/* Roles del sistema basados en funciones operacionales
   Cada rol agrupa permisos específicos para un área de negocio
*/

CREATE ROLE IF NOT EXISTS 'rol_catalogo';
CREATE ROLE IF NOT EXISTS 'rol_precios';
CREATE ROLE IF NOT EXISTS 'rol_ventas_web';
CREATE ROLE IF NOT EXISTS 'rol_caja_tienda';
CREATE ROLE IF NOT EXISTS 'rol_almacen';
CREATE ROLE IF NOT EXISTS 'rol_logistica';

-- ===== ROL CATÁLOGO (rol_catalogo) =====
/* Permisos para gestión de productos, categorías y marcas
   Puede consultar precios pero no modificarlos
*/

GRANT SELECT, INSERT, UPDATE ON megastore.productos TO 'rol_catalogo';
GRANT SELECT, INSERT, UPDATE ON megastore.categorias TO 'rol_catalogo';
GRANT SELECT, INSERT, UPDATE ON megastore.marcas TO 'rol_catalogo';
GRANT SELECT ON megastore.precios TO 'rol_catalogo';

-- ===== ROL PRECIOS (rol_precios) =====
/* Permisos para gestión de políticas de precios
   Acceso solo lectura a productos, modificación de precios
*/

GRANT SELECT ON megastore.productos TO 'rol_precios';
GRANT SELECT, INSERT, UPDATE ON megastore.precios TO 'rol_precios';

-- ===== ROL VENTAS WEB (rol_ventas_web) =====
/* Permisos para procesamiento de ventas online
   Consulta catálogo, datos de clientes y procesamiento de pedidos
*/

GRANT SELECT ON megastore.productos TO 'rol_ventas_web';
GRANT SELECT ON megastore.precios TO 'rol_ventas_web';
GRANT SELECT ON megastore.clientes TO 'rol_ventas_web';
GRANT SELECT ON megastore.direcciones_cliente TO 'rol_ventas_web';
GRANT INSERT ON megastore.pedidos TO 'rol_ventas_web';
GRANT INSERT ON megastore.lineas_pedido TO 'rol_ventas_web';
GRANT INSERT ON megastore.pagos TO 'rol_ventas_web';

-- ===== ROL CAJA TIENDA (rol_caja_tienda) =====
/* Permisos para caja de tienda física
   Consulta productos y clientes, genera pedidos y pagos en tienda
*/

GRANT SELECT ON megastore.productos TO 'rol_caja_tienda';
GRANT SELECT ON megastore.precios TO 'rol_caja_tienda';
GRANT SELECT ON megastore.clientes TO 'rol_caja_tienda';
GRANT INSERT ON megastore.pedidos TO 'rol_caja_tienda';
GRANT INSERT ON megastore.lineas_pedido TO 'rol_caja_tienda';
GRANT INSERT ON megastore.pagos TO 'rol_caja_tienda';

-- ===== ROL ALMACÉN (rol_almacen) =====
/* Permisos para gestión de stock y almacenes
   Control de inventario y actualización de existencias
*/

GRANT SELECT ON megastore.productos TO 'rol_almacen';
GRANT SELECT, INSERT, UPDATE ON megastore.stock_almacen TO 'rol_almacen';
GRANT SELECT ON megastore.almacenes TO 'rol_almacen';

-- ===== ROL LOGÍSTICA (rol_logistica) =====
/* Permisos para gestión de envíos y logística
   Consulta pedidos y datos de clientes, gestiona envíos
*/

GRANT SELECT ON megastore.pedidos TO 'rol_logistica';
GRANT SELECT ON megastore.clientes TO 'rol_logistica';
GRANT SELECT ON megastore.direcciones_cliente TO 'rol_logistica';
GRANT SELECT ON megastore.transportistas TO 'rol_logistica';
GRANT SELECT, INSERT, UPDATE ON megastore.envios TO 'rol_logistica';

-- ===== ASIGNACIÓN DE ROLES A USUARIOS =====
/* Vinculación entre usuarios y roles
   Cada usuario recibe uno o más roles según su función
*/

GRANT 'rol_catalogo' TO 'cat_mgr'@'localhost';
GRANT 'rol_precios' TO 'cat_mgr'@'localhost';

GRANT 'rol_ventas_web' TO 'web_sales'@'localhost';

GRANT 'rol_caja_tienda' TO 'store_cashier'@'localhost';

GRANT 'rol_almacen' TO 'warehouse_op'@'localhost';

GRANT 'rol_logistica' TO 'logistics_op'@'localhost';

-- ===== ACTIVACIÓN DE ROLES POR DEFECTO =====
/* Los roles se activan automáticamente al conectarse
   Se pueden cambiar dinámicamente con SET ROLE
*/

ALTER USER 'cat_mgr'@'localhost' DEFAULT ROLE 'rol_catalogo', 'rol_precios';
ALTER USER 'web_sales'@'localhost' DEFAULT ROLE 'rol_ventas_web';
ALTER USER 'store_cashier'@'localhost' DEFAULT ROLE 'rol_caja_tienda';
ALTER USER 'warehouse_op'@'localhost' DEFAULT ROLE 'rol_almacen';
ALTER USER 'logistics_op'@'localhost' DEFAULT ROLE 'rol_logistica';

-- ===== APLICAR CAMBIOS =====

FLUSH PRIVILEGES;

-- ===== VERIFICACIÓN (COMENTADA) =====
/*
-- Verificar usuarios creados:
SELECT USER FROM mysql.user WHERE USER IN ('cat_mgr', 'web_sales', 'store_cashier', 'warehouse_op', 'logistics_op');

-- Verificar roles asignados:
SELECT * FROM mysql.role_edges WHERE TO_USER IN ('cat_mgr', 'web_sales', 'store_cashier', 'warehouse_op', 'logistics_op');

-- Verificar permisos de un usuario:
SHOW GRANTS FOR 'cat_mgr'@'localhost' USING 'rol_catalogo';
*/
