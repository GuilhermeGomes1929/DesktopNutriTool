/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nutritionalprogram.Model.dao;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import nutritionalprogram.Model.entity.FoodModel;
        
        

/**
 *
 * @author Luana Franciele
 */
public class MenuDao {
    
    private ConnectDatabase connectDatabase;
    
    public MenuDao(){
        connectDatabase = new ConnectDatabase();
    }
    
    public void createTable(String dbName){
        
        String[] tableList = new String[]{"café da manhã", "lanche", "almoço", "lanche da tarde", "jantar", "ceia"}; 
        
        
        for(int i = 0; i < tableList.length; i ++){
            
            String sql = "CREATE TABLE IF NOT EXISTS ["+ tableList[i] + "] (id integer PRIMARY KEY autoincrement, foodgroup integer, food integer, portion double, subs integer);";
        
            
            try{
                connectDatabase.connect(dbName);

                Statement stmt = connectDatabase.getStatement();
                stmt.execute(sql);

                stmt.close();
                connectDatabase.disconnect();

            }catch(SQLException e){

            }
        
        }
        
        
        
        
    }
    
    public boolean insertData(String dbName, String tableName, int foodgroup, int food, double portion, int subs){
        
        
        String sqlInsert = "INSERT INTO ["+ tableName+"] ("
                + "id, "
                + "foodgroup,"
                + "food,"
                + "portion,"
                + "subs) "
                + "VALUES(?,?,?,?,?);";
        
        
        
        try{
            
            connectDatabase.connect(dbName);
            PreparedStatement preparedStatement = connectDatabase.getPreparedStatement(sqlInsert);
            
            preparedStatement.setInt(2, foodgroup);
            preparedStatement.setInt(3, food);
            preparedStatement.setDouble(4, portion);
            preparedStatement.setInt(5, subs);
            
            int result = preparedStatement.executeUpdate();
            if(result == 1){
                preparedStatement.close();
                connectDatabase.disconnect();
                
                return true;
            }else{
                preparedStatement.close();
                connectDatabase.disconnect();
                return false;
            }
            
                
        }catch(SQLException e){
           
            return false;
        }
    }
    
    public ArrayList<String> getTableNames(String dbName){
        ArrayList<String> tableNames = new ArrayList<String>();
        
       
        
        try{
            connectDatabase.connect(dbName);
            Connection conn = connectDatabase.getConnection();
            
            ResultSet resultset = conn.getMetaData().getTables(null, null, null, null);
            while(resultset.next()){
                tableNames.add(resultset.getString("TABLE_NAME"));
            }
            resultset.close();
            connectDatabase.disconnect();
            return tableNames;
        
        }catch(SQLException e){
            
        }
            
        return null;
    }
    
    public ArrayList<String> getAllFoodName(String dbName, String tableName){
        
       
        ArrayList<String> foodNames = new ArrayList<String>();
        
        try{
            connectDatabase.connect(dbName);
            String query = "SELECT foodname FROM ["+ tableName+"]";
        
            Statement stmt = connectDatabase.getStatement();
            
            ResultSet resultset = stmt.executeQuery(query);
            
            while(resultset.next()){
                foodNames.add(resultset.getString("foodname"));
            }
            resultset.close();
            stmt.close();
            connectDatabase.disconnect();
            return foodNames;
        }catch(SQLException e){
            
            return null;
        }
    }
    
    public FoodModel getFoodModelFromId(String dbName, String tableName, int id){
        
        
        String sql = "SELECT * FROM ["+tableName+"] WHERE id = ?";
        
        try{
            FoodModel foodModel = new FoodModel();
            connectDatabase.connect(dbName);
            
            
            PreparedStatement preparedStmt = connectDatabase.getPreparedStatement(sql);
            preparedStmt.setInt(1, id);
            
            ResultSet resultset = preparedStmt.executeQuery();
            
            while(resultset.next()){
                foodModel.setId(resultset.getInt("id"));
                foodModel.setFoodName(resultset.getString("foodname"));
                foodModel.setWeight(resultset.getInt("weight"));
                foodModel.setHomeMeasure(resultset.getString("homemeasure"));
                foodModel.setCalories(resultset.getInt("calories"));
                foodModel.setHomePortions(resultset.getDouble("homeportions"));
                
                
            }
            resultset.close();
            preparedStmt.close();
            connectDatabase.disconnect();
            return foodModel;
            
        
        }catch(SQLException e){
           
            return null;
        }
    }
    
    
}
