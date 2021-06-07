/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transport;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author ARIFUL
 */
public class DashboardController implements Initializable {

    protected static String session = "990";
    @FXML
    private ChoiceBox<String> frombox;
    @FXML
    private ChoiceBox<String> tobox;
    @FXML
    private DatePicker datetimepicker;
    @FXML
    private Label distanceLabel;
   
    @FXML
    private TextField distancebox;
    @FXML
    private TextField jdate;
    @FXML
    private RadioButton busac;
    @FXML
    private RadioButton busnonac;
    @FXML
    private ChoiceBox<String> jtime;
    @FXML
    private Label timelabel;
    @FXML
    private TextField busnumBox;
    @FXML
    private TextField busphnBox;
    @FXML
    private Pane lefepane;
    
    private AnchorPane leftBusSit;
    public String bustime;
    int bustype =1;
   static public int price;
    static public String dd="";//[8.30AM, 9.30AM]
    static public String bl,bp;
    static public int totalprice;
    public String busDate;
    @FXML
    private Button a1;
    @FXML
    private Button a2;
    @FXML
    private Button a3;
    @FXML
    private Button a4;
    @FXML
    private TextField sitNumberBox;
    @FXML
    private TextField sitprice;
    @FXML
    private TextField totalpriceBox;
    @FXML
    private Button b1;
    @FXML
    private Button c1;
    @FXML
    private Button d1;
    @FXML
    private Button f1;
    @FXML
    private Button g1;
    @FXML
    private Button h1;
    @FXML
    private Button b2;
    @FXML
    private Button c2;
    @FXML
    private Button d2;
    @FXML
    private Button f2;
    @FXML
    private Button g2;
    @FXML
    private Button h2;
    @FXML
    private Button i1;
    @FXML
    private Button j1;
    @FXML
    private Button i2;
    @FXML
    private Button j2;
    @FXML
    private Button b3;
    @FXML
    private Button c3;
    @FXML
    private Button d3;
    @FXML
    private Button e3;
    @FXML
    private Button f3;
    @FXML
    private Button g3;
    @FXML
    private Button h3;
    @FXML
    private Button b4;
    @FXML
    private Button c4;
    @FXML
    private Button d4;
    @FXML
    private Button e4;
    @FXML
    private Button f4;
    @FXML
    private Button g4;
    @FXML
    private Button h4;
    @FXML
    private Button i3;
    @FXML
    private Button j4;
    @FXML
    private Button i4;
    @FXML
    private Button j5;
    @FXML
    private Button j3;
    @FXML
    private Button submitBtn;
    @FXML
    private Button e1;
    @FXML
    private Button e2;
    @FXML
    private TextField custName;
    @FXML
    private TextField custPhn;
    @FXML
    private TextField custMail;
    @FXML
    private TextArea newsBox;
    private static String brnews;
    @FXML
    private Label hislabel;
    @FXML
    private Label logoutlabel;
    @FXML
    private Label locklabel;
    @FXML
    private BorderPane locksceen;
    @FXML
    private Button unlockBtn;
    @FXML
    private PasswordField unlockpassBox;
    protected static String userID;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            //ObservableList<String> cursors = FXCollections.observableArrayList("a","b","c");
            //From ChoiceBox
            frombox.getItems().addAll("Uttara", "Abdullapur", "Saidabad", "Ashulia");
            tobox.getItems().addAll("Jessore", "Khulna", "Rajshahi", "Jamalpur", "Pabna");
           //To ChoiceBox
            jtime.setOnAction(this::busTime);
            tobox.setOnAction(this::tobox);
            frombox.setOnAction(this::frombox);
            lefepane.setDisable(true);
            
            
            brnews = news.upnews();
            newsBox.setText(brnews);
            
            
    }    

    public String frbus,tobus;
    private void distancetest(String bustyp){
            distanceLabel.textProperty().bind(frombox.getSelectionModel().selectedItemProperty());
            frbus = distanceLabel.getText();
            distanceLabel.textProperty().bind(tobox.getSelectionModel().selectedItemProperty());
            tobus  =distanceLabel.getText();
            distancebox.setText(frbus+" To "+ tobus+bustyp);

    }
    @FXML
    private void fromboxAction(MouseEvent event) {
         //silence is gold
    }

    @FXML
    private void toboxAction(MouseEvent event) {
         //silence is gold
    }
    public void buscontactBox(){
    
     busnumBox.setText(bp);
        busphnBox.setText(bl);
        sitprice.setText(String.valueOf(price));
    }
    public void clear(){
            busnonac.setSelected(false);
            busac.setSelected(false);
            jtime.getItems().clear();
            lefepane.setDisable(true);
            bustime="";
            bp="";
            bl="";
            price = 0;
            totalprice =0;
            sitNumberBox.setText("");
            totalpriceBox.setText("0");
            buscontactBox();
            
    }
    public void frombox(ActionEvent event){
        clear(); 
    }
    
    public void tobox(ActionEvent event){
        clear();
    }
   
    @FXML
    private void datetimepickerAction(ActionEvent event) {
          busDate = datetimepicker.getValue().format(DateTimeFormatter.ofPattern("dd-MMMM-yyyy"));
          jdate.setText(busDate);
          clear();
    }

    public void radioClear(){
            dd="";
            jtime.getItems().clear();
            lefepane.setDisable(true);
            busnumBox.setText(bp);
            bustime=" ";
            bp=" ";
            bl=" ";
            price =0;
            totalprice =0;
            sitNumberBox.setText("");
            totalpriceBox.setText("0");
            buscontactBox();
           // 
    }
    @FXML
    private void acAction(ActionEvent event) {
            radioClear();
        if(busac.isSelected()){
           
            busnonac.setSelected(false);
            distancetest(" (AC)");
            bustype =1;
            DBbbusChecking.bustimechecking(frbus,tobus,busDate,bustype);
            nn();
            
                
        }
    }

    @FXML
    private void nonAction(ActionEvent event) {
          radioClear();
          
         if(busnonac.isSelected()){
            busac.setSelected(false);
            distancetest(" (Non-AC)");
            bustype =2;
            DBbbusChecking.bustimechecking(frbus,tobus,busDate,bustype);
            //jtime.setDisable(true);
            nn();
           
        }
    }

  
   static public void nika(String tt){
       
       dd=tt.replace("[","");
       dd=dd.replace("]","");
       dd=dd.replace(" ","");
    }
   
   public void nn(){
       
      String[] strarray = dd.split(",");
                if(strarray.length > 0){
                    for(String elm: strarray){
                        jtime.getItems().addAll(elm);
                    }
                }
       
   }
   
    private void jtimeAction(MouseEvent event) {
       //silence is gold
    }
    
    static protected void getbusinfo(String busp,String busl,int sitprice){
       bp = busp;
       bl = busl;
       price = sitprice;
    }
    int kk=0;
    protected void busTime(ActionEvent event){
        price =0;
            totalprice =0;
            sitNumberBox.setText("");
            totalpriceBox.setText("0");
        timelabel.textProperty().bind(jtime.getSelectionModel().selectedItemProperty());
        bustime= timelabel.getText();
        
        DBbbusChecking.bussitChecking(frbus,tobus,busDate,bustype,bustime);
        buscontactBox();
        
        lefepane.setDisable(false);
        
          BDbusSitChecking.sitcheck(busDate, bustime, bl);
          bs();
    }
   static int A1,A2,A3,A4,B1,B2,B3,B4,C1,C2,C3,C4,D1,D2,D3,D4,E1,E2,E3,E4,F1,F2,F3,F4,G1,G2,G3,G4,H1,H2,H3,H4,I1,I2,I3,I4,J1,J2,J3,J4,J5;
    static protected void getsit(int a1,int a2,int a3,int a4,int b1, int b2,int b3,int b4,int c1,int c2,int c3, int c4,int d1,int d2,int d3,int d4,int e1, int e2,int e3,int e4,int f1,int f2,int f3, int f4,int g1,int g2,int g3,int g4,int h1,int h2,int h3,int h4,int i1,int i2,int i3,int i4,int j1,int j2,int j3,int j4,int j5)
    {
        A1=a1;A2=a2;A3=a3;A4=a4;B1=b1;B2=b2;B3=b3;B4=b4;C1=c1;C2=c2;C3=c3;C4=c4;
        D1=d1;D2=d2;D3=d3;D4=d4;
        E1=e1;E2=e2;E3=e3;E4=e4;
        F1=f1;F2=f2;F3=f3;F4=f4;
        G1=g1;F2=g2;G3=g3;G4=g4;
        H1=h1;H2=h2;H3=h3;H4=h4;
        I1=i1;I2=i2;I3=i3;I4=i4;
        J1=j1;J2=j2;J3=j3;J4=j4;J5=j5;
        
        
    }
     public void bs(){
         if(A1==1){a1.setStyle("-fx-background-color: efc564");a1.setDisable(true);}else{a1.setStyle("-fx-background-color: 90EE90");a1.setDisable(false);}
         if(A2==1){a2.setStyle("-fx-background-color: efc564");a2.setDisable(true);}else{a2.setStyle("-fx-background-color: 90EE90");a2.setDisable(false);}
         if(A3==1){a3.setStyle("-fx-background-color: efc564");a3.setDisable(true);}else{a3.setStyle("-fx-background-color: 90EE90");a3.setDisable(false);}
         if(A4==1){a4.setStyle("-fx-background-color: efc564");a4.setDisable(true);}else{a4.setStyle("-fx-background-color: 90EE90");a4.setDisable(false);}
         if(B1==1){b1.setStyle("-fx-background-color: efc564");b1.setDisable(true);}else{b1.setStyle("-fx-background-color: 90EE90");b1.setDisable(false);}
         if(B2==1){b2.setStyle("-fx-background-color: efc564");b2.setDisable(true);}else{b2.setStyle("-fx-background-color: 90EE90");b2.setDisable(false);}
         if(B3==1){b3.setStyle("-fx-background-color: efc564");b3.setDisable(true);}else{b3.setStyle("-fx-background-color: 90EE90");b3.setDisable(false);}
         if(B4==1){b4.setStyle("-fx-background-color: efc564");b4.setDisable(true);}else{b4.setStyle("-fx-background-color: 90EE90");b4.setDisable(false);}
         if(C1==1){c1.setStyle("-fx-background-color: efc564");c1.setDisable(true);}else{c1.setStyle("-fx-background-color: 90EE90");c1.setDisable(false);}
if(C2==1){c2.setStyle("-fx-background-color: efc564");c2.setDisable(true);}else{c2.setStyle("-fx-background-color: 90EE90");c2.setDisable(false);}
if(C3==1){c3.setStyle("-fx-background-color: efc564");c3.setDisable(true);}else{c3.setStyle("-fx-background-color: 90EE90");c3.setDisable(false);}
if(C4==1){c4.setStyle("-fx-background-color: efc564");c4.setDisable(true);}else{c4.setStyle("-fx-background-color: 90EE90");c4.setDisable(false);}


if(D1==1){d1.setStyle("-fx-background-color: efc564");d1.setDisable(true);}else{d1.setStyle("-fx-background-color: 90EE90");d1.setDisable(false);}
if(D2==1){d2.setStyle("-fx-background-color: efc564");d2.setDisable(true);}else{d2.setStyle("-fx-background-color: 90EE90");d2.setDisable(false);}
if(D3==1){d3.setStyle("-fx-background-color: efc564");d3.setDisable(true);}else{d3.setStyle("-fx-background-color: 90EE90");d3.setDisable(false);}
if(D4==1){d4.setStyle("-fx-background-color: efc564");d4.setDisable(true);}else{d4.setStyle("-fx-background-color: 90EE90");d4.setDisable(false);}

if(E1==1){e1.setStyle("-fx-background-color: efc564");e1.setDisable(true);}else{e1.setStyle("-fx-background-color: 90EE90");e1.setDisable(false);}
if(E2==1){e2.setStyle("-fx-background-color: efc564");e2.setDisable(true);}else{e2.setStyle("-fx-background-color: 90EE90");e2.setDisable(false);}
if(E3==1){e3.setStyle("-fx-background-color: efc564");e3.setDisable(true);}else{e3.setStyle("-fx-background-color: 90EE90");e3.setDisable(false);}
if(E4==1){e4.setStyle("-fx-background-color: efc564");e4.setDisable(true);}else{e4.setStyle("-fx-background-color: 90EE90");e4.setDisable(false);}

if(F1==1){f1.setStyle("-fx-background-color: efc564");f1.setDisable(true);}else{f1.setStyle("-fx-background-color: 90EE90");f1.setDisable(false);}
if(F2==1){f2.setStyle("-fx-background-color: efc564");f2.setDisable(true);}else{f2.setStyle("-fx-background-color: 90EE90");f2.setDisable(false);}
if(F3==1){f3.setStyle("-fx-background-color: efc564");f3.setDisable(true);}else{f3.setStyle("-fx-background-color: 90EE90");f3.setDisable(false);}
if(F4==1){f4.setStyle("-fx-background-color: efc564");f4.setDisable(true);}else{f4.setStyle("-fx-background-color: 90EE90");f4.setDisable(false);}

if(G1==1){g1.setStyle("-fx-background-color: efc564");g1.setDisable(true);}else{g1.setStyle("-fx-background-color: 90EE90");g1.setDisable(false);}
if(G2==1){g2.setStyle("-fx-background-color: efc564");g2.setDisable(true);}else{g2.setStyle("-fx-background-color: 90EE90");g2.setDisable(false);}
if(G3==1){g3.setStyle("-fx-background-color: efc564");g3.setDisable(true);}else{g3.setStyle("-fx-background-color: 90EE90");g3.setDisable(false);}
if(G4==1){g4.setStyle("-fx-background-color: efc564");g4.setDisable(true);}else{g4.setStyle("-fx-background-color: 90EE90");g4.setDisable(false);}

if(H1==1){h1.setStyle("-fx-background-color: efc564");h1.setDisable(true);}else{h1.setStyle("-fx-background-color: 90EE90");h1.setDisable(false);}
if(H2==1){h2.setStyle("-fx-background-color: efc564");h2.setDisable(true);}else{h2.setStyle("-fx-background-color: 90EE90");h2.setDisable(false);}
if(H3==1){h3.setStyle("-fx-background-color: efc564");h3.setDisable(true);}else{h3.setStyle("-fx-background-color: 90EE90");h3.setDisable(false);}
if(H4==1){h4.setStyle("-fx-background-color: efc564");h4.setDisable(true);}else{h4.setStyle("-fx-background-color: 90EE90");h4.setDisable(false);}

if(I1==1){i1.setStyle("-fx-background-color: efc564");i1.setDisable(true);}else{i1.setStyle("-fx-background-color: 90EE90");i1.setDisable(false);}
if(I2==1){i2.setStyle("-fx-background-color: efc564");i2.setDisable(true);}else{i2.setStyle("-fx-background-color: 90EE90");i2.setDisable(false);}
if(I3==1){i3.setStyle("-fx-background-color: efc564");i3.setDisable(true);}else{i3.setStyle("-fx-background-color: 90EE90");i3.setDisable(false);}
if(I4==1){i4.setStyle("-fx-background-color: efc564");i4.setDisable(true);}else{i4.setStyle("-fx-background-color: 90EE90");i4.setDisable(false);}

if(J1==1){j1.setStyle("-fx-background-color: efc564");j1.setDisable(true);}else{j1.setStyle("-fx-background-color: 90EE90");j1.setDisable(false);}
if(J2==1){j2.setStyle("-fx-background-color: efc564");j2.setDisable(true);}else{j2.setStyle("-fx-background-color: 90EE90");j2.setDisable(false);}
if(J3==1){j3.setStyle("-fx-background-color: efc564");j3.setDisable(true);}else{j3.setStyle("-fx-background-color: 90EE90");j3.setDisable(false);}
if(J4==1){j4.setStyle("-fx-background-color: efc564");j4.setDisable(true);}else{j4.setStyle("-fx-background-color: 90EE90");j4.setDisable(false);}
if(J5==1){j5.setStyle("-fx-background-color: efc564");j5.setDisable(true);}else{j5.setStyle("-fx-background-color: 90EE90");j5.setDisable(false);}

     }
    
    @FXML
    private void jtimemouseClicked(MouseEvent event) {
        //silence is gold
    }
         @FXML
    private void newsMouse(MouseEvent event) {
         brnews = news.upnews();
            newsBox.setText(brnews);
    }

    protected void sitDelect(String a){
    String ds = sitNumberBox.getText();
        ds= ds.replace(a,"");
        sitNumberBox.setText(ds);
        totalprice = totalprice -price;
        totalpriceBox.setText(String.valueOf(totalprice));
          i--;
       if(i>0){
           submitBtn.setDisable(false);
       }else submitBtn.setDisable(true);
    }
    int i=0;
    protected void sitAdd(String a){
        
        sitNumberBox.setText(sitNumberBox.getText()+a+" ");
        totalprice = totalprice +price;
        totalpriceBox.setText(String.valueOf(totalprice));
        i++;
        if(i>0){
           submitBtn.setDisable(false);
       }else submitBtn.setDisable(true);
    } 
    
    @FXML
    private void submitBtnAction(ActionEvent event) throws IOException {
        
        String aa= totalpriceBox.getText();
        int lk =Integer.parseInt(aa);
        if(sitNumberBox.getText()!=null && lk!= 0){
           BDbusSitChecking.sitnumber(sitNumberBox.getText());
            //JOptionPane.showMessageDialog(null, "Booking Completed!");
            PrintController.printview(distancebox.getText(),sitNumberBox.getText(),custName.getText(),custPhn.getText(),custMail.getText(),"todays date",jdate.getText(),totalpriceBox.getText(),distancebox.getText(),timelabel.getText());
        
            custName.setText("");custPhn.setText("");custMail.setText("");
           
            print();
            clear();

        }
    }
    protected void print() throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("print.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.setResizable(false);
        
        stage.show();

    
    
    }
    @FXML
    private void a1Action(ActionEvent event) {
            if(A1==0){a1.setStyle("-fx-background-color: efc564");A1=1;
            sitAdd("A1");
        }
        else{
            a1.setStyle("-fx-background-color: 90EE90");A1=0;
            sitDelect("A1");
        }
          
    }

    @FXML
    private void a2Action(ActionEvent event) {
        if(A2==0){a2.setStyle("-fx-background-color: efc564");A2=1; sitAdd("A2");}else{a2.setStyle("-fx-background-color: 90EE90");A2=0;sitDelect("A2");}
    }

    @FXML
    private void a3Action(ActionEvent event) {
        if(A3==0){a3.setStyle("-fx-background-color: efc564");A3=1;sitAdd("A3");}else{a3.setStyle("-fx-background-color: 90EE90");A3=0;sitDelect("A3");}
    }

    @FXML
    private void a4Action(ActionEvent event) {
        if(A4==0){a4.setStyle("-fx-background-color: efc564");A4=1;sitAdd("A4");}else{a4.setStyle("-fx-background-color: 90EE90");A4=0;sitDelect("A4");}
    }

    @FXML
    private void b1Action(ActionEvent event) {
        if(B1==0){b1.setStyle("-fx-background-color: efc564");B1=1;sitAdd("B1");}else{b1.setStyle("-fx-background-color: 90EE90");B1=0;sitDelect("B1");}
    }

    @FXML
    private void c1Action(ActionEvent event) {
        if(C1==0){c1.setStyle("-fx-background-color: efc564");C1=1; sitAdd("C1");}else{c1.setStyle("-fx-background-color: 90EE90");C1=0;sitDelect("C1");}
        
    }

    @FXML
    private void d1Action(ActionEvent event) {
if(D1==0){d1.setStyle("-fx-background-color: efc564");D1=1; sitAdd("D1");}else{d1.setStyle("-fx-background-color: 90EE90");D1=0;sitDelect("D1");}
    }

    @FXML
    private void e1Action(ActionEvent event) {
if(E1==0){e1.setStyle("-fx-background-color: efc564");E1=1; sitAdd("E1");}else{e1.setStyle("-fx-background-color: 90EE90");E1=0;sitDelect("E1");}
    }

    @FXML
    private void f1Action(ActionEvent event) {
if(F1==0){f1.setStyle("-fx-background-color: efc564");F1=1; sitAdd("F1");}else{f1.setStyle("-fx-background-color: 90EE90");F1=0;sitDelect("F1");}
    }

    @FXML
    private void g1Action(ActionEvent event) {
if(G1==0){g1.setStyle("-fx-background-color: efc564");G1=1; sitAdd("G1");}else{g1.setStyle("-fx-background-color: 90EE90");G1=0;sitDelect("G1");}
    }

    @FXML
    private void h1Action(ActionEvent event) {
if(H1==0){h1.setStyle("-fx-background-color: efc564");H1=1; sitAdd("H1");}else{h1.setStyle("-fx-background-color: 90EE90");H1=0;sitDelect("H1");}
    }

    @FXML
    private void b2Action(ActionEvent event) {
        if(B2==0){b2.setStyle("-fx-background-color: efc564");B2=1; sitAdd("B2");}else{b2.setStyle("-fx-background-color: 90EE90");B2=0;sitDelect("B2");}
    }

    @FXML
    private void c2Action(ActionEvent event) {
        
        if(C2==0){c2.setStyle("-fx-background-color: efc564");C2=1; sitAdd("C2");}else{c2.setStyle("-fx-background-color: 90EE90");C2=0;sitDelect("C2");}
    }

    @FXML
    private void d2Action(ActionEvent event) {
if(D2==0){d2.setStyle("-fx-background-color: efc564");D2=1; sitAdd("D2");}else{d2.setStyle("-fx-background-color: 90EE90");D2=0;sitDelect("D2");}
    }

    @FXML
    private void e2Action(ActionEvent event) {
if(E2==0){e2.setStyle("-fx-background-color: efc564");E2=1; sitAdd("E2");}else{e2.setStyle("-fx-background-color: 90EE90");E2=0;sitDelect("E2");}
    }

    @FXML
    private void f2Action(ActionEvent event) {
if(F2==0){f2.setStyle("-fx-background-color: efc564");F2=1; sitAdd("F2");}else{f2.setStyle("-fx-background-color: 90EE90");F2=0;sitDelect("F2");}
    }

    @FXML
    private void g2Action(ActionEvent event) {
if(G2==0){g2.setStyle("-fx-background-color: efc564");G2=1; sitAdd("G2");}else{g2.setStyle("-fx-background-color: 90EE90");G2=0;sitDelect("G2");}
    }

    @FXML
    private void h2Action(ActionEvent event) {
if(H2==0){h2.setStyle("-fx-background-color: efc564");H2=1; sitAdd("H2");}else{h2.setStyle("-fx-background-color: 90EE90");H2=0;sitDelect("H2");}
    }

    @FXML
    private void i1Action(ActionEvent event) {
if(I1==0){i1.setStyle("-fx-background-color: efc564");I1=1; sitAdd("I1");}else{i1.setStyle("-fx-background-color: 90EE90");I1=0;sitDelect("I1");}
    }

    @FXML
    private void j1Action(ActionEvent event) {
if(J1==0){j1.setStyle("-fx-background-color: efc564");J1=1; sitAdd("J1");}else{j1.setStyle("-fx-background-color: 90EE90");J1=0;sitDelect("J1");}
    }

    @FXML
    private void i2Action(ActionEvent event) {
if(I2==0){i2.setStyle("-fx-background-color: efc564");I2=1; sitAdd("I2");}else{i2.setStyle("-fx-background-color: 90EE90");I2=0;sitDelect("I2");}
    }

    @FXML
    private void j2Action(ActionEvent event) {
if(J2==0){j2.setStyle("-fx-background-color: efc564");J2=1; sitAdd("J2");}else{j2.setStyle("-fx-background-color: 90EE90");J2=0;sitDelect("J2");}
    }

    @FXML
    private void b3Action(ActionEvent event) {
         if(B3==0){b3.setStyle("-fx-background-color: efc564");B3=1;sitAdd("B3");}else{b3.setStyle("-fx-background-color: 90EE90");B3=0;sitDelect("B3");}
    }

    @FXML
    private void c3Action(ActionEvent event) {
        
if(C3==0){c3.setStyle("-fx-background-color: efc564");C3=1; sitAdd("C3");}else{c3.setStyle("-fx-background-color: 90EE90");C3=0;sitDelect("C3");}
    }

    @FXML
    private void d3Action(ActionEvent event) {
if(D3==0){d3.setStyle("-fx-background-color: efc564");D3=1; sitAdd("D3");}else{d3.setStyle("-fx-background-color: 90EE90");D3=0;sitDelect("D3");}
    }

    @FXML
    private void e3Action(ActionEvent event) {
if(E3==0){e3.setStyle("-fx-background-color: efc564");E3=1; sitAdd("E3");}else{e3.setStyle("-fx-background-color: 90EE90");E3=0;sitDelect("E3");}
    }

    @FXML
    private void f3Action(ActionEvent event) {
if(F3==0){f3.setStyle("-fx-background-color: efc564");F3=1; sitAdd("F3");}else{f3.setStyle("-fx-background-color: 90EE90");F3=0;sitDelect("F3");}
    }

    @FXML
    private void g3Action(ActionEvent event) {
if(G3==0){g3.setStyle("-fx-background-color: efc564");G3=1; sitAdd("G3");}else{g3.setStyle("-fx-background-color: 90EE90");G3=0;sitDelect("G3");}
    }

    @FXML
    private void h3Action(ActionEvent event) {
if(H3==0){h3.setStyle("-fx-background-color: efc564");H3=1; sitAdd("H3");}else{h3.setStyle("-fx-background-color: 90EE90");H3=0;sitDelect("H3");}
    }

    @FXML
    private void b4Action(ActionEvent event) {
         if(B4==0){b4.setStyle("-fx-background-color: efc564");B4=1;sitAdd("B4");}else{b4.setStyle("-fx-background-color: 90EE90");B4=0;sitDelect("B4");}
    }

    @FXML
    private void c4Action(ActionEvent event) {
        
if(C4==0){c4.setStyle("-fx-background-color: efc564");C4=1; sitAdd("C4");}else{c4.setStyle("-fx-background-color: 90EE90");C4=0;sitDelect("C4");}
    }

    @FXML
    private void d4Action(ActionEvent event) {
if(D4==0){d4.setStyle("-fx-background-color: efc564");D4=1; sitAdd("D4");}else{d4.setStyle("-fx-background-color: 90EE90");D4=0;sitDelect("D4");}
    }

    @FXML
    private void e4Action(ActionEvent event) {
if(E4==0){e4.setStyle("-fx-background-color: efc564");E4=1; sitAdd("E4");}else{e4.setStyle("-fx-background-color: 90EE90");E4=0;sitDelect("E4");}
    }

    @FXML
    private void f4Action(ActionEvent event) {
if(F4==0){f4.setStyle("-fx-background-color: efc564");F4=1; sitAdd("F4");}else{f4.setStyle("-fx-background-color: 90EE90");F4=0;sitDelect("F4");}
    }

    @FXML
    private void g4Action(ActionEvent event) {
if(G4==0){g4.setStyle("-fx-background-color: efc564");G4=1; sitAdd("G4");}else{g4.setStyle("-fx-background-color: 90EE90");G4=0;sitDelect("G4");}
    }

    @FXML
    private void h4Action(ActionEvent event) {
if(H4==0){h4.setStyle("-fx-background-color: efc564");H4=1; sitAdd("H4");}else{h4.setStyle("-fx-background-color: 90EE90");H4=0;sitDelect("H4");}
    }

    @FXML
    private void i3Action(ActionEvent event) {
if(I3==0){i3.setStyle("-fx-background-color: efc564");I3=1; sitAdd("I3");}else{i3.setStyle("-fx-background-color: 90EE90");I3=0;sitDelect("I3");}
    }

    @FXML
    private void j4Action(ActionEvent event) {
if(J4==0){j4.setStyle("-fx-background-color: efc564");J4=1; sitAdd("J4");}else{j4.setStyle("-fx-background-color: 90EE90");J4=0;sitDelect("J4");}
    }

    @FXML
    private void i4Action(ActionEvent event) {
if(I4==0){i4.setStyle("-fx-background-color: efc564");I4=1; sitAdd("I4");}else{i4.setStyle("-fx-background-color: 90EE90");I4=0;sitDelect("I4");}
    }

    @FXML
    private void j5Action(ActionEvent event) {
if(J5==0){j5.setStyle("-fx-background-color: efc564");J5=1; sitAdd("J5");}else{j5.setStyle("-fx-background-color: 90EE90");J5=0;sitDelect("J5");}
    }

    @FXML
    private void j3Action(ActionEvent event) {
if(J3==0){j3.setStyle("-fx-background-color: efc564");J3=1; sitAdd("J3");}else{j3.setStyle("-fx-background-color: 90EE90");J3=0;sitDelect("J3");}
    }

    private void histryBtnAction(ActionEvent event) throws IOException {
        
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("history.fxml"));
    Parent root1 = (Parent) fxmlLoader.load();
    Stage stage = new Stage();
    stage.setTitle("History");
     stage.setResizable(false);
    stage.setScene(new Scene(root1));  
    stage.maximizedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue)
                stage.setMaximized(true);
        });
    stage.show();

    }

    @FXML
    private void labelAction(MouseEvent event) throws IOException {
        
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("history.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("History");
        stage.setResizable(false);
        stage.setScene(new Scene(root1));  
        stage.maximizedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue)
                stage.setMaximized(true);
        });
        stage.show();
    }

    @FXML
    private void hisMouseExit(MouseEvent event) {
        hislabel.setTextFill(Color.web("#ffa700"));
    }

    @FXML
    private void hisMouseEntry(MouseEvent event) {
        
        hislabel.setTextFill(Color.web("#0025ff"));
    }

    @FXML
    private void logoutMouseExit(MouseEvent event) {
        logoutlabel.setTextFill(Color.web("#ffa700"));
    }

    @FXML
    private void logoutMouseEnter(MouseEvent event) {
        logoutlabel.setTextFill(Color.web("#0025ff"));
    }

    @FXML
    private void logoutlabelAction(MouseEvent event) throws IOException {
        
        session="";
        Stage stage = (Stage) logoutlabel.getScene().getWindow();
            stage.close();
        login();
         
    }
    
    public void login() throws IOException{
       
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Login");
        stage.setResizable(false);
        stage.setScene(new Scene(root1));  
        stage.maximizedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue)
                stage.setMaximized(true);
        });
    stage.show();
    
    }

    @FXML
    private void lockMouseExit(MouseEvent event) {
        locklabel.setTextFill(Color.web("#ffa700"));
    }

    @FXML
    private void lockMouseEnter(MouseEvent event) {
        locklabel.setTextFill(Color.web("#0025ff"));
    }

    @FXML
    private void locklabelAction(MouseEvent event) {
        locksceen.setVisible(true);
    }

    @FXML
    private void unlockBtnAction(ActionEvent event) {
        String s_pass = passwordEncryption.NoSuchAlgorithmException(unlockpassBox.getText());
       if(( DBConnect.userLogin(userID,s_pass))==true)
            locksceen.setVisible(false);
       unlockpassBox.setText("");
    }

   

    


   
    
}
