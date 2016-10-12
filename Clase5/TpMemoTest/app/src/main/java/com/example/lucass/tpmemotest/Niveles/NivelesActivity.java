package com.example.lucass.tpmemotest.Niveles;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.lucass.tpmemotest.MainActivity;
import com.example.lucass.tpmemotest.Niveles.Nivel;
import com.example.lucass.tpmemotest.Niveles.NivelAdapter;
import com.example.lucass.tpmemotest.OnFichaClick;
import com.example.lucass.tpmemotest.R;

import java.util.ArrayList;
import java.util.List;

public class NivelesActivity extends AppCompatActivity implements OnNivelClick, Handler.Callback {

    RecyclerView rv;
    NivelAdapter adaptador;
    LinearLayoutManager lManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_niveles);

        List<Nivel> lista = new ArrayList<>();

        lista.add(new Nivel(1,"Facil",R.drawable.question_icon));
        lista.add(new Nivel(2,"Intermedio",R.drawable.question_icon));
        lista.add(new Nivel(3,"Dificil",R.drawable.question_icon));

        rv = (RecyclerView) findViewById(R.id.listNiveles);
        adaptador = new NivelAdapter(lista, this);
        rv.setAdapter(adaptador);

        lManager = new LinearLayoutManager(this);
        rv.setLayoutManager(lManager);
    }

    @Override
    public boolean handleMessage(Message msg) {
        return false;
    }

    @Override
    public void clickEnNivel(int position) {
        Log.d("TpMemoTest: ","Click en nivel: " + position+1);
        Intent i = new Intent(this, MainActivity.class);
        i.putExtra("Nivel", position+1);
        startActivity(i);
    }
}
