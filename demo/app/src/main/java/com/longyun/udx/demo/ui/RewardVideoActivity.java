package com.longyun.udx.demo.ui;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

import com.blankj.utilcode.util.ToastUtils;
import com.longyun.udx.demo.R;
import com.longyun.udx.sdk.UDXAd;
import com.longyun.udx.sdk.UDXError;
import com.longyun.udx.sdk.reward.UDXReward;
import com.longyun.udx.sdk.reward.UDXRewardedAd;
import com.longyun.udx.sdk.reward.UDXRewardedAdListener;

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
                    mRewardedAd.show(RewardVideoActivity.this);
                    mRewardedAd = null;
                } else {
                    ToastUtils.showShort("Please load the ad first !");
                }
            }
        });
    }

    private void loadAd() {
        new UDXRewardedAd().loadAd("S7E0YS", null, new UDXRewardedAdListener() {
            @Override
            public void onRewardedVideoStarted(UDXAd ad) {
                Log.i(TAG, "onRewardedVideoStarted");
                ToastUtils.showShort("rewardVideoAd onRewardedVideoStarted");
            }

            @Override
            public void onRewardedVideoCompleted(UDXAd ad) {
                Log.i(TAG, "onRewardedVideoCompleted");
                ToastUtils.showShort("rewardVideoAd onRewardedVideoCompleted");
            }

            @Override
            public void onUserRewarded(UDXAd ad, UDXReward reward) {
                Log.i(TAG, "onUserRewarded" + reward.isReward());
                ToastUtils.showShort("rewardVideoAd onUserRewarded");
            }

            @Override
            public void onAdLoaded(UDXAd ad) {
                Log.i(TAG,"onAdLoaded");
                ToastUtils.showShort("rewardVideoAd onAdLoaded");
                mRewardedAd = (UDXRewardedAd) ad;
            }

            @Override
            public void onAdFailedToLoad(String adUnitId, UDXError error) {
                Log.i(TAG,"onAdFailedToLoad code:"+error.getCode()+" msg:"+error.getMessage());
                ToastUtils.showShort("rewardVideoAd onAdFailedToLoad code:"+error.getCode()+" msg:"+error.getMessage());
            }

            @Override
            public void onAdDisplayFailed(UDXAd ad, UDXError error) {
                Log.i(TAG,"onAdDisplayFailed code:"+error.getCode()+" msg:"+error.getMessage());
                ToastUtils.showShort("rewardVideoAd onAdDisplayFailed code:"+error.getCode()+" msg:"+error.getMessage());
            }

            @Override
            public void onAdDisplayed(UDXAd ad) {
                Log.i(TAG,"onAdDisplayed");
                ToastUtils.showShort("rewardVideoAd onAdDisplayed");
            }

            @Override
            public void onAdClicked(UDXAd ad) {
                Log.i(TAG,"onAdClicked");
                ToastUtils.showShort("rewardVideoAd onAdClicked");
            }

            @Override
            public void onAdHidden(UDXAd ad) {
                Log.i(TAG,"onAdHidden");
                ToastUtils.showShort("rewardVideoAd onAdHidden");
            }
        });
    }
}
