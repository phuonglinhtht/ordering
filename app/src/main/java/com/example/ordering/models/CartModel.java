package com.example.ordering.models;

public class CartModel{
    private int image;
    private String name;
    private String price;
    private String note;

    public CartModel(int image, String name, String price, String note) {
        this.image = image;
        this.name = name;
        this.price = price;
        this.note = note;
    }

    public CartModel() {

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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
