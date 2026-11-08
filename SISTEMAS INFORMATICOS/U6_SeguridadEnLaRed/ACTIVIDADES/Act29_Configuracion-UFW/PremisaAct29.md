# Actividad 29: actividad: configuración de firewall con ufw

Antes de comenzar la actividad, es obligatorio eliminar todas las reglas existentes de iptables para evitar conflictos con ufw:

- iptables -F
- iptables -X

A continuación, realiza las siguientes tareas y adjunta captura de pantalla de cada una de ellas:

1. bloquear todo el tráfico entrante en el sistema usando ufw.
2. permitir todo el tráfico entrante en el sistema usando ufw.
3. bloquear el acceso al puerto 22 (ssh) en el equipo.
4. permitir únicamente el acceso al puerto 80 (http).
5. bloquear el acceso a un puerto específico indicado.
6. permitir el acceso a un puerto específico indicado.
7. bloquear el tráfico procedente de una dirección ip concreta.
8. permitir el tráfico únicamente desde una dirección ip concreta.
9. bloquear el tráfico de una red completa (por ejemplo 192.168.1.0/24).
10. bloquear un rango específico de direcciones ip (investigar cómo hacerlo en ufw).
11. permitir únicamente el tráfico https (puerto 443) y bloquear el resto.
12. bloquear todo el tráfico saliente del equipo.
13. permitir únicamente el tráfico saliente hacia una ip concreta.
14. bloquear el acceso a un servicio usando protocolo udp.
15. permitir tráfico solo por protocolo tcp.
16. limitar el número de conexiones a un servicio (por ejemplo ssh).
17. eliminar una regla concreta previamente creada.
18. listar todas las reglas activas en el sistema.
19. modificar una regla existente eliminándola y creando una nueva.
20. bloquear el acceso a una página web concreta mediante su dirección ip.
