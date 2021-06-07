/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transport;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import static transport.BDbusSitChecking.url;

/**
 *
 * @author ARIFUL
 */
public class news {
    
     final static String    url = "jdbc:mysql://localhost:3306/dhaka_transport";
      final static String    user = "root";
      final static String    password = "";
      
      private static String newsUpdate;
      
      public static String upnews(){
          try{
               Connection con=DriverManager.getConnection(url,user,password);
                Statement stmt=con.createStatement(); 
                String er = "select news from server_news";
               
                ResultSet rs=stmt.executeQuery(er);  
                if(rs.next()) {
                     newsUpdate = rs.getString("news");
                    
                    
                }
                con.close();
          }catch(Exception ex){
              JOptionPane.showMessageDialog(null, "Connection Failed" +ex);
          }
         //return null;
       return newsUpdate;
      }
     
    
}
