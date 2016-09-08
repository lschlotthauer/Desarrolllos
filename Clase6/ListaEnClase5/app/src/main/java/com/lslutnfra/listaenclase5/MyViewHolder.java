package com.lslutnfra.listaenclase5;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by ernesto on 19/04/16.
 */
public class MyViewHolder extends RecyclerView.ViewHolder
                                implements View.OnClickListener {

    public TextView tNombre;
    public TextView tApellido;
    public int position;

    private MainActivity mainActivity;

    public MyViewHolder(View itemView, MainActivity mainActivity) {
        super(itemView);

       tNombre = (TextView)itemView.findViewById(R.id.txtNombre);
       tApellido = (TextView)itemView.findViewById(R.id.txtApellido);

        itemView.setOnClickListener(this);

        this.mainActivity=mainActivity;
    }

    @Override
    public void onClick(View v) {
        mainActivity.seHizoCLickEnItem(position);
    }
}
