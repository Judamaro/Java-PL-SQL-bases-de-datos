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
public class Ciudad {

    private int idCiudad;
    private String nombCiudad;

    public Ciudad() {
    }

    public Ciudad(int idCiudad, String nombCiudad) {
        this.idCiudad = idCiudad;
        this.nombCiudad = nombCiudad;
    }

    public Ciudad(String nombCiudad) {
        this.nombCiudad = nombCiudad;
    }

    public String getNombCiudad() {
        return nombCiudad;
    }

    public void setNombCiudad(String nombCiudad) {
        this.nombCiudad = nombCiudad;
    }

    public int getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(int idCiudad) {
        this.idCiudad = idCiudad;
    }

    @Override
    public String toString() {
        return "Ciudad{" + "idCiudad=" + idCiudad + ", nombCiudad=" + nombCiudad + '}';
    }

    public LinkedList<Ciudad> consultarCiudades(String sql) {
        LinkedList<Ciudad> lc = new LinkedList<>();
        Conexion objc = new Conexion();
        int idCiudad1 = 0;
        String nombCiudad1 = "";
        ResultSet rs = null;
        
        if (objc.crearConexion()) {
            try {
                rs = objc.getSt().executeQuery(sql);
                while(rs.next()){
                    idCiudad1 = rs.getInt("idCiudad");
                    nombCiudad1 = rs.getString("nombCiudad");
                    lc.add( new Ciudad(idCiudad1, nombCiudad1));         
                }            
            } catch (SQLException ex) {
                Logger.getLogger(Ciudad.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    return lc;
    
    }

}
