package com.lslutnfra.ejercicioparacompletargrilla;

import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class MyAdapter extends Adapter<MyViewHolder> {

    private List<Ficha> lista;

    private OnFichaClick listener;
    public MyAdapter(List<Ficha> lista, OnFichaClick listener)
    {
        this.lista=lista;
        // recibir el objeto listener para pasarselo al viewholder
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(v);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // cargar el viewholder con la info del objeto Ficha : si esta destapado, cargo el imageview con la imagen de la ficha
        // si esta tapada, cargo el imageview con la imagen del signo de pregunta

    }

    @Override
    public int getItemCount() {
        return lista.size();
    }
}
