/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjbPriseDeSang;

import DataBaseLibrary.DBUtilities;
import PriseDeSangLibrary.Analyse;
import PriseDeSangLibrary.Demande;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

/**
 *
 * @author 'Toine
 */
@Stateless
public class EjbAnalyses implements EjbAnalysesRemote {
    
    public static DBUtilities uti = new DBUtilities();
    
    @Override
    public MessageProducer creaProducer(Connection con,Session ses,Topic top) {
        MessageProducer prod = null;
        try {
            prod = ses.createProducer(top);
        } catch (JMSException ex) {
            Logger.getLogger(EjbAnalyses.class.getName()).log(Level.SEVERE, null, ex);
        }
        return prod;       
    }
    
    @Override
    public void sendMessage(String text,Session ses,MessageProducer prod)
    {
        try
        {
            TextMessage txt = ses.createTextMessage();
            txt.setText(text);
            prod.send(txt);
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
