/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBaseLibrary;

import java.sql.*;
import static java.sql.ResultSet.*;
import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
/**
 *
 * @author 'Toine
 */
public class DBUtilities {

    public static EntityManagerFactory emf;
    public static EntityManager em;
    
    public DBUtilities() {
        emf = Persistence.createEntityManagerFactory("PriseDeSangLibraryPU");
        em = emf.createEntityManager();
        em.getTransaction().begin();
    }
    
    public void commit(){
        em.getTransaction().commit();
    }
    
    public boolean end(){
        em.close();
        return true;
    }
    
    public <T> List<T> getList(Class c){
        List<T> list =null;
        try {
            int number = getNbr(c);
            int j=1;
            ResultSet rs;
            String name = c.getSimpleName();
            list = em.createQuery("SELECT x FROM "+name+" as x").getResultList();
        } catch(Exception e){
            throw e;
        }
        return list;
    }
    
    public <T> int getNbr(Class c){
        int nbr=0;
        String name = c.getSimpleName();
        ResultSet rs;
        try {
            Long tmp = ((Long)em.createQuery("SELECT MAX(x.id"+name+") FROM "+name+" as x").getResultList().get(0));
            nbr = tmp.intValue();
        } catch (Exception e) {
            throw e;
        }
        return nbr;
    }
    
    public <T> int getNextId(Class c){
        int nbr=0;
        String name = c.getSimpleName();
        ResultSet rs;
        try {
            Long tmp = ((Long)em.createQuery("SELECT MAX(x.id"+name+") FROM "+name+" as x").getResultList().get(0));
            nbr = tmp.intValue();
        } catch (Exception e) {
            throw e;
        }
        return nbr+1;
    }
}
