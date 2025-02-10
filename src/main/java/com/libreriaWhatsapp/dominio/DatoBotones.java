package com.libreriaWhatsapp.dominio;

import java.util.List;

public class DatoBotones {
	private String strId;
	private String strTextoBoton;
	
	public String getStrId() {
		return strId;
	}
	public void setStrId(String strId) {
		this.strId = strId;
	}
	public String getStrTextoBoton() {
		return strTextoBoton;
	}
	public void setStrTextoBoton(String strTextoBoton) {
		this.strTextoBoton = strTextoBoton;
	}
	public DatoBotones() {
		super();
	}
	@Override
	public String toString() {
		return "DatoBotones [strId=" + strId + ", strTextoBoton=" + strTextoBoton + "]";
	}
	
	
}
