package com.longyun.udx.demo.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.longyun.udx.demo.R;

public class MainActivity extends AppCompatActivity {

    private final  static String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_reward).setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, RewardVideoActivity.class);
            startActivity(intent);
        });

        findViewById(R.id.btn_interstitial).setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, InterstitialActivity.class);
            startActivity(intent);
        });
    }
}