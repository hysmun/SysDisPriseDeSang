/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import PriseDeSangLibrary.Analyse;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

/**
 *
 * @author 'Toine
 */
@WebService(serviceName = "WSResultat")
@Stateless()
public class WSResultat {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getAnalyse")
    public Analyse getAnalyse(@WebParam(name = "idAnalyse") int idAnalyse) {
        //TODO write your implementation code here:
        return null;
    }
}
