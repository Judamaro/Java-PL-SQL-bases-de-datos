/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import modelo.Lector;

/**
 *
 * @author Usuario
 */
public class ControlLector {
    
    Lector le;

    public boolean registrarlector(String nomb1, String nomb2, String apell1, String apell2, String dirr, String tel1, String tel2, String tel3, String tel4, File ruta, String nickname, String contra) {
        
        boolean t = false;
        
        Lector lec = new Lector();
        le = new Lector();
        
        lec.setNombLector1(nomb1);
        lec.setNombLector12(nomb2);
        lec.setApellLector1(apell1);
        lec.setApellLector12(apell2);
        lec.setDirrLector(dirr);
        lec.setTelLector1(tel1);
        lec.setTelLector2(tel2);
        lec.setTelLector3(tel3);
        lec.setTelLector4(tel4);
        try {
            byte[] foto = new byte[(int) ruta.length()];
            InputStream input = new FileInputStream(ruta);
            input.read(foto);
            lec.setFotoLector(foto);
        } catch (Exception e) {
            lec.setFotoLector(null);
        }
        lec.setNicknameLector(nickname);
        lec.setContraseña(contra);
        

        t = le.registrarLector(lec);
        
        return t;
    }

    public boolean consultarLogin(String nickname, String contra) {
                
        boolean t = false;
        Lector objlector = new Lector();
        String sql = "Select * from lectores where nicknameLector = '"+nickname+"' and contrasena ='"+contra+"' ;";
        
        t = objlector.consultarlgin(sql);
     
        return t;
    }

    public int consultarIdL(String nicknameL, String contraL) {
        
        Lector objl = new Lector();
        String sql = "select idLector from lectores where nicknameLector = '"+nicknameL+"' and contrasena = '"+contraL+"';";
        int idLector = objl.consultarIdL(sql);
        
        return idLector;
    }
    
}
