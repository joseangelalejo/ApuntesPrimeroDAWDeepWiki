package practicarExamen;

public class Empleado {
    // ATRIBUTOS
    private final String numeroEmpleado;
    private String nombre;
    private String departamento;
    private double salarioBase;
    private double saldoNomina;
    private String tokenAutenticacion;
    // CONSTRUCTOR PRINCIPAL
    public Empleado(String numeroEmpleado, String nombre, String departamento, double salarioBase, double saldoNomina, String tokenAutenticacion) {
        this.numeroEmpleado = numeroEmpleado;
        this.nombre = nombre;
        this.departamento = departamento;
        this.salarioBase = Math.abs(salarioBase);
        this.saldoNomina = Math.abs(saldoNomina);
        this.tokenAutenticacion = tokenAutenticacion;
    }
    // Constructor con saldo inicializado en cero
    public Empleado(String numeroEmpleado, String nombre, String departamento, double salarioBase, String tokenAutenticacion) {
    this(numeroEmpleado, nombre, departamento, salarioBase, 0.0, tokenAutenticacion);
    }

    // GETTERS Y SETTERS
    // Getters - Se excluye el token y el saldo nómina por requisitos de premisa
    public String getNumeroEmpleado() {return numeroEmpleado;}
    public String getNombre() {return nombre;}
    public String getDepartamento() {return departamento;}
    public double getSalarioBase() {return salarioBase;}

    // Setters
    public void setNombre(String nombre) {this.nombre = nombre;}
    public void setDepartamento(String departamento) {this.departamento = departamento;}

    // MÉTODOS SOLICITADOS
    // Métodos para sumar el salario base al saldo
    public void acumularNomina(String tokenAutenticacion) {
        if (salarioBase > 0 && this.tokenAutenticacion.equals(tokenAutenticacion)) {
            saldoNomina += salarioBase;
        }
    }
    // Método para pagar al empleado si el token es válido
    public boolean pagarNomina(double cantidad, String token) {
        if (cantidad > 0 && this.tokenAutenticacion.equals(token)) {
            saldoNomina += cantidad;
            return true;
        }
        return false;
    }
    // Método para consultar la nómina si el token es válido
    public boolean consultarNomina(String token) {
        if (this.tokenAutenticacion.equals(token)) {
            System.out.println("Saldo actual: " + saldoNomina);
            return true;
        }
        return false;
    }
    // Método para cambiar el token si el actual es correcto
    public boolean cambiarToken(String actual, String nuevo) {
        if (this.tokenAutenticacion.equals(actual)) {
            tokenAutenticacion = nuevo;
            return true;
        }
        return false;
    }
    // Método para ajustar el salario si el token es válido
    public boolean ajustarSalario(double nuevoSalario, String token) {
        if (this.tokenAutenticacion.equals(token)) {
            salarioBase = Math.abs(nuevoSalario);
            return true;
        }
        return false;
    }
}
