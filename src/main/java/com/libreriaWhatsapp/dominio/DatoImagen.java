package com.libreriaWhatsapp.dominio;

public class DatoImagen {
	private String strUrl;

	public String getStrUrl() {
		return strUrl;
	}

	public void setStrUrl(String strUrl) {
		this.strUrl = strUrl;
	}

	public DatoImagen() {
		
	}

	@Override
	public String toString() {
		return "DatoImagen [strUrl=" + strUrl + "]";
	}
	
}
