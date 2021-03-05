/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.LinkedList;
import modelo.Editorial;

/**
 *
 * @author Usuario
 */
public class ControlEditorial {

    public LinkedList<Editorial> consultarEditoriales() {

        LinkedList<Editorial> le = new LinkedList<>();
        String sql = "select * from editoriales";
        Editorial obje = new Editorial();
        le = obje.consultarEditorial(sql);

        return le;

    }


}
