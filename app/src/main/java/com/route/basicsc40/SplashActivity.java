package com.route.basicsc40;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("SplashActivity", "onCreate");
        setContentView(R.layout.activity_splash);
        Button categoriesButton = findViewById(R.id.categoriesBtn);
        categoriesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("SplashActivity", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("SplashActivity", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("SplashActivity", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("SplashActivity", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("SplashActivity", "Destroy");
    }
}