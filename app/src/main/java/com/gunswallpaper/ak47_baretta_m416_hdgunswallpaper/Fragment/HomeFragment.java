package com.gunswallpaper.ak47_baretta_m416_hdgunswallpaper.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AlertDialog;

import android.content.DialogInterface;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.ads.MaxAdView;
import com.applovin.mediation.ads.MaxInterstitialAd;
import com.applovin.mediation.nativeAds.MaxNativeAdListener;
import com.applovin.mediation.nativeAds.MaxNativeAdLoader;
import com.applovin.mediation.nativeAds.MaxNativeAdView;
import com.gunswallpaper.ak47_baretta_m416_hdgunswallpaper.Activity.ImageActivity;
import com.gunswallpaper.ak47_baretta_m416_hdgunswallpaper.R;

import java.util.concurrent.TimeUnit;


public class HomeFragment extends Fragment {

    // For InterStial Ad-App-Lovin
    private MaxInterstitialAd interstitialAd;
    private int retryAttempt;
    int addCounter = 0;

    // For Banner Ad-App-Lovin
    MaxAdView maxBanner;

    // For Native Ad-App-Lovin
    FrameLayout nativeAdContainer;
    private MaxNativeAdLoader nativeAdLoader;
    private MaxAd nativeAd;

    LinearLayout linearLayoutAK47, linearLayoutM416, linearLayout9mm, linearLayoutSniper, linearLayoutMossberg,
            linearLayoutTommy, linearLayoutAR_15, linearLayoutM16A1, linearLayoutP90, linearLayoutType95, linearLayoutUMP45,
            linearLayoutKalashnikov, linearLayoutBeretta;

    @Override
    public void onDestroy() {
        super.onDestroy();
        showDialog();
    }

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // -----> Banner AppLovin Ad
        maxBanner = view.findViewById(R.id.maxBannerAd);
        maxBanner.setVisibility(View.VISIBLE);
        maxBanner.loadAd();

        // interstitial add applovin
        createInterstitialAd();

        // -----> for Native AppLovin Ads
        nativeAdContainer = view.findViewById(R.id.nativeAdLayout);
        // -----> Call Method createNativeAd() in Main() Method
        createNativeAd();

        linearLayoutAK47 = view.findViewById(R.id.linearLayoutAK47);
        linearLayoutM416 = view.findViewById(R.id.linearLayoutM416);
        linearLayout9mm = view.findViewById(R.id.linearLayout9mm);
        linearLayoutSniper = view.findViewById(R.id.linearLayoutSniper);
        linearLayoutMossberg = view.findViewById(R.id.linearLayoutMossberg);
        linearLayoutTommy = view.findViewById(R.id.linearLayoutTommy);
        linearLayoutAR_15 = view.findViewById(R.id.linearLayoutAR_15);
        linearLayoutM16A1 = view.findViewById(R.id.linearLayoutM16A1);
        linearLayoutP90 = view.findViewById(R.id.linearLayoutP90);
        linearLayoutType95 = view.findViewById(R.id.linearLayoutType95);
        linearLayoutUMP45 = view.findViewById(R.id.linearLayoutUMP45);
        linearLayoutKalashnikov = view.findViewById(R.id.linearLayoutKalashnikov);
        linearLayoutBeretta = view.findViewById(R.id.linearLayoutBeretta);

        linearLayoutAK47.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (addCounter == 1) {
                    if (interstitialAd.isReady()) {
                        interstitialAd.showAd();
                    }
                    addCounter = 0;
                } else {
                    addCounter++;
                }
                Intent intent = new Intent(getActivity(), ImageActivity.class);
                intent.putExtra("layoutContent", 1);
                startActivity(intent);
            }
        });
        linearLayoutM416.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (addCounter == 1) {
                    if (interstitialAd.isReady()) {
                        interstitialAd.showAd();
                    }
                    addCounter = 0;
                } else {
                    addCounter++;
                }
                Intent intent = new Intent(getActivity(), ImageActivity.class);
                intent.putExtra("layoutContent", 2);
                startActivity(intent);
            }
        });
        linearLayoutKalashnikov.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (addCounter == 1) {
                    if (interstitialAd.isReady()) {
                        interstitialAd.showAd();
                    }
                    addCounter = 0;
                } else {
                    addCounter++;
                }
                Intent intent = new Intent(getActivity(), ImageActivity.class);
                intent.putExtra("layoutContent", 3);
                startActivity(intent);
            }
        });
        linearLayoutBeretta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (addCounter == 1) {
                    if (interstitialAd.isReady()) {
                        interstitialAd.showAd();
                    }
                    addCounter = 0;
                } else {
                    addCounter++;
                }
                Intent intent = new Intent(getActivity(), ImageActivity.class);
                intent.putExtra("layoutContent", 4);
                startActivity(intent);
            }
        });
        linearLayoutAR_15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (addCounter == 1) {
                    if (interstitialAd.isReady()) {
                        interstitialAd.showAd();
                    }
                    addCounter = 0;
                } else {
                    addCounter++;
                }
                Intent intent = new Intent(getActivity(), ImageActivity.class);
                intent.putExtra("layoutContent", 5);
                startActivity(intent);
            }
        });
        linearLayoutSniper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (addCounter == 1) {
                    if (interstitialAd.isReady()) {
                        interstitialAd.showAd();
                    }
                    addCounter = 0;
                } else {
                    addCounter++;
                }
                Intent intent = new Intent(getActivity(), ImageActivity.class);
                intent.putExtra("layoutContent", 6);
                startActivity(intent);
            }
        });
        linearLayoutMossberg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (addCounter == 1) {
                    if (interstitialAd.isReady()) {
                        interstitialAd.showAd();
                    }
                    addCounter = 0;
                } else {
                    addCounter++;
                }
                Intent intent = new Intent(getActivity(), ImageActivity.class);
                intent.putExtra("layoutContent", 7);
                startActivity(intent);
            }
        });
        linearLayoutTommy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (addCounter == 1) {
                    if (interstitialAd.isReady()) {
                        interstitialAd.showAd();
                    }
                    addCounter = 0;
                } else {
                    addCounter++;
                }
                Intent intent = new Intent(getActivity(), ImageActivity.class);
                intent.putExtra("layoutContent", 8);
                startActivity(intent);
            }
        });
        linearLayout9mm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (addCounter == 1) {
                    if (interstitialAd.isReady()) {
                        interstitialAd.showAd();
                    }
                    addCounter = 0;
                } else {
                    addCounter++;
                }
                Intent intent = new Intent(getActivity(), ImageActivity.class);
                intent.putExtra("layoutContent", 9);
                startActivity(intent);
            }
        });
        linearLayoutM16A1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (addCounter == 1) {
                    if (interstitialAd.isReady()) {
                        interstitialAd.showAd();
                    }
                    addCounter = 0;
                } else {
                    addCounter++;
                }
                Intent intent = new Intent(getActivity(), ImageActivity.class);
                intent.putExtra("layoutContent", 10);
                startActivity(intent);
            }
        });
        linearLayoutP90.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (addCounter == 1) {
                    if (interstitialAd.isReady()) {
                        interstitialAd.showAd();
                    }
                    addCounter = 0;
                } else {
                    addCounter++;
                }
                Intent intent = new Intent(getActivity(), ImageActivity.class);
                intent.putExtra("layoutContent", 11);
                startActivity(intent);
            }
        });
        linearLayoutType95.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (addCounter == 1) {
                    if (interstitialAd.isReady()) {
                        interstitialAd.showAd();
                    }
                    addCounter = 0;
                } else {
                    addCounter++;
                }
                Intent intent = new Intent(getActivity(), ImageActivity.class);
                intent.putExtra("layoutContent", 12);
                startActivity(intent);
            }
        });
        linearLayoutUMP45.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (addCounter == 1) {
                    if (interstitialAd.isReady()) {
                        interstitialAd.showAd();
                    }
                    addCounter = 0;
                } else {
                    addCounter++;
                }
                Intent intent = new Intent(getActivity(), ImageActivity.class);
                intent.putExtra("layoutContent", 13);
                startActivity(intent);
            }
        });

        return view;
    }

    public void showDialog() {
        AlertDialog alertDialog = new AlertDialog.Builder(requireActivity()).setCancelable(false).setTitle("Exit").setMessage("Are you sure you want to Exit?").setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        }).create();
        alertDialog.show();
    }

    void createInterstitialAd() {
        interstitialAd = new MaxInterstitialAd( "2b191cc7b00e56b4", getActivity() );
        interstitialAd.setListener(new MaxAdListener() {
            // MAX Ad Listener
            @Override
            public void onAdLoaded(final MaxAd maxAd)
            {
                // Interstitial ad is ready to be shown. interstitialAd.isReady() will now return 'true'
                // Reset retry attempt
                retryAttempt = 0;
            }

            @Override
            public void onAdLoadFailed(final String adUnitId, final MaxError error)
            {
                // Interstitial ad failed to load
                // AppLovin recommends that you retry with exponentially higher delays up to a maximum delay (in this case 64 seconds)
                retryAttempt++;
                long delayMillis = TimeUnit.SECONDS.toMillis( (long) Math.pow( 2, Math.min( 6, retryAttempt ) ) );

                new Handler().postDelayed(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        interstitialAd.loadAd();
                    }
                }, delayMillis );
            }

            @Override
            public void onAdDisplayFailed(final MaxAd maxAd, final MaxError error)
            {
                // Interstitial ad failed to display. AppLovin recommends that you load the next ad.
                interstitialAd.loadAd();
            }

            @Override
            public void onAdDisplayed(final MaxAd maxAd) {
            }

            @Override
            public void onAdClicked(final MaxAd maxAd) {
            }

            @Override
            public void onAdHidden(final MaxAd maxAd)
            {
                // Interstitial ad is hidden. Pre-load the next ad
                interstitialAd.loadAd();
            }
        });

        // Load the first ad
        interstitialAd.loadAd();
    }

    void createNativeAd() {
        nativeAdLoader = new MaxNativeAdLoader("f29d9f7a118daaf3", getContext());
        nativeAdLoader.setNativeAdListener(new MaxNativeAdListener() {
            @Override
            public void onNativeAdLoaded(final MaxNativeAdView nativeAdView, final MaxAd ad) {
                // Clean up any pre-existing native ad to prevent memory leaks.
                if (nativeAd != null) {
                    nativeAdLoader.destroy(nativeAd);
                }

                // Save ad for cleanup.
                nativeAd = ad;

                // Add ad view to view.
                nativeAdContainer.removeAllViews();
                nativeAdContainer.addView(nativeAdView);
            }

            @Override
            public void onNativeAdLoadFailed(final String adUnitId, final MaxError error) {
                // We recommend retrying with exponentially higher delays up to a maximum delay
            }

            @Override
            public void onNativeAdClicked(final MaxAd ad) {
                // Optional click callback
            }
        });

        nativeAdLoader.loadAd();
    }


}