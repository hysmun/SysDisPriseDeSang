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
import Utilities.AllVariables;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.jboss.weld.logging.Category;

@Stateless
public class EjbAnalyses implements EjbAnalysesRemote {
    
    private static Connection conQ =null;
    private static Session sesQ =null;
    
    private static MessageProducer prodQ = null;

    
    private static Connection conT =null;
    private static Session sesT =null;
    
    private static MessageProducer prodT = null;
    
    
    public static DBUtilities uti = new DBUtilities();
    
    
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
    public List getAnalyseDone() {
        List lp;
        lp = uti.getList(Analyse.class);
        LinkedList<Analyse> lpdone = new LinkedList<>();
        for(Analyse a : (List<Analyse>)lp){
            if(! a.getValeur().equals("NULL"))
                lpdone.add(a);
        }
        return lpdone;
    }
    
    @Override
    public List getAnalyseNotDone() {
        List lp;
        lp = uti.getList(Analyse.class);
        LinkedList<Analyse> lpdone = new LinkedList<>();
        for(Analyse a : (List<Analyse>)lp){
            if(a.getValeur().equals("NULL"))
                lpdone.add(a);
        }
        return lpdone;
    }
    
    @Override
    public List getDemandeNotDone() {
        List lp;
        lp = uti.getList(Analyse.class);
        LinkedList<Demande> lpdone = new LinkedList<>();
        for(Analyse a : (List<Analyse>)lp){
            if(a.getValeur().equals("NULL"))
                lpdone.add(getDemande(a.getIdAnalyse()));
        }
        return lpdone;
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
    public Boolean addAnalyse(Analyse ppatient, AllVariables av) {
        try{
            int id = uti.getNextId(Analyse.class);
            ppatient.setIdAnalyse(id);
            uti.em.persist(ppatient);
            uti.commit();
            uti.em.getTransaction().begin();
            if(prodQ == null)
                prodQ = av.sesQue.createProducer(av.queue);
            TextMessage tm = av.sesQue.createTextMessage();
            tm.setText(""+ppatient.getIdAnalyse());
            prodQ.send(tm);
        }catch(Exception e){
            Logger.getLogger(EjbAnalyses.class.getName()).log(Level.SEVERE, null, e);
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
            uti.commit();
            uti.em.getTransaction().begin();
        }catch(Exception e){
            throw e;
        }
        return true;
    }
    
    @Override
    public Boolean modifAnalyse(Analyse ppatient, AllVariables av) {
        try{
            Analyse p;
            //p=uti.em.find(Patient.class, ppatient);
            uti.em.merge(ppatient);
            uti.commit();
            uti.em.getTransaction().begin();
            Demande d= uti.getById(Demande.class, ppatient.getIdAnalyse());
            if(prodT == null)
                prodT = av.sesTop.createProducer(av.topic);
            
            TextMessage tm = av.sesTop.createTextMessage();
            tm.setBooleanProperty("urgent",d.getUrgent()== 0 ? false: true);
            tm.setText(""+ppatient.getIdAnalyse());
            prodT.send(tm);
        }catch(Exception e){
            Logger.getLogger(EjbAnalyses.class.getName()).log(Level.SEVERE, null, e);
        }
        return true;
    }
    
    
}
