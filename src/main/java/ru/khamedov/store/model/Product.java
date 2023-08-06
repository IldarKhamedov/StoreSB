package ru.khamedov.store.model;

public class Product {

    private Long id;

    private String name;

    private double cost;

    private double count;

    public Product(Long id, String name, double cost, double count) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.count = count;
    }

    public Product() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getCount() {
        return count;
    }

    public void setCount(double count) {
        this.count = count;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
