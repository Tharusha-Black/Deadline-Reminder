/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drs;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author ST
 */
public class MainController implements Initializable {

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void loadInsertWindow(ActionEvent event) {
    }

    @FXML
    private void loadUpdateWindow(ActionEvent event) {
    }

    @FXML
    private void loadDeleteWindow(ActionEvent event) {
    }

    @FXML
    private void loadViewWindow(ActionEvent event) {
    }

    @FXML
    private void loadHomeWindow(ActionEvent event) {
    }
    
}
