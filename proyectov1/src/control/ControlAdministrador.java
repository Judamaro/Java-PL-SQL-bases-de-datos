/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import modelo.Administrador;

/**
 *
 * @author Usuario
 */
public class ControlAdministrador {

    public boolean consultarLogin(String nickname, String contra) {
        
        boolean t = false;
        Administrador objadmin = new Administrador();
        String sql = "Select * from administradores where nicknameAdmin = '"+nickname+"' and contrasenaAdmin ='"+contra+"' ;";
        
        t = objadmin.consultarlgin(sql);
     
        return t;
    }
    
}
