/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjbPriseDeSang;

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

    List<Patient> getPatientList();
    
}