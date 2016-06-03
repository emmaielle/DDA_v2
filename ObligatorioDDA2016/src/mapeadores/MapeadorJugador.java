/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapeadores;

import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.Jugador;
import persistencia.Persistente;

/**
 *
 * @author Euge
 */
public class MapeadorJugador implements Persistente {
    Jugador j;

    public MapeadorJugador() {
    }

    public MapeadorJugador(Jugador j) {
        this.j = j;
    }

    public void setJ(Jugador j) {
        this.j = j;
    }
    
    @Override
    public int getOid() {
        if(j==null) return 0;
        else return j.getOid();
    }

    @Override
    public void setOid(int oid) {
        j.setOid(oid);
    }

    @Override
    public ArrayList<String> getSqlInsert() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<String> getSqlUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<String> getSqlDelete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getSqlSelect() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void leer(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void crearNuevo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getObjeto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
