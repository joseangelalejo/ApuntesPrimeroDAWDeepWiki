# Premisa de actividad proporcionada por profesor

Documentar cada paso de las siguientes actividades en un documento, entregar en pdf.

Unidades Organizativas (OU) y Políticas de Grupo (GPO)Crea tres Unidades y 3 usuarios en cada una. Organizativas: OU_Usuarios, OU_Administradores, OU_Temporales CREA AL MENOS UNA UNIDAD ORGANIZATIVA CON COMANDOS DESDE LA POWERSHELL y muestra por consola todas la OU.

1. Crea un GPO para cada Unidad Organizativa con las siguientes configuraciones:
   1. En OU_Usuarios: Bloquear la posibilidad de desinstalar programas e Impedir el cambio del fondo de escritorio.
   2. En OU_Temporales: Configurar una política que cierre automáticamente la sesión después de 5 minutos de inactividad y Restringir el acceso al Panel de Control.
   3. En OU_Administradores: Permitir acceso total a configuraciones del sistema.
   4. Inicia sesión con un usuario de alguna unidad organizativa y comprueba que la política se aplique.
2. Gestión de Usuarios con Comandos CSVDE y LDIFDE
   1. Exporta los usuarios existentes de una unidad organizativa con el comando csvde y guarda el archivo en el Escritorio
   2. Importa una nueva unidad organizativa con el comando ldifde
   3. Investiga cómo usar ldifde para:
   4. Modificar un atributo (por ejemplo, cambiar el nombre del usuario)
      - Modificar un atributo (por ejemplo, cambiar el nombre del usuario)
      - Eliminar un usuario del sistema.
3. Creación de un Administrador de Dominio
   1. Usando el Administrador del Servidor, crea un usuario y asígnale permisos de Administrador del Dominio
   2. Realiza la misma operación usando comandos de PowerShell.
4. Grupos y Compartición de Carpetas
   1. Investiga:¿Qué son los grupos en Active Directory?
   2. Tipos de grupos disponibles (por ejemplo, grupos de seguridad y grupos de distribución).
   3. Alcances de grupo (local, global y universal).
   4. Crea dos usuarios en la OU_Usuarios y asócialos a un grupo de seguridad.
   5. Configura una carpeta compartida para los dos usuarios con los siguientes permisos:
      1. Usuario 1: Permiso de lectura
      2. Usuario 2: Permiso de lectura y escritura.

- Entrega:
  - Documenta cada paso con capturas de pantalla y los comandos utilizados.
  - Incluye una breve explicación de las configuraciones realizadas en cada sección.
  - Investiga y responde las preguntas en la sección de investigación sobre grupos.
