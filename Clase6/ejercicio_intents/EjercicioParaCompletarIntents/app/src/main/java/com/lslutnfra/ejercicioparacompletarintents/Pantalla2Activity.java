package com.lslutnfra.ejercicioparacompletarintents;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class Pantalla2Activity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla2_layout);


    }

    @Override
    public void onClick(View v) {
        EditText et = (EditText) findViewById(R.id.editTextUrl);
        String s = et.getText().toString();

        Intent i = new Intent();
        i.putExtra("texto", s);

        setResult(RESULT_OK,i);

        finish();
    }


}
