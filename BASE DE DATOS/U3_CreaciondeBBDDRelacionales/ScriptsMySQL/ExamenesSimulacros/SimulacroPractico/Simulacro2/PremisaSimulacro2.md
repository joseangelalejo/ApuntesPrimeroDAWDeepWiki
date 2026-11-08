# Examen Tema 3

---

## Creación de la Base de Datos y Tablas

Crea una base de datos de una **franquicia de restaurantes** personalizada con tu nombre y construye los siguientes elementos de la BD.

### Tablas

#### Restaurantes

- **ID**: Identificador de los diferentes registros de la tabla. Almacena números enteros y se incrementa de forma automática.
- **Local**: Cadena de caracteres de tamaño variable. Campo obligatorio y con valores no repetidos.
- **Ubicación**: Almacena la coordenada donde se encuentra el restaurante. No pueden existir dos restaurantes en la misma coordenada, aunque el campo puede quedar vacío.
- **Teléfono**: Número de teléfono con su prefijo correspondiente (ejemplo: +34 955 84 34 94). Puede no existir o repetirse entre restaurantes.

#### Mesas

- **Código**: Identificador de los registros de la tabla. Almacena un conjunto de caracteres.
- **Restaurante**: Identificador del restaurante para vincular las mesas con su establecimiento. Toda mesa debe tener un restaurante. Si el restaurante desaparece, las mesas asociadas también lo harán.
- **Capacidad**: Número entero pequeño comprendido entre **1 y 10**, ambos incluidos. Campo obligatorio.
- **Zona**: Indica a qué zona pertenece la mesa. Valores permitidos: **Terraza**, **Sala** y **Barra**. Por defecto, una mesa estará en **Sala**.

#### Empleado

- **DNI**: Identificador único para cada empleado registrado.
- **Local**: Identificador del restaurante para vincular los empleados con su establecimiento. Todo empleado debe tener un restaurante asignado. Si el restaurante desaparece, el valor pasará a ser **NULL**.

---

## Detalles de Tablas, Índices y Vistas

### Detalle Empleado

- **Nombre**: Nombre de pila del empleado. Campo obligatorio, no identificativo.
- **Puesto**: Puestos posibles: **Camarero**, **Cocinero**, **Encargado**, **Chef** y **Contable**. Un empleado puede tener varios puestos de forma simultánea.
- **Alta**: Día en que el empleado fue dado de alta. Campo obligatorio, con valor por defecto la fecha actual.
- **Sueldo**: Valor decimal con precisión lógica para representar dinero. No admite valores negativos y debe estar comprendido entre **1200** y **4000**.

### Plato

- **ID**: Identificador de los registros de la tabla. Almacena números enteros y se incrementa automáticamente.
- **Precio**: Valor decimal con precisión lógica para dinero. Puede ser nulo si el plato está descatalogado o aún no se ha introducido.
- **Disponible**: Indica si el plato está disponible o no. Campo obligatorio, por defecto no disponible.

### Carta_Restaurante

- **Plato**: Valor que relaciona esta tabla con la tabla **Plato**. Si el plato es eliminado, no tiene sentido mantener el registro.
- **Local**: Valor que relaciona esta tabla con la tabla **Restaurante**. Si el restaurante es eliminado, no tiene sentido mantener el registro.

### Índices y Vistas

- Crea un **índice** que mejore las consultas referentes a las zonas de las mesas.
- Es habitual comprobar el sueldo junto con el puesto de trabajo de los empleados. Crea una **consulta** que mejore estas búsquedas.
- Crea una **vista** visible para los encargados de los restaurantes que muestre únicamente **Nombre**, **Puesto** y **Local** de los empleados que no sean **Encargados**.
- Crea una **vista** que muestre todas las mesas cuya capacidad sea **superior a 5** y que excluya las mesas de **Barra**, mostrando al menos el **Código**.

---

## Modificaciones, Roles y Usuarios

### Modificaciones

- Añade una columna **foto** a la tabla **plato** que permita la imagen del plato en cuestión.
- En la tabla **carta_restaurante** se nos olvidó la clave primaria, agrega una clave primaria compuesta por las dos columnas existentes.
- Cambia el nombre de la columna **Alta** en la tabla **empleado** por **Comienzo** y modifica su tipo y valor por defecto para que registre fecha y hora.
- Agrega una restricción en la tabla **mesa** para que, si la zona es **Barra**, la capacidad sea entre **1 y 3**, mientras que si la zona no es **Barra**, la capacidad sea de **1 a 10**.

### Roles y Usuarios

- Crea un rol llamado **Administrador**.
- Crea un rol llamado **Gerente**.
- Crea un rol llamado **Cliente**.
- Crea **2 usuarios por cada rol** (Usuario_1, Usuario_2, …).
- Asigna **todos los permisos** al rol de **Administrador** sobre **todas las tablas de esta base de datos**.
- Asigna al rol de **Gerente** los permisos para **consultar, insertar, modificar y borrar** sobre las tablas **Plato** y **Mesa**, mientras que **solo podrá consultar** la tabla **Empleado**.
- Asigna al rol de **Cliente** la posibilidad de **consultar** las tablas **Plato**, **Restaurante** y la **vista creada sobre la tabla Mesa**.
- Asigna los roles a los usuarios y **establécelos como rol por defecto**.
