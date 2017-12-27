/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PriseDeSangLibrary;

import java.util.Date;

/**
 *
 * @author 'Toine
 */
public class Demande {
    
    private int Id;
    
    private int RefPatient;

    private int RefMedecin;

    private Date DateHeureDemande;

    private boolean Urgent;

    public Demande() {
    }

    public Demande(int Id, int RefPatient, int RefMedecin, Date DateHeureDemande, boolean Urgent) {
        this.Id = Id;
        this.RefPatient = RefPatient;
        this.RefMedecin = RefMedecin;
        this.DateHeureDemande = DateHeureDemande;
        this.Urgent = Urgent;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Demande other = (Demande) obj;
        if (this.Id != other.Id) {
            return false;
        }
        return true;
    }
    
    //<editor-fold defaultstate="collapsed" desc="getter et setter">
    /**
     * Get the value of Urgent
     *
     * @return the value of Urgent
     */
    public boolean isUrgent() {
        return Urgent;
    }

    /**
     * Set the value of Urgent
     *
     * @param Urgent new value of Urgent
     */
    public void setUrgent(boolean Urgent) {
        this.Urgent = Urgent;
    }

    /**
     * Get the value of DateHeureDemande
     *
     * @return the value of DateHeureDemande
     */
    public Date getDateHeureDemande() {
        return DateHeureDemande;
    }

    /**
     * Set the value of DateHeureDemande
     *
     * @param DateHeureDemande new value of DateHeureDemande
     */
    public void setDateHeureDemande(Date DateHeureDemande) {
        this.DateHeureDemande = DateHeureDemande;
    }

    /**
     * Get the value of RefMedecin
     *
     * @return the value of RefMedecin
     */
    public int getRefMedecin() {
        return RefMedecin;
    }

    /**
     * Set the value of RefMedecin
     *
     * @param RefMedecin new value of RefMedecin
     */
    public void setRefMedecin(int RefMedecin) {
        this.RefMedecin = RefMedecin;
    }

    /**
     * Get the value of RefPatient
     *
     * @return the value of RefPatient
     */
    public int getRefPatient() {
        return RefPatient;
    }

    /**
     * Set the value of RefPatient
     *
     * @param RefPatient new value of RefPatient
     */
    public void setRefPatient(int RefPatient) {
        this.RefPatient = RefPatient;
    }

    /**
     * Get the value of id
     *
     * @return the value of id
     */
    public int getId() {
        return Id;
    }

    /**
     * Set the value of id
     *
     * @param id new value of id
     */
    public void setId(int id) {
        this.Id = id;
    }
    //</editor-fold>
}
