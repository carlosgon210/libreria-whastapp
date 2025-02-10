package com.libreriaWhatsapp.dominio;

public class DatoAudio {
	private String strUrl;

	public String getStrUrl() {
		return strUrl;
	}

	public void setStrUrl(String strUrl) {
		this.strUrl = strUrl;
	}

	public DatoAudio() {
		super();
	}

	@Override
	public String toString() {
		return "DatoAudio [strUrl=" + strUrl + "]";
	}

}
