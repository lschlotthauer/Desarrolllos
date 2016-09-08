package com.lslutnfra.ejercicioparacompletargrilla;

public class Ficha {

	public static final boolean TAPADA = true;
	public static final boolean DESTAPADA = false;
	
	private boolean estado;
	private int imagen;
	
	public Ficha(boolean estado,int imagen)
	{
		setEstado(estado);
		setImagen(imagen);
	}
	
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
	
}
