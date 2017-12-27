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
public class Analyse {
    
    private int Id;
    
    private String Item;
    
    private String Valeur;

    public Analyse(int Id, String Item, String Valeur) {
        this.Id = Id;
        this.Item = Item;
        this.Valeur = Valeur;
    }

    public Analyse() {
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Analyse other = (Analyse) obj;
        if (this.Id != other.Id) {
            return false;
        }
        return true;
    }
    
    //<editor-fold defaultstate="collapsed" desc="getter et setter">
    /**
     * Get the value of Item
     *
     * @return the value of Item
     */
    public String getItem() {
        return Item;
    }

    /**
     * Set the value of Item
     *
     * @param Item new value of Item
     */
    public void setItem(String Item) {
        this.Item = Item;
    }

    /**
     * Get the value of Valeur
     *
     * @return the value of Valeur
     */
    public String getValeur() {
        return Valeur;
    }

    /**
     * Set the value of Valeur
     *
     * @param Valeur new value of Valeur
     */
    public void setValeur(String Valeur) {
        this.Valeur = Valeur;
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
