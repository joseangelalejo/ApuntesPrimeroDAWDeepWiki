package act12clase5banco;
// Clase para Pin de cuentaBancaria
public class Pin {
    // Atributo
    private String valor;          // También se puede hacer con char[] / hash (?)
    public Pin(String inicial) {
        if (!esFuerte(inicial)) {
            System.out.println("PIN débil");
        }
        this.valor = inicial;
    }
    // Método para comprobar si el pin es fuerte (ejemplo: al menos 4 dígitos)
    private boolean esFuerte(String s) {
        // comprobar longitud mínima, que lleve dígitos, etc.
        return (s != null && s.length() >= 4);
    }
    // Método para comprobar si el pin introducido es correcto
    public boolean comprobar(String intento) {
        return valor.equals(intento);
    }
    // Método para cambiar el pin
    public void cambiar(String actual, String nuevo) {
        if (!comprobar(actual)) {
            System.out.println("PIN actual incorrecto");
            return;
        }
        if (!esFuerte(nuevo)) {
            System.out.println("PIN nuevo débil");
        }
        this.valor = nuevo;
    }
}
