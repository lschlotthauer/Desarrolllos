package com.example.lucass.tpmemotest.Niveles;

/**
 * Created by lucass on 6/11/2016.
 */
public class Nivel {

    private int numero;
    private String descripcion;
    private int imagen;

    public Nivel( int numero, String descripcion) {
        this.descripcion = descripcion;
        this.numero = numero;
    }

    public Nivel(int numero, String descripcion, int imagen) {
        this.numero = numero;
        this.descripcion = descripcion;
        this.imagen = imagen;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
