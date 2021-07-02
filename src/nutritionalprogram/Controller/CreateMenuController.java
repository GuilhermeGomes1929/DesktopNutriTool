/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nutritionalprogram.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import nutritionalprogram.Model.entity.FoodModel;
import nutritionalprogram.Model.entity.MenuModel;
import nutritionalprogram.Model.service.CreateMenuService;
import nutritionalprogram.View.CreateMenuPanel;

/**
 *
 * @author Luana Franciele
 */
public class CreateMenuController {
    
    private CreateMenuPanel menuPanel;
    private JScrollPane scrollPanel;
    private CreateMenuService service;
    private ArrayList<MenuModel> menuModelList;
    private ArrayList<Integer> places;
    
    public CreateMenuController(CreateMenuPanel menuPanel){
        this.menuPanel = menuPanel;
        this.scrollPanel = menuPanel.getScrollPanel();
        this.service = new CreateMenuService();
        this.menuModelList = new ArrayList<MenuModel>();
        
        menuPanel.getNameLabel().setText(menuPanel.getPatientName());
        configFoodGroups();
        configButtons();
        
    }
    
    public void prepareToSave(){
        MenuModel menuModel = new MenuModel();
        menuModel.setMeal(menuPanel.getCbMeal().getSelectedItem().toString());
        menuModel.setFoodGroup(menuPanel.getCbFoodGroup().getSelectedIndex());
        menuModel.setFood(menuPanel.getCbFoodName().getSelectedIndex());
        menuModel.setPortion(Float.parseFloat(menuPanel.getSpinPortion().getValue().toString()));
        menuModel.setSubs(getSubs(menuPanel.getCheckSubstitutions().isSelected()));
        
        menuModelList.add(menuModel);
        updateMenuView();
      
    }
    
    public void updateMenuView(){
        DefaultListModel<String> listModel = new DefaultListModel<String>();
        ArrayList<String> table = service.getAllFoodGroupName("\\lista\\foodlist");
        places = new ArrayList<Integer>();
        
        for(int i = 0; i < menuModelList.size(); i++){
            
            if(menuModelList.get(i).getMeal().equals(menuPanel.getCbMeal().getSelectedItem().toString())){
                FoodModel foodModel = service.getFood("\\lista\\foodlist",
                        table.get(menuModelList.get(i).getFoodGroup()),
                        menuModelList.get(i).getFood()+1);
                listModel.addElement(menuModelList.get(i).getPortion() * foodModel.getWeight() +
                        "g de " +
                        foodModel.getFoodName());
                places.add(i);
            }
        }
        menuPanel.getListShowMenu().setModel(listModel);
    }
    
    public void deleteItemFromList(){
        try{
            int index = places.get(menuPanel.getListShowMenu().getSelectedIndex());
            menuModelList.remove(index);
            
        }catch(Exception e){
            int result = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja limpar toda a lista?", "Atenção!", JOptionPane.YES_NO_OPTION);
            if(result == JOptionPane.YES_OPTION){
                for(int i = menuModelList.size() - 1; i >= 0 ; i--){
                    if(menuModelList.get(i).getMeal().equals(menuPanel.getCbMeal().getSelectedItem().toString())){
                        menuModelList.remove(i);
                    }
                }
            }
        }
    }
    
    public void saveMenu(){
        if(menuPanel.getTfName().getText().equals("")){
            JOptionPane.showMessageDialog(null, "Preencha o nome do cardápio e tente novamente."
                    , "Atenção!", JOptionPane.OK_OPTION);
        }else{
            if(service.saveMenu("\\cardápios\\"+menuPanel.getTfName().getText(), menuModelList)){
                JOptionPane.showMessageDialog(null, "Cardápio salvo com sucesso!");
            }else{
                JOptionPane.showMessageDialog(null, "Algo de errado ocorreu... Tente novamente!");
            }
        }
        
    }
    
    public void configFoodGroups(){
        ArrayList<String> foodGroupNames = service.getAllFoodGroupName("\\lista\\foodlist");
        for(int i = 0; i < foodGroupNames.size(); i++){
            menuPanel.getCbFoodGroup().addItem(foodGroupNames.get(i));
        }
        configFoodNames();
        menuPanel.getCbFoodGroup().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                configFoodNames();
            }
        });
    }
    
    public void configFoodNames(){
        int index = menuPanel.getCbFoodGroup().getSelectedIndex();
        menuPanel.getCbFoodName().removeAllItems();;
        ArrayList<String> groups = service.getAllFoodGroupName("\\lista\\foodlist");
        
        ArrayList<String> datas = new ArrayList<String>();
        datas = service.getAllFoodNames("\\lista\\foodlist", groups.get(index));
        
        for(int i = 0; i < datas.size(); i++){
            menuPanel.getCbFoodName().addItem(datas.get(i));
        }
    }
    
    
    
    
    public Integer getSubs(boolean status){
        if(status){ return 1; }
        else{ return 0; }
    }
    
    public void configButtons(){
        menuPanel.getAddMenuBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                prepareToSave();
            }
        });
        
        menuPanel.getCbMeal().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateMenuView();
            }
        });
        
        menuPanel.getBtnDeleteAll().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteItemFromList();
                updateMenuView();
            }
        });
        
        menuPanel.getSaveBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveMenu();
            }
        });
        
        menuPanel.getCancelBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showInternalConfirmDialog(null, "Tem certeza que deseja cancelar?", "Atenção!", JOptionPane.YES_NO_OPTION);
                if(result == JOptionPane.YES_OPTION){
                    menuPanel.getScrollPanel().setViewportView(menuPanel.getPatientPanel());
                }
            }
        });
    }
    
}
