# Premisa Actividad 11: Clases Cuatro - Password

Crea una clase Password que tenga como atributo un String que representa una contraseña.
La clase Password contendrá un método llamado esFuerte() que comprueba si la contraseña es fuerte o no según estas normas:

- La longitud es como mínimo de 8 caracteres.
- Contiene como mínimo dos letras mayúsculas, dos letras minúsculas, un dígito y al menos un punto o un guión bajo.

El método esFuerte() devuelve un boolean indicando si la contraseña es fuerte o no.
La clase contendrá también un método modificarContraseña() para cambiar una contraseña ya existente. El método modificarContraseña() pide por teclado un String que contenga una nueva contraseña. Si la contraseña introducida es fuerte se modifica la contraseña actual. Si no es fuerte se deja la contraseña actual sin modificar. El método devuelve true si se ha modificado la contraseña y false en caso contrario.
El valor de una contraseña solo se podrá modificar mediante el método modificarContraseña().

Además de estos métodos puedes añadir a la clase los métodos que consideres necesarios.
Una vez creada la clase Password escribe un programa para probar el funcionamiento de la clase.

Ampliación: La clase Password contendrá los siguientes constructores:

- Constructor por defecto que genera una contraseña de longitud 8.
- Constructor con un parámetro de tipo int. Este parámetro indica la longitud de la contraseña que se va a crear.

Las contraseñas en ambos casos se generan al azar y contendrán letras mayúsculas, letras minúsculas, dígitos y los caracteres . (punto) y _ (guión bajo).
