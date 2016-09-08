package com.lslutnfra.listaenclase5;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ernesto on 19/04/16.
 */
public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private List<Persona> lista;
    public MyAdapter(List<Persona> lista)
    {
        this.lista = lista;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_layout, parent, false);

        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

            Persona p = lista.get(position);

            MyViewHolder mvh = holder;

            mvh.tNombre.setText(p.getNombre());
            mvh.tApellido.setText(p.getApellido());
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }
}
