package com.libreriaWhatsapp.dominio;

import java.util.List;

public class Emails {
 private List<Email> emails;

public List<Email> getEmails() {
	return emails;
}

public void setEmails(List<Email> emails) {
	this.emails = emails;
}

public Emails() {
	super();
}

@Override
public String toString() {
	return "Emails [emails=" + emails + "]";
}
 

}
