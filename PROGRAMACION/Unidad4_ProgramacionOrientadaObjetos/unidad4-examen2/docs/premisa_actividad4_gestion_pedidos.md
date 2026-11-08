# Premisa de la Actividad: Gestión de Pedidos

El proyecto debe contener dos paquetes llamados tienda y calculos, y tres clases: DatosPedido, que pertenecerá al paquete tienda; CalculosPedido, que pertenecerá al paquete calculos; y ProgramaPrincipal, que también pertenecerá al paquete tienda.

La clase DatosPedido contendrá métodos estáticos que devuelvan información relacionada con un pedido y no mostrarán nada por pantalla. Deberá incluir los siguientes métodos:

- importeBruto(double precioUnitario, int cantidad), que devuelve el importe total sin descuentos.
- pedidoValido(int cantidad), que devuelve true si la cantidad solicitada es mayor que cero y menor o igual que cien.
- tipoPedido(int cantidad), que devuelve un String con uno de los siguientes valores: "PEQUEÑO", "MEDIANO" si la cantidad está entre diez y cincuenta, o "GRANDE" si la cantidad es mayor de cincuenta.

La clase CalculosPedido contendrá métodos estáticos con lógica de cálculo. Deberá incluir los siguientes métodos:

- esPedidoGrande(int cantidad), que devuelve true si la cantidad es mayor de cincuenta.
- calcularDescuento(double importeBruto, int cantidad), que devuelve el importe del descuento aplicado y que debe utilizar internamente el método esPedidoGrande para decidir si se aplica un descuento del diez por ciento o ningún descuento.
- importeFinal(double importeBruto, double descuento), que devuelve el importe final del pedido tras aplicar el descuento.

La clase ProgramaPrincipal contendrá el método main y será la única clase que muestre información por pantalla. Desde el método main se definirán valores fijos para el precio unitario y la cantidad de productos, se llamará a los métodos de las clases DatosPedido y CalculosPedido utilizando el nombre de la clase, y se mostrará por pantalla el importe bruto, el tipo de pedido, si el pedido es válido o no, el descuento aplicado y el importe final del pedido.
