package com.example.android.ejemplolayouts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<String> lista = new ArrayList<String>();
        Log.d("activity", "tamaño: " + lista.size());

        lista.add("opcion 1");
        lista.add("opcion 2");
        lista.add("opcion 3");
        lista.add("opcion 4");

        Log.d("activity", "tamaño: " + lista.size());

        lista.remove(2);

        Log.d("activity", "tamaño: " + lista.size());

        for(String s : lista)
        {
            Log.d("activity",s);
        }

        Spinner sp = (Spinner)findViewById(R.id.spinner);

        ArrayAdapter<String> adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,lista);

        sp.setAdapter(adapter);

        sp.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        Log.d("activity", "seleccionaste un item: " + position);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
