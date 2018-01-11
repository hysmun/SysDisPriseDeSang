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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
    , @NamedQuery(name = "Demande.findByIddemande", query = "SELECT d FROM Demande d WHERE d.iddemande = :idDemande")
    , @NamedQuery(name = "Demande.findByDateHeureDemande", query = "SELECT d FROM Demande d WHERE d.dateHeureDemande = :dateHeureDemande")
    , @NamedQuery(name = "Demande.findByUrgent", query = "SELECT d FROM Demande d WHERE d.urgent = :urgent")})
public class Demande implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idDemande")
    private Integer iddemande;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DateHeureDemande")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateHeureDemande;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Urgent")
    private short urgent;
    @JoinColumn(name = "RefMedecin", referencedColumnName = "idmedecin")
    @ManyToOne(optional = false)
    private Medecin refMedecin;
    @JoinColumn(name = "RefPatient", referencedColumnName = "idPatient")
    @ManyToOne(optional = false)
    private Patient refPatient;

    public Demande() {
    }

    public Demande(Integer iddemande) {
        this.iddemande = iddemande;
    }

    public Demande(Date dateHeureDemande, short urgent) {
        this.dateHeureDemande = dateHeureDemande;
        this.urgent = urgent;
    }
    
    public Demande(Integer iddemande, Date dateHeureDemande, short urgent) {
        this.iddemande = iddemande;
        this.dateHeureDemande = dateHeureDemande;
        this.urgent = urgent;
    }

    public Integer getIddemande() {
        return iddemande;
    }

    public void setIddemande(Integer iddemande) {
        this.iddemande = iddemande;
    }

    public Date getDateHeureDemande() {
        return dateHeureDemande;
    }

    public void setDateHeureDemande(Date dateHeureDemande) {
        this.dateHeureDemande = dateHeureDemande;
    }

    public short getUrgent() {
        return urgent;
    }

    public void setUrgent(short urgent) {
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
        hash += (iddemande != null ? iddemande.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Demande)) {
            return false;
        }
        Demande other = (Demande) object;
        if ((this.iddemande == null && other.iddemande != null) || (this.iddemande != null && !this.iddemande.equals(other.iddemande))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PriseDeSangLibrary.Demande[ iddemande=" + iddemande + " ]";
    }
    
}
