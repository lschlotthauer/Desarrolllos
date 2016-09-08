package com.example.lucass.tpmemotest;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lucass on 4/22/2016.
 */
public class FichasAdapter extends RecyclerView.Adapter<CustomViewHolder> {

    List<Ficha> lista;
    private OnFichaClick listener;

    public FichasAdapter(List<Ficha> lista,OnFichaClick listener){
        this.lista  = lista;
        this.listener = listener;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        CustomViewHolder cv = new CustomViewHolder(v,listener);
        return cv;
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        Ficha f = lista.get(position);
        if(f.getEstado()== Ficha.TAPADA)
            holder.imagen.setImageResource(R.drawable.question_icon);
        else
            holder.imagen.setImageResource(f.getImagen());
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }
}
