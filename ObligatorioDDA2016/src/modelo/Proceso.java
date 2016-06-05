/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Moi
 */
public class Proceso implements Runnable{

    // Agrgar eventos?
    public static final int EVENTO_ADD_SECONDS = 1;
    public static final int EVENTO_TIME_OUT = 2;
    
    private Thread hilo;
    private boolean ejecutar;
    private static int segundos;
    private MiObservable observable = new MiObservable();
    
    public Proceso(){
        
    }

    public static int getSegundos() {
        return segundos;
    }    
    
    public synchronized void addObserver(Observer o) {
        observable.addObserver(o);
    }

    public synchronized void deleteObserver(Observer o) {
        observable.deleteObserver(o);
    }
    
    public void ejecutar(){
        if(!ejecutar){
            ejecutar = true;
            hilo = new Thread(this);
            hilo.start();
        }
    }

    public void parar(){
        ejecutar=false;
        hilo.interrupt();
    }
    
    public void reset(){
        segundos = 0;
        avisar(Proceso.EVENTO_ADD_SECONDS);
    }
    
    private void avisar(Object evento){
        observable.avisar(evento);
    }

    
    @Override
    public void run() {
        try {
            while (ejecutar){
                while (segundos < Ronda.getTIEMPO_LIMITE()*10){
                    hilo.sleep(1000);
                    segundos ++;
                    avisar(Proceso.EVENTO_ADD_SECONDS);
                }
                reset();
                
                avisar(Proceso.EVENTO_TIME_OUT);
            }
            //ejecutar = false;
        } catch (InterruptedException ex) {}
            
    }
    
}
