/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PriseDeSangLibrary;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 'Toine
 */
@Entity
@Table(name = "analyse")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Analyse.findAll", query = "SELECT a FROM Analyse a")
    , @NamedQuery(name = "Analyse.findByIdAnalyse", query = "SELECT a FROM Analyse a WHERE a.idAnalyse = :idAnalyse")
    , @NamedQuery(name = "Analyse.findByItem", query = "SELECT a FROM Analyse a WHERE a.item = :item")
    , @NamedQuery(name = "Analyse.findByValeur", query = "SELECT a FROM Analyse a WHERE a.valeur = :valeur")})
public class Analyse implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idAnalyse")
    private Integer idAnalyse;
    @Size(max = 255)
    @Column(name = "Item")
    private String item;
    @Size(max = 255)
    @Column(name = "Valeur")
    private String valeur;

    public Analyse() {
    }

    public Analyse(Integer idAnalyse) {
        this.idAnalyse = idAnalyse;
    }
    
    public Analyse(Integer idAnalyse, String item, String Valeur) {
        this.idAnalyse = idAnalyse;
        this.item = item;
        this.valeur = Valeur;
    }

    public Integer getIdAnalyse() {
        return idAnalyse;
    }

    public void setIdAnalyse(Integer idAnalyse) {
        this.idAnalyse = idAnalyse;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getValeur() {
        return valeur;
    }

    public void setValeur(String valeur) {
        this.valeur = valeur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAnalyse != null ? idAnalyse.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Analyse)) {
            return false;
        }
        Analyse other = (Analyse) object;
        if ((this.idAnalyse == null && other.idAnalyse != null) || (this.idAnalyse != null && !this.idAnalyse.equals(other.idAnalyse))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PriseDeSangLibrary.Analyse[ idAnalyse=" + idAnalyse + " ]";
    }
    
}
