package com.example.lucass.tpmemotest.Niveles;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lucass.tpmemotest.OnFichaClick;
import com.example.lucass.tpmemotest.R;

import java.util.List;

/**
 * Created by lucass on 6/12/2016.
 */
public class NivelAdapter extends RecyclerView.Adapter<NivelViewHolder>
{
    List<Nivel> niveles;
    private OnNivelClick listener;

    public NivelAdapter(List<Nivel> niveles,OnNivelClick listener) {
        this.niveles = niveles;
        this.listener = listener;
    }

    @Override
    public NivelViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_nivel_layout, parent, false);
        NivelViewHolder nv = new NivelViewHolder(v,listener);
        return nv;
    }

    @Override
    public void onBindViewHolder(NivelViewHolder holder, int position) {
        Nivel n = niveles.get(position);
       holder.nivel.setText("Nivel: " + Integer.toString(n.getNumero()));
        holder.desc.setText(n.getDescripcion());
        //holder.imagen.setImageResource(n.getImagen());
    }

    @Override
    public int getItemCount() {
        return niveles.size();
    }
}
