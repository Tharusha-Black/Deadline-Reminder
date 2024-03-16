/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deadlinereminder;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

/**
 *
 * @author ST
 */
public class DeadlineReminderHomeController implements Initializable {
    
    private Label label;
    @FXML
    private AnchorPane mPane1;
    @FXML
    private AnchorPane mPane2;
    @FXML
    private Text dates;
    @FXML
    private Text client;
    @FXML
    private Button insert;
    @FXML
    private Button update;
    @FXML
    private Button delete;
    @FXML
    private Button view;
    @FXML
    private Button home;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         DeadlineShow();
    }    

    @FXML
    private void loadInsertWindow(ActionEvent event) throws IOException{
       // loadWindow("","Insert Reminder");

            AnchorPane pane = FXMLLoader.load(getClass().getResource("/insert/Insert.fxml"));
            mPane2.getChildren().setAll(pane);

         

    }

    @FXML
    private void loadUpdateWindow(ActionEvent event) throws IOException{
        //loadWindow("/update/Update.fxml","Update Reminder");
       AnchorPane pane = FXMLLoader.load(getClass().getResource("/update/Update.fxml"));
       mPane2.getChildren().setAll(pane);
    }

    @FXML
    private void loadDeleteWindow(ActionEvent event) throws IOException {
       // loadWindow("/delete/Delete.fxml","Delete Reminder");
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/delete/Delete.fxml"));
        mPane2.getChildren().setAll(pane);
    }

    @FXML
    private void loadViewWindow(ActionEvent event) throws IOException {
        //loadWindow("/view/view.fxml","View Reminder");
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/view.fxml"));
        mPane2.getChildren().setAll(pane);
    }

    private void DeadlineShow(){
        Deadline dead = new Deadline();
            client.setText(dead.getName());
            dates.setText("" + dead.Count() + "");
            
                 
            
    }

    @FXML
    private void loadHomeWindow(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/drs/Main.fxml"));
        mPane1.getChildren().setAll(pane);
    }

    
    
}
