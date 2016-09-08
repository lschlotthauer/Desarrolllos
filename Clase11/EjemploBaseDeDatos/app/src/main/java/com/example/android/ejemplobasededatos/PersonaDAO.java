package com.example.android.ejemplobasededatos;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import java.util.ArrayList;


public class PersonaDAO {

    private SQLiteDatabase db;
    private SQLiteStatement statementSave;

    public PersonaDAO(SQLiteDatabase db)
    {
        this.db=db;
        statementSave = db.compileStatement("INSERT INTO personas (nombre,edad) VALUES(?,?)");
    }

    public Persona getPersonaById(long id)
    {
        Cursor c;
        Persona p=null;
        c = db.rawQuery("SELECT _id,nombre,edad" +
                " FROM personas WHERE _id=" +id,null);

        if(c.moveToFirst())
        {
            p = new Persona();
            p.setId(c.getLong(0));
            p.setNombre(c.getString(1));
            p.setEdad(c.getInt(2));
        }
        c.close();
        return p;
    }

    public long save(Persona p)
    {
        statementSave.clearBindings();
        statementSave.bindString(1, p.getNombre());
        statementSave.bindLong(2, p.getEdad());

        return statementSave.executeInsert();
    }

    public void update(Persona p)
    {
        ContentValues values = new ContentValues();

        values.put("nombre", p.getNombre());
        values.put("edad", p.getEdad());

        db.update("personas", values, "_id=" + p.getId(), null);
    }

    public void delete(Persona p)
    {
        db.delete("personas", "_id=" + p.getId(), null);
    }

    public ArrayList<Persona> getAll()
    {
        ArrayList<Persona> lista  = new ArrayList<>();

        Cursor c;
        Persona p=null;
        c = db.rawQuery("SELECT _id,nombre,edad" +
                " FROM personas",null);

        if(c.moveToFirst())
        {
            do {
                p = new Persona();
                p.setId(c.getLong(0));
                p.setNombre(c.getString(1));
                p.setEdad(c.getInt(2));
                lista.add(p);
            }while(c.moveToNext());
        }
        c.close();


        return lista;
    }
}
