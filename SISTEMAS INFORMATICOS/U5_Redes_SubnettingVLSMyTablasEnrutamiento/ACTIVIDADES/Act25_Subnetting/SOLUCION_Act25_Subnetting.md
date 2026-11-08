# Actividad 25 - Subnetting y Direccionamiento IP con VLSM

## Datos de la Actividad

**Red Base:** 172.30.32.0/22
**Técnica:** VLSM (Variable Length Subnet Masking)
**Objetivo:** Diseñar direccionamiento IP y rutas estáticas para red jerárquica

---

## Subnetting VLSM - Análisis

**Red Base:** 172.30.32.0/22 = 1024 hosts disponibles

**Requisitos de subnets:**

| LAN          | Cantidad Hosts | Bits Necesarios | Hosts Reales |
|--------------|----------------|-----------------|--------------|
| LAN1         | 500            | 10              | 1024 (/22)   |
| LAN2         | 250            | 9               | 512 (/23)    |
| LAN3 (R0-R1) | 2              | 2               | 4 (/30)      |
| LAN4 (R0-R2) | 2              | 2               | 4 (/30)      |
| LAN5 (R1-R2) | 2              | 2               | 4 (/30)      |

---

## TABLA 1: Información de Redes

| LAN          | Dirección de Red | CIDR | Máscara de Subred |
|--------------|------------------|------|-------------------|
| LAN1         | 172.30.32.0      | /22  | 255.255.252.0     |
| LAN2         | 172.30.36.0      | /23  | 255.255.254.0     |
| LAN3 (R0-R1) | 172.30.38.0      | /30  | 255.255.255.252   |
| LAN4 (R0-R2) | 172.30.38.4      | /30  | 255.255.255.252   |
| LAN5 (R1-R2) | 172.30.38.8      | /30  | 255.255.255.252   |

---

## TABLA 2: Rango de Direcciones IP de Hosts

| LAN          | 1ª Dirección de Host | Última Dirección de Host | Dirección Broadcast |
|--------------|----------------------|--------------------------|---------------------|
| LAN1         | 172.30.32.1          | 172.30.35.254            | 172.30.35.255       |
| LAN2         | 172.30.36.1          | 172.30.37.254            | 172.30.37.255       |
| LAN3 (R0-R1) | 172.30.38.1          | 172.30.38.2              | 172.30.38.3         |
| LAN4 (R0-R2) | 172.30.38.5          | 172.30.38.6              | 172.30.38.7         |
| LAN5 (R1-R2) | 172.30.38.9          | 172.30.38.10             | 172.30.38.11        |

---

## TABLA 3: Direcciones IP de Interfaces de Routers

| Interfaz     | Router     | Dirección IP | Máscara         |
|--------------|------------|--------------|-----------------|
| LAN1         | R0 (ge0/0) | 172.30.32.1  | 255.255.252.0   |
| LAN2         | R1 (ge0/0) | 172.30.36.1  | 255.255.254.0   |
| Enlace R0-R1 | R0 (ge0/1) | 172.30.38.1  | 255.255.255.252 |
| Enlace R0-R1 | R1 (ge0/1) | 172.30.38.2  | 255.255.255.252 |
| Enlace R0-R2 | R0 (ge1/0) | 172.30.38.5  | 255.255.255.252 |
| Enlace R0-R2 | R2 (ge0/0) | 172.30.38.6  | 255.255.255.252 |
| Enlace R1-R2 | R1 (ge1/0) | 172.30.38.9  | 255.255.255.252 |
| Enlace R1-R2 | R2 (ge0/1) | 172.30.38.10 | 255.255.255.252 |

---

## TABLA 4: Puertas de Enlace por Red

| LAN  | Puerta de Enlace (Gateway) | Dirección IP | Máscara       |
|------|----------------------------|--------------|---------------|
| LAN1 | R0 (ge0/0)                 | 172.30.32.1  | 255.255.252.0 |
| LAN2 | R1 (ge0/0)                 | 172.30.36.1  | 255.255.254.0 |

---

## Cálculos de Verificación

### LAN1 (/22)

- Rango: 172.30.32.0 - 172.30.35.255
- Hosts útiles: 172.30.32.1 - 172.30.35.254 (1022 hosts)
- Siguiente red: 172.30.36.0

### LAN2 (/23)

- Rango: 172.30.36.0 - 172.30.37.255
- Hosts útiles: 172.30.36.1 - 172.30.37.254 (510 hosts)
- Siguiente red: 172.30.38.0

### Enlaces Punto a Punto (/30)

- LAN3: 172.30.38.0 - 172.30.38.3
- LAN4: 172.30.38.4 - 172.30.38.7
- LAN5: 172.30.38.8 - 172.30.38.11

**Total de direcciones usadas:** 1022 + 510 + 4 + 4 + 4 = 1544 (dentro de los 1024 disponibles × 1.5 = bien distribuido)
