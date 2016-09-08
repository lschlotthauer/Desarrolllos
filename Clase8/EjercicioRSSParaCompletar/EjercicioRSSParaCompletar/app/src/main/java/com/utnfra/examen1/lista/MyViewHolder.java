package com.utnfra.examen1.lista;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.utnfra.examen1.R;

/**
 * Created by Ernesto on 22/03/2015.
 */
public class MyViewHolder extends RecyclerView.ViewHolder {

    public TextView txtTitulo;
    public TextView txtDescripcion;
    public ImageView imgNoticia;

    public MyViewHolder(View itemView) {
        super(itemView);

        // cargar las referencias de los textviews desde la view
        txtTitulo = (TextView)itemView.findViewById(R.id.txtTitulo);
        txtDescripcion = (TextView)itemView.findViewById(R.id.txtDescripcion);
        imgNoticia = (ImageView)itemView.findViewById(R.id.imgNoticia);
        //_____________________________________________________

    }


}
