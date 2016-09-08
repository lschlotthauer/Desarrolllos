package com.lslutnfra.listaenclase5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static List<Persona> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // creamos modelo de datos
        lista = new ArrayList<Persona>();

        Persona p1 = new Persona();
        p1.setNombre("Juan");
        p1.setApellido("Perez");

        Persona p2 = new Persona();
        p2.setNombre("Ernesto");
        p2.setApellido("Gigliotti");

        Persona p3 = new Persona();
        p3.setNombre("Lucas");
        p3.setApellido("gonzales");

        lista.add(p1);
        lista.add(p2);
        lista.add(p3);

        // obtenemos recyclerview
        RecyclerView rv = (RecyclerView)findViewById(R.id.list);

        MyAdapter adapter = new MyAdapter(lista,this);

        rv.setAdapter(adapter);

        LinearLayoutManager l = new LinearLayoutManager(this);
        rv.setLayoutManager(l);

    }

    public void seHizoCLickEnItem(int position) {

        Log.d("activity", "se hizo click en:" + position);

        // lanzo la otra activity
        Intent i = new Intent(this,Pantalla2Activity.class);
        i.putExtra("p",position);
        startActivity(i);
    }
}
