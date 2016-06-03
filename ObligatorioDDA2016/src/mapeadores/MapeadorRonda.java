/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapeadores;

import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.Ronda;
import persistencia.Persistente;

/**
 *
 * @author Euge
 */
public class MapeadorRonda implements Persistente{
    Ronda r;

    public MapeadorRonda() {
    }

    public MapeadorRonda(Ronda r) {
        this.r = r;
    }

    public void setR(Ronda r) {
        this.r = r;
    }
    
    
    @Override
    public int getOid() {
        if(r==null) return 0;
        else return r.getOid();
    }

    @Override
    public void setOid(int oid) {
        r.setOid(oid);
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
