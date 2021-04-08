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
    }
    
    public void configBasicInfo(){
        BasicPatientInfoModel basicInfo = service.getBasicInfos(patientName);
        patientPanel.getNameLabel().setText(basicInfo.getName());
        patientPanel.getAgeLabel().setText("Idade: "+basicInfo.getAge().toString());
        patientPanel.getHightLabel().setText("Altura: "+basicInfo.getHight().toString());
        patientPanel.getSexLabel().setText("Sexo: "+basicInfo.getSex());
        
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
            patientPanel.getCurrentWeightLabel().setText("Atual:" +bodyModel.getCurrentWeight().toString());
            patientPanel.getGoalWeightLabel().setText("Meta: "+bodyModel.getGoalWeight().toString());
            patientPanel.getDifferenceWeightLabel()
                    .setText("Diferença: "+(bodyModel.getGoalWeight() - bodyModel.getCurrentWeight()));
            patientPanel.getBodyfatLabel().setText("Gordura corporal: "+bodyModel.getBodyfat().toString());
            patientPanel.getImcLabel()
                    .setText("IMC: "+bodyModel.getCurrentWeight() / basicInfo.getHight() * basicInfo.getHight() );
            patientPanel.getShouldersLabel().setText("Ombros: "+bodyModel.getShoulders().toString());
            patientPanel.getChestLabel().setText("Peitoral: "+bodyModel.getChest().toString());
            patientPanel.getRightArmLabel().setText("Braço D.: "+bodyModel.getRightArm().toString());
            patientPanel.getLeftArmLabel().setText("Braço E.: "+bodyModel.getLeftArm().toString());
            patientPanel.getWaistLabel().setText("Cintura: "+bodyModel.getWaist().toString());
            patientPanel.getHipLabel().setText("Quadril: "+bodyModel.getHip().toString());
            patientPanel.getRightLegLabel().setText("Perna D.: "+bodyModel.getRightLeg().toString());
            patientPanel.getLeftLegLabel().setText("Perna E.: "+bodyModel.getLeftLeg().toString());
            patientPanel.getRightCalfLabel().setText("Panturrilha D.: "+bodyModel.getRightCalf().toString());
            patientPanel.getLeftCalfLabel().setText("Panturrilha E.: "+bodyModel.getLeftCalf().toString());
            patientPanel.getDateLabel().setText(new SimpleDateFormat("dd/MM/yyyy").format(bodyModel.getDate()));
            patientPanel.getDeleteInfoBtn().setEnabled(true);
        }catch(Exception e){
            patientPanel.getCurrentWeightLabel().setText("Atual:");
            patientPanel.getGoalWeightLabel().setText("Meta: ");
            patientPanel.getDifferenceWeightLabel()
                    .setText("Diferença: ");
            patientPanel.getBodyfatLabel().setText("Gordura corporal: ");
            patientPanel.getImcLabel()
                    .setText("IMC: ");
            patientPanel.getShouldersLabel().setText("Ombros: ");
            patientPanel.getChestLabel().setText("Peitoral: ");
            patientPanel.getRightArmLabel().setText("Braço D.: ");
            patientPanel.getLeftArmLabel().setText("Braço E.: ");
            patientPanel.getWaistLabel().setText("Cintura: ");
            patientPanel.getHipLabel().setText("Quadril: ");
            patientPanel.getRightLegLabel().setText("Perna D.: ");
            patientPanel.getLeftLegLabel().setText("Perna E.: ");
            patientPanel.getRightCalfLabel().setText("Panturrilha D.: ");
            patientPanel.getLeftCalfLabel().setText("Panturrilha E.: ");
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
                
                if(service.deleteInfo(patientPanel.getPatientName(), numberOfInfos.get(cursor))){
                    System.out.println("Funciona");
                    numberOfInfos = service.getCursor(patientName);
                    cursor = numberOfInfos.size() - 1;
                    configBodyInfo();
                }else{
                     System.out.println("Não funfa");
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
