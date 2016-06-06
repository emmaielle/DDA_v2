package modelo;

import java.util.Date;



public class ApuestaPleno extends Apuesta {
 
	private Numero numeroTablero;
	 
	private Numero numero;

    public ApuestaPleno(int monto, JugadorRuleta jugador, Numero numero, Ronda ronda, Date fechaHora) {
        super(monto, jugador, numero, ronda, fechaHora);
    }
	 
	public int montoGanado() {
		return 0;
	}
	 
}
 
