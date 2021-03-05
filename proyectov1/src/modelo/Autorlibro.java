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
public class Autorlibro {
    
    private int idAutor;
    private String nombAutor1;
    private String nombAutor2;
    private String apellAutor1;
    private String apellAutor2;
    private String dirrAutor;
    private String telAutor1;
    private String telAutor2;
    private int idPaisf;
    private int idCiudadf;
    
    public Autorlibro() {
    }
    
    public Autorlibro(int idAutor, String nombAutor1, String nombAutor2, String apellAutor1, String apellAutor2, String dirrAutor, String telAutor1, String telAutor2, int paisAutor, int ciudadAutor) {
        this.idAutor = idAutor;
        this.nombAutor1 = nombAutor1;
        this.nombAutor2 = nombAutor2;
        this.apellAutor1 = apellAutor1;
        this.apellAutor2 = apellAutor2;
        this.dirrAutor = dirrAutor;
        this.telAutor1 = telAutor1;
        this.telAutor2 = telAutor2;
        this.idPaisf = paisAutor;
        this.idCiudadf = ciudadAutor;
    }
    
    public Autorlibro(String nombAutor1, String nombAutor2, String apellAutor1, String apellAutor2, String dirrAutor, String telAutor1, String telAutor2, int paisAutor, int ciudadAutor) {
        this.nombAutor1 = nombAutor1;
        this.nombAutor2 = nombAutor2;
        this.apellAutor1 = apellAutor1;
        this.apellAutor2 = apellAutor2;
        this.dirrAutor = dirrAutor;
        this.telAutor1 = telAutor1;
        this.telAutor2 = telAutor2;
        this.idPaisf = paisAutor;
        this.idCiudadf = ciudadAutor;
    }
    
    public int getIdCiudadf() {
        return idCiudadf;
    }
    
    public void setIdCiudadf(int idCiudadf) {
        this.idCiudadf = idCiudadf;
    }
    
    public int getIdPaisf() {
        return idPaisf;
    }
    
    public void setIdPaisf(int idPaisf) {
        this.idPaisf = idPaisf;
    }
    
    public String getTelAutor2() {
        return telAutor2;
    }
    
    public void setTelAutor2(String telAutor2) {
        this.telAutor2 = telAutor2;
    }
    
    public String getTelAutor1() {
        return telAutor1;
    }
    
    public void setTelAutor1(String telAutor1) {
        this.telAutor1 = telAutor1;
    }
    
    public String getDirrAutor() {
        return dirrAutor;
    }
    
    public void setDirrAutor(String dirrAutor) {
        this.dirrAutor = dirrAutor;
    }
    
    public String getApellAutor2() {
        return apellAutor2;
    }
    
    public void setApellAutor2(String apellAutor2) {
        this.apellAutor2 = apellAutor2;
    }
    
    public String getApellAutor1() {
        return apellAutor1;
    }
    
    public void setApellAutor1(String apellAutor1) {
        this.apellAutor1 = apellAutor1;
    }
    
    public String getNombAutor2() {
        return nombAutor2;
    }
    
    public void setNombAutor2(String nombAutor2) {
        this.nombAutor2 = nombAutor2;
    }
    
    public String getNombAutor1() {
        return nombAutor1;
    }
    
    public void setNombAutor1(String nombAutor1) {
        this.nombAutor1 = nombAutor1;
    }
    
    public int getIdAutor() {
        return idAutor;
    }
    
    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }
    
    @Override
    public String toString() {
        return "Autorlibro{" + "idAutor=" + idAutor + ", nombAutor1=" + nombAutor1 + ", nombAutor2=" + nombAutor2 + ", apellAutor1=" + apellAutor1 + ", apellAutor2=" + apellAutor2 + ", dirrAutor=" + dirrAutor + ", telAutor1=" + telAutor1 + ", telAutor2=" + telAutor2 + ", paisAutor=" + idPaisf + ", ciudadAutor=" + idCiudadf + '}';
    }
    
    public boolean insertarAutor(String sql) {
        
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
    
    public Autorlibro consultarAutor(String sql) {
        
        Conexion objc = new Conexion();
        Autorlibro objal = new Autorlibro();
        
        if (objc.crearConexion()) {
            try {
                Statement sentencia = objc.getConexion().createStatement();
                ResultSet rs = sentencia.executeQuery(sql);
                
                while (rs.next()) {
                    
                    objal.setIdAutor(rs.getInt("idAutor"));
                    objal.setNombAutor1(rs.getString("nombAutor1"));
                    
                    try {
                        objal.setNombAutor2(rs.getString("nombAutor2"));
                    } catch (NullPointerException e) {
                    }
                    if (rs.getString("nombAutor2") == null) {
                        objal.setNombAutor2("");
                    }
                    
                    objal.setApellAutor1(rs.getString("apellAutor1"));
                    
                    try {
                        objal.setApellAutor2(rs.getString("apellAutor2"));
                    } catch (NullPointerException e) {
                    }
                    if (rs.getString("apellAutor2") == null) {
                        objal.setApellAutor2("");
                    }
                    
                    objal.setDirrAutor(rs.getString("dirrAutor"));
                    objal.setTelAutor1(rs.getString("telAutor1"));
                    objal.setTelAutor2(rs.getString("telAutor2"));
                    objal.setIdPaisf(rs.getInt("idPaisf"));
                    objal.setIdCiudadf(rs.getInt("idCiudadf"));
                    
                }
                
            } catch (SQLException e) {
                e.printStackTrace();
            }
            
        }
        
        return objal;
        
    }
    
    public boolean modificarAutorL(String sql) {
        
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
    
    public boolean eliminarAutorL(String sql) {
        
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

    public LinkedList<Autorlibro> consultarAutorLT(String sql) {
        
        LinkedList<Autorlibro> lal = new LinkedList<>();
        Conexion objc = new Conexion();
        
        int idAutor = 0;
        String nombA1 = "";
        String nombA2 = "";
        String apellA1 = "";
        String apellA2 = "";
        String dirr = "";
        String telA1 = "";
        String telA2 = "";
        int idpaisf = 0;
        int idciudadf = 0;
        
        ResultSet rs = null;
        
        if (objc.crearConexion()) {
            try {
                rs = objc.getSt().executeQuery(sql);
                while(rs.next()){
                    idAutor = rs.getInt("idAutor");
                    nombA1 = rs.getString("nombAutor1");
                        try {
                            nombA2 = rs.getString("nombAutor2");
                        } catch (NullPointerException e) {
                        }if (rs.getString("nombAutor2")==null) {
                            nombA2 = "";
                        }
                    apellA1 = rs.getString("apellAutor1");
                        try {
                            apellA2 = rs.getString("apellAutor2");
                        } catch (NullPointerException e) {
                        }if (rs.getString("apellAutor2")==null) {
                            apellA2 = "";
                        }
                    dirr = rs.getString("dirrAutor");
                    telA1 = rs.getString("telAutor1");
                    telA2 = rs.getString("telAutor2");
                    idpaisf = rs.getInt("idPaisf");
                    idciudadf = rs.getInt("idCiudadf");
                
                    lal.add(new Autorlibro(idAutor, nombA1, nombA2, apellA1, apellA2, dirr, telA1, telA2, idpaisf, idciudadf));
                
                }
            } catch (SQLException e) {
                Logger.getLogger(Autorlibro.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return lal;
    }
    
}
