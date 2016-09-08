package com.utnfra.examen1;

import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.utnfra.examen1.entities.Noticia;
import com.utnfra.examen1.lista.MyAdapter;

import java.util.List;

/**
 * Created by Ernesto on 22/03/2015.
 */
public class ScreenManager {

    private Activity a;
    private RecyclerView list;
    private ProgressBar loading;
    private MyAdapter adapter;

    public ScreenManager(Activity a)
    {
        // Completar constructor
        this.a = a;
        this.list = (RecyclerView)a.findViewById(R.id.list);
        this.loading = (ProgressBar)a.findViewById(R.id.progressBar);
        //______________________

        LinearLayoutManager layoutManager = new LinearLayoutManager(a);
        list.setLayoutManager(layoutManager);
    }

    public void mostrarLista(List<Noticia> listaNoticias)
    {
        ocultarLoading();
        adapter = new MyAdapter(listaNoticias);
        list.setAdapter(adapter);
    }

    public void refresco()
    {
        adapter.notifyDataSetChanged();
    }

    private void ocultarLoading()
    {
        this.loading.setVisibility(View.GONE);
    }
}
