/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.LinkedList;
import modelo.Prestamo;

/**
 *
 * @author Usuario
 */
public class ControlPrestamo {

    public boolean prestamoSolicitado(String fechaIni, String fechaLimi, int numbLibros, int idLector) {

        boolean t = false;

        String sql = "insert into prestamos (fechaPrest, fechaLimite, totalLibros, idLectorf1) value ('" + fechaIni + "', '" + fechaLimi + "', " + numbLibros + ", " + idLector + ");";

        Prestamo objp = new Prestamo();

        t = objp.prestamoSolicitado(sql);

        return t;

    }

    public int consultarIdPrestamo(int idLector) {

        int idPrestamo = 0;

        String sql = "Select (idPrest) from prestamos where idLectorf1 = " + idLector + ";";

        Prestamo objp = new Prestamo();

        idPrestamo = objp.consultarIdPrestamo(sql);

        return idPrestamo;
    }

    public LinkedList<Prestamo> consultarPrestamosFechas(String fecha1, String fecha2) {

        LinkedList<Prestamo> listaP = new LinkedList<>();

        String sql = "Select * from prestamos where fechaPrest between '" + fecha1 + "' and '" + fecha2 + "' ;";

        Prestamo objp = new Prestamo();

        listaP = objp.consultarPrestamosFechas(sql);

        return listaP;
    }

    public LinkedList<Prestamo> consultarPrestamosVigentes() {

        LinkedList<Prestamo> listap = new LinkedList<>();

        String sql = "Select * from prestamos";

        Prestamo objp = new Prestamo();

        listap = objp.consultarPrestamosVigentes(sql);

        return listap;

    }

    public LinkedList<Prestamo> consultarPrestamosLector(int idLector) {

        LinkedList<Prestamo> listap = new LinkedList<>();

        String sql = "select libros.isbn, libros.tituloLibro, prestamos.fechaprest, prestamos.fechaLimite from prestamos inner join prestamos_detalle on prestamos.idPrest = prestamos_detalle.idPrestf2 inner join libros on prestamos_detalle.isbnf2 = libros.isbn where idLectorf1 = " + idLector + ";";

        Prestamo objp = new Prestamo();

        listap = objp.consultarPrestamosLector(sql);

        return listap;
    }

    public LinkedList<Prestamo> consultarPrestamosVencidos() {

        LinkedList<Prestamo> listap = new LinkedList<>();

        String sql = "select * from prestamos where datediff(fechaDevol, fechaLimite) >= 1;";

        Prestamo objp = new Prestamo();

        listap = objp.consultarPrestamosVencidos(sql);

        return listap;

    }

    public int consultarTotalLibros(int idLector) {

        int totalL = 0;

        String sql = "select (totalLibros) from prestamos where idLectorf1 =" + idLector + ";";

        Prestamo objp = new Prestamo();

        totalL = objp.consultarTotalLibros(sql);

        return totalL;

    }

}
