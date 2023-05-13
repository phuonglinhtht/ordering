package com.example.ordering.models;

public class HomeVerModel {
    int image;
    String name;
    int rating;
    String price;

    public HomeVerModel(int image, String name,int rating, String price) {
        this.image = image;
        this.name = name;
        this.rating = rating;
        this.price = price;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
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
}
