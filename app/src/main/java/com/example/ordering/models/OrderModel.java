package com.example.ordering.models;

import java.util.List;

public class OrderModel {
    private List<CartModel> productList;
    private String note;
    private String totalPrice;
    private String stt;

    public OrderModel(){}

    public OrderModel( List<CartModel> productList, String note, String totalPrice, String stt) {
        this.productList = productList;
        this.note = note;
        this.totalPrice = totalPrice;
        this.stt = stt;
    }
    public List<CartModel> getProductList() {
        return productList;
    }

    public void setProductList(List<CartModel> productList) {
        this.productList = productList;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStt() {
        return stt;
    }

    public void setStt(String stt) {
        this.stt = stt;
    }
}

