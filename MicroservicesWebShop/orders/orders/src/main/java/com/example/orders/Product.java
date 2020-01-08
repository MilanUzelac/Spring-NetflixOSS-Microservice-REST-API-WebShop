package com.example.orders;

public class Product {
    private long productId;
    private String name;
    private int price;

    public Product(long productId, String name, int price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public Product(){}

    public long getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

}
