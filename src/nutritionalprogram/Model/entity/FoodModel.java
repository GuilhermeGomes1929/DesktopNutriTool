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
public class FoodModel {
    
    private Integer id;
    private String foodName;
    private Integer weight;
    private String homeMeasure;
    private Integer calories;
    private Double homePortions;

    public Double getHomePortions() {
        return homePortions;
    }

    public void setHomePortions(Double homePortions) {
        this.homePortions = homePortions;
    }   
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getHomeMeasure() {
        return homeMeasure;
    }

    public void setHomeMeasure(String homeMeasure) {
        this.homeMeasure = homeMeasure;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    
    
    
    
}
