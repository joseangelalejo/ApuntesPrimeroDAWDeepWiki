# U6 — Seguridad en la Red
### Módulo: Sistemas Informáticos · 1º DAW

---

## Índice

1. [Conceptos Fundamentales](#1-conceptos-fundamentales)
   - 1.1 Qué es un Firewall
   - 1.2 Concepto de Puerto
   - 1.3 Puertos importantes a memorizar
2. [Firewall en Windows (Defender)](#2-firewall-en-windows-defender)
   - 2.1 Perfiles de red
   - 2.2 Tipos de reglas
   - 2.3 Casos prácticos (Actividad 24)
3. [Firewall en Linux: iptables](#3-firewall-en-linux-iptables)
   - 3.1 Estructura: tablas y cadenas
   - 3.2 Políticas por defecto
   - 3.3 Sintaxis general
   - 3.4 Comandos esenciales (Actividad 25 completa)
4. [Firewall en Linux: ufw](#4-firewall-en-linux-ufw)
   - 4.1 Qué es ufw y por qué usarlo
   - 4.2 Comandos esenciales (Actividad 29 completa)
   - 4.3 Conflicto iptables + ufw
5. [Servidor Proxy con Squid](#5-servidor-proxy-con-squid)
   - 5.1 Tipos de proxy
   - 5.2 Instalación y configuración base
   - 5.3 ACLs: definición y aplicación
   - 5.4 Reglas de filtrado completas (Actividad 30)
6. [Referencia rápida y errores comunes](#6-referencia-rápida-y-errores-comunes)

---

## 1. Conceptos Fundamentales

### 1.1 Qué es un Firewall

Un **cortafuegos** es un elemento de seguridad (hardware o software) que controla, filtra y determina qué flujos de tráfico están autorizados a **entrar o salir** de una red o sistema. Funciona evaluando un conjunto de reglas preestablecidas.

Dos estrategias opuestas:

| Estrategia       | Política por defecto      | Filosofía                                    |
|------------------|---------------------------|----------------------------------------------|
| **Lista blanca** | `DROP` (todo bloqueado)   | Solo se permite lo explícitamente autorizado |
| **Lista negra**  | `ACCEPT` (todo permitido) | Solo se bloquea lo explícitamente prohibido  |

> En entornos de producción se recomienda la **lista blanca**: más seguro aunque requiere más configuración inicial.

### 1.2 Concepto de Puerto

Un puerto es un identificador numérico (0–65535) que permite distinguir qué servicio está usando la red. Es como una "puerta" por la que entra o sale tráfico.

| Rango       | Nombre                     | Descripción                                      |
|-------------|----------------------------|--------------------------------------------------|
| 0–1023      | Puertos bien conocidos     | Servicios estándar del sistema (HTTP, SSH, FTP…) |
| 1024–49151  | Puertos registrados        | Aplicaciones comunes (MySQL, servidores…)        |
| 49152–65535 | Puertos dinámicos/privados | Usados temporalmente por clientes                |

### 1.3 Puertos importantes a memorizar

| Puerto   | Protocolo | Servicio                        |
|----------|-----------|---------------------------------|
| **22**   | TCP       | SSH — acceso remoto seguro      |
| **53**   | UDP/TCP   | DNS — resolución de nombres     |
| **80**   | TCP       | HTTP — web sin cifrar           |
| **443**  | TCP       | HTTPS — web cifrada             |
| **21**   | TCP       | FTP — transferencia de archivos |
| **3306** | TCP       | MySQL — base de datos           |
| **3389** | TCP       | RDP — escritorio remoto Windows |

---

## 2. Firewall en Windows (Defender)

**Acceso:** Panel de Control → Sistema y Seguridad → Firewall de Windows Defender → Configuración Avanzada

O directamente buscando "Firewall de Windows Defender con seguridad avanzada" en el menú de inicio.

### 2.1 Perfiles de red

Windows aplica diferentes conjuntos de reglas según el contexto de conexión:

| Perfil      | Contexto                                                |
|-------------|---------------------------------------------------------|
| **Dominio** | Redes corporativas vinculadas a Active Directory        |
| **Privado** | Redes de hogar o de confianza                           |
| **Público** | Redes abiertas de alto riesgo (aeropuertos, cafeterías) |

### 2.2 Tipos de reglas

- **Reglas de entrada** — controlan el tráfico que llega al equipo desde la red
- **Reglas de salida** — controlan el tráfico que sale del equipo hacia la red
- **Por programa** — bloquea o permite un ejecutable concreto (sin necesidad de conocer sus puertos)
- **Por puerto** — bloquea o permite un puerto TCP/UDP específico

### 2.3 Casos prácticos (Actividad 24)

#### Bloquear una aplicación (regla de salida por programa)

1. Firewall con seguridad avanzada → **Reglas de salida** → Nueva regla
2. Tipo: **Programa** → Ruta del ejecutable (ej. `chrome.exe`)
3. Acción: **Bloquear la conexión**
4. Aplicar a todos los perfiles

#### Bloquear puertos 80 y 443 (navegación web)

1. Nueva regla de salida → Tipo: **Puerto**
2. Protocolo: TCP → Puertos específicos: `80, 443`
3. Acción: Bloquear

#### Bloquear puerto 22 (SSH)

1. Nueva regla de salida → Tipo: **Puerto**
2. Protocolo: TCP → Puerto: `22`
3. Acción: Bloquear

#### Bloquear SSH solo para una IP concreta

1. Nueva regla de salida → Puerto TCP `22`
2. En el paso de **Ámbito**: especificar la IP de destino o de origen
3. Esto permite que otras IPs sigan usando SSH

> **Truco de examen:** Fíjate bien si te piden regla de **entrada** o de **salida**. Bloquear la salida al puerto 22 impide que **tu equipo** inicie conexiones SSH. Bloquear la entrada al puerto 22 impide que te **conecten** a ti.

---

## 3. Firewall en Linux: iptables

`iptables` es la herramienta clásica que permite configurar las tablas del framework **Netfilter** del kernel de Linux.

### 3.1 Estructura: tablas y cadenas

La tabla por defecto es `filter`, con tres cadenas:

```
INTERNET
    │
    ▼
┌─────────────────────────────────────────┐
│              Netfilter (kernel)          │
│                                          │
│  INPUT ← paquetes hacia esta máquina     │
│  OUTPUT → paquetes desde esta máquina    │
│  FORWARD → paquetes que pasan por aquí  │
└─────────────────────────────────────────┘
```

| Cadena      | Tráfico que controla                                 |
|-------------|------------------------------------------------------|
| **INPUT**   | Paquetes destinados a la propia máquina              |
| **OUTPUT**  | Paquetes generados por la máquina local              |
| **FORWARD** | Paquetes enrutados a través del equipo (modo router) |

### 3.2 Políticas por defecto

```bash
sudo iptables -P INPUT DROP    # Todo entrante bloqueado por defecto (lista blanca)
sudo iptables -P INPUT ACCEPT  # Todo entrante permitido por defecto (lista negra)
sudo iptables -P OUTPUT DROP   # Todo saliente bloqueado por defecto
```

> ⚠️ **Crítico:** Si pones `iptables -P INPUT DROP` en una conexión SSH remota sin haber añadido antes la regla `ESTABLISHED,RELATED`, perderás el acceso. **Siempre añade esta regla primero:**
>
> ```bash
> sudo iptables -A INPUT -m conntrack --ctstate ESTABLISHED,RELATED -j ACCEPT
> ```

### 3.3 Sintaxis general

```
iptables [-t tabla] COMANDO cadena [opciones] -j ACCIÓN
```

| Parámetro         | Opciones principales                                                                                                                    |
|-------------------|-----------------------------------------------------------------------------------------------------------------------------------------|
| Comando           | `-A` (append/añadir), `-D` (delete/borrar), `-R` (replace/reemplazar), `-P` (policy/política), `-L` (list/listar), `-F` (flush/limpiar) |
| Cadena            | `INPUT`, `OUTPUT`, `FORWARD`                                                                                                            |
| Opciones filtrado | `-s IP` (origen), `-d IP` (destino), `-p tcp/udp` (protocolo), `--dport N` (puerto destino), `--sport N` (puerto origen)                |
| Acción            | `ACCEPT`, `DROP`, `REJECT`                                                                                                              |

### 3.4 Comandos esenciales (Actividad 25 completa)

#### Políticas globales

```bash
# 1. Bloquear TODO el tráfico entrante
sudo iptables -P INPUT DROP

# 2. Permitir TODO el tráfico entrante
sudo iptables -P INPUT ACCEPT

# 12. Bloquear TODO el tráfico saliente
sudo iptables -P OUTPUT DROP
```

#### Reglas por puerto

```bash
# 3. Bloquear SSH (puerto 22)
sudo iptables -A INPUT -p tcp --dport 22 -j DROP

# 4. Permitir SOLO el puerto 80 (HTTP)
sudo iptables -A INPUT -p tcp --dport 80 -j ACCEPT

# 5. Bloquear un puerto específico (ej. 8080)
sudo iptables -A INPUT -p tcp --dport 8080 -j DROP

# 6. Permitir un puerto específico (ej. 3306 MySQL)
sudo iptables -A INPUT -p tcp --dport 3306 -j ACCEPT

# 11. Permitir SOLO HTTPS y bloquear el resto
sudo iptables -A INPUT -p tcp --dport 443 -j ACCEPT
sudo iptables -P INPUT DROP

# 14. Bloquear un servicio UDP (ej. DNS puerto 53)
sudo iptables -A INPUT -p udp --dport 53 -j DROP

# 15. Permitir solo protocolo TCP (bloquear UDP)
sudo iptables -A INPUT -p udp -j DROP
```

#### Reglas por IP/red

```bash
# 7. Bloquear tráfico de una IP concreta
sudo iptables -A INPUT -s 192.168.1.50 -j DROP

# 8. Permitir tráfico SOLO desde una IP concreta
sudo iptables -P INPUT DROP
sudo iptables -A INPUT -s 192.168.1.50 -j ACCEPT

# 9. Bloquear una red completa
sudo iptables -A INPUT -s 192.168.1.0/24 -j DROP

# 10. Bloquear un rango de IPs (módulo iprange)
sudo iptables -A INPUT -m iprange --src-range 192.168.1.50-192.168.1.100 -j DROP

# 13. Permitir tráfico saliente SOLO hacia una IP concreta
sudo iptables -P OUTPUT DROP
sudo iptables -A OUTPUT -d 8.8.8.8 -j ACCEPT

# 20. Bloquear acceso a una web por su IP
sudo iptables -A OUTPUT -d 157.240.221.35 -j DROP
```

#### Reglas avanzadas

```bash
# 16. Limitar conexiones (anti fuerza bruta, ej. max 3 SSH/minuto)
sudo iptables -A INPUT -p tcp --dport 22 -m limit --limit 3/minute -j ACCEPT

# Mantener conexiones ya establecidas (IMPRESCINDIBLE con política DROP)
sudo iptables -A INPUT -m conntrack --ctstate ESTABLISHED,RELATED -j ACCEPT
```

#### Gestión de reglas

```bash
# 18. Listar todas las reglas con números de línea
sudo iptables -L -n -v --line-numbers

# 17. Eliminar una regla por su número de línea
sudo iptables -D INPUT 3

# 19. Reemplazar una regla existente (no se edita, se reemplaza)
sudo iptables -R INPUT 1 -s 192.168.1.200 -j DROP

# Limpiar TODAS las reglas
sudo iptables -F   # vacía las cadenas
sudo iptables -X   # elimina cadenas personalizadas
```

---

## 4. Firewall en Linux: ufw

`ufw` (Uncomplicated Firewall) es una interfaz simplificada sobre `iptables`. No tienes que memorizar flags complejos: usa comandos en lenguaje natural.

### 4.1 Qué es ufw y por qué usarlo

- Es una **capa sobre iptables**, no un sistema distinto
- Ideal para configuraciones cotidianas sin complejidad de bajo nivel
- Trabaja con **políticas por defecto** + **reglas específicas**
- Política recomendada: `deny incoming` + `allow outgoing` (salvo que necesites restricción total)

> ⚠️ **Antes de activar ufw**, limpia las reglas de iptables para evitar conflictos:
>
> ```bash
> sudo iptables -F
> sudo iptables -X
> ```

### 4.2 Comandos esenciales (Actividad 29 completa)

#### Activación y estado

```bash
sudo ufw enable              # Activar el firewall
sudo ufw disable             # Desactivar el firewall
sudo ufw status verbose      # Ver estado y reglas en detalle
sudo ufw status numbered     # Ver reglas con numeración
sudo ufw reset               # Restablecer configuración por defecto
ufw --version                # Ver versión instalada
```

#### Políticas globales

```bash
# 1. Bloquear TODO el tráfico entrante
sudo ufw default deny incoming

# 2. Permitir TODO el tráfico entrante
sudo ufw default allow incoming

# 12. Bloquear TODO el tráfico saliente
sudo ufw default deny outgoing

# Al bloquear toda la salida, permite DNS para que internet funcione:
sudo ufw allow out 53
```

#### Reglas por puerto

```bash
# 3. Bloquear SSH
sudo ufw deny 22/tcp

# 4. Permitir HTTP
sudo ufw allow 80/tcp

# 5. Bloquear un puerto específico (ej. 8080)
sudo ufw deny 8080/tcp

# 6. Permitir un puerto específico (ej. 3306)
sudo ufw allow 3306/tcp

# 11. Permitir solo HTTPS
sudo ufw default deny incoming
sudo ufw allow 443/tcp

# 14. Bloquear un servicio UDP (ej. DNS)
sudo ufw deny 53/udp

# 15. Permitir solo TCP (bloquear UDP genérico)
sudo ufw deny proto udp from any to any
```

#### Reglas por IP/red

```bash
# 7. Bloquear una IP concreta
sudo ufw deny from 192.168.1.50

# 8. Permitir solo desde una IP concreta
sudo ufw default deny incoming
sudo ufw allow from 192.168.1.50

# 9. Bloquear una red completa
sudo ufw deny from 192.168.1.0/24

# 10. Bloquear un rango de IPs (ufw no tiene --src-range nativo, se hace con iptables o múltiples reglas)
# Opción: usar iptables directamente para el rango
sudo iptables -A INPUT -m iprange --src-range 192.168.1.50-192.168.1.100 -j DROP

# 13. Permitir salida solo hacia una IP concreta
sudo ufw default deny outgoing
sudo ufw allow out to 8.8.8.8

# 20. Bloquear acceso a web por IP
sudo ufw deny out to 157.240.221.35
```

#### Reglas avanzadas

```bash
# Permitir IP a puerto concreto (ej. solo esa IP puede entrar por SSH)
sudo ufw allow from 192.168.1.100 to any port 22 proto tcp

# 16. Limitar conexiones (rate limiting integrado en ufw)
sudo ufw limit ssh    # permite SSH pero limita intentos de fuerza bruta
```

#### Gestión de reglas

```bash
# 17. Eliminar regla por número de índice
sudo ufw delete 2

# Eliminar regla por comando original
sudo ufw delete allow 22

# 19. Modificar una regla: se borra y se crea de nuevo
sudo ufw delete deny 22/tcp
sudo ufw allow 22/tcp
```

### 4.3 Conflicto iptables + ufw

Ambas herramientas trabajan sobre el mismo framework Netfilter. Las reglas se evalúan **de arriba hacia abajo** y se aplica la **primera coincidencia**. Si hay un `DROP` de iptables antes de un `allow` de ufw, el DROP gana. En la práctica:

> **Usa solo una herramienta a la vez.** Si cambias a ufw, limpia iptables primero con `iptables -F && iptables -X`.

---

## 5. Servidor Proxy con Squid

Un servidor proxy actúa como **intermediario** entre los clientes de la red local e Internet. Opera en la **capa de aplicación** (capa 7).

### 5.1 Tipos de proxy

| Tipo                  | Descripción                                                 | Ejemplo de uso                        |
|-----------------------|-------------------------------------------------------------|---------------------------------------|
| **Transparente**      | Intercepta el tráfico sin que el usuario lo configure       | ISP, empresas grandes                 |
| **Directo (Forward)** | Entre clientes e Internet: controla lo que pueden visitar   | Instituto, empresa (bloquear YouTube) |
| **Inverso (Reverse)** | Entre Internet y los servidores: protege y distribuye carga | Amazon, grandes sitios web            |

- **Funciones principales de Squid:**
  - **Filtrado y seguridad** — controlar a qué recursos acceden los usuarios
  - **Caché** — guardar copias locales de páginas visitadas (ahorra ancho de banda)
  - **Logging** — registrar qué páginas visita cada IP para auditoría

### 5.2 Instalación y configuración base

```bash
# Instalar Squid
sudo apt install squid

# Editar configuración
sudo nano /etc/squid/squid.conf

# Reiniciar servicio tras cambios
sudo systemctl restart squid

# Verificar estado
sudo systemctl status squid
```

**Configuración mínima funcional** en `/etc/squid/squid.conf`:

```
http_port 3128                          # puerto de escucha del proxy

acl red_local src 192.168.1.0/24        # definir la red local

http_access allow red_local             # permitir acceso a la red local
http_access deny all                    # denegar el resto
```

- **Configuración del cliente (Windows):**
  - Configuración → Red e Internet → Proxy
  - Servidor: IP del equipo con Squid · Puerto: `3128`

### 5.3 ACLs: definición y aplicación

- Servidor: IP del equipo con Squid · Puerto: `3128`  - Servidor: IP del equipo con Squid · Puerto: `3128`

Squid usa **ACLs** para definir criterios y **`http_access`** para aplicar acciones.

```
acl  <nombre>  <tipo>  <valor>          ← define el criterio
http_access  allow|deny  <nombre>       ← aplica la acción
```

> **Regla de oro de Squid:** las reglas se evalúan **de arriba hacia abajo** y se aplica la **primera coincidencia**. Las excepciones específicas van **antes** que los bloqueos generales.

#### Tipos de ACL disponibles

| Tipo de ACL              | Sintaxis                                         | Descripción                                                 |
|--------------------------|--------------------------------------------------|-------------------------------------------------------------|
| Por IP origen            | `acl nombre src 192.168.1.50`                    | IP o red de origen del cliente                              |
| Por dominio destino      | `acl nombre dstdomain .facebook.com`             | Dominio al que accede (el `.` incluye subdominios)          |
| Por regex en URL         | `acl nombre url_regex -i casino apuestas`        | Palabras clave en la URL (insensible a mayúsculas con `-i`) |
| Por extensión de archivo | `acl nombre urlpath_regex -i \.(exe\|msi\|bat)$` | Bloqueo de descargas por extensión                          |
| Por horario              | `acl nombre time MTWHF 08:00-14:00`              | Restricción temporal                                        |

**Códigos de días para ACL horaria:**
`M` = Monday (lunes), `T` = Tuesday (martes), `W` = Wednesday (miércoles), `H` = tHursday (jueves), `F` = Friday (viernes), `A` = sAturday (sábado), `S` = Sunday (domingo)

### 5.4 Reglas de filtrado completas (Actividad 30)

```squid
http_port 3128

# ── DEFINICIÓN DE ACLs ──────────────────────────────────

# Redes
acl red_local          src 192.168.1.0/24
acl cliente_bloqueado  src 192.168.1.50

# Dominios específicos
acl facebook           dstdomain .facebook.com
acl instagram          dstdomain .instagram.com
acl web_permitida      dstdomain www.facebook.com

# Palabras clave en URLs (regex, insensible a mayúsculas)
acl palabras_url       url_regex -i casino apuestas juegos foro

# Extensiones de archivo bloqueadas
acl ejecutables        urlpath_regex -i \.(exe|msi|bat|cmd|com)$

# Restricción horaria: días laborables 08:00-14:00
acl horario_bloqueo    time MTWHF 08:00-14:00

# ── POLÍTICAS DE ACCESO (orden crítico) ─────────────────

# 1. Bloquear completamente a una IP problemática
http_access deny cliente_bloqueado

# 2. Excepción: permitir una página concreta del dominio bloqueado
http_access allow web_permitida

# 3. Bloquear redes sociales
http_access deny facebook
http_access deny instagram

# 4. Bloquear URLs con palabras de ocio
http_access deny palabras_url

# 5. Bloquear descargas de ejecutables
http_access deny ejecutables

# 6. Bloquear en franja horaria laboral
http_access deny horario_bloqueo

# 7. Permitir la navegación al resto de la red local
http_access allow red_local

# 8. Denegar todo lo demás (siempre al final)
http_access deny all
```

---

## 6. Referencia rápida y errores comunes

### Tabla comparativa iptables vs ufw

| Tarea                 | iptables                                        | ufw                         |
|-----------------------|-------------------------------------------------|-----------------------------|
| Activar               | (siempre activo en kernel)                      | `ufw enable`                |
| Política DROP entrada | `iptables -P INPUT DROP`                        | `ufw default deny incoming` |
| Permitir puerto 80    | `iptables -A INPUT -p tcp --dport 80 -j ACCEPT` | `ufw allow 80/tcp`          |
| Bloquear IP           | `iptables -A INPUT -s 1.2.3.4 -j DROP`          | `ufw deny from 1.2.3.4`     |
| Listar reglas         | `iptables -L -n -v --line-numbers`              | `ufw status numbered`       |
| Borrar regla          | `iptables -D INPUT 3`                           | `ufw delete 2`              |
| Limpiar todo          | `iptables -F && iptables -X`                    | `ufw reset`                 |

### Errores comunes de examen

| Error                                                        | Causa                                              | Solución                                                                                         |
|--------------------------------------------------------------|----------------------------------------------------|--------------------------------------------------------------------------------------------------|
| Me quedo sin acceso SSH al poner `DROP`                      | No añadí la regla `ESTABLISHED,RELATED` antes      | Siempre añadir primero: `iptables -A INPUT -m conntrack --ctstate ESTABLISHED,RELATED -j ACCEPT` |
| ufw no hace efecto aunque añado la regla                     | Hay reglas previas de iptables que coinciden antes | Limpiar iptables: `iptables -F && iptables -X` antes de usar ufw                                 |
| En Squid, nadie puede navegar aunque puse `allow red_local`  | El `deny all` está antes del `allow red_local`     | Las reglas permisivas van **después** de los bloqueos específicos, antes del `deny all` final    |
| Bloqueo `.facebook.com` pero permite `www.facebook.com`      | Usé `dstdomain facebook.com` sin el punto          | Con punto (`.facebook.com`) incluye todos los subdominios                                        |
| Tráfico saliente bloqueado con ufw pero internet no funciona | Bloqueé la salida sin abrir DNS                    | Añadir: `ufw allow out 53` para la resolución de nombres                                         |

---

> **Consejo de examen práctico:** En iptables el orden importa: pon `ESTABLISHED,RELATED` primero. En Squid, pon siempre las excepciones específicas antes del bloqueo genérico, y `http_access deny all` al final. En ufw, limpia iptables antes de empezar.
