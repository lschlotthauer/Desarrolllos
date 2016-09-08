package com.lslutnfra.listaenclase5;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by ernesto on 19/04/16.
 */
public class MyViewHolder extends RecyclerView.ViewHolder {

    public TextView tNombre;
    public TextView tApellido;

    public MyViewHolder(View itemView) {
        super(itemView);

       tNombre = (TextView)itemView.findViewById(R.id.txtNombre);
       tApellido = (TextView)itemView.findViewById(R.id.txtApellido);

    }
}
