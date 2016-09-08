package com.example.lucass.tpmemotest.Splash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.lucass.tpmemotest.Niveles.NivelesActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent(this, NivelesActivity.class);
        startActivity(intent);
        finish();
    }
}
