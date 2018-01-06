/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PriseDeSangLibrary;

import java.io.Serializable;

/**
 *
 * @author 'Toine
 */
public class Logs implements Serializable{
    
    private int Id;
    
    private String Infos;

    public Logs() {
    }

    public Logs(int Id, String Infos) {
        this.Id = Id;
        this.Infos = Infos;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Logs other = (Logs) obj;
        if (this.Id != other.Id) {
            return false;
        }
        return true;
    }

    //<editor-fold defaultstate="collapsed" desc="getter et setter">
    /**
     * Get the value of Infos
     *
     * @return the value of Infos
     */
    public String getInfos() {
        return Infos;
    }

    /**
     * Set the value of Infos
     *
     * @param Infos new value of Infos
     */
    public void setInfos(String Infos) {
        this.Infos = Infos;
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
