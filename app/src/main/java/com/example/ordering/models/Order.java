package com.example.ordering.models;

import java.util.List;

public class Order {
    private List<CartModel> productList;
    private int totalPrice;

    public Order() {}

    public Order(List<CartModel> productList, int totalPrice) {
        this.productList = productList;
        this.totalPrice = totalPrice;
    }

    public List<CartModel> getProductList() {
        return productList;
    }

    public void setProductList(List<CartModel> productList) {
        this.productList = productList;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
}
