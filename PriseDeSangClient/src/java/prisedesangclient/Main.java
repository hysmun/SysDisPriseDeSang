/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prisedesangclient;

import EjbPriseDeSang.EjbLoginRemoteRemote;
import Utilities.AllVariables;
import javax.ejb.EJB;
import prisedesanggui.ApplicationLaborantin;
import prisedesanggui.ApplicationMedecin;
import static test.testClient.ejbLogin;




public class Main {
    
    @EJB
    public static EjbLoginRemoteRemote ejbLogin;
    
    public static AllVariables ar;
    
    public static void main(String[] args) {
        
        ar = new AllVariables();
        ejbLogin.connect();
        ApplicationMedecin appMed = new ApplicationMedecin(ar);
        appMed.setVisible(true);

        ApplicationLaborantin appLab = new ApplicationLaborantin(ar);
        appLab.setVisible(true);
    }
     
}
