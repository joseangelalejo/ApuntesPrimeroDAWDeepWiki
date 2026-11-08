# Actividad 22 - Modelos OSI - Tabla de protocolos | José Ángel Alejo

> **Nombra y explica muy brevemente cuales son las capas del modelo OSI**, diferencias con el modelo TCP/IP

- Capa 1: Capa física - Se encarga de la transmisión de bits a través de un medio físico.
- Capa 2: Capa de enlace de datos - Proporciona la transferencia de datos entre dos dispositivos en la misma red local, utilizando direcciones MAC.
- Capa 3: Capa de red - Se encarga del enrutamiento de los paquetes de datos a través de diferentes redes, utilizando direcciones IP.
- Capa 4: Capa de transporte - Proporciona la transferencia de datos entre dispositivos en diferentes redes, utilizando protocolos como TCP y UDP.
- Capa 5: Capa de sesión - Establece, mantiene y termina las sesiones de comunicación entre aplicaciones.
- Capa 6: Capa de presentación - Se encarga de la traducción de datos, la compresión y el cifrado.
- Capa 7: Capa de aplicación - Proporciona servicios de red a las aplicaciones del usuario, como correo electrónico, navegación web, etc.

> **Diferencias con el modelo TCP/IP:**

- El modelo OSI tiene 7 capas, mientras que el modelo TCP/IP tiene 4 capas (Capa de aplicación, Capa de transporte, Capa de Internet, Capa de enlace).
- El modelo OSI es un modelo teórico que se utiliza para entender y diseñar redes, mientras que el modelo TCP/IP es un modelo práctico que se utiliza en la mayoría de las redes actuales.
- El modelo OSI es más detallado y específico en cuanto a las funciones de cada capa, mientras que el modelo TCP/IP es más general y flexible.

> **Asigna los siguientes eventos a la capa correspondiente del modelo OSI: ordénalos de nivel 7 a nivel 1**

- Capa 7 — Aplicación: Gmail usa SMTP (Simple Mail Transfer Protocol) para enviar el correo al servidor de correo de Google.
- Capa 7 — Aplicación: El correo es convertido a un formato estándar (MIME) para que cualquier sistema pueda leerlo.
- Capa 5 — Sesión: Se establece y mantiene la comunicación entre el servidor de correo de Gmail y el servidor de Outlook.
- Capa 4 — Transporte: Se usa el protocolo TCP para dividir el correo en pequeños segmentos de datos.
- Capa 3 — Red: Un router decide la mejor ruta para enviar los paquetes del correo a Outlook.
- Capa 2 — Enlace de datos: Se usan direcciones MAC para asegurarse de que los datos lleguen correctamente a cada dispositivo en la red local.
- Capa 1 — Física: Los datos del correo son convertidos en señales eléctricas (Ethernet) o en ondas de radio (WiFi).

> **Dados los siguientes protocolos, crea una tabla donde expliques que hace cada protocolo y en la capa que se ejecuta: TCP, UDP, IP, ICMP, HTTPS, FTP, SFTP, TFTP, DNS**

| PROTOCOLO | FUNCIÓN                                                                                                                                                                                                          | CAPA DE EJECUCIÓN |
|:---------:|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|:-----------------:|
|  **TCP**  | Protocolo orientado a conexión que garantiza la entrega de datos en orden y sin errores, funciona dividiendo el paquete en muchos paquetes menores llamados "paquetes", conteniendo cada uno fragmentos de datos |      Capa 4       |
|  **UDP**  | Protocolo sin conexión que ofrece entrega rápida pero no garantiza la entrega de datos                                                                                                                           |      Capa 4       |
|  **IP**   | Conjunto central de TCP/IP, proporciona mecanismos de direccionamiento y enrutamiento necesarios para entrega de paquetes de datos a través de redes                                                             |      Capa 3       |
| **ICMP**  | Protocolo de control de mensajes de Internet que se usa para enviar mensajes de error y para diagnosticar problemas en la red                                                                                    |      Capa 3       |
| **HTTPS** | "Protocolo de capa de aplicación", establece la conexión entre navegadores web y servidores y también se utiliza para otros fines, tiene cuatro capas: Aplicación, Transporte, Internet, Enlace (etc)            |      Capa 7       |
|  **FTP**  | Hay varios tipos, FTPS en concreto proporciona transferencia segura de archivos mediante cifrado de datos, de manera que no sean interceptados o manipulados durante el tránsito                                 |      Capa 7       |
| **SFTP**  | Protocolo seguro de transferencia de archivos que utiliza SSH para cifrar los datos durante la transferencia                                                                                                     |      Capa 7       |
| **TFTP**  | Protocolo de transferencia de archivos simple que no incluye autenticación ni cifrado, usado principalmente para transferencias rápidas y sencillas en redes locales                                             |      Capa 7       |
|  **DNS**  | Protocolo que traduce nombres de dominio legibles por humanos en direcciones IP                                                                                                                                  |      Capa 7       |
