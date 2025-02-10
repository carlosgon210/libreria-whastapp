package com.libreriaWhatsapp.dominio;

public class Email {
	private String email;
	private String type;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Email() {
		
	}
	@Override
	public String toString() {
		return "Email [email=" + email + ", type=" + type + "]";
	}
	
}
