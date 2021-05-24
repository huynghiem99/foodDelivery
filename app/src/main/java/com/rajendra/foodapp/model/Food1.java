package com.rajendra.foodapp.model;
public class Food1 {
    private int id;
    private String name;
    private double price;
    private float rating;
    private String type;
    private String nameRestaurent;
    private String foodImageUrl;
    private String description;

    public Food1() {
    }

    public Food1(int id, String name, double price, float rating, String type, String nameRestaurent, String foodImageUrl, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.type = type;
        this.nameRestaurent = nameRestaurent;
        this.foodImageUrl = foodImageUrl;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNameRestaurent() {
        return nameRestaurent;
    }

    public void setNameRestaurent(String nameRestaurent) {
        this.nameRestaurent = nameRestaurent;
    }

    public String getFoodImageUrl() {
        return foodImageUrl;
    }

    public void setFoodImageUrl(String foodImageUrl) {
        this.foodImageUrl = foodImageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", rating=" + rating +
                ", type='" + type + '\'' +
                ", nameRestaurent='" + nameRestaurent + '\'' +
                ", foodImageUrl='" + foodImageUrl + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}