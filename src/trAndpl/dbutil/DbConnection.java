/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trAndpl.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class DbConnection {
    
    private final static String DB_URL="jdbc:mysql://database-1.co0qfrus1fqz.ap-south-1.rds.amazonaws.com/sys";
    private final static String DB_User_Name="TrAndPl";
    private final static String DB_Pwd="Project123";
    private static Connection conn;
    static{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn=DriverManager.getConnection(DB_URL,DB_User_Name,DB_Pwd);
            JOptionPane.showMessageDialog(null, "Connected Succesfully to DB!");
         }
        catch(ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null, "Error in Driver Loading"+ex.getMessage());
            ex.printStackTrace();
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error in Openning to Connect DB!"+ex.getMessage());
            ex.printStackTrace();
        }
      }
    public static Connection getConnection(){
          return conn;
        }
    public static void closeConnection(){
        try{
            conn.close();
            JOptionPane.showMessageDialog(null, "DisConnected successfully from the DB");
        }
        catch(SQLException ex){
                    JOptionPane.showMessageDialog(null, "Error in closing the conn to DB:"+ex.getMessage());
                    ex.printStackTrace();
      }
    }
}
    

