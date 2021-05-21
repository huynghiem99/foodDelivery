package com.rajendra.foodapp.model;

public class GeneralFood {
    private String name;
    private int imageGeneral;

    public GeneralFood(String name, int imageGeneral) {
        this.name = name;
        this.imageGeneral = imageGeneral;
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


}
