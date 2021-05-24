package com.rajendra.foodapp.model;

public class GeneralFood {
    private String name;
    private int imageGeneral;
    private  String key;

    public GeneralFood(String name, int imageGeneral, String key) {
        this.name = name;
        this.imageGeneral = imageGeneral;
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageGeneral() {
        return imageGeneral;
    }

    public void setImageGeneral(int imageGeneral) {
        this.imageGeneral = imageGeneral;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
