/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prisedesanggui;

import EjbPriseDeSang.EjbPatient;
import EjbPriseDeSang.EjbPatientRemote;
import PriseDeSangLibrary.Patient;
import PriseDeSangLibrary.PriseDeSangToString;
import Utilities.MyListModel;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

/**
 *
 * @author 'Toine
 */
public class GestionPatient extends javax.swing.JFrame {

    @EJB
    private static EjbPatientRemote ejbPatient;
    
    public List<Patient> lp;
    
    /**
     * Creates new form GestionPatient
     */
    public GestionPatient() {
        initComponents();
        this.setLocationRelativeTo(null);
        try {
            InitialContext ctx = new InitialContext();
            ejbPatient = (EjbPatientRemote) ctx.lookup("java:global/EAPriseDeSang/EjbPriseDeSang/EjbPatient!EjbPriseDeSang.EjbPatientRemote");
        }
        catch(Exception ex)
        {
            System.out.println("Exception caught : " + ex);
        } 
        lp = ejbPatient.getPatientList();
        patientJList.setModel(new MyListModel(lp));
        
        
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        refreshPatientButton = new javax.swing.JButton();
        addPatientButton = new javax.swing.JButton();
        modifPatientButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        patientJList = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        refreshPatientButton.setText("Rafraichir");
        refreshPatientButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                refreshPatientButtonMouseClicked(evt);
            }
        });

        addPatientButton.setText("Ajout Patient");
        addPatientButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addPatientButtonMouseClicked(evt);
            }
        });

        modifPatientButton.setText("Modif Patient");
        modifPatientButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                modifPatientButtonMouseClicked(evt);
            }
        });

        patientJList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(patientJList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(refreshPatientButton)
                    .addComponent(addPatientButton)
                    .addComponent(modifPatientButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(refreshPatientButton)
                .addGap(18, 18, 18)
                .addComponent(addPatientButton)
                .addGap(28, 28, 28)
                .addComponent(modifPatientButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void refreshPatientButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshPatientButtonMouseClicked
        // TODO add your handling code here:
        lp = ejbPatient.getPatientList();
        patientJList.setModel(new MyListModel(lp));
    }//GEN-LAST:event_refreshPatientButtonMouseClicked

    private void addPatientButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addPatientButtonMouseClicked
        // TODO add your handling code here:
        addModifyPatient adp = new addModifyPatient(this, true, addModifyPatient.AJOUT);
        adp.setVisible(true);
    }//GEN-LAST:event_addPatientButtonMouseClicked

    private void modifPatientButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modifPatientButtonMouseClicked
        // TODO add your handling code here:
        if(patientJList.getSelectedIndex() > -1)
        {
            Patient p = lp.get(patientJList.getSelectedIndex());
            addModifyPatient adp = new addModifyPatient(this, true, 0);
            adp.setVisible(true);
        }
    }//GEN-LAST:event_modifPatientButtonMouseClicked

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
            java.util.logging.Logger.getLogger(GestionPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionPatient().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addPatientButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton modifPatientButton;
    private javax.swing.JList<String> patientJList;
    private javax.swing.JButton refreshPatientButton;
    // End of variables declaration//GEN-END:variables
}
