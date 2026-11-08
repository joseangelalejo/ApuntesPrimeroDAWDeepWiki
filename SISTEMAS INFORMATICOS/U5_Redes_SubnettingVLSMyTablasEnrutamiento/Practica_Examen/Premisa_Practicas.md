# Ejercicios de Práctica - Subnetting

---

## BLOQUE 1: Información de una IP

Para cada ejercicio calcula: dirección de red, máscara decimal, CIDR, puerta de enlace, rango de hosts, broadcast y número de hosts útiles.

---

### Ejercicio 1.1

Dada la IP: `192.168.1.130/26`

---

### Ejercicio 1.2

Dada la IP: `10.0.0.200/29`

---

### Ejercicio 1.3

Dada la IP: `172.16.45.83/27`

---

### Ejercicio 1.4

Dada la IP: `192.168.100.50/28`

---

## BLOQUE 2: Subnetting VLSM

Para cada ejercicio calcula las 4 tablas:

- **Tabla 1:** Dirección de red, CIDR y máscara de cada LAN
- **Tabla 2:** Primera IP de host, última IP de host y broadcast de cada LAN
- **Tabla 3:** IP de cada interfaz de cada router
- **Tabla 4:** Puerta de enlace de cada LAN con hosts

---

### Ejercicio 2.1

Red base: `192.168.20.0/24`

Topología: dos routers R0 y R1 conectados entre sí. R0 conectado a Internet por g0/0 (IP pública `85.14.22.100/24`, gateway `85.14.22.1`). R0 conectado a R1 por g0/1 ↔ g0/0. R1 tiene dos LANs: LAN1 por g0/1 y LAN2 por g0/2.

Requisitos:

- LAN1: 100 hosts
- LAN2: 50 hosts
- Enlace R0-R1: 2 hosts

Asignación: orden de mayor a menor. Primera IP de cada LAN al router. En el enlace, primera IP a R0 y segunda a R1.

---

### Ejercicio 2.2

Red base: `10.10.0.0/22`

Topología: dos routers R0 y R1. R0 conectado a Internet por g0/0 (IP pública `212.45.10.5/24`, gateway `212.45.10.1`). R0 conectado a R1 por g0/1 ↔ g0/0. R0 tiene LAN1 por g0/2. R1 tiene LAN2 por g0/1 y LAN3 por g0/2.

Requisitos:

- LAN1: 400 hosts
- LAN2: 100 hosts
- LAN3: 50 hosts
- Enlace R0-R1: 2 hosts

Asignación: orden de mayor a menor. Primera IP de cada LAN al router. En el enlace, primera IP a R0 y segunda a R1.

---

### Ejercicio 2.3

Red base: `172.20.0.0/22`

Topología: igual que el ejercicio del profesor (R0 arriba conectado a Internet por g0/0, R0 conectado a R1 por g0/2 y a R2 por g0/1, R1 tiene LAN1 por g0/2, R2 tiene LAN2 por g0/1, enlace R1-R2 por g0/1 ↔ g0/2).

Requisitos:

- LAN1: 200 hosts
- LAN2: 100 hosts
- Enlace R0-R1: 2 hosts
- Enlace R0-R2: 2 hosts
- Enlace R1-R2: 2 hosts

Asignación: orden de mayor a menor. Primera IP de cada LAN al router. En los enlaces, primera IP al router de la izquierda y segunda al de la derecha.

---

### Ejercicio 2.4

Red base: `192.168.50.0/23`

Topología: dos routers R0 y R1. R0 conectado a Internet por g0/0 (IP pública `94.23.11.50/24`, gateway `94.23.11.1`). R0 conectado a R1 por g0/1 ↔ g0/0. R0 tiene LAN1 por g0/2. R1 tiene LAN2 por g0/1 y LAN3 por g0/2.

Requisitos:

- LAN1: 300 hosts
- LAN2: 60 hosts
- LAN3: 25 hosts
- Enlace R0-R1: 2 hosts

Asignación: orden de mayor a menor. Primera IP de cada LAN al router. En el enlace, primera IP a R0 y segunda a R1.

---

## BLOQUE 3: Tablas de Enrutamiento

Para cada ejercicio rellena la tabla de enrutamiento de los routers indicados. Usa los datos de direccionamiento que se proporcionan.

Recuerda:

- Las redes directamente conectadas **no** se rellenan (métrica 0, el router las añade solo).
- Ruta de último recurso: `0.0.0.0/0`, métrica ≥ 100.
- El siguiente salto es siempre la IP del router vecino, nunca la IP de destino.

---

### Ejercicio 3.1

Topología: R0 conectado a Internet (g0/0), R0 conectado a R1 (g0/1 ↔ g0/0).  
R1 tiene LAN1 (g0/1) y LAN2 (g0/2).

Direccionamiento:

```
Internet:      R0 g0/0 = 91.10.5.1/24,  gateway Internet = 91.10.5.254
Enlace R0-R1:  R0 g0/1 = 10.0.0.1/30,  R1 g0/0 = 10.0.0.2/30
LAN1:          red = 192.168.1.0/25,    R1 g0/1 = 192.168.1.1
LAN2:          red = 192.168.1.128/26,  R1 g0/2 = 192.168.1.129
```

**Rellena la tabla de R0 y la tabla de R1.**

---

### Ejercicio 3.2

Topología: R0 conectado a Internet (g0/0), R0 conectado a R1 (g0/1 ↔ g0/0) y a R2 (g0/2 ↔ g0/0).  
R1 tiene LAN1 (g0/1). R2 tiene LAN2 (g0/1).

Direccionamiento:

```
Internet:      R0 g0/0 = 80.5.3.10/24,  gateway Internet = 80.5.3.1
Enlace R0-R1:  R0 g0/1 = 172.16.0.1/30, R1 g0/0 = 172.16.0.2/30
Enlace R0-R2:  R0 g0/2 = 172.16.0.5/30, R2 g0/0 = 172.16.0.6/30
LAN1:          red = 10.10.1.0/24,       R1 g0/1 = 10.10.1.1
LAN2:          red = 10.10.2.0/24,       R2 g0/1 = 10.10.2.1
```

**Rellena la tabla de R0 y la tabla de R1.**

---

### Ejercicio 3.3

Topología igual al ejercicio del profesor: R0 arriba (Internet por g0/0, R1 por g0/2, R2 por g0/1). R1 tiene LAN1 (g0/2). R2 tiene LAN2 (g0/1). Enlace R1-R2 por g0/1 ↔ g0/2.

Direccionamiento:

```
Internet:      R0 g0/0 = 195.60.1.2/24,  gateway Internet = 195.60.1.1
Enlace R0-R1:  R0 g0/2 = 10.0.0.1/30,   R1 g0/0 = 10.0.0.2/30
Enlace R0-R2:  R0 g0/1 = 10.0.0.5/30,   R2 g0/0 = 10.0.0.6/30
Enlace R1-R2:  R1 g0/1 = 10.0.0.9/30,   R2 g0/2 = 10.0.0.10/30
LAN1:          red = 192.168.10.0/24,    R1 g0/2 = 192.168.10.1
LAN2:          red = 192.168.20.0/24,    R2 g0/1 = 192.168.20.1
```

**Rellena la tabla de R0 y la tabla de R1.**

---

### Ejercicio 3.4

Topología igual al ejercicio del profesor: R0 arriba (Internet por g0/0, R1 por g0/2, R2 por g0/1). R1 tiene LAN1 (g0/2) y LAN3 (g0/0 hacia arriba ya es el enlace). R2 tiene LAN2 (g0/1). Enlace R1-R2 por g0/1 ↔ g0/2.

Direccionamiento:

```
Internet:      R0 g0/0 = 80.28.53.213/24,  gateway Internet = 80.28.53.1
Enlace R0-R1:  R0 g0/2 = 172.30.38.1/30,  R1 g0/0 = 172.30.38.2/30
Enlace R0-R2:  R0 g0/1 = 172.30.38.5/30,  R2 g0/0 = 172.30.38.6/30
Enlace R1-R2:  R1 g0/1 = 172.30.38.9/30,  R2 g0/2 = 172.30.38.10/30
LAN1:          red = 172.30.32.0/22,       R1 g0/2 = 172.30.32.1
LAN2:          red = 172.30.36.0/23,       R2 g0/1 = 172.30.36.1
```

**Rellena la tabla de R0, la tabla de R1 y la tabla de R2.**

---

*Cuando termines cada ejercicio dímelo y te corrijo.*
