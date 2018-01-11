/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjbPriseDeSang;

import DataBaseLibrary.DBUtilities;
import static EjbPriseDeSang.EjbPatient.uti;
import PriseDeSangLibrary.Analyse;
import PriseDeSangLibrary.Demande;
import PriseDeSangLibrary.Medecin;
import PriseDeSangLibrary.Patient;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.naming.InitialContext;
import javax.naming.NamingException;

@Stateless
public class EjbAnalyses implements EjbAnalysesRemote {
    
    private static MessageProducer prodQue = null;
    private static MessageProducer prodTop = null;
    
    
    public static DBUtilities uti = new DBUtilities();
    
    
    @Override
    public void sendMessage(String text,Session ses, Connection con, Topic top)
    {
        try
        {
            if(prodTop == null)
            {
                prodTop = ses.createProducer(top);
            }
            TextMessage txt = ses.createTextMessage();
            txt.setText(text);
            prodTop.send(txt);
        }
        catch(JMSException ex)
        {
            Logger.getLogger(EjbAnalyses.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void sendMessage(String text,Session ses, Connection con, Queue que)
    {
        try
        {
            if(prodQue == null)
            {
                prodQue = ses.createProducer(que);
            }
            TextMessage txt = ses.createTextMessage();
            txt.setText(text);
            prodQue.send(txt);
        }
        catch(JMSException ex)
        {
            Logger.getLogger(EjbAnalyses.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
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
        p = uti.getById(Demande.class, pid);
        return p;
    }
    
    @Override
    public Analyse getAnalyse(int pid) {
        Analyse p;
        p = uti.getById(Analyse.class, pid);
        return p;
    }
    
    @Override
    public Boolean addAnalyse(Analyse ppatient) {
        try{
            int id = uti.getNextId(Analyse.class);
            ppatient.setIdAnalyse(id);
            uti.em.persist(ppatient);
            uti.commit();
            uti.em.getTransaction().begin();
        }catch(Exception e){
            throw e;
        }
        return true;
    }
    
    @Override
    public int nextIdDemande(){
        int nbr;
        try{
            nbr = uti.getNextId(Demande.class);
        }catch(Exception e){
            throw e;
        }
        return nbr;
    }
    
    @Override
    public Boolean addDemande(Demande ppatient) {
        try{
            Medecin m = uti.getById(Medecin.class, ppatient.getRefMedecin().getIdMedecin());
            Patient p = uti.getById(Patient.class, ppatient.getRefPatient().getIdPatient());
            
            ppatient.setRefMedecin(m);
            ppatient.setRefPatient(p);
            
            uti.em.persist(ppatient);
            uti.commit();
            uti.em.getTransaction().begin();
        }catch(Exception e){
            throw e;
        }
        return true;
    }
    
    @Override
    public Boolean modifAnalyse(Analyse ppatient) {
        try{
            Analyse p;
            //p=uti.em.find(Patient.class, ppatient);
            uti.em.merge(ppatient);
        }catch(Exception e){
            throw e;
        }
        return true;
    }
}
