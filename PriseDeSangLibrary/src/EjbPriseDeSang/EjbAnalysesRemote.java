/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjbPriseDeSang;

import PriseDeSangLibrary.Analyse;
import PriseDeSangLibrary.Demande;
import java.util.List;
import javax.ejb.Remote;
import javax.jms.Connection;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.Topic;

/**
 *
 * @author 'Toine
 */
@Remote
public interface EjbAnalysesRemote {
       
    void sendMessage(String text,Session ses, Connection con, Topic top);
    
    void sendMessage(String text,Session ses, Connection con, Queue que);
    
    List getDemandeList();

    List getAnalyseList();
    
    Demande getDemande(int pid);
    
    Analyse getAnalyse(int pid);
    
    Boolean addAnalyse(Analyse ppatient);
    
    Boolean addDemande(Demande ppatient);
}
