/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjbPriseDeSang;

import static EjbPriseDeSang.EjbPatient.uti;
import PriseDeSangLibrary.Analyse;
import PriseDeSangLibrary.Demande;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author 'Toine
 */
@Stateless
public class EjbAnalyses implements EjbAnalysesRemote {

    @Override
    public List getDemandeList() {
        List lp;
        lp = uti.getList(Demande.class);
        return lp;
    }

    @Override
    public List getAnalyseList() {
        List lp;
        lp = uti.getList(Analyse.class);
        return lp;
    }
    
    @Override
    public Demande getDemande(int pid) {
        Demande p;
        p = uti.em.find(Demande.class, pid);
        return p;
    }
    
    @Override
    public Analyse getAnalyse(int pid) {
        Analyse p;
        p = uti.em.find(Analyse.class, pid);
        return p;
    }
    
    @Override
    public Boolean addAnalyse(Analyse ppatient) {
        try{
            uti.em.persist(ppatient);
        }catch(Exception e){
            throw e;
        }
        return true;
    }
    
    @Override
    public Boolean addDemande(Demande ppatient) {
        try{
            uti.em.persist(ppatient);
        }catch(Exception e){
            throw e;
        }
        return true;
    }
}
