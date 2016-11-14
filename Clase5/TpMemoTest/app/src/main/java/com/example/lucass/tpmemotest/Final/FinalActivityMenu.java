package com.example.lucass.tpmemotest.Final;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.lucass.tpmemotest.MainActivity;
import com.example.lucass.tpmemotest.MiDialogo;
import com.example.lucass.tpmemotest.Niveles.NivelesActivity;
import com.example.lucass.tpmemotest.R;
import com.example.lucass.tpmemotest.RankingActivity;

public class FinalActivityMenu extends AppCompatActivity implements DialogInterface.OnClickListener {

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
        setContentView(R.layout.activity_final_menu);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("tpMemoTest");
        setSupportActionBar(toolbar);

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
            Button b = (Button) findViewById(R.id.btnGuardar);
            b.setVisibility(View.VISIBLE);
            b.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    LayoutInflater li = LayoutInflater.from(v.getContext());
                    View viewAlert = li.inflate(R.layout.layout_dialogo,null);

                    AlertDialog.Builder builder = new
                            AlertDialog.Builder()uil()



                    //MiDialogo md =  new MiDialogo();
                    //md.show(getSupportFragmentManager(),"Dialogo");
                }
            });
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

        Button button = (Button) findViewById(R.id.btnVolver);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), NivelesActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem item = menu.findItem(R.id.menu_item_ranking);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id)
        {
            case R.id.menu_item_ranking:
            {
                Log.d("act", "Ranking");
                Intent i = new Intent(this, RankingActivity.class);
                startActivity(i);
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed(){

    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        switch (which)
        {
            case AlertDialog.BUTTON_POSITIVE:
            {
                Log.d("act", "Positivo");

            }

        }
    }
}
