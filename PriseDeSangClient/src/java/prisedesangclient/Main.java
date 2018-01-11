/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prisedesangclient;

import EjbPriseDeSang.EjbLoginRemoteRemote;
import Utilities.AllVariables;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import prisedesanggui.ApplicationLaborantin;
import prisedesanggui.ApplicationMedecin;

public class Main {
    
    @EJB
    public static EjbLoginRemoteRemote ejbLogin;
    
    public static AllVariables ar;
    
    public static int nbrFen = 2;
    
    public static void main(String[] args) {
        
        ar = new AllVariables();
        /*try {
            InitialContext ctx = new InitialContext();
            ejbLogin = (EjbLoginRemoteRemote) ctx.lookup("java:global/EAPriseDeSang/EjbPriseDeSang/EjbLoginRemote!EjbPriseDeSang.EjbLoginRemoteRemote");
        } catch (NamingException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        for(int i=0; i< nbrFen; i++){
            
            int ret = ejbLogin.connect();
            switch(ret){
                case 1:
                    ApplicationMedecin appMed = new ApplicationMedecin(ar);
                    appMed.setVisible(true);
                    break;
                case 2:
                    ApplicationLaborantin appLab = new ApplicationLaborantin(ar);
                    appLab.setVisible(true);
                    break;
                default:
                    System.out.println("ERREUR LOGIN"+ ret);
            }
        }
    }
     
}
