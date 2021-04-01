/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nutritionalprogram.Model.dao;


import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Luana Franciele
 */
public class ConnectDatabase {
    
    private Connection connection;
    
    public boolean connect(String fileName){
        
        String url = "jdbc:sqlite:" + System.getProperty("user.dir")+"\\pacientes\\"+fileName+".db";
        
        try{
            
            connection = DriverManager.getConnection(url);
            
            if(connection != null){
                DatabaseMetaData meta = connection.getMetaData();
                
            }
            return true;
        }catch(Exception e){
            
            return false;
        }
    }
    
    public boolean disconnect(){
        try{
            if(connection.isClosed() == false){
                connection.close();
            }
        }catch(SQLException e){
            
            return false;
        }
        return true;
    }
    
    public Statement getStatement(){
        try{
            return this.connection.createStatement();
            
        }catch(SQLException e){
            return null;
        }
    
    }
    
    public Connection getConnection(){
        return this.connection;
    }
    
    public PreparedStatement getPreparedStatement(String sql){
        try{
            return this.connection.prepareStatement(sql);
        }catch(SQLException e){
            System.out.print(e.getMessage());
            return null;
        }
    }
    
}
