package com.libreriaWhatsapp.dominio;

import java.util.List;

public class Phones {
	private List<Phone> phones;

	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

	public Phones() {
		super();
	}

	@Override
	public String toString() {
		return "Phones [phones=" + phones + "]";
	}
	
	
	
}
