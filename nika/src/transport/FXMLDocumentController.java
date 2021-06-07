/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transport;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author ARIFUL
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private TextField user_txt;
    @FXML
    private PasswordField pass_txt;
    @FXML
    private Button loginBtn;
    @FXML
    private Button clearBtn;
    
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleLoginButton(ActionEvent event) throws IOException {
       // DBConnect.connectiontest();
      
      String s_pass = passwordEncryption.NoSuchAlgorithmException(pass_txt.getText());
       if(( DBConnect.userLogin(user_txt.getText(),s_pass))==true)
       {
           DashboardController.userID = user_txt.getText();
            Stage stage = (Stage) loginBtn.getScene().getWindow();
            stage.close();
            dash();
            //Call Dashboard 
            //Catch session code
            
       }
    }

    public void dash() throws IOException {
    
       FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Dashboard.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("DashBoard");
        stage.setScene(new Scene(root1)); 
       
        stage.show();
    }
    
    @FXML
    private void handleClearButton(ActionEvent event) {
        user_txt.setText("");
        pass_txt.setText("");
    }
    
    
   
  
    
}
