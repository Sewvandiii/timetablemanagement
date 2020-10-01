/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

 /**
 *
 * @author  Jayagoda N.M.  -  IT17184304
 */
public class CreateDB {
    public static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    public static final String JDBC_URL = "jdbc:derby:unidb;create=true";
    public static void main(String[] args) throws ClassNotFoundException, SQLException{
       Class.forName(DRIVER);
        Connection connection = DriverManager.getConnection(JDBC_URL);
        

//        //Creating the Statement object
      Statement stmt = connection.createStatement();

      //Executing the query      
      String query = "DROP TABLE lecturer";
      stmt.execute(query);
      System.out.println("Table dropped");


        connection.createStatement().execute("create table lecturer(lecturer_fname varchar(20), lecturer_lname varchar(30), employeeId CHAR(6), faculty varchar(40), department varchar(60), center varchar(20), building varchar(30), level INTEGER, rank CHAR(10))");
        connection.createStatement().execute("insert into lecturer values " +
                 "('Prasanna', 'Gamage', '000150', 'Computing', 'Department of Information Technology', 'Malabe', 'Main Building', 2, '2.000150')");
         
        connection.createStatement().execute("create table subject(subject_code char(6), subject_name varchar(60), offeredYearandSemester varchar(30), numberOfLectureHours INTEGER, numberOfTutorialHours INTEGER, numberOfLabHours INTEGER, numberOfEvaluationHours INTEGER )");
       connection.createStatement().execute("insert into subject values " +
                "('SE3080', 'Software Project management', 'Year 3 Semester 2', 2, 1, 1, 1)");
      
          connection.createStatement().execute("create table center_building( center varchar(20), building varchar(30))");
          connection.createStatement().execute("insert into center_building values('Malabe', 'Main Building'),( 'Malabe','New Building'), ('Malabe', 'D-Block'), ('Kandy', 'Main Building'), ('Kurunagala', 'Main Building'), ('Metro', 'Main Building'), ('Jaffna', 'Main Building'), ('Matara', 'Main Building'), ('Malabe', 'Enginnering Building'), ('Malabe', 'Business School Building')");
            
           connection.createStatement().execute("ALTER TABLE lecturer ALTER COLUMN building SET DATA TYPE varchar(30)");
            connection.createStatement().execute("create table tags(tag varchar(20) unique)");
            connection.createStatement().execute("insert into tags values('Lecture'), ('Tutorial'), ('Practical')");

            connection.createStatement().execute("create table students(groupId varchar(20))");
          connection.createStatement().execute("insert into students values('Y1.S1.IT.01'), ('Y1.S1.IT.02'), ('Y1.S1.IT.03'), ('Y3.S1.SE.01.1'),('Y3.S1.SE.01.2'), ('Y4.S1.IM.01.1')");
           
          connection.createStatement().execute("create table sessions( sessionId INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), lecturers varchar(200), tag varchar(20), subject_name varchar(50), subject_code char(6), student_group_id varchar(20), duration integer, number_of_students integer)");
           connection.createStatement().execute("insert into sessions(lecturers, tag, subject_name, subject_code, student_group_id, duration, number_of_students ) values('Dr. Nuwan Kodagoda, Ms. Kanchana Yasas, Ms. Dinishi Kahadagala', 'Lecture', 'Object Oriented Concepts', 'SE3050', 'Y3.S2.SE.21.1', 5, 320)");

        System.out.println("Table created and Records inserted successfully to the Database");


   } 
}
