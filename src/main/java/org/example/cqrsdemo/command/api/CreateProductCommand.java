package org.example.cqrsdemo.command.api;

public class CreateProductCommand {
    private String name;
    private double price;

    public CreateProductCommand() {}

    public CreateProductCommand(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

