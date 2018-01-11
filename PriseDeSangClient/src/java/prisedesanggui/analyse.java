/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prisedesanggui;

import EjbPriseDeSang.EjbAnalyses;
import EjbPriseDeSang.EjbAnalysesRemote;
import EjbPriseDeSang.EjbPatientRemote;
import PriseDeSangLibrary.Analyse;
import PriseDeSangLibrary.Demande;
import PriseDeSangLibrary.Medecin;
import PriseDeSangLibrary.Patient;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;
import javax.ejb.EJB;
import javax.jms.Connection;
import javax.jms.Queue;
import javax.jms.Session;
import javax.naming.InitialContext;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Morghen
 */
public class analyse extends javax.swing.JFrame {

    
    @EJB
    private static EjbPatientRemote ejbPatient;
    
    @EJB
    private static EjbAnalysesRemote ejbAnalyse;
    
    private int refMed;
    
    private Session ses;
    
    private Connection con;
    
    private Queue que;
    
    public analyse() {
        initComponents();
    }
    
    public analyse(int refMedecin) {
        initComponents();
        try {
            InitialContext ctx = new InitialContext();
            ejbPatient = (EjbPatientRemote) ctx.lookup("java:global/EAPriseDeSang/EjbPriseDeSang/EjbPatient!EjbPriseDeSang.EjbPatientRemote");
        }
        catch(Exception ex)
        {
            System.out.println("Exception caught : " + ex);
        } 
        refMed = refMedecin;
        ArrayList<Patient> ar = new ArrayList(ejbPatient.getPatientList());
        DefaultComboBoxModel bobox = new DefaultComboBoxModel();
        for(int i = 0;i<ar.size();i++)
        {
            bobox.addElement(ar.get(i).getIdPatient() + ":" + ar.get(i).getNom() + " " + ar.get(i).getPrenom());
        }
        patientBox.setModel(bobox);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        patientBox = new javax.swing.JComboBox<>();
        patientLabel = new javax.swing.JLabel();
        OKButton = new javax.swing.JButton();
        CancelButton = new javax.swing.JButton();
        leuco = new javax.swing.JCheckBox();
        hematie = new javax.swing.JCheckBox();
        hemoglo = new javax.swing.JCheckBox();
        hemato = new javax.swing.JCheckBox();
        vgm = new javax.swing.JCheckBox();
        ccmh = new javax.swing.JCheckBox();
        tcmm = new javax.swing.JCheckBox();
        rdw = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Prescrire une analyse");

        patientBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        patientLabel.setText("Patient :");

        OKButton.setText("OK");
        OKButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OKButtonActionPerformed(evt);
            }
        });

        CancelButton.setText("Annuler");
        CancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelButtonActionPerformed(evt);
            }
        });

        leuco.setText("Leucocytes");

        hematie.setText("Hématies");

        hemoglo.setText("Hémoglobine");

        hemato.setText("Hématocrite");

        vgm.setText("VGM");

        ccmh.setText("CCMH");

        tcmm.setText("TCMM");

        rdw.setText("RDW");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(133, 133, 133)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(hemoglo)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(hemato)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(patientLabel)
                                    .addGap(37, 37, 37))
                                .addComponent(OKButton, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(hematie)
                            .addComponent(leuco))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(patientBox, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CancelButton)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(vgm)
                                .addComponent(ccmh)
                                .addComponent(tcmm)
                                .addComponent(rdw)))))
                .addContainerGap(124, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(patientLabel)
                    .addComponent(patientBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(leuco)
                    .addComponent(vgm))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hematie)
                    .addComponent(ccmh))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hemoglo)
                    .addComponent(tcmm))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hemato)
                    .addComponent(rdw))
                .addGap(75, 75, 75)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CancelButton)
                    .addComponent(OKButton))
                .addContainerGap(93, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OKButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OKButtonActionPerformed
        // Encodage des données sur le patient dans la BDD
        try {
            InitialContext ctx = new InitialContext();
            ejbAnalyse = (EjbAnalysesRemote) ctx.lookup("java:global/EAPriseDeSang/EjbPriseDeSang/EjbAnalyses!EjbPriseDeSang.EjbAnalysesRemote");
        }
        catch(Exception ex){
            System.out.println("Exception caught : " + ex);
        } 
        // Generation du numero de réference ( = id demande )
        int idAnalyse = ejbAnalyse.nextIdDemande();
        Demande demande = new Demande(idAnalyse,new Date(),(short)0);
        Medecin med = ejbPatient.getMedecin(refMed);
        demande.setRefMedecin(med);
        int refPat = Tokenize(patientBox.getSelectedItem().toString());
        Patient pat = ejbPatient.getPatient(refPat);
        demande.setRefPatient(pat);
        ejbAnalyse.addDemande(demande);
        // Poster message sur la queue
        ejbAnalyse.sendMessage("blabla", ses, con, que);
    }//GEN-LAST:event_OKButtonActionPerformed

    private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_CancelButtonActionPerformed

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
            java.util.logging.Logger.getLogger(analyse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(analyse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(analyse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(analyse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new analyse().setVisible(true);
            }
        });
    }
    
    public int Tokenize(String st)
    {
        String val;
        StringTokenizer str = new StringTokenizer(st,":");
        val = str.nextToken();
        return Integer.parseInt(val);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelButton;
    private javax.swing.JButton OKButton;
    private javax.swing.JCheckBox ccmh;
    private javax.swing.JCheckBox hematie;
    private javax.swing.JCheckBox hemato;
    private javax.swing.JCheckBox hemoglo;
    private javax.swing.JCheckBox leuco;
    private javax.swing.JComboBox<String> patientBox;
    private javax.swing.JLabel patientLabel;
    private javax.swing.JCheckBox rdw;
    private javax.swing.JCheckBox tcmm;
    private javax.swing.JCheckBox vgm;
    // End of variables declaration//GEN-END:variables
}
