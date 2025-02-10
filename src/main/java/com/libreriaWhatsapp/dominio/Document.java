package com.libreriaWhatsapp.dominio;

public class Document {
	private String filename;
	private String link;
	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Document() {
		super();
	}
	
	public String toString() {
		return "  { \"link\": \""+link+"\", "
				+ "\"}";
	}
}
