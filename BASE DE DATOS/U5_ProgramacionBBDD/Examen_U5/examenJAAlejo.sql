USE Tienda_Moda;
/**	Función 1 - "Calcular_Descuento_Cantidad" para calcular porcentaje de descuento aplciado según la cantidad de unidades compradas de un . Para ello:
	La función recibe como parámetro cantidad de unidades compradas (entero) y devuelve número entero que represente porcentaje de descuento obtenido.alter
    El descuento se calcula teninedo en cuenta cantidad de productos comprados. Por cada 2 unidades compradas, se aplica un 1% de descuento (%2=0)
    
*/

-- PENDIENTE


/**	Procedimiento "Cambiar_Estado_Pedido" con finalidad modificar estado de pedido. Para ello:
	El procedimiento recibirá como parámetros el código del pedido y el nuevo estado que se quiere asignar.
    Deberá actualizarse el estado del pedido recibido por parámetros.
    Tras la actualización se debe comprobar:
		- Si se han actualizado 0 línaeas (ROW_COUNT() = 0) mostrar el mensaje "No existe ese pedido".
        - Si no es así, se muestra el mensaje "Estado del pedido actualizado correctamente"
*/

-- PENDIENTE / EZ

/**	Procedimiento "Pasar_Carrito_A_Pedido" finalidad sea pasar productos de un carrito a un pedido ya existente. Para ello:
	El procedimiento recibe como parámetros el código del carrito, el código del pedido.
    El cursor debe recorrer la tabla "Detalles_Carrito" para obtener el producto y la cantidad del carrito dado por parámetro.
    Por cada lectura del cursor se necesita el precio del producto obtenido en dicha lectura de la tabla dde "Productos", calcular descuento usando la función "Calcular_Descuento_Cantidad",
    calcular el subtotal ( Subtotal = Precio * Cantidad * (1-Descuento/100)) e sinsertar en la tabla detalles_pedido los datos de las siguientes columnas de dicha tabla "Pedido", "Producto", "Cantidad", "Precio_unitario", "Porcentaje_descuento" y "Subtotal".alter
*/

-- PENDIENTE

/** Crear Trigger "TRG_Actualizar_Estado_Producto" con finalidad actualizar automáticamente el estado de un producto cuando cambie su stock. Para ello:
	- El trigger se ejecuta antes de actualizar un producto en la tabla "Productos".
    - Deberá comprobar si el stock del producto ha cambiado con la actualización que activó el trigger.alter
    - Si el estado del producto es distinto a "DESCATALOGADO" comprobar el stock que recibirá tras actualizar, si este es 0 el estado será "AGOTADO", si no será "DISPONIBLE".alter
*/

-- PENDIENTE / EZ - No dependiente

/** Evento "Evento_Ocultar_Productos_Agotados" con finalidad ocultar automáticamente los productos que estén agotados. Para ello:
	- El evento se ejecuta una vez al día. Nota personal no pedida: Hacer que sea a las 3:00 AM hora local para evitar problemas con clientela.
    - Actualizar la tabla de "Productos" para modificar el estado de aquellos productos que si stock es "0" y su estado es "AGOTADO", para que su estado pase a ser "OCULTO".
*/

-- NO DEPENDIENTE