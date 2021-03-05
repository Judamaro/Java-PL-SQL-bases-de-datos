/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.LinkedList;
import modelo.Autor_participacion;

/**
 *
 * @author Usuario
 */
public class ControlAutor_participacion {

    public boolean insertarAutorP(LinkedList<Autor_participacion> listaParticipacion) {

        boolean t = false;
        Autor_participacion objap = new Autor_participacion();
        for (int i = 0; i < listaParticipacion.size(); i++) {
            Autor_participacion objap2 = listaParticipacion.get(i);
            String sql = "insert into autores_participacion ( idAutorf, isbnf1) values (" + objap2.getIdAutorf() + "," + objap2.getIsbnf1() + ")";
            t = objap.insertarAutorP(sql);
        }
        return t;
    }

}
