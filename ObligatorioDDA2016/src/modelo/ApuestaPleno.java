package modelo;

import java.util.Date;



public class ApuestaPleno extends Apuesta {
    
    private Numero numeroTablero;

    public ApuestaPleno(int monto, JugadorRuleta jugador, Numero numero, String num, Ronda ronda, Date fechaHora) {
        super(monto, jugador, numero, num, ronda, fechaHora);
        this.numeroTablero=numero;
    }
    
    
	 
    public boolean validar(){
        return numeroTablero!=null;
    }
}
 
