/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapeadores;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
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
    //deje el insert update y delete para hacer la carga automatica a la base
    @Override
    public ArrayList<String> getSqlInsert() {
        ArrayList<String> sqls = new ArrayList();
        sqls.add(
            "INSERT INTO usuario (oid,nombre,password,saldo,nombreUsuario) VALUES " +
              "(" + getOid() + ",'" + j.getNombre()+  
              "','"  +j.getPassword()+"',"+j.getSaldo()+",'"+j.getNombreCompleto()+"')");
        return sqls;
    }

    @Override
    public ArrayList<String> getSqlUpdate() {
        ArrayList<String> sqls = new ArrayList();
        sqls.add("UPDATE usuario set nombre='" + j.getNombre() + "', password='" + j.getPassword()+"',saldo="+j.getSaldo()+ ",nombreUsuario='"+j.getNombreCompleto()+"WHERE oid = " + j.getOid());
        return sqls;
    }
    
    @Override
    public ArrayList<String> getSqlDelete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getSqlSelect() {
        String sql = "SELECT * FROM usuario";
        if(j!=null) sql+= " where oid=" + getOid();
        return sql;
    }

    @Override
    public void leer(ResultSet rs) {
        try {
            j.setOid(rs.getInt("oid"));
            j.setNombre(rs.getString("nombre"));
            j.setNombreCompleto(rs.getString("nombreUsuario"));
            //q pasa con el saldo?
        } catch (SQLException ex) {
            System.out.println("Error al leer usuario:" + ex.getMessage());
        }
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
