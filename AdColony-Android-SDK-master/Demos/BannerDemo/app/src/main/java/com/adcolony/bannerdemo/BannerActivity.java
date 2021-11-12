package com.adcolony.bannerdemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.adcolony.sdk.AdColony;
import com.adcolony.sdk.AdColonyAdOptions;
import com.adcolony.sdk.AdColonyAdSize;
import com.adcolony.sdk.AdColonyAdView;
import com.adcolony.sdk.AdColonyAdViewListener;
import com.adcolony.sdk.AdColonyAppOptions;
import com.adcolony.sdk.AdColonyZone;

public class BannerActivity extends Activity {

    private final String APP_ID = "INSERT_YOUR_APP_ID_HERE";
    private final String ZONE_ID = "INSERT_YOUR_BANNER_ZONE_ID_HERE";
    private final String TAG = "AdColonyBannerDemo";

    private AdColonyAdViewListener listener;
    private AdColonyAdOptions adOptions;
    private RelativeLayout adContainer;
    private ProgressBar progressBar;
    private Button buttonLoad;
    private AdColonyAdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adContainer = findViewById(R.id.ad_container);
        progressBar = findViewById(R.id.progress);
        buttonLoad = findViewById(R.id.load_button);
        buttonLoad.setOnClickListener(view -> {
            //Remove previous ad view if present.
            if (adContainer.getChildCount() > 0) {
                adContainer.removeView(adView);
            }

            progressBar.setVisibility(View.VISIBLE);
            buttonLoad.setEnabled(false);
            buttonLoad.setAlpha(0.5f);

            requestBannerAd();
        });

        // Construct optional app options object to be sent with configure
        AdColonyAppOptions appOptions = new AdColonyAppOptions();

        // Configure AdColony in your launching Activity's onCreate() method so that cached ads can
        // be available as soon as possible.
        AdColony.configure(this, appOptions, APP_ID, ZONE_ID);

        listener = new AdColonyAdViewListener() {
            @Override
            public void onRequestFilled(AdColonyAdView adColonyAdView) {
                Log.d(TAG, "onRequestFilled");
                resetUI();
                adContainer.addView(adColonyAdView);
                adView = adColonyAdView;
            }

            @Override
            public void onRequestNotFilled(AdColonyZone zone) {
                super.onRequestNotFilled(zone);
                Log.d(TAG, "onRequestNotFilled");
                resetUI();
            }

            @Override
            public void onOpened(AdColonyAdView ad) {
                super.onOpened(ad);
                Log.d(TAG, "onOpened");
            }

            @Override
            public void onClosed(AdColonyAdView ad) {
                super.onClosed(ad);
                Log.d(TAG, "onClosed");
            }

            @Override
            public void onClicked(AdColonyAdView ad) {
                super.onClicked(ad);
                Log.d(TAG, "onClicked");
            }

            @Override
            public void onLeftApplication(AdColonyAdView ad) {
                super.onLeftApplication(ad);
                Log.d(TAG, "onLeftApplication");
            }
        };
    }

    private void requestBannerAd() {
        // Optional Ad specific options to be sent with request
        adOptions = new AdColonyAdOptions();

        //Request Ad
        AdColony.requestAdView(ZONE_ID, listener, AdColonyAdSize.BANNER, adOptions);
    }

    private void resetUI() {
        progressBar.setVisibility(View.GONE);
        buttonLoad.setEnabled(true);
        buttonLoad.setAlpha(1.0f);
    }
}
