package com.example.android.ejemplorecyclerviewclase5;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener{

    private SwipeRefreshLayout s;
    public static List<Persona> lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        s = (SwipeRefreshLayout) findViewById(R.id.swipe);
        s.setOnRefreshListener(this);
        s.setColorSchemeResources(R.color.red,R.color.green,R.color.blue);

        lista = new ArrayList<Persona>();

        Persona p1 = new Persona();
        p1.setNombre("Juan");
        p1.setApellido("Perez");

        Persona p2 = new Persona();
        p2.setNombre("Ernesto");
        p2.setApellido("Gigliotti");

        Persona p3 = new Persona();
        p3.setNombre("Lucas");
        p3.setApellido("Schlotthauer");

        Persona p4 = new Persona();
        p4.setNombre("Juan2");
        p4.setApellido("Perez2");

        Persona p5 = new Persona();
        p5.setNombre("Ernesto2");
        p5.setApellido("Gigliotti2");

        Persona p6 = new Persona();
        p6.setNombre("Lucas2");
        p6.setApellido("Schlotthauer2");

        lista.add(p1);
        lista.add(p2);
        lista.add(p3);
        lista.add(p4);
        lista.add(p5);
        lista.add(p6);
        lista.add(p1);
        lista.add(p2);
        lista.add(p3);
        lista.add(p4);
        lista.add(p5);
        lista.add(p6);
        lista.add(p1);
        lista.add(p2);
        lista.add(p3);
        lista.add(p4);
        lista.add(p5);
        lista.add(p6);
        lista.add(p1);
        lista.add(p2);
        lista.add(p3);
        lista.add(p4);
        lista.add(p5);
        lista.add(p6);
        lista.add(p1);
        lista.add(p2);
        lista.add(p3);
        lista.add(p4);
        lista.add(p5);
        lista.add(p6);
        lista.add(p1);
        lista.add(p2);
        lista.add(p3);
        lista.add(p4);
        lista.add(p5);
        lista.add(p6);



        //Obtenemos recyclerView

        RecyclerView rv = (RecyclerView) findViewById(R.id.list);

        MyAdapter Adaptador = new MyAdapter(lista, this);

        rv.setAdapter(Adaptador);

        //Indica como mostrar la lista;
            LinearLayoutManager l = new LinearLayoutManager(this);

        rv.setLayoutManager(l);

    }

    @Override
    public void onRefresh() {
        Log.d("activity", "Refresh List");
    }

    @Override
    public void onBackPressed(){
        if (s.isRefreshing())
            s.setRefreshing(false);
        else
            super.onBackPressed();
    }

    public void seHizoClickEnItem(int position) {
        //Lanza otra Activity

        Intent i = new Intent(this,Pantalla2Activity.class);
        i.putExtra("p",position);
        startActivity(i);

    }
}
