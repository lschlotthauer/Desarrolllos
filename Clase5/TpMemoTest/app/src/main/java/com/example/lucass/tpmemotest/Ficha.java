package com.example.lucass.tpmemotest;

/**
 * Created by lucass on 4/22/2016.
 */
public class Ficha {

    public static final boolean TAPADA = true;
    public static final boolean DESTAPADA = false;

    private boolean estado;
    private int imagen;

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public Ficha(boolean estado, int imagen){
        this.estado = estado;
        this.imagen = imagen;
    }

}
