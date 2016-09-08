package com.utnfra.examen1.lista;

import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.utnfra.examen1.R;
import com.utnfra.examen1.entities.Noticia;

import java.util.List;


public class MyAdapter extends Adapter<MyViewHolder> {

    private List<Noticia> lista;

    public MyAdapter(List<Noticia> lista)
    {
        this.lista = lista;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(v);
        return myViewHolder;

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Noticia n = lista.get(position);

        // Cargar los textviews del holder con los datos de "n"
        holder.txtTitulo.setText(n.getTitle());
        holder.txtDescripcion.setText(n.getDescription());
        if (n.getBitmap() == null)
            holder.imgNoticia.setImageResource(R.drawable.fondogris);
        else
            holder.imgNoticia.setImageBitmap(n.getBitmap());

        //_____________________________________________________




    }

    @Override
    public int getItemCount() {
        return lista.size();
    }
}
