/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBaseLibrary;

import java.sql.*;
import static java.sql.ResultSet.*;
import PriseDeSangLibrary.*;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author 'Toine
 */
public class DBUtilities {
    public static int SQL = 2;
    
    private int typeConnection;
    private String nameConnection;
    private String login;
    private String motdepasse;
    private Connection con;
    private Statement instruc;

    public DBUtilities(String plogin, String pmotdepasse, String ip, int port) throws ClassNotFoundException, Exception {
        String tmpCon;
        String nomDB = "bdprisedesang";
        this.typeConnection = SQL;
        
        nameConnection = "org.gjt.mm.mysql.Driver";
        //nameConnection = "com.mysql.jdbc.Driver";
        
        Class.forName(nameConnection);
        login = plogin;
        motdepasse = pmotdepasse;
        
        tmpCon = "jdbc:" + "mysql://"+ip+":"+port+"/"+nomDB;
        con = DriverManager.getConnection(tmpCon, login, motdepasse);
        instruc =  con.createStatement(TYPE_SCROLL_INSENSITIVE, CONCUR_READ_ONLY);
    }
    
    public ResultSet query(String pquery) throws SQLException
    {
        return instruc.executeQuery(pquery);
    }
    
    public int update(String pupdate) throws SQLException
    {
        return instruc.executeUpdate(pupdate);
    }
    
    public boolean execute(String pupdate) throws SQLException
    {
        return instruc.execute(pupdate);
    }
    
    public <T> List getList(Class c){
        List<T> list = new LinkedList<>();
            
        try {
            int number = getNbr(c);
            int j=1;
            ResultSet rs;
            String name = c.getSimpleName().toLowerCase();
            rs = query("SELECT * FROM "+name);
            rs.next();
            for(int i=0; i<number; i++){
                T tmp = (T) c.newInstance();
                j=1;
                for(Field f : tmp.getClass().getFields()){
                    //System.out.println("t"+f.get(tmp));
                    f.set(tmp, rs.getObject(j));
                    j++;
                }
                rs.next();
                list.add(tmp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBUtilities.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(DBUtilities.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(DBUtilities.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public <T> int getNbr(Class c){
        int nbr=0;
        String name = c.getSimpleName().toLowerCase();
        System.out.println(name);
        ResultSet rs;
        try {
            rs = query("SELECT count(*) FROM "+name);
            rs.next();
            nbr = rs.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(DBUtilities.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nbr;
    }
    
    //<editor-fold defaultstate="collapsed" desc="Getter">
    public String getNameConnection() {
        return nameConnection;
    }
    
    public int getTypeConnection() {
        return typeConnection;
    }
    
    public String getLogin() {
        return login;
    }
    
    public String getMotdepasse() {
        return motdepasse;
    }
    
    public Connection getCon() {
        return con;
    }
//</editor-fold>
}
