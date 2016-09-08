package com.lslutnfra.listaenclase5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // creamos modelo de datos
        List<Persona> lista = new ArrayList<Persona>();

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

        MyAdapter adapter = new MyAdapter(lista);

        rv.setAdapter(adapter);

        LinearLayoutManager l = new LinearLayoutManager(this);
        rv.setLayoutManager(l);

    }
}
