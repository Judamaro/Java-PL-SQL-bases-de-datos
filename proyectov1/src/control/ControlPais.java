/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.LinkedList;
import modelo.Pais;

/**
 *
 * @author Usuario
 */
public class ControlPais {

    public LinkedList<Pais> consultarPaises() {

        LinkedList<Pais> lp = new LinkedList<>();
        String sql = "select * from paises";
        Pais objp = new Pais();
        lp = objp.consultarPaises(sql);

        return lp;
    }
    
}
