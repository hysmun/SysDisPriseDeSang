/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjbPriseDeSang;

import java.security.Principal;
import javax.annotation.Resource;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

/**
 *
 * @author Morghen
 */
@Stateless
@DeclareRoles({"medecin","laborantin"})
public class EjbLoginRemote implements EjbLoginRemoteRemote {

    @Resource SessionContext ctx;
    @RolesAllowed({"medecin","laborantin"})
    @Override
    public void doIt(String p) {
                
        if(ctx.isCallerInRole("medecin")) {
            Principal medecin = ctx.getCallerPrincipal();
            //Connexion BDD et test si existant
            
            
            //Si non existant on quitte
            
            System.out.println("medecin : " + medecin.getName());

        }
        else
        {
            Principal laborantin = ctx.getCallerPrincipal();
            
            System.out.println("laborantin : " + laborantin.getName());

        }
    }
}
