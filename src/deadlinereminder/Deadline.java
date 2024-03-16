/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deadlinereminder;

/**
 *
 * @author ST
 */


import database.DatabaseHandler;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.util.Duration;


public class Deadline {
    public static void main(String args[]){
        
    }
    public Date getDate() throws SQLException{
         DatabaseHandler Handler;
         Handler = new DatabaseHandler();
         Date edate = null;
         ResultSet rs;
         String q = "SELECT MIN(enddate) FROM DRS";
         rs = Handler.execQuery(q);
         
         try{
         while (rs.next()){
            edate = rs.getDate("MIN(enddate)");
            }
               } catch (SQLException ex) {
            Logger.getLogger(Deadline.class.getName()).log(Level.SEVERE, null, ex);
        }
        return edate;
    }
    public String getName(){
        String ed = "error";
        try {
             ed = getDate().toString();
        } catch (SQLException ex) {
            Logger.getLogger(Deadline.class.getName()).log(Level.SEVERE, null, ex);
        }
        DatabaseHandler Handler;
        Handler = new DatabaseHandler();
        ResultSet rs;
        
        String q = "SELECT name FROM DRS WHERE enddate = '" + ed + "'";
        rs = Handler.execQuery(q);
        String name = "error";
        try {
            while (rs.next()){
            name = rs.getString("name");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Deadline.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        return name;
        
    }
    public int Count(){
        Date edate = null;
        int db = 0;
        try {
            edate = getDate();
        } catch (SQLException ex) {
            Logger.getLogger(Deadline.class.getName()).log(Level.SEVERE, null, ex);
        }
            Date today = new Date();
            long diff = edate.getTime() - today.getTime();
            
            db = (int) (diff / (1000*60*60*24));
            

            return db;
    }
}



