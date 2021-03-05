/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import control.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class Categoria {

    private int idCateg;
    private String nombCateg;
    private String fechaCateg;

    public Categoria() {
    }

    public Categoria(int idCateg, String nombCateg, String fechaCateg) {
        this.idCateg = idCateg;
        this.nombCateg = nombCateg;
        this.fechaCateg = fechaCateg;
    }

    public Categoria(String nombCateg, String fechaCateg) {
        this.nombCateg = nombCateg;
        this.fechaCateg = fechaCateg;
    }

    public String getFechaCateg() {
        return fechaCateg;
    }

    public void setFechaCateg(String fechaCateg) {
        this.fechaCateg = fechaCateg;
    }

    public String getNombCateg() {
        return nombCateg;
    }

    public void setNombCateg(String nombCateg) {
        this.nombCateg = nombCateg;
    }

    public int getIdCateg() {
        return idCateg;
    }

    public void setIdCateg(int idCateg) {
        this.idCateg = idCateg;
    }

    @Override
    public String toString() {
        return "Categoria{" + "idCateg=" + idCateg + ", nombCateg=" + nombCateg + ", fechaCateg=" + fechaCateg + '}';
    }

    public LinkedList<Categoria> consultarCategorias(String sql) {

        LinkedList<Categoria> lc = new LinkedList<>();
        Conexion objc = new Conexion();

        int idCategoria1 = 0;
        String nombCategoria1 = "";
        String fechaCateg1 = "";

        ResultSet rs = null;
        if (objc.crearConexion()) {

            try {
                rs = objc.getSt().executeQuery(sql);
                while (rs.next()) {
                    idCategoria1 = rs.getInt("idCateg");
                    nombCategoria1 = rs.getString("nombCateg");
                    fechaCateg1 = rs.getString("fechaCateg");

                    lc.add(new Categoria(idCategoria1, nombCategoria1, fechaCateg1));
                }
            } catch (SQLException ex) {
                Logger.getLogger(Categoria.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lc;

    }

    public Categoria consultarCategorias2(String sql) {

        Conexion objc = new Conexion();
        Categoria objca = new Categoria();

        int idCateg = 0;
        String nombCateg = "";
        String fechaCateg = "";

        ResultSet rs = null;
        if (objc.crearConexion()) {
            try {

                rs = objc.getSt().executeQuery(sql);
                while (rs.next()) {
                    idCateg = rs.getInt("idCateg");
                    nombCateg = rs.getString("nombCateg");
                    fechaCateg = rs.getString("fechaCateg");

                    objca = new Categoria(idCateg, nombCateg, fechaCateg);

                }
            } catch (SQLException e) {
                Logger.getLogger(Categoria.class.getName()).log(Level.SEVERE, null, e);
            }

        }

        return objca;
    }

    public boolean modificarCategoria(String sql) {

        boolean t = false;
        Conexion objc = new Conexion();

        if (objc.crearConexion()) {

            try {
                Statement st = objc.getConexion().createStatement();
                st.executeUpdate(sql);
                t = true;
            } catch (SQLException e) {
                {
                    e.printStackTrace();
                    t = false;
                }
            }

        }
        return t;

    }

    public boolean eliminarCategoria(String sql) {

        boolean t = false;
        Conexion objc = new Conexion();

        if (objc.crearConexion()) {
            try {
                Statement st = objc.getConexion().createStatement();
                st.executeUpdate(sql);
                t = true;
            } catch (SQLException e) {
                e.printStackTrace();
                t = false;
            }
        }
        return t;

    }

}
