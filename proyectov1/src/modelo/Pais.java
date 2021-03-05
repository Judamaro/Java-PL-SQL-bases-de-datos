/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import control.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class Pais {

    private int idPais;
    private String nombPais;

    public Pais() {
    }

    public Pais(int idPais, String nombPais) {
        this.idPais = idPais;
        this.nombPais = nombPais;
    }

    public Pais(String nombPais) {
        this.nombPais = nombPais;
    }

    public String getNombPais() {
        return nombPais;
    }

    public void setNombPais(String nombPais) {
        this.nombPais = nombPais;
    }

    public int getIdPais() {
        return idPais;
    }

    public void setIdPais(int idPais) {
        this.idPais = idPais;
    }

    @Override
    public String toString() {
        return "Pais{" + "idPais=" + idPais + ", nombPais=" + nombPais + '}';
    }

    public LinkedList<Pais> consultarPaises(String sql) {

        LinkedList<Pais> lp = new LinkedList<>();
        Conexion objc = new Conexion();
        
        int idPais1 = 0;
        String nombrePais1 = "";

        ResultSet rs = null;
        if (objc.crearConexion()) {
            
            try {
                rs = objc.getSt().executeQuery(sql);
                while (rs.next()) {
                    idPais1 = rs.getInt("idPais");
                    nombrePais1 = rs.getString("nombPais");
                    lp.add(new Pais(idPais1, nombrePais1));    
                }       
            } catch (SQLException ex) {
                Logger.getLogger(Pais.class.getName()).log(Level.SEVERE, null, ex);
            }                
        }
        return lp;
    }

}
