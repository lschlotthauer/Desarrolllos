package com.example.lucass.tpmemotest;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Chronometer;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lucass.tpmemotest.Final.FinalActivity;
import com.example.lucass.tpmemotest.Niveles.NivelesActivity;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MainActivity extends AppCompatActivity implements OnFichaClick, Handler.Callback {

    private List<Ficha> lista;
    private FichasAdapter adaptador;
    private RecyclerView rv;
    private TextView tvTiempo;
    private TextView tvVidas;
    private GridLayoutManager lManager;
    private Worker worker;
    private Cronometro crono;
    private Handler h;
    private Handler h2;
    private int tiros = 1;
    private int primerClickPosition;
    private int segundoClickPosition;
    private int nivel;
    private int vidas = 3;
    private boolean termino= false;


    Chronometer ct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ct = (Chronometer) findViewById(R.id.chrono);

        Intent i = getIntent();
        Bundle extras = i.getExtras();
        nivel = extras.getInt("Nivel");

        lista = cargarFichas();
        comenzar(lista);

    }

    @Override
    public void clickEnFicha(int position) {
        Ficha f = lista.get(position);
        if (f.getEstado() == Ficha.TAPADA && tiros <= 2 ) {
            f.setEstado(Ficha.DESTAPADA);

            if(tiros == 1) {
                primerClickPosition = position;
                tiros ++;
            }
            else if (tiros == 2) {
                segundoClickPosition = position;

                worker = new Worker(h,500,false);
                worker.start();
                tiros ++;
            }
        }
        if(tiros == 3){
            tiros = 1;
        }
        adaptador.notifyDataSetChanged();
    }


    public void comenzar(List<Ficha> lista){
        Collections.shuffle(lista);

        rv = (RecyclerView) findViewById(R.id.list);
        adaptador = new FichasAdapter(lista, this);
        rv.setAdapter(adaptador);

        lManager = new GridLayoutManager(this, 3);
        rv.setLayoutManager(lManager);

        h = new Handler(this);
        h2 = new Handler(this);
        //tvTiempo = (TextView) findViewById(R.id.textTiempo);
        //tvTiempo.setText("Tiempo: " + t.getTime());

        tvVidas = (TextView) findViewById(R.id.textVidas);
        tvVidas.setText("Vidas: "+ vidas);
        long time = 0;
        switch (nivel) {
            case 1:
                time = 10000;
                break;
            case 2:
                time = 5000;
                break;
            case 3:
                time = 3000;
                break;
            default:
                break;
        }
        worker = new Worker(h,time,false);
        worker.start();

        mostrarToast("Nivel " + nivel,Toast.LENGTH_LONG);
    }

    public void inicialCronometro(){
        //crono = new Cronometro(h2);
        //crono.start();
        ct.setBase(SystemClock.elapsedRealtime());
        ct.start();
    }


    public List<Ficha> cargarFichas(){

        List<Ficha> listaAux = new ArrayList<>();

        listaAux.add(new Ficha(Ficha.DESTAPADA, R.drawable.img_1));
        listaAux.add(new Ficha(Ficha.DESTAPADA, R.drawable.img_1));
        listaAux.add(new Ficha(Ficha.DESTAPADA, R.drawable.img_2));
        listaAux.add(new Ficha(Ficha.DESTAPADA, R.drawable.img_2));
        listaAux.add(new Ficha(Ficha.DESTAPADA, R.drawable.img_3));
        listaAux.add(new Ficha(Ficha.DESTAPADA, R.drawable.img_3));
        listaAux.add(new Ficha(Ficha.DESTAPADA, R.drawable.img_4));
        listaAux.add(new Ficha(Ficha.DESTAPADA, R.drawable.img_4));
        listaAux.add(new Ficha(Ficha.DESTAPADA, R.drawable.img_5));
        listaAux.add(new Ficha(Ficha.DESTAPADA, R.drawable.img_5));
        listaAux.add(new Ficha(Ficha.DESTAPADA, R.drawable.img_6));
        listaAux.add(new Ficha(Ficha.DESTAPADA, R.drawable.img_6));

        return listaAux;
    }


    @Override
    public boolean handleMessage(Message msg) {
        if(msg.arg1 == 1) {
            Log.d("TpMemoTest", "primera ficha posicion: " + primerClickPosition);
            Log.d("TpMemoTest", "segunda ficha posicion: " + segundoClickPosition);
            Ficha ficha1 = lista.get(primerClickPosition);
            Ficha ficha2 = lista.get(segundoClickPosition);

            if (ficha1.getImagen() != ficha2.getImagen()) {
                mostrarToast("No hay coincidencia!!!", Toast.LENGTH_SHORT);
                ficha1.setEstado(Ficha.TAPADA);
                ficha2.setEstado(Ficha.TAPADA);
                vidas = vidas - 1;
                tvVidas = (TextView) findViewById(R.id.textVidas);
                tvVidas.setText("Vidas: "+ vidas);
            }
            else
            {
                mostrarToast("Hay coincidencia!!!",Toast.LENGTH_SHORT);
                if(hayGanador())
                {
                    worker.interrupt();
                    //crono.interrupt();

                    long elapsedMillis = SystemClock.elapsedRealtime() - ct.getBase();
                    Log.d("TpMemoTest", "Tiempo: " + elapsedMillis);
                    Intent i = new Intent(this, FinalActivity.class);
                    i.putExtra("Gano", true);
                    i.putExtra("Tiempo", elapsedMillis);
                    i.putExtra("Vidas", vidas);
                    ct.stop();
                    startActivity(i);
                }
            }
        }
        //else if(msg.arg1 == 2){
          //  t.setTime(msg.arg2);
            //tvTiempo = (TextView) findViewById(R.id.textTiempo);
            //tvTiempo.setText("Tiempo: "+ t.getTime());

        //}
        else {
            for (Ficha item : lista) {
                item.setEstado(Ficha.TAPADA);
            }
            inicialCronometro();
        }

        if(vidas == 0) {
            worker.interrupt();
            //crono.interrupt();

            Intent i = new Intent(this, FinalActivity.class);
            i.putExtra("Gano", false);
            long elapsedMillis = SystemClock.elapsedRealtime() - ct.getBase();
            Log.d("TpMemoTest", "Tiempo: " + elapsedMillis);
            i.putExtra("Tiempo", elapsedMillis);
            ct.stop();
            i.putExtra("Vidas", vidas);
            startActivity(i);
        }

        adaptador.notifyDataSetChanged();
        return false;
    }

    private void mostrarToast(CharSequence mensaje, int duracion){
        Context context = getApplicationContext();

        Toast toast = Toast.makeText(context, mensaje, duracion);
        toast.setGravity(Gravity.BOTTOM,0,20);
        toast.show();
    }

    private boolean hayGanador() {
        for (Ficha f : lista) {
            if (f.getEstado() == Ficha.TAPADA) {
                Log.d("MAIN", "NO GANO");
                return false;
            }
        }
        Log.d("MAIN", "GANO");
        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        worker.interrupt();
        ct.stop();
    }
}
