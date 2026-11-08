# Act 3 - Colleción Lista Banco

Crea un programa para un banco que permita manejar cuentas del mismo. Tendrá que tener una lista con los clientes. Para ello tendrás que:

- Crear una clase Cuenta que defina los atributos:  nº de cuenta  y saldo. Define los métodos necesarios (set/get) para variar estos atributos.
- Crear una clase Cliente que defina los atributos:  nombre y apellidos, codigo de cliente  y lista con cuentas . Define los métodos necesarios (set/get) para variar estos atributos.
- Haz un main donde inicialmente se muestre un menú al usuario donde tenga que logarse con su nombre y código. Si el cliente no existe le dará la opción de crear uno nuevo. Una vez logado al usuario le saldrá un menú donde pueda elegir entre las siguientes opciones:

1- Añadir cuenta
2- Borrar cuenta
3- Imprimir saldo por pantalla
4- Meter/sacar dinero de una cuenta
5- Salir del programa

- En el caso de opción Añadir se le creará una cuenta nueva al cliente con saldo 0 y un número de cuenta automático que no exista ya.
- En el caso de opción Borrar preguntar la cuenta que quiere borrar en caso de tener varias. En caso de no existir avisar.
- En el caso de Saldo, proceder igual que en borrar cuenta pero en vez de eso imprimiendo por pantalla el saldo de la cuenta dada por el usuario.
- En el caso de meter sacar dinero se podrá variar el saldo de una cuenta dada.
