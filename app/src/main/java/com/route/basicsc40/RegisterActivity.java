package com.route.basicsc40;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("RegisterActivity", "onCreate");
        setContentView(R.layout.activity_register);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("RegisterActivity", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("RegisterActivity", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("RegisterActivity", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("RegisterActivity", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("RegisterActivity", "Destroy");
    }

}
