/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nutritionalprogram.Model.entity;

/**
 *
 * @author Luana Franciele
 */
public class BasicPatientInfoModel {
    
    private String name;
    private Integer age;
    private String sex;
    private Float hight;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Float getHight() {
        return hight;
    }

    public void setHight(Float hight) {
        this.hight = hight;
    }
    

    
}
