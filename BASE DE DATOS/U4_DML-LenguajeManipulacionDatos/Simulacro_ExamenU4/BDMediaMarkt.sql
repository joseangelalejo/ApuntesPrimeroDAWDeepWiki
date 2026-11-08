DROP DATABASE IF EXISTS mediamark_db;
CREATE DATABASE mediamark_db;
USE mediamark_db;

CREATE TABLE paises (
    id_pais INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    codigo_iso CHAR(2) NOT NULL,
    UNIQUE (nombre),
    UNIQUE (codigo_iso)
);

CREATE TABLE provincias (
    id_provincia INT AUTO_INCREMENT PRIMARY KEY,
    id_pais INT NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    codigo_provincia VARCHAR(10),
    UNIQUE (id_pais, nombre),
    FOREIGN KEY (id_pais) REFERENCES paises(id_pais)
);

CREATE TABLE ciudades (
    id_ciudad INT AUTO_INCREMENT PRIMARY KEY,
    id_provincia INT NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    UNIQUE (id_provincia, nombre),
    FOREIGN KEY (id_provincia) REFERENCES provincias(id_provincia)
);

CREATE TABLE direcciones (
    id_direccion INT AUTO_INCREMENT PRIMARY KEY,
    calle VARCHAR(150) NOT NULL,
    numero VARCHAR(20),
    piso VARCHAR(20),
    puerta VARCHAR(20),
    codigo_postal VARCHAR(12) NOT NULL,
    id_ciudad INT NOT NULL,
    referencia VARCHAR(255),
    FOREIGN KEY (id_ciudad) REFERENCES ciudades(id_ciudad)
);

CREATE TABLE tiendas (
    id_tienda INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(120) NOT NULL,
    codigo_tienda VARCHAR(30) NOT NULL,
    telefono VARCHAR(20),
    email VARCHAR(120),
    id_direccion INT NOT NULL,
    fecha_apertura DATE NOT NULL,
    activa BOOLEAN NOT NULL DEFAULT TRUE,
    UNIQUE (codigo_tienda),
    UNIQUE (email),
    FOREIGN KEY (id_direccion) REFERENCES direcciones(id_direccion)
);

CREATE TABLE departamentos (
    id_departamento INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion VARCHAR(255),
    UNIQUE (nombre)
);

CREATE TABLE cargos (
    id_cargo INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion VARCHAR(255),
    UNIQUE (nombre)
);

CREATE TABLE empleados (
    id_empleado INT AUTO_INCREMENT PRIMARY KEY,
    id_tienda INT NOT NULL,
    id_departamento INT NOT NULL,
    id_cargo INT NOT NULL,
    id_jefe INT NULL,
    nombre VARCHAR(100) NOT NULL,
    apellido1 VARCHAR(100) NOT NULL,
    apellido2 VARCHAR(100),
    dni VARCHAR(20) NOT NULL,
    telefono VARCHAR(20),
    email VARCHAR(120) NOT NULL,
    fecha_nacimiento DATE,
    fecha_contratacion DATE NOT NULL,
    fecha_baja DATE,
    salario DECIMAL(10,2) NOT NULL,
    estado_empleado VARCHAR(30) NOT NULL,
    UNIQUE (dni),
    UNIQUE (email),
    FOREIGN KEY (id_tienda) REFERENCES tiendas(id_tienda),
    FOREIGN KEY (id_departamento) REFERENCES departamentos(id_departamento),
    FOREIGN KEY (id_cargo) REFERENCES cargos(id_cargo),
    FOREIGN KEY (id_jefe) REFERENCES empleados(id_empleado),
    CHECK (salario >= 0)
);

CREATE TABLE clientes (
    id_cliente INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellido1 VARCHAR(100) NOT NULL,
    apellido2 VARCHAR(100),
    dni_nif VARCHAR(20),
    telefono VARCHAR(20),
    email VARCHAR(120),
    fecha_nacimiento DATE,
    fecha_registro DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    acepta_marketing BOOLEAN NOT NULL DEFAULT FALSE,
    puntos_fidelidad INT NOT NULL DEFAULT 0,
    estado_cliente VARCHAR(30) NOT NULL,
    UNIQUE (dni_nif),
    UNIQUE (email),
    CHECK (puntos_fidelidad >= 0)
);

CREATE TABLE clientes_direcciones (
    id_cliente_direccion INT AUTO_INCREMENT PRIMARY KEY,
    id_cliente INT NOT NULL,
    id_direccion INT NOT NULL,
    tipo_direccion VARCHAR(30) NOT NULL,
    es_principal BOOLEAN NOT NULL DEFAULT FALSE,
    FOREIGN KEY (id_cliente) REFERENCES clientes(id_cliente),
    FOREIGN KEY (id_direccion) REFERENCES direcciones(id_direccion)
);

CREATE TABLE proveedores (
    id_proveedor INT AUTO_INCREMENT PRIMARY KEY,
    nombre_comercial VARCHAR(150) NOT NULL,
    razon_social VARCHAR(150),
    cif VARCHAR(20),
    telefono VARCHAR(20),
    email VARCHAR(120),
    web VARCHAR(150),
    id_direccion INT,
    persona_contacto VARCHAR(120),
    estado_proveedor VARCHAR(30) NOT NULL,
    UNIQUE (cif),
    UNIQUE (email),
    FOREIGN KEY (id_direccion) REFERENCES direcciones(id_direccion)
);

CREATE TABLE marcas (
    id_marca INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    pais_origen VARCHAR(100),
    activa BOOLEAN NOT NULL DEFAULT TRUE,
    UNIQUE (nombre)
);

CREATE TABLE categorias (
    id_categoria INT AUTO_INCREMENT PRIMARY KEY,
    id_categoria_padre INT NULL,
    nombre VARCHAR(100) NOT NULL,
    descripcion VARCHAR(255),
    activa BOOLEAN NOT NULL DEFAULT TRUE,
    UNIQUE (id_categoria_padre, nombre),
    FOREIGN KEY (id_categoria_padre) REFERENCES categorias(id_categoria)
);

CREATE TABLE impuestos (
    id_impuesto INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    porcentaje DECIMAL(5,2) NOT NULL,
    activo BOOLEAN NOT NULL DEFAULT TRUE,
    UNIQUE (nombre),
    CHECK (porcentaje >= 0 AND porcentaje <= 100)
);

CREATE TABLE productos (
    id_producto INT AUTO_INCREMENT PRIMARY KEY,
    id_marca INT NOT NULL,
    id_categoria INT NOT NULL,
    id_impuesto INT NOT NULL,
    nombre VARCHAR(150) NOT NULL,
    descripcion TEXT,
    modelo VARCHAR(100),
    sku_base VARCHAR(50) NOT NULL,
    codigo_barras_base VARCHAR(50),
    garantia_meses INT NOT NULL DEFAULT 24,
    peso DECIMAL(10,3),
    activo BOOLEAN NOT NULL DEFAULT TRUE,
    fecha_alta DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    UNIQUE (sku_base),
    UNIQUE (codigo_barras_base),
    FOREIGN KEY (id_marca) REFERENCES marcas(id_marca),
    FOREIGN KEY (id_categoria) REFERENCES categorias(id_categoria),
    FOREIGN KEY (id_impuesto) REFERENCES impuestos(id_impuesto),
    CHECK (garantia_meses >= 0),
    CHECK (peso IS NULL OR peso >= 0)
);

CREATE TABLE producto_variantes (
    id_variante INT AUTO_INCREMENT PRIMARY KEY,
    id_producto INT NOT NULL,
    sku VARCHAR(50) NOT NULL,
    codigo_barras VARCHAR(50),
    color VARCHAR(50),
    capacidad VARCHAR(50),
    descripcion_variante VARCHAR(255),
    precio_coste DECIMAL(10,2) NOT NULL,
    precio_venta DECIMAL(10,2) NOT NULL,
    stock_minimo INT NOT NULL DEFAULT 0,
    activa BOOLEAN NOT NULL DEFAULT TRUE,
    UNIQUE (sku),
    UNIQUE (codigo_barras),
    FOREIGN KEY (id_producto) REFERENCES productos(id_producto),
    CHECK (precio_coste >= 0),
    CHECK (precio_venta >= 0),
    CHECK (stock_minimo >= 0)
);

CREATE TABLE proveedores_productos (
    id_proveedor_producto INT AUTO_INCREMENT PRIMARY KEY,
    id_proveedor INT NOT NULL,
    id_variante INT NOT NULL,
    codigo_producto_proveedor VARCHAR(50),
    precio_compra_referencia DECIMAL(10,2) NOT NULL,
    plazo_entrega_dias INT NOT NULL,
    proveedor_principal BOOLEAN NOT NULL DEFAULT FALSE,
    UNIQUE (id_proveedor, id_variante),
    FOREIGN KEY (id_proveedor) REFERENCES proveedores(id_proveedor),
    FOREIGN KEY (id_variante) REFERENCES producto_variantes(id_variante),
    CHECK (precio_compra_referencia >= 0),
    CHECK (plazo_entrega_dias >= 0)
);

CREATE TABLE almacenes (
    id_almacen INT AUTO_INCREMENT PRIMARY KEY,
    id_tienda INT NULL,
    nombre VARCHAR(120) NOT NULL,
    tipo_almacen VARCHAR(30) NOT NULL,
    id_direccion INT NOT NULL,
    activo BOOLEAN NOT NULL DEFAULT TRUE,
    FOREIGN KEY (id_tienda) REFERENCES tiendas(id_tienda),
    FOREIGN KEY (id_direccion) REFERENCES direcciones(id_direccion)
);

CREATE TABLE inventario (
    id_inventario INT AUTO_INCREMENT PRIMARY KEY,
    id_almacen INT NOT NULL,
    id_variante INT NOT NULL,
    stock_actual INT NOT NULL DEFAULT 0,
    stock_reservado INT NOT NULL DEFAULT 0,
    stock_disponible INT NOT NULL DEFAULT 0,
    ubicacion VARCHAR(100),
    fecha_ultima_actualizacion DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    UNIQUE (id_almacen, id_variante),
    FOREIGN KEY (id_almacen) REFERENCES almacenes(id_almacen),
    FOREIGN KEY (id_variante) REFERENCES producto_variantes(id_variante),
    CHECK (stock_actual >= 0),
    CHECK (stock_reservado >= 0),
    CHECK (stock_disponible >= 0)
);

CREATE TABLE movimientos_inventario (
    id_movimiento INT AUTO_INCREMENT PRIMARY KEY,
    id_almacen INT NOT NULL,
    id_variante INT NOT NULL,
    tipo_movimiento VARCHAR(30) NOT NULL,
    cantidad INT NOT NULL,
    fecha_movimiento DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    referencia_origen VARCHAR(50),
    id_referencia INT,
    id_empleado INT,
    observaciones VARCHAR(255),
    FOREIGN KEY (id_almacen) REFERENCES almacenes(id_almacen),
    FOREIGN KEY (id_variante) REFERENCES producto_variantes(id_variante),
    FOREIGN KEY (id_empleado) REFERENCES empleados(id_empleado),
    CHECK (cantidad > 0)
);

CREATE TABLE compras_proveedor (
    id_compra INT AUTO_INCREMENT PRIMARY KEY,
    id_proveedor INT NOT NULL,
    id_almacen_destino INT NOT NULL,
    id_empleado INT NOT NULL,
    fecha_compra DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    estado_compra VARCHAR(30) NOT NULL,
    subtotal DECIMAL(12,2) NOT NULL DEFAULT 0,
    impuestos_total DECIMAL(12,2) NOT NULL DEFAULT 0,
    total DECIMAL(12,2) NOT NULL DEFAULT 0,
    observaciones VARCHAR(255),
    FOREIGN KEY (id_proveedor) REFERENCES proveedores(id_proveedor),
    FOREIGN KEY (id_almacen_destino) REFERENCES almacenes(id_almacen),
    FOREIGN KEY (id_empleado) REFERENCES empleados(id_empleado),
    CHECK (subtotal >= 0),
    CHECK (impuestos_total >= 0),
    CHECK (total >= 0)
);

CREATE TABLE compras_proveedor_detalle (
    id_compra_detalle INT AUTO_INCREMENT PRIMARY KEY,
    id_compra INT NOT NULL,
    id_variante INT NOT NULL,
    cantidad INT NOT NULL,
    precio_unitario DECIMAL(10,2) NOT NULL,
    porcentaje_impuesto DECIMAL(5,2) NOT NULL,
    subtotal_linea DECIMAL(12,2) NOT NULL,
    impuesto_linea DECIMAL(12,2) NOT NULL,
    total_linea DECIMAL(12,2) NOT NULL,
    FOREIGN KEY (id_compra) REFERENCES compras_proveedor(id_compra),
    FOREIGN KEY (id_variante) REFERENCES producto_variantes(id_variante),
    CHECK (cantidad > 0),
    CHECK (precio_unitario >= 0),
    CHECK (porcentaje_impuesto >= 0),
    CHECK (subtotal_linea >= 0),
    CHECK (impuesto_linea >= 0),
    CHECK (total_linea >= 0)
);

CREATE TABLE metodos_pago (
    id_metodo_pago INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion VARCHAR(255),
    requiere_autorizacion BOOLEAN NOT NULL DEFAULT FALSE,
    activo BOOLEAN NOT NULL DEFAULT TRUE,
    UNIQUE (nombre)
);

CREATE TABLE ventas (
    id_venta INT AUTO_INCREMENT PRIMARY KEY,
    id_tienda INT NOT NULL,
    id_cliente INT NULL,
    id_empleado INT NOT NULL,
    fecha_venta DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    estado_venta VARCHAR(30) NOT NULL,
    subtotal DECIMAL(12,2) NOT NULL DEFAULT 0,
    descuento_total DECIMAL(12,2) NOT NULL DEFAULT 0,
    impuestos_total DECIMAL(12,2) NOT NULL DEFAULT 0,
    total DECIMAL(12,2) NOT NULL DEFAULT 0,
    observaciones VARCHAR(255),
    FOREIGN KEY (id_tienda) REFERENCES tiendas(id_tienda),
    FOREIGN KEY (id_cliente) REFERENCES clientes(id_cliente),
    FOREIGN KEY (id_empleado) REFERENCES empleados(id_empleado),
    CHECK (subtotal >= 0),
    CHECK (descuento_total >= 0),
    CHECK (impuestos_total >= 0),
    CHECK (total >= 0)
);

CREATE TABLE ventas_detalle (
    id_venta_detalle INT AUTO_INCREMENT PRIMARY KEY,
    id_venta INT NOT NULL,
    id_variante INT NOT NULL,
    cantidad INT NOT NULL,
    precio_unitario DECIMAL(10,2) NOT NULL,
    descuento_unitario DECIMAL(10,2) NOT NULL DEFAULT 0,
    porcentaje_impuesto DECIMAL(5,2) NOT NULL,
    subtotal_linea DECIMAL(12,2) NOT NULL,
    impuesto_linea DECIMAL(12,2) NOT NULL,
    total_linea DECIMAL(12,2) NOT NULL,
    FOREIGN KEY (id_venta) REFERENCES ventas(id_venta),
    FOREIGN KEY (id_variante) REFERENCES producto_variantes(id_variante),
    CHECK (cantidad > 0),
    CHECK (precio_unitario >= 0),
    CHECK (descuento_unitario >= 0),
    CHECK (porcentaje_impuesto >= 0),
    CHECK (subtotal_linea >= 0),
    CHECK (impuesto_linea >= 0),
    CHECK (total_linea >= 0)
);

CREATE TABLE pagos (
    id_pago INT AUTO_INCREMENT PRIMARY KEY,
    id_venta INT NOT NULL,
    id_metodo_pago INT NOT NULL,
    fecha_pago DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    importe DECIMAL(12,2) NOT NULL,
    estado_pago VARCHAR(30) NOT NULL,
    referencia_externa VARCHAR(100),
    autorizado_por INT NULL,
    FOREIGN KEY (id_venta) REFERENCES ventas(id_venta),
    FOREIGN KEY (id_metodo_pago) REFERENCES metodos_pago(id_metodo_pago),
    FOREIGN KEY (autorizado_por) REFERENCES empleados(id_empleado),
    CHECK (importe >= 0)
);

CREATE TABLE motivos_devolucion (
    id_motivo_devolucion INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion VARCHAR(255),
    activo BOOLEAN NOT NULL DEFAULT TRUE,
    UNIQUE (nombre)
);

CREATE TABLE devoluciones_clientes (
    id_devolucion INT AUTO_INCREMENT PRIMARY KEY,
    id_venta INT NOT NULL,
    id_cliente INT NULL,
    fecha_devolucion DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    estado_devolucion VARCHAR(30) NOT NULL,
    importe_total DECIMAL(12,2) NOT NULL DEFAULT 0,
    id_empleado_gestiona INT NULL,
    observaciones VARCHAR(255),
    FOREIGN KEY (id_venta) REFERENCES ventas(id_venta),
    FOREIGN KEY (id_cliente) REFERENCES clientes(id_cliente),
    FOREIGN KEY (id_empleado_gestiona) REFERENCES empleados(id_empleado),
    CHECK (importe_total >= 0)
);

CREATE TABLE devoluciones_clientes_detalle (
    id_devolucion_detalle INT AUTO_INCREMENT PRIMARY KEY,
    id_devolucion INT NOT NULL,
    id_venta_detalle INT NOT NULL,
    id_motivo_devolucion INT NOT NULL,
    cantidad INT NOT NULL,
    importe_unitario DECIMAL(10,2) NOT NULL,
    total_linea DECIMAL(12,2) NOT NULL,
    estado_producto_devuelto VARCHAR(30) NOT NULL,
    FOREIGN KEY (id_devolucion) REFERENCES devoluciones_clientes(id_devolucion),
    FOREIGN KEY (id_venta_detalle) REFERENCES ventas_detalle(id_venta_detalle),
    FOREIGN KEY (id_motivo_devolucion) REFERENCES motivos_devolucion(id_motivo_devolucion),
    CHECK (cantidad > 0),
    CHECK (importe_unitario >= 0),
    CHECK (total_linea >= 0)
);

CREATE TABLE reembolsos (
    id_reembolso INT AUTO_INCREMENT PRIMARY KEY,
    id_devolucion INT NOT NULL,
    id_pago INT NULL,
    fecha_reembolso DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    importe DECIMAL(12,2) NOT NULL,
    metodo_reembolso VARCHAR(50) NOT NULL,
    estado_reembolso VARCHAR(30) NOT NULL,
    observaciones VARCHAR(255),
    FOREIGN KEY (id_devolucion) REFERENCES devoluciones_clientes(id_devolucion),
    FOREIGN KEY (id_pago) REFERENCES pagos(id_pago),
    CHECK (importe >= 0)
);