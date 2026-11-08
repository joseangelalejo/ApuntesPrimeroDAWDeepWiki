package act7Constructores;

public class Rectangulo {
    // ATRIBUTOS
    public double base;
    public double altura;

    // CONSTRUCTOR
    public Rectangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }
    /*  Para esta actividad se hace sobrecarga de constructores, llamando a 
    otro constructor de la misma clase, para ello se siguen varias normas:
    1- La llamada a this debe ser la primera línea del constructor.
    2- Sólo se puede llamar a un constructor desde otro constructor de la misma clase
    */

    // Constructor para un cuadrado
    public Rectangulo(double base) {
        this(base, base);
    }
}
