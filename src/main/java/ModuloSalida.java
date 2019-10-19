/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jului
 */
import java.util.Scanner;
public class ModuloSalida {
    //Se definen los atributos
    private NodoPasajero front;
    private NodoPasajero rear;
    private int size;

    //Se define el constructor
    public ModuloSalida() {
        this.front = new NodoPasajero();
        this.rear = this.front;
        this.size = 0;
    }

    /**
     * Método para agregar un Pasajero a la cola
     *
     * @param elemento
     */
    public void enqueue(Pasajero elemento) {
        this.rear.setNext(new NodoPasajero(elemento, null));
        this.rear = rear.getNext();
        this.size++;
    }

    // Método para desencolar un elemento de la cola
    public Pasajero dequeue() {
        if (this.size == 0) {
            System.out.println("Queue is empty");
            return null;
        }
        Pasajero temp = (Pasajero) this.front.getNext().getElement();
        NodoPasajero nTemp = this.front.getNext();
        this.front.setNext(nTemp.getNext());
        if (this.rear == nTemp) {
            this.rear = this.front;
        }
        this.size--;
        return temp;
    }
    //Localiza el primer elemento

    public Pasajero primero() {
        if (this.size == 0) {
            System.out.println("Queue is empty");
            return null;
        }
        return (Pasajero) this.front.getNext().getElement();
    }
    //Retorna el tamaño de la cola

    public int size() {
        return this.size;
    }
    //Vacía la cola

    public void clear() {
        this.front = new NodoPasajero();
        this.rear = this.front;
        this.size = 0;
    }

    PuestoMigración Migra1=new PuestoMigración(1); 
    
    PuestoMigración Migra2=new PuestoMigración(2); 
    
    Scanner myObj = new Scanner(System.in);
    public void Migracion(ModuloSalida ColaSalida) throws InterruptedException{
        NodoPasajero Temporal=this.front.getNext();
        int rangominimo=0;
        int rangomaximo=5;
        while (Temporal!=null){
            //Aqui va cada botón de atender para cada puesto de migracion
            System.err.println("Digite el puesto de migracion");
            int Opcion = myObj.nextInt();
            if (Opcion==1){
                 //System.out.println("Se atendio al pasajero "+Temporal.getElement().getNombre()+" En el puesto de migracion 1");
                 int n = (int) (Math.random() *(rangomaximo-rangominimo+1)+rangominimo);
                 Thread.sleep(n*1000);
                 System.out.println("Se atendio al pasajero "+Temporal.getElement().getNombre()+"En el puesto de migracion numero:"+ Migra1.getNumeroPuesto());
                 Migra1.Atender(ColaSalida);
                 String Comentario = myObj.nextLine();
                 AnalisisComentario(Comentario);
        }
            else{
                 int n = (int) (Math.random() *(rangomaximo-rangominimo+1)+rangominimo);
                 Thread.sleep(n*1000);
                 System.out.println("Se atendio al pasajero "+Temporal.getElement().getNombre()+" En el puesto"+ Migra2.getNumeroPuesto());
                 Migra2.Atender(ColaSalida);
                 String Comentario2 = myObj.nextLine();
            }
            Temporal=Temporal.getNext();
    }
        
}
    public void AnalisisComentario(String comentario){
     
    }
}