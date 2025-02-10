package com.libreriaWhatsapp.dominio;

public class Org {
	private String company;
	private String department;
	private String title;
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Org() {
	}
	@Override
	public String toString() {
		return "{ "
		        + "\"company\": \""+company+"\", "
		        + "\"department\": \""+department+"\", "
		        + "\"title\": \""+title+"\" "
		        + "}";
	}
	
}
