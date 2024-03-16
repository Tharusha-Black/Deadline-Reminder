/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import database.DatabaseHandler;
import deadlinereminder.DeadlineReminderHomeController;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author ST
 */


public class ViewController implements Initializable {

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    
    
    ObservableList<DRS> list = FXCollections.observableArrayList();
    @FXML
    private TableView<DRS> tablePane;
    @FXML
    private TableColumn<DRS,String> idCol;
    @FXML
    private TableColumn<DRS,String> nameCol;
    @FXML
    private TableColumn<DRS,String> startCol;
    @FXML
    private TableColumn<DRS,String> endCol;
    
    DatabaseHandler Handler;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Handler = new DatabaseHandler();
        loadData();
        intCol();
    }   
    private void loadData() {
        list.clear();
        String qu = "SELECT * FROM DRS";
        ResultSet rs = Handler.execQuery(qu);
        try{
            while (rs.next()){
                String id = rs.getString("id");
                String name = rs.getString("name");
                String startdate = rs.getString("startdate");
                String enddate = rs.getString("enddate");
                
                list.add(new ViewController.DRS(id, name, startdate, enddate));
            }
        }catch (SQLException ex){
            Logger.getLogger(DeadlineReminderHomeController.class.getName()).log(Level.SEVERE, null,ex);
        }
        
        tablePane.getItems().setAll(list);
        
    }
    @FXML
    private void refreshData(ActionEvent event) {
        loadData();
        
  }
    public static class DRS{
        private final SimpleStringProperty id;
        private final SimpleStringProperty name;
        private final SimpleStringProperty startdate;
        private final SimpleStringProperty enddate;
        
        DRS(String id,String name,String startdate,String enddate){
            this.id = new SimpleStringProperty(id);
            this.name = new SimpleStringProperty(name);
            this.startdate = new SimpleStringProperty(startdate);
            this.enddate = new SimpleStringProperty(enddate); 
        }

        public String getId() {
            return id.get();
        }

        public String getName() {
            return name.get();
        }

        public String getStartdate() {
            return startdate.get();
        }

        public String getEnddate() {
            return enddate.get();
        }
        
               
    }
        private void intCol() {
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        startCol.setCellValueFactory(new PropertyValueFactory<>("startdate"));
        endCol.setCellValueFactory(new PropertyValueFactory<>("enddate"));
    }
    
}
