package com.example.segundoauqui.foodcatolog.model;

/**
 * Created by segundoauqui on 8/24/17.
 */

public class Groceries {

    public Groceries() {
    }

    public String name;
    public String type;
    public double price;


    public Groceries(String name, String type, double price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }
}