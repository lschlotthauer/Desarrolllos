package com.utnfra.examen1;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import com.utnfra.examen1.comm.ThreadConexion;
import com.utnfra.examen1.datos.ParserNoticias;
import com.utnfra.examen1.entities.Noticia;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;


public class MainActivity extends ActionBarActivity implements  Handler.Callback {

    private List<Noticia> listaNoticias;
    private ScreenManager sm;

    private Handler h;
    private ThreadPoolExecutor executor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        h = new Handler(this);

        ThreadConexion tc = new ThreadConexion(h,"http://rss.cnn.com/rss/edition.rss",false);
        Thread t = new Thread(tc);
        t.start();

        executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);

        sm = new ScreenManager(this);
    }


    @Override
    public boolean handleMessage(Message msg) {

        switch(msg.arg1)
        {
            case 0:
            {
                break;
            }
            case 1: // llego una imagen
            {

                int pos = msg.arg2;
                byte[] data = (byte[]) msg.obj;
                Bitmap b = BitmapFactory.decodeByteArray(data,0,data.length);
                Noticia n = listaNoticias.get(pos);
                n.setBitmap(b);

                sm.refresco();

                break;
            }
            case 2: // llego un string
            {
                String dataXml = (String)msg.obj;
                Log.d("act", "llego:" + dataXml);
                ParserNoticias pn = new ParserNoticias(dataXml);
                listaNoticias = pn.parseListaNoticias();
                sm.mostrarLista(listaNoticias);

                int i = 0;
                for(Noticia n: listaNoticias)
                {
                    ThreadConexion t = new ThreadConexion(h,n.getImageUrl(),true);
                    t.setExtraData(i);
                    i++;
                    executor.execute(t);
                }


                break;
            }
        }

        return false;
    }
}
