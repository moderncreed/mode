package com.example.mode.model;

public class Cloth {

    private int id;
    private String name;
    private int weight;
    private int price;
    private int length;

    public Cloth() {
    }

    public Cloth(int id, String name, int weight, int price, int length) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.price = price;
        this.length = length;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
