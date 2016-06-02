/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import exceptions.InvalidUserActionException;
import java.util.ArrayList;

/**
 *
 * @author Euge
 */
public class SistemaJugador {
    private ArrayList<Jugador> jugadores = new ArrayList();
    private ArrayList<Jugador> logueados = new ArrayList();
    private boolean habilitado = true;
    private static SistemaJugador instancia = new SistemaJugador();
    
    private SistemaJugador() {
    }

    public static SistemaJugador getInstancia() {
        return instancia;
    }
    
    public ArrayList<Jugador> getLogueados() {
        return logueados;
    }
    
    public boolean isHabilitado() {
        return habilitado;
    }
    
    // <editor-fold defaultstate="collapsed" desc="Metodos">
    public void agregar(Jugador j){
        jugadores.add(j);
    }
    
    public Jugador login(String nom, String psw) throws InvalidUserActionException{
        if(!habilitado) return null;
        Jugador j = buscarJugador(nom);
        if (j != null){
            if (isLogged(j)) throw new InvalidUserActionException("Ya se encuentra logueado");
            if (j.getPassword().equals(psw) && !logueados.contains(j)){
                logueados.add(j);
                Modelo.getInstancia().avisar(Modelo.EVENTO_LOGUEADOS);
                return j;
            }
        }
        return null;
    }

    public Jugador buscarJugador(String nom){
        for(Jugador j:jugadores){
            if(j.getNombre().equals(nom)){
                return j;
            }
        }
        return null;
    }
    
    public boolean isLogged(Jugador j) {
        if (j != null) return logueados.contains(j);
        return false;
    }
    
    public void logout(Jugador j) {
        logueados.remove(j);
        Modelo.getInstancia().avisar(Modelo.EVENTO_LOGUEADOS);
    }

    public long totalCobradoTodos(){
        int total=0;
        for(Jugador j:jugadores){
            total+=j.getTotalCobrado();
        }
        return total;
    }
    public long totalApostadoTodos(){
        int total=0;
        for(Jugador j: jugadores){
            total+=j.getTotalApostado();
        }
        return total;
    }
    // </editor-fold>
    
}
