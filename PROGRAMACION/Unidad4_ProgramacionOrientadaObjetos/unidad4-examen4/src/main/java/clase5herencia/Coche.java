package clase5herencia;
// con el extends indicamos que Coche es clase hija de Vehículo, por lo que en Coche heredamos los métodos de la clase padre Vehiculo
public class Coche extends Vehiculo {
    private int nplazas;

    public Coche(String marca, String modelo, String matricula, int nplazas) {
        super(marca, modelo, matricula, 0);
        if (nplazas < 1 || nplazas > 6) {
            System.out.println("plazas 1‑6");
        }
        this.nplazas = nplazas;
    }

    public Coche(String marca, String modelo, String matricula) {
        super(marca, modelo, matricula);
        this.nplazas = 4;            // Valor por defecto, por ejemplo
    }

    public void acelerar(double cantidad) {
        velocidad += cantidad;       // Usa el campo heredado
    }

    public int getNPlazas() {
        return nplazas;               // Ahora el campo se usa
    }
    // A esto se le llama "sobreescritura" de métodos: 
    // el método toString() de la clase Object se redefine para mostrar la información del coche
    // Para que haya sobreescritura el método se debe llamar igual y tener los mismos parámetros. De lo contrario, será sobrecarga y no sobreescritura.
    public String toString() {
        // return marca + " " + modelo + " (" + matricula + ") - Plazas: " + nplazas;
        // Podemos usar el toString de la clase padre y concatenar algo más el mensaje, por ejemplo:
        return super.toString() + " - Plazas: " + nplazas;
        // Aquí lo que hacemos es utilizar super (super invoca al padre directo, indicado en extends)
    }
}