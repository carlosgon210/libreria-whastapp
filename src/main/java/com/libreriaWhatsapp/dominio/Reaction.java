package com.libreriaWhatsapp.dominio;

public class Reaction {
	private String message_id;
	private String emoji;
	public String getMessage_id() {
		return message_id;
	}
	public void setMessage_id(String message_id) {
		this.message_id = message_id;
	}
	public String getEmoji() {
		return emoji;
	}
	public void setEmoji(String emoji) {
		this.emoji = emoji;
	}
	public Reaction() {
	}
	
	@Override
	public String toString() {
		return  "  { \"message_id\": \""+message_id+"\", "
				+ " \"emoji\": \""+ emoji+"\"}";
	}
}
