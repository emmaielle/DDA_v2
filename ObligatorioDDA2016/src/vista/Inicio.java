/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.time.Clock;
import java.util.ArrayList;
import mapeadores.MapeadorJugador;
import modelo.Jugador;
import modelo.Modelo;
import persistencia.BaseDatos;

/**
 *
 * @author Euge
 */
public class Inicio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String url="jdbc:mysql://localhost/obligatoriodda2016";
        String user="root";
        String pass="";
        BaseDatos bd = BaseDatos.getInstancia();
        bd.conectar(url, user, pass);
        
//        MapeadorJugador mapJug = new MapeadorJugador();
//        ArrayList<Object> jugadores =  bd.obtenerTodos(mapJug);
//        Modelo m = Modelo.getInstancia();
//        m.agregar(j);

//        MapeadorJugador map = new MapeadorJugador();
//        Jugador j = new Jugador("a","a","Juan Perez",1000);
//        
//        map.setJ(j);
//        bd.guardar(map);
//        System.out.println(j);
//        j=new Jugador("b","b","Rodrigo Rodriguez",1000);
//        map.setJ(j);
//        bd.guardar(map);
//                System.out.println(j);
//
//        j=new Jugador("c","c","Roberto Lopez",1000);
//        map.setJ(j);
//        bd.guardar(map);
//                System.out.println(j);
//
//        j = new Jugador("d","d","Leticia Bueno",1000);
//        map.setJ(j);
//        bd.guardar(map);
//                System.out.println(j);
//
//        j = new Jugador("e","e","Laura Lorenzo",1000);
//        map.setJ(j);
//        bd.guardar(map);
//                System.out.println(j);
//
//        j=new Jugador("f","f","Luis Suarez",1000);
//        map.setJ(j);
//        bd.guardar(map);
//                System.out.println(j);
//
//        j = new Jugador("g","g","Moira Lasserre",1000);
//        map.setJ(j);
//        bd.guardar(map);
//                System.out.println(j);
//
//        j=new Jugador("h","h","Maria Eugenia Cremona",1000);
//        map.setJ(j);
//        bd.guardar(map);
//                System.out.println(j);
//
//        j=new Jugador("i","i","Dario Campalans",1000);
//        map.setJ(j);
//        bd.guardar(map);
//                System.out.println(j);
//
//        j=new Jugador("j","j","Gabriel Serrano",1000);
//        map.setJ(j);
//        bd.guardar(map);
//        
//        System.out.println(j);
        
        
        cargarDatos();
        // cargardatos la tenemos que cambiar por que los traiga de BD
        Principal principal = new Principal();
        principal.setVisible(true);
        principal.setLocationRelativeTo(null);
        
        
        bd.desconectar();
        System.out.println("Desconectado.");
        
    }
 
    private static void cargarDatos() {
        Modelo m = Modelo.getInstancia();
        Jugador j = new Jugador("a","a","Juan Perez",1000);
        
        m.agregar(j);
        
        m.agregar(new Jugador("b","b","Rodrigo Rodriguez",1000));
        m.agregar(new Jugador("c","c","Roberto Lopez",1000));
        m.agregar(new Jugador("d","d","Leticia Bueno",1000));
        m.agregar(new Jugador("e","e","Laura Lorenzo",1000));
        m.agregar(new Jugador("f","f","Luis Suarez",1000));
        m.agregar(new Jugador("g","g","Moira Lasserre",1000));
        m.agregar(new Jugador("h","h","Maria Eugenia Cremona",1000));
        m.agregar(new Jugador("i","i","Dario Campalans",1000));
        m.agregar(new Jugador("j","j","Gabriel Serrano",1000));
    }
    
}
