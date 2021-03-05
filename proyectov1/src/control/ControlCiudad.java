/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.LinkedList;
import modelo.Ciudad;

/**
 *
 * @author Usuario
 */
public class ControlCiudad {

    public LinkedList<Ciudad> consultarCiudades() {

        LinkedList<Ciudad> lc = new LinkedList<>();
        String sql = "select * from ciudades";
        Ciudad objc = new Ciudad();
        lc = objc.consultarCiudades(sql);

        return lc;

    }
    
}
