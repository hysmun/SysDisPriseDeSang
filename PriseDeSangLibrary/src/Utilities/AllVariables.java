/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.Topic;

/**
 *
 * @author Morghen
 */
public class AllVariables {
    
    public Connection conTop;
    public Connection conQue;
    public Session sesTop;
    public Session sesQue;
    
    @Resource(mappedName = "jms/QueuePDS")
    public Queue queue;

    @Resource(mappedName = "jms/QueuePDSFactory")
    public ConnectionFactory queuePDSFactory;

    @Resource(mappedName = "jms/TopicPDS")
    public Topic topic;

    @Resource(mappedName = "jms/TopicPDSFactory")
    public ConnectionFactory topicPDSFactory;
    
    public AllVariables() {
        
        try {
            conTop = topicPDSFactory.createConnection();
            sesTop = conTop.createSession(false, Session.AUTO_ACKNOWLEDGE);
            conQue = queuePDSFactory.createConnection();
            sesQue = conQue.createSession(false, Session.AUTO_ACKNOWLEDGE);
        } catch (JMSException ex) {
            Logger.getLogger(AllVariables.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
