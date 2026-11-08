package practicarExamen;
import java.time.LocalDate;
public class Suscripcion {
    // ATRIBUTOS
    private final String idSuscriptor;
    private String nombre;
    private String plan;
    private String fechaVencimiento;
    private int peliculasVistas;
    private String claveAcceso;
    // CONSTRUCTOR PRINCIPAL
    public Suscripcion(String idSuscriptor, String nombre, String plan, String fechaVencimiento, int peliculasVistas, String claveAcceso) {
        this.idSuscriptor = idSuscriptor;
        this.nombre = (nombre.isEmpty()) ? "Nombre generico" : nombre;
        this.plan = (plan.isEmpty()) ? "Plan Básico" : plan;
        this.fechaVencimiento = (fechaVencimiento.isEmpty()) ? LocalDate.now().plusDays(3).toString() : fechaVencimiento;
            // LocalDate.now.plusDays(3).toString() lo que hace es establecer la fecha del sistema en el día de hoy, agregarle 3 y convertir a String
        this.peliculasVistas = Math.abs(peliculasVistas);
        this.claveAcceso = (claveAcceso.isEmpty()) ? "clavegenerica" : claveAcceso;
    }
    // CONSTRUCTOR sin peliculas vistas, inicializa a 0
    public Suscripcion(String idSuscriptor, String nombre, String plan, String fechaVencimiento, String claveAcceso) {
        this(idSuscriptor, nombre, plan, fechaVencimiento, 0, claveAcceso);
    }
    // GETTERS Y SETTERS
    // Getters
    public String getIdSuscriptor() {return idSuscriptor;}
    public String getNombre() {return nombre;}
    public String getPlan() {return plan;}
    public String getFechaVencimiento() {return fechaVencimiento;}
    public int getPeliculasVistas() {return peliculasVistas;}
    // Se obvia claveAcceso por motivos de seguridad

    // Setters
    public void setNombre(String nombre) {this.nombre = (nombre.isEmpty()) ? "Nombre generico" : nombre;}
    public void setPlan(String plan) {this.plan = (plan.isEmpty()) ? "Plan Básico" : plan;}
    public void setFechaVencimiento(String fechaVencimiento) {this.fechaVencimiento = (fechaVencimiento.isEmpty()) ? LocalDate.now().plusDays(3).toString() : fechaVencimiento;}
    public void setPeliculasVistas(int peliculasVistas) {this.peliculasVistas = Math.abs(peliculasVistas);}
    public void setClaveAcceso(String claveAcceso) {this.claveAcceso = (claveAcceso.isEmpty()) ? "clavegenerica" : claveAcceso;}

    // MÉTODOS SOLICITADOS
    // Método para incrementar el contador de películas vistas
    public void verPelicula() {
        peliculasVistas += 1;
    }
    // Método para renovar suscripción si la clave es correcta
    public boolean renovarSuscripcion(String claveAcceso) {
        if (this.claveAcceso.equals(claveAcceso)) {
            this.fechaVencimiento = LocalDate.now().plusDays(30).toString();
            return true;
        }
        return false;
    }
    // Método para cambiar el plan si la clave es válida
    public boolean cambiarPlan(String nuevoPlan, String claveAcceso) {
        if (this.claveAcceso.equals(claveAcceso)) {
            plan = nuevoPlan;
            return true;
        }
        return false;
    }
    // Método para mostrar el estado de la suscripción si la clave es válida
    public boolean mostrarEstadoSuscripcion(String claveAcceso) {
        if (this.claveAcceso.equals(claveAcceso)) {
            System.out.println("\nNombre: " + nombre + " - Plan:" + plan + " - Fecha de vencimiento: " + fechaVencimiento + " - Películas vistas: " + peliculasVistas);
            return true;
        }
        return false;
    }
    // Método para cambiar la clave si la actual es correcta
    public boolean cambiarClave(String actual, String nueva) {
        if (this.claveAcceso.equals(actual)) {
            claveAcceso = nueva;
            return true;
        }
        return false;
    }
}