# Premisa Actividad 18: Interfaces - Super

Para unificar el código y permitir una mayor flexibilidad en la gestión de productos en un supermercado, se requiere la implementación de interfaces que describan las características comunes de los productos. Se pide lo siguiente:

- Interfaz ProductoSupermercado.
  - Define los métodos básicos que deben tener todos los productos en el supermercado.
  - getMarca, getPrecio y aplicarDescuento que aplicará un descuento dado.
- Interfaz Esliquido.
  - Define los métodos que deben tener los productos líquidos.
  - getVolumen y getTipoEnvase
- Interfaz EsAlimento.
  - Define los métodos que deben tener los productos que son alimentos perecederos.
  - getCaducidad y  esCaducado.

Realiza estas tres interfaces y luego crea las siguientes clases decidiendo que interfaces debe implementar cada una:

- Clase Cereal
- Clase Lejia
- Clase Leche

> **NOTAS**:

- Todas las clases deberán tener un método toString().
- Investiga la clase LocalDate para definir la caducidad.
