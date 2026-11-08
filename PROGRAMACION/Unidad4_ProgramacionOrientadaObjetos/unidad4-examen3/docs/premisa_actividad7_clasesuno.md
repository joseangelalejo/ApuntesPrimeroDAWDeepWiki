# Actividad 7: Clases 1

Crea una clase Cliente para definir los clientes de un negocio. Esta clase tendrá los siguientes atributos que sólo pueden ser modificados en la misma clase:

- nombre (nombre y apellidos)
- telefono
- direccion
- edad
- mail
- cuponactivo (flag que indicará si el cliente tiene un cupón de descuento activado)
- descuento (indicará el % de descuento a aplicar en el cupón si está activo)
- compras (indicará el número de compras que ha hecho el cliente, entre 0 y 4)

Tendrá un constructor donde será necesario introducir todos los atributos a excepción de cuponactivo que será TRUE, descuento que será 10% y compras 0.

Además tiene los siguientes métodos:

- ncompras, se llamará cuando el cliente realice una compra. Este método aumentará la variable compras. Cuando esta llegue a 5 la volverá a poner a 0 y activará un descuento del 5%.
- usacupon, se le pasará el precio de la compra, verá si tiene un cupón activo y le aplicará el descuento, devolviendo el precio final. También pondrá el cuponactivo a false.
- get, todos los atributos tendrá un método get para su consulta.
- set, todos los atributos tendrán un set excepto el cuponactivo, descuento y compras, que no podrán ser modificados.
