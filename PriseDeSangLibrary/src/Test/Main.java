/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;
import DataBaseLibrary.*;
import EjbPriseDeSang.EjbLoginRemoteRemote;
import EjbPriseDeSang.EjbPatientRemote;
import PriseDeSangLibrary.*;
import java.time.Clock;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.persistence.*;
/**
 *
 * @author 'Toine
 */
public class Main {
    
    @EJB
    private static EjbPatientRemote ejbPatientRemote;
    
    @EJB
    private static EjbLoginRemoteRemote ejbLoginRemote;
       
    public static void main(String[] args) {
        try {
            List<Medecin> lm=null;
            List<Analyse> la=null;
            List<Demande> ld=null;
            List<Patient> lp=null;
            /*EntityManagerFactory emf = Persistence.createEntityManagerFactory("PriseDeSangLibraryPU");
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            List<Medecin> lm = em.createQuery("SELECT m FROM Medecin m").getResultList();
            
            for(Medecin m : lm){
                System.out.println("medecin : " + m);
            }*/
            
            if(ejbPatientRemote == null)
                System.out.println("ERREUR");
            //lp = ejbPatientRemote.getPatientList();
            ejbLoginRemote.doIt("test");
            if(lp != null)
                for(Patient p : lp){
                    System.out.println(p.toString());
                }
            else
                System.out.println("ERREUR NULL");
            
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
