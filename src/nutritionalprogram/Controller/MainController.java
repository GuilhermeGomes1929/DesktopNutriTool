/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nutritionalprogram.Controller;

import java.awt.Button;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import nutritionalprogram.View.MainJFrame;
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
    
    public MainController(MainJFrame view){
        this.view = view;
        registerPatientPanel = new RegisterPatientPanel();
        patientPanel = new PatientPanel();
        
        scrollPanel = view.getContentPanel();
    }
    
    
    public void addRegisterPatientView(){
        scrollPanel.setViewportView(registerPatientPanel);
    }
    
    public void addPatientView(){
        scrollPanel.setViewportView(patientPanel);
    }
    
    
    
}
