/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PriseDeSangLibrary;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 'Toine
 */
@Entity
@Table(name = "medecin")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medecin.findAll", query = "SELECT m FROM Medecin m")
    , @NamedQuery(name = "Medecin.findByIdMedecin", query = "SELECT m FROM Medecin m WHERE m.idMedecin = :idMedecin")
    , @NamedQuery(name = "Medecin.findByLogin", query = "SELECT m FROM Medecin m WHERE m.login = :login")
    , @NamedQuery(name = "Medecin.findByNom", query = "SELECT m FROM Medecin m WHERE m.nom = :nom")
    , @NamedQuery(name = "Medecin.findByPrenom", query = "SELECT m FROM Medecin m WHERE m.prenom = :prenom")})
public class Medecin implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idMedecin")
    private Integer idMedecin;
    @Size(max = 255)
    @Column(name = "Login")
    private String login;
    @Size(max = 255)
    @Column(name = "Nom")
    private String nom;
    @Size(max = 255)
    @Column(name = "Prenom")
    private String prenom;
    @OneToMany(mappedBy = "refMedecin")
    private Collection<Demande> demandeCollection;

    public Medecin() {
    }

    public Medecin(Integer idMedecin) {
        this.idMedecin = idMedecin;
    }

    public Medecin(Integer idMedecin, String login, String nom, String prenom) {
        this.idMedecin = idMedecin;
        this.login = login;
        this.nom = nom;
        this.prenom = prenom;
    }

    public Medecin(String login, String nom, String prenom) {
        this.login = login;
        this.nom = nom;
        this.prenom = prenom;
    }

    public Integer getIdMedecin() {
        return idMedecin;
    }

    public void setIdMedecin(Integer idMedecin) {
        this.idMedecin = idMedecin;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @XmlTransient
    public Collection<Demande> getDemandeCollection() {
        return demandeCollection;
    }

    public void setDemandeCollection(Collection<Demande> demandeCollection) {
        this.demandeCollection = demandeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMedecin != null ? idMedecin.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medecin)) {
            return false;
        }
        Medecin other = (Medecin) object;
        if ((this.idMedecin == null && other.idMedecin != null) || (this.idMedecin != null && !this.idMedecin.equals(other.idMedecin))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PriseDeSangLibrary.Medecin[ idMedecin=" + idMedecin + " ]";
    }
    
}
