package com.libreriaWhatsapp.dominio;

public class DatoVideo {
	private String strUrl;
	

	public String getStrUrl() {
		return strUrl;
	}

	public void setStrUrl(String strUrl) {
		this.strUrl = strUrl;
	}

	public DatoVideo() {
		
	}

	@Override
	public String toString() {
		return "DatoVideo [strUrl=" + strUrl + "]";
	}

}
