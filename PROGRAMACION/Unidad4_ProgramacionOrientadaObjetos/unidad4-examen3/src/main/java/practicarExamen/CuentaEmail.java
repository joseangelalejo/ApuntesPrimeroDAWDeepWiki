package practicarExamen;

public class CuentaEmail {
    // ATRIBUTOS
    private final String usuario;
    private String dominio;
    private String contrasena;
    private int almacenamiento; // Capacidad total en MB
    private int espacioUsado;   // Espacio usado en MB
    private int cantidadMensajes;   // Numero de mensajes en el buzon
    // CONSTRUCTOR PRINCIPAL
    public CuentaEmail(String usuario, String dominio, String contrasena, int almacenamiento, int espacioUsado, int cantidadMensajes) {
        this.usuario = usuario;
        this.dominio = dominio;
        this.contrasena = contrasena;
        this.almacenamiento = (almacenamiento < 1) ? 1 : almacenamiento; // Almacenamiento mínimo de 1 MB
        this.espacioUsado = (espacioUsado > this.almacenamiento) ? this.almacenamiento : (espacioUsado < 0 ? 0 : espacioUsado); // El espacio usado no puede superar el almacenamiento ni ser negativo
        this.cantidadMensajes = (cantidadMensajes < 0) ? 0 : cantidadMensajes;
    }
    // CONSTRUCTOR sin espacio (almacenamiento = 1000 MB, espacioUsado = 0 MB)
    public CuentaEmail(String usuario, String dominio, String contrasena) {
        this(usuario, dominio, contrasena, 1000, 0, 0);
    }
    // GETTERS Y SETTERS
    // Getters
    public String getUsuario() {return usuario;}
    public String getDominio() {return dominio;}
    public int getAlmacenamiento() {return almacenamiento;}
    public int getEspacioUsado() {return espacioUsado;}
    public int getCantidadMensajes() {return cantidadMensajes;}
    // Setters
    public void setDominio(String dominio) {this.dominio = dominio;}
    public void setContrasena(String contrasena) {this.contrasena = contrasena;}
    public void setAlmacenamiento(int almacenamiento) {
        this.almacenamiento = (almacenamiento < 1) ? 1 : almacenamiento; // Almacenamiento mínimo de 1 MB
        if (this.espacioUsado > this.almacenamiento) {
            this.espacioUsado = this.almacenamiento; // Ajustar espacioUsado si supera el nuevo almacenamiento
        }
    }
    public void setEspacioUsado(int espacioUsado) {
        this.espacioUsado = (espacioUsado > this.almacenamiento) ? this.almacenamiento : (espacioUsado < 0 ? 0 : espacioUsado);
    }
    public void setCantidadMensajes(int cantidadMensajes) {
        this.cantidadMensajes = (cantidadMensajes < 0) ? 0 : cantidadMensajes;
    }

    // MÉTODOS SOLICITADOS
    // Método para enviar un mensaje de correo electrónico. Consume espacio
    public boolean enviarCorreo(int tamanio) {
        if (tamanio > 0 && espacioUsado + tamanio <= almacenamiento) {
            espacioUsado += tamanio;
            cantidadMensajes += 1;
            return true;
        }
        return false;
    }
    // Método para recibir correos si hay espacio y la contraseña es correcta
    public boolean recibirCorreo(int tamanio, String contrasena) {
        if (this.contrasena.equals(contrasena) && tamanio > 0 && espacioUsado + tamanio <= almacenamiento) {
            espacioUsado += tamanio;
            cantidadMensajes += 1;
            return true;
        }
        return false;
    }
    // Método para eliminar correo
    public boolean eliminarCorreo(int tamanio) {
        if (tamanio > 0 && tamanio <= espacioUsado && cantidadMensajes > 0) {
            espacioUsado -= tamanio;
            cantidadMensajes -= 1;
            return true;
        }
        return false;
    }
    // Método para mostrar el espacio disponible si la contraseña es correcta
    public boolean mostrarEspacioDisponible(String contrasena) {
        if (this.contrasena.equals(contrasena)) {
            System.out.println("Espacio disponible: " + (almacenamiento - espacioUsado));
            return true;
        }
        return false;
    }
    // Método para cambiar la contraseña si la actual es correcta
    public boolean cambiarContrasena(String actual, String nueva) {
        if (this.contrasena.equals(actual)) {
            contrasena = nueva;
            return true;
        }
        return false;
    }
}