/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nutritionalprogram.Model.service;

import nutritionalprogram.Model.dao.PatientDao;
import nutritionalprogram.Model.entity.BasicPatientInfoModel;
import nutritionalprogram.Model.entity.BodyPatientModel;

/**
 *
 * @author Luana Franciele
 */
public class RegisterPatientService {
    
    public PatientDao patientDao;
    
    public RegisterPatientService(){
        patientDao = new PatientDao();
    }
    
    public String registerPatient(String patientName, BasicPatientInfoModel basicInfo, BodyPatientModel bodymodel){
        patientDao.createTable(patientName);
        if(patientDao.insertBasicInfos(patientName, basicInfo) && patientDao.insertBodyInfos(patientName, bodymodel)){
            return "Paciente registrado com sucesso!";
        }else{
            return "Houve um erro ao registrar o paciente...";
        }
    }
}
