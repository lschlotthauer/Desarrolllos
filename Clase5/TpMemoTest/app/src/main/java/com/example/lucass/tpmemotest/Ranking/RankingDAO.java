package com.example.lucass.tpmemotest.Ranking;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import com.example.lucass.tpmemotest.Ranking.Ranking;

import java.util.ArrayList;

public class RankingDAO {

    private SQLiteDatabase db;
    private SQLiteStatement statementSave;

    public RankingDAO(SQLiteDatabase db){
        this.db=db;
        statementSave = db.compileStatement("INSERT INTO ranking (nombre, tiempo, vidas) VALUES(?,?,?)");
    }

    public long save(Ranking r){
        statementSave.clearBindings();
        statementSave.bindString(1,r.getNombre());
        statementSave.bindString(2,r.getTiempo());
        statementSave.bindLong(3,r.getVidas());

        return statementSave.executeInsert();
    }

    public ArrayList<Ranking> getAll(){
        ArrayList<Ranking> lista = new ArrayList<>();

        Cursor c;
        Ranking r = null;

        c= db.rawQuery("SELECT _id,nombre,tiempo,vidas FROM ranking order by vidas desc, tiempo",null);

        if (c.moveToFirst()){
            do {
                r = new Ranking();
                r.setId(c.getLong(0));
                r.setNombre(c.getString(1));
                r.setTiempo(c.getString(2));
                r.setVidas(c.getInt(3));
                lista.add(r);

            }while(c.moveToNext());
        }
        c.close();

        return lista;
    }


}
