package com.libreriaWhatsapp.dominio;

public class Location {
	private Double longitude;
    private Double latitude;
    private String name;
    private String address;
    
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Location() {
		super();
	}
	@Override
	public String toString() {
		return "  { \"longitude\": "+longitude+", "
				+"\"latitude\": "+latitude+", "
				+"\"name\": \""+name+"\", "
				+ " \"address\": \""+ address+"\"}";
	}
    
}
