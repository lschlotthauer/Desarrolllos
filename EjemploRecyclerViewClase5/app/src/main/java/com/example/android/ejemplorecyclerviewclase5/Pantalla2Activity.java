package com.example.android.ejemplorecyclerviewclase5;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Pantalla2Activity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);

        int position = getIntent().getExtras().getInt("p");
        Persona p = MainActivity.lista.get(position);
        TextView tvNombre = (TextView) findViewById(R.id.tvNombre);
        tvNombre.setText(p.getNombre() + " " +  p.getApellido());

        Button btnSend = (Button) findViewById(R.id.btnSend);
        btnSend.setOnClickListener(this);

        Button btnCamara = (Button) findViewById(R.id.btnCamara);
        btnCamara.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.btnCamara){
            Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivity(i);
        }
        else {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse("http://www.google.com"));
            startActivity(Intent.createChooser(i, "Elejir un navegador"));
        }
    }
}
