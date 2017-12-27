/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;
import DataBaseLibrary.*;
import PriseDeSangLibrary.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author 'Toine
 */
public class Main {
    
    public static void main(String[] args) {
        try {
            DBUtilities dbuti = new DBUtilities("root", "toor", "127.0.0.1", 5500);
            Medecin[] listMed = dbuti.getMedecin();
            
            for(Medecin m : listMed){
                System.out.println(m.toString());
            }
            
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
