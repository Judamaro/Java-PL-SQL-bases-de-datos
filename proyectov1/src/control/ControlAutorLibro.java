/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.LinkedList;
import modelo.Autorlibro;

/**
 *
 * @author Usuario
 */
public class ControlAutorLibro {

    public boolean insertarAutorLibro(LinkedList<Autorlibro> listaAutores) {
       
        boolean t = false;
        Autorlibro objal = new Autorlibro();
        for (int i = 0; i < listaAutores.size(); i++) {
            Autorlibro get = listaAutores.get(i);
            String sql = "insert into autoreslibros (nombAutor1, nombAutor2, apellAutor1, apellAutor2, dirrAutor, telAutor1, telAutor2, idPaisf, idCiudadf) value ('"+get.getNombAutor1()+"', '"+get.getNombAutor2()+"', '"+get.getApellAutor1()+"', '"+get.getApellAutor2()+"', '"+get.getDirrAutor()+"', '"+get.getTelAutor1()+"', '"+get.getTelAutor2()+"',"+get.getIdPaisf()+","+get.getIdCiudadf()+");";
            t = objal.insertarAutor(sql);
        }
        
       return t;
              
    }

    public Autorlibro consultarAutorL(String nomb1, String apell1, int idAutor) {
  
        Autorlibro objal2 = new Autorlibro();
        String sql = "select * from autoreslibros where idAutor = "+idAutor+" and nombAutor1 = '"+nomb1+"' and apellAutor1 = '"+apell1+"';";
        Autorlibro objal = new Autorlibro();
        objal2 = objal.consultarAutor(sql);
        
          return objal2;
    }

    public boolean modificarAutorL(int idautor, String nomb1, String nomb2, String apell1, String apell2, String dirr, String tel1, String tel2, int idpaisf, int idciudadf) {
         boolean t = false;
         
         Autorlibro objal = new Autorlibro();
         String sql = "update autoreslibros set nombAutor1 = '"+nomb1+"', nombAutor2 = '"+nomb2+"', apellAutor1 = '"+apell1+"', apellAutor2 = '"+apell2+"', dirrAutor = '"+dirr+"', telAutor1 = '"+tel1+"', telAutor2 = '"+tel2+"', idPaisf = "+idpaisf+", idCiudadf = "+idciudadf+" where idAutor = "+idautor+"; ";
         
         t = objal.modificarAutorL(sql);
         
         return t;
    
    }

    public boolean eliminarAutorL(int idautor, String nomb1, String apell1, int idpaisf, int idciudadf) {
        boolean t = false;
        
        Autorlibro objal = new Autorlibro();
        String sql = "delete from autoreslibros where idAutor = "+idautor+" and nombAutor1 = '"+nomb1+"' and apellAutor1 = '"+apell1+"' and idPaisf = "+idpaisf+" and idCiudadf = "+idciudadf+";";
        
        t = objal.eliminarAutorL(sql);
        
        return t;
     
    }

    public LinkedList<Autorlibro> consultarAutorLT() {
        
        LinkedList<Autorlibro> lal = new LinkedList<>();
        String sql = "select * from autoreslibros";
        Autorlibro objal = new Autorlibro();
        lal = objal.consultarAutorLT(sql);
        return lal;
    }
    
    
    
}
 