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
public class MenuModel {
    
    private String meal;
    private Integer foodGroup;
    private Integer food;
    private Float portion;
    private Integer subs;

    public String getMeal() {
        return meal;
    }

    public void setMeal(String meal) {
        this.meal = meal;
    }

    public Integer getFoodGroup() {
        return foodGroup;
    }

    public void setFoodGroup(Integer foodGroup) {
        this.foodGroup = foodGroup;
    }

    public Integer getFood() {
        return food;
    }

    public void setFood(Integer food) {
        this.food = food;
    }

    public Float getPortion() {
        return portion;
    }

    public void setPortion(Float portion) {
        this.portion = portion;
    }

    public Integer getSubs() {
        return subs;
    }

    public void setSubs(Integer subs) {
        this.subs = subs;
    }
    
    
    
}
