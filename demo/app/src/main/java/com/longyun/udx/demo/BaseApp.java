package com.longyun.udx.demo;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import com.longyun.udx.sdk.SdkInitListener;
import com.longyun.udx.sdk.UDX;

public class BaseApp
        extends Application
{

    private final String TAG = BaseApp.class.getSimpleName();

    @Override
    public void onCreate()
    {
        super.onCreate();

//        UDXConfig config = new UDXConfig.Builder()
//                .setAppId("VJ0DPE")
//                .build();
//
//        UDXSdk.init(this, config, new UDXSdk.UDXInitCallback() {
//            @Override
//            public void success() {
//                Log.i("BaseApp", "init success");
//            }
//
//            @Override
//            public void fail(int code, String msg) {
//                Log.i("BaseApp", "init fail code:" + code + " msg:" + msg);
//            }
//        });

        UDX.init(this, "6S0RYA", new SdkInitListener() {
            public void onInitSuccess() {
                Log.i(TAG, "UDX SDK initialized");
                Toast.makeText(BaseApp.this, "UDX SDK initialized", Toast.LENGTH_SHORT).show();
            }

            public void onInitError() {
                Log.i(TAG, "UDX SDK failed to initialize");
                Toast.makeText(BaseApp.this, "UDX SDK failed to initialize", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
