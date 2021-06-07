/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transport;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.beans.property.ObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author ARIFUL
 */
public class HistoryController implements Initializable {

    @FXML
    private TableView<historydata> table;
    @FXML
    private TableColumn<historydata, String> jdate;
    @FXML
    private TableColumn<historydata, String> jtime;
    @FXML
    private TableColumn<historydata, String> name;
    @FXML
    private TableColumn<historydata, String> sit;
    
    @FXML
    private TableColumn<historydata, String> dis;
    @FXML
    private TableColumn<historydata, String> mail;
    @FXML
    private TableColumn<historydata, String> phone;
    @FXML
    private TableColumn<historydata, String> idate;
    @FXML
    private TableColumn<historydata, String> buslic;
    @FXML
    private TextField searchsit;
    @FXML
    private TextField custon;
    @FXML
    private TextField jdateBox;
    @FXML
    private TextField jtimeBox;
    @FXML
    private TextField distanceBox;
    @FXML
    private TextField phnBox;
    @FXML
    private TextField mailBox;
    @FXML
    private TextField idateBox;
    private String id;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
     
     historyd();
     
        jdate.setCellValueFactory(new PropertyValueFactory<historydata,String>("jdate"));
        jtime.setCellValueFactory(new PropertyValueFactory<historydata,String>("jtime"));
        sit.setCellValueFactory(new PropertyValueFactory<historydata,String>("sit"));
        name.setCellValueFactory(new PropertyValueFactory<historydata,String>("name"));
        dis.setCellValueFactory(new PropertyValueFactory<historydata,String>("dis"));
        mail.setCellValueFactory(new PropertyValueFactory<historydata,String>("mail"));
        phone.setCellValueFactory(new PropertyValueFactory<historydata,String>("phone"));
        idate.setCellValueFactory(new PropertyValueFactory<historydata,String>("idate"));
        buslic.setCellValueFactory(new PropertyValueFactory<historydata,String>("buslic"));
        jdate.prefWidthProperty().bind(table.widthProperty().divide(10));
        sit.prefWidthProperty().bind(table.widthProperty().divide(6));
        dis.prefWidthProperty().bind(table.widthProperty().divide(6));
        mail.prefWidthProperty().bind(table.widthProperty().divide(6));
        
            
       table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
       
       table.setItems(List);
       
       
       
      //  ObservableList<historydata> List = FXCollections.observableArrayList(new historydata(customer_nam,sit_num));
    }  
    
      ObservableList<historydata> List = FXCollections.observableArrayList();
      final static String url = "jdbc:mysql://localhost:3306/dhaka_transport";
  final      static String    user = "root";
  final     static String     password = "";
   private static Connection nika;
  // String customer_nam,sit_num;
   String sessionCode= DashboardController.session;
   
    
   
    void historyd(){
       
          
        try{
            
            Connection con=DriverManager.getConnection(url,user,password);
                Statement stmt=con.createStatement(); 
                String er = "select stats,bus_num,journey_date,journey_time,booking_sit,distance,customer_name,customer_phone,customer_mail,issue_date from booking_history where session like '%"+sessionCode+"%'";
                ResultSet rs=stmt.executeQuery(er);  
                while(rs.next()) {
                     
                      String stats = rs.getString("stats");
                      if("0".equals(stats)){
                          
                          List.add(new historydata(
                                  
                                  
                                  rs.getString("customer_name"),
                                  rs.getString("booking_sit"),
                                  rs.getString("journey_date"),
                                  rs.getString("journey_time"),
                                  rs.getString("distance"),
                                  rs.getString("customer_mail"),
                                  rs.getString("customer_phone"),
                                  rs.getString("issue_date"),
                                  rs.getString("bus_num")
                                  
                          ));
                      } else {
                      }
                     
               
                }
        }catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Connection Failed" +e);
                }  
           
    }

   
    //String ssc="ariful";
    void search1(){
        
        FilteredList<historydata> filteredData = new FilteredList<>(List, p -> true);

        jdateBox.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(myObject -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();
//                if (String.valueOf(myObject.getSit()).toLowerCase().contains(lowerCaseFilter) || String.valueOf(myObject.getName()).toLowerCase().contains(lowerCaseFilter) ) {
//                    return true;
                 if (
                         String.valueOf(myObject.getJdate()).toLowerCase().contains(lowerCaseFilter) 
                        
                         ) {
                    
                     return true;
            }

                return false; 
            });
        });

        SortedList<historydata> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(table.comparatorProperty());
        table.setItems(sortedData);
    
    
    }
           void search2(){
        
        FilteredList<historydata> filteredData = new FilteredList<>(List, p -> true);

        jtimeBox.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(myObject -> {
                
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();
                if (
                        String.valueOf(myObject.getJtime()).toLowerCase().contains(lowerCaseFilter)
                       
                         ) {
                return true;

            }

                return false; 
            });
        });

        SortedList<historydata> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(table.comparatorProperty());
        table.setItems(sortedData);
    
    
    }
    
       void search3(){
        
        FilteredList<historydata> filteredData = new FilteredList<>(List, p -> true);

        searchsit.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(myObject -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();
               if (
                          String.valueOf(myObject.getSit()).toLowerCase().contains(lowerCaseFilter) 
                        
                         ) {
                return true;

            }

                return false; 
            });
        });

        SortedList<historydata> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(table.comparatorProperty());
        table.setItems(sortedData);
    
    
    }
          void search4(){
        
        FilteredList<historydata> filteredData = new FilteredList<>(List, p -> true);

        distanceBox.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(myObject -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();
                if (
                        String.valueOf(myObject.getDis()).toLowerCase().contains(lowerCaseFilter) 
                        
                         ) {
                return true;

            }

                return false; 
            });
        });

        SortedList<historydata> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(table.comparatorProperty());
        table.setItems(sortedData);
    } 
    
       void search5(){
        
        FilteredList<historydata> filteredData = new FilteredList<>(List, p -> true);

        custon.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(myObject -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();
               if (
                        String.valueOf(myObject.getName()).toLowerCase().contains(lowerCaseFilter)
                       
                         ) {
                return true;

            }

                return false; 
            });
        });

        SortedList<historydata> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(table.comparatorProperty());
        table.setItems(sortedData);
    
    
    }
       void search6(){
        
           
        FilteredList<historydata> filteredData = new FilteredList<>(List, p -> true);

        phnBox.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(myObject -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();
                if (String.valueOf(myObject.getPhone()).toLowerCase().contains(lowerCaseFilter)) {
                return true;

                }

                return false; 
            });
        });

        SortedList<historydata> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(table.comparatorProperty());
        table.setItems(sortedData);
    
    
    }
              void search7(){
        
        FilteredList<historydata> filteredData = new FilteredList<>(List, p -> true);

        mailBox.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(myObject -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();
                if (String.valueOf(myObject.getMail()).toLowerCase().contains(lowerCaseFilter)) {
                    return true;

            }

                return false; 
            });
        });

        SortedList<historydata> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(table.comparatorProperty());
        table.setItems(sortedData);
    
    
    }
       void search8(){
        
        FilteredList<historydata> filteredData = new FilteredList<>(List, p -> true);

        idateBox.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(myObject -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();
                if (
                        String.valueOf(myObject.getIdate()).toLowerCase().contains(lowerCaseFilter)
                        
                         ) {
                return true;

            }

                return false; 
            });
        });

        SortedList<historydata> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(table.comparatorProperty());
        table.setItems(sortedData);
    
    
    }
    @FXML
    private void searchsitTyp(KeyEvent event) {
        search3();
    }

    private void searchkeystop(KeyEvent event) {
       // ssc=search.getText();
    }

    @FXML
    private void custonTyp(KeyEvent event) {
         search5();
    }

    @FXML
    private void jdateBoxtyp(KeyEvent event) {
        search1();
    }

    @FXML
    private void jtimeBoxtyp(KeyEvent event) {
        search2();
    }

    @FXML
    private void distanceBoxtyp(KeyEvent event) {
        search4();
    }

    @FXML
    private void phnBoxtyp(KeyEvent event) {
        search6();
    }

    @FXML
    private void mailBoxtyp(KeyEvent event) {
        search7();
    }

    @FXML
    private void idateBoxtyp(KeyEvent event) {
        search8();
    }

    @FXML
    private void deleteBtn(ActionEvent event) {
        
       //fastsearchLabel.setText( table.getSelectionModel().getSelectedItem().getBuslic() );
       String sit = table.getSelectionModel().getSelectedItem().getSit();
       String distance = table.getSelectionModel().getSelectedItem().getDis();
       String jtime = table.getSelectionModel().getSelectedItem().getJtime();
       String jdate = table.getSelectionModel().getSelectedItem().getJdate();
       String buslicnum = table.getSelectionModel().getSelectedItem().getBuslic();
       
       bookingDelet.bussitbookingCancel(sit,distance,jtime,jdate);//data send for delet history table
       bookingDelet.bussitupdate(jdate,jtime,buslicnum,sit);
        table.getItems().removeAll(table.getSelectionModel().getSelectedItem());
        
    }

  
     

}
