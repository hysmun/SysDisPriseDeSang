/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjbPriseDeSang;

import DataBaseLibrary.DBUtilities;
import PriseDeSangLibrary.Medecin;
import java.security.Principal;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    public DBUtilities db = new DBUtilities();
    
    @Resource SessionContext ctx;
    @RolesAllowed({"medecin","laborantin"})
    @Override
    public int connect(){
                
        
        if(ctx.isCallerInRole("medecin")) {
            System.out.println("medecin");
            Principal med = ctx.getCallerPrincipal();
            //Connexion BDD et test si existant
            try{
                Medecin m = db.getByLogin( med.getName());
                if(m == null){
                    return -404;
                }
                else{
                    return 1;
                }
            } catch(Exception ex){
                Logger.getLogger(EjbLoginRemote.class.getName()).log(Level.SEVERE, null, ex);
                return -101;
            }
        }
        if(ctx.isCallerInRole("laborantin")){
            System.out.println("laborantin");
            return 2;
        }
        return -500;
    }
}
