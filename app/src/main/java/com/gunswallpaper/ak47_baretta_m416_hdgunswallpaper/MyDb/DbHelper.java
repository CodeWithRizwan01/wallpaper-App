package com.gunswallpaper.ak47_baretta_m416_hdgunswallpaper.MyDb;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

public class DbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "GunWallpaper";
    public static final int DATABASE_VERSION = 1;

    private static DbHelper instance;

    public static DbHelper getInstance(Context context) {
        if (instance == null) {
            instance = new DbHelper(context);
        }
        return instance;
    }

    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DbModel.CREATE_FAVOURITE_DESIGN_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            db.execSQL(DbModel.DROP_FAVOURITE_DESIGN_TABLE);
            db.execSQL(DbModel.CREATE_FAVOURITE_DESIGN_TABLE);
        }
    }

    @SuppressLint("Range")
    public List<DbModel> getAllImages() {
        List<DbModel> imageList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + DbModel.FAVOURITE_DESIGN_TABLE;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                DbModel imageModel = new DbModel();
                imageModel.setId(cursor.getInt(0));
                imageModel.setImage(cursor.getBlob(1));
                imageList.add(imageModel);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return imageList;
    }

    public boolean insertBitMapImages(Context context, int image) {
        Drawable drawable = ContextCompat.getDrawable(context, image);
        Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();

        SQLiteDatabase database = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DbModel.KEY_IMAGE, byteArray);
        long effectRows = 0;
        try {
            effectRows = database.insert(DbModel.FAVOURITE_DESIGN_TABLE, null, values);
        } catch (Exception ex) {
            return false;
        }
        return effectRows == 1;
    }

    @SuppressLint("Range")
    public void deleteImage(int id) {
        String deleteQuery = "DELETE FROM " + DbModel.FAVOURITE_DESIGN_TABLE + " WHERE id = " + id;
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(deleteQuery);

        // Retrieve all rows from the table
        String selectQuery = "SELECT id FROM " + DbModel.FAVOURITE_DESIGN_TABLE + " ORDER BY id ASC";
        Cursor cursor = db.rawQuery(selectQuery, null);

        // Update the IDs of the remaining rows sequentially
        int newId = 1;
        while (cursor.moveToNext()) {
            int currentId = cursor.getInt(0);
            if (currentId != newId) {
                String updateQuery = "UPDATE " + DbModel.FAVOURITE_DESIGN_TABLE + " SET id = " + newId + " WHERE id = " + currentId;
                db.execSQL(updateQuery);
            }
            newId++;
        }
        cursor.close();
    }

    public void deleteAllRows() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(DbModel.FAVOURITE_DESIGN_TABLE, null, null);
        db.close();
    }

}
