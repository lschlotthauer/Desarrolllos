package com.example.android.ejemplobasededatos;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyOpenHelper helper = new MyOpenHelper(this,"BasePrueba.db3");

        SQLiteDatabase db = helper.getWritableDatabase();

        PersonaDAO dao = new PersonaDAO(db);

        ArrayList<Persona> lista = dao.getAll();

        for(Persona p : lista)
        {
            Log.d("act", p.getNombre() + " Edad: " + p.getEdad());
        }

    }
}
