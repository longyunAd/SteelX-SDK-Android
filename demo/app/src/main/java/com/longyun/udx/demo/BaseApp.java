package com.longyun.udx.demo;

import android.app.Application;
import android.util.Log;

import com.longyun.udx.sdk.UDXConfig;
import com.longyun.udx.sdk.UDXSdk;

public class BaseApp
        extends Application
{
    @Override
    public void onCreate()
    {
        super.onCreate();

        UDXConfig config = new UDXConfig.Builder()
                .setAppId("VJ0DPE")
                .build();

        UDXSdk.init(this, config, new UDXSdk.UDXInitCallback() {
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
