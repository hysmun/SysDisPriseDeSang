/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prisedesanggui;

import EjbPriseDeSang.EjbAnalysesRemote;
import EjbPriseDeSang.EjbPatientRemote;
import PriseDeSangLibrary.Analyse;
import PriseDeSangLibrary.Demande;
import PriseDeSangLibrary.Medecin;
import PriseDeSangLibrary.Patient;
import Utilities.AllVariables;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
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
    
    private AllVariables av;
    private Connection conQ =null;
    private Session sesQ =null;
    
    private MessageProducer prodQ = null;
    
    public analyse() {
        initComponents();
    }
    
    public analyse(int refMedecin,AllVariables tav) {
        initComponents();
        av = tav;
        
        try {
            InitialContext ctx = new InitialContext();
            ejbPatient = (EjbPatientRemote) ctx.lookup("java:global/EAPriseDeSang/EjbPriseDeSang/EjbPatient!EjbPriseDeSang.EjbPatientRemote");
        }
        catch(Exception ex)
        {
            System.out.println("Exception caught : " + ex);
        } 
        refMed = refMedecin;
        List<Patient> ar = ejbPatient.getPatientList();
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

        typeBG = new javax.swing.ButtonGroup();
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
        ugentCB = new javax.swing.JCheckBox();

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

        typeBG.add(leuco);
        leuco.setText("Leucocytes");

        typeBG.add(hematie);
        hematie.setText("Hematies");

        hemoglo.setText("Hemoglobine");

        typeBG.add(hemato);
        hemato.setText("Hematocrite");

        typeBG.add(vgm);
        vgm.setText("VGM");

        typeBG.add(ccmh);
        ccmh.setText("CCMH");

        typeBG.add(tcmm);
        tcmm.setText("TCMM");

        typeBG.add(rdw);
        rdw.setText("RDW");

        ugentCB.setText("Urgent ?");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                        .addComponent(rdw))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(229, 229, 229)
                        .addComponent(ugentCB)))
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
                .addGap(18, 18, 18)
                .addComponent(ugentCB)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CancelButton)
                    .addComponent(OKButton))
                .addContainerGap(93, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void OKButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OKButtonActionPerformed
        try {                                         
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
            short urgent=0;
            if(ugentCB.isSelected())
                urgent = 1;
            Demande demande = new Demande(idAnalyse,new Date(),urgent);
            Medecin med = ejbPatient.getMedecin(refMed);
            demande.setRefMedecin(med);
            int refPat = Tokenize(patientBox.getSelectedItem().toString());
            Patient pat = ejbPatient.getPatient(refPat);
            demande.setRefPatient(pat);
            ejbAnalyse.addDemande(demande);
            String type="default";
            if(hemato.isSelected())
                type = "hemato";
            if(hemoglo.isSelected())
                type = "hemoglo";
            if(hematie.isSelected())
                type = "hematie";
            if(leuco.isSelected())
                type = "leuco";
            if(tcmm.isSelected())
                type = "tcmm";
            if(vgm.isSelected())
                type = "vgm";
            if(ccmh.isSelected())
                type = "ccmh";
            if(rdw.isSelected())
                type = "rdw";
            //ejbAnalyse.addAnalyse(new Analyse(idAnalyse,type,"NULL"), av);
            ejbAnalyse.addAnalyse(new Analyse(idAnalyse,type,"NULL"));
            if(prodQ == null)
                prodQ = av.sesQue.createProducer(av.queue);
            TextMessage tm = av.sesQue.createTextMessage();
            tm.setText(""+idAnalyse);
            prodQ.send(tm);
        }
        catch(JMSException ex){
            Logger.getLogger(analyse.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    private javax.swing.ButtonGroup typeBG;
    private javax.swing.JCheckBox ugentCB;
    private javax.swing.JCheckBox vgm;
    // End of variables declaration//GEN-END:variables
}
