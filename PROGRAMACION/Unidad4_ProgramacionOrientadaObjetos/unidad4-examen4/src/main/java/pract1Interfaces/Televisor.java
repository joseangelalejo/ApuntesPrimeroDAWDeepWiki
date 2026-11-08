package pract1Interfaces;

public class Televisor implements Encendible, ConectableWiFi {

    @Override
    public void encender() {
        System.out.println("Televisor encendido");
    }

    @Override
    public void apagar() {
        System.out.println("Televisor apagado");
    }

    @Override
    public void conectar(String red) {
        System.out.println("Televisor conectado a " + red);
    }

    @Override
    public void desconectar() {
        System.out.println("Televisor desconectado");
    }

}
