/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBaseLibrary;

import java.sql.*;
import static java.sql.ResultSet.*;
import PriseDeSangLibrary.*;
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
    
    public Medecin[] getMedecin(){
        Medecin[] listMed = new Medecin[0];
        try {
            ResultSet rs = query("SELECT count(*) FROM medecin");
            rs.next();
            int number = rs.getInt(1);
            
            listMed = new Medecin[number];
            rs = query("SELECT * FROM medecin");
            rs.next();
            for(int i=0; i<number; i++){
                listMed[i] = new Medecin(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
                rs.next();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBUtilities.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listMed;
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
