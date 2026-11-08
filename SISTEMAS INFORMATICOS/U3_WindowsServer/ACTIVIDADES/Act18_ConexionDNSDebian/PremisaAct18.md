# Actividad 18: Instalación y despliegue de un servidor web con resolución de nombres

Instalar y configurar un servidor web Apache2 en Linux, desplegar una página HTML propia,
configurar un dominio local y habilitar la resolución de nombres mediante dnsmasq.

1. Instalar el servidor web Apache2.
2. Comprobar que el servicio Apache2 está activo y en ejecución.
3. Crear y desplegar una página HTML propia en el servidor.
4. Configurar un dominio local para acceder a la página desde el navegador.
5. Instalar y configurar dnsmasq como servidor DNS local.
6. Verificar la correcta resolución del dominio configurado.

- Acceso a la página web desde el navegador usando el dominio configurado.
- Estado correcto del servicio Apache2.
- Estado correcto del servicio dnsmasq.

La entrega consistirá en 3 capturas de pantalla:

1. Captura del navegador mostrando la página HTML cargada usando el dominio configurado.
2. Captura del resultado del comando:
   systemctl status apache2
3. Captura del resultado del comando:
   systemctl status dnsmasq
