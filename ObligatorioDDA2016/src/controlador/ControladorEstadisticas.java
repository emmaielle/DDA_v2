/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.Observable;
import java.util.Observer;
import modelo.Jugador;
import modelo.Modelo;

/**
 *
 * @author Euge
 */
public class ControladorEstadisticas implements Observer{
    public Modelo modelo = Modelo.getInstancia();
    public VistaEstadisticas vista;
    public Jugador jugador;

    public ControladorEstadisticas(VistaEstadisticas vista, Jugador jugador) {
        this.vista = vista;
        this.jugador = jugador;
        modelo.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if(arg.equals(Modelo.EVENTO_ACTUALIZA_SALDOS)){
            vista.mostrarTodosApostado(modelo.totalApostadoTodos());
            vista.mostrarTodosCobrado(modelo.totalCobradoTodos());
            vista.mostrarTotalApostado(jugador.getTotalApostado());
            vista.mostrarTotalCobrado(jugador.getTotalCobrado());
        }
    }
    
    public void mostrarTotalApostadoTodos(){
        vista.mostrarTodosApostado(modelo.totalApostadoTodos());
    }

    public void mostrarTotalCobradoTodos() {
        vista.mostrarTodosCobrado(modelo.totalCobradoTodos());
    }

    public void mostrarTotalApostado() {
        vista.mostrarTotalApostado(jugador.getTotalApostado());
    }

    public void mostrarTotalCobrado() {
        vista.mostrarTotalCobrado(jugador.getTotalCobrado());
    }

    public void habilitarStats(boolean habilitar) {
        jugador.setStatsOn(!habilitar);
    }

    public void eliminarObservador() {
        modelo.deleteObserver(this);
    }
}
