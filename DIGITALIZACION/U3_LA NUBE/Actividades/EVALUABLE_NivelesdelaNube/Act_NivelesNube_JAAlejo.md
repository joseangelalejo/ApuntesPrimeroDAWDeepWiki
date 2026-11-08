# **Actividad Evaluable: Niveles de la Nube y Computación Distribuida | José Ángel Alejo Sillero**

- **Autor**: José Ángel Alejo Sillero
- **Centro**: Instituto Tecnológico Pablo de la Torre
- **Curso**: 2025/2026
- **Módulo**: Digitalización
- **Unidad**: 3 - La Nube
- **Tipo**: Actividad Evaluable

---
<div style="page-break-after: always;"></div>

> **Tabla de contenidos**

- [**Actividad Evaluable: Niveles de la Nube y Computación Distribuida | José Ángel Alejo Sillero**](#actividad-evaluable-niveles-de-la-nube-y-computación-distribuida--josé-ángel-alejo-sillero)
  - [**1. FOG, MIST y EDGE COMPUTING**](#1-fog-mist-y-edge-computing)
    - [**FOG COMPUTING**](#fog-computing)
    - [**MIST/EDGE COMPUTING**](#mistedge-computing)
  - [**2. Investigar los 3 Niveles de la Nube**](#2-investigar-los-3-niveles-de-la-nube)
    - [**2.1 Definiciones y Ejemplos**](#21-definiciones-y-ejemplos)
      - [**IaaS (Infrastructure as a Service)**](#iaas-infrastructure-as-a-service)
      - [**PaaS (Platform as a Service)**](#paas-platform-as-a-service)
      - [**SaaS (Software as a Service)**](#saas-software-as-a-service)

---
<div style="page-break-after: always;"></div>

## **1. FOG, MIST y EDGE COMPUTING**

### **FOG COMPUTING**

**Definición:** Extensión de la computación en la nube hacia redes locales, colocando recursos de procesamiento y almacenamiento más cerca del usuario final, pero no directamente en los dispositivos.

**Ejemplo distinto a las diapositivas:**

- **Servidor Minecraft con procesamiento local de eventos**: Tu servidor Minecraft en casa ejecuta en Docker y procesa eventos localmente (acciones de jugadores, cambios de chunks, explosiones de creepers) antes de enviar solo los datos relevantes a servicios externos como webhooks de Discord o bases de datos remotas. El servidor Fog (tu PC en casa) maneja la lógica compleja del juego localmente, solo transmite alertas resumidas ("jugador entró a la mina", "servidor a bajo FPS") a la nube, evitando congestionar la red con todo el flujo de datos de Minecraft.

### **MIST/EDGE COMPUTING**

**Definición:** Computación que ocurre en el extremo de la red, directamente en los dispositivos o muy cerca de ellos, minimizando la latencia y reduciendo la cantidad de datos enviados a la nube.

**Ejemplo distinto a las diapositivas:**

- **Grafana en edge para monitoreo del servidor Minecraft**: Instalas Grafana localmente en tu PC (edge device) que recopila métricas en tiempo real del servidor Minecraft (CPU, RAM, jugadores conectados, TPS) desde Prometheus. Grafana procesa y visualiza estos datos localmente con respuesta inmediata. Solo envía alertas críticas a la nube (ej: "Server crashed", "Memory > 95%") o resúmenes agregados a servicios como Discord, evitando saturar la red con telemetría constante. El edge realiza todo el procesamiento y análisis local, transmitiendo solo lo esencial a la nube.

---

## **2. Investigar los 3 Niveles de la Nube**

### **2.1 Definiciones y Ejemplos**

#### **IaaS (Infrastructure as a Service)**

**Definición:** Modelo de servicio en la nube que proporciona recursos de infraestructura virtualizados a través de internet, como servidores, almacenamiento, redes y máquinas virtuales. El usuario gestiona aplicaciones, datos y sistemas operativos, mientras el proveedor maneja la infraestructura física subyacente.

**Ejemplos:**

1. **Servidor Minecraft Paper en tu máquina local con puertos expuestos**: Tu servidor Minecraft de casa ejecuta en Docker con Java 21 (Amazon Corretto), donde tú configuras el Dockerfile, gestionar los plugins, mapas y actualizaciones del servidor, mientras que el servidor físico (hardware) es responsabilidad tuya. Es como si tu PC fuera un servidor virtualizado donde tienes control total de la aplicación y datos.
2. **Servidor MySQL con base de datos RPG en tu hogar**: Tu servidor de base de datos corre en una máquina física en casa (donde gestionar scripts SQL, configuración, usuarios, backups) pero la infraestructura de red, puertos expuestos y conectividad dependen del servidor. Analogía a una VM en la nube donde tienes acceso administrativo total.

#### **PaaS (Platform as a Service)**

**Definición:** Modelo de servicio en la nube que proporciona una plataforma completa de desarrollo e implementación en la nube, incluyendo herramientas, bases de datos, frameworks y middleware. Los usuarios pueden desarrollar, probar y desplegar aplicaciones sin preocuparse por la infraestructura subyacente.

**Ejemplos:**

1. **Docker con docker-compose para tu servidor Minecraft**: Utilizas Docker como plataforma que abstrae la complejidad del sistema operativo. No necesitas preocuparte por las dependencias específicas de Java o la compatibilidad del sistema; Docker proporciona todo el entorno empaquetado. Defines la configuración en `docker-compose.yml` (servidor.properties, plugins, versión de Java) sin tocar infraestructura, solo tu aplicación Minecraft.
2. **Railway o Render para aplicaciones Python**: Plataformas donde subes tu código Python, ellas proporcionan runtime, base de datos, variables de entorno, y todo se escala automáticamente sin que configures VMs, sin gestionar servidores físicos, solo tu lógica de aplicación.

#### **SaaS (Software as a Service)**

**Definición:** Modelo de servicio en la nube que ofrece aplicaciones de software accesibles a través de internet mediante un navegador web. Los usuarios acceden al software sin necesidad de instalarlo localmente, y el proveedor gestiona mantenimiento, actualizaciones y seguridad.

**Ejemplos:**

1. **phpmyadmin o pgAdmin desde la nube**: Si alojaras tu base de datos RPG en un servicio como Render Database o Supabase, accederías a la gestión de la base de datos desde tu navegador sin instalar nada localmente. Todo (backup, actualizaciones, seguridad) lo maneja el proveedor. Es exactamente como usar la interfaz web de tu base de datos en línea.
2. **Discord o Slack para comunicación del servidor**: Aplicaciones completamente en la nube donde no instalas nada en tu PC, todo funciona en el navegador o aplicación ligera, y los proveedores gestionan servidores, actualizaciones y seguridad. Accedes solo desde tu cuenta.
