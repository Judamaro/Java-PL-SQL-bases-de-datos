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
public class Administrador {

    private int idAdmin;
    private String nicknameAdmin;
    private String contrasenaAdmin;

    public Administrador() {
    }

    public Administrador(int idAdmin, String nicknameAdmin, String contrasenaAdmin) {
        this.idAdmin = idAdmin;
        this.nicknameAdmin = nicknameAdmin;
        this.contrasenaAdmin = contrasenaAdmin;
    }

    public Administrador(String nicknameAdmin, String contrasenaAdmin) {
        this.nicknameAdmin = nicknameAdmin;
        this.contrasenaAdmin = contrasenaAdmin;
    }

    public String getContrasenaAdmin() {
        return contrasenaAdmin;
    }

    public void setContrasenaAdmin(String contrasenaAdmin) {
        this.contrasenaAdmin = contrasenaAdmin;
    }

    public String getNicknameAdmin() {
        return nicknameAdmin;
    }

    public void setNicknameAdmin(String nicknameAdmin) {
        this.nicknameAdmin = nicknameAdmin;
    }

    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    @Override
    public String toString() {
        return "administrador{" + "idAdmin=" + idAdmin + ", nicknameAdmin=" + nicknameAdmin + ", contrasenaAdmin=" + contrasenaAdmin + '}';
    }

    public boolean consultarlgin(String sql) {
        
        
        boolean t = false;
        Conexion objc = new Conexion();
        
        if (objc.crearConexion()) {
            
            try {
                
                Statement sentencia = objc.getConexion().createStatement();
                ResultSet rs = sentencia.executeQuery(sql);
                
                if (rs.next()) {
                    t=true;
                }else{
                    JOptionPane.showMessageDialog(null, "No existe el administrador");
                }
                     
            } catch (SQLException e) {
                e.printStackTrace();
                t=false;
            }     
        }
       return t;
    }

    
    
    
    
}
