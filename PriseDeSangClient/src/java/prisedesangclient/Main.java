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
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

/**
 *
 * @author Morghen
 */
public class Main {

    @Resource(mappedName = "jms/QueuePDS")
    private static Queue queuePDS;

    @Resource(mappedName = "jms/QueuePDSFactory")
    private static ConnectionFactory queuePDSFactory;

    @Resource(mappedName = "jms/TopicPDS")
    private static Topic topicPDS;

    @Resource(mappedName = "jms/TopicPDSFactory")
    private static ConnectionFactory topicPDSFactory;

    
    
    private static Connection conTop = null;
    
    private static Connection conQueue = null;
    
    private static Session sesTop = null;
    
    private static Session sesQue = null;
    
    public static void main(String[] args) {
        
        try {
            conTop = topicPDSFactory.createConnection();
            sesTop = conTop.createSession(false, Session.AUTO_ACKNOWLEDGE);
            conQueue = queuePDSFactory.createConnection();
            sesQue = conQueue.createSession(false, Session.AUTO_ACKNOWLEDGE);
        } catch (JMSException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }        
}
