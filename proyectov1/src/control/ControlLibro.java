/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.LinkedList;
import modelo.Categoria;
import modelo.Libro;

/**
 *
 * @author Usuario
 */
public class ControlLibro {

    Libro al;

    public boolean insertarLibro(int isbn, String titulo, int ejemplar, File ruta, int idEditf, int idCategf) {
        boolean t = false;
        Libro objal = new Libro();
        al = new Libro();

        objal.setIsbn(isbn);
        objal.setTituloLibro(titulo);
        objal.setNumbEjemplo(ejemplar);

        try {
            byte[] foto = new byte[(int) ruta.length()];
            InputStream input = new FileInputStream(ruta);
            input.read(foto);
            objal.setImagLibro(foto);
        } catch (Exception e) {
            objal.setImagLibro(null);
        }

        objal.setIdEditf(idEditf);
        objal.setIdCategf(idCategf);

        t = al.insertarAutor(objal);

        return t;
    }

    public Libro consultarLibro(int isbn) {

        Libro objl1 = new Libro();

        String sql = "select * from libros where isbn = " + isbn + ";";

        Libro objl2 = new Libro();

        objl1 = objl2.consultarLibro(sql);

        return objl1;

    }

    public boolean eliminarLibro(int isbn) {

        boolean t = false;

        Libro objl = new Libro();

        String sql = "delete from libros where isbn = " + isbn + ";";

        objl.eliminarLibro(sql);

        return t;

    }

    public LinkedList<Libro> consultarLibro2(int idCateg) {

        String sql = "select * from libros where idCategf = " + idCateg + ";";

        Libro objl = new Libro();

        LinkedList<Libro> listalibro = objl.consultarLibro2(sql);

        return listalibro;
    }

    public boolean modificarLibro(int isbn, String tituloL, int numbEjemp, File ruta, int idEditf, int idCategf) {

        boolean t = false;

        Libro objl = new Libro();

        al = new Libro();

        objl.setIsbn(isbn);
        objl.setTituloLibro(tituloL);
        objl.setNumbEjemplo(numbEjemp);

        try {
            byte[] foto = new byte[(int) ruta.length()];
            InputStream input = new FileInputStream(ruta);
            input.read(foto);
            objl.setImagLibro(foto);
        } catch (Exception e) {
            objl.setImagLibro(null);
        }

        objl.setIdEditf(idEditf);
        objl.setIdCategf(idCategf);

        t = objl.modificarLibro(objl);

        return t;

    }

}
