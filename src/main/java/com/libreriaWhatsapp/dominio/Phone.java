package com.libreriaWhatsapp.dominio;

public class Phone {
	private String phone;
	private String type;
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Phone() {
		
	}
	@Override
	public String toString() {
		return "Phone [phone=" + phone + ", type=" + type + "]";
	}

}
