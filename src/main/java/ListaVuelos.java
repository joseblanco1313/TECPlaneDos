//
//Se importa Random

import java.util.Random;

/**
 * Se crea la clase ListaVuelos: Se almacenará cada vuelo
 */
public class ListaVuelos {

    //atributos LinkedList
    private Nodo head;
    private Nodo current;
    private Nodo tail;
    private int position;
    private int size;
    //Constructor

    public ListaVuelos() {
        this.head = new Nodo();
        this.current = this.head;
        this.tail = this.head;
        this.size = 0;
        this.position = -1;
    }

    //Métodos
    /**
     * Agrega un nuevo elemento a la lista
     *
     * @param element El elemento a agregar
     */
    public void insertar(Vuelos element) {
        //insertar en cualquier posiciÃ³n
        Nodo newNode = new Nodo(element, this.getCurrent(), this.getCurrent().getNext());
        if (this.getCurrent() != this.getTail()) {
            this.getCurrent().getNext().setPrevious(newNode);
        }
        this.getCurrent().setNext(newNode);
        //necesario si se está insertando al final de la lista
        if (this.getCurrent() == this.getTail()) {
            this.setTail(getTail().getNext());
        }
        this.setSize(this.getSize() + 1);
    }

    /**
     * Agrega un nuevo elemento a la lista
     *
     * @param element El elemento a agregar
     */
    public void append(Vuelos element) {
        //insertar en cualquier posiciÃ³n
        Nodo newNode = new Nodo(element, this.getTail(), null);
        this.getTail().setNext(newNode);
        this.setTail(newNode);
        this.setSize(this.getSize() + 1);
    }

    /**
     * Remueve el elemento siguiente al nodo actual
     *
     */
    public void remover() {
        //verifica si la lista está vacía
        if ((this.getHead() == this.getCurrent()) && (this.getHead() == this.getTail())) {
            System.out.println("Lista vacía");
            return;
        }
        //Valida si está en el nodo especial
        if (this.getHead() == this.getCurrent()) {
            System.out.println("No se puede borrar");
            return;
        }

        //Verifica si el nodo current es el último elemento
        if (this.getCurrent() == this.getTail()) {
            this.getCurrent().getPrevious().setNext(null);
            this.setPosition(this.getPosition() - 1);
            this.setTail(this.getCurrent().getPrevious());
        } else {
            this.getCurrent().getNext().setPrevious(this.getCurrent().getPrevious());
            this.getCurrent().getPrevious().setNext(this.getCurrent().getNext());

        }
        this.setCurrent(this.getCurrent().getPrevious());
        this.setSize(this.getSize() - 1);

    }

    /**
     * Retorna el elemento del nodo actual
     *
     * @return el elemento del nodo actual
     */
    public Vuelos getElement() {
        return this.getCurrent().getElement();
    }

    /**
     * Retorna el tamaño de la lista
     *
     * @return size
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Verifica si hay siguiente elemento
     *
     * @return valor boleano (true o false)
     */
    public boolean next() {
        if (this.getCurrent() == this.getTail()) {
            System.out.println("Último nodo");
            return false;
        }
        this.setCurrent(this.getCurrent().getNext());
        this.setPosition(this.getPosition() + 1);
        return true;
    }

    /**
     * Verifica si hay elemento anterior
     *
     * @return valor boleano (true o false)
     */
    public boolean previous() {
        if (this.getCurrent() == this.getHead()) {
            System.out.println("Actualmente en primer nodo, no se puede retroceder");
            return false;
        }
        this.setCurrent(this.getCurrent().getPrevious());
        this.setPosition(this.getPosition() - 1);
        return true;
    }

    /**
     * Añade un nodo en una posición específica
     *
     * @param elemento
     * @param posicion
     */
    public void insert(Vuelos elemento, int posicion) {
        this.setSize(0);
        Nodo temporal = this.getHead();
        while (this.getSize() != posicion) {
            temporal = temporal.getNext();
            setSize(getSize() + 1);
        }
        Nodo nuevoNodo = new Nodo(elemento);
        Nodo temporalNext = temporal.getNext();
        temporal.setNext(nuevoNodo);
        nuevoNodo.setPrevious(temporal);
        nuevoNodo.setNext(temporalNext);
    }

    /**
     * Remueve el nodo en una posición específica
     *
     * @param posicion
     */
    public void remove(int posicion) {
        this.setSize(-1);
        Nodo temporal = this.getHead();
        //Ciclo para encontrar la posición
        while (this.getSize() != posicion) {
            temporal = temporal.getNext();
            this.setSize(this.getSize() + 1);
        }
        Nodo temporalAnterior = temporal.getPrevious();
        Nodo temporalNext1 = temporal.getNext();
        temporalNext1.setPrevious(temporalAnterior);
        temporalAnterior.setNext(temporalNext1);

    }
    //Se crea un arreglo tipo "público (global)"
    private int[] puertas;
    /**
     * Método que creará un arreglo con el número de puertas ingresadas por el
     * usuario
     *
     * @param numero
     * @return
     */
    public int[] puertasArray(int numero) {
        setPuertas(new int[numero]);
        int contador = 1;
        int asignar = 0;
        //Ciclo para agregar datos al arreglo
        while (contador <= numero) {
            puertas[asignar] = contador;
            contador++;
            asignar++;
        }
        return puertas;
    }

    /**
     * Método para asignar una puerta a cada vuelo
     *
     * @param lista
     */
    public String asignarPuerta(ListaVuelos lista) {
        String resultado = "";
        //Ciclo para asignar una puerta aleatoria a cada vuelo
        for (Nodo temporal = lista.getHead().getNext(); temporal != null; temporal = temporal.getNext()) {
            Vuelos vueloElemento = temporal.getElement();
            Random random = new Random();
            //Búsqueda lineal para evitar la repetición de puertas
            int randomNumero = random.nextInt(puertas.length);
            vueloElemento.setPuerta(puertas[randomNumero]);
            resultado = lista + ",";
        }
        return resultado;
        //System.out.println("Lista de vuelos: " + lista.toString());
    }

    /**
     * Método para convertir la lista a string
     *
     * @return el string
     */
    @Override
    public String toString() {
        Nodo currentNode = this.getHead().getNext();

        StringBuilder result = new StringBuilder();

        for (int i = 0; currentNode != null; i++) {
            if (i > 0) {
                result.append(",");
            }
            Vuelos element = currentNode.getElement();

            result.append(element == null ? "" : "Número de vuelo: " + element.getNumeroVuelo() + " Puerta: " + element.getPuerta());
            currentNode = currentNode.getNext();
        }
        return result.toString();
    }

    /**
     * @return the head
     */
    public Nodo getHead() {
        return head;
    }

    /**
     * @param head the head to set
     */
    public void setHead(Nodo head) {
        this.head = head;
    }

    /**
     * @return the current
     */
    public Nodo getCurrent() {
        return current;
    }

    /**
     * @param current the current to set
     */
    public void setCurrent(Nodo current) {
        this.current = current;
    }

    /**
     * @return the tail
     */
    public Nodo getTail() {
        return tail;
    }

    /**
     * @param tail the tail to set
     */
    public void setTail(Nodo tail) {
        this.tail = tail;
    }

    /**
     * @return the position
     */
    public int getPosition() {
        return position;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(int position) {
        this.position = position;
    }

    /**
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * @param puertas the puertas to set
     */
    public void setPuertas(int[] puertas) {
        this.puertas = puertas;
    }
}
