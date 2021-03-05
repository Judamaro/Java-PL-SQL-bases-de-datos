/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import com.toedter.calendar.JDateChooser;
import control.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class Prestamo {

    private int idPrest;
    private String fechaPrest;
    private String fechaDevol;
    private String fechaLimite;
    private int totalLibros;
    private int idLectorf1;

    SimpleDateFormat Formato = new SimpleDateFormat("yyyy-MM-dd");

    public Prestamo() {
    }

    public Prestamo(int idPrest, String fechaPrest, String fechaDevol, String fechaLimite, int totalLibros, int idLectorf1) {
        this.idPrest = idPrest;
        this.fechaPrest = fechaPrest;
        this.fechaDevol = fechaDevol;
        this.fechaLimite = fechaLimite;
        this.totalLibros = totalLibros;
        this.idLectorf1 = idLectorf1;
    }

    public Prestamo(String fechaPrest, String fechaDevol, String fechaLimite, int totalLibros, int idLectorf1) {
        this.fechaPrest = fechaPrest;
        this.fechaDevol = fechaDevol;
        this.fechaLimite = fechaLimite;
        this.totalLibros = totalLibros;
        this.idLectorf1 = idLectorf1;
    }

    public int getIdLectorf1() {
        return idLectorf1;
    }

    public void setIdLectorf1(int idLectorf1) {
        this.idLectorf1 = idLectorf1;
    }

    public int getTotalLibros() {
        return totalLibros;
    }

    public void setTotalLibros(int totalLibros) {
        this.totalLibros = totalLibros;
    }

    public String getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(String fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public String getFechaDevol() {
        return fechaDevol;
    }

    public void setFechaDevol(String fechaDevol) {
        this.fechaDevol = fechaDevol;
    }

    public String getFechaPrest() {
        return fechaPrest;
    }

    public void setFechaPrest(String fechaPrest) {
        this.fechaPrest = fechaPrest;
    }

    public int getIdPrest() {
        return idPrest;
    }

    public void setIdPrest(int idPrest) {
        this.idPrest = idPrest;
    }

    @Override
    public String toString() {
        return "Prestamo{" + "idPrest=" + idPrest + ", fechaPrest=" + fechaPrest + ", fechaDevol=" + fechaDevol + ", fechaLimite=" + fechaLimite + ", totalLibros=" + totalLibros + ", idLectorf1=" + idLectorf1 + '}';
    }

    public String getFecha(JDateChooser jd) {
        if (jd.getDate() != null) {
            return Formato.format(jd.getDate());
        } else {
            return null;
        }
    }

    public boolean prestamoSolicitado(String sql) {

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

    public int consultarIdPrestamo(String sql) {

        int idPrestamo = 0;
        Conexion objc = new Conexion();

        if (objc.crearConexion()) {

            try {
                Statement st = objc.getConexion().createStatement();
                ResultSet rs = st.executeQuery(sql);

                while (rs.next()) {
                    idPrestamo = rs.getInt("idPrest");
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return idPrestamo;
    }

    public LinkedList<Prestamo> consultarPrestamosFechas(String sql) {

        LinkedList<Prestamo> lp = new LinkedList<>();

        Conexion objc = new Conexion();

        String fechaLimite = "";
        int totalLiros = 0;
        int idLector = 0;

        ResultSet rs = null;

        if (objc.crearConexion()) {

            try {

                rs = objc.getSt().executeQuery(sql);

                while (rs.next()) {
                    fechaLimite = rs.getString("fechaLimite");
                    totalLiros = rs.getInt("totalLibros");
                    idLector = rs.getInt("idLectorf1");

                    lp.add(new Prestamo("", "", fechaLimite, totalLiros, idLector));

                }

            } catch (SQLException e) {
                Logger.getLogger(Prestamo.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return lp;
    }

    public LinkedList<Prestamo> consultarPrestamosVigentes(String sql) {

        LinkedList<Prestamo> lp = new LinkedList<>();

        Conexion objc = new Conexion();

        String fechaPrest = "";
        String fechaDevol = "";
        String fechaLimite = "";
        int totalLi = 0;
        int idLector1 = 0;

        ResultSet rs = null;

        if (objc.crearConexion()) {

            try {

                rs = objc.getSt().executeQuery(sql);

                while (rs.next()) {

                    fechaPrest = rs.getString("fechaPrest");
                    try {
                        fechaDevol = rs.getString("fechaDevol");
                    } catch (NullPointerException e) {
                    }
                    if (rs.getString("fechaDevol") == null) {
                        fechaDevol = "Pendiente";
                    }

                    fechaLimite = rs.getString("fechaLimite");
                    totalLi = rs.getInt("totalLibros");
                    idLector1 = rs.getInt("idLectorf1");

                    lp.add(new Prestamo(fechaPrest, fechaDevol, fechaLimite, totalLi, idLector1));

                }

            } catch (SQLException e) {
                Logger.getLogger(Prestamo.class.getName()).log(Level.SEVERE, null, e);
            }

        }
        return lp;
    }

    public LinkedList<Prestamo> consultarPrestamosLector(String sql) {

        LinkedList<Prestamo> lp = new LinkedList<>();

        Conexion objc = new Conexion();

        int isbn = 0;
        String tituloL = "";
        String fechaPresta = "";
        String fechaLimit = "";

        ResultSet rs = null;

        if (objc.crearConexion()) {

            try {
                rs = objc.getSt().executeQuery(sql);

                while (rs.next()) {
                    isbn = rs.getInt("isbn");
                    tituloL = rs.getString("tituloLibro");
                    fechaPresta = rs.getString("fechaPrest");
                    fechaLimit = rs.getString("fechaLimite");

                    lp.add(new Prestamo(tituloL, fechaPresta, fechaLimit, isbn, 0));

                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return lp;
    }

    public LinkedList<Prestamo> consultarPrestamosVencidos(String sql) {

        LinkedList<Prestamo> lp = new LinkedList<>();

        Conexion objc = new Conexion();

        String fechaPres = "";
        String fechaDev = "";
        String fechaLimite = "";
        int totalL = 0;
        int idLector = 0;

        ResultSet rs = null;

        if (objc.crearConexion()) {
            try {

                rs = objc.getSt().executeQuery(sql);

                while (rs.next()) {

                    fechaPres = rs.getString("fechaPrest");
                    fechaDev = rs.getString("fechaDevol");
                    fechaLimite = rs.getString("fechaLimite");
                    totalL = rs.getInt("totalLibros");
                    idLector = rs.getInt("idLectorf1");

                    lp.add(new Prestamo(fechaPres, fechaDev, fechaLimite, totalL, idLector));

                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return lp;

    }

    public int consultarTotalLibros(String sql) {

        int totalL = 0;

        Conexion objc = new Conexion();

        ResultSet rs = null;

        if (objc.crearConexion()) {

            try {
                rs = objc.getSt().executeQuery(sql);

                while (rs.next()) {

                    totalL += rs.getInt("totalLibros");

                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return totalL;
    }
}
