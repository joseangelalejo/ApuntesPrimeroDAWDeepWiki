# Solución Act 23: MODIFICACIÓN DE DOCUMENTOS XML. XQUERY

## Archivo de Datos (alumnos.xml)

```xml
<?xml version="1.0" encoding="UTF-8"?>
<alumnos>
    <alumno id="1">
        <nombre>Juan</nombre>
        <edad>20</edad>
        <curso>DAW</curso>
        <email>juan@example.com</email>
    </alumno>
    <alumno id="2">
        <nombre>Ana</nombre>
        <edad>19</edad>
        <curso>DAM</curso>
        <email>ana@example.com</email>
    </alumno>
    <alumno id="3">
        <nombre>Luis</nombre>
        <edad>21</edad>
        <curso>ASIR</curso>
        <email>luis@example.com</email>
    </alumno>
</alumnos>
```

---

## SOLUCIONES XQUERY

### 1. Modificar nombre del alumno con id="1" a "Pedro"

```xquery
declare function local:modificarNombre() {
    let $doc := doc('alumnos.xml')
    return 
        replace value of node $doc//alumno[@id="1"]/nombre with "Pedro"
};

local:modificarNombre()
```

**Resultado:** El nombre del alumno 1 cambia de "Juan" a "Pedro".

---

### 2. Modificar edad de Ana a 23 años

```xquery
declare function local:modificarEdadAna() {
    let $doc := doc('alumnos.xml')
    return 
        replace value of node $doc//alumno[nombre = 'Ana']/edad with "23"
};

local:modificarEdadAna()
```

**Resultado:** La edad de Ana se actualiza a 23.

---

### 3. Insertar nodo <telefono> en alumno con id="1"

```xquery
declare function local:insertarTelefono() {
    let $doc := doc('alumnos.xml')
    return 
        insert node <telefono>600111222</telefono> 
        into $doc//alumno[@id="1"]
};

local:insertarTelefono()
```

**Resultado:** Se añade `<telefono>600111222</telefono>` dentro del alumno 1.

---

### 4. Insertar nodo <estado>activo</estado> en todos los alumnos

```xquery
declare function local:insertarEstadoGlobal() {
    let $doc := doc('alumnos.xml')
    return 
        for $alumno in $doc//alumno
        return 
            insert node <estado>activo</estado> into $alumno
};

local:insertarEstadoGlobal()
```

**Resultado:** Se añade el nodo `<estado>activo</estado>` a todos los alumnos.

---

### 5. Insertar <becado>si</becado> solo en alumno Luis

```xquery
declare function local:insertarBecadoLuis() {
    let $doc := doc('alumnos.xml')
    return 
        insert node <becado>si</becado> 
        into $doc//alumno[nombre = 'Luis']
};

local:insertarBecadoLuis()
```

**Resultado:** Se añade `<becado>si</becado>` únicamente en el nodo de Luis.

---

### 6. Eliminar email del alumno con id="3"

```xquery
declare function local:eliminarEmail() {
    let $doc := doc('alumnos.xml')
    return 
        delete node $doc//alumno[@id="3"]/email
};

local:eliminarEmail()
```

**Resultado:** Se elimina el nodo `<email>` del alumno 3.

---

### 7. Eliminar completamente el alumno con id="2"

```xquery
declare function local:eliminarAlumno() {
    let $doc := doc('alumnos.xml')
    return 
        delete node $doc//alumno[@id="2"]
};

local:eliminarAlumno()
```

**Resultado:** Se elimina el nodo alumno 2 completamente (Ana).

---

### 8. Reemplazar curso del alumno id="1" por "DAW"

```xquery
declare function local:reemplazarCurso() {
    let $doc := doc('alumnos.xml')
    return 
        replace node $doc//alumno[@id="1"]/curso 
        with <curso>DAW</curso>
};

local:reemplazarCurso()
```

**Resultado:** El curso del alumno 1 se reemplaza por `<curso>DAW</curso>`.

---

### 9. Renombrar "edad" a "anios" en alumno id="3"

```xquery
declare function local:renombrarEdad() {
    let $doc := doc('alumnos.xml')
    $edad := $doc//alumno[@id="3"]/edad
    return 
        replace node $edad 
        with element anios { $edad/text() }
};

local:renombrarEdad()
```

**Resultado:** El nodo `<edad>` se renombra a `<anios>`.

---

### 10. Añadir atributo matriculado="si" al alumno id="1"

```xquery
declare function local:anadirAtributo() {
    let $doc := doc('alumnos.xml')
    return 
        insert node attribute matriculado { "si" } 
        into $doc//alumno[@id="1"]
};

local:anadirAtributo()
```

**Resultado:** Se añade el atributo `matriculado="si"` al alumno 1.

---

### 11. Modificar atributo matriculado de "si" a "no"

```xquery
declare function local:modificarAtributo() {
    let $doc := doc('alumnos.xml')
    return 
        replace value of node $doc//alumno[@id="1"]/@matriculado with "no"
};

local:modificarAtributo()
```

**Resultado:** El atributo `matriculado` cambia de "si" a "no".

---

### 12. Eliminar atributo matriculado del alumno id="1"

```xquery
declare function local:eliminarAtributo() {
    let $doc := doc('alumnos.xml')
    return 
        delete node $doc//alumno[@id="1"]/@matriculado
};

local:eliminarAtributo()
```

**Resultado:** Se elimina el atributo `matriculado` del alumno 1.

---

### 13. Insertar <direccion>Sevilla</direccion> al principio del alumno id="1"

```xquery
declare function local:insertarDireccionPrincipio() {
    let $doc := doc('alumnos.xml')
    $alumno := $doc//alumno[@id="1"]
    return 
        insert node <direccion>Sevilla</direccion> 
        as first into $alumno
};

local:insertarDireccionPrincipio()
```

**Resultado:** Se añade `<direccion>Sevilla</direccion>` al principio del alumno 1.

---

### 14. Insertar <observaciones>Buen rendimiento</observaciones> al final del alumno id="1"

```xquery
declare function local:insertarObservacionesFinal() {
    let $doc := doc('alumnos.xml')
    return 
        insert node <observaciones>Buen rendimiento</observaciones> 
        as last into $doc//alumno[@id="1"]
};

local:insertarObservacionesFinal()
```

**Resultado:** Se añade `<observaciones>Buen rendimiento</observaciones>` al final del alumno 1.

---

### 15. Insertar nuevo alumno Carlos

```xquery
declare function local:insertarNuevoAlumno() {
    let $doc := doc('alumnos.xml')
    return 
        insert node 
        <alumno id="4">
            <nombre>Carlos</nombre>
            <edad>21</edad>
            <curso>DAM</curso>
        </alumno> 
        into $doc/alumnos
};

local:insertarNuevoAlumno()
```

**Resultado:** Se añade un nuevo alumno con id="4" (Carlos).

---

### 16. Reemplazar alumno id="3" con nuevo alumno

```xquery
declare function local:reemplazarAlumno() {
    let $doc := doc('alumnos.xml')
    return 
        replace node $doc//alumno[@id="3"] 
        with 
        <alumno id="3">
            <nombre>María</nombre>
            <edad>20</edad>
            <curso>DAW</curso>
        </alumno>
};

local:reemplazarAlumno()
```

**Resultado:** El alumno 3 se reemplaza completamente con nuevos datos.

---

### 17. Eliminar todos los emails del documento

```xquery
declare function local:eliminarTodosEmails() {
    let $doc := doc('alumnos.xml')
    return 
        delete node $doc//email
};

local:eliminarTodosEmails()
```

**Resultado:** Se eliminan todos los nodos `<email>` de todo el documento.

---

### 18. Añadir atributo estado="activo" a todos los alumnos

```xquery
declare function local:anadirEstadoGlobal() {
    let $doc := doc('alumnos.xml')
    return 
        for $alumno in $doc//alumno
        return 
            insert node attribute estado { "activo" } into $alumno
};

local:anadirEstadoGlobal()
```

**Resultado:** Se añade `estado="activo"` como atributo a todos los alumnos.

---

### 19. Modificar curso de todos los alumnos a "ASIR"

```xquery
declare function local:modificarCursosGlobal() {
    let $doc := doc('alumnos.xml')
    return 
        for $alumno in $doc//alumno
        return 
            replace value of node $alumno/curso with "ASIR"
};

local:modificarCursosGlobal()
```

**Resultado:** El curso de todos los alumnos se cambia a "ASIR".

---

### 20. Renombrar "curso" a "ciclo" en todo el documento

```xquery
declare function local:renombrarCursoGlobal() {
    let $doc := doc('alumnos.xml')
    return 
        for $curso in $doc//curso
        return 
            replace node $curso 
            with element ciclo { $curso/text() }
};

local:renombrarCursoGlobal()
```

**Resultado:** Todos los nodos `<curso>` se renombran a `<ciclo>`.

---

## Notas Importantes

- Estas consultas requieren **Saxon 9.9+** u otro procesador XQuery compatible
- Algunas operaciones modifycan el documento en memoria
- Para operaciones persistentes, se debe guardar el documento modificado
- El orden de las operaciones es importante en algunas secuencias
