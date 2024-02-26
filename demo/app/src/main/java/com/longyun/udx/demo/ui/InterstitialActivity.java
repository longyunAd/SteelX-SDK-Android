package com.longyun.udx.demo.ui;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

import com.longyun.udx.demo.R;
import com.blankj.utilcode.util.ToastUtils;
import com.longyun.udx.sdk.UDXAd;
import com.longyun.udx.sdk.UDXError;
import com.longyun.udx.sdk.inters.UDXInterstitialAd;
import com.longyun.udx.sdk.inters.UDXInterstitialAdListener;

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
                    mInterstitialAd.show(InterstitialActivity.this);
                    mInterstitialAd = null;
                } else {
                    ToastUtils.showShort("Please load the ad first !");
                }
            }
        });
    }

    private void loadAd() {
        new UDXInterstitialAd().loadAd("S7S0BU", null, new UDXInterstitialAdListener() {

            @Override
            public void onAdLoaded(UDXAd ad) {
                Log.i(TAG, "onAdLoaded: ");
                ToastUtils.showShort("interstitialAd onAdLoaded");
                mInterstitialAd = (UDXInterstitialAd) ad;
            }

            @Override
            public void onAdFailedToLoad(String adUnitId, UDXError error) {
                Log.i(TAG, "onAdFailedToLoad code:"+error.getCode()+"msg:"+error.getMessage());
                ToastUtils.showShort("interstitialAd onAdFailedToLoad code:"+error.getCode()+"msg:"+error.getMessage());
            }

            @Override
            public void onAdDisplayFailed(UDXAd ad, UDXError error) {
                Log.i(TAG, "onAdDisplayFailed code:"+error.getCode()+"msg:"+error.getMessage());
                ToastUtils.showShort("interstitialAd onAdDisplayFailed code:"+error.getCode()+"msg:"+error.getMessage());
            }

            @Override
            public void onAdDisplayed(UDXAd ad) {
                Log.i(TAG, "onAdDisplayed");
                ToastUtils.showShort("interstitialAd onAdDisplayed");
            }

            @Override
            public void onAdClicked(UDXAd ad) {
                Log.i(TAG, "onAdClicked");
                ToastUtils.showShort("interstitialAd onAdClicked");
            }

            @Override
            public void onAdHidden(UDXAd ad) {
                Log.i(TAG, "onAdHidden");
                ToastUtils.showShort("interstitialAd onAdHidden");
            }
        });
    }
}
