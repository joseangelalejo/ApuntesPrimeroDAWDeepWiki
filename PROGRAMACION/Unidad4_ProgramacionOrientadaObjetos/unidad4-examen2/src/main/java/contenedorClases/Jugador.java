package contenedorClases;

public class Jugador {
    public String nombre;
    public String dorsal;
    public String posicion;
    public int goles;
    public int tarjetas[] = new int [2]; // Posición 0 para amarillas, posición 1 para rojas

    // MÉTODOS
    // Constructor
    // El constructor se declara como public, y tendrá el mismo nombre que el .java/class
    public Jugador (String nombre, String dorsal, String posicion) {
        this.nombre = nombre; // La sintaxis es this.atributo = parametro; , donde el this. se refiere al atributo de la clase, y el parámetro es el que se recibe en el constructor
        this.dorsal = dorsal;
        this.posicion = posicion;
    }
    // Método para marcar goles
    public void marcarGol () {
        goles++;
    }
    // DONE: Hacer sobrecarga para sumar la cantidad de goles especificada por pantalla (scanner)
    public int marcarGol(int sumarGoles) {
        goles += sumarGoles; // goles = goles + sumarGoles;
        return sumarGoles;
    }
    // Método para anular goles
    public void anularGol () {
        goles--;
    }
    // DONE: Sobrecarga para restar la cantidad de goles especificada por pantalla (scanner)
    public int anularGol (int restarGoles) {
        goles -= restarGoles; // goles = goles - restarGoles;
        return restarGoles;
    }
    // Método para poner tarjetas, se podría hacer con métodos distintos
    public void amonestar (int amarillas, int rojas) {
        tarjetas[0] += amarillas; // tarjetas[0] = tarjetas[0] + amarillas;
        tarjetas[1] += rojas; // tarjetas[1] = tarjetas[1] + rojas;
    }

}

