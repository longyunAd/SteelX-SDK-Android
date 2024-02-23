package com.longyun.steelx.demo.ui;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

import com.longyun.steelx.demo.R;
import com.blankj.utilcode.util.ToastUtils;
import com.longyun.steelx.sdk.SXAd;
import com.longyun.steelx.sdk.SXError;
import com.longyun.steelx.sdk.inters.SXInterstitialAd;
import com.longyun.steelx.sdk.inters.SXInterstitialAdListener;

public class InterstitialActivity extends Activity {
    public static final String TAG = "RewardVideoActivity";
    private Button mLoadAd;
    private Button mShowAd;
    private SXInterstitialAd mInterstitialAd;

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
                    mInterstitialAd.show(InterstitialActivity.this);
                    mInterstitialAd = null;
                } else {
                    ToastUtils.showShort("Please load the ad first !");
                }
            }
        });
    }

    private void loadAd() {
        new SXInterstitialAd().loadAd("S7S0BU", null, new SXInterstitialAdListener() {

            @Override
            public void onAdLoaded(SXAd ad) {
                Log.i(TAG, "onAdLoaded: ");
                ToastUtils.showShort("interstitialAd onAdLoaded");
                mInterstitialAd = (SXInterstitialAd) ad;
            }

            @Override
            public void onAdFailedToLoad(String adUnitId, SXError error) {
                Log.i(TAG, "onAdFailedToLoad code:"+error.getCode()+"msg:"+error.getMessage());
                ToastUtils.showShort("interstitialAd onAdFailedToLoad code:"+error.getCode()+"msg:"+error.getMessage());
            }

            @Override
            public void onAdDisplayFailed(SXAd ad, SXError error) {
                Log.i(TAG, "onAdDisplayFailed code:"+error.getCode()+"msg:"+error.getMessage());
                ToastUtils.showShort("interstitialAd onAdDisplayFailed code:"+error.getCode()+"msg:"+error.getMessage());
            }

            @Override
            public void onAdDisplayed(SXAd ad) {
                Log.i(TAG, "onAdDisplayed");
                ToastUtils.showShort("interstitialAd onAdDisplayed");
            }

            @Override
            public void onAdClicked(SXAd ad) {
                Log.i(TAG, "onAdClicked");
                ToastUtils.showShort("interstitialAd onAdClicked");
            }

            @Override
            public void onAdHidden(SXAd ad) {
                Log.i(TAG, "onAdHidden");
                ToastUtils.showShort("interstitialAd onAdHidden");
            }
        });
    }
}
