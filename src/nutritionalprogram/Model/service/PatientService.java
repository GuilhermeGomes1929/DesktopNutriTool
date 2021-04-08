/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nutritionalprogram.Model.service;

import java.util.ArrayList;
import nutritionalprogram.Model.dao.PatientDao;
import nutritionalprogram.Model.entity.BasicPatientInfoModel;
import nutritionalprogram.Model.entity.BodyPatientModel;

/**
 *
 * @author Luana Franciele
 */
public class PatientService {
    
    public PatientDao patientDao;
    
    public PatientService(){
        patientDao = new PatientDao();
    }
    
    public String registerPatient(String patientName, BasicPatientInfoModel basicInfo, BodyPatientModel bodymodel){
        patientDao.createTable("\\pacientes\\"+patientName);
        if(patientDao.insertBasicInfos("\\pacientes\\"+patientName, basicInfo) && patientDao.insertBodyInfos("\\pacientes\\"+patientName, bodymodel)){
            return "Paciente registrado com sucesso!";
        }else{
            return "Houve um erro ao registrar o paciente...";
        }
    }
    
    public String insertPatientInfos(String dbName, BodyPatientModel bodyModel){
        if(patientDao.insertBodyInfos("\\pacientes\\"+dbName, bodyModel)){
            return "Informações inseridas com sucesso!";
        }else{
            return "Houve um erro ao inserir as informações...";
        }
    }
    
    public BasicPatientInfoModel getBasicInfos(String dbName){
        return patientDao.getBasicInfo(dbName);
    }
    
    public ArrayList<Integer> getCursor(String dbName){
        return patientDao.getLastIdFrom(dbName, "bodyInfos");
    }
    
    public BodyPatientModel getBodyModel(String dbName, int id){
        return patientDao.getBodyInfoById(dbName, id);
    }
    
    public boolean deleteInfo(String dbname, int id){
        return patientDao.deleteInfosWithId(dbname, id);
    }
}
