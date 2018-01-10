/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjbPriseDeSang;

import javax.ejb.Remote;

/**
 *
 * @author Morghen
 */
@Remote
public interface EjbLoginRemoteRemote {
    
    public String doIt(String p);
}
