# Actividad 24: Administración de windows - Firewall

1. Verificar el estado del Firewall

- Abrir el Panel de control → Sistema y seguridad → Firewall de Windows Defender.
- Comprobar si está activado.

2. Permitir o bloquear una aplicación (Google Chrome)

- Crear una regla de salida para bloquear Google Chrome.
- Antes de aplicar la regla, acceder a una página web y hacer captura.
- Activar la regla.
- Comprobar que el navegador no puede acceder a Internet.

3. Bloquear conexión HTTP y HTTPS (puertos 80 y 443)

- Crear una regla de salida que bloquee los puertos 80 y 443.
- Antes de aplicar la regla, comprobar que se puede navegar y hacer captura.
- Activar la regla.
- Verificar que no cargan las páginas web.

4. Bloquear conexión SSH (puerto 22)

- Crear una regla de salida que bloquee el puerto 22.
- Establecer conexión SSH a la máquina virtual antes de aplicar la regla.
- Realizar captura de la conexión correcta.
- Activar la regla.
- Comprobar que la conexión falla.
- Realizar captura del error.
- Desactivar la regla.
- Verificar que la conexión vuelve a funcionar.

5. Bloquear conexión SSH solo para una IP

- Crear una regla de salida que bloquee el puerto 22 para una IP concreta.
- Comprobar que desde esa IP no se puede conectar por SSH.
- Realizar captura.
- Cambiar la IP de origen (otra máquina o adaptador de red).
- Verificar que la conexión sí funciona

MODO DE ENTREGA
_______________________________

Realizar capturas de pantalla de todo el proceso, mostrando cada uno de los apartados y el resultado obtenido en cada prueba.

La actividad debe entregarse antes de que finalice la hora clase. Al tratarse de una actividad realizada en clase, cualquier entrega fuera de ese plazo se evaluará con una puntuación máxima de 5.
