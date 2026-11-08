# Actividad 22 - Consultas XQuery I | José Ángel Alejo Sillero

## Solución

### 1. Nodos título sin etiqueta y ordenados alfabéticamente

```xquery
for $titulo in doc("videojuegos.xml")//titulo
order by data($titulo)
return data($titulo)
```

### 2. Juego más caro y más barato

```xquery
let $juegos := doc("videojuegos.xml")//videojuego
return concat(
    "El juego más caro es: ", data($juegos[precio = max($juegos/precio)]/titulo),
    " y el más barato es: ", data($juegos[precio = min($juegos/precio)]/titulo)
)
```

### 3. Juegos que sean de género RPG

```xquery
for $juego in doc("videojuegos.xml")//videojuego[genero = "RPG"]
return $juego
```

### 4. Títulos y protagonistas

```xquery
for $juego in doc("videojuegos.xml")//videojuego
return (
    <juego>
        <titulo>{data($juego/titulo)}</titulo>
        {
            for $protagonista in $juego/protagonistas/personaje
            return <protagonista>{data($protagonista)}</protagonista>
        }
    </juego>
)
```

### 5. Títulos de juegos anteriores al año 2020

```xquery
for $juego in doc("videojuegos.xml")//videojuego[anio < 2020]
return concat("título: ", data($juego/titulo), " y año: ", data($juego/anio))
```
