/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delete;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import database.DatabaseHandler;
import java.time.LocalDate;
/**
 * FXML Controller class
 *
 * @author ST
 */
public class DeleteController implements Initializable {

    @FXML
    private Button Delete;
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
    private void handleDeleteOp(ActionEvent event) {
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
            id.setText(" ");
            return;
        }
        if(Did.matches("[a-zA-Z]+")){
             Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Enter 5 numbers only!");
            alert.showAndWait();
            id.setText("");
            return;
        }
        
        String dc = "DELETE FROM DRS WHERE id = '"+Did+"'";
        Handler.execAction(dc);
        
            if (Handler.execAction(dc)){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("DELETED");
            alert.showAndWait();
            
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("FAIL");
            alert.showAndWait();
        }
    }

    @FXML
    private void handleDeleteOp(KeyEvent event) {
    }

    @FXML
    private void onCllickDemo(ActionEvent event) {
                id.setText("10011");

    }
    
}
