public class Vehiculo {
    private String matricula;
    private String marca;
    private String modelo;
    private boolean premium;

    public Vehiculo(String matricula, String marca, String modelo, boolean premium) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.premium = premium;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public boolean isPremium() {
        return premium;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "matricula='" + matricula + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", premium=" + premium +
                '}';
    }
}