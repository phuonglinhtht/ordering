package com.example.ordering.models;

import java.util.ArrayList;
import java.util.List;

public class order {
    private static order instance;
    private List<OrderModel> lists;

    private order() {
        lists = new ArrayList<>();
    }
    public static order getInstance() {
        if (instance == null) {
            instance = new order();
        }
        return instance;
    }
    public void addOrder(OrderModel list) {
        lists.add(list);
    }
    public void removeOrder(OrderModel list) {
        lists.remove(list);
    }

    public List<OrderModel> getOrder() {
        return lists;
    }

    public void clear() {
        lists.clear();
    }
}
