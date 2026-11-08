package act9clases2;

public class Vehiculos { 
    // ATRIBUTOS
    public enum TipoVehiculo { MOTO, COCHE, ELECTRICO, CAMIONETA }  // ENUM, para el tipo de vehículo, con 4 posibles valores: moto, coche, eléctrico y camioneta

    private TipoVehiculo tipo;  // tipo de vehículo, usando el enum definido arriba como tipo de dato
    private String matricula;
    private float consumo;          // litros cada 100 km
    private int nplazas;
    private int antiguedad;         // años completos, sin decimales
    private boolean itv;            // si este año ya la pasó
    private int tara;               // kg que soporta

    // CONSTRUCTORES
    // Constructor completo
    public Vehiculos(TipoVehiculo tipo, String matricula, float consumo, int nplazas, int antiguedad, boolean itv, int tara) {
        this.tipo = tipo == null ? TipoVehiculo.COCHE : tipo;
        this.matricula = matricula == null ? "" : matricula;
        this.consumo = consumo < 0 ? 0 : consumo;
        this.nplazas = nplazas < 0 ? 0 : nplazas;
        this.antiguedad = antiguedad < 0 ? 0 : antiguedad;
        this.itv = itv;
        this.tara = tara < 0 ? 0 : tara;
    }
    // Constructor para motos, no se pasa tipo de vehículo(moto), nplazas(2) ni tara(0)
    public Vehiculos(String matricula, float consumo, int antiguedad, boolean itv) {
        this(TipoVehiculo.MOTO, matricula, consumo, 2, antiguedad, itv, 0);
    }
    // Constructor para v.eléctricos, no se pasa tipo de vehículo(eléctrico) ni consumo(0)
    public Vehiculos(String matricula, int nplazas, int antiguedad, boolean itv, int tara) {
        this(TipoVehiculo.ELECTRICO, matricula, 0, nplazas, antiguedad, itv, tara);
    }

    //  MÉTODOS
    //  Método pasaritv, devuelve si este año es necesario pasar la itv, teniendo en cuenta el tipo de vehículo que es y si ya paso este año la itv
    
    public boolean pasaritv() {
        if (itv) { // ya la pasó este año
            return false;
        }
        return switch (tipo) {  // True (debe pasar la itv) si la antigüedad supera el umbral para su tipo, false si no
            case MOTO -> antiguedad > 4;       // hasta 4 años exento
            case COCHE -> antiguedad > 4;      // umbral más bajo actual
            case ELECTRICO -> antiguedad > 5;  // libre hasta 5 años (inventado porque la premisa no especifica)
            case CAMIONETA -> antiguedad > 2;  // libre hasta 2 años
        };
    }

    //  Devuelve cuántos kilos libres de carga quedan dado el peso actual.
    public int cargalibre(int cargaActual) {
        if (cargaActual < 0) {
            cargaActual = 0;
        }
        int libre = tara - cargaActual;
        return libre < 0 ? 0 : libre;
    }

    // Kilómetros de autonomía con la cantidad de litros indicada. 
    public float autonomia(float litros) {
        if (consumo <= 0) { 
            return 0;
        }   // vehículos eléctricos o datos inválidos
        return litros * 100f / consumo;
    }

    // getters
    public TipoVehiculo getTipo() { return tipo; }
    public String getMatricula() { return matricula; }
    public float getConsumo() { return consumo; }
    public int getNplazas() { return nplazas; }
    public int getAntiguedad() { return antiguedad; }
    public boolean isItv() { return itv; }
    public int getTara() { return tara; }

    // setters permitidos (matrícula e itv)
    public void setMatricula(String matricula) {
        if (matricula != null && !matricula.isEmpty()) {
            this.matricula = matricula;
        }
    }
    public void setItv(boolean itv) {
        this.itv = itv;
    }
}
