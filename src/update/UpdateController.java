/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package update;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import database.DatabaseHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

/**
 * FXML Controller class
 *
 * @author ST
 */
public class UpdateController implements Initializable {

    @FXML
    private JFXDatePicker edate;
    @FXML
    private Button Update;
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
    private void loadRenewOp(ActionEvent event) {
        String Did = id.getText();
        if(Did.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please Enter in All Fields!");
            alert.showAndWait();
            id.setText(" ");
            return;
        }
        if(Did.length()< 5 || Did.length() > 5){
             Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Enter 5 numbers id!");
            alert.showAndWait();
            id.setText("");
            return;
        }
        if(Did.matches("[a-zA-Z0-9]+")){
             Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Enter 5 numbers only!");
            alert.showAndWait();
            id.setText("");
            return;
        }
        LocalDate Dedate = edate.getValue();
        //String Dedate = ((TextField)edate.getEditor()).getText();
        String ac = "UPDATE DRS SET enddate = '"+Dedate+"' WHERE id = '"+Did+"'";
        Handler.execAction(ac);
        
    if (Handler.execAction(ac)){
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
    private void loadRenewOp(KeyEvent event) {
    }

    @FXML
    private void onClickDemo(ActionEvent event) {
                id.setText("10011");
                edate.setValue(LocalDate.ofYearDay(2020, 12));
    }
    
}
