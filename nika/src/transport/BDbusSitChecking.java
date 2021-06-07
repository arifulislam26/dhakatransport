/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transport;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import static transport.DBbbusChecking.url;
import static transport.DashboardController.dd;

/**
 *
 * @author ARIFUL
 */
public class BDbusSitChecking {
      final static String    url = "jdbc:mysql://localhost:3306/dhaka_transport";
      final static String    user = "root";
      final static String    password = "";
  static String date;
 static String time;
  static String bl;
  static protected void sitcheck(String ddate,String ttime,String bbl){
      date=ddate;
      time=ttime;
      bl=bbl;
    //  JOptionPane.showMessageDialog(null, "time: " +date+time+bl);
    try{
                Connection con=DriverManager.getConnection(url,user,password);
                Statement stmt=con.createStatement(); 
                String er = "select * from sitbooking_data where bus_date like '%"+date+"%' and bus_time like '%"+time+"%' and bus_number like '%"+bl+"%'";
               
                ResultSet rs=stmt.executeQuery(er);  
                if(rs.next())  
                {
                    
                    int a1 = rs.getInt("a1");int a2 = rs.getInt("a2");int a3 = rs.getInt("a3");int a4 = rs.getInt("a4");
                    int b1 = rs.getInt("b1");int b2 = rs.getInt("b2");int b3 = rs.getInt("b3");int b4 = rs.getInt("b4");
                    int c1 = rs.getInt("c1");int c2 = rs.getInt("c2");int c3 = rs.getInt("c3");int c4 = rs.getInt("c4");
                    int d1 = rs.getInt("d1");int d2 = rs.getInt("d2");int d3 = rs.getInt("d3");int d4 = rs.getInt("d4");
                    int e1 = rs.getInt("e1");int e2 = rs.getInt("e2");int e3 = rs.getInt("e3");int e4 = rs.getInt("e4");
                    int f1 = rs.getInt("f1");int f2 = rs.getInt("f2");int f3 = rs.getInt("f3");int f4 = rs.getInt("f4");
                    int g1 = rs.getInt("g1");int g2 = rs.getInt("g2");int g3 = rs.getInt("g3");int g4 = rs.getInt("g4");
                    int h1 = rs.getInt("h1");int h2 = rs.getInt("h2");int h3 = rs.getInt("h3");int h4 = rs.getInt("h4");
                    int i1 = rs.getInt("i1");int i2 = rs.getInt("i2");int i3 = rs.getInt("i3");int i4 = rs.getInt("i4");
                    int j1 = rs.getInt("j1");int j2 = rs.getInt("j2");int j3 = rs.getInt("j3");int j4 = rs.getInt("j4");int j5 = rs.getInt("j5");
                     DashboardController.getsit(a1,a2,a3,a4,b1,b2,b3,b4,c1,c2,c3,c4,d1,d2,d3,d4,e1,e2,e3,e4,f1,f2,f3,f4,g1,g2,g3,g4,h1,h2,h3,h4,i1,i2,i3,i4,j1,j2,j3,j4,j5);
                          //  JOptionPane.showMessageDialog(null, "time: " +a1);
                    
                }
              con.close();
             
           
           
        }
        catch(Exception ex ){
           
            JOptionPane.showMessageDialog(null, "Connection Failed" +ex);
            
        }
  }
   static protected void bussitbooking(String elm){
   
       try{
          Connection con=DriverManager.getConnection(url,user,password);
                Statement stmt=con.createStatement(); 
                String er = "UPDATE sitbooking_data SET "+elm+" = 1 WHERE bus_date like '%"+date+"%' and bus_time like '%"+time+"%' and bus_number like '%"+bl+"%'";
               PreparedStatement st = con.prepareStatement(er);
               
                st.executeUpdate();  
                //JOptionPane.showMessageDialog(null, "done:"+ er );
                //JOptionPane.showMessageDialog(null, "done" );
                
      } catch(Exception ex ){
           
            //JOptionPane.showMessageDialog(null, "SERVER RUNNING SLOW");
            
        }
 
   
   }//bussitbooking END
   
     static protected void sitnumber(String sit){
          //sit=sit.replace(" ","");
          sit = sit.toLowerCase();
          String[] strarray = sit.split(" ");
                if(strarray.length > 0){
                    for(String elm: strarray){
                        if(!" ".equals(elm) || !"".equals(elm) || elm!=null)
                       bussitbooking(elm);
                        
                    }
                }
   
   }
  
}//BDbusSitChecking
