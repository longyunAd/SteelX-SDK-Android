package com.longyun.udx.demo.ui;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

import com.blankj.utilcode.util.ToastUtils;
import com.longyun.udx.demo.R;
import com.longyun.udx.sdk.AdError;
import com.longyun.udx.sdk.UDXRewardedAd;

public class RewardVideoActivity extends Activity {
    public static final String TAG = "RewardVideoActivity";
    private Button mLoadAd;
    private Button mShowAd;
    private UDXRewardedAd mRewardedAd;

    @SuppressWarnings("RedundantCast")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reward_video);
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
                if (mRewardedAd != null) {
                    mRewardedAd.showAd();
                    mRewardedAd = null;
                } else {
                    ToastUtils.showShort("Please load the ad first !");
                }
            }
        });
    }

    private void loadAd() {
//        mRewardedAd = new UDXRewardedAd(this, "S780NI");
        mRewardedAd = new UDXRewardedAd(this, "S7E0YS");
        mRewardedAd.setListener(new UDXRewardedAd.Listener() {

            @Override
            public void onAdHidden() {
                Log.i(TAG, "onAdHidden: ");
                ToastUtils.showShort("RewardedAd onAdHidden");
            }

            @Override
            public void onUserRewarded() {
                Log.i(TAG, "onUserRewarded: ");
                ToastUtils.showShort("RewardedAd onUserRewarded");
            }

            @Override
            public void onAdLoaded() {
                Log.i(TAG, "onAdLoaded: ");
                ToastUtils.showShort("RewardedAd onAdLoaded");
            }

            @Override
            public void onAdLoadFailed() {
                Log.i(TAG, "onAdLoadFailed: ");
                ToastUtils.showShort("RewardedAd onAdLoadFailed");
            }

            @Override
            public void onAdDisplayed() {
                Log.i(TAG, "onAdDisplayed: ");
                ToastUtils.showShort("RewardedAd onAdDisplayed");
            }

            @Override
            public void onAdClicked() {
                Log.i(TAG, "onAdClicked: ");
                ToastUtils.showShort("RewardedAd onAdClicked");
            }

            @Override
            public void onAdError(AdError adError) {
                Log.i(TAG, "onAdError: ");
                ToastUtils.showShort("RewardedAd onAdError");
            }
        });
        mRewardedAd.loadAd();
    }
}
