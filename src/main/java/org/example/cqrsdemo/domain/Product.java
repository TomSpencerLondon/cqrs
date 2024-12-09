package org.example.cqrsdemo.domain;

public class Product {
    private final String id;
    private String name;
    private double price;

    public Product(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // getters and setters (id is final, only getters)
}
