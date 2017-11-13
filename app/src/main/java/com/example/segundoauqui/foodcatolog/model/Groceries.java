package com.example.segundoauqui.foodcatolog.model;

import java.util.ArrayList;

/**
 * Created by segundoauqui on 8/24/17.
 */

public class Groceries {

    public Groceries(String s, boolean b) {
    }

    public String name;
    public String type;
    public double price;


    public Groceries(String name, String type, double price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }
//    private static int lastContactId = 0;
//
//    public static ArrayList<Groceries> createContactsList(int numContacts) {
//        ArrayList<Groceries> contacts = new ArrayList<Groceries>();
//
//        for (int i = 1; i <= numContacts; i++) {
//            contacts.add(new Groceries("Person " + ++lastContactId, i <= numContacts / 2));
//        }
//
//        return contacts;
//    }

}