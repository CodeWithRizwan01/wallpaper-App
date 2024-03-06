package com.gunswallpaper.ak47_baretta_m416_hdgunswallpaper.Model;

import java.io.Serializable;

public class Guns implements Serializable {

    private int id;
    private int image;
    private String isFavourite;

    // constructor

    public Guns() {
    }

    public Guns(int image, String isFavourite) {
        this.image = image;
        this.isFavourite = isFavourite;
    }

    public Guns(int id, int image, String isFavourite) {
        this.id = id;
        this.image = image;
        this.isFavourite = isFavourite;
    }

    // getter and setter of the data members

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getIsFavourite() {
        return isFavourite;
    }

    public void setIsFavourite(String isFavourite) {
        this.isFavourite = isFavourite;
    }
}
