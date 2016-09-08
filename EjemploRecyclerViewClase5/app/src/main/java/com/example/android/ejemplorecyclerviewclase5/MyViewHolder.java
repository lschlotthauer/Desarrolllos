package com.example.android.ejemplorecyclerviewclase5;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by android on 20/04/16.
 */
public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView tNombre;
    public TextView tApellido;
    public int position;
    private MainActivity mainActivity;

    public MyViewHolder(View itemView, MainActivity mainActivity) {
        super(itemView);
        this.tNombre = (TextView) itemView.findViewById(R.id.txtNombre);
        this.tApellido = (TextView) itemView.findViewById(R.id.txtApellido);
        this.mainActivity = mainActivity;
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        mainActivity.seHizoClickEnItem(position);
    }
}
