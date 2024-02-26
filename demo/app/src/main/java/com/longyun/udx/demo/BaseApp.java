package com.longyun.udx.demo;

import android.app.Application;
import android.util.Log;

import com.longyun.udx.sdk.SXConfig;
import com.longyun.udx.sdk.SXSdk;

public class BaseApp
        extends Application
{
    @Override
    public void onCreate()
    {
        super.onCreate();

        SXConfig config = new SXConfig.Builder()
                .setAppId("VJ0DPE")
                .build();

        SXSdk.init(this, config, new SXSdk.SLInitCallback() {
            @Override
            public void success() {
                Log.i("BaseApp", "init success");
            }

            @Override
            public void fail(int code, String msg) {
                Log.i("BaseApp", "init fail code:" + code + " msg:" + msg);
            }
        });
    }
}
