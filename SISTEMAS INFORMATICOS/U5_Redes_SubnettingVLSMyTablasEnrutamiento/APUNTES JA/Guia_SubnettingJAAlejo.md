# Guía de Subnetting - JAAlejo

## **1. Información de una IP**

Dado un bloque como `192.168.50.200/28`, puedes extraer toda esta información:

### Paso a paso

#### **Paso 1 — Bits de host**

```
32 - prefijo = bits de host
32 - 28 = 4 bits de host
```

#### **Paso 2 — Tamaño de bloque (salto)**

```
2^bits = tamaño de bloque
2⁴ = 16
```

#### **Paso 3 — Número de hosts útiles**

```
tamaño de bloque - 2 = hosts útiles
16 - 2 = 14 hosts
```

#### **Paso 4 — Máscara decimal**

Memoriza esta tabla:

| CIDR | Último octeto | Salto |
|------|---------------|-------|
| /25  | 128           | 128   |
| /26  | 192           | 64    |
| /27  | 224           | 32    |
| /28  | 240           | 16    |
| /29  | 248           | 8     |
| /30  | 252           | 4     |

`/28 → 255.255.255.240`

#### **Paso 5 — Dirección de red**

Divide la IP entre el salto y quédate con la parte entera, luego multiplica:

```
200 ÷ 16 = 12.5 → parte entera = 12
12 × 16 = 192 → dirección de red = 192.168.50.192
```

#### **Paso 6 — Broadcast**

```
dirección de red + salto - 1
192 + 16 - 1 = 207 → 192.168.50.207
```

#### **Paso 7 — Puerta de enlace**

```
dirección de red + 1 = 192.168.50.193
```

#### **Paso 8 — Última IP útil**

```
broadcast - 1 = 192.168.50.206
```

#### **Paso 9 — Rango de hosts**

```
gateway → última IP útil
192.168.50.193 → 192.168.50.206
```

#### Resultado final

| Campo             | Valor                  |
|-------------------|------------------------|
| Dirección de red  | 192.168.50.192         |
| Máscara decimal   | 255.255.255.240        |
| CIDR              | /28                    |
| Puerta de enlace  | 192.168.50.193         |
| Rango de hosts    | .193 → .206            |
| Broadcast         | 192.168.50.207         |
| Hosts útiles      | 14                     |

---

## **2. Subnetting VLSM**

VLSM (Variable Length Subnet Masking) consiste en asignar a cada subred **el tamaño justo** que necesita, sin desperdiciar IPs.

## **2.1. VLSM estándar (salto en cuarto octeto)**

### Ejemplo

- Red base: `172.30.32.0/22`
- Requisitos:
  - LAN1 → 500 hosts
  - LAN2 → 250 hosts
  - LAN3 → 2 hosts (enlace R0-R1)
  - LAN4 → 2 hosts (enlace R0-R2)
  - LAN5 → 2 hosts (enlace R1-R2)

---

### Paso 1 — Ordenar de mayor a menor

Siempre empieza asignando la red más grande:

```
LAN1 → 500 hosts
LAN2 → 250 hosts
LAN3 → 2 hosts
LAN4 → 2 hosts
LAN5 → 2 hosts
```

### Paso 2 — Calcular el prefijo de cada LAN

Busca la potencia de 2 que cubra los hosts necesarios (+2 por red y broadcast):

```
LAN1: necesita 500 → 2⁹=512 no llega → 2¹⁰=1024 ✅ → 10 bits host → /22
LAN2: necesita 250 → 2⁸=256 ✅         →  8 bits host → /24 (o /23 según criterio)
LAN3: necesita   2 → 2²=4   ✅         →  2 bits host → /30
LAN4: necesita   2 → 2²=4   ✅         →  2 bits host → /30
LAN5: necesita   2 → 2²=4   ✅         →  2 bits host → /30
```

> Los enlaces punto a punto entre routers siempre son /30 porque solo necesitan 2 IPs.

### Paso 3 — Asignar bloques consecutivos desde la red base

El broadcast de una red + 1 = dirección de red de la siguiente.

> **LAN1 → /22** (bloque de 1024)

```
Red:            172.30.32.0
Broadcast:      172.30.35.255
Siguiente red:  172.30.36.0
```

> **LAN2 → /23** (bloque de 512)

```
Red:            172.30.36.0
Broadcast:      172.30.37.255
Siguiente red:  172.30.38.0
```

> **LAN3 → /30** (bloque de 4)

```
Red:            172.30.38.0
Broadcast:      172.30.38.3
Siguiente red:  172.30.38.4
```

> **LAN4 → /30**

```
Red:            172.30.38.4
Broadcast:      172.30.38.7
Siguiente red:  172.30.38.8
```

> **LAN5 → /30**

```
Red:            172.30.38.8
Broadcast:      172.30.38.11
```

### Paso 4 — Rellenar las tablas

#### **Tabla 1 — Información de redes**

| Red  | Dir. de red | CIDR | Máscara         |
|------|-------------|------|-----------------|
| LAN1 | 172.30.32.0 | /22  | 255.255.252.0   |
| LAN2 | 172.30.36.0 | /23  | 255.255.254.0   |
| LAN3 | 172.30.38.0 | /30  | 255.255.255.252 |
| LAN4 | 172.30.38.4 | /30  | 255.255.255.252 |
| LAN5 | 172.30.38.8 | /30  | 255.255.255.252 |

#### **Tabla 2 — Rango de hosts**

| Red  | 1ª IP host  | Última IP host | Broadcast     |
|------|-------------|----------------|---------------|
| LAN1 | 172.30.32.1 | 172.30.35.254  | 172.30.35.255 |
| LAN2 | 172.30.36.1 | 172.30.37.254  | 172.30.37.255 |
| LAN3 | 172.30.38.1 | 172.30.38.2    | 172.30.38.3   |
| LAN4 | 172.30.38.5 | 172.30.38.6    | 172.30.38.7   |
| LAN5 | 172.30.38.9 | 172.30.38.10   | 172.30.38.11  |

#### **Tabla 3 — IPs de interfaces de routers**

En LAN1 y LAN2 la primera IP va al router. En los enlaces (LAN3/4/5) la primera IP al router de la izquierda y la segunda al de la derecha (según el diagrama).

| Red          | Router | Interfaz | IP           |
|--------------|--------|----------|--------------|
| LAN1         | R1     | g0/2     | 172.30.32.1  |
| LAN2         | R2     | g0/1     | 172.30.36.1  |
| LAN3 (R0↔R1) | R0     | g0/2     | 172.30.38.1  |
| LAN3 (R0↔R1) | R1     | g0/0     | 172.30.38.2  |
| LAN4 (R0↔R2) | R0     | g0/1     | 172.30.38.5  |
| LAN4 (R0↔R2) | R2     | g0/0     | 172.30.38.6  |
| LAN5 (R1↔R2) | R1     | g0/1     | 172.30.38.9  |
| LAN5 (R1↔R2) | R2     | g0/2     | 172.30.38.10 |

#### **Tabla 4 — Puertas de enlace**

| Red  | Gateway | IP          |
|------|---------|-------------|
| LAN1 | R1 g0/2 | 172.30.32.1 |
| LAN2 | R2 g0/1 | 172.30.36.1 |

---

## **3. Tablas de Enrutamiento**

La tabla de enrutamiento le dice al router: para llegar a esta red, manda el paquete por aquí.

### Las 4 columnas

| Columna                       | Descripción                                      |
|-------------------------------|--------------------------------------------------|
| **Dirección de destino/CIDR** | La red a la que quiero llegar                    |
| **Siguiente salto**           | IP del router vecino por el que mando el paquete |
| **Métrica**                   | Coste del camino (número de saltos)              |
| **Interfaz de salida**        | Puerto físico por el que sale el paquete         |

### Reglas clave

- **Métrica 0** → redes directamente conectadas, el router las pone solo, no las rellenas tú.
- **Métrica 1, 2...** → redes a las que hay que llegar pasando por otros routers, estas sí las rellenas.
- **Métrica ≥ 100** → ruta de último recurso (`0.0.0.0/0`). Todo lo desconocido sale por aquí (hacia Internet).
- **El siguiente salto** es siempre la IP del router vecino en el enlace que los conecta, nunca la IP de destino final.

### Cómo pensar cada tabla (ejemplo con R0)

1. Paso 1 — ¿Qué redes ve R0 directamente?
   → enlace R0-R1 (172.30.38.0/30)  via g0/2  ← NO la rellenas
   → enlace R0-R2 (172.30.38.4/30)  via g0/1  ← NO la rellenas
   → Internet (80.28.53.0/24)        via g0/0  ← NO la rellenas

2. Paso 2 — ¿Qué redes NO ve directamente?
   → LAN1 (172.30.32.0/22)    ← está detrás de R1, SÍ la rellenas
   → LAN2 (172.30.36.0/23)    ← está detrás de R2, SÍ la rellenas
   → enlace R1-R2 (172.30.38.8/30) ← SÍ la rellenas

3. Paso 3 — ¿Por qué router vecino llego a cada una?
   → LAN1 está detrás de R1 → siguiente salto = IP de R1 en enlace R0-R1 = 172.30.38.2
   → LAN2 está detrás de R2 → siguiente salto = IP de R2 en enlace R0-R2 = 172.30.38.6
   → enlace R1-R2 → puedo ir por R1 → 172.30.38.2

4. Paso 4 — ¿Por qué interfaz sale?
   → Si el siguiente salto es R1 (172.30.38.2) → sale por g0/2
   → Si el siguiente salto es R2 (172.30.38.6) → sale por g0/1

5. Paso 5 — Ruta de último recurso
   → 0.0.0.0/0 → 80.28.53.1 → métrica 100 → g0/0

### Tabla de R0

| Destino CIDR   | Siguiente salto | Métrica | Interfaz |
|----------------|-----------------|---------|----------|
| 0.0.0.0/0      | 80.28.53.1      | 100     | g0/0     |
| 172.30.32.0/22 | 172.30.38.2     | 1       | g0/2     |
| 172.30.36.0/23 | 172.30.38.6     | 1       | g0/1     |
| 172.30.38.8/30 | 172.30.38.2     | 1       | g0/2     |

### Tabla de R1

R1 ve directamente: LAN1 (g0/2), enlace R0-R1 (g0/0), enlace R1-R2 (g0/1).  
Necesita rutas hacia: LAN2, enlace R0-R2 e Internet.

| Destino CIDR   | Siguiente salto | Métrica | Interfaz |
|----------------|-----------------|---------|----------|
| 0.0.0.0/0      | 172.30.38.1     | 100     | g0/0     |
| 172.30.36.0/23 | 172.30.38.10    | 1       | g0/1     |
| 172.30.38.4/30 | 172.30.38.1     | 1       | g0/0     |

### Tabla de R2

R2 ve directamente: LAN2 (g0/1), enlace R0-R2 (g0/0), enlace R1-R2 (g0/2).  
Necesita rutas hacia: LAN1, enlace R0-R1 e Internet.

| Destino CIDR   | Siguiente salto | Métrica | Interfaz |
|----------------|-----------------|---------|----------|
| 0.0.0.0/0      | 172.30.38.5     | 100     | g0/0     |
| 172.30.32.0/22 | 172.30.38.9     | 1       | g0/2     |
| 172.30.38.0/30 | 172.30.38.5     | 1       | g0/0     |

---

## **2.2. Subnetting Clase B (salto en tercer octeto)**

Cuando el bloque es mayor que 256, el salto ocurre en el **tercer octeto** en vez del cuarto.

### **Paso a paso**

1. **Red base** → poner los octetos de host a 0
   - Clase A (/8): `X.0.0.0`
   - Clase B (/16): `X.X.0.0`
   - Clase C (/24): `X.X.X.0`
2. **Ordenar subredes** → de mayor a menor número de hosts
3. **Prefijo de cada subred** → potencia de 2 que cubra los hosts necesarios
   - hosts necesarios → busca 2^n ≥ hosts → prefijo = `32 - n`
4. **Tamaño de bloque** → `2^n` (los bits de host)
5. **Salto en el tercer octeto** → `bloque ÷ 256`
   - Si bloque ≤ 256 → el salto ocurre en el cuarto octeto (como siempre)
   - Si bloque > 256 → el salto ocurre en el tercer octeto
6. **Dirección de red** → partir de la red base y sumar el salto en cada subred
   - Si el tercer octeto llega a 256 → vuelve a 0 y suma 1 al segundo octeto
7. **Broadcast** → `siguiente dirección de red - 1`
   - El cuarto octeto siempre es 255
   - Si es la última subred: `dirección de red + salto - 1` (en el tercer octeto)
8. **Máscara decimal** → `256 - salto` en el octeto donde ocurre el salto
   - Clase B con salto en tercer octeto: `255.255.(256-salto).0`
9. **Máscara binario** → tantos 1s como bits de red, luego 0s hasta 32
   - /17 → `11111111.11111111.10000000.00000000`
   - /18 → `11111111.11111111.11000000.00000000`
   - /19 → `11111111.11111111.11100000.00000000`
   - /20 → `11111111.11111111.11110000.00000000`

### Tabla de referencia rápida

| Prefijo | Bloque | Salto 3er octeto | Máscara       | Máscara binario                     |
|---------|--------|------------------|---------------|-------------------------------------|
| /17     | 32768  | 128              | 255.255.128.0 | 11111111.11111111.10000000.00000000 |
| /18     | 16384  | 64               | 255.255.192.0 | 11111111.11111111.11000000.00000000 |
| /19     | 8192   | 32               | 255.255.224.0 | 11111111.11111111.11100000.00000000 |
| /20     | 4096   | 16               | 255.255.240.0 | 11111111.11111111.11110000.00000000 |

### Ejemplo aplicado: `180.128.64.32` dividida en 5 subredes

**Datos:** 2 subredes de 15500 hosts, 3 subredes de 3100 hosts

**Red base:**

```
180.128.64.32 es clase B → red base = 180.128.0.0
```

**Prefijos:**

```
15500 hosts → 2¹⁴=16384 ✅ → 14 bits host → /18 → salto = 16384 ÷ 256 = 64
 3100 hosts → 2¹²=4096  ✅ → 12 bits host → /20 → salto =  4096 ÷ 256 = 16
```

**Resultado:**

| Subred | Hosts | Prefijo | Dir. de red   | Broadcast       | Máscara       |
|--------|-------|---------|---------------|-----------------|---------------|
| 1      | 15500 | /18     | 180.128.0.0   | 180.128.63.255  | 255.255.192.0 |
| 2      | 15500 | /18     | 180.128.64.0  | 180.128.127.255 | 255.255.192.0 |
| 3      | 3100  | /20     | 180.128.128.0 | 180.128.143.255 | 255.255.240.0 |
| 4      | 3100  | /20     | 180.128.144.0 | 180.128.159.255 | 255.255.240.0 |
| 5      | 3100  | /20     | 180.128.160.0 | 180.128.175.255 | 255.255.240.0 |

---

## **Resumen de fórmulas**

### IP normal (salto en cuarto octeto)

1. **Bits de host**       → 32 - prefijo
2. **Tamaño de bloque**   → 2^bits de host
3. **Hosts útiles**       → bloque - 2
4. **Dirección de red**   → (IP ÷ bloque, parte entera) × bloque
5. **Broadcast**          → red + bloque - 1
6. **Gateway**            → red + 1
7. **Última IP útil**     → broadcast - 1
8. **Siguiente red VLSM** → broadcast + 1

### Clase B (salto en tercer octeto)

1. **Red base**              → X.X.0.0
2. **Prefijo**               → 32 - n  (donde 2^n ≥ hosts necesarios)
3. **Bloque**                → 2^n
4. **Salto tercer octeto**   → bloque ÷ 256
5. **Dir. de red**           → red anterior + salto (en tercer octeto)
6. **Broadcast**             → siguiente red - 1  (cuarto octeto siempre 255)
7. **Máscara tercer octeto** → 256 - salto

### Tablas de enrutamiento

1. **Redes directas**        → métrica 0, las pone el router solo, no las rellenas
2. **Redes a rellenar**      → todas las que el router NO ve directamente
3. **Siguiente salto**       → IP del router vecino en el enlace que los conecta (nunca la IP de destino)
4. **Métrica**               → número de saltos hasta la red destino (1, 2... o ≥100 para último recurso)
5. **Interfaz de salida**    → interfaz del router por la que sale hacia el siguiente salto
6. **Último recurso**        → `0.0.0.0/0`, métrica ≥ 100, apunta al gateway de Internet
