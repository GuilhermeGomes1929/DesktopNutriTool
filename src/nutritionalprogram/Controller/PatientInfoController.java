/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nutritionalprogram.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import nutritionalprogram.Model.entity.BasicPatientInfoModel;
import nutritionalprogram.Model.entity.BodyPatientModel;
import nutritionalprogram.Model.service.PatientService;
import nutritionalprogram.View.AddInfoPanel;
import nutritionalprogram.View.CreateMenuPanel;
import nutritionalprogram.View.PatientPanel;

/**
 *
 * @author Luana Franciele
 */
public class PatientInfoController {
    
    private PatientPanel patientPanel;
    private ArrayList<Integer> numberOfInfos;
    private int cursor;
    private PatientService service;
    private String patientName;
    private AddInfoPanel addInfoPanel;
    
    
    public PatientInfoController(PatientPanel patientPanel){
        
        this.patientPanel = patientPanel;
        this.service = new PatientService();
        this.patientName = this.patientPanel.getPatientName();
        this.numberOfInfos = service.getCursor(patientName);
        this.cursor = numberOfInfos.size() - 1;
        
        init();
    }
    
    public void init(){
        configBasicInfo();
        configBodyInfo();
        configInfoBtn();
        configAddAndDelBtn();
        configMenuBtn();
    }
    
    public void configMenuBtn(){
        
        patientPanel.getCreateMenuBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreateMenuPanel createMenuPanel = new CreateMenuPanel(patientPanel.getScrollPanel(),
                        patientName, patientPanel);
                patientPanel.getScrollPanel().setViewportView(createMenuPanel);
            }
        });
    }
    
    public void configBasicInfo(){
        BasicPatientInfoModel basicInfo = service.getBasicInfos(patientName);
        patientPanel.getNameLabel().setText(basicInfo.getName());
        patientPanel.getAgeLabel().setText(basicInfo.getAge().toString()+ " anos");
        patientPanel.getHightLabel().setText(basicInfo.getHight().toString() +"m");
        patientPanel.getSexLabel().setText(basicInfo.getSex());
        
    }
    
    public void configBodyInfo(){
        
        
        if(cursor >= numberOfInfos.size() - 1){
            patientPanel.getNextDateBtn().setEnabled(false);
        }else{
            patientPanel.getNextDateBtn().setEnabled(true);
        }
        
        if(cursor < 1){
            patientPanel.getBackDateBtn().setEnabled(false);
        }else{
            patientPanel.getBackDateBtn().setEnabled(true);
        }
        
        try{
            BasicPatientInfoModel basicInfo = service.getBasicInfos(patientName);
            BodyPatientModel bodyModel = service.getBodyModel(patientName, numberOfInfos.get(cursor));
            patientPanel.getCurrentWeightLabel().setText(bodyModel.getCurrentWeight().toString()+ "Kg");
            patientPanel.getGoalWeightLabel().setText(bodyModel.getGoalWeight().toString()+ "Kg");
            patientPanel.getDifferenceWeightLabel()
                    .setText((bodyModel.getGoalWeight() - bodyModel.getCurrentWeight())+ "Kg");
            patientPanel.getBodyfatLabel().setText(bodyModel.getBodyfat().toString()+"%");
            patientPanel.getImcLabel()
                    .setText(bodyModel.getCurrentWeight() / (basicInfo.getHight() * basicInfo.getHight())+"" );
            patientPanel.getShouldersLabel().setText(bodyModel.getShoulders().toString()+"cm");
            patientPanel.getChestLabel().setText(bodyModel.getChest().toString()+"cm");
            patientPanel.getRightArmLabel().setText(bodyModel.getRightArm().toString()+"cm");
            patientPanel.getLeftArmLabel().setText(bodyModel.getLeftArm().toString()+"cm");
            patientPanel.getWaistLabel().setText(bodyModel.getWaist().toString()+"cm");
            patientPanel.getHipLabel().setText(bodyModel.getHip().toString()+"cm");
            patientPanel.getRightLegLabel().setText(bodyModel.getRightLeg().toString()+"cm");
            patientPanel.getLeftLegLabel().setText(bodyModel.getLeftLeg().toString()+"cm");
            patientPanel.getRightCalfLabel().setText(bodyModel.getRightCalf().toString()+"cm");
            patientPanel.getLeftCalfLabel().setText(bodyModel.getLeftCalf().toString()+"cm");
            patientPanel.getDateLabel().setText(new SimpleDateFormat("dd/MM/yyyy").format(bodyModel.getDate()));
            patientPanel.getDeleteInfoBtn().setEnabled(true);
        }catch(Exception e){
            patientPanel.getCurrentWeightLabel().setText("");
            patientPanel.getGoalWeightLabel().setText("");
            patientPanel.getDifferenceWeightLabel()
                    .setText("");
            patientPanel.getBodyfatLabel().setText("");
            patientPanel.getImcLabel()
                    .setText("");
            patientPanel.getShouldersLabel().setText("");
            patientPanel.getChestLabel().setText("");
            patientPanel.getRightArmLabel().setText("");
            patientPanel.getLeftArmLabel().setText("");
            patientPanel.getWaistLabel().setText("");
            patientPanel.getHipLabel().setText("");
            patientPanel.getRightLegLabel().setText("");
            patientPanel.getLeftLegLabel().setText("");
            patientPanel.getRightCalfLabel().setText("");
            patientPanel.getLeftCalfLabel().setText("");
            patientPanel.getDateLabel().setText("__/__/____");
            JOptionPane.showMessageDialog(null, "Nenhuma informação foi encontrada!");
            patientPanel.getDeleteInfoBtn().setEnabled(false);
        }
        
        
    }
    
    public void configAddAndDelBtn(){
        patientPanel.getAddInfoBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addInfoPanel = new AddInfoPanel(patientName, patientPanel.getScrollPanel());
                patientPanel.getScrollPanel().setViewportView(addInfoPanel);
            }
        });
        
        patientPanel.getDeleteInfoBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                int result = JOptionPane.showConfirmDialog(null,
                        "Tem certeza que deseja deletar essa informação?", "Atenção!",
                        JOptionPane.YES_NO_OPTION);
                
                if(result == JOptionPane.YES_OPTION){
                    if(service.deleteInfo(patientPanel.getPatientName(), numberOfInfos.get(cursor))){
                        System.out.println("Funciona");
                        numberOfInfos = service.getCursor(patientName);
                        cursor = numberOfInfos.size() - 1;
                        configBodyInfo();
                    }else{
                         System.out.println("Não funfa");
                    }
                }

                
            }
        });
    }
    
    public void configInfoBtn(){
        patientPanel.getNextDateBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nextDate();
            }
        });
        patientPanel.getBackDateBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                backDate();
            }
        });
    }
    
    public void nextDate(){
        cursor ++;
        configBodyInfo();
    }
    
    public void backDate(){
        cursor --;
        configBodyInfo();
    }
    
}
