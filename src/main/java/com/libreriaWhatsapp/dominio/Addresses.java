package com.libreriaWhatsapp.dominio;

import java.util.List;

public class Addresses {
	
	private List<Address> addresses;

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public Addresses() {
	}

	@Override
	public String toString() {
		return "Addresses [addresses=" + addresses + "]";
	}
	
	
}
