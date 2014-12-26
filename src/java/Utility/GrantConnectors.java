/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author audax
 */
public class GrantConnectors {
    
    
      private String user, pas, conString, DBurl;

      private Connection con;
      
      
      public GrantConnectors(){
          
          
        user = "root";
        //pas = "audax338";
        pas = "ajb98AWqk";
        //conString = "org.mariadb.jdbc.Driver";
        conString = "com.mysql.jdbc.Driver";
        //DBurl = "jdbc:mariadb://localhost/finalDBB";
        DBurl = "jdbc:mysql://localhost/finalDB";
          
          
      }
      
      
        public Connection getConnection() throws InstantiationException, IllegalAccessException {

        try {
            
            try {
                
                Class.forName(conString).newInstance();
                
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(GrantConnectors.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            con = DriverManager.getConnection(DBurl, user, pas);
            
            if (con != null)
            {
                //JOptionPane.showMessageDialog(null, "Connected");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(GrantConnectors.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return con;
    }
     
   
     
     public static void main(String [] args)
     {
         
             try {
                 GrantConnectors mio = new GrantConnectors();
                 
                 mio.getConnection();
             } catch (InstantiationException ex) {
                 Logger.getLogger(GrantConnectors.class.getName()).log(Level.SEVERE, null, ex);
             } catch (IllegalAccessException ex) {
                 Logger.getLogger(GrantConnectors.class.getName()).log(Level.SEVERE, null, ex);
             }
         
     }
    
}
