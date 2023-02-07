package com.example.pizzaorder;

import java.io.Serializable;

public class Pizza implements Serializable {
    private String pizzaName;
    private int pizzaPrice;
    private int pizzaImage;
    private int pizzaNumber;
    private int pizzaImageId;
    private String pizzaInfo;

    public Pizza(String pizzaName, int pizzaPrice, int pizzaImage, String pizzaInfo) {
        this.pizzaName = pizzaName;
        this.pizzaPrice = pizzaPrice;
        this.pizzaImage = pizzaImage;
        this.pizzaInfo = pizzaInfo;
        this.pizzaNumber = 0;
    }

    public void setNumber(int pizzaNumber) {

        this.pizzaNumber = pizzaNumber;
    }

    public String getName() {

        return pizzaName;
    }

    public int getPrice() {

        return pizzaPrice;
    }

    public int getImage() {

        return pizzaImage;
    }

    public int getNumber() {

        return pizzaNumber;
    }

    public int getImageId() {
        return pizzaImageId;
    }

    public void setImageId(int imageId) {
        this.pizzaImageId = imageId;
    }

    public String getInfo() {
        return pizzaInfo;
    }
}
