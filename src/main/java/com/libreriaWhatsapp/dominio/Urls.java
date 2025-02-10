package com.libreriaWhatsapp.dominio;

import java.util.List;

public class Urls {
	private List<Url> urls;

	public List<Url> getUrls() {
		return urls;
	}

	public void setUrls(List<Url> urls) {
		this.urls = urls;
	}

	public Urls() {
		
	}

	@Override
	public String toString() {
		return "Urls [urls=" + urls + "]";
	}
	
}
