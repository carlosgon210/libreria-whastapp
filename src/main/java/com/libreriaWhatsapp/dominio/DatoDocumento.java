package com.libreriaWhatsapp.dominio;

public class DatoDocumento {
	private String strUrl;
	private String strNombreDocumento;
	public String getStrUrl() {
		return strUrl;
	}

	public void setStrUrl(String strUrl) {
		this.strUrl = strUrl;
	}

	public String getStrNombreDocumento() {
		return strNombreDocumento;
	}

	public void setStrNombreDocumento(String strNombreDocumento) {
		this.strNombreDocumento = strNombreDocumento;
	}

	public DatoDocumento() {
		super();
	}

	@Override
	public String toString() {
		return "DatoDocumento [strUrl=" + strUrl + ", strNombreDocumento=" + strNombreDocumento + "]";
	}

}
