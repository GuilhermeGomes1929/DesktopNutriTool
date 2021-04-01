/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nutritionalprogram.Model.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import nutritionalprogram.Model.entity.BasicPatientInfoModel;
import nutritionalprogram.Model.entity.BodyPatientModel;

/**
 *
 * @author Luana Franciele
 */
public class PatientDao {
    
   
    private ConnectDatabase connectDatabase;
    
    public PatientDao(){
        connectDatabase = new ConnectDatabase();
    }
    
    public void createTable(String dbName){
        
        String basicInfos = "CREATE TABLE IF NOT EXISTS "
                + "basicInfos(id INTEGER PRIMARY KEY autoincrement,"
                + " name TEXT, age INTEGER, hight INTEGER, sex TEXT );";
        String bodyInfos = "CREATE TABLE IF NOT EXISTS "
                + "bodyInfos(id INTEGER PRIMARY KEY autoincrement,"
                + "currentWeight REAL, goalWeight REAL, bodyfat REAL,"
                + "shoulders INTEGER, chest INTEGER, leftArm INTEGER,"
                + "rightArm INTEGER, waist INTEGER, hip INTEGER, leftLeg INTEGER,"
                + "rightLeg INTEGER, leftCalf INTEGER, rightCalf INTEGER, date INTEGER);";
        
        try{
                if(connectDatabase.connect(dbName)){
                    Statement stmt = connectDatabase.getStatement();
                    stmt.execute(basicInfos);
                    stmt.execute(bodyInfos);

                    stmt.close();
                    connectDatabase.disconnect();
                
                }else{
                    System.out.print("É isso");
                }

                

            }catch(SQLException e){

            }
        
    }
    
    public boolean insertBasicInfos(String dbName, BasicPatientInfoModel basicInfo){
       
        String sqlInsert = "INSERT INTO basicInfos ("
                + "id, "
                + "name, "
                + "age,"
                + "hight,"
                + "sex) "
                + "VALUES(?,?,?,?,?);";
        
        
        
        try{
            
            connectDatabase.connect(dbName);
            PreparedStatement preparedStatement = connectDatabase.getPreparedStatement(sqlInsert);
            
            preparedStatement.setString(2, basicInfo.getName());
            preparedStatement.setInt(3, basicInfo.getAge());
            preparedStatement.setFloat(4, basicInfo.getHight());
            preparedStatement.setString(5, basicInfo.getSex());
            
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
            System.out.print(e.getMessage());
            return false;
        }
        
        
    }
    
    public boolean insertBodyInfos(String dbName, BodyPatientModel bodyInfo){
        
        String sqlInsert = "INSERT INTO bodyInfos ("
                + "id, "
                + "currentWeight, "
                + "goalWeight,"
                + "bodyfat,"
                + "shoulders,"
                + "chest, "
                + "leftArm,"
                + "rightArm,"
                + "waist, "
                + "hip, "
                + "leftLeg,"
                + "rightLeg,"
                + "leftCalf,"
                + "rightCalf, "
                + "date) "
                + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?, ?);";
        
        try{
            
            connectDatabase.connect(dbName);
            PreparedStatement preparedStatement = connectDatabase.getPreparedStatement(sqlInsert);
            
            preparedStatement.setFloat(2,bodyInfo.getCurrentWeight());
            preparedStatement.setFloat(3, bodyInfo.getGoalWeight());
            preparedStatement.setFloat(4, bodyInfo.getBodyfat());
            preparedStatement.setInt(5, bodyInfo.getShoulders());
            preparedStatement.setInt(6, bodyInfo.getChest());
            preparedStatement.setInt(7, bodyInfo.getLeftArm());
            preparedStatement.setInt(8, bodyInfo.getRightArm());
            preparedStatement.setInt(9, bodyInfo.getWaist());
            preparedStatement.setInt(10, bodyInfo.getHip());
            preparedStatement.setInt(11, bodyInfo.getLeftLeg());
            preparedStatement.setInt(12, bodyInfo.getRightLeg());
            preparedStatement.setInt(13, bodyInfo.getLeftCalf());
            preparedStatement.setInt(14, bodyInfo.getRightCalf());
            preparedStatement.setLong(15, bodyInfo.getDate());
            
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
    
}
