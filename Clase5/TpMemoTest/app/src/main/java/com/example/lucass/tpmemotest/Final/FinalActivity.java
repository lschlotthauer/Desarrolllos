package com.example.lucass.tpmemotest.Final;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.lucass.tpmemotest.R;

public class FinalActivity extends AppCompatActivity {

    private int vidas;
    private int tiempo;
    private String resultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        Intent i = getIntent();
        Bundle extras = i.getExtras();
        vidas = extras.getInt("Vidas");
        tiempo = extras.getInt("Tiempo");

        if(vidas == 0 || tiempo == 0) {
            resultado= "PERDISTE!!!";
        }
        else{
            resultado = "GANASTE!!!";
        }
    }
}
