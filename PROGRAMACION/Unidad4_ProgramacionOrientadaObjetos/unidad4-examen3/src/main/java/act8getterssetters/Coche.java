package act8getterssetters;

public class Coche {

    private String marca;
    private String modelo;
    private int velocidad;

    // Constructor solo con marca
    public Coche(String marca) {
        this(marca, "Desconocido");
    }

    // Constructor principal
    public Coche(String marca, String modelo) {
        this.marca = (marca == null || marca.isEmpty()) ? "Sin marca" : marca;
        this.modelo = (modelo == null || modelo.isEmpty()) ? "Sin modelo" : modelo;
        this.velocidad = 0; // Puede omitirse porque por defecto será 0
    }

    public void acelerar(int cantidad) {
        if (cantidad > 0) {
            velocidad += cantidad;
        }
    }

    public void frenar(int cantidad) {
        if (cantidad > 0) {
            velocidad -= cantidad;
            if (velocidad < 0)
                velocidad = 0;
        }
    }

    // Getters y Setters
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = (marca == null || marca.isEmpty()) ? this.marca : marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = (modelo == null || modelo.isEmpty()) ? this.modelo : modelo;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = (velocidad < 0) ? 0 : velocidad;
    }
}
