package com.gunswallpaper.ak47_baretta_m416_hdgunswallpaper.Fragment;

import android.os.Bundle;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.applovin.mediation.ads.MaxAdView;
import com.gunswallpaper.ak47_baretta_m416_hdgunswallpaper.Activity.FavouriteSingleStyle;
import com.gunswallpaper.ak47_baretta_m416_hdgunswallpaper.MyDb.DbHelper;
import com.gunswallpaper.ak47_baretta_m416_hdgunswallpaper.R;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.gunswallpaper.ak47_baretta_m416_hdgunswallpaper.Adapter.FavouriteDesignAdapter;
import com.gunswallpaper.ak47_baretta_m416_hdgunswallpaper.MyDb.DbModel;

import java.util.ArrayList;

public class FavoriteFragment extends Fragment {

    TextView tvFavouriteText;
    RecyclerView designRecyclerView;
    FavouriteDesignAdapter designAdapter;
    ArrayList<DbModel> favouriteDesignList = new ArrayList<>();
    DbHelper dbHelper;

    // For Banner Ad-App-Lovin
    MaxAdView maxBanner;

    public FavoriteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_favorite, container, false);

        // -----> Banner AppLovin Ad
        maxBanner = rootView.findViewById(R.id.maxBannerAd);
        maxBanner.setVisibility(View.VISIBLE);
        maxBanner.loadAd();

        // find all the values of ids
        dbHelper = DbHelper.getInstance(getContext());

        tvFavouriteText = rootView.findViewById(R.id.tvFavouriteListText);
        designRecyclerView = rootView.findViewById(R.id.favouriteDesignRecyclerView);
        designRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));

        DbHelper dbHelper = DbHelper.getInstance(getContext());
        favouriteDesignList = (ArrayList<DbModel>) dbHelper.getAllImages();

        if (favouriteDesignList.isEmpty()) {
            tvFavouriteText.setVisibility(View.VISIBLE);
        } else {
            designRecyclerView.setVisibility(View.VISIBLE);
        }

        // -----> Create Object of Adapter Class and set Adapter of RecyclerView
        designAdapter = new FavouriteDesignAdapter(favouriteDesignList);
        designRecyclerView.setAdapter(designAdapter);

        // adapter click listener
        designAdapter.setOnImageClickListener(new FavouriteDesignAdapter.onImageClickListener() {
            @Override
            public void onImageClick(ImageView image, int position) {
                Intent intent = new Intent(getContext(), FavouriteSingleStyle.class);
                intent.putExtra("position", position);
                startActivity(intent);
            }
        });


        return rootView;

    }
}