package act7Clases1;

public class Cliente {
    // ATRIBUTOS
    private String nombre;      //   Contiene nombre y apellidos
    private String telefono;
    private String direccion;
    private int edad;
    private String mail;
    private boolean cuponactivo;    //  cuponactivo (flag que indicará si el cliente tiene un cupón de descuento activado
    private double descuento;       //  descuento (indicará el % de descuento a aplicar en el cupón si está activo)
    private int compras;            //  compras (indicará el número de compras que ha hecho el cliente)

    // CONSTRUCTOR
    public Cliente (String nombre, String telefono, String direccion, int edad, String mail) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.edad = edad;
        this.mail = mail;
        this.cuponactivo = true;
        this.descuento = 0.90;  // Suponiendo que se vaya a usar para cálculos, para aplicar el 10% se extrae directamente el valor
        this.compras = 0;
    }

    // MÉTODOS
    // ncompras, se llamará cuando el cliente realice una compra. Este método aumentará la variable compras. Cuando esta llegue a 5 la volverá a poner a 0 y activará un descuento del 5%. 
    public void ncompras() {
        this.compras++;               // actualiza el atributo, no una variable local
        if (this.compras == 5) {
            this.compras = 0;
            this.descuento = 0.95;    // factor multiplicador para 5 %
            this.cuponactivo = true;
        }
    }
    /** Método erroneo, inncremento la variable local, no la variable del objeto.
    public void ncompras(double descuento, int compras) {
        compras++;
        if (this.compras == 5) {
            this.compras = 0;
            this.descuento = 0.95; // Suponiendo que el cupón del 10% y el del 5% es acumulable
            this.cuponactivo = true; // Activa el cupón
        } 
    }
    */
    // usacupon, se le pasará el precio de la compra, verá si tiene un cupón activo y le aplicará el descuento, devolviendo el precio final. También pondrá el cuponactivo a false.
    public double usacupon(double precioCompra) {
        if (this.cuponactivo) {
            this.cuponactivo = false;
            return precioCompra*this.descuento;
        }
        return precioCompra;
    }
    // get, todos los atributos tendrá un método get para su consulta.
    public String getNombre() { return nombre; }
    public String getTelefono() {return telefono;}
    public String getDireccion() {return direccion;}
    public int getEdad() {return edad;}
    public String getMail() {return mail;}
    public boolean getCuponactivo() {return cuponactivo;}
    public double getDescuento() {return descuento;}
    public int getCompras() {return compras;}

    // set, todos los atributos tendrán un set excepto el cuponactivo, descuento y compras, que no podrán ser modificados.
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setTelefono(String telefono) {this.telefono = telefono;}
    public void setDireccion(String direccion) {this.direccion = direccion;}
    public void setEdad(int edad) {this.edad = edad;}
    public void setMail(String mail) {this.mail = mail;}
}
