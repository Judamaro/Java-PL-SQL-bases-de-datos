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
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class Lector {

    private int idLector;
    private String nombLector1;
    private String nombLector12;
    private String apellLector1;
    private String apellLector12;
    private String dirrLector;
    private String telLector1;
    private String telLector2;
    private String telLector3;
    private String telLector4;
    private byte[] fotoLector;
    private String nicknameLector;
    private String contraseña;

    public Lector() {
    }

    public Lector(int idLector, String nombLector1, String nombLector12, String apellLector1, String apellLector12, String dirrLector, String telLector1, String telLector2, String telLector3, String telLector4, byte[] fotoLector, String nicknameLector, String contraseña) {
        this.idLector = idLector;
        this.nombLector1 = nombLector1;
        this.nombLector12 = nombLector12;
        this.apellLector1 = apellLector1;
        this.apellLector12 = apellLector12;
        this.dirrLector = dirrLector;
        this.telLector1 = telLector1;
        this.telLector2 = telLector2;
        this.telLector3 = telLector3;
        this.telLector4 = telLector4;
        this.fotoLector = fotoLector;
        this.nicknameLector = nicknameLector;
        this.contraseña = contraseña;
    }

    public Lector(String nombLector1, String nombLector12, String apellLector1, String apellLector12, String dirrLector, String telLector1, String telLector2, String telLector3, String telLector4, byte[] fotoLector, String nicknameLector, String contraseña) {
        this.nombLector1 = nombLector1;
        this.nombLector12 = nombLector12;
        this.apellLector1 = apellLector1;
        this.apellLector12 = apellLector12;
        this.dirrLector = dirrLector;
        this.telLector1 = telLector1;
        this.telLector2 = telLector2;
        this.telLector3 = telLector3;
        this.telLector4 = telLector4;
        this.fotoLector = fotoLector;
        this.nicknameLector = nicknameLector;
        this.contraseña = contraseña;
    }

    public byte[] getFotoLector() {
        return fotoLector;
    }

    public void setFotoLector(byte[] fotoLector) {
        this.fotoLector = fotoLector;
    }

    public String getNicknameLector() {
        return nicknameLector;
    }

    public void setNicknameLector(String nicknameLector) {
        this.nicknameLector = nicknameLector;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getTelLector4() {
        return telLector4;
    }

    public void setTelLector4(String telLector4) {
        this.telLector4 = telLector4;
    }

    public String getTelLector3() {
        return telLector3;
    }

    public void setTelLector3(String telLector3) {
        this.telLector3 = telLector3;
    }

    public String getTelLector2() {
        return telLector2;
    }

    public void setTelLector2(String telLector2) {
        this.telLector2 = telLector2;
    }

    public String getTelLector1() {
        return telLector1;
    }

    public void setTelLector1(String telLector1) {
        this.telLector1 = telLector1;
    }

    public String getDirrLector() {
        return dirrLector;
    }

    public void setDirrLector(String dirrLector) {
        this.dirrLector = dirrLector;
    }

    public String getApellLector12() {
        return apellLector12;
    }

    public void setApellLector12(String apellLector12) {
        this.apellLector12 = apellLector12;
    }

    public String getApellLector1() {
        return apellLector1;
    }

    public void setApellLector1(String apellLector1) {
        this.apellLector1 = apellLector1;
    }

    public String getNombLector12() {
        return nombLector12;
    }

    public void setNombLector12(String nombLector12) {
        this.nombLector12 = nombLector12;
    }

    public String getNombLector1() {
        return nombLector1;
    }

    public void setNombLector1(String nombLector1) {
        this.nombLector1 = nombLector1;
    }

    public int getIdLector() {
        return idLector;
    }

    public void setIdLector(int idLector) {
        this.idLector = idLector;
    }

    public boolean registrarLector(Lector le) {

        boolean t = false;
        PreparedStatement ps;
        Conexion objc = new Conexion();
        String sql = "insert into lectores (nombLector1, nombLector2, apellLector1, apellLector2, dirrLector, telLector1, telLector2, telLector3, telLector4, fotoLector, nicknameLector, contrasena) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

        if (objc.crearConexion()) {
            try {
                objc.getConexion().setAutoCommit(false);
                ps = objc.getConexion().prepareStatement(sql);

                ps.setString(1, le.getNombLector1());
                ps.setString(2, le.getNombLector12());
                ps.setString(3, le.getApellLector1());
                ps.setString(4, le.getApellLector12());
                ps.setString(5, le.getDirrLector());
                ps.setString(6, le.getTelLector1());
                ps.setString(7, le.getTelLector2());
                ps.setString(8, le.getTelLector3());
                ps.setString(9, le.getTelLector4());
                ps.setBytes(10, le.getFotoLector());
                ps.setString(11, le.getNicknameLector());
                ps.setString(12, le.getContraseña());

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

    public boolean consultarlgin(String sql) {

        boolean t = false;
        Conexion objc = new Conexion();

        if (objc.crearConexion()) {

            try {

                Statement sentencia = objc.getConexion().createStatement();
                ResultSet rs = sentencia.executeQuery(sql);

                if (rs.next()) {
                    t = true;
                } else {
                    JOptionPane.showMessageDialog(null, "No existe la cuenta");
                }

            } catch (SQLException e) {
                e.printStackTrace();
                t = false;
            }
        }
        return t;

    }

    public int consultarIdL(String sql) {

        int idLector1 = 0;
        Conexion objc = new Conexion();

        if (objc.crearConexion()) {
            try {
                Statement st = objc.getConexion().createStatement();
                ResultSet rs = st.executeQuery(sql);
                if (rs.next()) {
                    idLector1 = rs.getInt("idLector");
                }else{
                idLector1 = 0;
                }
                
            } catch (SQLException e) {
                e.printStackTrace();
            }
            
        }
        return idLector1;

    }

}
