//
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jului
 */
public class PuestoMigración {
 private int numeroPuesto;   

    public PuestoMigración(int numeroPuesto){
        this.numeroPuesto=numeroPuesto;
    }
 
 
    /**
     * @return the numeroPuesto
     */
    public int getNumeroPuesto() {
        return numeroPuesto;
    }

    /**
     * @param numeroPuesto the numeroPuesto to set
     */
    public void setNumeroPuesto(int numeroPuesto) {
        this.numeroPuesto = numeroPuesto;
    }
    public void Atender(ModuloSalida Salida){
        Salida.dequeue();
    }
 
 
}
