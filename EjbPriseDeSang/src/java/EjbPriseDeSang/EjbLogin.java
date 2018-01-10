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
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

/**
 *
 * @author Morghen
 */
@Stateless
@DeclareRoles({"medecin","laborantin"})
public class EjbLogin implements EjbLoginLocal {
    
    @Resource SessionContext ctx;
    @RolesAllowed({"medecin","laborantin"})
    @Override
    public String doIt(String p) {
        
        StringBuilder sb = new StringBuilder();
        
        if(ctx.isCallerInRole("medecin")) {
            Principal medecin = ctx.getCallerPrincipal();
            
            sb.append("medecin : "+ medecin.getName());
            return sb.toString();
        }
        else
        {
            Principal laborantin = ctx.getCallerPrincipal();
            
            sb.append("laborantin : " + laborantin.getName());
            return sb.toString();
        }
    }

    @Override
    public String saySomething() {
        return "on est en local";
    }
}
