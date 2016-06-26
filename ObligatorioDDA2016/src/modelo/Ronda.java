/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Observer;


/**
 *
 * @author Euge
 */
public class Ronda implements Observer{
    private int oid;
    private final int nroRonda;
    private ArrayList<Apuesta> apuestasGanadoras = new ArrayList<>();
    private Numero nroGanador = null;
    //private String colorGanador; ///
    private ArrayList<Apuesta> apuestas = new ArrayList<>();
    private static int TIEMPO_LIMITE = 10; // minutos
    private final Mesa mesa;
    private Date fechaYhoraFin;
    private final Proceso elProceso;


    // <editor-fold defaultstate="collapsed" desc="Constructor">   
    public Ronda(int numRonda, Mesa m) {
        nroRonda = numRonda;
        mesa = m;
        elProceso = new Proceso();
        elProceso.addObserver(this);
        elProceso.reset();
        elProceso.ejecutar();
    }
    
    //</editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters y setters">
    public Numero getNroGanador() {
        return nroGanador;
    }

    public static int getTIEMPO_LIMITE() {
        return TIEMPO_LIMITE;
    }

    public static void setTIEMPO_LIMITE(int TIEMPO_LIMITE) {
        Ronda.TIEMPO_LIMITE = TIEMPO_LIMITE;
    }

    public Mesa getMesa() {
        return mesa;
    }
    
    public void setApuestas(ArrayList<Apuesta> apuestas) {
        this.apuestas = apuestas;
    }
    
    public int getNroRonda() {
        return nroRonda;
    }

    public ArrayList<Apuesta> getApuestaGanadora() {
        return apuestasGanadoras;
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


    public Date getFechaYhoraFin() {
        return fechaYhoraFin;
    }

    public void setFechaYhoraFin(Date fechaYhoraFin) {
        this.fechaYhoraFin = fechaYhoraFin;
    }
    //agregue para la persistencia
    public void setNroGanador(Numero nroGanador) {
        this.nroGanador = nroGanador;
    }

    public Proceso getElProceso() {
        return elProceso;
    }
    
    
    
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Metodos">
    
    // sortea si no existe, sino devuelve existente
    public Numero sortearNroGanador() {
        
        if (nroGanador == null){ // todavia no se sorteo
            int randomOut = (int)Math.floor(Math.random()*37);
            Numero tablero = mesa.buscarNumeroEnTablero(randomOut);
            nroGanador = new Numero(tablero.getValor(), tablero.getColor());
            lookForWinner();
            this.fechaYhoraFin=new Date();
            return nroGanador;
        }
        return nroGanador;
    }
    
    public ApuestaPleno buscarApuestaPorNumero(Numero n){
        ApuestaPleno yaApostada = null;
        for (Apuesta a: apuestas){
            if (a instanceof ApuestaPleno){
                ApuestaPleno ap = (ApuestaPleno)a;
                if (ap.getNumeroTablero() == n)
                    yaApostada = ap;
            }
        }
        return yaApostada;
    }
    
    private Apuesta buscarApuestaPorTipo(String tipo) {
        Apuesta yaApostada = null;
        String type = tipo.split(" ")[0];
        String eleccion = tipo.split(" ")[1];
         for (Apuesta a: apuestas){
            if (a.getTipo().equals(type)){
                if (a.getNumero().split(" ")[1].equals(eleccion))
                    yaApostada = a;
            }
        }
        return yaApostada;
    }
    
    public void apostar(String numero, Numero n, int v, JugadorRuleta jugador) { //funciona en ambos sentidos si se clickea de nuevo
        Apuesta yaApostada = buscarApuestaPorTipo(numero);
        if (yaApostada == null){ // si entra aca es porque ese numero no fue elegido antes
            Apuesta a = setApuestaByType(numero, v, jugador, n);
            if (a.validar()){
                if (!areThereBetsInThisRondaForThisPlayer(jugador)) {
                    jugador.setRondasSinApostarAnterior(jugador.getRondasSinApostar());
                    jugador.setRondasSinApostar(0);
                }
                agregarApuesta(a);
                jugador.getJugador().modificarSaldo(false, v);
            }
        }
        else desapostar(jugador, numero);
    }
    
    public void desapostar(JugadorRuleta j, Numero n){
        Apuesta yaApostada = buscarApuestaPorNumero(n);
        if (yaApostada.getJugador().equals(j)) 
            quitarApuesta(yaApostada);
        if (!areThereBetsInThisRondaForThisPlayer(j)) j.setRondasSinApostar(j.getRondasSinApostarAnterior());
    }
    
    public void desapostar(JugadorRuleta j, String tipo) {
        Apuesta yaApostada = buscarApuestaPorTipo(tipo);
        if (yaApostada.getJugador().equals(j)) 
            quitarApuesta(yaApostada);
        if (!areThereBetsInThisRondaForThisPlayer(j)) j.setRondasSinApostar(j.getRondasSinApostarAnterior());
    }
    
    public void quitarApuesta(Apuesta a){
        a.getJugador().getJugador().modificarSaldo(true,a.getMonto());
        if (a instanceof ApuestaPleno){
            ((ApuestaPleno)a).getNumeroTablero().setApuesta(null);
        }
        a.getJugador().quitarApuesta(a);
        a.setJugador(null);
        a.setRonda(null);
        apuestas.remove(a);
        Modelo.getInstancia().avisar(Modelo.EVENTO_TABLERO);
    }
    
    // unico para el pleno 
    public void agregarApuesta(Apuesta a){
        if (a instanceof ApuestaPleno){
            ((ApuestaPleno)a).getNumeroTablero().setApuesta(a);
        }
        a.getJugador().agregarApuesta(a);
        apuestas.add(a);
        Modelo.getInstancia().avisar(Modelo.EVENTO_TABLERO);
    }

    private void lookForWinner() {
        for (Apuesta a : apuestas){
            if (a.esGanadora(nroGanador)) apuestasGanadoras.add(a);
        }
    }
    
    public void modificarSaldos() {
        for (Apuesta a: apuestas){
            Jugador j = a.getJugador().getJugador();
            if (apuestasGanadoras != null && apuestasGanadoras.equals(a)){ // si hubo un ganador
                j.modificarSaldo(true, a.getMonto()* 35);
                j.setTotalCobrado(j.getTotalCobrado() + a.getMonto() * 35);
                j.setTotalApostado(j.getTotalApostado() + a.getMonto());
                a.setMontoGanado(a.getMonto()* 35);
            }
            else {
                j.setTotalApostado(j.getTotalApostado() + a.getMonto());
                a.setMontoGanado(0);
            }
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

    public boolean areThereBetsInThisRondaForThisPlayer(JugadorRuleta jugador) {
        for (Apuesta a : apuestas){
            if (a.getJugador().equals(jugador)) return true;
        }
        return false;
    }
    // </editor-fold>

    @Override
    public void update(java.util.Observable o, Object arg) {
        if (arg.equals(Proceso.EVENTO_ADD_SECONDS)){
            Modelo.getInstancia().avisar(Modelo.EVENTO_ADD_SECONDS);
        }
        else if (arg.equals(Proceso.EVENTO_TIME_OUT)){            
            mesa.finalizarApuestaPorTiempo();
            Modelo.getInstancia().avisar(Modelo.EVENTO_SIN_JUGAR);
        }
    }

    public void stopProceso() {
        elProceso.parar();
    }


    public void quitarObservador() {
        elProceso.deleteObserver(this);
    }

    private Apuesta setApuestaByType(String numero, int monto, JugadorRuleta jugador, Numero n) {
        Apuesta a;
        String type = numero.split(" ")[0];
        if (n != null && type.equals("Pleno")){
            a = new ApuestaPleno(monto, jugador, numero, n, this, new Date());
        }
        else if (type.equals("Color")){
            a = new ApuestaColor(monto, jugador, numero, this, new Date());
        }
        else if (type.equals("Docena")){
            a = new ApuestaDocena(monto, jugador, numero, this, new Date());
        }
        else a = null;
        return a;
    }






}
