/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;
import DataBaseLibrary.*;
import PriseDeSangLibrary.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.*;
/**
 *
 * @author 'Toine
 */
public class Main {
    
       
    public static void main(String[] args) {
        try {
            List<Medecin> lm;
            List<Analyse> la;
            List<Demande> ld;
            List<Patient> lp;
            /*EntityManagerFactory emf = Persistence.createEntityManagerFactory("PriseDeSangLibraryPU");
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            List<Medecin> lm = em.createQuery("SELECT m FROM Medecin m").getResultList();
            
            for(Medecin m : lm){
                System.out.println("medecin : " + m);
            }*/
            
            DBUtilities uti = new DBUtilities();uti.getList(Patient.class);
            lp = uti.getList(Patient.class);
            for(Patient p : lp){
                System.out.println(p.toString());
            }
            
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
