package com.rajendra.foodapp.model;

import java.io.Serializable;

public class Food implements Serializable {

    String name;
    String type;
    String price;
    Integer imageUrl;
    String rating;
    String restorantname;
    int numberOrder;
    String description;

    public Food(String name,String type, String price, Integer imageUrl, String rating, String restorantname,int numberOrder,String description) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.imageUrl = imageUrl;
        this.rating = rating;
        this.restorantname = restorantname;
        this.numberOrder = numberOrder;
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getRestorantname() {
        return restorantname;
    }

    public void setRestorantname(String restorantname) {
        this.restorantname = restorantname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(Integer imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getNumberOrder() {
        return numberOrder;
    }

    public void setNumberOrder(int numberOrder) {
        this.numberOrder = numberOrder;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
