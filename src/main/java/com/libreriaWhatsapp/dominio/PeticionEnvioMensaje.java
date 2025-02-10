package com.libreriaWhatsapp.dominio;

import java.util.List;

public class PeticionEnvioMensaje {
	private String messaging_product;
	private String recipient_type;
	private String to;
	private String type;
	
		private Text text;
		private Reaction reaction;
		private Location location;
		private List<Contact> contacts;
		private Document document; 
		private Audio audio;
		private Image image;
		private Video video;
		private Interactive interactive;
		
		public Interactive getInteractive() {
			return interactive;
		}
		public void setInteractive(Interactive interactive) {
			this.interactive = interactive;
		}
		public String getMessaging_product() {
			return messaging_product;
		}
		public void setMessaging_product(String messaging_product) {
			this.messaging_product = messaging_product;
		}
		public String getRecipient_type() {
			return recipient_type;
		}
		public void setRecipient_type(String recipient_type) {
			this.recipient_type = recipient_type;
		}
		public String getTo() {
			return to;
		}
		public void setTo(String to) {
			this.to = to;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public Text getText() {
			return text;
		}
		public void setText(Text text) {
			this.text = text;
		}
		public Reaction getReaction() {
			return reaction;
		}
		public void setReaction(Reaction reaction) {
			this.reaction = reaction;
		}
		public Location getLocation() {
			return location;
		}
		public void setLocation(Location location) {
			this.location = location;
		}
		public List<Contact> getContacts() {
			return contacts;
		}
		public void setContacts(List<Contact> contacts) {
			this.contacts = contacts;
		}
		public Document getDocument() {
			return document;
		}
		public void setDocument(Document document) {
			this.document = document;
		}
		public Audio getAudio() {
			return audio;
		}
		public void setAudio(Audio audio) {
			this.audio = audio;
		}
		public Image getImage() {
			return image;
		}
		public void setImage(Image image) {
			this.image = image;
		}
		public Video getVideo() {
			return video;
		}
		public void setVideo(Video video) {
			this.video = video;
		}
		
		public PeticionEnvioMensaje() {
			
		}
		

	
	
	
}
