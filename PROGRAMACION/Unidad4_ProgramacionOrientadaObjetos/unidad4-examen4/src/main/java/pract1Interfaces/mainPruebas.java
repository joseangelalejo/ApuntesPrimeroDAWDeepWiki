package pract1Interfaces;

public class mainPruebas {
    public static void main(String[] args) {
        Televisor miTelevisor = new Televisor();

        Lampara miLampara = new Lampara() {
            @Override
            public void encender() {
                System.out.println("Lámpara encendida");
            }

            @Override
            public void apagar() {
                System.out.println("Lámpara apagada");
            }
        };

        Router miRouter = new Router() {
            @Override
            public void conectar(String red) {
                System.out.println("Router conectado a " + red);
            }

            @Override
            public void desconectar() {
                System.out.println("Router desconectado");
            }
        };
        System.out.println();
        System.out.println("Pruebas con Televisor:");
        miTelevisor.encender();
        miTelevisor.conectar("MiRedWiFi");
        miTelevisor.apagar();
        miTelevisor.desconectar();

        miLampara.encender();
        miLampara.apagar();

        miRouter.conectar("MiRedWiFi");
        miRouter.desconectar();
    }
}
