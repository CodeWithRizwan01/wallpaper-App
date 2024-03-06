package com.gunswallpaper.ak47_baretta_m416_hdgunswallpaper.MyDb;

import java.io.Serializable;

public class DbModel implements Serializable {

    private int id;
    private byte[] image;

    public static final String FAVOURITE_DESIGN_TABLE = "FavouriteDesigns";
    public static final String KEY_ID = "Id";
    public static final String KEY_IMAGE = "Image";
    public static final String CREATE_FAVOURITE_DESIGN_TABLE = String.format("CREATE TABLE IF NOT EXISTS %S (%S INTEGER PRIMARY KEY AUTOINCREMENT, %S BLOB)", FAVOURITE_DESIGN_TABLE, KEY_ID, KEY_IMAGE);
    public static final String DROP_FAVOURITE_DESIGN_TABLE = "DROP TABLE IF EXISTS " + FAVOURITE_DESIGN_TABLE;
    public static final String SELECT_FAVOURITE_DESIGN_TABLE = "SELECT * FROM " + FAVOURITE_DESIGN_TABLE;


    public DbModel() {
    }

    public DbModel(int id, byte[] image) {
        this.id = id;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
