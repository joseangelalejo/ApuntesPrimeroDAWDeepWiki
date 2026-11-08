# Proceso de Creación y Justificación de los Scripts SQL para CS2-SVSS (Fragify)

## Información del Documento

- **Autor**: José Ángel Alejo Sillero
- **Proyecto**: CS2-SVSS - Counter Strike 2 Stats Visualizing System (Fragify)
- **Fecha de creación**: 12 de enero de 2026
- **Versión**: 1.0
- **Propósito**: Documentar el proceso de desarrollo de los scripts SQL, incluyendo decisiones técnicas y justificaciones basadas en la ERS y el modelo ER/LR.

## Introducción

Este documento detalla el proceso de creación de los scripts SQL para la base de datos del proyecto CS2-SVSS (Fragify), un sistema backend para recopilar y visualizar estadísticas de Counter-Strike 2. El proceso se basó en la Especificación de Requisitos de Software (ERS) y el modelo Entidad-Relación/Lógico-Relacional (ER/LR), asegurando cumplimiento con principios ACID, formas normales y requisitos de seguridad.

El objetivo es proporcionar una base de datos robusta para almacenar datos de jugadores, estadísticas, rankings, partidas, servidores, reportes y logs de auditoría, preparada para futuras expansiones como el frontend.

## Análisis de Requisitos

### Fuentes

- **ERS (ERS CS2-SVSS_Jose-Angel-Alejo.md)**: Define entidades, atributos, relaciones y requisitos funcionales (almacenamiento, integridad, seguridad, mantenimiento).
- **Modelo ER/LR (Modelado_CS2SVSS_JAAlejo.md)**: Transforma el conceptual en relacional, aplicando FN (1FN, 2FN, 3FN) y reglas de integridad.

### Entidades Identificadas

Se identificaron 7 entidades principales:

1. **JUGADORES_CS2**: Perfiles de usuarios registrados.
2. **SERVIDORES_CS2**: Información de servidores de juego.
3. **ESTADISTICAS_CS2**: Métricas de rendimiento por jugador.
4. **RANKINGS_CS2**: Puntuaciones ELO y posiciones.
5. **PARTIDAS_CS2**: Detalles de partidas jugadas.
6. **REPORTES_CONDUCTA**: Reportes de conducta (futuro).
7. **LOGS_AUDITORIA**: Registros para auditoría y RGPD.

### Requisitos Clave

- **Almacenamiento**: Datos precisos y en tiempo real vía APIs/Steam.
- **Integridad**: Claves primarias naturales (e.g., Steam_ID64), FKs con CASCADE/SET NULL, CHECK constraints.
- **Seguridad**: Cifrado (preparado), autenticación OAuth, logs de auditoría.
- **Mantenimiento**: Soft deletes implícitos, backups y RTO/RPO.
- **Compatibilidad**: MySQL 8.0.11, ENGINE=InnoDB, CHARSET=utf8mb4.

## Diseño de Tablas

Cada tabla se diseñó siguiendo el modelo LR, con atributos atómicos, tipos de datos apropiados y restricciones.

### 1. JUGADORES_CS2

- **Atributos**: steam_id64 (PK, VARCHAR(17)), nombre_usuario_steam, fecha_registro_fragify, estado_verificacion, clave_juego_unica, ultima_actualizacion_datos, estado_actividad.
- **Justificación**: Steam_ID64 como PK natural para unicidad. CHECK para formato numérico. Índices en campos de búsqueda. Prepara FKs a otras tablas.

### 2. SERVIDORES_CS2

- **Atributos**: id_servidor (PK AUTO_INCREMENT), ip_servidor, region, tipo_servidor, ping_promedio, ultima_actualizacion.
- **Justificación**: PK surrogate para simplicidad. CHECK para ping >=0. Índices en region/tipo para filtrado rápido.

### 3. ESTADISTICAS_CS2

- **Atributos**: id_estadistica (PK AUTO_INCREMENT), steam_id64 (FK), kills, deaths, assists, headshots, clutches, kd_ratio, mvps, tiempo_jugado, ultima_actualizacion.
- **Justificación**: FK a JUGADORES_CS2 con CASCADE. CHECK para kd_ratio >=0 y tiempo_jugado >=0. Índices en steam_id64 y kd_ratio para consultas.

### 4. RANKINGS_CS2

- **Atributos**: id_ranking (PK AUTO_INCREMENT), steam_id64 (FK), tipo_ranking, mapa, puntos_elo, tier, posicion_global, ultima_actualizacion.
- **Justificación**: Soporta PREMIERE y mapas. CHECK para puntos_elo >=0. Índices en steam_id64, tipo_ranking y puntos_elo DESC.

### 5. PARTIDAS_CS2

- **Atributos**: id_partida (PK), mapa, modo, resultado, duracion_minutos, fecha_partida, steam_id64 (FK), id_servidor (FK), kills, deaths.
- **Justificación**: id_partida como PK natural (de Valve). FKs con CASCADE/SET NULL. CHECK para duracion >0. Índices en steam_id64, fecha y mapa.

### 6. REPORTES_CONDUCTA

- **Atributos**: id_reporte (PK AUTO_INCREMENT), steam_id64_reportado (FK), steam_id64_reportador (FK), motivo, descripcion, evidencia, fecha_reporte, estado_reporte.
- **Justificación**: Dos FKs a JUGADORES_CS2. ENUM para motivo/estado. CHECK para fecha <= NOW. Índices en reportado/reportador/estado.

### 7. LOGS_AUDITORIA

- **Atributos**: id_log (PK AUTO_INCREMENT), tabla_afectada, accion, steam_id64_usuario, descripcion, fecha_log, ip_origen.
- **Justificación**: Sin FKs directas. DEFAULT CURRENT_TIMESTAMP para fecha_log. CHECK para fecha <= NOW. Índices en tabla_afectada, fecha y usuario.

## Restricciones de Integridad de Datos

Cada restricción previene un problema específico de consistencia de datos.

### JUGADORES_CS2

#### chk_steam_id64_format

- **Restricción**: `steam_id64 REGEXP '^[0-9]{17}$'`
- **Problema que evita**: Inserción de Steam IDs malformados que no coincidan con el estándar de Valve (exactamente 17 dígitos numéricos).
- **Por qué en esta columna**: steam_id64 es el identificador crítico para todas las integraciones con APIs de Valve y relaciones con otras tablas. Un formato incorrecto comprometería la sincronización de datos.
- **Impacto**: Garantiza que solo Steam IDs válidos se almacenen, manteniendo coherencia con el ecosistema de Steam.

#### chk_fecha_registro

- **Restricción**: `fecha_registro_fragify <= NOW()`
- **Problema que evita**: Registros con fechas futuras que falsearían la cronología de cuando un jugador fue agregado a la BD.
- **Por qué en esta columna**: La fecha de registro es auditable y legal (RGPD). Una fecha futura indicaría un error de inserción o manipulación malintencionada.
- **Impacto**: Mantiene la integridad temporal del sistema y facilita cumplimiento normativo.

#### chk_ultima_actualizacion

- **Restricción**: `ultima_actualizacion_datos <= NOW()`
- **Problema que evita**: Registro de actualizaciones futuras que no tiene sentido lógico en un sistema de datos en tiempo real.
- **Por qué en esta columna**: El servicio API continuamente actualiza este timestamp. Una fecha futura indicaría fallo en la sincronización.
- **Impacto**: Detecta errores de sincronización de APIs.

### SERVIDORES_CS2

#### chk_ping

- **Restricción**: `ping_promedio >= 0 OR ping_promedio IS NULL`
- **Problema que evita**: Valores negativos de latencia, que son imposibles en redes reales.
- **Por qué en esta columna**: El ping es una métrica de rendimiento crítica. Valores negativos indican corrupción de datos de medición.
- **Impacto**: Asegura métricas realistas de disponibilidad de servidores.

#### chk_ultima_actualizacion_serv

- **Restricción**: `ultima_actualizacion <= NOW()`
- **Problema que evita**: Fechas futuras en registros de verificación de servidores.
- **Por qué en esta columna**: Marca cuándo se verificó últimamente si el servidor está disponible. Futuro = dato incoherente.
- **Impacto**: Mantiene validez de información de estado de servidores.

### ESTADISTICAS_CS2

#### chk_kd_ratio

- **Restricción**: `kd_ratio >= 0`
- **Problema que evita**: Ratios K/D negativos (matemáticamente imposibles).
- **Por qué en esta columna**: K/D es la métrica más importante de rendimiento. Un valor negativo indicaría fallo en cálculo o corrupción de datos.
- **Impacto**: Garantiza métricas de rendimiento válidas para ranking y comparativas.

#### chk_tiempo_jugado

- **Restricción**: `tiempo_jugado >= 0`
- **Problema que evita**: Tiempos negativos de juego (imposibles).
- **Por qué en esta columna**: El tiempo jugado es auditable. Valores negativos indican errores de sincronización de APIs.
- **Impacto**: Asegura coherencia en estadísticas de experiencia del jugador.

#### chk_ultima_actualizacion_est

- **Restricción**: `ultima_actualizacion <= NOW()`
- **Problema que evita**: Timestamps futuros en actualización de estadísticas.
- **Por qué en esta columna**: Critical para auditar cuándo se sincronizaron datos de APIs. Futuro = fallo de sincronización.
- **Impacto**: Detecta errores en pipeline de actualización de datos.

### RANKINGS_CS2

#### chk_puntos_elo

- **Restricción**: `puntos_elo >= 0`
- **Problema que evita**: Puntos ELO negativos (sistema de ranking no permite valores menores a 0).
- **Por qué en esta columna**: ELO es el sistema de ranking oficial de PREMIERE (ERS). Valores negativos son inválidos según reglas de Valve.
- **Impacto**: Asegura que el ranking sea válido según sistema de Valve.

#### chk_posicion_global

- **Restricción**: `posicion_global > 0 OR posicion_global IS NULL`
- **Problema que evita**: Posiciones 0 o negativas (posiciones deben comenzar en 1), o datos incompletos almacenados como 0.
- **Por qué en esta columna**: Posición global es solo para PREMIERE. Si está presente, debe ser válida (>0). Si no está disponible, NULL es válido.
- **Impacto**: Previene anomalías en rankings y facilita filtrado de datos incompletos.

#### chk_ultima_actualizacion_rank

- **Restricción**: `ultima_actualizacion <= NOW()`
- **Problema que evita**: Rankings con timestamps futuros.
- **Por qué en esta columna**: Rankings son actualizados por APIs. Una fecha futura indicaría error de sincronización o reloj desincronizado.
- **Impacto**: Mantiene la validez del ranking competitivo.

### PARTIDAS_CS2

#### chk_duracion

- **Restricción**: `duracion_minutos > 0`
- **Problema que evita**: Partidas con duración 0 o negativa (todas las partidas duran al menos algunos minutos).
- **Por qué en esta columna**: Duración es requisito mínimo. Valor 0 o negativo = error de recopilación de datos.
- **Impacto**: Asegura integridad de estadísticas de partidas.

#### chk_fecha_partida

- **Restricción**: `fecha_partida <= NOW()`
- **Problema que evita**: Partidas jugadas "en el futuro" (imposible).
- **Por qué en esta columna**: La fecha de partida es auditable. Futuro = error en sincronización o timestamp del servidor incorrecto.
- **Impacto**: Detecta problemas en recopilación de datos de partidas.

### REPORTES_CONDUCTA

#### chk_fecha_reporte

- **Restricción**: `fecha_reporte <= NOW()`
- **Problema que evita**: Reportes registrados con fechas futuras.
- **Por qué en esta columna**: La fecha de reporte es crítica para auditoría (RGPD y cumplimiento legal). Futuro = error de datos.
- **Impacto**: Garantiza integridad temporal de reportes para inspectores de Valve.

### LOGS_AUDITORIA

#### chk_fecha_log

- **Restricción**: `fecha_log <= NOW()`
- **Problema que evita**: Logs con timestamps futuros que comprometerían la auditoría temporal.
- **Por qué en esta columna**: Los logs son la única pista de auditoría. Una fecha futura invalidaría la trazabilidad del sistema.
- **Impacto**: Asegura confiabilidad de auditoría y cumplimiento de RGPD.

## Índices y Optimización de Rendimiento

Los índices se crearon en campos de consulta frecuente mencionados en la ERS para cumplir el requisito: "90% de las consultas típicas del sistema se completen en menos de 1.5 segundos".

### Índices en JUGADORES_CS2

- **idx_nombre_usuario**: Búsquedas rápidas de jugadores por nombre de usuario (búsqueda en frontend de Fragify). Evita table scan completo.
- **idx_estado_verificacion**: Filtrado de cuentas verificadas vs no verificadas. Crítico para lógica de negocio de acceso a datos avanzados.
- **idx_estado_actividad**: Estadísticas de jugadores activos/inactivos. Necesario para reportes administrativos y análisis de usuario.

### Índices en SERVIDORES_CS2

- **idx_region**: Filtrado de servidores por región geográfica. La ERS menciona análisis de latencia por región.
- **idx_tipo_servidor**: Diferenciación entre servidores oficiales y comunitarios. Simplifica consultas de disponibilidad.

### Índices en ESTADISTICAS_CS2

- **idx_steam_estadisticas**: Lookup rápido de estadísticas por jugador (FK). Crítico para joins con tabla JUGADORES_CS2 en dashboard.
- **idx_kd_ratio**: Ordenamiento descendente para ranking por K/D. ERS especifica necesidad de "ranking por rendimiento" para dashboard.

### Índices en RANKINGS_CS2

- **idx_steam_rankings**: Lookup rápido de rankings por jugador. Necesario para mostrar ranking actual en perfil.
- **idx_tipo_ranking**: Separa consultas de PREMIERE vs mapas. Dos flujos diferentes en plataforma web.
- **idx_puntos_elo DESC**: Ranking global ELO descendente. ERS especifica "tabla de clasificación global" como requisito crítico.

### Índices en PARTIDAS_CS2

- **idx_steam_partidas**: Historial de partidas de un jugador. Consulta muy frecuente en dashboard de jugador.
- **idx_fecha_partida**: Filtrado de partidas recientes. Vista `vw_partidas_recientes_jugador` depende de este índice para rendimiento.
- **idx_mapa**: Análisis de rendimiento por mapa. ERS menciona "estadísticas segregadas por mapa".

### Índices en REPORTES_CONDUCTA

- **idx_reportado**: Búsqueda de reportes sobre un jugador específico. Inspector de Valve necesita saber "cuántos reportes tiene un usuario".
- **idx_reportador**: Validación de quién hace reportes. Auditoría de integridad de reportes.
- **idx_estado_reporte**: Filtrado de reportes pendientes, revisados, resueltos. Flujo de trabajo de Overwatch depende de esto.

### Índices en LOGS_AUDITORIA

- **idx_tabla_afectada**: Filtrado de logs por tabla. Análisis de qué tabla ha sufrido cambios.
- **idx_fecha_log**: Búsquedas temporales de logs. Auditoría RGPD requiere poder extraer cambios en un período.
- **idx_steam_log**: Trazabilidad de actividad de usuario. RGPD: "quién ha accedido mis datos".

**NOTA**: Tabla LOGS_AUDITORIA NO tiene índices adicionales fuera de PKs porque:

1. Bajo volumen de consultas críticas de rendimiento (logs son principalmente archivados).
2. Prioridad baja comparada con tablas operacionales.
3. Los tres índices presentes cubren los casos de auditoría principales.

## Vistas Estratégicas (Views)

Las vistas optimizan consultas frecuentes mencionadas en la ERS y mejoran rendimiento sin modificar tablas base.

### Vistas Creadas

#### 1. vw_ranking_jugadores_elo

- **Utilidad**: Ranking de top 100 jugadores por puntos ELO PREMIERE sin necesidad de joins repetitivos.
- **Justificación**: La ERS especifica "tabla de clasificación global PREMIERE" como requisito crítico de rendimiento. Esta vista evita cálculos repetidos y mejora UX del dashboard.
- **Rendimiento**: Elimina necesidad de evaluar todas las relaciones PREMIERE; presentación directa del ranking.

#### 2. vw_estadisticas_jugador_resumen

- **Utilidad**: Dashboard de estadísticas agregadas (kills, deaths, K/D, MVPs) sin cálculos en tiempo real.
- **Justificación**: Consulta muy frecuente en perfil de jugador. Precalcular este resumen mejora significativamente la UX de Fragify.
- **Rendimiento**: Joins previos de JUGADORES_CS2 + ESTADISTICAS_CS2; cliente recibe datos listos para presentar.

#### 3. vw_reportes_pendientes_valve

- **Utilidad**: Filtrado de reportes NO resueltos con información contextual para inspectores de Valve.
- **Justificación**: ERS Sección 1.2 especifica que "Valve Corporation accede con permisos de solo lectura a reportes". Esta vista facilita el flujo de trabajo de Overwatch sin exponer datos sensibles.
- **Rendimiento**: Prefiltra PENDIENTE, agrega nombres de jugadores, calcula días desde reporte.

#### 4. vw_partidas_recientes_jugador

- **Utilidad**: Últimas 10 partidas de un jugador sin procesar tabla PARTIDAS completa (escala a millones de registros).
- **Justificación**: Historial de partidas es consulta típica en plataforma web. Evita table scan costoso.
- **Rendimiento**: LIMIT 1000 precompilado; cliente obtiene datos listos para mostrar en UI.

#### 5. vw_rendimiento_por_mapa

- **Utilidad**: Análisis segregado de rendimiento por mapa (tasa victoria, K/D, cantidad de partidas).
- **Justificación**: ERS requiere "análisis de rendimiento por mapa". Esta vista facilita consultas complejas con GROUP BY.
- **Rendimiento**: Precalcula agregaciones costosas (COUNT, SUM, AVG, tasa de victoria).

### Justificación de Ausencia de Vistas por Tabla

#### JUGADORES_CS2 - SIN VISTA ADICIONAL

**Justificación**: Esta tabla es la base de todas las relaciones. Las consultas sobre JUGADORES_CS2 generalmente requieren contexto de otras tablas (estadísticas, rankings, partidas). No hay una "vista estándar" de jugadores que mejore rendimiento; las vistas que existen (`vw_estadisticas_jugador_resumen`, `vw_ranking_jugadores_elo`) ya incorporan datos de JUGADORES_CS2 con su contexto.

#### SERVIDORES_CS2 - SIN VISTA ADICIONAL

**Justificación**: Tabla pequeña con baja frecuencia de consulta. Las partidas incluyen referencias a servidores, pero no existe una consulta "estándar" que justifique una vista. Si en futuro se necesita "top servidores por latencia promedio" o "servidores con más uso", se podría crear entonces.

#### ESTADISTICAS_CS2 - CONSUMIDA POR VISTA vw_estadisticas_jugador_resumen

**Justificación**: Las consultas sobre esta tabla siempre van acompañadas del jugador (FK a JUGADORES_CS2). La vista `vw_estadisticas_jugador_resumen` cubre el caso de uso principal. Consultas específicas de estadísticas (ej: "jugadores con K/D > 2.0") son puntuales y no justifican vista.

#### RANKINGS_CS2 - CONSUMIDA POR VISTA vw_ranking_jugadores_elo

**Justificación**: La vista `vw_ranking_jugadores_elo` cubre el caso de ranking PREMIERE (requisito crítico de ERS). Para ranking por mapa, no hay una consulta "estándar"; cada consulta de ranking por mapa es específica del mapa.

#### PARTIDAS_CS2 - CONSUMIDA POR VISTAS vw_partidas_recientes_jugador y vw_rendimiento_por_mapa

**Justificación**: Tabla que crece indefinidamente (cientos de miles de registros). Las vistas existentes cubren los dos casos de uso principales de rendimiento. Consultas puntuales (ej: "partidas entre dos fechas específicas") son ad-hoc y no justifican vista persistente.

#### REPORTES_CONDUCTA - CONSUMIDA POR VISTA vw_reportes_pendientes_valve

**Justificación**: La vista `vw_reportes_pendientes_valve` cubre el flujo de trabajo de Valve (solo lectura de pendientes). Otras consultas de reportes (ej: "todos los reportes de un jugador", "reportes resueltos") son específicas del contexto y no justifican vistas adicionales.

#### LOGS_AUDITORIA - SIN VISTA ADICIONAL

**Justificación**: Tabla de auditoría/cumplimiento normativo. Las consultas son principalmente archivado y análisis temporal (ej: "logs del último mes", "quién modificó la tabla X"). No hay una consulta "estándar" que justifique vista; cualquier vista sería demasiado específica del caso de uso.

## Proceso de Creación

1. **Análisis**: Lectura profunda de ERS y Modelado para extraer entidades/atributos.
2. **Creación individual**: Scripts separados por tabla, siguiendo estilo observado (comentarios /* */, DROP IF EXISTS, restricciones).
3. **Fusión**: Combinación en `cs2svss_full.sql` con creación de BD y USE.
4. **Ordenación**: Renombrado con prefijos numéricos (1- al 7-) para ejecución secuencial.
5. **Refinamiento**: Eliminación de separadores genéricos, aplicación de igualdades cortas para personalización.

## Decisiones Técnicas

- **MySQL 8.0.11**: Soporte para CHECK constraints, utf8mb4, expresiones en DEFAULT.
- **Formas Normales**: 1FN (atributos atómicos), 2FN/3FN (dependencias completas, sin transitivas).
- **Restricciones**: CHECK para validaciones (e.g., fechas no futuras), UNIQUE implícito en PKs.
- **Índices**: En FKs y campos de consulta frecuente para rendimiento.
- **Engine/Charset**: InnoDB para transacciones, utf8mb4 para caracteres Unicode.
- **Orden de creación**: Basado en dependencias (tablas base primero).

## Roles, Usuarios y Permisos

Implementación del modelo de control de acceso basado en roles especificado en ERS Sección 3.3. Cumple requisitos de seguridad y preparación para futuras integraciones.

### Rol 1: ADMINISTRADOR DEL SISTEMA (admin_cs2)

- **Descripción**: Usuario administrativo con acceso total a la base de datos.
- **Qué puede hacer**: Crear/modificar/eliminar cualquier objeto. Gestionar usuarios. Ejecutar backups. Modificar configuración.
- **Por qué estos permisos**: Necesita control total para:
  1. Mantenimiento de integridad estructural (ALTER TABLE, índices, vistas).
  2. Gestión de seguridad y permisos de otros usuarios.
  3. Operaciones de backup y recovery (RGPD, continuidad del negocio).
  4. Optimización de rendimiento.
  5. Cumplimiento normativo (auditoría, logs de cambios).
- **Restricciones**: Uso restringido a personal de operaciones. No para aplicaciones.

### Rol 2: SERVICIO API (api_service)

- **Descripción**: Usuario para servicio de actualización automática de datos desde APIs de Valve.
- **Qué puede hacer**:
  - **SELECT**: Leer datos públicos de jugadores y servidores.
  - **INSERT/UPDATE**: Crear/actualizar estadísticas, rankings y partidas.
  - **SELECT (logs_auditoria)**: Solo lectura para auditoría.
- **Por qué estos permisos**: La ERS especifica "sincronización automática de datos vía APIs/Steam". El servicio API necesita:
  1. INSERT en ESTADISTICAS_CS2, RANKINGS_CS2, PARTIDAS_CS2 (nuevos datos).
  2. UPDATE en las mismas tablas (datos actualizados de Valve).
  3. SELECT de JUGADORES_CS2 y SERVIDORES_CS2 para contexto de inserciones.
  4. SELECT de LOGS_AUDITORIA para validar auditoría.
- **Restricciones**: SIN permisos para DELETE (preservar historial). SIN acceso a reportes (datos sensibles). SIN acceso a logs de auditoría excepto lectura.

### Rol 3: INSPECTOR DE VALVE (valve_inspector)

- **Descripción**: Usuario de solo lectura para Valve Corporation, especializado en revisión de reportes.
- **Qué puede hacer**:
  - **SELECT**: Lectura de reportes de conducta, datos de jugadores reportados, estadísticas contextuales, partidas (para acceder a demos).
- **Por qué estos permisos**: ERS Sección 1.2 especifica: "Valve Corporation accede con permisos de solo lectura a reportes". Necesita:
  1. Acceso a REPORTES_CONDUCTA para casos a revisar (inspectores de Overwatch).
  2. Datos de JUGADORES_CS2 para contexto (quién es el reportado, quién reportó).
  3. Datos de ESTADISTICAS_CS2 y PARTIDAS_CS2 para investigar conducta en contexto histórico.
  4. SELECT-only garantiza que no puede manipular pruebas.
- **Restricciones**: Solo lectura (CRITICAL). Host restringido a servidores de Valve. SIN acceso a LOGS_AUDITORIA (proteger privacidad de otros usuarios).

### Rol 4: JUGADOR FRAGIFY (jugador_fragify)

- **Descripción**: Usuario de plataforma web Fragify (jugador final).
- **Qué puede hacer**:
  - **SELECT**: Leer propias estadísticas, rankings y historial de partidas.
- **Por qué estos permisos**: Plataforma web futura permite jugadores ver su perfil público. Necesita:
  1. Acceso a ESTADISTICAS_CS2 (su K/D, MVPs, tiempo jugado).
  2. Acceso a RANKINGS_CS2 (su posición ELO, tier).
  3. Acceso a PARTIDAS_CS2 (historial de partidas jugadas).
  4. SELECT-only (no puede modificar su perfil vía BD).
- **Restricciones**: En futuro, se añadirá control a nivel de fila (Row-Level Security) vía aplicación para que vea solo SUS datos.
  SIN acceso a reportes (no vería reportes de otros). SIN acceso a LOGS_AUDITORIA.

### Acceso por Host

- **admin_cs2**: localhost (máquina de administración local).
- **api_service**: localhost (servicio backend en mismo servidor).
- **valve_inspector**: remote_valve_server (acceso remoto desde infraestructura de Valve; en producción, requeriría VPN y certificados).
- **jugador_fragify**: localhost (aplicación web en mismo servidor; en producción, aplicación serviría como proxy).

## Conclusión

Los scripts garantizan una BD escalable, segura y eficiente, completamente alineada con la ERS y modelo ER/LR. Incluyen:

- **7 tablas normalizadas** (1FN, 2FN, 3FN) con integridad referencial.
- **10 restricciones CHECK** validando consistencia de datos.
- **13 índices estratégicos** optimizando rendimiento para cumplir requisito de "<1.5s por consulta".
- **5 vistas** facilitando consultas complejas frecuentes.
- **4 roles con permisos diferenciados** implementando control de acceso basado en roles (RBAC).
- **Cumplimiento de principios ACID** y estándares IEEE 830-1998.
- **Preparación para futuras expansiones**: Frontend, sistema de reportes Valve, autenticación OAuth, RGPD.

Beneficios finales:

- Integridad referencial garantizada por FKs y CHECKs.
- Optimización de consultas por índices y vistas.
- Seguridad mediante RBAC y control de acceso diferenciado.
- Auditoría completa mediante logs y timestamps.
- Escalabilidad demostrada en diseño normalizado.

Próximos pasos: Implementación de triggers para auditoría automática, pruebas de carga hasta 200 partidas/segundo, y validación con conjunto de datos real de CS2.

Este proceso asegura calidad, mantenibilidad y profesionalismo, cumpliendo estándares académicos e industriales.
