package com.example.lucass.tpmemotest.Niveles;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lucass.tpmemotest.OnFichaClick;
import com.example.lucass.tpmemotest.R;

/**
 * Created by lucass on 6/12/2016.
 */
public class NivelViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    ImageView imagen;
    TextView nivel;
    TextView desc;
    private OnNivelClick listener;

    public NivelViewHolder(View itemView,OnNivelClick listener) {
        super(itemView);
        //imagen = (ImageView) itemView.findViewById(R.id.iconNivel);
       nivel = (TextView)itemView.findViewById(R.id.textNivel);
       desc = (TextView)itemView.findViewById(R.id.textDescripcion);
        itemView.setOnClickListener(this);
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        listener.clickEnNivel(getAdapterPosition());
    }
}
