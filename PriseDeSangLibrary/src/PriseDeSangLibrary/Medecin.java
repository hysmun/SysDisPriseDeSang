/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PriseDeSangLibrary;

/**
 *
 * @author 'Toine
 */
public class Medecin {
    
    public int Id;

    public String Nom;

    public String Prenom;

    public String Login;

    public Medecin() {
    }
    
    public Medecin(int Id, String Nom, String Prenom, String Login) {
        this.Id = Id;
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.Login = Login;
    }

    @Override
    public String toString() {
        return "" + Id + ", " + Nom + ", " + Prenom + ", " + Login;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Medecin other = (Medecin) obj;
        if (this.Id != other.Id) {
            return false;
        }
        return true;
    }
    
    //<editor-fold defaultstate="collapsed" desc="getter et setter">
    /**
     * Get the value of Login
     *
     * @return the value of Login
     */
    public String getLogin() {
        return Login;
    }
    
    /**
     * Set the value of Login
     *
     * @param Login new value of Login
     */
    public void setLogin(String Login) {
        this.Login = Login;
    }
    
    /**
     * Get the value of Prenom
     *
     * @return the value of Prenom
     */
    public String getPrenom() {
        return Prenom;
    }
    
    /**
     * Set the value of Prenom
     *
     * @param Prenom new value of Prenom
     */
    public void setPrenom(String Prenom) {
        this.Prenom = Prenom;
    }
    
    /**
     * Get the value of Nom
     *
     * @return the value of Nom
     */
    public String getNom() {
        return Nom;
    }
    
    /**
     * Set the value of Nom
     *
     * @param Nom new value of Nom
     */
    public void setNom(String Nom) {
        this.Nom = Nom;
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
