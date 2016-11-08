package com.example.lucass.tpmemotest.Final;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.lucass.tpmemotest.R;

public class FinalActivity extends AppCompatActivity {

    private int vidas;
    private long tiempo;
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
        tiempo = extras.getLong("Tiempo");
        int hours = (int) (tiempo / 3600000);
        int minutes = (int) (tiempo - hours * 3600000) / 60000;
        Log.d("TpMemoTest", "Min: " + minutes);
        int seconds = (int) (tiempo - hours * 3600000 - minutes * 60000) / 1000;
        Log.d("TpMemoTest", "Sec: " + seconds);
        String minutosFormateado;
        String segundosFormateado;

        if(minutes <=9){
            minutosFormateado = "0" + minutes;
        }
        else {
            minutosFormateado = "" + minutes;
        }

        if(seconds <=9){
            segundosFormateado = "0" + seconds;
        }
        else {
            segundosFormateado = "" + seconds;
        }

        String tiempoFormateado = minutosFormateado + ":" + segundosFormateado;

        gano = extras.getBoolean("Gano");

        if(gano) {
            resultado = "GANASTE!!!";
        }
        else{
            resultado = "PERDISTE!!!";
        }

        tvTiempo = (TextView) findViewById(R.id.textTiempoFinal);
        tvTiempo.setText("Tiempo: "+ tiempoFormateado);

        tvVidas = (TextView) findViewById(R.id.textVidasFinal);
        tvVidas.setText("Vidas: "+ vidas);

        tvVidas = (TextView) findViewById(R.id.textResultado);
        tvVidas.setText(""+resultado);
    }

    @Override
    public void onBackPressed(){

    }
}
