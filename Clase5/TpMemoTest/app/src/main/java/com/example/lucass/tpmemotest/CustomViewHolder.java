package com.example.lucass.tpmemotest;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by lucass on 4/22/2016.
 */
public class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    ImageView imagen;
    private OnFichaClick listener;

    public CustomViewHolder(View itemView,OnFichaClick listener) {
        super(itemView);
        imagen = (ImageView) itemView.findViewById(R.id.icon);
        itemView.setOnClickListener(this);
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        listener.clickEnFicha(getAdapterPosition());
    }
}
