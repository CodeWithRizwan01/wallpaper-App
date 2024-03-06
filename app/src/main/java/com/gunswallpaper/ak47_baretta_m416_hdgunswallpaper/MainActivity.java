package com.gunswallpaper.ak47_baretta_m416_hdgunswallpaper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;

import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkConfiguration;
import com.gunswallpaper.ak47_baretta_m416_hdgunswallpaper.Fragment.FavoriteFragment;
import com.gunswallpaper.ak47_baretta_m416_hdgunswallpaper.Fragment.HomeFragment;
import com.gunswallpaper.ak47_baretta_m416_hdgunswallpaper.R;
import com.google.android.material.navigation.NavigationView;
import com.onesignal.OneSignal;


public class MainActivity extends AppCompatActivity {
    boolean exitFlag = false;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    private static final String ONESIGNAL_APP_ID = "bc25086e-02ca-4fd1-93f2-88fdcc110340";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // -----> call method for one signal app notification
        oneSignal();

        AppLovinSdk.getInstance( this ).setMediationProvider( "max" );
        AppLovinSdk.initializeSdk( this, new AppLovinSdk.SdkInitializationListener() {
            @Override
            public void onSdkInitialized(final AppLovinSdkConfiguration configuration)
            {
                // AppLovin SDK is initialized, start loading ads
                AppLovinSdk.getInstance( MainActivity.this ).showMediationDebugger();

            }
        });

        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigationView);
        toolbar = findViewById(R.id.toolBar);

        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.OPenDrawer, R.string.CloseDrawer);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        homeFragmentLoad(new HomeFragment());

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.itemHome){
                    homeFragmentLoad(new HomeFragment());
                    getSupportActionBar().setTitle("Gun Wallpaper");
                }
                else if (id == R.id.itemFavorite){
                    favoriteFragmentLoad(new FavoriteFragment());
                    getSupportActionBar().setTitle("Favorite");
                }
                else if (id == R.id.itemShare){
                    shareAppLink();
                }
                else if (id == R.id.itemRate){
                    rateOurApp();
                }
                else if (id == R.id.itemMoreApps){
                    moreOurApp();
                }

                drawerLayout.closeDrawer(GravityCompat.START);

                return true;
            }
        });

    }

    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else {
            showDialog();
            if (exitFlag){
                super.onBackPressed();
            }
        }
    }

    public void showDialog() {
        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this)
                .setCancelable(false)
                .setTitle("Exit")
                .setMessage("Are you sure you want to Exit?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        exitFlag = true;
                        finish();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        exitFlag = false;
                        dialog.dismiss();
                    }
                })
                .create();
        alertDialog.show();
    }


    private void homeFragmentLoad(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        ft.add(R.id.container, fragment);
        ft.commit();

    }


    private void favoriteFragmentLoad(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        ft.add(R.id.container, fragment);
        ft.commit();
    }

    // Option --> share app
    private void shareAppLink() {
        Intent myIntent = new Intent(Intent.ACTION_SEND);
        myIntent.setType("text/plain");
        String body = "https://play.google.com/store/apps/details?id=" + getPackageName();
        String sub = "Your Subject";
        myIntent.putExtra(Intent.EXTRA_SUBJECT, sub);
        myIntent.putExtra(Intent.EXTRA_TEXT, body);
        startActivity(Intent.createChooser(myIntent, "Share Using"));
    }

    // Option --> Rate our app
    private void rateOurApp() {
        try {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("market://details?id=" + getPackageName())));
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://play.google.com/store/apps/details?id=" + getPackageName())));
        }
    }

    // Option --> More app
    private void moreOurApp() {
        try {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("market://search?q=pub:" + "Codingkey")));
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://play.google.com/store/apps/developer?id=Codingkey")));
        }
    }

    public void oneSignal(){
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE);

        // OneSignal Initialization
        OneSignal.initWithContext(this);
        OneSignal.setAppId(ONESIGNAL_APP_ID);
    }

}