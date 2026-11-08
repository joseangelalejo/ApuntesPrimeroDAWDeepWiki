DROP DATABASE IF EXISTS megastore;
CREATE DATABASE megastore;

USE megastore;

CREATE TABLE marcas (
  id_marca INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(80) NOT NULL UNIQUE
);

CREATE TABLE categorias (
  id_categoria INT AUTO_INCREMENT PRIMARY KEY,
  nombre  VARCHAR(80) NOT NULL,
  id_padre  INT NULL,
  CONSTRAINT fk_categoria_padre
 FOREIGN KEY (id_padre) REFERENCES categorias(id_categoria)
 ON DELETE SET NULL
);

CREATE TABLE productos (
  id_producto BIGINT AUTO_INCREMENT PRIMARY KEY,
  sku VARCHAR(30) NOT NULL UNIQUE,
  nombre VARCHAR(150) NOT NULL,
  descripcion TEXT,
  id_marca INT NOT NULL,
  id_categoria  INT NOT NULL,
  activo Boolean NOT NULL DEFAULT(1),
  creado_en  DATETIME NOT NULL DEFAULT(current_timestamp()),
  actualizado_en DATETIME,
  CONSTRAINT fk_producto_marca
 FOREIGN KEY (id_marca) REFERENCES marcas(id_marca),
  CONSTRAINT fk_producto_categoria
 FOREIGN KEY (id_categoria) REFERENCES categorias(id_categoria)
);

CREATE TABLE precios (
  id_precio BIGINT AUTO_INCREMENT PRIMARY KEY,
  id_producto BIGINT NOT NULL,
  fecha_inicio DATETIME NOT NULL,
  fecha_fin DATETIME,
  precio DECIMAL(10,2) NOT NULL,
  moneda CHAR(3) NOT NULL DEFAULT('EUR'),
  CONSTRAINT fk_precio_producto
 FOREIGN KEY (id_producto) REFERENCES productos(id_producto)
 ON DELETE CASCADE
);

CREATE TABLE tiendas (
  id_tienda INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(120) NOT NULL,
  ciudad VARCHAR(80) NOT NULL,
  provincia VARCHAR(80) NOT NULL,
  direccion VARCHAR(180) NOT NULL,
  telefono  VARCHAR(20),
  email  VARCHAR(120),
  activo Boolean NOT NULL DEFAULT(True)
);

CREATE TABLE almacenes (
  id_almacen INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(120) NOT NULL,
  ciudad VARCHAR(80) NOT NULL,
  provincia VARCHAR(80) NOT NULL,
  direccion VARCHAR(180) NOT NULL,
  activo Boolean NOT NULL DEFAULT(true)
);

CREATE TABLE stock_tienda (
  id_tienda INT NOT NULL,
  id_producto BIGINT NOT NULL,
  unidades INT NOT NULL DEFAULT(0),
  minimo INT NOT NULL DEFAULT(0),
  actualizado_en DATETIME NOT NULL DEFAULT(current_timestamp()),
  PRIMARY KEY (id_tienda, id_producto),
  CONSTRAINT fk_stock_tienda_tienda
 FOREIGN KEY (id_tienda) REFERENCES tiendas(id_tienda)
 ON DELETE CASCADE,
  CONSTRAINT fk_stock_tienda_producto
 FOREIGN KEY (id_producto) REFERENCES productos(id_producto)
 ON DELETE CASCADE
);

CREATE TABLE stock_almacen (
  id_almacen  INT NOT NULL,
  id_producto BIGINT NOT NULL,
  unidades INT NOT NULL DEFAULT(0),
  minimo INT NOT NULL DEFAULT(0),
  actualizado_en DATETIME NOT NULL DEFAULT(current_timestamp()),
  PRIMARY KEY (id_almacen, id_producto),
  CONSTRAINT fk_stock_almacen_almacen
 FOREIGN KEY (id_almacen) REFERENCES almacenes(id_almacen)
 ON DELETE CASCADE,
  CONSTRAINT fk_stock_almacen_producto
 FOREIGN KEY (id_producto) REFERENCES productos(id_producto)
 ON DELETE CASCADE
);


CREATE TABLE clientes (
  id_cliente BIGINT AUTO_INCREMENT PRIMARY KEY,
  email VARCHAR(150) NOT NULL UNIQUE,
  nombre  VARCHAR(80) NOT NULL,
  apellidos  VARCHAR(120) NOT NULL,
  telefono VARCHAR(20),
  nif VARCHAR(15) ,
  creado_en  DATETIME NOT NULL DEFAULT(current_timestamp()),
  activo  Boolean NOT NULL DEFAULT(true)
);

CREATE TABLE direcciones_cliente (
  id_direccion BIGINT AUTO_INCREMENT PRIMARY KEY,
  id_cliente BIGINT NOT NULL,
  etiqueta  VARCHAR(40) NOT NULL DEFAULT('Principal'),
  direccion VARCHAR(180) NOT NULL,
  ciudad  VARCHAR(80) NOT NULL,
  provincia VARCHAR(80) NOT NULL,
  cp VARCHAR(10) NOT NULL,
  pais VARCHAR(60) NOT NULL DEFAULT('España'),
  es_principal Boolean NOT NULL DEFAULT(0),
  CONSTRAINT fk_dir_cliente
 FOREIGN KEY (id_cliente) REFERENCES clientes(id_cliente)
 ON DELETE CASCADE,
  INDEX idx_dir_cliente (id_cliente, es_principal)
);

CREATE TABLE pedidos (
  id_pedido  BIGINT AUTO_INCREMENT PRIMARY KEY,
  id_cliente BIGINT NOT NULL,
  canal ENUM('WEB','TIENDA') NOT NULL,
  id_tienda  INT NULL, 
  estado ENUM('CREADO','PAGADO','PREPARACION','ENVIADO','ENTREGADO','CANCELADO') NOT NULL DEFAULT('CREADO'),
  total DECIMAL(12,2) NOT NULL DEFAULT(0),
  creado_en  DATETIME NOT NULL DEFAULT(current_timestamp()),
  actualizado_en DATETIME,
  CONSTRAINT fk_pedido_cliente
 FOREIGN KEY (id_cliente) REFERENCES clientes(id_cliente),
  CONSTRAINT fk_pedido_tienda
 FOREIGN KEY (id_tienda) REFERENCES tiendas(id_tienda)
 ON DELETE SET NULL
);

CREATE TABLE lineas_pedido (
  id_pedido  BIGINT NOT NULL,
  num_linea  INT NOT NULL,
  id_producto BIGINT NOT NULL,
  cantidad INT NOT NULL,
  precio_unit DECIMAL(10,2) NOT NULL,
  iva_porcentaje DECIMAL(5,2) NOT NULL DEFAULT(21.00),
  subtotal DECIMAL(12,2),
  PRIMARY KEY (id_pedido, num_linea),
  CONSTRAINT fk_linea_pedido
 FOREIGN KEY (id_pedido) REFERENCES pedidos(id_pedido)
 ON DELETE CASCADE,
  CONSTRAINT fk_linea_producto
 FOREIGN KEY (id_producto) REFERENCES productos(id_producto)
);

CREATE TABLE pagos (
  id_pago BIGINT AUTO_INCREMENT PRIMARY KEY,
  id_pedido BIGINT NOT NULL,
  metodo ENUM('TARJETA','PAYPAL','TRANSFERENCIA','FINANCIACION','EFECTIVO') NOT NULL,
  estado ENUM('PENDIENTE','ACEPTADO','RECHAZADO','DEVUELTO') NOT NULL DEFAULT('PENDIENTE'),
  importe DECIMAL(12,2) NOT NULL,
  referencia VARCHAR(80),
  creado_en DATETIME NOT NULL DEFAULT(current_timestamp()),
  CONSTRAINT fk_pago_pedido
 FOREIGN KEY (id_pedido) REFERENCES pedidos(id_pedido)
 ON DELETE CASCADE
);

CREATE TABLE devoluciones (
  id_devolucion BIGINT AUTO_INCREMENT PRIMARY KEY,
  id_pedido BIGINT NOT NULL,
  motivo VARCHAR(200) NOT NULL,
  estado ENUM('SOLICITADA','APROBADA','RECHAZADA','REEMBOLSADA') NOT NULL DEFAULT('SOLICITADA'),
  creado_en DATETIME NOT NULL DEFAULT(current_timestamp()),
  CONSTRAINT fk_devolucion_pedido
 FOREIGN KEY (id_pedido) REFERENCES pedidos(id_pedido)
 ON DELETE CASCADE
);


CREATE TABLE transportistas (
  id_transportista INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(120) NOT NULL UNIQUE,
  telefono VARCHAR(20),
  email  VARCHAR(120)
);

CREATE TABLE envios (
  id_envio BIGINT AUTO_INCREMENT PRIMARY KEY,
  id_pedido BIGINT NOT NULL,
  id_transportista INT NOT NULL,
  estado ENUM('PENDIENTE','EN_TRANSITO','ENTREGADO','INCIDENCIA') NOT NULL DEFAULT('PENDIENTE'),
  creado_en DATETIME NOT NULL DEFAULT(current_timestamp()),
  entregado_en DATETIME,
  CONSTRAINT fk_envio_pedido
 FOREIGN KEY (id_pedido) REFERENCES pedidos(id_pedido)
 ON DELETE CASCADE,
  CONSTRAINT fk_envio_transportista
 FOREIGN KEY (id_transportista) REFERENCES transportistas(id_transportista)
);

CREATE TABLE puestos (
  id_puesto INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(80) NOT NULL UNIQUE
);

CREATE TABLE empleados (
  id_empleado BIGINT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(80) NOT NULL,
  apellidos VARCHAR(120) NOT NULL,
  email VARCHAR(150) NOT NULL UNIQUE,
  id_puesto INT NOT NULL,
  id_tienda INT,
  activo Boolean NOT NULL DEFAULT(true),
  creado_en DATETIME NOT NULL DEFAULT(current_timestamp()),
  CONSTRAINT fk_empleado_puesto
 FOREIGN KEY (id_puesto) REFERENCES puestos(id_puesto),
  CONSTRAINT fk_empleado_tienda
 FOREIGN KEY (id_tienda) REFERENCES tiendas(id_tienda)
 ON DELETE SET NULL
);
