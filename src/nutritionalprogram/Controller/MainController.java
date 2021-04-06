/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nutritionalprogram.Controller;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.plaf.ScrollBarUI;
import javax.swing.plaf.basic.BasicScrollBarUI;
import nutritionalprogram.Model.entity.BasicPatientInfoModel;
import nutritionalprogram.Model.entity.BodyPatientModel;
import nutritionalprogram.Model.service.PatientsEditor;
import nutritionalprogram.Model.service.PatientService;
import nutritionalprogram.View.AddInfoPanel;
import nutritionalprogram.View.MainJFrame;
import nutritionalprogram.View.MyScrollBar;
import nutritionalprogram.View.PatientPanel;
import nutritionalprogram.View.RegisterPatientPanel;

/**
 *
 * @author Luana Franciele
 */
public class MainController{
    
    private MainJFrame view;
    private RegisterPatientPanel registerPatientPanel;
    private JScrollPane scrollPanel;
    private PatientPanel patientPanel;
    private PatientsEditor patientsEditor;
    private PatientService service;
    private AddInfoPanel addInfoPanel;
    private int numberOfInfos;
    private int cursor;
   
    private static int MENU_PANEL_WIDTH = 194;
    
    
    public MainController(MainJFrame view){
        this.view = view;
        registerPatientPanel = new RegisterPatientPanel();
        scrollPanel = view.getContentPanel();
        patientsEditor = new PatientsEditor();
        addInfoPanel = new AddInfoPanel();
        
        service = new PatientService();
        
        updateMenuPatientList();
    }
    
    
    public void addRegisterPatientView(){
        scrollPanel.setViewportView(registerPatientPanel);
        registerPatientPanel.getSaveInfoPatientButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getAllInformation();
                updateMenuPatientList();
            }
        });
    }
    
    public void addInfoPatientView(){
        scrollPanel.setViewportView(patientPanel);
    }
    
    public void updateMenuPatientList(){
        ArrayList<String> list = patientsEditor.listOfPatients();
        JPanel listPatientPanel = new JPanel();
        if(list.size() < 10){
            listPatientPanel.setLayout(new GridLayout(10, 1));
        }else{
            listPatientPanel.setLayout(new GridLayout(list.size(), 1));
        }
        
        
       

        if(!list.isEmpty()){
            
             for(int i = 0; i < list.size(); i++){
                
                JButton button = new JButton(list.get(i));                
                button.setPreferredSize(new Dimension(180,40));
                button.setMaximumSize(new Dimension(180,40));
                button.setMinimumSize(new Dimension(180,40));
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        patientPanel = new PatientPanel();
                        configBasicInfo(button.getText());
                        scrollPanel.setViewportView(patientPanel);
                        numberOfInfos = service.getCursor(button.getText());
                        cursor = numberOfInfos;
                        configBodyInfo(button.getText());
                        configInfoBtn();
                        configAddAndDelBtn();
                    }
                });                
               
                listPatientPanel.add(button);
   
            }
           
        }
        view.getListScrollPanel().setViewportView(listPatientPanel);
        view.getListScrollPanel().setVerticalScrollBar(new MyScrollBar(JScrollBar.VERTICAL));
            
    }
    
     public void getAllInformation(){
        Calendar calendar = Calendar.getInstance();
        long timeInMilis = calendar.getTimeInMillis();
        BasicPatientInfoModel basicInfo = new BasicPatientInfoModel();
        BodyPatientModel bodyModel = new BodyPatientModel();
        
        basicInfo.setName(registerPatientPanel.getNameTextField().getText());
        basicInfo.setAge(Integer.parseInt(registerPatientPanel.getAgeSpinner().getValue().toString()));
        basicInfo.setHight(Float.parseFloat(registerPatientPanel.getHightSpinner().getValue().toString()));
        basicInfo.setSex(registerPatientPanel.getSexComboBox().getSelectedItem().toString());
        bodyModel.setCurrentWeight(Float.parseFloat(registerPatientPanel.getCurrentWeightSpinner().getValue().toString()));
        bodyModel.setGoalWeight(Float.parseFloat(registerPatientPanel.getGoalWeightSpinner().getValue().toString()));
        bodyModel.setBodyfat(Float.parseFloat(registerPatientPanel.getBodyfatSpinner().getValue().toString()));
        bodyModel.setShoulders(Integer.parseInt(registerPatientPanel.getShouldersSpinner().getValue().toString()));
        bodyModel.setChest(Integer.parseInt(registerPatientPanel.getChestSpinner().getValue().toString()));
        bodyModel.setLeftArm(Integer.parseInt(registerPatientPanel.getLeftArmSpinner().getValue().toString()));
        bodyModel.setRightArm(Integer.parseInt(registerPatientPanel.getRightArmSpinner().getValue().toString()));
        bodyModel.setWaist(Integer.parseInt(registerPatientPanel.getWaistSpinner().getValue().toString()));
        bodyModel.setHip(Integer.parseInt(registerPatientPanel.getHipSpinner().getValue().toString()));
        bodyModel.setLeftLeg(Integer.parseInt(registerPatientPanel.getLeftLegSpinner().getValue().toString()));
        bodyModel.setRightLeg(Integer.parseInt(registerPatientPanel.getRightLegSpinner().getValue().toString()));
        bodyModel.setLeftCalf(Integer.parseInt(registerPatientPanel.getLeftCalfSpinner().getValue().toString()));
        bodyModel.setRightCalf(Integer.parseInt(registerPatientPanel.getRightCalfSpinner().getValue().toString()));
        bodyModel.setDate(timeInMilis);
        
        String status = service.registerPatient(registerPatientPanel.getNameTextField().getText(), basicInfo, bodyModel);
        JOptionPane.showMessageDialog(null, status);
    }
     
     
    public void configBasicInfo(String patientName){
        BasicPatientInfoModel basicInfo = service.getBasicInfos(patientName);
        patientPanel.getNameLabel().setText(basicInfo.getName());
        patientPanel.getAgeLabel().setText("Idade: "+basicInfo.getAge().toString());
        patientPanel.getHightLabel().setText("Altura: "+basicInfo.getHight().toString());
        patientPanel.getSexLabel().setText("Sexo: "+basicInfo.getSex());
        
    }
    
    public void configBodyInfo(String patientName){
        
        
        if(cursor >= numberOfInfos){
            patientPanel.getNextDateBtn().setEnabled(false);
        }else{
            patientPanel.getNextDateBtn().setEnabled(true);
        }
        
        if(cursor <= 1){
            patientPanel.getBackDateBtn().setEnabled(false);
        }else{
            patientPanel.getBackDateBtn().setEnabled(true);
        }
        
        try{
            BasicPatientInfoModel basicInfo = service.getBasicInfos(patientName);
            BodyPatientModel bodyModel = service.getBodyModel(patientName, cursor);
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
        }
        
        
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
        configBodyInfo(patientPanel.getNameLabel().getText());
    }
    
    public void backDate(){
        cursor --;
        configBodyInfo(patientPanel.getNameLabel().getText());
    }
    
    public void configAddAndDelBtn(){
        patientPanel.getAddInfoBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 scrollPanel.setViewportView(addInfoPanel);
            }
        });
        
        patientPanel.getDeleteInfoBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(service.deleteInfo(patientPanel.getNameLabel().getText(), cursor)){
                    System.out.println("Funciona");
                }else{
                     System.out.println("Não funfa");
                }
                configBodyInfo(patientPanel.getNameLabel().getText());
            }
        });
    }
    
    
    
}
