# Bases de datos: Apuntes sobre Modelo E-R Amplicado: Generalización y Especialización

## Generalización

La generalización es un proceso mediante el cual se identifican atributos y relaciones comunes entre varias entidades y se agrupan en una entidad más general. Este proceso ayuda a reducir la redundancia y a simplificar el modelo de datos.

## Especialización

La especialización es el proceso inverso a la generalización. Consiste en dividir una entidad general en varias entidades más específicas basadas en atributos o relaciones particulares. Esto permite capturar detalles específicos y diferencias entre las entidades especializadas.

### Tipos de especialización

#### Especialización exclusiva

En la Especialización Exclusiva, cada ocurrencia de la superclase solo puede materializarse en una especialización. Por ejemplo, si tenemos una superclase "Empleado" y dos subclases "Gerente" y "Empleado de Ventas", un empleado solo puede ser o un gerente o un empleado de ventas, pero no ambos al mismo tiempo.

#### Especialización Inclusiva

En la Especialización Inclusiva, cada ocurrencia de la superclase puede materializarse en varias ocurrencias de las subclases. Por ejemplo, si tenemos una superclase "Empleado" y dos subclases "Desarrollador" y "Diseñador", un empleado puede ser tanto un desarrollador como un diseñador al mismo tiempo.

#### Especialización Total

En la Especialización Total: En este caso, la entidad Superclase tiene que materializarse obligatoriamente en una de las especializaciones. Por ejemplo, si tenemos una superclase "Desarrollador" y dos subclases "Java" y "Python", cada desarrollador debe ser necesariamente un desarrollador Java o un desarrollador Python.

#### Especialización Parcial

En la Especialización Parcial, la entidad Superclase no tiene por qué materializarse en una de las especializaciones. Por ejemplo, si tenemos una superclase "Empleado" y dos subclases "Tiempo Completo" y "Medio Tiempo", un empleado puede no pertenecer a ninguna de las dos categorías.

### Notación de Especialización y Generalización

- La Generalización se representa mediante un triángulo con la punta hacia abajo, conectando la superclase a las subclases.
![alt text](Imagenes/Generalizacion.png)
- La Especialización Total se representa con un círculo sobre la superclase. Su ausencia indica que la especialización es Parcial.
![alt text](Imagenes/EspecializacionTotal.png)
- La Especialización Exclusiva se representa con una U entre la Superclase y las Subclases bajo el triángulo de generalización. Su ausencia indica que la especialización es Inclusiva.
![alt text](Imagenes/EspecializacionExclusiva.png)

(Ejemplos gráficos de posibles combinaciones en apuntes a mano).

#### Ejemplos combinados

| Tipo                | Notación               | Imagen |
|---------------------|------------------------|--------|
| Parcial y Inclusiva | Solo triángulo         |    ![Parcial e Inclusiva](Imagenes/Generalizacion.png)    |
| Total e Inclusiva   | Triángulo y círculo    |   ![Total e Inclusiva](Imagenes/TotaleInclusiva.png)     |
| Parcial y Exclusiva | Triángulo y U          |   ![Parcial y Exclusiva](Imagenes/ParcialyExclusiva.png)     |
| Total y Exclusiva   | Triángulo, círculo y U |    ![Total y Exclusiva](Imagenes/TotalyExclusiva.png)    |
