/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjbPriseDeSang;

import DataBaseLibrary.DBUtilities;
import PriseDeSangLibrary.Analyse;
import PriseDeSangLibrary.Demande;
import PriseDeSangLibrary.Medecin;
import PriseDeSangLibrary.Patient;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.Singleton;
import javax.ejb.Stateless;
import org.apache.taglibs.standard.extra.spath.Predicate;

/**
 *
 * @author 'Toine
 */
@Stateless
public class EjbPatient implements EjbPatientRemote {

    public static DBUtilities uti = new DBUtilities();
    
    @Override
    public List getPatientList() {
        List lp;
        lp = uti.getList(Patient.class);
        return lp;
    }
    
    @Override
    public List getMedecinList() {
        List lp;
        lp = uti.getList(Medecin.class);
        return lp;
        
        
        
        
    }
    
    @Override
    public Patient getPatient(int pid) {
        Patient p;
        Predicate cond = new Predicate(){
            boolean evaluate(Object sample) {
                return (sample).idPatient.equals(pid);
        }};
        p = uti.getList(Patient.class).stream().filter((<any> item) -> item.idPatient.equals(pid));
        
        return p;
    }
    @Override
    public Medecin getMedecin(int pid) {
        Medecin p;
        p = uti.em.find(Medecin.class, pid);
        return p;
    }

    @Override
    public Boolean addPatient(Patient ppatient) {
        try{
            int id = uti.getNextId(Patient.class);
            ppatient.setIdPatient(id);
            uti.em.persist(ppatient);
            uti.commit();
            uti.em.getTransaction().begin();
        }catch(Exception e){
            throw e;
        }
        return true;
    }
    
    @Override
    public Boolean addMedecin(Medecin ppatient) {
        try{
            int id = uti.getNextId(Medecin.class);
            ppatient.setIdmedecin(id);
            uti.em.persist(ppatient);
            uti.commit();
            uti.em.getTransaction().begin();
        }catch(Exception e){
            throw e;
        }
        return true;
    }
    
    @Override
    public Boolean modifPatient(Patient ppatient) {
        try{
            Patient p;
            p=uti.em.find(Patient.class, ppatient);
            uti.em.merge(p);
        }catch(Exception e){
            throw e;
        }
        return true;
    }
}
