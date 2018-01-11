/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PriseDeSangLibrary;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 'Toine
 */
@Entity
@Table(name = "demande")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Demande.findAll", query = "SELECT d FROM Demande d")
    , @NamedQuery(name = "Demande.findByIdDemande", query = "SELECT d FROM Demande d WHERE d.idDemande = :idDemande")
    , @NamedQuery(name = "Demande.findByDateHeureDemande", query = "SELECT d FROM Demande d WHERE d.dateHeureDemande = :dateHeureDemande")
    , @NamedQuery(name = "Demande.findByUrgent", query = "SELECT d FROM Demande d WHERE d.urgent = :urgent")})
public class Demande implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idDemande")
    private Integer idDemande;
    @Column(name = "DateHeureDemande")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateHeureDemande;
    @Column(name = "Urgent")
    private Short urgent;
    @JoinColumn(name = "RefMedecin", referencedColumnName = "idMedecin")
    @ManyToOne
    private Medecin refMedecin;
    @JoinColumn(name = "RefPatient", referencedColumnName = "idPatient")
    @ManyToOne
    private Patient refPatient;

    public Demande() {
    }

    public Demande(Integer idDemande) {
        this.idDemande = idDemande;
    }

    public Demande(Integer idDemande, Date dateHeureDemande, Short urgent, Medecin refMedecin, Patient refPatient) {
        this.idDemande = idDemande;
        this.dateHeureDemande = dateHeureDemande;
        this.urgent = urgent;
        this.refMedecin = refMedecin;
        this.refPatient = refPatient;
    }

    public Demande(Integer idDemande, Date dateHeureDemande, Short urgent) {
        this.idDemande = idDemande;
        this.dateHeureDemande = dateHeureDemande;
        this.urgent = urgent;
    }
    
    

    public Integer getIdDemande() {
        return idDemande;
    }

    public void setIdDemande(Integer idDemande) {
        this.idDemande = idDemande;
    }

    public Date getDateHeureDemande() {
        return dateHeureDemande;
    }

    public void setDateHeureDemande(Date dateHeureDemande) {
        this.dateHeureDemande = dateHeureDemande;
    }

    public Short getUrgent() {
        return urgent;
    }

    public void setUrgent(Short urgent) {
        this.urgent = urgent;
    }

    public Medecin getRefMedecin() {
        return refMedecin;
    }

    public void setRefMedecin(Medecin refMedecin) {
        this.refMedecin = refMedecin;
    }

    public Patient getRefPatient() {
        return refPatient;
    }

    public void setRefPatient(Patient refPatient) {
        this.refPatient = refPatient;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDemande != null ? idDemande.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Demande)) {
            return false;
        }
        Demande other = (Demande) object;
        if ((this.idDemande == null && other.idDemande != null) || (this.idDemande != null && !this.idDemande.equals(other.idDemande))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PriseDeSangLibrary.Demande[ idDemande=" + idDemande + " ]";
    }
    
}
