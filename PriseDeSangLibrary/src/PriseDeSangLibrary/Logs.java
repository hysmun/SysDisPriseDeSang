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
@Table(name = "logs")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Logs.findAll", query = "SELECT l FROM Logs l")
    , @NamedQuery(name = "Logs.findByIdlogs", query = "SELECT l FROM Logs l WHERE l.idlogs = :idlogs")
    , @NamedQuery(name = "Logs.findByInfos", query = "SELECT l FROM Logs l WHERE l.infos = :infos")})
public class Logs implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idlogs")
    private Integer idlogs;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Infos")
    private String infos;

    public Logs() {
    }

    public Logs(Integer idlogs) {
        this.idlogs = idlogs;
    }

    public Logs(Integer idlogs, String infos) {
        this.idlogs = idlogs;
        this.infos = infos;
    }

    public Integer getIdlogs() {
        return idlogs;
    }

    public void setIdlogs(Integer idlogs) {
        this.idlogs = idlogs;
    }

    public String getInfos() {
        return infos;
    }

    public void setInfos(String infos) {
        this.infos = infos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idlogs != null ? idlogs.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Logs)) {
            return false;
        }
        Logs other = (Logs) object;
        if ((this.idlogs == null && other.idlogs != null) || (this.idlogs != null && !this.idlogs.equals(other.idlogs))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PriseDeSangLibrary.Logs[ idlogs=" + idlogs + " ]";
    }
    
}
