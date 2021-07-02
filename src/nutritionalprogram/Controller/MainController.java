/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nutritionalprogram.Controller;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
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
    
   
    private static int MENU_PANEL_WIDTH = 194;
    
    
    public MainController(MainJFrame view){
        this.view = view;
        registerPatientPanel = new RegisterPatientPanel();
        scrollPanel = view.getContentPanel();
        patientsEditor = new PatientsEditor();
        
        service = new PatientService();
        
        updateMenuPatientList();
        MyScrollBar sc = new MyScrollBar(JScrollBar.VERTICAL);
        view.getListScrollPanel().setVerticalScrollBar(sc);
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
        listPatientPanel.setOpaque(false);
        listPatientPanel.setBorder(null);
        if(list.size() < 10){
            listPatientPanel.setLayout(new GridLayout(10, 1));
        }else{
            listPatientPanel.setLayout(new GridLayout(list.size(), 1));
        }
        
        
       

        if(!list.isEmpty()){
            
             for(int i = 0; i < list.size(); i++){
                
                JLabel button = new JLabel(list.get(i));
                button.setOpaque(true);
                button.setBackground(new Color(115,232,255));
                button.setFont(new Font("Tahoma", Font.PLAIN, 14));
                button.setForeground(new Color(60,60,60));
                button.setIcon(new ImageIcon(getClass().getResource("/icons/space.png")));
                button.setPreferredSize(new Dimension(180,40));
                button.setMaximumSize(new Dimension(180,40));
                button.setMinimumSize(new Dimension(180,40));
                button.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseEntered(java.awt.event.MouseEvent evt) {
                        button.setBackground(new Color(0,134,195));
                    }
                    public void mouseExited(java.awt.event.MouseEvent evt) {
                        button.setBackground(new Color(115,232,255));
                    }
                    
                    public void mouseReleased(java.awt.event.MouseEvent evt) {
                        button.setBackground(new Color(115,232,255));
                        patientPanel = new PatientPanel(button.getText(), scrollPanel);
                        scrollPanel.setViewportView(patientPanel);
                    }
                });
                
                        
                
               
                listPatientPanel.add(button);
   
            }
           
        }
        view.getListScrollPanel().setViewportView(listPatientPanel);
            
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
        
        String status = service.insertPatientInfos(patientPanel.getNameLabel().getText(), bodyModel);
        
        JOptionPane.showMessageDialog(null, status);
    }
    
    
}
