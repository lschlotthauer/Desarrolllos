package com.lslutnfra.ejercicioparacompletargrilla;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    ImageView img;
    int position;


    public MyViewHolder(View itemView) {  // recibir listener
        super(itemView);
        img = (ImageView) itemView.findViewById(R.id.icon);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // llamar a metodo de listener, pasando la posicion
    }
}
