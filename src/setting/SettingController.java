/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package setting;

import java.io.IOException;
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
public class SettingController implements Initializable {

    @FXML
    private Button apply1;
    @FXML
    private Button apply2;
    @FXML
    private Text txt1;
    @FXML
    private Text txt2;
    @FXML
    private AnchorPane setPane1;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
        @FXML
    public void loadThemeOne(ActionEvent event) throws IOException {

    }

    @FXML
    public void loadThemeTwo(ActionEvent event) throws IOException {

    }
   
}
