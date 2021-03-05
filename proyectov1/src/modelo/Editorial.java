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
public class Editorial {

    private int idEdit;
    private String nombEdit;

    public Editorial() {
    }

    public Editorial(int idEdit, String nombEdit) {
        this.idEdit = idEdit;
        this.nombEdit = nombEdit;
    }

    public Editorial(String nombEdit) {
        this.nombEdit = nombEdit;
    }

    public String getNombEdit() {
        return nombEdit;
    }

    public void setNombEdit(String nombEdit) {
        this.nombEdit = nombEdit;
    }

    public int getIdEdit() {
        return idEdit;
    }

    public void setIdEdit(int idEdit) {
        this.idEdit = idEdit;
    }

    @Override
    public String toString() {
        return "Editorial{" + "idEdit=" + idEdit + ", nombEdit=" + nombEdit + '}';
    }

    public LinkedList<Editorial> consultarEditorial(String sql) {

        LinkedList<Editorial> le = new LinkedList<>();
        Conexion objc = new Conexion();

        int idEditorial1 = 0;
        String nombEditorial1 = "";

        ResultSet rs = null;
        if (objc.crearConexion()) {

            try {
                rs = objc.getSt().executeQuery(sql);
                while (rs.next()) {
                    idEditorial1 = rs.getInt("idEdit");
                    nombEditorial1 = rs.getString("nombEdit");
                    le.add(new Editorial(idEditorial1, nombEditorial1));
                }
            } catch (SQLException ex) {
                Logger.getLogger(Editorial.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return le;

    }

}
