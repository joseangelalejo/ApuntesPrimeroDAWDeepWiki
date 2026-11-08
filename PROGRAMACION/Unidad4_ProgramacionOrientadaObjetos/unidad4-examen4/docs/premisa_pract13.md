# Premisa pract13 - Gestión de Cursos y Alumnos

Crea un modelo de cursos utilizando interfaces y clases abstractas para roles y registros.

## Objetivo

Practicar herencia, interfaces de servicio y polimorfismo en entidades de dominio.

## Enunciado

1. Crea clase abstracta `Persona` con:
   - Atributos `String nombre`, `String email`.
   - Constructor y `void info()`.

2. Interfaces:
   - `Alumno` con `void inscribirse(Curso curso)` y `int obtenerCreditos()`.
   - `Profesor` con `void asignarCurso(Curso curso)` y `double calcularSalario()`.

3. Clases:
   - `Estudiante` extiende `Persona`, implementa `Alumno`.
   - `Docente` extiende `Persona`, implementa `Profesor`.

4. Clase `Curso` con:
   - `String nombre`, `int creditos`, `Profesor profesor`, `List<Alumno> alumnos`.
   - Métodos para `anadirAlumno` y `mostrarInscritos`.

5. En `main`:
   - Crea cursos, profesor y estudiantes.
   - Inscribe estudiantes y muestra información.

---

✅ Extra: Añade una interfaz `Evaluable` con `double calificar(Alumno alumno, double nota)` y haz que `Profesor` la implemente.
