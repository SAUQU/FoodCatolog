package com.example.segundoauqui.foodcatolog.model;

import java.util.ArrayList;

/**
 * Created by segundoauqui on 11/10/17.
 */

public class SelectedItems {

    public SelectedItems() {
    }

    public String name;
    public String type;
    public double price;

    public SelectedItems(String name, String type, double price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }
}
