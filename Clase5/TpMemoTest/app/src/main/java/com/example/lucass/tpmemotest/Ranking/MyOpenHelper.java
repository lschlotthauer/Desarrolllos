package com.example.lucass.tpmemotest.Ranking;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by lucass on 12/13/2016.
 */

public class MyOpenHelper extends SQLiteOpenHelper {

    private String  dbFilePath;
    private String  dbFileName;
    private Context context;

    private static final int DB_VERSION = 1;

    public MyOpenHelper(Context context, String name) {
        super(context, name, null, DB_VERSION);

        this.dbFilePath = context.getDatabasePath(name).getAbsolutePath();
        this.dbFilePath = dbFilePath.substring(0,dbFilePath.lastIndexOf("/")+1);

        this.context = context;
        this.dbFileName = name;

        checkDataBase();
    }


    private void checkDataBase(){
        SQLiteDatabase checkDB = null;

        try{
            String myPath = dbFilePath + dbFileName;
            checkDB = SQLiteDatabase.openDatabase(myPath,null,SQLiteDatabase.OPEN_READONLY);
        }catch (SQLiteException e){
            try {
                Log.d("helper", "Copiando archivo desde assets");
                copyDataBase();
            }catch (IOException e2){
                Log.d("helper","Error copiando archivo ddesde assets");
            }
        }
    }

    private void copyDataBase() throws IOException{
        File f = new File (dbFilePath);
        f.mkdirs();
        InputStream myInput = context.getAssets().open(dbFileName);
        String outFileName = dbFilePath + dbFileName;
        OutputStream myOutput = new FileOutputStream(outFileName);

        byte[] buffer = new byte[1024];
        int length;
        while((length = myInput.read(buffer))>0){
            Log.d("helper", "Copying "+ length+"bytes");
            myOutput.write(buffer,0,length);
        }
        myOutput.flush();
        myOutput.close();
        myInput.close();
    }



    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
