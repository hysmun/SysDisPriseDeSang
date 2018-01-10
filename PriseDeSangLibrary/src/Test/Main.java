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
import javax.naming.InitialContext;
import javax.persistence.*;
/**
 *
 * @author 'Toine
 */
public class Main {
    
    /*@EJB
    private static EjbPatientRemote ejbPatientRemote;*/
    
    @EJB
    private static EjbLoginRemoteRemote ejbLoginRemoteRemote;
       
    public static void main(String[] args) {
        try {
            List<Medecin> lm;
            List<Analyse> la;
            List<Demande> ld;
            List<Patient> lp;
            
            
            ejbLoginRemoteRemote.doIt("coucou");
            
            /*EntityManagerFactory emf = Persistence.createEntityManagerFactory("PriseDeSangLibraryPU");
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            List<Medecin> lm = em.createQuery("SELECT m FROM Medecin m").getResultList();
            
            for(Medecin m : lm){
                System.out.println("medecin : " + m);
            }*/
            
            
            
            /*if(ejbPatientRemote == null)
                System.out.println("ERREUR");
            lp = ejbPatientRemote.getPatientList();
            if(lp != null)
                for(Patient p : lp){
                    System.out.println(p.toString());
                }
            else
                System.out.println("ERREUR NULL");*/
            
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
