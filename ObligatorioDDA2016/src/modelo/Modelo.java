/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import exceptions.InvalidUserActionException;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Observable;

/**
 *
 * @author Euge
 */
public class Modelo extends Observable {
        
    private SistemaJugador sj = SistemaJugador.getInstancia();
    private Casino casino = Casino.getInstancia();
    private static Modelo instancia = new Modelo();
    public static final int EVENTO_LOGIN = 1;
    public static final int EVENTO_LOGUEADOS= 2;
    public static final int EVENTO_NUEVA_MESA = 3;
    public static final int EVENTO_TABLERO = 4;
    public static final int EVENTO_SORTEARNUMERO = 5;
    public static final int EVENTO_NUEVO_JUGADOR_MESA_RULETA = 6;
    public static final int EVENTO_JUEGO_CERRADO = 7;
    public static final int EVENTO_ACTUALIZA_SALDOS = 8;
    public static final int EVENTO_SALIR_MESA = 9;
    public static final int EVENTO_STATSWINDOW = 10;
    public static final int EVENTO_CHECK_SALDOS = 11;
    public static final int EVENTO_ADD_SECONDS = 12;
    public static final int EVENTO_SIN_JUGAR = 13;
    
    private Modelo() {
    }

    public static Modelo getInstancia() {
        return instancia;
    }
    
    protected void avisar(Object evento){
        setChanged();
        notifyObservers(evento);
    }
    
    // <editor-fold defaultstate="collapsed" desc="Metodos Sistema Jugador">   
    public void agregar (Jugador j){
        sj.agregar(j);
    }
    
    // capaz?
//    public void cargarJugadores(ArrayList<Object> j){
//        sj.cargarJugadores(j);
//    }

    public boolean isHabilitado() {
        return sj.isHabilitado();
    }

    public Jugador login(String nom, String psw) throws InvalidUserActionException{
        return sj.login(nom,psw);
    }
    
    public void logout(Jugador j){
        sj.logout(j);
    }
    
    public long totalApostadoTodos() {
        return sj.totalApostadoTodos();
    }

    public long totalCobradoTodos() {
        return sj.totalCobradoTodos();
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Metodos Casino"> 
    public ArrayList<String> getJuegos(){
        return casino.getJuegos();
    }

    public Object getJuego(String j) {
        return casino.getJuego(j);
    }

    public ArrayList<Mesa> listarMesasRuleta() {
        return casino.getRuleta().getListadoMesas();
    }

    public void agregarMesaRuleta(Mesa m, Jugador j, Color c) throws InvalidUserActionException {
        casino.getRuleta().agregarMesaRuleta(m, j, c);
    }

    public Mesa buscarMesaRuleta(String nom){
        return casino.getRuleta().buscarMesa(nom);
    }

    public void unirJugadorAMesaRuleta(Jugador j, Mesa m, Color c) throws InvalidUserActionException{
        casino.getRuleta().unirJugadorAMesaRuleta(j, m, c);
    }
    
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Metodos mesa">  
    public ArrayList<JugadorRuleta> getJugadoresPorMesa(Mesa m) {
        return m.getTodosJugadoresEnMesa();
    }

    public Color asignarColorRuleta(Mesa m) {
        return m.getUnusedColour();
    }

    public int ultNumeroSorteado(Mesa m) {
        return m.getNumeroGanador();
    }

    public void apostar(Mesa mesa, Numero n, String v, JugadorRuleta jugador) throws InvalidUserActionException {
        mesa.apostarUnNumero(n, v, jugador);
    }  

    public int finalizarApuesta(Mesa mesa, JugadorRuleta jr) {
        return mesa.finalizarApuesta(jr);
    }

    public void salirDeMesaRuleta(JugadorRuleta jugador, Mesa mesa) {
        casino.getRuleta().quitarJugador(jugador, mesa);
    }

    public boolean estaEnEspera(JugadorRuleta jugador, Mesa mesa) {
        return mesa.estaEnEspera(jugador);
    }
    // </editor-fold>

}
