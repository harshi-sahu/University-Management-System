package university.management.system;

import java.sql.*;

public class Conn {
    
    Connection c;
    Statement s;
    
    Conn(){  //constructor
        try{
            //Register the driver class
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //Creating Connection String 
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitymanagementsystem", "root", "12345");
    
            //Creating Statement
            s = c.createStatement();
            
            //Executing MySQL Queries
            //Closing the Connection
        }catch (Exception e){
            e.printStackTrace();
        }
    }

public static void main(String args[]){
   new Conn();
}

}