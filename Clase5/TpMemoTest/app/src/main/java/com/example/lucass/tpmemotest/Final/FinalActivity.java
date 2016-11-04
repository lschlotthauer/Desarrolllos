package com.example.lucass.tpmemotest.Final;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.lucass.tpmemotest.R;

public class FinalActivity extends AppCompatActivity {

    private int vidas;
    private int tiempo;
    private String resultado;
    private boolean gano= false;

    private TextView tvTiempo;
    private TextView tvVidas;
    private TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        Intent i = getIntent();
        Bundle extras = i.getExtras();
        vidas = extras.getInt("Vidas");
        tiempo = extras.getInt("Tiempo");
        gano = extras.getBoolean("Gano");

        if(gano) {
            resultado = "GANASTE!!!";
        }
        else{
            resultado = "PERDISTE!!!";
        }

        tvTiempo = (TextView) findViewById(R.id.textTiempoFinal);

        if(tiempo >= 0 && tiempo <10){
            tvTiempo.setText("Tiempo: 00:0"+ tiempo);
        }
        else if(tiempo >= 10 && tiempo <=30){
            tvTiempo.setText("Tiempo: 00:"+ tiempo);
        }

        tvVidas = (TextView) findViewById(R.id.textVidasFinal);
        tvVidas.setText("Vidas: "+ vidas);

        tvVidas = (TextView) findViewById(R.id.textResultado);
        tvVidas.setText(""+resultado);
    }

    @Override
    public void onBackPressed(){

    }
}
