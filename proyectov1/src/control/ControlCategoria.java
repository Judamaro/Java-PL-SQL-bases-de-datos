/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.LinkedList;
import modelo.Categoria;

/**
 *
 * @author Usuario
 */
public class ControlCategoria {

    public LinkedList<Categoria> consultarCategorias() {

        LinkedList<Categoria> lc = new LinkedList<>();
        String sql = "select * from categorias";
        Categoria objc = new Categoria();
        lc = objc.consultarCategorias(sql);

        return lc;

    }

    public Categoria consultarCategorias2(int idCateg) {

        Categoria objc = new Categoria();
        String sql = "select * from categorias where idCateg = " + idCateg + ";";

        Categoria objc2 = new Categoria();
        objc2 = objc.consultarCategorias2(sql);

        return objc2;

    }

    public boolean modificarCategoria(int idCateg, String nombCateg, String fechaCateg) {
        
        boolean t = false;
        
        Categoria objc = new Categoria();
        
        String sql = "update categorias set nombCateg = '"+nombCateg+"', fechaCateg = '"+fechaCateg+"' where idCateg = "+idCateg+";";
        
        t = objc.modificarCategoria(sql);
        
        return t;
    }

    public boolean eliminarCategoria(int idCateg) {
        
        boolean t = false;
        
        Categoria objc = new Categoria();
        
        String sql = "delete from categorias where idCateg ="+idCateg+";";
        
        t = objc.eliminarCategoria(sql);
        
        return t;
        
        
    }

}
