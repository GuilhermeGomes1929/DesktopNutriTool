/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nutritionalprogram.Model.service;

import java.util.ArrayList;
import nutritionalprogram.Model.dao.MenuDao;
import nutritionalprogram.Model.entity.FoodModel;
import nutritionalprogram.Model.entity.MenuModel;

/**
 *
 * @author Luana Franciele
 */
public class CreateMenuService {
    
    private MenuDao dao;
    
    public CreateMenuService(){
        dao = new MenuDao();
    }
    
    public ArrayList<String> getAllFoodGroupName(String foodList){
        return dao.getTableNames(foodList);
    }
    
    public ArrayList<String> getAllFoodNames(String dbName, String tableName){
        return dao.getAllFoodName(dbName, tableName);
    }
    
    public FoodModel getFood(String dbName, String table, int id){ 
        return dao.getFoodModelFromId(dbName, table, id);
    }
    
    public boolean saveMenu(String dbName, ArrayList<MenuModel> menuModelList){
        
        try{
            dao.createTable(dbName);
            for(int i = 0 ; i < menuModelList.size(); i++){
                dao.insertData(dbName, menuModelList.get(i).getMeal(), menuModelList.get(i).getFoodGroup(),
                        menuModelList.get(i).getFood(), menuModelList.get(i).getPortion(), menuModelList.get(i).getSubs());
            }
            return true;
        }catch(Exception e){
            return false;
        }   
    }
}
