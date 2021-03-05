/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.ResultSet;
import java.util.LinkedList;
import modelo.Libro;
import modelo.Prestamo;
import modelo.Prestamo_detalle;

/**
 *
 * @author Usuario
 */
public class ControlPrestamo_detalle {

    public boolean prestamoDetalle(int idPrestamo, LinkedList<Libro> listalibrosS) {

        boolean t = false;

        Prestamo_detalle objpd = new Prestamo_detalle();

        for (int i = 0; i < listalibrosS.size(); i++) {

            Libro objl = listalibrosS.get(i);

            String sql = "insert into prestamos_detalle (isbnf2, idPrestf2) value (" + objl.getIsbn() + ", " + idPrestamo + ");";

            t = objpd.prestamoDetalle(sql);

        }
        return t;
    }

}
