/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nutritionalprogram.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.JOptionPane;
import nutritionalprogram.Model.entity.BodyPatientModel;
import nutritionalprogram.Model.service.PatientService;
import nutritionalprogram.View.AddInfoPanel;
import nutritionalprogram.View.PatientPanel;

/**
 *
 * @author Luana Franciele
 */
public class AddInfoController {
    
    private AddInfoPanel addInfoPanel;
    private PatientService service;
    
    public AddInfoController(AddInfoPanel addInfoPanel){
        this.addInfoPanel = addInfoPanel;
        this.service = new PatientService();
        
        init();
    }
    
    public void init(){
        configPatientName();
        configAddInfoBtn();
    }
    
    public void configPatientName(){
        addInfoPanel.getNameLabel().setText(addInfoPanel.getPatientName());
    }
    
    public void configAddInfoBtn(){
        addInfoPanel.getSaveBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getNewInformations();
                addInfoPanel.getScrollPanel()
                        .setViewportView(new PatientPanel(addInfoPanel.getPatientName(),
                        addInfoPanel.getScrollPanel()));
                System.out.println("Salvou");
            }
        });
        addInfoPanel.getCancelBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addInfoPanel.getScrollPanel()
                        .setViewportView(new PatientPanel(addInfoPanel.getPatientName(),
                        addInfoPanel.getScrollPanel()));
                System.out.println("Cancelou");
            }
        });
    }
    
    public void getNewInformations(){
        BodyPatientModel bodyModel = new BodyPatientModel();
        Calendar calendar = Calendar.getInstance();
        long timeInMillis = calendar.getTimeInMillis();
        
        bodyModel.setCurrentWeight(Float.parseFloat(addInfoPanel.getCurrentWeightSpinner().getValue().toString()));
        bodyModel.setGoalWeight(Float.parseFloat(addInfoPanel.getGoalWeightSpinner().getValue().toString()));
        bodyModel.setBodyfat(Float.parseFloat(addInfoPanel.getBodyfatSpinner().getValue().toString()));
        bodyModel.setShoulders(Integer.parseInt(addInfoPanel.getShouldersSpinner().getValue().toString()));
        bodyModel.setChest(Integer.parseInt(addInfoPanel.getChestSpinner().getValue().toString()));
        bodyModel.setRightArm(Integer.parseInt(addInfoPanel.getRightArmSpinner().getValue().toString()));
        bodyModel.setLeftArm(Integer.parseInt(addInfoPanel.getLeftArmSpinner().getValue().toString()));
        bodyModel.setWaist(Integer.parseInt(addInfoPanel.getWaistSpinner().getValue().toString()));
        bodyModel.setHip(Integer.parseInt(addInfoPanel.getHipSpinner().getValue().toString()));
        bodyModel.setRightLeg(Integer.parseInt(addInfoPanel.getRightLegSpinner().getValue().toString()));
        bodyModel.setLeftLeg(Integer.parseInt(addInfoPanel.getLeftLegSpinner().getValue().toString()));
        bodyModel.setRightCalf(Integer.parseInt(addInfoPanel.getRightCalfSpinner().getValue().toString()));
        bodyModel.setLeftCalf(Integer.parseInt(addInfoPanel.getLeftCalfSpinner().getValue().toString()));
        bodyModel.setDate(timeInMillis);
        
        String status = service.insertPatientInfos(addInfoPanel.getPatientName(), bodyModel);
        
        JOptionPane.showMessageDialog(null, status);
    }
    
}
