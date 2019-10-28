//
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 * Se crea el método main que ejecutará todo el código.
 *
 * @authors Jose Ignacio Blanco Chaves, Julio Romero Chacón, Kevin Rojas Salazar
 */
public class TECPlane {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {

        //Se instancian dos colas
        ColaCheckIn cola = new ColaCheckIn();
        ColaCheckIn colaNueva = new ColaCheckIn();
        //Se instancian los pasajeros
        Pasajero p1 = new Pasajero();
        p1.setNombre("Kevin Rojas");
        p1.setFecha("09/10/2019");
        p1.setNacionalidad("Costarricense");
        p1.setNumeroPasaporte(1075740768);
        p1.setOrigen("Costa Rica");
        p1.setDestino("Holanda");
        p1.setPlanLealtad("Especial");
        cola.enqueue(p1);
        System.out.println("Ops: " + cola.ObtenerNombre(p1.getNombre()));
        ModuloSalida salida = new ModuloSalida();
        String respuesta;
        respuesta = JOptionPane.showInputDialog(null, "Por favor, rellene esta encuesta " + "\n" + " indique las observaciones que tienen del servicio y atención recibida");
        String fin = respuesta;
        System.out.println("FIN: " + fin);
        salida.AnalisisComentario(fin);

        /*
        //----------------------------------------------
        Pasajero p2 = new Pasajero();
        p2.setNombre("Pepito Perez");
        p2.setFecha("17/04/2000");
        p2.setNacionalidad("Costarricense");
        p2.setNumeroPasaporte(306460345);
        p2.setOrigen("Costa Rica");
        p2.setDestino("Alemania");
        p2.setPlanLealtad("Oro");
        cola.enqueue(p2);
        //---------------------------------------------
        Pasajero p3 = new Pasajero();
        p3.setNombre("Julio Romero");
        p3.setFecha("01//04/2000");
        p3.setNacionalidad("Costarricense");
        p3.setNumeroPasaporte(106370646);
        p3.setOrigen("Costa Rica");
        p3.setDestino("México");
        p3.setPlanLealtad("Especial");
        cola.enqueue(p3);
        //----------------------------------
        Pasajero p4 = new Pasajero();
        p4.setNombre("Tavo Calderón");
        p4.setFecha("14/02/2000");
        p4.setNacionalidad("Costarricense");
        p4.setNumeroPasaporte(109650352);
        p4.setOrigen("Costa Rica");
        p4.setDestino("Estados Unidos");
        p4.setPlanLealtad("Economico");
        cola.enqueue(p4);
        //---------------------------------------
        Pasajero p5 = new Pasajero();
        p5.setNombre("Jose Blanco");
        p5.setFecha("26/03/2001");
        p5.setNacionalidad("Costarricense");
        p5.setNumeroPasaporte(305310180);
        p5.setOrigen("Costa Rica");
        p5.setDestino("Dubai");
        p5.setPlanLealtad("Platino");
        cola.enqueue(p5);
        
        
        System.out.println("Cola Normal: " + cola.toString());
        
        cola.colaPrioridad(cola, colaNueva);
        System.out.println("Cola prioridad:" + colaNueva.toString());
        cola.crearAsientos();
        
        System.out.println("Lealtad: " + p1.getPlanLealtad());
        System.out.println(cola.asignarAsientos(p1) + "" + p1.getPlanLealtad());
        
        
        System.err.println("Funcion 5");
        ModuloSalida Salida=new ModuloSalida();
        Salida.enqueue(p1);
        Salida.enqueue(p2);
        Salida.enqueue(p3);
        Salida.enqueue(p4);
        Salida.enqueue(p5);
        Salida.Migracion(Salida);
/*
//Probando vuelos
        Vuelos vuelo1 = new Vuelos();
        vuelo1.setOrigen("SJO");
        vuelo1.setDestino("MEX");
        vuelo1.setNumeroVuelo(21);

        Vuelos vuelo2 = new Vuelos();
        vuelo2.setOrigen("SJO");
        vuelo2.setDestino("NYC");
        vuelo2.setNumeroVuelo(101);

        Vuelos vuelo3 = new Vuelos();
        vuelo3.setOrigen("SJO");
        vuelo3.setDestino("MDW");
        vuelo3.setNumeroVuelo(85);

        Puerta puertas = new Puerta();
        puertas.setNumeroPuerta(6);
        int numero = puertas.getNumeroPuerta();
        ListaVuelos lista = new ListaVuelos();
        lista.append(vuelo1);
        lista.append(vuelo2);
        lista.append(vuelo3);
        lista.puertasArray(numero);
        lista.asignarPuerta(lista);
         */
 /*
        ListaPasajeros lp = new ListaPasajeros();

        Pasajero prueba1 = new Pasajero();
        prueba1.setNombre("Kevin Rojas");
        prueba1.setFecha("09/10/2019");
        prueba1.setNacionalidad("Costarricense");
        prueba1.setNumeroPasaporte(1075740768);
        prueba1.setOrigen("Costa Rica");
        prueba1.setDestino("Holanda");
        prueba1.setPlanLealtad("Especial");
        lp.append(prueba1);
        //----------------------------------------------
        Pasajero prueba2 = new Pasajero();
        prueba2.setNombre("Pepito Perez");
        prueba2.setFecha("17/04/2000");
        prueba2.setNacionalidad("Costarricense");
        prueba2.setNumeroPasaporte(306460345);
        prueba2.setOrigen("Costa Rica");
        prueba2.setDestino("Alemania");
        prueba2.setPlanLealtad("Oro");
        lp.append(prueba2);

        Pasajero prueba3 = new Pasajero();
        prueba3.setNombre("Pepito Sola");
        prueba3.setFecha("17/04/2000");
        prueba3.setNacionalidad("Costarricense");
        prueba3.setNumeroPasaporte(306460345);
        prueba3.setOrigen("Costa Rica");
        prueba3.setDestino("Brasil");
        prueba3.setPlanLealtad("Platino");
        lp.append(prueba3);

        Pasajero prueba4 = new Pasajero();
        prueba4.setNombre("Jose Blanco");
        prueba4.setFecha("26/03/2001");
        prueba4.setNacionalidad("Costarricense");
        prueba4.setNumeroPasaporte(305310180);
        prueba4.setOrigen("Costa Rica");
        prueba4.setDestino("Dubai");
        prueba4.setPlanLealtad("Platino");
        lp.append(prueba4);

        int tam = lp.getSize();

        Heap minHeap = new Heap(lp.getSize());
        Heap x = new Heap(lp.getSize());
        Heap nuevo = new Heap(lp.getSize());

        minHeap.insert(prueba1); //Especial   //1
        minHeap.insert(prueba2); //Oro        //3
        minHeap.insert(prueba3); //Platino    //2
        minHeap.insert(prueba4); //Platino    //2

        int arrA[] = {prueba1.getnumero_prioridad(), prueba2.getnumero_prioridad(), prueba3.getnumero_prioridad(), prueba4.getnumero_prioridad()};

        System.out.println("Original array is: " + Arrays.toString(arrA));
        minHeap.sort(arrA);
        System.out.println("Sorted array is (Heap Sort): " + Arrays.toString(arrA));

        for (int i = 0; i < arrA.length; i++) {
            System.out.println("Insertando: " + arrA[i]);
            int m = x.insert_dos(arrA[i]);
            
            if (m == 1) {
                System.out.println("Especial");
            }
            if (m == 2) {
                System.out.println("Platino");
            }
            if (m == 3) {
                System.out.println("Oro");
            }
            if (m == 4) {
                System.out.println("Economico");
            }

            System.out.println("");

        }
         */
    }
}
