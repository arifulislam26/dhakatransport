/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transport;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import javax.swing.JOptionPane;
import static transport.DashboardController.session;

/**
 *
 * @author ARIFUL
 */
public class bookingDelet {
     final static String    url = "jdbc:mysql://localhost:3306/dhaka_transport";
      final static String    user = "root";
      final static String    password = "";
     // private static String ss= DashboardController.session;
      
       static protected void bussitbookingCancel(String sit,String distance,String jtime,String jdate){
           
       try{
          Connection con=DriverManager.getConnection(url,user,password);
                Statement stmt=con.createStatement(); 
                String er = "UPDATE booking_history SET stats = 1 WHERE distance like '%"+distance+"%' and journey_time like '%"+jtime+"%' and journey_date like '%"+jdate+"%' and session like '%"+session+"%' and booking_sit like '%"+sit+"%'";
               PreparedStatement st = con.prepareStatement(er);
               JOptionPane.showMessageDialog(null, "session: "+session);
                st.executeUpdate();  
                
      } catch(Exception ex ){
           
            
            
        }
 
   
   }//bussitbookingCancel END
    
       private static String date,time,buslic;
    static protected void bussitupdate(String dt,String ty,String bl,String sit){
        date = dt;
        time = ty;
        buslic= bl;
        sit = sit.toLowerCase();
          String[] strarray = sit.split(" ");
                if(strarray.length > 0){
                    for(String elm: strarray){
                        if(!" ".equals(elm) || !"".equals(elm) || elm!=null)
                       bk(elm);
                        
                    }
                }
    }
    
    static protected void bk(String elm){
    
     try{
          Connection con=DriverManager.getConnection(url,user,password);
                Statement stmt=con.createStatement(); 
                String er = "UPDATE sitbooking_data SET "+elm+" = 0 WHERE bus_date like '%"+date+"%' and bus_time like '%"+time+"%' and bus_number like '%"+buslic+"%'";
               PreparedStatement st = con.prepareStatement(er);
               
                st.executeUpdate();  
                
      } catch(Exception ex ){
          //error
            
        }
    }
    
     static protected void sitnumber(String sit){
          //sit=sit.replace(" ","");
         
   
   }
       
}
