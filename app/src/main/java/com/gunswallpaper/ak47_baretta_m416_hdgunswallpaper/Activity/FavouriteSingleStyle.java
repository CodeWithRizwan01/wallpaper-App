package com.gunswallpaper.ak47_baretta_m416_hdgunswallpaper.Activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.viewpager.widget.ViewPager;

import android.app.WallpaperManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.widget.ImageView;
import android.widget.Toast;

import com.gunswallpaper.ak47_baretta_m416_hdgunswallpaper.MainActivity;
import com.gunswallpaper.ak47_baretta_m416_hdgunswallpaper.MyDb.DbHelper;
import com.gunswallpaper.ak47_baretta_m416_hdgunswallpaper.MyDb.DbModel;
import com.gunswallpaper.ak47_baretta_m416_hdgunswallpaper.R;
import com.gunswallpaper.ak47_baretta_m416_hdgunswallpaper.ViewPager.FavouriteSingleViewPager;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;


public class FavouriteSingleStyle extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    ViewPager favouriteSingleViewPager;
    ArrayList<DbModel> favouriteImageList = new ArrayList<>();
    int currentPosition;
    DbHelper dbHelper;
    FavouriteSingleViewPager viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite_single_style);

        favouriteSingleViewPager = findViewById(R.id.favouriteSingleImageViewPager);

        int position = getIntent().getIntExtra("position", 0);

        dbHelper = DbHelper.getInstance(FavouriteSingleStyle.this);
        favouriteImageList = (ArrayList<DbModel>) dbHelper.getAllImages();

        viewPagerAdapter = new FavouriteSingleViewPager(FavouriteSingleStyle.this, favouriteImageList);
        favouriteSingleViewPager.setAdapter(viewPagerAdapter);
        favouriteSingleViewPager.setCurrentItem(position);

        currentPosition = favouriteSingleViewPager.getCurrentItem();
        favouriteSingleViewPager.addOnPageChangeListener(this);

        viewPagerAdapter.setOnFavouriteClickListener(new FavouriteSingleViewPager.onFavouriteClickListener() {
            @Override
            public void onFavourite(ImageView image, ImageView icon, int position) {
                unFavouriteImage();
                icon.setImageResource(R.drawable.baseline_favorite_border_24);
            }
        });
        viewPagerAdapter.setOnShareImageClickListener(new FavouriteSingleViewPager.onShareImageClickListener() {
            @Override
            public void onShareImage(ImageView image, int position) {
                shareCurrentImage();
            }
        });
        viewPagerAdapter.setOnSaveImageClickListener(new FavouriteSingleViewPager.onSaveImageClickListener() {
            @Override
            public void onSaveImage(ImageView image, int position) {
                saveImageToGallery();
                Toast.makeText(FavouriteSingleStyle.this, "Image Saved to Gallery", Toast.LENGTH_SHORT).show();
            }
        });

        viewPagerAdapter.setOnSetWallPaperClickListener(new FavouriteSingleViewPager.onSetWallPaperClickListener() {
            @Override
            public void onsetWallPaperClick(ImageView imageView, int position) {
                setWallpaper(favouriteSingleViewPager.getCurrentItem());
            }
        });

    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(FavouriteSingleStyle.this, MainActivity.class));
        super.onBackPressed();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {
        currentPosition = position;
    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }


    // Favourite Images toggle to unFavorite
    void unFavouriteImage() {
        int position = favouriteSingleViewPager.getCurrentItem();
        int deleteId = favouriteImageList.get(position).getId();
        dbHelper.deleteImage(deleteId);

        favouriteImageList.remove(position);
        viewPagerAdapter.notifyDataSetChanged();

        // Update the ViewPager's current item
        if (favouriteImageList.size() > 0) {
            int newPosition = position - 1;
            if (newPosition < 0) {
                newPosition = 0;
            }
            favouriteSingleViewPager.setCurrentItem(newPosition);
        } else {
            startActivity(new Intent(FavouriteSingleStyle.this, MainActivity.class));
            Toast.makeText(this, "Your Favourite List is Empty", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
    // #####-----> Functions to Share Current Image in Gallery <-----#####
    void shareCurrentImage() {
        byte[] imageData = favouriteImageList.get(currentPosition).getImage();

        try {
            File tempFile = File.createTempFile("shared_image", ".jpg", getExternalCacheDir());
            FileOutputStream fos = new FileOutputStream(tempFile);
            fos.write(imageData);
            fos.close();
            // Generate a content:// URI using FileProvider
            Uri imageUri = FileProvider.getUriForFile(this, getPackageName() + ".fileprovider", tempFile);
            // Share the image
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("image/jpeg");
            shareIntent.putExtra(Intent.EXTRA_STREAM, imageUri);
            shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            startActivity(Intent.createChooser(shareIntent, "Share Image"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // #####-----> Functions to Save Current Image in Gallery <-----#####
    void saveImageToGallery() {
        byte[] imageData = favouriteImageList.get(currentPosition).getImage();

        File imageFile = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "shared_image.jpg");
        try {
            FileOutputStream fos = new FileOutputStream(imageFile);
            fos.write(imageData);
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
            // Handle error in file creation or writing
        }

        // Create a BroadcastReceiver to receive the media scanner completion notification
        BroadcastReceiver mediaScanReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                // Handle media scanner completion
            }
        };

        // Register the BroadcastReceiver to receive the media scanner completion notification
        IntentFilter intentFilter = new IntentFilter(Intent.ACTION_MEDIA_SCANNER_FINISHED);
        intentFilter.addDataScheme("file");
        registerReceiver(mediaScanReceiver, intentFilter);

        // Trigger the media scanner to scan the saved image file
        MediaScannerConnection.scanFile(this, new String[]{imageFile.getAbsolutePath()}, null, null);
    }


    private void setWallpaper(int position) {
        currentPosition = position;

        byte[] imageResourceId = favouriteImageList.get(currentPosition).getImage();
        Bitmap bitmap = BitmapFactory.decodeByteArray(imageResourceId, 0, imageResourceId.length);

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