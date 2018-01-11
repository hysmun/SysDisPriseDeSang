/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prisedesanggui;

import EjbPriseDeSang.EjbAnalysesRemote;
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
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import prisedesangclient.Main;

/**
 *
 * @author 'Toine
 */
public class ApplicationLaborantin extends javax.swing.JFrame implements MessageListener {
  
    @EJB
    private static EjbAnalysesRemote ejbAnalyse;
    
    private Topic top = null;
    
    private Queue queue = null;
    
    private Connection conTop = null;
    
    private Connection conQueue = null;
    
    private Session sesTop = null;
    
    private Session sesQue = null;
        
    private MessageConsumer cons = null;
    
    public ApplicationLaborantin() {
        initComponents();
             
    }
    
    public ApplicationLaborantin(AllVariables av) {
        try {        
            initComponents();
            this.conTop = av.conTop;
            this.top = av.topic;
            this.sesTop = av.sesTop;
            this.conQueue = av.conQue;
            this.sesQue = av.sesQue;
            this.queue = av.queue;
            
            cons = sesQue.createConsumer(queue);
            cons.setMessageListener(this);
        } catch (JMSException ex) {
            Logger.getLogger(ApplicationLaborantin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void onMessage(Message message)
    {
        TextMessage txt = (TextMessage)message;
        DefaultListModel listModel = new DefaultListModel();
        listModel.addElement(txt.toString());
        demandeListe.setModel(listModel);

    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        demandeListe = new javax.swing.JList<>();
        demandeLabel = new javax.swing.JLabel();
        refreshButton = new javax.swing.JButton();
        traiterButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        demandeListe.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(demandeListe);

        demandeLabel.setText("Demandes :");

        refreshButton.setText("Rafraichir");
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });

        traiterButton.setText("Traiter demande");
        traiterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                traiterButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(152, 152, 152)
                                .addComponent(refreshButton)
                                .addGap(64, 64, 64)
                                .addComponent(traiterButton))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(demandeLabel)))
                        .addGap(0, 117, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(refreshButton)
                    .addComponent(traiterButton))
                .addGap(14, 14, 14)
                .addComponent(demandeLabel)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_refreshButtonActionPerformed

    private void traiterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_traiterButtonActionPerformed
        if(demandeListe.isSelectionEmpty())
        {
            // ne rien faire
        }
        else
        {
            
        }
    }//GEN-LAST:event_traiterButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ApplicationLaborantin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ApplicationLaborantin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ApplicationLaborantin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ApplicationLaborantin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ApplicationLaborantin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel demandeLabel;
    private javax.swing.JList<String> demandeListe;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton refreshButton;
    private javax.swing.JButton traiterButton;
    // End of variables declaration//GEN-END:variables

}
