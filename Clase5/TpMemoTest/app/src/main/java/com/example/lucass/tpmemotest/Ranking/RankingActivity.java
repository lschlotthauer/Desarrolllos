package com.example.lucass.tpmemotest.Ranking;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.lucass.tpmemotest.R;

import java.util.ArrayList;

public class RankingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        MyOpenHelper helper = new MyOpenHelper(this,"RankingTP2.db3");
        SQLiteDatabase db = helper.getWritableDatabase();
        RankingDAO dao = new RankingDAO(db);
        ArrayList<Ranking> lista = dao.getAll();

        for(Ranking r : lista){
            Log.d("act", r.getNombre() + " Tiempo: " + r.getTiempo() + "Vidas: " + r.getVidas());
        }
    }
}
