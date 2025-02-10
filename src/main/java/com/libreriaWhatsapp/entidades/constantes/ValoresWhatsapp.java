package com.libreriaWhatsapp.entidades.constantes;

public enum ValoresWhatsapp {
	WHATSAPP("whatsapp"),
	RECIPENT_TYPE("individual"),
	UBICACION("location"),
	TEXTO("text"),
	AUDIO("audio"),	DOCUMENTO("document"),
	VIDEO("video"),	IMAGEN("image"),
	INTERACTIVO("interactive"),
	BOTON("button"),
	RESPONDER("reply");
	
	
	private ValoresWhatsapp(String strValor) {
		this.strValor = strValor;
	}

	private String strValor;

	public String getStrValor() {
		return strValor;
	}

	public void setStrValor(String strValor) {
		this.strValor = strValor;
	}
}
