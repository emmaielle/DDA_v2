/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Euge
 */
public class Apuesta {
    private int monto;
    private JugadorRuleta jugador;
    private Numero numero;

    // <editor-fold defaultstate="collapsed" desc="Constructor"> 

    public Apuesta(int monto, JugadorRuleta jugador, Numero numero) {
        this.monto = monto;
        this.jugador = jugador;
        this.numero = numero;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Getters y setters">       
    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public JugadorRuleta getJugador() {
        return jugador;
    }

    public void setJugador(JugadorRuleta jugador) {
        this.jugador = jugador;
    }

    public Numero getNumero() {
        return numero;
    }

    public void setNumero(Numero numero) {
        this.numero = numero;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Metodos"> 
    public boolean validar() {
        return monto > 0 && jugador != null && numero != null; 
    }
    // </editor-fold>
}
