package com.example.softexpertdemo.Model;

public class Car {
    private String brand;
    private String constractionYear;
    private Boolean isUsed;
    private String imageUrl;

    public Car(String brand, String constractionYear, Boolean isUsed, String imageUrl) {
        this.brand = brand;
        this.constractionYear = constractionYear;
        this.isUsed = isUsed;
        this.imageUrl = imageUrl;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getConstractionYear() {
        return constractionYear;
    }

    public void setConstractionYear(String constractionYear) {
        this.constractionYear = constractionYear;
    }

    public Boolean getUsed() {
        return isUsed;
    }

    public void setUsed(Boolean used) {
        isUsed = used;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
