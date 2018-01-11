/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prisedesangclient;

import Utilities.AllVariables;
import prisedesanggui.ApplicationMedecin;




public class Main {
    
    public static AllVariables ar;
    
    public static void main(String[] args) {
        
        ar = new AllVariables();
        
        ApplicationMedecin appMed = new ApplicationMedecin(ar);
        appMed.setVisible(true);


    }
     
}
