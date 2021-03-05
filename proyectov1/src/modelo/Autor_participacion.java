/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import control.Conexion;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Usuario
 */
public class Autor_participacion {

    private int idAutoLibros;
    private int idAutorf;
    private int isbnf1;

    public Autor_participacion() {
    }

    public Autor_participacion(int idAutoLibros, int idAutorf, int isbnf1) {
        this.idAutoLibros = idAutoLibros;
        this.idAutorf = idAutorf;
        this.isbnf1 = isbnf1;
    }

    public Autor_participacion(int idAutorf, int isbnf1) {
        this.idAutorf = idAutorf;
        this.isbnf1 = isbnf1;
    }

    public int getIsbnf1() {
        return isbnf1;
    }

    public void setIsbnf1(int isbnf1) {
        this.isbnf1 = isbnf1;
    }

    public int getIdAutorf() {
        return idAutorf;
    }

    public void setIdAutorf(int idAutorf) {
        this.idAutorf = idAutorf;
    }

    public int getIdAutoLibros() {
        return idAutoLibros;
    }

    public void setIdAutoLibros(int idAutoLibros) {
        this.idAutoLibros = idAutoLibros;
    }

    @Override
    public String toString() {
        return "Autor_participacion{" + "idAutoLibros=" + idAutoLibros + ", idAutorf=" + idAutorf + ", isbnf1=" + isbnf1 + '}';
    }

    public boolean insertarAutorP(String sql) {
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
