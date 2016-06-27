/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import modelo.Modelo;

/**
 *
 * @author Euge
 */
public class Inicio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        cargarDatos();
        Principal principal = new Principal();
        principal.setVisible(true);
        principal.setLocationRelativeTo(null);
        
        
    }
 
    private static void cargarDatos() {
        Modelo m = Modelo.getInstancia();
        //m.persistirJugadores();
        m.obtenerTodos();
//        Jugador j = new Jugador("a","a","Juan Perez",1000);
//        
//        m.agregar(j);
//        
//        m.agregar(new Jugador("b","b","Rodrigo Rodriguez",1000));
//        m.agregar(new Jugador("c","c","Roberto Lopez",1000));
//        m.agregar(new Jugador("d","d","Leticia Bueno",1000));
//        m.agregar(new Jugador("e","e","Laura Lorenzo",1000));
//        m.agregar(new Jugador("f","f","Luis Suarez",1000));
//        m.agregar(new Jugador("g","g","Moira Lasserre",1000));
//        m.agregar(new Jugador("h","h","Maria Eugenia Cremona",1000));
//        m.agregar(new Jugador("i","i","Dario Campalans",1000));
//        m.agregar(new Jugador("j","j","Gabriel Serrano",1000));
    }
    
}
