# Premisa - Sistema de Gestión MegaStore

## Objetivo

Implementar un sistema de control de acceso basado en roles (RBAC) para una tienda multicanal (online y física) que gestiona catálogo, precios, ventas y logística.

## Usuarios a crear

- **cat_mgr** - Gestión de catálogo
- **web_sales** - Ventas web
- **store_cashier** - Caja en tienda
- **warehouse_op** - Operario almacén
- **logistics_op** - Logística envíos

## Roles a crear

- **rol_catalogo** - Gestión de productos, categorías y marcas
- **rol_precios** - Gestión de precios
- **rol_ventas_web** - Procesamiento de ventas online
- **rol_caja_tienda** - Gestión de ventas en tienda
- **rol_almacen** - Control de stock y almacenes
- **rol_logistica** - Gestión de envíos y transportistas

## Permisos por rol

### Rol Catálogo (rol_catalogo)

- SELECT, INSERT, UPDATE en: `productos`
- SELECT, INSERT, UPDATE en: `categorias`
- SELECT, INSERT, UPDATE en: `marcas`
- SELECT en `precios` (solo lectura, para consultar)

### Rol Precios (rol_precios)

- SELECT en `productos`
- SELECT, INSERT, UPDATE en `precios`

### Rol Ventas Web (rol_ventas_web)

- SELECT en `productos`, `precios`, `clientes`, `direcciones_cliente`
- INSERT en `pedidos`
- INSERT en `lineas_pedido`
- INSERT en `pagos`

### Rol Caja Tienda (rol_caja_tienda)

- SELECT en `productos`, `precios`, `clientes`
- INSERT en `pedidos`, `lineas_pedido`, `pagos`

### Rol Almacén (rol_almacen)

- SELECT en `productos`
- SELECT, INSERT, UPDATE en `stock_almacen`
- SELECT en `almacenes`

### Rol Logística (rol_logistica)

- SELECT en `pedidos`, `clientes`, `direcciones_cliente`
- SELECT en `transportistas`
- SELECT, INSERT, UPDATE en `envios`

## Asignaciones de roles a usuarios

- **cat_mgr** → `rol_catalogo` y `rol_precios` (responsable de catálogo y pricing)
- **web_sales** → `rol_ventas_web`
- **store_cashier** → `rol_caja_tienda`
- **warehouse_op** → `rol_almacen`
- **logistics_op** → `rol_logistica`

## Requisitos finales

- Activar los roles por defecto
- Todos los usuarios deben tener contraseña
- Los permisos deben ser granulares y específicos por tabla
