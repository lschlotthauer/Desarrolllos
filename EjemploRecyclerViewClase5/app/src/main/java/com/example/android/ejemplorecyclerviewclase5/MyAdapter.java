package com.example.android.ejemplorecyclerviewclase5;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by android on 20/04/16.
 */
public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private List<Persona> lista;
    private MainActivity mainActivity;

    public MyAdapter(List<Persona> lista, MainActivity mainActivity)
    {
        this.lista = lista;
        this.mainActivity = mainActivity;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_layout, parent, false);
        MyViewHolder vh = new MyViewHolder(v, mainActivity);

        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Persona p = lista.get(position);
        holder.position = position;
        holder.tNombre.setText(p.getNombre());
        holder.tApellido.setText(p.getApellido());
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }
}
