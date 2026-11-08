# Hoja repaso pre-examen

- **Métodos static**: `public static tipo nombre(parámetros) { lógica; return valor; }`
  - **Llamada**: `Clase.metodo(args)`.
  - **Main, asignación**: `tipo var = Clase.metodo();` o imprime directamente.
- **Strings básicos**: `length()` (longitud), `equals()` (comparar), `toUpperCase()` (mayúsculas), `toLowerCase()` (minúsculas).
- **Operador ternario**: `(condición) ? valorTrue : valorFalse` - Para condicionales simples en una línea.
- **Constructor**: `public Clase(tipo param) { this.var = param; }` - Para inicializar objetos.
- **Instancia en main**: `Clase obj = new Clase(args);` - Crea objeto con constructor.
- **Acceder atributos instancia**: `objeto.atributo` - Para usar datos de instancia en llamadas a métodos.

> 📖 **1. STRINGS - MÉTODOS ESENCIALES**

| Método                     | Función              | Ejemplo                                  |
|----------------------------|----------------------|------------------------------------------|
| `length()`                 | Nº de caracteres     | `"Hola".length()` → 4                    |
| `charAt(index)`            | Carácter en posición | `"Hola".charAt(0)` → 'H'                 |
| `equals(String)`           | Compara exacto       | `"Hola".equals("hola")` → false          |
| `equalsIgnoreCase(String)` | Compara sin mayús    | `"Hola".equalsIgnoreCase("hola")` → true |
| `toUpperCase()`            | A mayúsculas         | `"hola".toUpperCase()` → "HOLA"          |
| `toLowerCase()`            | A minúsculas         | `"HOLA".toLowerCase()` → "hola"          |
| `indexOf(char)`            | Busca posición       | `"Hola".indexOf('l')` → 2                |
| `lastIndexOf(char)`        | Última posición      | `"Hola".lastIndexOf('l')` → 2            |
| `substring(inicio, fin)`   | Extrae subcadena     | `"Hola".substring(0, 2)` → "Ho"          |
| `split(delimitador)`       | Divide en array      | `"A,B,C".split(",")` → ["A","B","C"]     |
| `trim()`                   | Quita espacios       | `"  Hola  ".trim()` → "Hola"             |
