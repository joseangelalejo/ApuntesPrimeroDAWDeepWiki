# Unidad 3 - Sistemas operativos en Red | Windows Server | José Ángel Alejo Sillero

- [Unidad 3 - Sistemas operativos en Red | Windows Server | José Ángel Alejo Sillero](#unidad-3---sistemas-operativos-en-red--windows-server--josé-ángel-alejo-sillero)
  - [GLOSARIO](#glosario)
  - [INSTALACIÓN WINDOWS SERVER](#instalación-windows-server)
  - [Instalar Guest Additions y protocolo SSH](#instalar-guest-additions-y-protocolo-ssh)
  - [Cuentas de usuario](#cuentas-de-usuario)
  - [Active Directorio (AD)](#active-directorio-ad)
    - [AD | ÁRBOLES y BOSQUES](#ad--árboles-y-bosques)
    - [AD | Instalación y configuración](#ad--instalación-y-configuración)
    - [Cuentas de usuario en AD](#cuentas-de-usuario-en-ad)
    - [Unidades Organizativas (OU/UO)](#unidades-organizativas-ouuo)
      - [Creación de Objetos de Políticas de Grupo (GPOs)](#creación-de-objetos-de-políticas-de-grupo-gpos)
    - [GRUPOS](#grupos)
      - [Grupos de Seguridad vs. Grupos de Distribución](#grupos-de-seguridad-vs-grupos-de-distribución)
  - [COMANDOS POWERSHELL](#comandos-powershell)
    - [Comandos para Unidades Organizativas](#comandos-para-unidades-organizativas)
    - [Comandos para Usuarios](#comandos-para-usuarios)
    - [Comandos para Grupos](#comandos-para-grupos)
    - [Otros comandos útiles](#otros-comandos-útiles)

---
<div style="page-break-after: always;"></div>

## GLOSARIO

1. **Windows Server**: Sistema operativo de servidor desarrollado por Microsoft, diseñado para gestionar recursos de red, servicios y aplicaciones en entornos empresariales.
2. **Active Directory (AD)**: Servicio de directorio que permite la administración centralizada de usuarios, grupos, equipos y políticas de seguridad en una red basada en Windows.
3. **Domain Controller (DC)**: Servidor que ejecuta Active Directory y es responsable de autenticar y autorizar a los usuarios y equipos en un dominio.
4. **Dominio en el contexto de Active Directory**: Conjunto de objetos (usuarios, grupos, equipos) que comparten una base de datos común y políticas de seguridad dentro de una red administrada por Active Directory.
5. **DNS (Domain Name System)**: Servicio que traduce nombres de dominio legibles (por ejemplo, `www.ejemplo.com`) en direcciones IP numéricas.
6. **DHCP (Dynamic Host Configuration Protocol)**: Servicio/Protocolo que asigna automáticamente direcciones IP y otros parámetros a los dispositivos en una red, evitando conflictos de IP y facilitando la configuración.
7. **Roles y características en Windows Server**: Componentes que se pueden habilitar según las necesidades de la organización/servidor:
   1. Roles: Funciones principales como servidor web (IIS), servidor de archivos, servidor DNS, etc.
   2. Características: Herramientas adicionales como .NET Framework, o BitLocker.
8. **Clústeres**: Conjunto de servidores o sistemas que trabahan juntos como si fueran una única entidad para proporcionar alta disponibilidad, escalabilidad y rendimiento.
9. **Remote Desktop Services (RDS)**: Tecnología que permite a los usuarios conectarse a escritorios remotos o aplicaciones alojadas en un servidor.
10. **Backup y Restore**: Herramientas y procesos para proteger losd atos mediante copias de seguridad y su restauración en caso de pérdida o fallo del sistema.
11. **Virtual Private Network (VPN)**: Servicio que permite conexiones seguras a la red desde ubicaciones remotas.
12. **NAT (Network Address Translation)**: Técnica que traduce direcciones IP privadas a direcciones IP públicas, facilitando la conexión a Internet y mejorando la seguridad.
13. **Roles de usuario**: Permisos y privilegios que se asignan a usuarios en función de sus tareas, como administrador o usuario estándar.

---
<div style="page-break-after: always;"></div>

## INSTALACIÓN WINDOWS SERVER

Descargar ISO de Windows Server desde [Microsoft Eval Center](https://www.microsoft.com/es-es/evalcenter/download-windows-server-2022).

Seleccionar edición "experiencia de escritorio" durante la instalación.

## Instalar Guest Additions y protocolo SSH

Instalar Guest Additions insertando la imagen desde el apartado dispositivos en VirtualBox.

Para instalar SSH, abrir PowerShell como administrador y ejecutar comandos para habilitar OpenSSH.

## Cuentas de usuario

Las cuentas de usuario permiten administrar el acceso al sistema y personalizar el entorno. Se dividen en varios tipos:

1. **Tipos de Cuentas**
   - **Administrador**: Tiene control total del sistema.
   - **Estándar**: Cuenta para uso cotidiano con permisos limitados.
   - **Invitado**: Acceso temporal con permisos mínimos.
   - **Cuentas de dominio**: Gestionadas por servidores en redes empresariales.

## Active Directorio (AD)

**Active Directory** (**AD**) es un servicio de **Microsoft** que permite gestionar de forma centralizada los **usuarios**, **dispositivos** y **recursos** en una red. Su principal función es **autenticar** y **autorizar** a los usuarios y equipos, permitiéndoles acceder a los recursos de la red (como archivos, impresoras, aplicaciones). Además, **Active Directory** organiza estos recursos en una estructura jerárquica (**dominios**, **árboles**, **bosques**) y facilita la administración mediante **políticas de seguridad** y **grupos**. Es esencial para redes empresariales grandes, ya que mejora la **seguridad** y la **eficiencia administrativa**.

### AD | ÁRBOLES y BOSQUES

Un **árbol de dominios** es un conjunto de **dominios** que comparten un espacio de nombres contiguo. Por ejemplo, si el dominio principal se llama empresa.local y tiene un subdominio, este se llamaría subdominio.empresa.local.

En un **bosque de Active Directory**, pueden existir varios árboles de dominio. El **bosque** es una estructura más grande que agrupa uno o más dominios, los cuales comparten un esquema, un catálogo global y configuraciones comunes. Además, todos los dominios dentro de un bosque tienen relaciones de confianza automáticas y bidireccionales entre sí. El bosque constituye una unidad completa del directorio y define los límites de seguridad.

Las **Unidades Organizativas** (**OUs**) son contenedores utilizados para organizar y gestionar eficientemente los objetos dentro de un dominio.

- **Bosque**: Contiene dominios. Se utiliza para definir el alcance de la autoridad de los administradores.
- **Dominio**: Contiene OUs. Se utiliza para particionar los datos del directorio y controlar la replicación.
- **Unidad Organizativa (OU)**: Contiene cuentas de usuario y computadora. Se utiliza para delegar el control y aplicar políticas.

### AD | Instalación y configuración

Video: [Instalación de Active Directory](https://drive.google.com/file/d/1KbXgxslz47PurEa1N1PmWbcyy5T7JYMH/view?usp=sharing)

PDF: [Guía de configuración](https://docs.google.com/document/d/1eqUA2y5hR1Clwz-wl0vMCQuG7f0mjpGNQFEuZD_4fDU/edit?usp=sharing)

### Cuentas de usuario en AD

Una vez instalado Active Directory, éste se convierte en un controlador de dominio. Por lo que no podremos crear usuarios ni grupos locales. Solo podremos crear cuentas de dominio.

Un UPN (User Principal Name) es un identificador de cuenta de usuario en Active Directory que sigue el formato de un correo electrónico, como `usuario@dominio.com`. Se utiliza para autenticar y acceder a recursos en un entorno de dominio.

- **Elementos de un UPN**:
  - **Nombre del Usuario**: La parte anterior al @.
  - **Sufijo UPN**: La parte posterior al @, que normalmente es el nombre del dominio.

Crear cuentas de usuario: [Guía](https://docs.google.com/document/d/1xVB1LmIu9A1v23WjkQ_aC7k1jSnf0cu_9AvUiZZRjsA/edit?usp=sharing)

Exportar o importar cuentas de usuario: [Guía](https://docs.google.com/document/d/1W7aaWG3eeYyEUNH5lagH5xUNwnCjEigkkuomLq9XNOM/edit?usp=sharing)

### Unidades Organizativas (OU/UO)

Las Unidades Organizativas (OUs) en Active Directory son **contenedores lógicos dentro de un dominio que se utilizan para organizar y administrar objetos** como usuarios, grupos, equipos y otros contenedores. Son **fundamentales para estructurar la jerarquía administrativa y delegar el control** en una organización.

> **Usos comunes**:

- **Departamentos**: Crear una OU para cada departamento, como Recursos Humanos, Finanzas, IT, etc.
- **Ubicación geográfica**: Dividir las OUs por regiones, oficinas, o países.
- **Función o rol**: Crear OUs basadas en funciones específicas como Servidores, Estaciones de Trabajo o Cuentas de Servicio.
- **Administración delegada**: Delegar tareas administrativas específicas a diferentes grupos responsables.

Las políticas que gestionan el comportamiento de usuarios y equipos, especialmente aquellas relacionadas con restricciones y configuraciones, se aplican mediante las Unidades Organizativas (OUs) en Active Directory, utilizando Objetos de Políticas de Grupo (GPOs).

Los Objetos de Políticas de Grupo (GPOs) se vinculan a una OU, lo que permite configurar restricciones o configuraciones específicas para los usuarios y equipos dentro de esa OU.

#### Creación de Objetos de Políticas de Grupo (GPOs)

Para crear GPOs, utiliza la herramienta "Administración de directivas de grupo".

1. Selecciona la OU a la que deseas aplicar la GPO.
2. Haz clic derecho sobre la OU y selecciona "Crear una GPO en este dominio y vincularlo aquí".
3. Asigna un nombre a la nueva GPO.
4. Para editar la GPO, haz clic derecho sobre ella y selecciona "Editar".

Esto permitirá configurar políticas específicas para la OU seleccionada.

### GRUPOS

Los **grupos en Active Directory son conjuntos de objetos**, principalmente usuarios, que se utilizan para **simplificar la administración de permisos y recursos dentro de un dominio**.

En lugar de asignar permisos individualmente a cada usuario, se pueden asignar a un grupo, y todos los miembros heredarán esos permisos. Esto **facilita la gestión y mejora la seguridad del sistema**.

#### Grupos de Seguridad vs. Grupos de Distribución

- Grupos de Seguridad: Se usan para asignar permisos de acceso a recursos como carpetas compartidas, impresoras y aplicaciones. Son esenciales para la gestión de seguridad dentro del dominio.
- Grupos de Distribución: Se utilizan únicamente para la distribución de correos electrónicos en Exchange Server. No pueden asignarse a permisos de seguridad.

Los grupos en AD tienen diferentes ámbitos:

- **Grupo Local de Dominio (Domain Local Group)**: Solo válido dentro del dominio.
  - Para asignar permisos a recursos dentro del dominio (a nivel local).
  - Puede contener usuarios, grupos globales y universales de cualquier dominio del bosque.
- **Grupo Global (Global Group)**: Para organizar usuarios dentro de un dominio.
  - Puede ser miembro de otros grupos locales de dominio o universales.
  - Sólo puede contener usuarios y grupos del mismo dominio.
- **Grupo Universal (Universal Group)**: Utilizable en cualquier dominio del bosque.
  - Ideal para compartir acceso entre múltiples dominios dentro de un bosque.
  - Puede contener usuarios, grupos globales y otros grupos universales de cualquier dominio del bosque.

## COMANDOS POWERSHELL

### Comandos para Unidades Organizativas

Crear una OU llamada "Departamentos" en la raíz del dominio:

```powershell
New-ADOrganizationalUnit -Name "Departamentos" -Path "DC=itpja,DC=local"
```

Crear una sub-OU dentro de otra OU:

```powershell
New-ADOrganizationalUnit -Name "IT" -Path "OU=Departamentos,DC=itpja,DC=local"
```

Crear varias OUs:

```powershell
$OUs = @("RecursosHumanos", "Finanzas", "Marketing")
foreach ($OU in $OUs) {
    New-ADOrganizationalUnit -Name $OU -Path "DC=itpja,DC=local"
}
```

Ver las OUs creadas:

```powershell
Get-ADOrganizationalUnit -Filter * | Select-Object Name, DistinguishedName
```

### Comandos para Usuarios

Crear **un usuario básico**:

```powershell
dsadd user "CN=Juan Perez,CN=Users,DC=itpja,DC=local" -samid jperez -upn jperez@itpja.local -fn Juan -ln Perez -pwd "Contraseña123!" -disabled no -mustchpwd no
```

- Donde:
  - `CN=Juan Perez`: Common Name (Nombre común del usuario).
  - `CN=Users`: Contenedor predeterminado para usuarios.
  - `DC=itpja,DC=local`: Domain Component (Componentes del dominio).
  - `-samid`: Nombre de inicio de sesión (SAM Account Name).
  - `-upn`: User Principal Name (Nombre principal del usuario).
  - `-fn`: First Name (Nombre).
  - `-ln`: Last Name (Apellido).
  - `-pwd`: Contraseña del usuario.
  - `-disabled no`: Habilita la cuenta.
  - `-mustchpwd no`: No obliga al usuario a cambiar la contraseña en el primer inicio de sesión.

Donde el conjunto `"CN=Juan Perez,CN=Users,DC=itpja,DC=local"` conforma la ruta LDAP (Protocolo Ligero de Acceso a Directorios) completa del usuario, que especifica dónde se creará el usuario dentro de la estructura del Active Directory.

Crear **un usuario en una OU específica**:

```powershell
dsadd user "CN=Juan Perez,OU=Instituto,DC=itpja,DC=local" -samid jperez -upn jperez@itpja.local -fn Juan -ln Perez -pwd "Contraseña123!" -disabled no -mustchpwd no
```

- Donde:
  - `CN`: Common Name (Nombre común del usuario).
  - `OU`: Organizational Unit (Unidad Organizativa donde se crea el usuario).
  - `DC`: Domain Component (Componentes del dominio).
  - `-samid`: Nombre de inicio de sesión (SAM Account Name).
  - `-upn`: User Principal Name (Nombre principal del usuario).
  - `-fn`: First Name (Nombre).
  - `-ln`: Last Name (Apellido).
  - `-pwd`: Contraseña del usuario.
  - `-disabled no`: Habilita la cuenta.
  - `-mustchpwd no`: No obliga al usuario a cambiar la contraseña en el primer inicio de sesión.

Crear **un usuario en una OU dentro de otra OU**(OU anidada), por ejemplo una OU llamada "LM" dentro de la OU "DAM":

```powershell
dsadd user "CN=lmuser1,OU=LM,OU=DAM,DC=itpja,DC=local" -samid lmuser1 -upn lmuser1@itpja.local -fn lmuser -ln 1 -pwd "Contraseña123!" -disabled no -mustchpwd no
```

- **Consideraciones al crear usuarios en OU y OU anidadas**:
  - Asegúrate de que la OU exista antes de intentar crear el usuario en ella.
  - Si creamos un usuario en una OU animada, la ruta LDAP debe reflejar correctamente la jerarquía de OUs.

Ver **los usuarios existentes en el dominio**:

```powershell
Get-ADUser -Filter * | Select-Object Name, SamAccountName, UserPrincipalName
```

**Proteger un usuario del dominio contra eliminación accidental**:

```powershell
Set-ADUser -Identity "jose" -ProtectedFromAccidentalDeletion $true
```

Eliminar un usuario del dominio:

```powershell
Remove-ADUser -Identity "jose"
```

### Comandos para Grupos

Ver grupos a los que pertenece un usuario:

```powershell
Get-ADUser -Identity "jose" -Properties MemberOf
```

Añadir un usuario a un grupo:

```powershell
Add-ADGroupMember -Identity "Admins. del dominio" -Members "jose"
```

### Otros comandos útiles

- Restablecer contraseña: `dsmod user "nombre distinguido del usuario" -pwd "nueva contraseña"`
- Modificar un usuario: `dsmod user "CN=Juan Pérez,OU=Usuarios,DC=empresa,DC=com" -pwd NuevaContraseña123 -mustchpwd yes -disabled no`
- Eliminar un usuario: `dsmrm "CN=Juan Pérez,OU=Usuarios,DC=empresa,DC=com"`
- Mover un usuario a otra UO: `dsmove "CN=Juan Pérez,OU=Usuarios,DC=empresa,DC=com" -newparent "OU=Administración,DC=empresa,DC=com"`
- Mostrar información de un usuario: `dsget user "CN=Juan Pérez,OU=Usuarios,DC=empresa,DC=com" -memberof`
- Ejecutar PowerShell con privilegios elevados: `runas /user:"nombre usuario" powershell`

TODO: Implementar imágenes a lo largo del documento para mejorar la comprensión visual de los conceptos y procedimientos descritos.
