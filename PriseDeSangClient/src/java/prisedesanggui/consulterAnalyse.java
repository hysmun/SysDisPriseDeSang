/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prisedesanggui;

import EjbPriseDeSang.EjbAnalysesRemote;
import PriseDeSangLibrary.Analyse;
import Utilities.AllVariables;
import Utilities.MyListModel;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Morghen
 */
public class consulterAnalyse extends javax.swing.JFrame implements MessageListener{

    @EJB
    public EjbAnalysesRemote ejbAnalysesRemote;
    
    private Connection conTop = null;
    private Session sestop = null;
    private MessageConsumer cons = null;
    
    public AllVariables av;
    
    public LinkedList<Analyse> analyseUrgentList;
    
    public consulterAnalyse() {}
    public consulterAnalyse( AllVariables tav) {
        av=tav;
        initComponents();
        try {
            InitialContext ctx = new InitialContext();
            ejbAnalysesRemote = (EjbAnalysesRemote) ctx.lookup("java:global/EAPriseDeSang/EjbPriseDeSang/EjbAnalyses!EjbPriseDeSang.EjbAnalysesRemote");
        } catch (NamingException ex) {
            Logger.getLogger(consulterAnalyse.class.getName()).log(Level.SEVERE, null, ex);
        }
        List<Analyse> la = ejbAnalysesRemote.getAnalyseDone();
        nonprioListe.setModel(new MyListModel(la));
        try {
            cons = av.sesTop.createConsumer(av.topic);
            cons.setMessageListener(this);
        } catch (JMSException ex) {
            Logger.getLogger(consulterAnalyse.class.getName()).log(Level.SEVERE, null, ex);
        }
        analyseUrgentList = new LinkedList<>();
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
        urgentListe = new javax.swing.JList<>();
        urgentLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        nonprioListe = new javax.swing.JList<>();
        nonprioLabel = new javax.swing.JLabel();
        refreshButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulter les analyses");

        urgentListe.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(urgentListe);

        urgentLabel.setText("Urgent :");

        nonprioListe.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(nonprioListe);

        nonprioLabel.setText("Priorite normale :");

        refreshButton.setText("Rafraichir");
        refreshButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                refreshButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nonprioLabel)
                        .addGap(138, 138, 138)
                        .addComponent(refreshButton))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(urgentLabel)
                        .addGap(0, 389, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(refreshButton)
                    .addComponent(nonprioLabel)
                    .addComponent(urgentLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void refreshButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshButtonMouseClicked
        // TODO add your handling code here:
        try {
            InitialContext ctx = new InitialContext();
            ejbAnalysesRemote = (EjbAnalysesRemote) ctx.lookup("java:global/EAPriseDeSang/EjbPriseDeSang/EjbAnalyses!EjbPriseDeSang.EjbAnalysesRemote");
        } catch (NamingException ex) {
            Logger.getLogger(consulterAnalyse.class.getName()).log(Level.SEVERE, null, ex);
        }
        List<Analyse> la = ejbAnalysesRemote.getAnalyseDone();
        nonprioListe.setModel(new MyListModel(la));
    }//GEN-LAST:event_refreshButtonMouseClicked

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
            java.util.logging.Logger.getLogger(consulterAnalyse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(consulterAnalyse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(consulterAnalyse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(consulterAnalyse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new consulterAnalyse().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel nonprioLabel;
    private javax.swing.JList<String> nonprioListe;
    private javax.swing.JButton refreshButton;
    private javax.swing.JLabel urgentLabel;
    private javax.swing.JList<String> urgentListe;
    // End of variables declaration//GEN-END:variables

    @Override
    public void onMessage(Message message) {
        try {
            int idAnalyse;
            TextMessage txt = (TextMessage) message;
            if(!txt.getBooleanProperty("urgent"))
                return;
            idAnalyse = Integer.parseInt(txt.getText());
            try {
                InitialContext ctx = new InitialContext();
                ejbAnalysesRemote = (EjbAnalysesRemote) ctx.lookup("java:global/EAPriseDeSang/EjbPriseDeSang/EjbAnalyses!EjbPriseDeSang.EjbAnalysesRemote");
            } catch (NamingException ex) {
                Logger.getLogger(consulterAnalyse.class.getName()).log(Level.SEVERE, null, ex);
            }
            Analyse a = ejbAnalysesRemote.getAnalyse(idAnalyse);
            analyseUrgentList.add(a);
            urgentListe.setModel(new MyListModel(analyseUrgentList));
        } catch (JMSException ex) {
            Logger.getLogger(consulterAnalyse.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
