/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;



/**
 *
 * @author Euge
 */
public class ApuestaDocena extends Apuesta {

    public ApuestaDocena(int monto, JugadorRuleta jugador, Numero numero, Ronda ronda, Date fechaHora) {
        super(monto, jugador, numero, ronda, fechaHora);
    }
 
	public int montoGanado() {
		return 0;
	}
	 
}
