
package transport;


import java.sql.* ;
import javax.swing.JOptionPane;


public class DBConnect{
   
  final static String url = "jdbc:mysql://localhost:3306/dhaka_transport";
  final      static String    user = "root";
  final     static String     password = "";
   private static Connection nika;
   
    public static Connection connectiontest() {
        
            
          try {
           DriverManager.registerDriver(new com.mysql.jdbc.Driver());
           nika = DriverManager.getConnection(url,user,password);
           JOptionPane.showMessageDialog(null,"Connection Successfuly");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Connection Failed" +e);
                }       
        
        return nika;
    }
    
  private boolean userLogin = false;
  
    protected static boolean  userLogin(String usr, String pass){
       
        try{
                Connection con=DriverManager.getConnection(url,user,password);
                Statement stmt=con.createStatement(); 
                String er = "select session from login_data where user_mail like '%"+usr+"%' and user_pass like '%"+pass+"%'";
                ResultSet rs=stmt.executeQuery(er);  
                if(rs.next())  
                {
                    String sess = rs.getString("session");
                    //JOptionPane.showMessageDialog(null, "session code: " +sess);
                     DashboardController.session= sess;
                      con.close();
                      return true;
                }
              con.close();
            return false;
           
        }
        catch(Exception ex ){
           
            JOptionPane.showMessageDialog(null, "Connection Failed" +ex);
             return false;
        }
        
    }
    
    
}
