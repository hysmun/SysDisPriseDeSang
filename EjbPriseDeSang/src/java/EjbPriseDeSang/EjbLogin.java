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
@DeclareRoles("arole")
public class EjbLogin implements EjbLoginLocal {
    
    @Resource SessionContext ctx;
    @RolesAllowed("arole")
    @Override
    public String doIt(String p) {
        
        StringBuilder sb = new StringBuilder();
        
        if(ctx.isCallerInRole("arole")) {
            Principal callerPrincipal = ctx.getCallerPrincipal();
            if(callerPrincipal.getName().equals("georges"))
                sb.append(" task done");
            return sb.toString();
        }
        return null;
    }
}
