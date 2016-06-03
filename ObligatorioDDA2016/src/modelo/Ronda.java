/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author Euge
 */
public class Ronda {
    private int oid;
    private final int nroRonda;
    private Apuesta apuestaGanadora;
    private int nroGanador = -1;
    private ArrayList<Apuesta> apuestas = new ArrayList<>();

    // <editor-fold defaultstate="collapsed" desc="Constructor">   
    public Ronda(int numRonda) {
        nroRonda = numRonda;
    }
    //</editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters y setters">
    public int getNroGanador() {
        return nroGanador;
    }

    public void setApuestas(ArrayList<Apuesta> apuestas) {
        this.apuestas = apuestas;
    }
    
    public int getNroRonda() {
        return nroRonda;
    }

    public Apuesta getApuestaGanadora() {
        return apuestaGanadora;
    }

    public ArrayList<Apuesta> getApuestas() {
        return apuestas;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }
    
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Metodos">
    
    // sortea si no existe, sino devuelve existente
    public int sortearNroGanador() {
        if (nroGanador == -1){ // todavia no se sorteo
            int randomOut = (int)Math.floor(Math.random()*37);
            nroGanador = randomOut; 
            lookForWinner();
            return randomOut;
        }
        return nroGanador;
    }
    
    public Apuesta buscarApuestaPorNumero(Numero n){
        Apuesta yaApostada = null;
        for (Apuesta a: apuestas){
            if (a.getNumero() == n) yaApostada = a;
        }
        return yaApostada;
    }
    
    public void apostar(Numero n, int v, JugadorRuleta jugador) { //funciona en ambos sentidos si se clickea de nuevo
        Apuesta yaApostada = buscarApuestaPorNumero(n);
        if (yaApostada == null){ // si entra aca es porque ese numero no fue elegido antes
            Apuesta a = new Apuesta(v, jugador, n);
            if (a.validar()){
                agregarApuesta(a);
                jugador.getJugador().modificarSaldo(false, v);
            }
        }
        else desapostar(jugador, n);
    }
    
    public void desapostar(JugadorRuleta j, Numero n){
        Apuesta yaApostada = buscarApuestaPorNumero(n);
        if (yaApostada.getJugador().equals(j)) 
            quitarApuesta(yaApostada);
    }
    
    public void quitarApuesta(Apuesta a){
        a.getJugador().getJugador().modificarSaldo(true,a.getMonto());
        a.getNumero().setApuesta(null);
        a.getJugador().quitarApuesta(a);
        a.setJugador(null);
        apuestas.remove(a);
        Modelo.getInstancia().avisar(Modelo.EVENTO_TABLERO);
    }
    
    public void agregarApuesta(Apuesta a){
        a.getNumero().setApuesta(a);
        a.getJugador().agregarApuesta(a);
        apuestas.add(a);
        Modelo.getInstancia().avisar(Modelo.EVENTO_TABLERO);
    }

    private void lookForWinner() {
        for (Apuesta a : apuestas){
            if (a.getNumero().getValor() == nroGanador) apuestaGanadora = a;
        }
    }
    
    public void modificarSaldos() {
        for (Apuesta a: apuestas){
            Jugador j = a.getJugador().getJugador();
            if (apuestaGanadora != null && apuestaGanadora.equals(a)){ // si hubo un ganador
                j.modificarSaldo(true, a.getMonto()* 35);
                j.setTotalCobrado(j.getTotalCobrado() + a.getMonto() * 35);
                j.setTotalApostado(j.getTotalApostado() + a.getMonto());
            }
            else j.setTotalApostado(j.getTotalApostado() + a.getMonto());
        }
        Modelo.getInstancia().avisar(Modelo.EVENTO_ACTUALIZA_SALDOS);
    }
    
    public void eliminarApuestas(JugadorRuleta j){
        for (int i = 0; i < apuestas.size(); i++){
            if(apuestas.get(i).getJugador() == j){
                quitarApuesta(apuestas.get(i));
                i--;
            }
        }
    }

    public long totalApostadoRonda(JugadorRuleta j){
        long total = 0;
        for(Apuesta a:apuestas){
            if(a.getJugador()==j) total += a.getMonto();
        }
        return total;
    }
    // </editor-fold>


}
