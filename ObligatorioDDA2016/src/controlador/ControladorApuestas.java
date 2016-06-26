/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import modelo.Apuesta;
import modelo.Jugador;
import modelo.Modelo;

/**
 *
 * @author Moi
 */
public class ControladorApuestas implements Observer{
    
    private Modelo modelo = Modelo.getInstancia();
    private VistaApuestas vista;
    private Jugador j;

    public ControladorApuestas(VistaApuestas vista, Jugador j) {
        this.vista = vista;
        this.j = j;
        modelo.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if(arg.equals(Modelo.EVENTO_SORTEARNUMERO)){  
            vista.mostrarApuestas(cargarApuestas());
        }
    }

    public ArrayList<Apuesta> cargarApuestas() {
        return j.getApuestas();
    }

    public ArrayList<Apuesta> cargarApuestasPorRonda(Apuesta a) {
        return a.getRonda().getApuestas();
    }

    public void salirDeApuestas() {
        j.setApuestasOn(false);
    }
    
    
    
}
