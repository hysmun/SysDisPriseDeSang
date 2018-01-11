/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prisedesangclient;

import EjbPriseDeSang.EjbLoginRemoteRemote;
import Utilities.AllVariables;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import prisedesanggui.ApplicationMedecin;
import static test.testClient.ejbLogin;




public class Main {
    
    public static AllVariables ar;
    
    public static void main(String[] args) {
        
        ar = new AllVariables();
        
        ApplicationMedecin appMed = new ApplicationMedecin(ar);
        appMed.setVisible(true);


    }
     
}
