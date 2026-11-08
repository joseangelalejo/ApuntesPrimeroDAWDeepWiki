# Configuración de MySQL en VSCode con SQLTools

## Introducción

En este repositorio, utilizamos MySQL como sistema de gestión de bases de datos para las prácticas de la asignatura de Bases de Datos. Para facilitar el desarrollo y la gestión de conexiones a MySQL directamente desde VSCode, recomendamos usar la extensión **SQLTools** junto con el driver de MySQL.

Esta guía explica paso a paso cómo instalar y configurar SQLTools en VSCode, agregar una nueva conexión a MySQL y resolver problemas comunes en **Windows, Arch Linux y Debian**.

## Instalación de MySQL

Antes de usar SQLTools, necesitas tener MySQL instalado en tu sistema. Aquí están las instrucciones para cada sistema operativo.

### Windows

1. Descarga el instalador desde [mysql.com](https://dev.mysql.com/downloads/mysql/)
2. Ejecuta el instalador `.msi` y sigue el asistente
3. Durante la instalación, configura:
   - Puerto: 3306 (por defecto)
   - Usuario root con contraseña
4. Inicia el servicio MySQL desde Servicios de Windows o usa la terminal:

```powershell
net start MySQL80
```

### Arch Linux

```bash
# Instalar MySQL
sudo pacman -S mysql

# Inicializar la base de datos
sudo mysql_install_db --user=mysql --basedir=/usr --datadir=/var/lib/mysql

# Iniciar el servicio
sudo systemctl start mysql
sudo systemctl enable mysql  # Para que inicie automáticamente

# Acceder a MySQL
sudo mysql -u root
```

### Debian / Ubuntu

```bash
# Instalar MySQL Server
sudo apt-get update
sudo apt-get install mysql-server

# Ejecutar el script de seguridad recomendado
sudo mysql_secure_installation

# Iniciar el servicio
sudo systemctl start mysql
sudo systemctl enable mysql  # Para que inicie automáticamente

# Acceder a MySQL
sudo mysql -u root
```

## Instalación de Extensiones

1. Abre VSCode y ve a la pestaña de Extensiones (ícono de cuadrados en la barra lateral izquierda).
2. Busca e instala las siguientes extensiones:
   - **SQLTools**: Extensión principal para ejecutar consultas SQL y gestionar conexiones.
   - **SQLTools MySQL/MariaDB**: Driver específico para MySQL (necesario para conectarte a bases de datos MySQL).

   Estas extensiones están recomendadas en el archivo `.vscode/extensions.json` de este repositorio.

**Alternativa:** Instalar desde terminal:

```bash
code --install-extension mtxr.sqltools
code --install-extension mtxr.sqltools-driver-mysql
```

## Creación de Usuarios en MySQL

Antes de configurar la conexión en SQLTools, asegúrate de que tienes usuarios creados en MySQL con los permisos adecuados.

### Acceder a MySQL desde Terminal

**Windows:**

```powershell
mysql -u root -p
```

**Arch Linux / Debian:**

```bash
# Acceso con sudo (opción recomendada)
sudo mysql -u root

# O si tienes contraseña:
mysql -u root -p
```

### Templates de Usuarios Predeterminados

Aquí tienes algunos templates comunes para crear usuarios con permisos específicos:

#### Usuario Administrador (Acceso Completo)

Ideal para desarrollo local con control total sobre las bases de datos.

```sql
-- Crear usuario administrador
CREATE USER 'admin'@'localhost' IDENTIFIED BY 'tu_contraseña_segura';

-- Otorgar todos los permisos
GRANT ALL PRIVILEGES ON *.* TO 'admin'@'localhost' WITH GRANT OPTION;

-- Aplicar cambios
FLUSH PRIVILEGES;
```

#### Usuario Profesor/Revisor (Solo Lectura)

Útil para profesores o revisores que necesitan consultar datos sin modificarlos.

```sql
-- Crear usuario profesor
CREATE USER 'profesor'@'localhost' IDENTIFIED BY 'tu_contraseña_segura';

-- Otorgar permisos de solo lectura
GRANT SELECT, SHOW VIEW ON *.* TO 'profesor'@'localhost';

-- Aplicar cambios
FLUSH PRIVILEGES;
```

#### Usuario Desarrollador (Permisos Limitados)

Para desarrolladores que pueden crear/modificar tablas pero no eliminar bases de datos completas.

```sql
-- Crear usuario desarrollador
CREATE USER 'dev'@'localhost' IDENTIFIED BY 'tu_contraseña_segura';

-- Otorgar permisos específicos
GRANT SELECT, INSERT, UPDATE, DELETE, CREATE, ALTER, DROP ON nombre_base_datos.* TO 'dev'@'localhost';

-- Aplicar cambios
FLUSH PRIVILEGES;
```

**Notas importantes**:

- Reemplaza `'tu_contraseña_segura'` con una contraseña fuerte.
- Para conexiones remotas, cambia `'localhost'` por `'%'` o la IP específica.
- Siempre ejecuta `FLUSH PRIVILEGES;` después de otorgar permisos.
- Si usas MySQL 8.0+, considera usar roles en lugar de permisos directos para una gestión más avanzada.

### Creación de Usuarios desde MySQL Workbench 8.0 CE (Interfaz Gráfica)

Si prefieres usar la interfaz gráfica en lugar de comandos SQL, puedes crear usuarios directamente desde MySQL Workbench. Aquí tienes los pasos:

1. **Abre MySQL Workbench** y conéctate a tu servidor MySQL (asegúrate de tener una conexión activa).

2. En el **panel lateral izquierdo**, selecciona la instancia de conexión a la que estás conectado (generalmente "Local instance MySQL80" o similar).

3. En la **barra de navegación superior**, haz clic en **Server**, luego **"Users and Privileges"** (icono de usuario con llave).

4. En la pestaña **"Users"**, haz clic en el botón **"Add Account"** (icono de usuario con un signo +).

5. Configura los detalles del usuario:
   - **Login Name**: Ingresa el nombre del usuario (ej. `admin`, `profesor`).
   - **Authentication Type**: Selecciona "Standard".
   - **Password**: Ingresa la contraseña.
   - **Confirm Password**: Repite la contraseña.
   - **Limit to Hosts Matching**: Deja como `%` para permitir conexiones desde cualquier host, o especifica `localhost` para conexiones locales.

6. Para asignar permisos:
   - Ve a la pestaña **"Administrative Roles"** y selecciona los roles predefinidos (ej. "DBA" para acceso completo, "ReadOnly" para solo lectura).
   - O ve a la pestaña **"Schema Privileges"** para permisos específicos por base de datos: selecciona el esquema, marca los permisos deseados (SELECT, INSERT, etc.).

7. Haz clic en **"Apply"** en la esquina inferior derecha para guardar los cambios.

8. Confirma los cambios en el diálogo que aparece y haz clic en **"Apply"** nuevamente.

**Consejos**:

- Para usuarios con permisos limitados, en "Administrative Roles" selecciona solo "ReadOnly" y desmarca otros roles.
- Puedes editar usuarios existentes haciendo doble clic en ellos en la lista.
- Recuerda que los cambios se aplican inmediatamente al servidor MySQL conectado.

Esta interfaz gráfica es especialmente útil para principiantes o para gestionar permisos complejos sin recordar comandos SQL.

## Configuración del Driver

Una vez instaladas las extensiones:

1. Reinicia VSCode si es necesario.
2. Abre la paleta de comandos (Ctrl+Shift+P) y busca "SQLTools: Add New Connection".
3. Selecciona "MySQL" como tipo de conexión.
4. Configura los parámetros de conexión:
   - **Connection Name**: Un nombre descriptivo, ej. "MySQL Local".
   - **Server Address**: `localhost` o la IP del servidor MySQL.
   - **Port**: `3306` (puerto por defecto de MySQL).
   - **Database**: Nombre de la base de datos a la que deseas conectarte (este campo es obligatorio).
   - **Username**: Tu usuario de MySQL (ej. `root`).
   - **Password**: La contraseña de tu usuario MySQL.
   - **Use Password**: Marca esta opción si deseas guardar la contraseña.

5. Haz clic en "Test Connection" para verificar que la conexión funcione.
6. Si la prueba es exitosa, guarda la conexión.

## Agregar una Nueva Conexión

Para agregar más conexiones (ej. a diferentes servidores o bases de datos):

1. Abre la paleta de comandos y selecciona "SQLTools: Add New Connection".
2. Repite los pasos de configuración anteriores con los nuevos parámetros.
3. Puedes tener múltiples conexiones activas y cambiar entre ellas desde la barra lateral de SQLTools.

## Uso Básico

- Una vez conectada, verás las bases de datos en la barra lateral.
- Haz clic derecho en una tabla para ver opciones como "Show Records" o "Describe Table".
- Para ejecutar consultas, crea un nuevo archivo con extensión `.sql`, escribe tu consulta y ejecuta con Ctrl+Shift+E o desde el menú de SQLTools.

## Problemas Comunes y Soluciones

- **Error de conexión**: Verifica que MySQL esté corriendo en tu máquina (usa MySQL Workbench o el servicio de Windows). Asegúrate de que el puerto 3306 no esté bloqueado por firewall.
- **Driver no encontrado**: Reinicia VSCode después de instalar las extensiones. Si persiste, instala manualmente el driver desde la paleta de comandos.
- **Acceso denegado**: Revisa las credenciales de usuario. En MySQL, el usuario `root` puede requerir configuración adicional para conexiones remotas.
- **Conexión a servidor remoto**: Para conexiones fuera de localhost, asegúrate de que el servidor MySQL permita conexiones remotas y configura el firewall adecuadamente.

## Recursos Adicionales

- [Documentación oficial de SQLTools](https://vscode-sqltools.mteixeira.dev/)
- [Guía de MySQL Workbench](https://dev.mysql.com/doc/workbench/en/) para gestión avanzada.
- Si tienes problemas específicos, consulta los issues en el repo de GitHub de SQLTools.

Esta configuración te permitirá trabajar eficientemente con bases de datos MySQL directamente en VSCode, integrando el desarrollo de aplicaciones Java con la gestión de datos.
