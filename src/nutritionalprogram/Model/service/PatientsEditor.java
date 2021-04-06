/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nutritionalprogram.Model.service;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author Luana Franciele
 */
public class PatientsEditor {
    
    private File file;
    private String path;
    
    public PatientsEditor(){
        path = System.getProperty("user.dir")+"\\pacientes";
        file = new File(path);    
    }
    
    
    public ArrayList<String> listOfPatients(){
        String arqs[] = file.list();
        ArrayList<String> list = new ArrayList<String>();
        
        if(arqs == null){
            return null;
        }else{
            for(int i = 0; i < arqs.length; i++){
                
                if(arqs[i].endsWith(".db")){
                    list.add(arqs[i].split("\\.")[0]);
                }
            }
            
            return list;
        }
    }
    
}
