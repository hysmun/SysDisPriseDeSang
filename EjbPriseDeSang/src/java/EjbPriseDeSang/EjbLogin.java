/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjbPriseDeSang;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;

/**
 *
 * @author Morghen
 */
@Stateless
@DeclareRoles("arole")
public class EjbLogin implements EjbLoginLocal {

    @RolesAllowed("arole")
    @Override
    public String doIt(String p) {
        
        return p;
    }
}
