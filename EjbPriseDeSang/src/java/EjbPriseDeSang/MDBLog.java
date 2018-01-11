/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjbPriseDeSang;

import DataBaseLibrary.DBUtilities;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 *
 * @author Morghen
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "clientId", propertyValue = "jms/TopicPDS")
    ,
        @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/TopicPDS")
    ,
        @ActivationConfigProperty(propertyName = "subscriptionDurability", propertyValue = "Durable")
    ,
        @ActivationConfigProperty(propertyName = "subscriptionName", propertyValue = "jms/TopicPDS")
    ,
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic")
})
public class MDBLog implements MessageListener {
    
    public DBUtilities uti = new DBUtilities();
    public MDBLog() {
    }
    
    @Override
    public void onMessage(Message message) {
        try {
            TextMessage txt = (TextMessage)message;
            System.out.println("--- Message recu : " + txt.getText() + " ---");
            
            uti.logMsg(txt.getText());
        } catch (JMSException ex) {
            Logger.getLogger(MDBLog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
