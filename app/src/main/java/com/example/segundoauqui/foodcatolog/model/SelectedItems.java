package com.example.segundoauqui.foodcatolog.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by segundoauqui on 11/10/17.
 */

public class SelectedItems implements Parcelable{

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

    protected SelectedItems(Parcel in) {
        name = in.readString();
        type = in.readString();
        price = in.readDouble();
    }

    public static final Creator<SelectedItems> CREATOR = new Creator<SelectedItems>() {
        @Override
        public SelectedItems createFromParcel(Parcel in) {
            return new SelectedItems(in);
        }

        @Override
        public SelectedItems[] newArray(int size) {
            return new SelectedItems[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(type);
        parcel.writeDouble(price);
    }
}
