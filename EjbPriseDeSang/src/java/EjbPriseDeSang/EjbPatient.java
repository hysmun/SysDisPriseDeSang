/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjbPriseDeSang;

import DataBaseLibrary.DBUtilities;
import PriseDeSangLibrary.Patient;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author 'Toine
 */
@Stateless
public class EjbPatient implements EjbPatientRemote {

    @Override
    public List getPatientList() {
        DBUtilities uti = new DBUtilities();
        
        List<Patient> lp;
        lp = new LinkedList<Patient>( uti.getList(Patient.class));
        return lp;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
