
package admin;

import java.sql.*;
import java.util.*;
import java.util.concurrent.Executor;

public class DatabaseManager {

private static Connection con = null; 

           static{
               try
               {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String url = "jdbc:sqlserver://FAWAD-PC\\SQLEXPRESS;databaseName=HMS;integratedSecurity=true;";
                con = DriverManager.getConnection(url,"","");
               }
               catch(Exception e)
               {
               e.printStackTrace();
               }
           }
                
            
           public static Connection getconnect()
           {
           
           try
               {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String url = "jdbc:sqlserver://FAWAD-PC\\SQLEXPRESS;databaseName=HMS;integratedSecurity=true;";
                Connection conn = DriverManager.getConnection(url,"","");
                return conn;
               }
               catch(Exception e)
               {
               e.printStackTrace();
               return null;
               }    
    
           
           

           }
               
     
          


        
    }    

        
        
        

    





    

 
     
 
 
 
  

