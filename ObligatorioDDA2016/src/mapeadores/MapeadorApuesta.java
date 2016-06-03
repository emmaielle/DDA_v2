/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapeadores;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import modelo.Apuesta;
import persistencia.Persistente;

/**
 *
 * @author Euge
 */
public class MapeadorApuesta implements Persistente{
    Apuesta a;

    public MapeadorApuesta() {
    }

    public MapeadorApuesta(Apuesta a) {
        this.a = a;
    }

    public void setA(Apuesta a) {
        this.a = a;
    }
    
    @Override
    public int getOid() {
        if(a==null) return 0;
        else return a.getOid();
    }

    @Override
    public void setOid(int oid) {
        a.setOid(oid);
    }

    @Override
    public ArrayList<String> getSqlInsert() {
//        ArrayList<String> sqls = new ArrayList();
//        sqls.add(
//                "INSERT INTO apuesta (oid,numero,monto,oidjugador,oidronda) VALUES " +
//                  "(" + getOid() + "," + a.getNumero()+  
//                  ",'"  +new Timestamp(c.getFecha().getTime()) + "')");
//        return sqls;
        return null;
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
