package com.example.orders;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.List;

@Document(collection = "order")
public class Order {

    @Id
    private long orderId;
    private long userId;
    private Product products;
    private int totalPrice;

    public Order(){}

    public Order(long orderId, long userId, Product products, int totalPrice) {
        this.orderId = orderId;
        this.userId = userId;
        this.products = products;
        this.totalPrice = totalPrice;
    }


    public Product getProducts() {
        return products;
    }

    public long getOrderId() {
        return orderId;
    }

    public long getUserId() {
        return userId;
    }

    public Product getProduct() {
        return products;
    }

    public int getTotalPrice() {
        return totalPrice;
    }
}
