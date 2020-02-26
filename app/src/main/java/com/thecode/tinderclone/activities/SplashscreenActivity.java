package com.thecode.tinderclone.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.thecode.tinderclone.R;

public class SplashscreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        new Handler().postDelayed(() -> {
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                finish();

        }, 2000);
    }
}
