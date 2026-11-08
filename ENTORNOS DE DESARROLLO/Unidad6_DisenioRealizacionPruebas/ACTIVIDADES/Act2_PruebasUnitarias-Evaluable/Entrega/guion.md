# Guion para Video de Pruebas Unitarias - Actividad 2

## Información General

- **Duración estimada**: 3-4 minutos
- **Herramienta de grabación**: Windows Game Bar (Win + G) o OBS Studio
- **Contenido**: Mostrar código, ejecución de aplicación y pruebas unitarias
- **Audio**: Hablar en español, explicando cada paso

## Estructura del Video

### 1. Introducción (0:00 - 0:30)

**Acciones en pantalla**:

- Mostrar el explorador de archivos con la estructura del proyecto
- Abrir Visual Studio 2026 con la solución cargada

**Texto a decir**:
"Hola, soy [Tu Nombre]. En este video voy a demostrar la ejecución de pruebas unitarias para la Actividad 2 de Diseño y Realización de Pruebas. He creado un proyecto de consola C# con una clase Operaciones que incluye métodos matemáticos básicos y un conjunto completo de pruebas unitarias usando xUnit."

### 2. Mostrar Código de Operaciones.cs (0:30 - 1:30)

**Acciones en pantalla**:

- Abrir el archivo `Calculadora/Operaciones.cs`
- Navegar por el código, destacando cada método
- Mostrar la documentación XML

**Texto a decir**:
"Primero, vamos a ver el código de la clase principal. Aquí tenemos la clase 'Operaciones' en el namespace 'Calculadora'. Incluye los siguientes métodos:

- Suma: toma dos números double y devuelve su suma
- Resta: toma dos números y devuelve la resta (este era uno de los requisitos)
- Multiplicar: multiplicación de dos números
- Dividir: división con manejo de excepciones (lanza ArgumentException si el divisor es cero)
- Iguales: devuelve true si dos números son iguales, false si no

Como pueden ver, cada método está documentado con comentarios XML y maneja tipos double para mayor precisión."

### 3. Mostrar Código de UnitTest1.cs (1:30 - 2:30)

**Acciones en pantalla**:

- Abrir el archivo `CalculadoraTests/UnitTest1.cs`
- Mostrar la estructura de la clase de pruebas
- Navegar por algunos métodos de prueba (no todos, para no alargar)
- Destacar el patrón Arrange-Act-Assert

**Texto a decir**:
"Ahora veamos las pruebas unitarias. Usamos xUnit como framework de pruebas. La clase 'OperacionesTests' tiene 20 pruebas en total, organizadas por regiones:

- Pruebas de Suma (3 pruebas)
- Pruebas de Resta (4 pruebas)
- Pruebas de Multiplicación (4 pruebas)
- Pruebas de División (4 pruebas)
- Pruebas de Iguales (4 pruebas)
- Una prueba intencional con fallo para demostración

Cada prueba sigue el patrón AAA: Arrange (preparar), Act (ejecutar), Assert (verificar). Usamos diferentes métodos de Assert como Equal, True, False y Throws para excepciones."

### 4. Ejecutar Aplicación de Consola (2:30 - 3:00)

**Acciones en pantalla**:

- Abrir terminal integrada en VS
- Ejecutar: `dotnet run --project Calculadora`
- Mostrar la salida completa

**Texto a decir**:
"Vamos a ejecutar la aplicación de consola para ver los métodos en funcionamiento. Como pueden ver, muestra ejemplos de todas las operaciones:

- Suma(10, 5) = 15
- Resta(10, 5) = 5  
- Multiplicar(10, 5) = 50
- Dividir(10, 5) = 2
- Iguales(5, 5) = True
- Iguales(5, 3) = False

También prueba la división por cero, que captura la excepción correctamente."

### 5. Ejecutar Pruebas Unitarias (3:00 - 3:45)

**Acciones en pantalla**:

- En la terminal, ejecutar: `dotnet test`
- Mostrar el progreso de las pruebas
- Destacar el resumen final (19 correctas, 1 error)

**Texto a decir**:
"Ahora ejecutemos las pruebas unitarias con 'dotnet test'. Como pueden ver, se ejecutan todas las 20 pruebas. El resumen muestra:

- Total: 20 pruebas
- Con errores: 1 (la prueba intencional que falla)
- Correctas: 19
- Tiempo: aproximadamente 2-3 segundos

La prueba que falla es 'PruebaQueDebeFallar_SumaIncorrecta_DevuelveFalse', que espera 20 pero obtiene 15, demostrando cómo se detectan errores en las pruebas."

### 6. Conclusión (3:45 - 4:00)

**Acciones en pantalla**:

- Mostrar el README.md brevemente
- Cerrar el IDE

**Texto a decir**:
"En resumen, hemos cumplido con todos los requisitos de la actividad:

- Método Resta implementado y probado
- Pruebas unitarias para Suma y Resta
- Método para verificar igualdad
- Pruebas para Multiplicar y Dividir
- Uso de diferentes métodos Assert
- Demostración de pruebas correctas y erróneas

El proyecto está disponible en el repositorio con documentación completa. Gracias por ver este video."

## Notas Técnicas

- **Resolución**: Grabar en 1080p o superior
- **Audio**: Asegúrate de que se escuche bien, sin ecos
- **Edición**: Si usas software de edición, agrega transiciones suaves
- **Entrega**: Sube el video a la plataforma requerida por tu profesor

## Checklist Pre-Grabación

- [ ] Proyecto compilado sin errores
- [ ] Terminal limpia
- [ ] Archivos abiertos en el editor
- [ ] Prueba de audio y video
- [ ] Espacio suficiente en disco
