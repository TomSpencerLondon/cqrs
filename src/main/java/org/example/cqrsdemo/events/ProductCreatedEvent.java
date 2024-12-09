package org.example.cqrsdemo.events;

public class ProductCreatedEvent {
    private final String productId;
    private final String name;
    private final double price;

    public ProductCreatedEvent(String productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }


    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

