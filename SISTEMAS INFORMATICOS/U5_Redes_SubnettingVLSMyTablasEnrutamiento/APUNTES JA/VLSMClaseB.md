# Mini Guía: Subnetting en redes grandes (Clase B)

Cuando el bloque es mayor que 256, el salto ocurre en el **tercer octeto** en vez del cuarto.

---

## Paso 1 — Identificar la red base

La IP que te dan es una IP de host. La red base tiene los octetos de host a 0.

```
Clase A (/8):  los 3 últimos octetos a 0  → X.0.0.0
Clase B (/16): los 2 últimos octetos a 0  → X.X.0.0
Clase C (/24): el último octeto a 0       → X.X.X.0
```

Ejemplo: `180.128.64.32` es clase B → red base = `180.128.0.0`

---

## Paso 2 — Calcular el prefijo de cada subred

Busca la potencia de 2 que cubra los hosts necesarios (+2):

```
hosts necesarios → potencia de 2 que lo cubre → bits de host → prefijo = 32 - bits
```

| Hosts necesarios | Potencia | Bits host | Prefijo |
|-----------------|----------|-----------|---------|
| 30100           | 2¹⁵=32768 | 15       | /17     |
| 15500           | 2¹⁴=16384 | 14       | /18     |
| 8000            | 2¹³=8192  | 13       | /19     |
| 4000            | 2¹²=4096  | 12       | /20     |

---

## Paso 3 — Calcular el salto en el tercer octeto

```
tamaño de bloque = 2^bits de host
salto en tercer octeto = tamaño de bloque ÷ 256
```

| Prefijo | Bloque   | Salto tercer octeto |
|---------|----------|---------------------|
| /17     | 32768    | 32768 ÷ 256 = 128   |
| /18     | 16384    | 16384 ÷ 256 = 64    |
| /19     | 8192     | 8192  ÷ 256 = 32    |
| /20     | 4096     | 4096  ÷ 256 = 16    |

---

## Paso 4 — Asignar direcciones de red en orden

Ordena siempre de mayor a menor. Parte de la red base y suma el salto en el tercer octeto:

```
Subred 1: 180.128.  0.0   (/17, salto 128)
Subred 2: 180.128.128.0   (0 + 128)
Subred 3: 180.128.192.0   (/18, salto 64)
Subred 4: 180.129.  0.0   (192 + 64 = 256 → carry → siguiente octeto +1, este a 0)
Subred 5: 180.129. 64.0   (0 + 64)
```

> Cuando el tercer octeto llega a 256, vuelve a 0 y sumas 1 al segundo octeto.

---

## Paso 5 — Calcular el broadcast de cada subred

```
broadcast = siguiente dirección de red - 1
```

Si es la última subred:

```
broadcast = dirección de red + salto - 1  (en tercer octeto)
            cuarto octeto siempre = 255
```

Ejemplo:

```
Subred 1: siguiente red es 180.128.128.0 → broadcast = 180.128.127.255
Subred 5: 180.129.64.0 + 64 - 1         → broadcast = 180.129.127.255
```

---

## Paso 6 — Calcular la máscara

La máscara del tercer octeto se calcula acumulando los bits de red de ese octeto:

```
/17 → 1 bit de red en tercer octeto  → 128           → 255.255.128.0
/18 → 2 bits de red en tercer octeto → 128+64 = 192  → 255.255.192.0
/19 → 3 bits de red en tercer octeto → 128+64+32=224 → 255.255.224.0
/20 → 4 bits de red en tercer octeto → 128+64+32+16=240 → 255.255.240.0
```

O más rápido: **el tercer octeto de la máscara = 256 - salto**

```
/17 → 256 - 128 = 128 → 255.255.128.0
/18 → 256 -  64 = 192 → 255.255.192.0
/19 → 256 -  32 = 224 → 255.255.224.0
/20 → 256 -  16 = 240 → 255.255.240.0
```

En binario el tercer octeto tiene tantos 1s como bits de red:

```
/17 → 10000000
/18 → 11000000
/19 → 11100000
/20 → 11110000
```

---

## Resumen de fórmulas

```
Red base         → octetos de host a 0
Prefijo          → 32 - bits de host
Bloque           → 2^bits de host
Salto 3er octeto → bloque ÷ 256
Dir de red       → red anterior + salto (en tercer octeto)
Broadcast        → siguiente red - 1  (cuarto octeto siempre 255)
Máscara          → 256 - salto  (en tercer octeto)
```

---

## Resumen de fórmulas: Subnetting Clase B

### Paso a paso

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

---

### Ejemplo aplicado: 180.128.64.32 dividida en 5 subredes

**Datos:** 2 subredes de 15500 hosts, 3 subredes de 3100 hosts

#### 1. Red base

```
180.128.64.32 es clase B → red base = 180.128.0.0
```

#### 2. Ordenar de mayor a menor

```
Subred 1 → 15500 hosts
Subred 2 → 15500 hosts
Subred 3 →  3100 hosts
Subred 4 →  3100 hosts
Subred 5 →  3100 hosts
```

#### 3. Prefijo de cada subred

```
15500 hosts → 2¹⁴=16384 ✅ → 14 bits host → /18
 3100 hosts → 2¹²=4096  ✅ → 12 bits host → /20
```

#### 4. Salto en el tercer octeto

```
/18 → bloque = 2¹⁴ = 16384 → 16384 ÷ 256 = 64
/20 → bloque = 2¹² =  4096 →  4096 ÷ 256 = 16
```

#### 5. Direcciones de red

```
Subred 1 (/18): 180.128.  0.0   (red base)
Subred 2 (/18): 180.128. 64.0   (0   + 64)
Subred 3 (/20): 180.128.128.0   (64  + 64)
Subred 4 (/20): 180.128.144.0   (128 + 16)
Subred 5 (/20): 180.128.160.0   (144 + 16)
```

#### 6. Broadcast

```
Subred 1: 180.128. 63.255  (siguiente red 180.128.64.0  - 1)
Subred 2: 180.128.127.255  (siguiente red 180.128.128.0 - 1)
Subred 3: 180.128.143.255  (128 + 16 - 1)
Subred 4: 180.128.159.255  (144 + 16 - 1)
Subred 5: 180.128.175.255  (160 + 16 - 1)
```

#### 7. Máscara

```
/18 → 256 - 64 = 192 → 255.255.192.0 → 11111111.11111111.11000000.00000000
/20 → 256 - 16 = 240 → 255.255.240.0 → 11111111.11111111.11110000.00000000
```

---

## Tabla resumen del ejemplo

| Subred | Hosts | Prefijo | Dir. de red   | Broadcast       | Máscara       |
|--------|-------|---------|---------------|-----------------|---------------|
| 1      | 15500 | /18     | 180.128.0.0   | 180.128.63.255  | 255.255.192.0 |
| 2      | 15500 | /18     | 180.128.64.0  | 180.128.127.255 | 255.255.192.0 |
| 3      | 3100  | /20     | 180.128.128.0 | 180.128.143.255 | 255.255.240.0 |
| 4      | 3100  | /20     | 180.128.144.0 | 180.128.159.255 | 255.255.240.0 |
| 5      | 3100  | /20     | 180.128.160.0 | 180.128.175.255 | 255.255.240.0 |
