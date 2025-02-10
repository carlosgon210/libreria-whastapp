package com.libreriaWhatsapp.dominio;

public class DatoTexto {
	private String strMensaje;

	public String getStrMensaje() {
		return strMensaje;
	}

	public void setStrMensaje(String strMensaje) {
		this.strMensaje = strMensaje;
	}

	public DatoTexto() {
		super();
	}

	@Override
	public String toString() {
		return "DatoTexto [strMensaje=" + strMensaje + "]";
	}
	
	
}
