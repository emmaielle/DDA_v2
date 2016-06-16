package modelo;

import java.util.Date;



public class ApuestaPleno extends Apuesta {
    
    private Numero numeroTablero;
    
    public ApuestaPleno(int monto, JugadorRuleta jugador, Numero numero, Ronda ronda, Date fechaHora, Numero numTablero) {
        super(monto, jugador, numero, ronda, fechaHora);
    this.numeroTablero=numTablero;
    }
	 
    public boolean validar(){
        return numeroTablero!=null;
    }
}
 
