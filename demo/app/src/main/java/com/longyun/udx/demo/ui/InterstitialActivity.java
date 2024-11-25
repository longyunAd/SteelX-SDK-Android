package com.longyun.udx.demo.ui;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

import com.longyun.udx.demo.R;
import com.blankj.utilcode.util.ToastUtils;
import com.longyun.udx.sdk.AdError;
import com.longyun.udx.sdk.UDXInterstitialAd;

public class InterstitialActivity extends Activity {
    public static final String TAG = "RewardVideoActivity";
    private Button mLoadAd;
    private Button mShowAd;
    private UDXInterstitialAd mInterstitialAd;

    @SuppressWarnings("RedundantCast")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interstitial);
        findViewById(R.id.btn_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mLoadAd = (Button) findViewById(R.id.btn_load);
        mShowAd = (Button) findViewById(R.id.btn_show);
        initClickEvent();
    }

    private void initClickEvent() {
        mLoadAd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadAd();
            }
        });
        mShowAd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mInterstitialAd != null) {
                    mInterstitialAd.showAd();
                    mInterstitialAd = null;
                } else {
                    ToastUtils.showShort("Please load the ad first !");
                }
            }
        });
    }

    private void loadAd() {
        mInterstitialAd = new UDXInterstitialAd(this, "S780NI");
        mInterstitialAd.setListener(new UDXInterstitialAd.Listener() {
            @Override
            public void onAdHidden() {
                Log.i(TAG, "onAdHidden");
                ToastUtils.showShort("interstitialAd onAdHidden");
            }

            @Override
            public void onAdLoaded() {
                Log.i(TAG, "onAdLoaded: ");
                ToastUtils.showShort("interstitialAd onAdLoaded");
            }

            @Override
            public void onAdLoadFailed() {
                Log.i(TAG, "onAdFailedToLoad:");
                ToastUtils.showShort("interstitialAd onAdFailedToLoad");
            }

            @Override
            public void onAdDisplayed() {
                Log.i(TAG, "onAdDisplayed");
                ToastUtils.showShort("interstitialAd onAdDisplayed");
            }

            @Override
            public void onAdClicked() {
                Log.i(TAG, "onAdClicked");
                ToastUtils.showShort("interstitialAd onAdClicked");
            }

            @Override
            public void onAdError(AdError adError) {
                Log.i(TAG, "onAdError");
                ToastUtils.showShort("interstitialAd onAdError");
            }
        });
        mInterstitialAd.loadAd();
    }
}
