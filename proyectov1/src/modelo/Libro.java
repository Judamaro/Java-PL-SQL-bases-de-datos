/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import control.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

/**
 *
 * @author Usuario
 */
public class Libro {

    private int isbn;
    private String tituloLibro;
    private int numbEjemplo;
    private byte[] imagLibro;
    private int idEditf;
    private int idCategf;

    public Libro() {
    }

    public Libro(int isbn, String tituloLibro, int numbEjemplo, byte[] imagLibro, int idEditf, int idCategf) {
        this.isbn = isbn;
        this.tituloLibro = tituloLibro;
        this.numbEjemplo = numbEjemplo;
        this.imagLibro = imagLibro;
        this.idEditf = idEditf;
        this.idCategf = idCategf;
    }

    public int getIdCategf() {
        return idCategf;
    }

    public void setIdCategf(int idCategf) {
        this.idCategf = idCategf;
    }

    public int getIdEditf() {
        return idEditf;
    }

    public void setIdEditf(int idEditf) {
        this.idEditf = idEditf;
    }

    public byte[] getImagLibro() {
        return imagLibro;
    }

    public void setImagLibro(byte[] imagLibro) {
        this.imagLibro = imagLibro;
    }

    public int getNumbEjemplo() {
        return numbEjemplo;
    }

    public void setNumbEjemplo(int numbEjemplo) {
        this.numbEjemplo = numbEjemplo;
    }

    public String getTituloLibro() {
        return tituloLibro;
    }

    public void setTituloLibro(String tituloLibro) {
        this.tituloLibro = tituloLibro;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Libro{" + "isbn=" + isbn + ", tituloLibro=" + tituloLibro + ", numbEjemplo=" + numbEjemplo + ", imagLibro=" + imagLibro + ", idEditf=" + idEditf + ", idCategf=" + idCategf + '}';
    }

    public boolean insertarAutor(Libro objal) {

        boolean t = false;
        PreparedStatement ps;
        Conexion objc = new Conexion();

        String sql = "insert into libros values (?, ?, ?, ?, ?, ?)";

        if (objc.crearConexion()) {

            try {
                objc.getConexion().setAutoCommit(false);
                ps = objc.getConexion().prepareStatement(sql);

                ps.setInt(1, objal.getIsbn());
                ps.setString(2, objal.getTituloLibro());
                ps.setInt(3, objal.getNumbEjemplo());
                ps.setBytes(4, objal.getImagLibro());
                ps.setInt(5, objal.getIdEditf());
                ps.setInt(6, objal.getIdCategf());

                ps.executeUpdate();
                objc.getConexion().commit();
                t = true;

            } catch (SQLException e) {
                e.printStackTrace();
                t = false;
            }
        }

        return t;

    }

    public Libro consultarLibro(String sql) {

        Conexion objc = new Conexion();

        Libro objl = new Libro();

        if (objc.crearConexion()) {

            try {

                Statement st = objc.getConexion().createStatement();
                ResultSet rs = st.executeQuery(sql);

                while (rs.next()) {

                    objl.setIsbn(rs.getInt("isbn"));
                    objl.setTituloLibro(rs.getString("tituloLibro"));
                    objl.setNumbEjemplo(rs.getInt("numbEjemplo"));
                    objl.setImagLibro(rs.getBytes("imagLibro"));
                    objl.setIdEditf(rs.getInt("idEditf"));
                    objl.setIdCategf(rs.getInt("idCategf"));

                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        return objl;
    }

    public boolean eliminarLibro(String sql) {

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

    public LinkedList<Libro> consultarLibro2(String sql) {
        ResultSet rs = null;

        LinkedList<Libro> ll = new LinkedList<>();
        Conexion objc = new Conexion();

        int isbn = 0;
        String titulo = "";
        int numbEjemplar = 0;
//        byte[] foto = ;
        int idEditf = 0;
        int idCategf = 0;

        if (objc.crearConexion()) {

            try {
                Statement st = objc.getConexion().createStatement();
                rs = st.executeQuery(sql);
                while (rs.next()) {
                    isbn = rs.getInt("isbn");
                    titulo = rs.getString("tituloLibro");
                    numbEjemplar = rs.getInt("numbEjemplo");
//                    foto = rs.getBytes("imagLibro");
                    idEditf = rs.getInt("idEditf");
                    idCategf = rs.getInt("idCategf");
                    ll.add(new Libro(isbn, titulo, numbEjemplar, null, idEditf, idCategf));
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return ll;
    }

    public boolean modificarLibro(Libro objal) {

        boolean t = false;
        PreparedStatement ps;
        Conexion objc = new Conexion();

        String sql = "update libros set tituloLibro = ?, numbEjemplo = ?, imagLibro = ?, idEditf = ?, idCategf = ?\n" + " where isbn = ?;";

        if (objc.crearConexion()) {

            try {
                objc.getConexion().setAutoCommit(false);
                ps = objc.getConexion().prepareStatement(sql);

                ps.setString(1, objal.getTituloLibro());
                ps.setInt(2, objal.getNumbEjemplo());
                ps.setBytes(3, objal.getImagLibro());
                ps.setInt(4, objal.getIdEditf());
                ps.setInt(5, objal.getIdCategf());
                ps.setInt(6, objal.getIsbn());

                ps.executeUpdate();
                objc.getConexion().commit();
                t = true;

            } catch (SQLException e) {
                e.printStackTrace();
                t = false;
            }
        }

        return t;

    }

}
