/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nutritionalprogram.Controller;

import java.util.Calendar;
import javax.swing.JOptionPane;
import nutritionalprogram.Model.entity.BasicPatientInfoModel;
import nutritionalprogram.Model.entity.BodyPatientModel;
import nutritionalprogram.Model.service.PatientService;
import nutritionalprogram.View.RegisterPatientPanel;

/**
 *
 * @author Luana Franciele
 */
public class RegisterController {
    
    private RegisterPatientPanel patientPanel;
    private PatientService service;
    
    public RegisterController(RegisterPatientPanel patientPanel){
        this.patientPanel = patientPanel;
        service = new PatientService();
    }
    
    public void getAllInformation(){
        Calendar calendar = Calendar.getInstance();
        long timeInMilis = calendar.getTimeInMillis();
        BasicPatientInfoModel basicInfo = new BasicPatientInfoModel();
        BodyPatientModel bodyModel = new BodyPatientModel();
        
        basicInfo.setName(patientPanel.getNameTextField().getText());
        basicInfo.setAge(Integer.parseInt(patientPanel.getAgeSpinner().getValue().toString()));
        basicInfo.setHight(Float.parseFloat(patientPanel.getHightSpinner().getValue().toString()));
        basicInfo.setSex(patientPanel.getSexComboBox().getSelectedItem().toString());
        bodyModel.setCurrentWeight(Float.parseFloat(patientPanel.getCurrentWeightSpinner().getValue().toString()));
        bodyModel.setGoalWeight(Float.parseFloat(patientPanel.getGoalWeightSpinner().getValue().toString()));
        bodyModel.setBodyfat(Float.parseFloat(patientPanel.getBodyfatSpinner().getValue().toString()));
        bodyModel.setShoulders(Integer.parseInt(patientPanel.getShouldersSpinner().getValue().toString()));
        bodyModel.setChest(Integer.parseInt(patientPanel.getChestSpinner().getValue().toString()));
        bodyModel.setLeftArm(Integer.parseInt(patientPanel.getLeftArmSpinner().getValue().toString()));
        bodyModel.setRightArm(Integer.parseInt(patientPanel.getRightArmSpinner().getValue().toString()));
        bodyModel.setWaist(Integer.parseInt(patientPanel.getWaistSpinner().getValue().toString()));
        bodyModel.setHip(Integer.parseInt(patientPanel.getHipSpinner().getValue().toString()));
        bodyModel.setLeftLeg(Integer.parseInt(patientPanel.getLeftLegSpinner().getValue().toString()));
        bodyModel.setRightLeg(Integer.parseInt(patientPanel.getRightLegSpinner().getValue().toString()));
        bodyModel.setLeftCalf(Integer.parseInt(patientPanel.getLeftCalfSpinner().getValue().toString()));
        bodyModel.setRightCalf(Integer.parseInt(patientPanel.getRightCalfSpinner().getValue().toString()));
        bodyModel.setDate(timeInMilis);
        
        String status = service.registerPatient(patientPanel.getNameTextField().getText(), basicInfo, bodyModel);
        JOptionPane.showMessageDialog(null, status);
    }
}
