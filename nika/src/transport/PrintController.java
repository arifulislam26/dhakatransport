/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transport;

import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;
import static transport.DBConnect.url;
import static transport.DashboardController.bl;
import static transport.DashboardController.bp;

/**
 * FXML Controller class
 *
 * @author ARIFUL
 */
public class PrintController implements Initializable {

    @FXML
    private Label SL;
    @FXML
    private TextField sitnum;
    @FXML
    private Label username;
    @FXML
    private Label idate;
    @FXML
    private Label userphn;
    @FXML
    private Label jdate;
    @FXML
    private Label usermail;

    /**
     * Initializes the controller class.
     */
    static String sit,usr,phn,mail,jdat,idat,ss,pp,session,dis,tym;
    @FXML
    private Label price;
    private static String busnum;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                
        SL.setText(ss);
         sitnum.setText(sit);
          username.setText(usr);
           userphn.setText(phn);
            usermail.setText(mail);
             jdate.setText(jdat);
              idate.setText(idat);
               price.setText(pp);
               session = DashboardController.session;
               datainsert();
               JOptionPane.showMessageDialog(null, "Session code" +session);
       
    }    
    static protected void printview(String a,String b,String c,String d,String e,String f,String g,String h,String i,String j){
        ss=a;sit=b;usr=c;phn=d;mail=e;idat=f;jdat =g;dis=i;tym=j;
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat simpleformat = new SimpleDateFormat("dd-MMM-yyyy");
        idat= simpleformat.format(cal.getTime());
        pp=h;
    }
     final static String url = "jdbc:mysql://localhost:3306/dhaka_transport";
  final      static String    user = "root";
  final     static String     password = "";
    protected static void  datainsert(){
       
        try{
                Connection con=DriverManager.getConnection(url,user,password);
                Statement stmt=con.createStatement(); 
//               String query = " insert into booking_history ( session, customer_name, customer_phone, customer_mail, booking_sit, distance,journey_time, journey_date,issue_date,stats)"
//        + " values (?, ?, ?, ?, ?, ?, ?, ?, ?,0)";
String query = " insert into booking_history ( bus_num,session, customer_name, customer_phone, customer_mail, booking_sit, distance,journey_time, journey_date,issue_date,stats)"
        + " values ("+bl+" ,?, ?, ?, ?, ?, ?, ?, ?, ?,0)";
               
            PreparedStatement preparedStmt = con.prepareStatement(query);
            
            preparedStmt.setString (1, session);
            preparedStmt.setString (2, usr);
            preparedStmt.setString  (3, phn);
            preparedStmt.setString  (4, mail);
            preparedStmt.setString   (5, sit);
            preparedStmt.setString   (6, dis);
            preparedStmt.setString   (7, tym);
            preparedStmt.setString   (8, jdat);
            preparedStmt.setString   (9, idat);
            
      preparedStmt.execute();
   
              con.close();
            
           
        }
        catch(Exception ex ){
           
            JOptionPane.showMessageDialog(null, "Connection Failed" +ex);
             
        }
        
    }
    
    
}
