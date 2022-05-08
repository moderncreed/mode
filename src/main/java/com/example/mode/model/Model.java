package com.example.mode.model;

public class Model {

    private int id;
    private String name;
    private int length;
    private int price;
    private Cloth cloth;

    public Model() {
    }

    public Model(int id, String name, int length, int price, Cloth cloth) {
        this.id = id;
        this.name = name;
        this.length = length;
        this.price = price;
        this.cloth = cloth;
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

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Cloth getCloth() {
        return cloth;
    }

    public void setCloth(Cloth cloth) {
        this.cloth = cloth;
    }
}
