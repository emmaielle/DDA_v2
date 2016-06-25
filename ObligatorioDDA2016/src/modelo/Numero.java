/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.awt.Color;

/**
 *
 * @author Euge
 */
public class Numero {
    private int valor;
    private Color color; // el color por defecto
    private Apuesta apuesta;

    // <editor-fold defaultstate="collapsed" desc="Constructor">   
    public Numero(int valor, Color color) {
        this.valor = valor;
        this.color = color;
    }
    //</editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters y setters"> 
    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Apuesta getApuesta() {
        return apuesta;
    }

    public void setApuesta(Apuesta apuesta) {
        this.apuesta = apuesta;
    }
    // </editor-fold>

    @Override
    public String toString() {
        String j = "Sin marcar";
        if(apuesta!=null) j=apuesta.getJugador().getJugador().getNombreCompleto();
        return "Numero{" + "valor=" + valor + ", usuario=" + j + '}';
    }
    
    
}
