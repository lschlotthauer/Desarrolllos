package com.lslutnfra.ejercicioparacompletargrilla;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnFichaClick {

    List<Ficha> fichas;
    boolean flagNuevaPagina;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        flagNuevaPagina=false;
        fichas = new ArrayList<Ficha>();
        fichas.add(new Ficha(Ficha.TAPADA,R.drawable.img_1));
        fichas.add(new Ficha(Ficha.TAPADA,R.drawable.img_1));
        fichas.add(new Ficha(Ficha.TAPADA,R.drawable.img_2));
        fichas.add(new Ficha(Ficha.TAPADA,R.drawable.img_2));
        fichas.add(new Ficha(Ficha.TAPADA,R.drawable.img_3));
        fichas.add(new Ficha(Ficha.TAPADA,R.drawable.img_3));
        fichas.add(new Ficha(Ficha.TAPADA,R.drawable.img_4));
        fichas.add(new Ficha(Ficha.TAPADA,R.drawable.img_4));
        fichas.add(new Ficha(Ficha.TAPADA,R.drawable.img_5));
        fichas.add(new Ficha(Ficha.TAPADA,R.drawable.img_5));
        fichas.add(new Ficha(Ficha.TAPADA,R.drawable.img_6));
        fichas.add(new Ficha(Ficha.TAPADA,R.drawable.img_6));
        Collections.shuffle(fichas);

        RecyclerView list = (RecyclerView)findViewById(R.id.list);

        GridLayoutManager layoutManager = new GridLayoutManager(this,3);

        list.setLayoutManager(layoutManager);

        adapter = new MyAdapter(fichas,this);
        list.setAdapter(adapter);
    }

    @Override
    public void clickEnFicha(int position) {
        Ficha f = fichas.get(position);
        // cambiar el estado de la ficha y refrescar la pantalla
    }
}
