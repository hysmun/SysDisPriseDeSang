/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjbPriseDeSang;

import PriseDeSangLibrary.Analyse;
import PriseDeSangLibrary.Demande;
import PriseDeSangLibrary.Medecin;
import PriseDeSangLibrary.Patient;
import java.util.Collection;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author 'Toine
 */
@Remote
public interface EjbPatientRemote {

    List getPatientList();
    
    List getMedecinList();

    Patient getPatient(int pid);
    
    Medecin getMedecin(int pid);
    
    Boolean addPatient(Patient ppatient);
    
    Boolean addMedecin(Medecin ppatient);
    
    Boolean modifPatient(Patient ppatient);
    
}
