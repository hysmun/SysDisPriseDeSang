/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import EjbPriseDeSang.EjbLoginRemoteRemote;
import EjbPriseDeSang.EjbPatientRemote;
import javax.ejb.EJB;

/**
 *
 * @author Morghen
 */
public class testClient {

    @EJB
    private static EjbPatientRemote ejbPatientRemote;
    
    @EJB
    private static EjbLoginRemoteRemote ejbLogin;
  
    public static void main(String[] args) {
        System.out.println("DEBUT");
        ejbLogin.doIt("coucou");
        ejbPatientRemote.getPatientList();
        
        System.out.println("FIN");
    }
    
}
