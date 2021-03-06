/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.Date;


/**
 *
 * @author Euge
 */
public class Jugador {
    private int oid;
    private String nombre;
    private String password;
    private String nombreCompleto;
    private long saldo;
    private long totalCobrado;
    private long totalApostado;
    private boolean enJuego;
    private boolean enMesa;
    private boolean statsOn;
    private boolean apuestasOn;
    private TipoJugador jugadorTipo;
    private ArrayList<Apuesta> apuestas = new ArrayList<>();
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">   
    
    public Jugador(String nombre, String password, String nombreCompleto, int saldo) {
        this.nombre = nombre;
        this.password = password;
        this.nombreCompleto = nombreCompleto;
        this.saldo = saldo;
    }
    //agregue para la persistencia ver....
    public Jugador() {
    }
    
    //</editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Getters y setters"> 
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isStatsOn() {
        return statsOn;
    }

    public void setStatsOn(boolean statsOn) {
        this.statsOn = statsOn;
        Modelo.getInstancia().avisar(Modelo.EVENTO_STATSWINDOW);
    }
    
    public boolean isEnMesa() {
        return enMesa;
    }

    public void setEnMesa(boolean enMesa) {
        this.enMesa = enMesa;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnJuego() {
        return enJuego;
    }

    public void setEnJuego(boolean enJuego) {
        this.enJuego = enJuego;
        Modelo.getInstancia().avisar(Modelo.EVENTO_JUEGO_CERRADO);
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public long getSaldo() {
        return saldo;
    }

    //agregue para la persistencia... ver
    public void setSaldo(long saldo) {
        this.saldo = saldo;
    }

    public long getTotalCobrado() {
        return totalCobrado;
    }

    public void setTotalCobrado(long totalCobrado) {
        this.totalCobrado = totalCobrado;
    }

    public void setTotalApostado(long totalApostado) {
        this.totalApostado = totalApostado;
    }
    
    public long getTotalApostado() {
        return totalApostado;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }
    public ArrayList<Apuesta> getApuestas() {
        return apuestas;
    }

    public boolean isApuestasOn() {
        return apuestasOn;
    }

    public void setApuestasOn(boolean apuestasOn) {
        this.apuestasOn = apuestasOn;
        Modelo.getInstancia().avisar(Modelo.EVENTO_APUESTASWINDOW);
    }

    public TipoJugador getJugadorTipo() {
        return jugadorTipo;
    }

    public void setJugadorTipo(TipoJugador jugadorTipo) {
        this.jugadorTipo = jugadorTipo;
    }
    
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Metodos"> 
    @Override
    public String toString(){
        return getNombreCompleto();
    }

    public void modificarSaldo(boolean agregar, int monto) {
        // a esta altura, ya se verifico que la cantidad restada no llegue a ser menor que lo 
        // que actualmente tiene, porque sino no se haria la apuesta
        if (agregar){
            saldo += monto;
        }
        else {
            saldo -= monto;
        }
    }
    
    // </editor-fold>

    public void agregarApuesta(String tipoApuesta, int montoApostado, Ronda r, int montGan) {
        Numero num = null;
        if (tipoApuesta.contains("Pleno")) num = new Numero(Integer.parseInt(tipoApuesta.split(" ")[1]));;
        Apuesta a = r.setApuestaByType(tipoApuesta, montoApostado, this, num);
        r.agregar(a);
        a.setJugador(this);
        a.setMontoGanado(montGan);
        agregarApuesta(a);
    }

    public void agregarApuesta(Apuesta a){
        if(a!=null) getApuestas().add(a);
    }

    public void quitarApuesta(Apuesta a){
        if (getApuestas().contains(a)) getApuestas().remove(a);
    }




}
