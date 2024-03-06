package com.gunswallpaper.ak47_baretta_m416_hdgunswallpaper.Activity;

import androidx.appcompat.app.AppCompatActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;

import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.viewpager.widget.ViewPager;

import android.app.WallpaperManager;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.Toast;

import com.gunswallpaper.ak47_baretta_m416_hdgunswallpaper.R;
import com.gunswallpaper.ak47_baretta_m416_hdgunswallpaper.ViewPager.ImageViewPager;
import com.gunswallpaper.ak47_baretta_m416_hdgunswallpaper.Model.Guns;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;


public class SingleImageActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    private static final int PERMISSION_REQUEST_CODE = 100;

    ViewPager singleImageViewPager;
    ArrayList<Guns> imageList;
    int currentPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_image);

        singleImageViewPager = findViewById(R.id.singleImageViewPager);

        // get data from intent
        imageList = (ArrayList<Guns>) getIntent().getSerializableExtra("imageList");
        int position = getIntent().getIntExtra("position", 0);

        ImageViewPager pagerAdapter = new ImageViewPager(SingleImageActivity.this, imageList);
        singleImageViewPager.setAdapter(pagerAdapter);
        singleImageViewPager.setCurrentItem(position);

        currentPosition = singleImageViewPager.getCurrentItem();
        singleImageViewPager.addOnPageChangeListener(this);

        // adapters click listeners
        pagerAdapter.setOnShareImageClickListener(new ImageViewPager.onShareImageClickListener() {
            @Override
            public void onShareImage(ImageView imageView, int position) {
                shareCurrentImageFile();
            }
        });
        pagerAdapter.setOnSaveImageClickListener(new ImageViewPager.onSaveImageClickListener() {
            @Override
            public void onSaveImage(ImageView imageView, int position) {
                downloadCurrentImage();
            }
        });
        pagerAdapter.setOnSetWallPaperClickListener(new ImageViewPager.onSetWallPaperClickListener() {
            @Override
            public void onsetWallPaperClick(ImageView imageView, int position) {
                setWallpaper(singleImageViewPager.getCurrentItem());
            }
        });

    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {
    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        try {
            return super.onTouchEvent(ev);
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    // set click listener on option item of app bar
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    // #####-----> Functions to Save Current Image in Gallery <-----#####
    // Method to Download the Current Image
    private void downloadCurrentImage() {
        if (checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            // Permission is already granted, proceed with the download
            performDownload();
        } else {
            // Request the permission from the user
            requestStoragePermission();
        }
        performDownload();
    }

    // Method to check the Runtime Permission
    private void requestStoragePermission() {
        if (shouldShowRequestPermissionRationale(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            // Show an explanation to the user if needed
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Permission needed");
            builder.setMessage("This permission is required to save images to your device's gallery.");
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    requestPermissions(new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, PERMISSION_REQUEST_CODE);
                }
            });
            builder.setNegativeButton("Cancel", null);
            builder.create().show();
        } else {
            // Request the permission directly
            requestPermissions(new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, PERMISSION_REQUEST_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission is granted, proceed with the download
                performDownload();
            } else {
                // Permission is denied, show a message or handle accordingly
//                Toast.makeText(this, "Permission denied, cannot download the image.", Toast.LENGTH_SHORT).show();
            }
        }
    }

    // Method to download the image and save to gallery
    private void performDownload() {
        currentPosition = singleImageViewPager.getCurrentItem();
        int imageResourceId = imageList.get(currentPosition).getImage();
        Drawable drawable = ContextCompat.getDrawable(this, imageResourceId);

        Bitmap bitmap = null;
        if (drawable instanceof BitmapDrawable) {
            bitmap = ((BitmapDrawable) drawable).getBitmap();
        } else {
            bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
        }

        // Save the Bitmap to the device's gallery (MediaStore)
        String fileName = "image.jpg";
        ContentValues values = new ContentValues();
        values.put(MediaStore.Images.Media.DISPLAY_NAME, fileName);
        values.put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg");
        values.put(MediaStore.Images.Media.WIDTH, bitmap.getWidth());
        values.put(MediaStore.Images.Media.HEIGHT, bitmap.getHeight());

        ContentResolver resolver = getContentResolver();
        Uri imageUri = resolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);

        try {
            OutputStream outputStream = resolver.openOutputStream(imageUri);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
            if (outputStream != null) {
                outputStream.close();
            }

            Toast.makeText(this, "Image saved to gallery", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Failed to save image", Toast.LENGTH_SHORT).show();
        }
    }

    // #####-----> Functions to Share Current Image in Gallery <-----#####
    // Method to save Current image to cache fore share
    private File saveDrawableToCache(Drawable drawable) {
        Bitmap bitmap;
        if (drawable instanceof BitmapDrawable) {
            bitmap = ((BitmapDrawable) drawable).getBitmap();
        } else {
            bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
        }

        // Create a temporary file to store the image
        File tempFile;
        try {
            tempFile = File.createTempFile("image", ".jpg", getCacheDir());
            FileOutputStream outputStream = new FileOutputStream(tempFile);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return tempFile;
    }

    // Method to Share Current Image of ViewPager
    private void shareCurrentImageFile() {
        int imageResourceId = imageList.get(currentPosition).getImage();
        Drawable drawable = ContextCompat.getDrawable(this, imageResourceId);

        File imageFile = saveDrawableToCache(drawable);
        // Create a content URI for the file
        Uri contentUri = FileProvider.getUriForFile(this, getPackageName() + ".fileprovider", imageFile);

        // Create a share intent
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("image/jpeg");
        shareIntent.putExtra(Intent.EXTRA_STREAM, contentUri);
        shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

        // Start the share activity
        startActivity(Intent.createChooser(shareIntent, "Share Image"));
    }

    private void setWallpaper(int position) {
        currentPosition = position;


        int imageResourceId = imageList.get(currentPosition).getImage();
        Drawable drawable = ContextCompat.getDrawable(this, imageResourceId);

        Bitmap bitmap = null;
        if (drawable instanceof BitmapDrawable) {
            bitmap = ((BitmapDrawable) drawable).getBitmap();
        } else {
            bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
        }

        final Bitmap finalBitmap = bitmap;

        // Create a dialog to allow the user to choose between home screen and lock screen
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Set Wallpaper");
        builder.setMessage("Set as Home Screen or Lock Screen?");
        builder.setPositiveButton("Home Screen", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                setWallpaper(finalBitmap, WallpaperManager.FLAG_SYSTEM);
            }
        });
        builder.setNegativeButton("Lock Screen", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                setWallpaper(finalBitmap, WallpaperManager.FLAG_LOCK);
            }
        });
        builder.setNeutralButton("Cancel", null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void setWallpaper(Bitmap bitmap, int flag) {
        WallpaperManager wallpaperManager = WallpaperManager.getInstance(this);
        try {
            wallpaperManager.setBitmap(bitmap, null, true, flag);
            Toast.makeText(this, "Wallpaper set successfully", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Failed to set wallpaper", Toast.LENGTH_SHORT).show();
        }
    }


}




