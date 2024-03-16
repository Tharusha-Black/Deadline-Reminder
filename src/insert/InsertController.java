/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insert;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import database.DatabaseHandler;
import java.net.URL;
import java.time.LocalDate;
import static java.time.temporal.TemporalQueries.localDate;
import java.util.Date;
//import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author ST
 */
public class InsertController implements Initializable {

    @FXML
    private JFXTextField name;
    @FXML
    private JFXDatePicker sdate;
    @FXML
    private JFXDatePicker edate;
    @FXML
    private Button submit;
    @FXML
    private JFXTextField id;

    /**
     * Initializes the controller class.
     */
    DatabaseHandler Handler;
    @FXML
    private Button demo;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Handler = new DatabaseHandler();
    }    
    
    @FXML
    public void submit(ActionEvent event){
        
        String Did = id.getText();
        String Dname = name.getText();        
        LocalDate Dedate = edate.getValue();
        LocalDate Dsdate = sdate.getValue();
        
        if(Did.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please Enter in All Fields!");
            alert.showAndWait();
            id.setText(" ");
            return;
        }else if (Dname.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please Enter in All Fields!");
            name.setText(" ");
            alert.showAndWait();
        }
        if(Did.length()< 5 || Did.length() > 5){
             Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Enter 5 numbers id!");
            alert.showAndWait();
            id.setText("");
            return;
        }
        if(Did.matches("[a-zA-Z]+")){
             Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Enter 5 numbers only!");
            alert.showAndWait();
            id.setText("");
            return;
        }
 
        
       
        String qu = "INSERT INTO DRS VALUES("+
                "'" + Did + "'," +
                "'" + Dname +  "'," +
                "'" + Dsdate +"'," +
                "'" + Dedate +"'"+")"; 
        
        System.out.println(qu);
        
        if (Handler.execAction(qu)){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("SUCCESS");
            alert.showAndWait();
            
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("FAIL");
            alert.showAndWait();
        }
       
    }

    @FXML
    private void onClickDemo(ActionEvent event) {
        id.setText("10011");
        name.setText("udana");
        sdate.setValue(LocalDate.ofYearDay(2018, 12));
        edate.setValue(LocalDate.ofYearDay(2019, 12));
       
    }
        
 }
 
