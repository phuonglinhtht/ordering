package com.example.ordering.models;

import java.util.ArrayList;
import java.util.List;

public class cart {
    private static cart instance;
    private List<CartModel> lists;

    private cart() {
        lists = new ArrayList<>();
    }

    public static cart getInstance() {
        if (instance == null) {
            instance = new cart();
        }
        return instance;//c
    }

    public void addProduct(CartModel list) {
        lists.add(list);
    }
    public void removeProduct(CartModel list) {
        lists.remove(list);
    }

    public List<CartModel> getProducts() {
        return lists;
    }

    public void clear() {
        lists.clear();
    }
}
