/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prisedesangclient;

import EjbPriseDeSang.EjbLoginRemoteRemote;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

/**
 *
 * @author Morghen
 */
public class Main {

    @Resource(mappedName = "jms/TopicPDS")
    private static Topic topicPDS;

    @Resource(mappedName = "jms/TopicPDSFactory")
    private static ConnectionFactory topicPDSFactory;

    @EJB
    private static EjbLoginRemoteRemote ejbLogin;
    
    private static Connection con = null;
    
    private static Session ses = null;
    
    public static void main(String[] args) {
        
        try {
            con = topicPDSFactory.createConnection();
            ses = con.createSession(false, Session.AUTO_ACKNOWLEDGE);
        } catch (JMSException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
