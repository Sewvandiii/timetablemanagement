/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thili
 */
public class dbConnect {

    private static Connection con;
    private static dbConnect dbc;

    private dbConnect() throws ClassNotFoundException, SQLException {
        //DB Driver
        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        
        String URL = "jdbc:derby:mydatabs;create=true";
        con = DriverManager.getConnection(URL);
        Statement stmt = con.createStatement();
        
        
    }
    
    public static dbConnect getDatabaseConnection() throws ClassNotFoundException, SQLException{
        
        if(dbc == null ){
            dbc = new dbConnect();
        }
        return dbc;
    }
    
    public static Connection getConnection(){
        return con;
    }
    
}
