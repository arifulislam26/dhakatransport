/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transport;
import java.sql.* ;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import static transport.DBConnect.url;

/**
 *
 * @author ARIFUL
 */
public class DBbbusChecking {
     final static String url = "jdbc:mysql://localhost:3306/dhaka_transport";
  final      static String    user = "root";
  final     static String     password = "";
  
  public String times(String tt){
      return tt;
  }
  static protected void bustimechecking(String fbus, String tbus,String dbus,int bustyp){
     
   ArrayList result = new ArrayList();
       try{
                Connection con=DriverManager.getConnection(url,user,password);
                Statement stmt=con.createStatement(); 
                String er = "select bus_date,bus_time from schedule_data where bus_from like '%"+fbus+"%' and bus_to like '%"+tbus+"%' and bus_date like '%"+dbus+"%' and bus_type like '%"+bustyp+"%'";
                 //AC for 1 
                 //nonAc for 2
                ResultSet rs=stmt.executeQuery(er);  
                while(rs.next())  
                {
                    
                     String time = rs.getString("bus_time");
                    
                    result.add(time);
                     
                            //JOptionPane.showMessageDialog(null, "time: " +time);
                     
                }
              con.close();
             
             DashboardController.nika(result.toString());
           
        }
        catch(Exception ex ){
           
            JOptionPane.showMessageDialog(null, "Connection Failed" +ex);
            
        }
  
  
  }//bustimechecking END
 
static protected void bussitChecking(String fbus, String tbus,String dbus,int bustyp,String time){
     //JOptionPane.showMessageDialog(null, "number: " +fbus+" "+tbus+dbus+bustyp+" time"+time);
 try{
                Connection con=DriverManager.getConnection(url,user,password);
                Statement stmt=con.createStatement(); 
                String er = "select bus_number,bus_phone,sit_price from schedule_data where bus_from like '%"+
                        fbus+"%' and bus_to like '%"+tbus+"%' and bus_date like '%"+
                        dbus+"%' and bus_type like '%"+bustyp+"%' and bus_time like '%"+time+"%'";
                ResultSet rs=stmt.executeQuery(er);  //+"%' and bus_time like '%"+time+
                if(rs.next())  
                {
                    
                     String busLic = rs.getString("bus_number");
                     String busPhn = rs.getString("bus_phone");
                     int sitPrice = rs.getInt("sit_price");
                    busPhone(busPhn);
                    busLic(busLic);
                  DashboardController.getbusinfo(busPhn,busLic,sitPrice);
                          //  JOptionPane.showMessageDialog(null, "number: " +busLic+" "+busPhn);
                     
                }
                
              con.close();
             
            // DashboardController.nika(result.toString());
           
        }
        catch(Exception ex ){
           
            JOptionPane.showMessageDialog(null, "Connection Failed" +ex);
            
        }
   
}//bussitChecking END

 static protected String busPhone(String bp){
        
        return bp;
    }
 static protected String busLic(String bl){
        
        return bl;
    }

}