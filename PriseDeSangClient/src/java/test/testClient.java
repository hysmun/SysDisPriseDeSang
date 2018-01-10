/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import EjbPriseDeSang.EjbLoginRemoteRemote;
import javax.ejb.EJB;

/**
 *
 * @author Morghen
 */
public class testClient {

    @EJB
    private static EjbLoginRemoteRemote ejbLoginRemote;
  
    public static void main(String[] args) {
        
        ejbLoginRemote.doIt("coucou"); 
    }
    
}
