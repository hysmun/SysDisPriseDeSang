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
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

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
