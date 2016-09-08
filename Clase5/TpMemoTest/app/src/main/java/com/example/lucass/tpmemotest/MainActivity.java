package com.example.lucass.tpmemotest;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnFichaClick, Handler.Callback {

    private List<Ficha> lista;
    private FichasAdapter adaptador;
    private RecyclerView rv;
    private GridLayoutManager lManager;
    private Worker worker;
    private Handler h;
    private int tiros = 1;
    private int primerClickPosition;
    private int segundoClickPosition;
    private int nivel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent i = getIntent();
        Bundle extras = i.getExtras();
        nivel = extras.getInt("Nivel");

        lista = new ArrayList<Ficha>();

        lista.add(new Ficha(Ficha.TAPADA, R.drawable.img_1));
        lista.add(new Ficha(Ficha.TAPADA, R.drawable.img_1));
        lista.add(new Ficha(Ficha.TAPADA, R.drawable.img_2));
        lista.add(new Ficha(Ficha.TAPADA, R.drawable.img_2));
        lista.add(new Ficha(Ficha.TAPADA, R.drawable.img_3));
        lista.add(new Ficha(Ficha.TAPADA, R.drawable.img_3));
        lista.add(new Ficha(Ficha.TAPADA, R.drawable.img_4));
        lista.add(new Ficha(Ficha.TAPADA, R.drawable.img_4));
        lista.add(new Ficha(Ficha.TAPADA, R.drawable.img_5));
        lista.add(new Ficha(Ficha.TAPADA, R.drawable.img_5));
        lista.add(new Ficha(Ficha.TAPADA, R.drawable.img_6));
        lista.add(new Ficha(Ficha.TAPADA, R.drawable.img_6));

        Collections.shuffle(lista);

        rv = (RecyclerView) findViewById(R.id.list);
        adaptador = new FichasAdapter(lista, this);
        rv.setAdapter(adaptador);

        lManager = new GridLayoutManager(this, 3);
        rv.setLayoutManager(lManager);

        h = new Handler(this);
    }

    @Override
    public void clickEnFicha(int position) {
        Ficha f = lista.get(position);
        if (f.getEstado() == Ficha.TAPADA && tiros <= 2 ) {
            f.setEstado(Ficha.DESTAPADA);


            if(tiros == 1) {
                primerClickPosition = position;
            }
            else if (tiros == 2) {
                segundoClickPosition = position;
                worker = new Worker(h);
                worker.start();
                tiros = 0;
            }

            tiros ++;
            adaptador.notifyDataSetChanged();
        }
    }


    public void taparDestaparFichas(List<Ficha> lista,boolean status ){

        adaptador.notifyDataSetChanged();
    }


    @Override
    public boolean handleMessage(Message msg) {
        Log.d("asdasdasd", "primera ficha posicion: "+ primerClickPosition);
        Log.d("asdasdasd", "segunda ficha posicion: "+ segundoClickPosition);
        Ficha ficha1 = lista.get(primerClickPosition);
        Ficha ficha2 = lista.get(segundoClickPosition);

        if (ficha1.getImagen()!= ficha2.getImagen()){
            ficha1.setEstado(Ficha.TAPADA);
            ficha2.setEstado(Ficha.TAPADA);
        }

        adaptador.notifyDataSetChanged();
        return false;
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        worker.interrupt();
    }
}
