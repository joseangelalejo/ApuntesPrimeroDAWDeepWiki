# **Comandos de Máquina Virtual en Debian - Apuntes de clase**

- [**Comandos de Máquina Virtual en Debian - Apuntes de clase**](#comandos-de-máquina-virtual-en-debian---apuntes-de-clase)
  - [**GESTIÓN DE PAQUETES**](#gestión-de-paquetes)
    - [**Uso de SSH**](#uso-de-ssh)
  - [**NAVEGACIÓN ENTRE DIRECTORIOS**](#navegación-entre-directorios)
    - [**Verificar ruta actual**](#verificar-ruta-actual)
  - [**LISTAR CONTENIDO DE ARCHIVOS O DIRECTORIOS**](#listar-contenido-de-archivos-o-directorios)
    - [**Buscar patrones en archivos**](#buscar-patrones-en-archivos)
  - [**CREAR ARCHIVOS O DIRECTORIOS**](#crear-archivos-o-directorios)
    - [**Expansión de nombres de archivos/directorios**](#expansión-de-nombres-de-archivosdirectorios)
  - [**MANIPULAR ARCHIVOS O DIRECTORIOS**](#manipular-archivos-o-directorios)
    - [**Mover archivos o directorios**](#mover-archivos-o-directorios)
    - [**Copiar/Pegar archivos/directorios a otro directorio**](#copiarpegar-archivosdirectorios-a-otro-directorio)
    - [**Eliminar archivos/directorios**](#eliminar-archivosdirectorios)
    - [**Crear accesos directos de un archivo o directorio**](#crear-accesos-directos-de-un-archivo-o-directorio)
    - [**Modificar permisos y propiedad de archivos/directorios**](#modificar-permisos-y-propiedad-de-archivosdirectorios)
      - [**Modificar permisos para un grupo**](#modificar-permisos-para-un-grupo)
      - [**Cambiar propietario de un archivo o directorio**](#cambiar-propietario-de-un-archivo-o-directorio)
      - [**Cambiar grupo propietario de un archivo o directorio**](#cambiar-grupo-propietario-de-un-archivo-o-directorio)
  - [**CREACION Y MODIFICACION DE USUARIOS Y GRUPOS**](#creacion-y-modificacion-de-usuarios-y-grupos)
    - [**Creacion y Modificacion de Root**](#creacion-y-modificacion-de-root)
  - [**OTROS COMANDOS/CONCEPTOS ÚTILES**](#otros-comandosconceptos-útiles)

---
<div style="page-break-after: always;"></div>

## **GESTIÓN DE PAQUETES**

Para instalar un paquete utilizamos el comando `sudo apt-get install nombre_del_paquete`:

Por ejemplo, para instalar el gestor de archivos ssh usamos:

```bash
sudo apt-get install openssh-server
```

Para comprobar si un paquete está instalado usamos el comando `dpkg -l | grep nombre_del_paquete`:

```bash
dpkg -l | grep openssh-server
```

Para eliminar un paquete usamos el comando `sudo apt-get remove nombre_del_paquete`:

```bash
sudo apt-get remove openssh-server
```

### **Uso de SSH**

- Para verificar si ssh está instalado, usamos `ssh -v`: Nos devolverá la versión instalada si lo está, o un error si no lo está.

- Para iniciar el servicio de ssh usamos el comando `sudo service ssh start`.
- Para detener el servicio de ssh usamos el comando `sudo service ssh stop`.
- Para reiniciar el servicio de ssh usamos el comando `sudo service ssh restart`.
- Para obtener la ip de conexión de la máquina virtual usamos el comando `ip a` y nos devolverá la ip en formato `inet XXX.XXX.x.x`.
- Para conectarnos a un servidor ssh usamos el comando `ssh usuario@ip_del_servidor`:

```bash
ssh jose@192.168.1.10
```

---
<div style="page-break-after: always;"></div>

## **NAVEGACIÓN ENTRE DIRECTORIOS**

Para desplazarse entre directorios utilizamos el comando cd (change directory) → `cd "ruta/al/directorio"`.

Para volver al directorio anterior utilizamos `cd ..`

### **Verificar ruta actual**

Si queremos verificar la ruta en la que nos encontramos actualmente, utilizamos el comando `pwd` (print working directory).

## **LISTAR CONTENIDO DE ARCHIVOS O DIRECTORIOS**

Para listar archivos o directorios utilizamos el comando `ls "/ruta/al/archivoOdirectorio"` (list):

Para listas archivos en orden alfabético, utilizamos `ls -r "/ruta/al/directorioOarchivo"`.

Para seleccionar múltiples archivos utilizamos `ls archivo1.txt archivo2.txt`.

Hay otros modificadores para el comando `ls`, como:

- `-a`: muestra todos los archivos, incluidos los ocultos (los que comienzan con un punto).
- `ls -l`: Lista larga, con detalles como permisos, propietario, tamaño y fecha de modificación.
- `ls -ld`: muestra información sobre el directorio en sí, en lugar de su contenido.
- `ls -d`: Muestra permisos y propietarios de un directorio.
- `ls -r *`: muestra directorios y subdirectorios.
- `ls -d *`: muestra en orden alfabético.
- `ls -dr *`: muestra en orden inverso.
- `*`: permite usar comodines para seleccionar múltiples archivos que coincidan con un patrón.
  - Ejemplo: `ls *.txt` lista todos los archivos con extensión .txt.
  - `ls -d t*`: muestra directorios y archivos que empiecen por t.
  - `ls -d ??`: muestra directorios y archivos que tengan dos caracteres.
  - `ls -d t*[a-d]`: muestra directorios y archivos que empiecen por t y acaben en a, b, c o d.
  - `ls -d t*s`: muestra directorios y archivos que empiecen por t y acaben en s.
  - `ls -d [^t]*`: muestra todos los archivos y directorios menos los que empiecen por t.

**Para ver la estructura de un directorio en forma de árbol**, utilizamos el comando `tree`:

### **Buscar patrones en archivos**

Para buscar patrones específicos dentro de archivos de texto, utilizamos el comando `grep "patrón" nombre_del_archivo.txt`.
Por ejemplo:

- `grep "hola" log.txt` buscará todas las líneas que contengan la palabra "hola" en el archivo log.txt.
- `grep -c hola doc.txt` mostrará el número de líneas que contienen la palabra "hola" en doc.txt.

---
<div style="page-break-after: always;"></div>

## **CREAR ARCHIVOS O DIRECTORIOS**

- Para **crear archivos** utilizamos el comando `touch nombre_del_archivo.txt`.
- Para **crear un archivo oculto** usamos `touch .nombre_del_archivo.txt`.
- Para **crear un archivo con espacios en el nombre** usamos comillas: `touch "nombre del archivo.txt"`.
- Si queremos **crearlo y modificarlo** usamos `nano nombre_del_archivo.txt`.
- Si queremos **visualizar el contenido de un archivo de texto** usamos el comando `cat nombre_del_archivo.txt`.

Para crear directorios utilizamos el comando `mkdir` (make directory):

```bash
mkdir nombre_del_directorio
```

### **Expansión de nombres de archivos/directorios**

La expansión de nombres de archivos nos permite crear o manipular múltiples archivos o directorios utilizando patrones o rangos.

Para crear múltiples directorios con una estructura específica, usamos el comando `mkdir -p` junto con llaves `{}` para definir patrones o rangos.

Ejemplo para crear una carpeta música con subcarpetas artistas y dentro albumes 1, 2 y 3:

```bash
mkdir -p  musica/artista{1,2,3}/album{1,2,3}
```

o

```bash
mkdir -p musica/{artista1,artista2,artista3}/album/{1,2,3}
```

Para crear múltiples archivos dentro de un directorio usamos el comando `touch` con expresiones regulares:

```bash
touch foo/bar{1,2,3}.txt
```

Si queremos crear muchos archivos con un rango numérica usamos:

```bash
touch archivo{1..10}.txt
```

Por ejemplo, para crear archivos con nombres secuenciales del 1 al 5, podemos usar:

```bash
touch archivo{1..5}.txt
```

---

## **MANIPULAR ARCHIVOS O DIRECTORIOS**

### **Mover archivos o directorios**

Para ello utilizamos el comando `mv "origen" "destino"`.

Si la ruta a la que hay que moverlo no existe, el archivo/directorio se renombra con el nombre indicado en destino.

### **Copiar/Pegar archivos/directorios a otro directorio**

Para copiar archivos utilizamos el comando `cp "origen" "destino"`.

Cuando queremos copiar un directorio, debemos usar el modificador `-r` (recursivo) para copiar todo su contenido.

```bash
cp -r carpeta1 "ruta/destino/"
```

### **Eliminar archivos/directorios**

Para eliminar archivos utilizamos el comando rm (remove): `rm nombre_del_archivo.txt`

Para eliminar directorios utilizamos el comando rmdir (remove directory): `rmdir nombre_del_directorio`

Si el directorio no está vacío, debemos usar el modificador `-r` (recursivo):

```bash
rm -r nombre_del_directorio
```

### **Crear accesos directos de un archivo o directorio**

Para crear accesos directos (enlaces simbólicos) de un archivo o directorio utilizamos el comando `ln -s "ruta/origen" "ruta/destino"`.
Por  ejemplo:

```bash
ln -s /home/usuario/documento.txt /home/usuario/escritorio/acceso_directo_documento.txt
```

---
<div style="page-break-after: always;"></div>

### **Modificar permisos y propiedad de archivos/directorios**

Para modificar los permisos de archivos o directorios utilizamos el comando chmod (change mode):

```bash
chmod permisos nombre_del_archivo_o_directorio
```

Donde `permisos` puede ser una combinación de:

- `r`: permiso de lectura (read)
- `w`: permiso de escritura (write)
- `x`: permiso de ejecución (execute)
- `-`: para eliminar un permiso

Ejemplo de dar permisos de lectura, escritura y ejecución al propietario, y solo lectura y ejecución al grupo y otros:

```bash
chmod 755 nombre_del_archivo_o_directorio
```

**Cada número representa los permisos para el propietario, el grupo y otros, respectivamente.**
Pueden ser:

- `7`: lectura, escritura y ejecución (rwx)
- `6`: lectura y escritura (rw-)
- `5`: lectura y ejecución (r-x)
- `4`: solo lectura (r--)
- `3`: escritura y ejecución (-wx)
- `2`: solo escritura (-w-)
- `1`: solo ejecución (--x)
- `0`: sin permisos (---)

![Calcular valor de permisos](Imagenesapuntes/Calcularvalorpermisos.jpg)
<div style="page-break-after: always;"></div>

#### **Modificar permisos para un grupo**

Para conceder permisos a todo un grupo utilizamos el comando `chmod g+permisos nombre_del_archivo_o_directorio`.

```bash
chmod g+rwx nombre_del_archivo_o_directorio
```

Donde:

- `g` indica grupo. `+` indica añadir. | `-` indica eliminar. `=` establecer permisos exactos.
- `rwx` son los permisos que se están concediendo (lectura, escritura y ejecución).
- `nombre_del_archivo_o_directorio` es el archivo o directorio al que se le están concediendo los permisos.

#### **Cambiar propietario de un archivo o directorio**

Para cambiar el propietario de un archivo o directorio utilizamos el comando `chown nuevo_propietario nombre_del_archivo_o_directorio`.

```bash
chown pepe documento.txt
```

#### **Cambiar grupo propietario de un archivo o directorio**

Para cambiar el grupo propietario de un archivo o directorio utilizamos el comando `chown :nuevo_grupo foo/bar`. Si queremos que el cambio afecte también a los archivos y subdirectorios dentro de un directorio, añadimos el modificador `-R` (recursivo):

```bash
chown -R :desarrolladores foo/bar
```

Lo que indiquemos después de los dos puntos `:` será el nuevo grupo propietario del archivo o directorio. Si queremos cambiar tanto usuario propietario como grupo propietario, lo indicamos antes y después de los dos puntos `usuario:grupo`:

```bash
chown pepe:desarrolladores documento.txt
```

## **CREACION Y MODIFICACION DE USUARIOS Y GRUPOS**

Para ver los usuarios existentes en el sistema, podemos consultar el archivo `/etc/passwd` utilizando el comando `cat /etc/passwd` desde la raiz del sistema: los usuarios humanos tendrán un UID alto, y una shell interactiva (normalmente `/bin/bash`, `/bin/sh` o `/bin/zsh`). <br>
Otra opción es filtrar usuarios humanos con el comando `awk -F: '$3 >= 1000 {print $1}' /etc/passwd`.

Para **crear usuarios** utilizamos el comando `sudo adduser nombre_del_usuario`:

```bash
sudo adduser jose
```

Para **eliminar un usuario** utilizamos el comando `sudo deluser nombre_del_usuario`:

```bash
sudo deluser jose
```

Para **cambiar el nombre del usuario** utilizamos el comando `usermod -l nuevo_nombre antiguo_nombre`:

```bash
sudo usermod -l pepe jose
```

Este comando no cambiara el home del usuario, para ello hay que usar el comando `usermod -d /home/nuevo_home -m nombre_del_usuario`:

```bash
sudo usermod -d /home/pepe -m pepe
```

Para cambiar nombre y home a la vez: `usermod -l nuevo_nombre -d /home/nuevo_home -m antiguo_nombre`:

```bash
sudo usermod -l pepe -d /home/pepe -m jose
```

Para **cambiar la contraseña de un usuario** utilizamos el comando `sudo passwd nombre_del_usuario`:

```bash
sudo passwd pepe
```

Para **cambiar de usuario** utilizamos el comando `su nombre_del_usuario` (switch user):

```bash
su pepe
```

Para **ver el grupo al que pertenece un usuario** usamos el comando `groups`:

```bash
groups nombre_del_usuario
```

Para **crear un grupo** usamos el comando `sudo groupadd nombre_del_grupo`:

```bash
sudo groupadd desarrolladores
```

Para **agregar un usuario a un grupo** usamos el comando `usermod -aG nombre_del_grupo nombre_del_usuario`:

```bash
sudo usermod -aG desarrolladores pepe
```

Para **eliminar un usuario de un grupo** utilizamos el comando `sudo gpasswd -d nombre_del_usuario nombre_del_grupo`:

```bash
sudo gpasswd -d pepe desarrolladores
```

Para **agregar un usuario a sudo** usamos el comando `sudo usermod` con el modificador `-aG`:

```bash
sudo usermod -aG sudo pepe
```

---

### **Creacion y Modificacion de Root**

Para **crear/habilitar/cambiar contraseña el usuario root** (administrador del sistema), utilizamos el comando `sudo passwd root`.

Para agregar un usuario al grupo root (para que tenga permisos de administrador) usamos el comando `usermod -aG root nombre_del_usuario`:

```bash
sudo usermod -aG root pepe
```

Para **entrar en usuario root** usamos el comando `su -`:

```bash
su -
```

Para **salir del modo root** usamos el comando `exit`:

```bash
exit
```

---

## **OTROS COMANDOS/CONCEPTOS ÚTILES**

- `clear`: limpia la pantalla de la terminal.
- `date`: muestra la fecha y hora actuales.

**La virgulilla `~` representa el directorio home del usuario actual.** Por ejemplo, si el usuario es "jose", `~/documento.txt` se refiere a `/home/jose/documento.txt`.
