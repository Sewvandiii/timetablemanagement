/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WorkingHours;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import util.dbConnect;

/**
 *
 * @author Sewwandi
 */
public class TablesConst {
    static Connection con;
    static Statement stmt;
    
    public static void main(String args[]) throws ClassNotFoundException {
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        
        String URL = "jdbc:derby:mydatabs;create=true";
        con = DriverManager.getConnection(URL);
        stmt = con.createStatement();
       
       
        String query = "create table workingHourstable( id int PRIMARY KEY GENERATED ALWAYS AS IDENTITY(Start with 1, Increment by 1), noWorkingHours varchar(20), wokingDays varchar(20), workingTime varchar(20), timeSlot varchar(20))";
        stmt.execute(query);
        System.out.println("Table created successfully");
        } catch (SQLException e) {
            System.out.print(e);
        }
    }
}
