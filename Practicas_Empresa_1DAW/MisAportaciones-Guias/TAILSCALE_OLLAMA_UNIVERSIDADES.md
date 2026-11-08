# ◆ Tailscale Funnel + Ollama — Guía para Universidades

⚠ **IMPORTANTE:** Este documento contiene ejemplos con placeholders. Reemplaza `TU_*`, `100.x.x.x` y `tailXXXX` con tus valores reales antes de usar en producción.

Guía completa para exponer un servidor **Ollama** (IA local) a través de **Tailscale Funnel**, permitiendo que universidades alemanas accedan de forma segura sin necesidad de VPN manual.

**Caso de uso:** Plataforma ILIAS con pruebas de IA (`SurAgent`) accesible desde cualquier institución educativa sin configuración complicada.

---

## ▬ Tabla de contenidos

- [◆ Tailscale Funnel + Ollama — Guía para Universidades](#-tailscale-funnel--ollama--guía-para-universidades)
  - [▬ Tabla de contenidos](#-tabla-de-contenidos)
  - [¿Qué es Tailscale Funnel?](#qué-es-tailscale-funnel)
  - [✓ Requisitos](#-requisitos)
  - [★ Arquitectura general](#-arquitectura-general)
  - [■ Instalación de Tailscale](#-instalación-de-tailscale)
    - [1. Instalar en Arch Linux](#1-instalar-en-arch-linux)
    - [2. Instalar en Debian/Ubuntu](#2-instalar-en-debianubuntu)
    - [3. Iniciar sesión en Tailscale](#3-iniciar-sesión-en-tailscale)
  - [⚙ Configuración en servidor (3 opciones)](#-configuración-en-servidor-3-opciones)
    - [Opción 1: Exponer Ollama directamente (Recomendado)](#opción-1-exponer-ollama-directamente-recomendado)
      - [1.1 Instalar Ollama](#11-instalar-ollama)
      - [1.2 Descargar modelo (primer uso)](#12-descargar-modelo-primer-uso)
      - [1.3 Habilitar Funnel en puerto 11434](#13-habilitar-funnel-en-puerto-11434)
      - [1.4 Verificar configuracion](#14-verificar-configuracion)
        - [**¡Hecho!** Ollama está públicamente accesible en](#hecho-ollama-está-públicamente-accesible-en)
    - [Opción 2: Proxy personalizado (Con autenticación)](#opción-2-proxy-personalizado-con-autenticación)
      - [2.1 Crear un proxy Node.js simple](#21-crear-un-proxy-nodejs-simple)
      - [2.2 Configurar variables de entorno](#22-configurar-variables-de-entorno)
      - [2.3 Exponer por Funnel](#23-exponer-por-funnel)
      - [2.4 Uso desde universidades](#24-uso-desde-universidades)
    - [Opción 3: Docker + Ollama](#opción-3-docker--ollama)
      - [3.1 Docker Compose](#31-docker-compose)
      - [3.2 Iniciar servicios](#32-iniciar-servicios)
      - [3.3 Descargar modelos dentro del contenedor](#33-descargar-modelos-dentro-del-contenedor)
      - [3.4 Habilitar Funnel](#34-habilitar-funnel)
  - [⚠ Seguridad y control de acceso](#-seguridad-y-control-de-acceso)
    - [1. Activar ACLs (Access Control Lists) en Tailscale](#1-activar-acls-access-control-lists-en-tailscale)
    - [2. Rate limiting (si usas proxy personalizado)](#2-rate-limiting-si-usas-proxy-personalizado)
    - [3. Monitoreo de acceso](#3-monitoreo-de-acceso)
  - [◊ Configuración en cliente (Universidades)](#-configuración-en-cliente-universidades)
    - [Para desarrolladores / integración con ILIAS](#para-desarrolladores--integración-con-ilias)
      - [1. Instalación de Tailscale en máquina local (opcional)](#1-instalación-de-tailscale-en-máquina-local-opcional)
      - [2. Acceso directo desde navegador o aplicación](#2-acceso-directo-desde-navegador-o-aplicación)
      - [3. Desde Python](#3-desde-python)
      - [4. Desde cURL (testing rápido)](#4-desde-curl-testing-rápido)
  - [◉ Pruebas de conexión](#-pruebas-de-conexión)
    - [Checklist de verificación](#checklist-de-verificación)
    - [Test desde universidad (machine remota)](#test-desde-universidad-machine-remota)
  - [⚒ Variables de entorno](#-variables-de-entorno)
  - [■ Monitoreo y logs](#-monitoreo-y-logs)
    - [Ver estado de Funnel en tiempo real](#ver-estado-de-funnel-en-tiempo-real)
    - [Monitorar Ollama](#monitorar-ollama)
    - [Estadísticas de acceso](#estadísticas-de-acceso)
  - [✗ Troubleshooting](#-troubleshooting)
    - [✗ Error: "Connection refused" desde universidad](#-error-connection-refused-desde-universidad)
    - [✗ Error: "Certificate error" (HTTPS)](#-error-certificate-error-https)
    - [✗ Error: "Too many requests" (Rate limiting)](#-error-too-many-requests-rate-limiting)
    - [✗ Ollama lento o "timeout"](#-ollama-lento-o-timeout)
    - [✗ Funnel se desactiva solo](#-funnel-se-desactiva-solo)
  - [✎ Casos de uso prácticos](#-casos-de-uso-prácticos)
    - [Caso 1: ILIAS + SurAgent con Ollama](#caso-1-ilias--suragent-con-ollama)
    - [Caso 2: API REST personal para investigadores](#caso-2-api-rest-personal-para-investigadores)
    - [Caso 3: Batch processing para análisis de datos](#caso-3-batch-processing-para-análisis-de-datos)
  - [⚠ Cuándo NO usar Tailscale Funnel](#-cuándo-no-usar-tailscale-funnel)
  - [★ Conclusión](#-conclusión)

---

## ¿Qué es Tailscale Funnel?

**Tailscale Funnel** es una característica que permite exponer un servidor local a internet de forma segura, sin necesidad de:

- ✖ Abrir puertos en router
- ✖ Comprar IP estática
- ✖ Configurar DNS dinámico
- ✖ Instalar certificados SSL manually

**Ventajas:**

- ✓ **Certificado SSL automático** — Renovación automática  
- ✓ **Acceso público** — Tu servidor accesible desde cualquier lugar  
- ✓ **Seguridad** — Cifrado end-to-end, detrás de firewall Tailscale  
- ✓ **FQDN estable** — URL consistente como `tu-servidor.tailXXXX.ts.net`  
- ✓ **Fácil de configurar** — Solo 2-3 comandos  

---

## ✓ Requisitos

- **En el servidor (tu homelab):**
  - Linux (Debian, Arch, RHEL, etc.)
    - Compatible con Tailscale y Ollama, se recomienda Linux sin interfaz gráfica por rendimiento (por ejemplo dietpi, basado en Debian).
    - Ajustar el modelo lo máximo posible a las necesidades para evitar sobrecarga. Modelos como `llama2:7b` o `mistral:7b` son buenas opciones para empezar.
    - Para generación de imágenes, se recomienda usar modelos ligeros o específicos para esa tarea (como `dall-e`), y asegurarse de tener suficiente GPU/RAM o menos ligeros pero más avanzados como Stable Diffusion 2.1 (API compatible con Ollama).
  - Ollama instalado y corriendo
  - Tailscale instalado
  - Puerto disponible (por defecto `11434` para Ollama)
  - Conexión a internet estable

- **En cliente (universidades):**
  - Navegador web moderno
  - Conexión a internet

---

## ★ Arquitectura general

```
┌─────────────────────────────────────────────────────────┐
│ UNIVERSIDAD (Alemania)                                  │
│ ┌──────────────────────────────────────┐                │
│ │ Browser / Application                │                │
│ │ → HTTPS request                      │                │
│ │ Latencia esperada: <100ms ↓          │                │
│ └────────────┬─────────────────────────┘                │
│              │                                           │
└──────────────┼───────────────────────────────────────────┘
               │
               │ TAILSCALE FUNNEL
               │ (Encriptado, SSL, <100ms típico)
               │ Geo-routing automático
               │
┌──────────────▼───────────────────────────────────────────┐
│ TU SERVIDOR (Homelab, EU)                                │
│ ┌──────────────────────────────────────┐                │
│ │ Tailscale Funnel                     │                │
│ │ https://tu-servidor.tailXXXX.ts.net │                │
│ │ Respuesta: <1s                       │                │
│ └────────────┬─────────────────────────┘                │
│              │                                           │
│ ┌────────────▼─────────────────────────┐                │
│ │ Ollama API                           │                │
│ │ http://localhost:11434               │                │
│ │ Respuesta base: 50-200ms             │                │
│ └────────────┬─────────────────────────┘                │
│              │                                           │
│ ┌────────────▼─────────────────────────┐                │
│ │ Modelos de IA                        │                │
│ │ (llama, mistral, neural-chat, etc)   │                │
│ │ Generación: variable (5-30s típico)  │                │
│ └──────────────────────────────────────┘                │
│                                                          │
└──────────────────────────────────────────────────────────┘
```

---

## ■ Instalación de Tailscale

### 1. Instalar en Arch Linux

```bash
sudo pacman -S tailscale

# Habilitar en startup
sudo systemctl enable --now tailscaled

# Verifica estado
tailscale status
```

### 2. Instalar en Debian/Ubuntu

```bash
curl -fsSL https://tailscale.com/install.sh | sh

# Habilitar en startup
sudo systemctl enable --now tailscaled

# Verifica estado
tailscale status
```

### 3. Iniciar sesión en Tailscale

```bash
sudo tailscale login
```

Abre la URL que aparece, autentica con tu cuenta Tailscale y vuelve a la terminal.

```bash
# Verifica que estés conectado
tailscale status

# Output esperado:
# 100.x.x.x        tu-servidor              tu-usuario@  linux  -
```

---

## ⚙ Configuración en servidor (3 opciones)

### Opción 1: Exponer Ollama directamente (Recomendado)

**Más simple y directa.** Sin autenticación adicional.

#### 1.1 Instalar Ollama

```bash
curl -fsSL https://ollama.ai/install.sh | sh

# Verificar instalación
ollama --version
```

#### 1.2 Descargar modelo (primer uso)

```bash
# Descargar modelo ligero (3.8 GB)
ollama pull llama2:7b

# O para testing rápido (1.3 GB)
ollama pull neural-chat:latest

# Ver modelos disponibles
ollama list
```

#### 1.3 Habilitar Funnel en puerto 11434

```bash
# Verificar que Ollama está corriendo
curl http://localhost:11434/api/tags

# Si no está corriendo, inicia:
ollama serve &

# Habilitar Funnel
sudo tailscale funnel on 11434
```

#### 1.4 Verificar configuracion

```bash
# Ver estado de Funnel
tailscale funnel status

# Output esperado:
# # Funnel on:
# #     - https://tu-servidor.tailXXXX.ts.net
# 
# https://tu-servidor.tailXXXX.ts.net (Funnel on)
# |-- / proxy http://localhost:11434
```

##### **¡Hecho!** Ollama está públicamente accesible en

```
https://tu-servidor.tailXXXX.ts.net
```

---

### Opción 2: Proxy personalizado (Con autenticación)

**Más control, con autenticación basada en token.**

#### 2.1 Crear un proxy Node.js simple

Crea el archivo `ollama-proxy.ts`:

```typescript
import http from 'http';
import httpProxy from 'http-proxy';
import { config } from 'dotenv';

config();

const PORT = 3003;
const AUTH_TOKEN = process.env.OLLAMA_AUTH_TOKEN;

// Crear proxy
const proxy = httpProxy.createProxyServer({
  target: 'http://localhost:11434',
  changeOrigin: true,
});

// Servidor con autenticación
const server = http.createServer((req, res) => {
  // Verificar token en header
  const token = req.headers['authorization']?.replace('Bearer ', '');
  
  if (!token || token !== AUTH_TOKEN) {
    res.writeHead(401, { 'Content-Type': 'application/json' });
    res.end(JSON.stringify({ error: 'Unauthorized' }));
    return;
  }

  proxy.web(req, res);
});

// Manejar WebSocket (para conexiones persistentes)
server.on('upgrade', (req, socket, head) => {
  const token = req.headers['authorization']?.replace('Bearer ', '');
  
  if (!token || token !== AUTH_TOKEN) {
    socket.write('HTTP/1.1 401 Unauthorized\r\n\r\n');
    socket.destroy();
    return;
  }

  proxy.ws(req, socket, head);
});

server.listen(PORT, () => {
  console.log(`✓ Proxy Ollama en http://localhost:${PORT}`);
  console.log(`✓ Requiere token: Authorization: Bearer ${AUTH_TOKEN}`);
});

proxy.on('error', (err, req, res) => {
  console.error('Proxy error:', err);
  res.writeHead(502, { 'Content-Type': 'application/json' });
  res.end(JSON.stringify({ error: 'Bad Gateway' }));
});
```

#### 2.2 Configurar variables de entorno

En `.env`:

```env
OLLAMA_AUTH_TOKEN=TU_TOKEN_SECRETO
```

#### 2.3 Exponer por Funnel

```bash
# Instalar dependencias
npm install http-proxy dotenv

# Ejecutar proxy
tsx ollama-proxy.ts

# En otro terminal, habilitar Funnel
sudo tailscale funnel on 3003
```

#### 2.4 Uso desde universidades

```bash
# Con curl:
curl -H "Authorization: Bearer TU_TOKEN_SECRETO" \
  https://tu-servidor.tailXXXX.ts.net/api/tags
```

---

### Opción 3: Docker + Ollama

**Para reproducibilidad y fácil deployment.**

#### 3.1 Docker Compose

```yaml
version: '3.9'

services:
  ollama:
    image: ollama/ollama:latest
    container_name: ollama-server
    restart: unless-stopped
    volumes:
      - ollama_data:$HOME/.ollama
    ports:
      - '11434:11434'
    environment:
      - OLLAMA_NUM_GPU=1  # Si tienes GPU
    networks:
      - overlay

  # (Opcional) Proxy con autenticación
  ollama-proxy:
    build:
      context: .
      dockerfile: Dockerfile.proxy
    container_name: ollama-proxy
    restart: unless-stopped
    ports:
      - '3003:3003'
    environment:
      - OLLAMA_AUTH_TOKEN=${OLLAMA_AUTH_TOKEN}
    depends_on:
      - ollama
    networks:
      - overlay

volumes:
  ollama_data:

networks:
  overlay:
    driver: bridge
```

#### 3.2 Iniciar servicios

```bash
# Construir y levantar
docker-compose up -d

# Ver si está corriendo
docker-compose ps

# Ver logs
docker-compose logs -f ollama
```

#### 3.3 Descargar modelos dentro del contenedor

```bash
docker exec ollama-server ollama pull llama2:7b
```

#### 3.4 Habilitar Funnel

```bash
sudo tailscale funnel on 11434
# O si usas proxy:
# sudo tailscale funnel on 3003
```

---

## ⚠ Seguridad y control de acceso

### 1. Activar ACLs (Access Control Lists) en Tailscale

Ve a [tailscale.com/admin/acls](https://tailscale.com/admin/acls) y define quién puede acceder a Funnel:

```json
{
  "acls": [
    // Universidades alemanas pueden acceder a Funnel Ollama
    {
      "action": "accept",
      "src": ["group:universidades"],
      "dst": ["tag:homelab-funnel:*"]
    }
  ],
  "hosts": {
    "tu-servidor": "100.x.x.x",
  },
  "tagOwners": {
    // El tag solo puede ser aplicado por admin
    "tag:homelab-funnel": ["autogroup:admin"]
  }
}
```

### 2. Rate limiting (si usas proxy personalizado)

Añade rate limiting en tu proxy:

```typescript
import rateLimit from 'express-rate-limit';

const limiter = rateLimit({
  windowMs: 15 * 60 * 1000, // 15 minutos
  max: 100, // máx 100 requests
  standardHeaders: true,
});

server.use(limiter);
```

### 3. Monitoreo de acceso

```bash
# Ver conexiones Funnel activas
sudo journalctl -u tailscaled -f | grep -i funnel

# Verificar quien accedió últimamente (en Tailscale Admin)
# → Devices → Tu servidor → Activities
```

---

## ◊ Configuración en cliente (Universidades)

### Para desarrolladores / integración con ILIAS

#### 1. Instalación de Tailscale en máquina local (opcional)

Si la universidad quiere Tailscale integrado:

```bash
# Linux
curl -fsSL https://tailscale.com/install.sh | sh

# O en macOS
brew install tailscale

# Iniciar sesión
tailscale login
```

#### 2. Acceso directo desde navegador o aplicación

**Sin Tailscale instalado** (más fácil):

```javascript
// JavaScript / Node.js
const response = await fetch(
  'https://tu-servidor.tailXXXX.ts.net/api/chat',
  {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
      'Authorization': 'Bearer token-si-aplica'
    },
    body: JSON.stringify({
      model: 'llama2:7b',
      messages: [{ role: 'user', content: 'Hola IA' }]
    })
  }
);

const data = await response.json();
console.log(data);
```

#### 3. Desde Python

```python
import requests

url = 'https://tu-servidor.tailXXXX.ts.net/api/tags'
headers = {
  'Authorization': 'Bearer TU_TOKEN_SECRETO'  # Si aplica
}

response = requests.get(url, headers=headers)
print(response.json())
```

#### 4. Desde cURL (testing rápido)

```bash
# Listar modelos disponibles
curl https://tu-servidor.tailXXXX.ts.net/api/tags

# Generar respuesta
curl -X POST https://tu-servidor.tailXXXX.ts.net/api/generate \
  -H 'Content-Type: application/json' \
  -d '{
    "model": "llama2:7b",
    "prompt": "Explica qué es computación en la nube:",
    "stream": false
  }'
```

---

## ◉ Pruebas de conexión

### Checklist de verificación

```bash
# 1. ¿Tailscale está corriendo?
tailscale status
# Debería responder en <100ms

# 2. ¿Ollama está accesible localmente?
curl http://localhost:11434/api/tags
# Debería responder en <200ms

# 3. ¿Funnel está habilitado?
sudo tailscale funnel status
# Debería mostrar "Funnel on" en <500ms

# 4. ¿Puedo acceder desde internet?
curl https://tu-servidor.tailXXXX.ts.net/api/tags
# Debería responder en <1s (incluye latencia de red)

# 5. ¿Modelos están disponibles?
curl https://tu-servidor.tailXXXX.ts.net/api/tags \
  | jq '.models[].name'
# Debería listar modelos en <1-2s
```

### Test desde universidad (machine remota)

**Sin Tailscale instalado:**

```python
import requests
import json

# URL del servidor
OLLAMA_URL = 'https://tu-servidor.tailXXXX.ts.net'

# 1. Test: ¿Está up?
try:
    r = requests.get(f'{OLLAMA_URL}/api/tags', timeout=5)
    print(f"✓ Servidor online: {r.status_code}")
except Exception as e:
    print(f"✗ Error: {e}")
    exit(1)

# 2. Test: ¿Hay modelos?
models = r.json().get('models', [])
print(f"✓ Modelos disponibles: {len(models)}")
for model in models:
    print(f"  - {model['name']}")

# 3. Test: ¿Puedo generar?
response = requests.post(
    f'{OLLAMA_URL}/api/generate',
    json={
        'model': models[0]['name'] if models else 'llama2:7b',
        'prompt': 'Hola, ¿quién eres?',
        'stream': False
    },
    timeout=30
)

if response.status_code == 200:
    result = response.json()
    print(f"\n✓ Generación trabajó:")
    print(f"  Respuesta: {result['response'][:100]}...")
else:
    print(f"✗ Error: {response.status_code}")
```

---

## ⚒ Variables de entorno

**Archivo `.env` recomendado:**

```env
# ────── Ollama ──────────────────────
OLLAMA_MODEL=llama2:7b
OLLAMA_NUM_GPU=1
OLLAMA_HOST=0.0.0.0:11434

# ────── Tailscale ───────────────────
# (Se configura en terminal, no necesita .env)
TAILSCALE_FUNNEL_PORT=11434

# ────── Proxy (solo si usas Opción 2)
OLLAMA_AUTH_TOKEN=TU_TOKEN_SECRETO
PROXY_PORT=3003

# ────── Integración ILIAS/SurAgent ──
ILIAS_OLLAMA_ENDPOINT=https://tu-servidor.tailXXXX.ts.net
ILIAS_OLLAMA_TOKEN=TU_TOKEN_SECRETO
ILIAS_OLLAMA_MODEL=llama2:7b
```

---

## ■ Monitoreo y logs

### Ver estado de Funnel en tiempo real

```bash
# Estado actual
sudo tailscale funnel status

# Logs de Tailscale
sudo journalctl -u tailscaled -n 50 -f

# Filtrar solo Funnel
sudo journalctl -u tailscaled -n 100 | grep -i funnel
```

### Monitorar Ollama

```bash
# Ver procesos Ollama
ps aux | grep ollama

# Si usas Docker
docker logs -f ollama-server

# CPU/Memoria
watch -n 1 'free -h && echo --- && ps aux | grep ollama'
```

### Estadísticas de acceso

```bash
# Conecta a Tailscale Admin Dashboard:
# → Devices → Tu servidor → Activities

# O desde CLI:
sudo tailscale admin set --advertise-routes=100.x.x.x/32
```

---

## ✗ Troubleshooting

### ✗ Error: "Connection refused" desde universidad

**Síntoma:** `curl: Failed to connect to tu-servidor.tailXXXX.ts.net port 443`

**Soluciones:**

1. **Verificar que Funnel está activo:**

   ```bash
   sudo tailscale funnel status
   
   # Si no muestra nada, habilita:
   sudo tailscale funnel on 11434
   ```

2. **Verificar que Ollama está corriendo:**

   ```bash
   curl http://localhost:11434/api/tags
   
   # Si falla, reinicia:
   ollama serve &
   ```

3. **Reiniciar Tailscale completo:**

   ```bash
   sudo systemctl restart tailscaled
   sudo tailscale login
   sudo tailscale funnel on 11434
   ```

4. **Verificar ACLs:**

   Ve a [tailscale.com/admin/acls](https://tailscale.com/admin/acls) y asegúrate que la universidad está en el grupo correcto.

---

### ✗ Error: "Certificate error" (HTTPS)

**Síntoma:** `SSL_ERROR_BAD_CERT_DOMAIN` en navegador

**Causa:** El certificado SSL de Tailscale a veces tarda en regenerarse.

**Soluciones:**

```bash
# 1. Limpiar caché de DNS en tu máquina
sudo systemctl restart systemd-resolved

# 2. Esperar 1-2 minutos a que Tailscale regenere el cert

# 3. Si persiste, reiniciar Funnel:
sudo tailscale funnel off 11434
sudo tailscale funnel on 11434
```

---

### ✗ Error: "Too many requests" (Rate limiting)

**Síntoma:** `HTTP 429 Too Many Requests`

**Causa:** Excediste límite de requests (si aplica).

**Soluciones:**

```bash
# Revisar logs de rate limit
sudo journalctl | grep -i "429\|rate"

# Si es problema del lado del cliente, reducir:
# - Número de requests paralelos
# - Aumentar delay entre requests
```

---

### ✗ Ollama lento o "timeout"

**Síntoma:** Tarda más de 30 segundos en responder.

**Causa común:** Modelo grande o servidor sobrecargado.

**Soluciones:**

```bash
# 1. Ver CPU/Memoria
watch 'free -h && echo --- && ps aux | grep ollama'

# 2. Usar modelo más ligero
ollama pull neural-chat:latest
# O:
ollama pull mistral:7b

# 3. Aumentar timeout en cliente
curl --max-time 120 https://tu-servidor.tailXXXX.ts.net/api/generate
```

---

### ✗ Funnel se desactiva solo

**Síntoma:** Después de algunas horas, Funnel deja de funcionar.

**Causa:** Timeout o desconexión de Tailscale.

**Soluciones:**

```bash
#!/bin/bash
# ./keep-funnel.sh
# Script que mantiene Funnel activo


while true; do
  if ! sudo tailscale funnel status | grep -q "Funnel on"; then
    echo "Reactivando Funnel..."
    sudo tailscale funnel on 11434
  fi
  sleep 60
done
```

Hacerlo ejecutable y ejecutar:

```bash
chmod +x ./keep-funnel.sh

# Opción 1: Con nohup
nohup ./keep-funnel.sh &

# Opción 2: Con PM2
pm2 start ./keep-funnel.sh --name "tailscale-funnel"
```

---

## ✎ Casos de uso prácticos

### Caso 1: ILIAS + SurAgent con Ollama

**Setup:**

```
Universidad (Alemania)
    ↓
ILIAS Platform
    ↓
SurAgent (Plugin)
    ↓
HTTPS Request
    ↓
tu-servidor.tailXXXX.ts.net (Ollama API)
    ↓
Ollama Model (llama2:7b, mistral, etc)
```

**Configuración en ILIAS:**

```php
// config.php o settings
define('OLLAMA_ENDPOINT', 'https://tu-servidor.tailXXXX.ts.net');
define('OLLAMA_MODEL', 'llama2:7b');
define('OLLAMA_TOKEN', 'TU_TOKEN_SECRETO');

// Test endpoint
$ch = curl_init(OLLAMA_ENDPOINT . '/api/tags');
curl_setopt($ch, CURLOPT_HEADER, ['Authorization: Bearer ' . OLLAMA_TOKEN]);
curl_exec($ch);
```

---

### Caso 2: API REST personal para investigadores

**Endpoint público:**

```
GET   /api/tags                  → Listar modelos
POST  /api/generate              → Generar texto
POST  /api/chat                  → Chat conversacional
POST  /api/embed                 → Embeddings (búsqueda)
```

**Cliente estándar:**

```python
import requests

class OllamaClient:
    def __init__(self, url, token=None):
        self.url = url
        self.token = token
    
    def headers(self):
        h = {'Content-Type': 'application/json'}
        if self.token:
            h['Authorization'] = f'Bearer {self.token}'
        return h
    
    def generate(self, prompt):
        r = requests.post(
            f'{self.url}/api/generate',
            json={'model': 'llama2:7b', 'prompt': prompt},
            headers=self.headers()
        )
        return r.json()['response']

# Uso
client = OllamaClient('https://tu-servidor.tailXXXX.ts.net', token='TU_TOKEN_SECRETO')
print(client.generate('¿Cuál es el futuro de la IA?'))
```

---

### Caso 3: Batch processing para análisis de datos

**Script de análisis masivo:**

```python
import requests
import pandas as pd

OLLAMA_URL = 'https://tu-servidor.tailXXXX.ts.net'

# Leer dataset
df = pd.read_csv('./data/textos_a_analizar.csv')

results = []
for idx, row in df.iterrows():
    text = row['texto']
    
    # Pedir análisis a Ollama
    response = requests.post(
        f'{OLLAMA_URL}/api/generate',
        json={
            'model': 'llama2:7b',
            'prompt': f'Analiza si es positivo, negativo o neutro: "{text}"',
            'stream': False
        },
        timeout=60
    )
    
    sentiment = response.json()['response']
    results.append({'texto': text, 'sentimiento': sentiment})
    
    print(f"Procesados {idx+1}/{len(df)}")

# Guardar resultados
pd.DataFrame(results).to_csv('./results/resultados_sentimientos.csv', index=False)
```

---

## ⚠ Cuándo NO usar Tailscale Funnel

Tailscale Funnel es excelente para la mayoría de casos, pero hay escenarios donde **no es la mejor opción**:

| Escenario | Razón | Alternativa |
|:---|:---|:---|
| **>1000 req/s** | Tailscale no está optimizado para alto volumen | Infraestructura tradicional (CDN + WAF) |
| **Latencia crítica (<50ms)** | Añade ~100ms de overhead | Servidores geográficamente distribuidos |
| **Tráfico masivo de datos** (>100GB/día) | Costos pueden ser prohibitivos | Transferencia de datos directa o S3 |
| **Cumplimiento regulatorio estricto** | Algunos marcos requieren infraestructura dedicada | Servidores on-premise o cloud privado |
| **Protección DDoS avanzada** | Funnel es básico en seguridad de capas | Servicios especializados (Cloudflare, Akamai) |

**Para este proyecto (Ollama + ILIAS):** Tailscale Funnel es **perfectamente adecuado** (estimado 100-500 req/s, latencia aceptable <2s).

---

## ★ Conclusión

Con esta configuración, tus universidades alemanas pueden:

- ✓ Acceder **sin VPN** — Solo con URL HTTPS  
- ✓ Usar **cualquier modelo Ollama** — Llama, Mistral, Neural Chat, etc  
- ✓ Integrar con **ILIAS/SurAgent** — Sin cambios de arquitectura  
- ✓ Escalar **sin mantenimiento** — Tailscale maneja certificados  

**Próximos pasos:**

1. Elige una opción (Opción 1 recomendada)
2. Configura Tailscale Funnel
3. Comparte `https://tu-servidor.tailXXXX.ts.net` con universidades
4. Integra con ILIAS/SurAgent
5. Monitorea [Troubleshooting](#-troubleshooting) según sea necesario

¿Dudas? Revisa la sección de [Troubleshooting](#-troubleshooting).

---

- **Creacińon inicial: Abril 2026**
- **Última actualización:** Abril 2026  
- **Autor:** José Ángel Alejo Sillero  
- **Stack:** Tailscale + Ollama + ILIAS
