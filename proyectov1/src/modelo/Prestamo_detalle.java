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

/**
 *
 * @author Usuario
 */
public class Prestamo_detalle {

    private int idPrestLibro;
    private int isbnf2;
    private int idPrestf2;

    public Prestamo_detalle() {
    }

    public Prestamo_detalle(int idPrestLibro, int isbnf2, int idPrestf2) {
        this.idPrestLibro = idPrestLibro;
        this.isbnf2 = isbnf2;
        this.idPrestf2 = idPrestf2;
    }

    public Prestamo_detalle(int isbnf2, int idPrestf2) {
        this.isbnf2 = isbnf2;
        this.idPrestf2 = idPrestf2;
    }

    public int getIdPrestf2() {
        return idPrestf2;
    }

    public void setIdPrestf2(int idPrestf2) {
        this.idPrestf2 = idPrestf2;
    }

    public int getIsbnf2() {
        return isbnf2;
    }

    public void setIsbnf2(int isbnf2) {
        this.isbnf2 = isbnf2;
    }

    public int getIdPrestLibro() {
        return idPrestLibro;
    }

    public void setIdPrestLibro(int idPrestLibro) {
        this.idPrestLibro = idPrestLibro;
    }

    @Override
    public String toString() {
        return "Prestamo_detalle{" + "idPrestLibro=" + idPrestLibro + ", isbnf2=" + isbnf2 + ", idPrestf2=" + idPrestf2 + '}';
    }

    public boolean prestamoDetalle(String sql) {
        boolean t = false;
        Conexion objc = new Conexion();

        if (objc.crearConexion()) {
            try {
                Statement sentencia = objc.getConexion().createStatement();
                sentencia.executeUpdate(sql);
                t = true;
            } catch (SQLException e) {
                e.printStackTrace();
                t = false;
            }
        }
        return t;
    }



}
