
//Pasajero

/**
 * Se crea la clase pasajero: contendrá datos de los usuarios.
 */
public class Pasajero {

    //Atributos
    private String nombre;
    private String fecha;
    private long numeroPasaporte;
    private String nacionalidad;
    private String origen;
    private String destino;
    private String planLealtad;
    private int numero_prioridad;
    private String asiento;
//Métodos gets y sets

    public int getnumero_prioridad() {
        return numero_prioridad;
    }

    public void setnumero_prioridad(String planLealtad) {
        if (planLealtad.equals("Especial")) {
            numero_prioridad = 1;
            //System.out.println("Especial");
        }
        if (planLealtad.equals("Platino")) {
            numero_prioridad = 2;
            //System.out.println("Platino");
        }
        if (planLealtad.equals("Oro")) {
            numero_prioridad = 3;
            //System.out.println("Oro");
        }
        if (planLealtad.equals("Economico")) {
            numero_prioridad = 4;
            //System.out.println("Economico");
        }
    }

    /**
     * @return el nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre nombre del pasajero
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha fecha de nacimiento
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return numeroPasaporte
     */
    public long getNumeroPasaporte() {
        return numeroPasaporte;
    }

    /**
     * @param numeroPasaporte numero de pasaporte
     */
    public void setNumeroPasaporte(long numeroPasaporte) {
        this.numeroPasaporte = numeroPasaporte;
    }

    /**
     * @return nacionalidad
     */
    public String getNacionalidad() {
        return nacionalidad;
    }

    /**
     * @param nacionalidad nacionalidad del usuario
     */
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    /**
     * @return origen
     */
    public String getOrigen() {
        return origen;
    }

    /**
     * @param origen origen del vuelo
     */
    public void setOrigen(String origen) {
        this.origen = origen;
    }

    /**
     * @return destino
     */
    public String getDestino() {
        return destino;
    }

    /**
     * @param destino lugar de destino del vuelo
     */
    public void setDestino(String destino) {
        this.destino = destino;
    }

    /**
     * @return planLealtad
     */
    public String getPlanLealtad() {
        return planLealtad;
    }

    /**
     * @param planLealtad plan de lealtad del usuario
     */
    public void setPlanLealtad(String planLealtad) {
        this.planLealtad = planLealtad;
        setnumero_prioridad(planLealtad);
    }

    /**
     * @return asiento
     */
    public String getAsiento() {
        return asiento;
    }

    /**
     * @param asiento asiento que tendrá el usuario
     */
    public void setAsiento(String asiento) {
        this.asiento = asiento;
    }

}
