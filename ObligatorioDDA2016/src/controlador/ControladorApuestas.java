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
import modelo.JugadorRuleta;

/**
 *
 * @author Moi
 */
public class ControladorApuestas implements Observer{
    
    private JugadorRuleta jr;

    public ControladorApuestas(JugadorRuleta jr) {
        this.jr = jr;
    }

    @Override
    public void update(Observable o, Object arg) {

    }

    public ArrayList<Apuesta> cargarApuestas() {
        return jr.getApuestas();
    }

    public ArrayList<Apuesta> cargarApuestasPorRonda(Apuesta a) {
        return a.getRonda().getApuestas();
    }
    
    
    
}
