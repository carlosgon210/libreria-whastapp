package com.libreriaWhatsapp.dominio;

public class Text {
	private Boolean preview_url;
	private String body;
	
	public Boolean getPreview_url() {
		return preview_url;
	}
	public void setPreview_url(Boolean preview_url) {
		this.preview_url = preview_url;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	
	public Text() {
	
	}
	@Override
	public String toString() {
		return "  { \"preview_url\": \""+preview_url+"\", "
				+ " \"body\": \""+ body+"\"}";
	}
}
