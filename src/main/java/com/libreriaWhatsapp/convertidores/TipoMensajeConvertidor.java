package com.libreriaWhatsapp.convertidores;

import java.util.ArrayList;
import java.util.List;

import com.libreriaWhatsapp.dominio.Action;
import com.libreriaWhatsapp.dominio.Address;
import com.libreriaWhatsapp.dominio.Addresses;
import com.libreriaWhatsapp.dominio.Audio;
import com.libreriaWhatsapp.dominio.Body;
import com.libreriaWhatsapp.dominio.Button;
import com.libreriaWhatsapp.dominio.Buttons;
import com.libreriaWhatsapp.dominio.Contact;
import com.libreriaWhatsapp.dominio.Contacts;
import com.libreriaWhatsapp.dominio.DatoAudio;
import com.libreriaWhatsapp.dominio.DatoBotones;
import com.libreriaWhatsapp.dominio.DatoDocumento;
import com.libreriaWhatsapp.dominio.DatoImagen;
import com.libreriaWhatsapp.dominio.DatoTexto;
import com.libreriaWhatsapp.dominio.DatoVideo;
import com.libreriaWhatsapp.dominio.DatosContacto;
import com.libreriaWhatsapp.dominio.DatosUbicacion;
import com.libreriaWhatsapp.dominio.Document;
import com.libreriaWhatsapp.dominio.Email;
import com.libreriaWhatsapp.dominio.Emails;
import com.libreriaWhatsapp.dominio.Image;
import com.libreriaWhatsapp.dominio.Interactive;
import com.libreriaWhatsapp.dominio.Location;
import com.libreriaWhatsapp.dominio.Name;
import com.libreriaWhatsapp.dominio.Org;
import com.libreriaWhatsapp.dominio.PeticionEnvioMensaje;
import com.libreriaWhatsapp.dominio.Phone;
import com.libreriaWhatsapp.dominio.Phones;
import com.libreriaWhatsapp.dominio.Reply;
import com.libreriaWhatsapp.dominio.Text;
import com.libreriaWhatsapp.dominio.Url;
import com.libreriaWhatsapp.dominio.Urls;
import com.libreriaWhatsapp.dominio.Video;
import com.libreriaWhatsapp.entidades.constantes.ValoresWhatsapp;

public class TipoMensajeConvertidor {

	 public PeticionEnvioMensaje enviarText(String strTelefono, DatoTexto datoTexto) {
		 
		 PeticionEnvioMensaje model = new PeticionEnvioMensaje();

			model.setMessaging_product(ValoresWhatsapp.WHATSAPP.getStrValor());
	        model.setRecipient_type(ValoresWhatsapp.RECIPENT_TYPE.getStrValor());
	        model.setTo(strTelefono);
	        model.setType(ValoresWhatsapp.TEXTO.getStrValor());
	        
	        Text text= new Text();
	        text.setPreview_url(false);
	        text.setBody(datoTexto.getStrMensaje());
	        
	         model.setText(text);
	         
		 return model;
	 }
	 public PeticionEnvioMensaje enviarURLVIstaPrevia(String strTelefono, DatoTexto datoTexto) {
		 
		 PeticionEnvioMensaje model = new PeticionEnvioMensaje();

		 	model.setMessaging_product(ValoresWhatsapp.WHATSAPP.getStrValor());
	        model.setRecipient_type(ValoresWhatsapp.RECIPENT_TYPE.getStrValor());
	        model.setTo(strTelefono);
	        model.setType(ValoresWhatsapp.TEXTO.getStrValor());
	        
	        Text text= new Text();
	        text.setPreview_url(true);
	        text.setBody(datoTexto.getStrMensaje());
	        
	         model.setText(text);
	         
		 return model;
	 }
	 public PeticionEnvioMensaje enviarUbicacion(String strTelefono, DatosUbicacion datoUbicacion) {
		 
		 PeticionEnvioMensaje model = new PeticionEnvioMensaje();

			model.setMessaging_product(ValoresWhatsapp.WHATSAPP.getStrValor());
	        model.setTo(strTelefono);
	        model.setType(ValoresWhatsapp.UBICACION.getStrValor());
	        
	        Location location=new Location();
	        location.setLongitude(datoUbicacion.getDoubleLongitud());
	        location.setLatitude(datoUbicacion.getDoublLatitud());
	        location.setName(datoUbicacion.getStrNombre());
	        location.setAddress(datoUbicacion.getStrDireccion());
	        
	        model.setLocation(location);
	        
	       
		 return model;
	 }
	 public PeticionEnvioMensaje enviarContacto(String strTelefono,List<DatosContacto> lstDatosContatos) {
		 PeticionEnvioMensaje model = new PeticionEnvioMensaje();
		 
		 	model.setMessaging_product(ValoresWhatsapp.WHATSAPP.getStrValor());
	        model.setTo(strTelefono);
	        model.setType("contacts");
	        

	        Contacts contactos= new Contacts();
	        List<Contact> lstContacts= new ArrayList<>();
	        
	       for (DatosContacto datoContacto:lstDatosContatos) {
	    	   Address address = new Address();
		        address.setStreet(datoContacto.getStrCalle());
		        address.setCity(datoContacto.getStrCiudad());
		        address.setState(datoContacto.getStrEstado());
		        address.setZip(datoContacto.getStrCodigoPostal());
		        address.setCountry(datoContacto.getStrPais());
		        address.setCountry_code(datoContacto.getStrCodigoPais());
		        address.setType(datoContacto.getStrTipoDireccion());
		        
		        Addresses addresses = new Addresses();
		        List<Address> lstAddresses=new ArrayList<>();
		        lstAddresses.add(address);
		        addresses.setAddresses(lstAddresses);
		     
		        Email correo= new Email();
		        correo.setEmail(datoContacto.getStrCorrero());
		        correo.setType(datoContacto.getStrTipoCorreo());// HOME o Work
		        
		        Emails correos= new Emails();
		        List<Email> lstCorreos = new ArrayList<Email>();
		        lstCorreos.add(correo);
		        correos.setEmails(lstCorreos);
		        
		        Name nombre = new Name();
		        nombre.setFormatted_name(datoContacto.getStrNombreFormato());//*
		        nombre.setFirst_name(datoContacto.getStrNombre());
		        nombre.setLast_name(datoContacto.getStrApellido());
		        nombre.setMiddle_name(datoContacto.getStrSegundoNombre());
		        nombre.setSuffix(datoContacto.getStrSufijo());
		        nombre.setPrefix(datoContacto.getStrPrefijo());
		        
		        Org org = new Org();
		        org.setCompany(datoContacto.getStrCompañia());
		        org.setDepartment(datoContacto.getStrDepartamento());
		        org.setTitle(datoContacto.getStrTitulo());
		        
		        Phone phone = new Phone();
		        phone.setPhone(datoContacto.getStrTelefono());
		        phone.setType(datoContacto.getStrTipoTelefono());
		        
		        Phones phones = new Phones();
		        List<Phone> lstPhones = new ArrayList<Phone>();
		        lstPhones.add(phone);
		        phones.setPhones(lstPhones);
		        
		        Url url = new Url();
		        url.setUrl(datoContacto.getStrUrl());
		        url.setType(datoContacto.getStrTipoUrl());
		        
		        Urls urls = new Urls();
		        List<Url> lstUrls = new ArrayList<Url>();
		        lstUrls.add(url);
		        urls.setUrls(lstUrls);
		        
			  Contact contacto= new Contact();
	        contacto.setAddresses(lstAddresses);
	        contacto.setBirthday(datoContacto.getStrCumpleaños()); //formato:"YYYY-MM-DD"
	        contacto.setEmails(lstCorreos);
	        contacto.setName(nombre);
	        contacto.setOrg(org);
	        contacto.setPhones(lstPhones);
	        contacto.setUrls(lstUrls);
	        
	        lstContacts.add(contacto);
		}
	       
	      
	        
	        
	        contactos.setContacts(lstContacts);
	        
	        
	        model.setContacts(lstContacts);
		 return model;
	 }
	 public PeticionEnvioMensaje enviarAudio(String strTelefono, DatoAudio datoAudio) {
		 
		 PeticionEnvioMensaje model = new PeticionEnvioMensaje();
		 	model.setMessaging_product(ValoresWhatsapp.WHATSAPP.getStrValor());
	        model.setRecipient_type(ValoresWhatsapp.RECIPENT_TYPE.getStrValor());
	        model.setTo(strTelefono);
	        model.setType(ValoresWhatsapp.AUDIO.getStrValor());
	        
	        Audio audio =new Audio();
	        audio.setLink(datoAudio.getStrUrl());//link http
			model.setAudio(audio);
		 return model;
	 }	 
	 public PeticionEnvioMensaje enviarDocumento(String strTelefono, DatoDocumento datoDocumento) {
		 
		 PeticionEnvioMensaje model = new PeticionEnvioMensaje();
		 	model.setMessaging_product(ValoresWhatsapp.WHATSAPP.getStrValor());
	        model.setRecipient_type(ValoresWhatsapp.RECIPENT_TYPE.getStrValor());
	        model.setTo(strTelefono);
	        model.setType(ValoresWhatsapp.DOCUMENTO.getStrValor());
	        
	        Document documento =new Document();
	        documento.setFilename(datoDocumento.getStrNombreDocumento());//nombre de documento 
	        documento.setLink(datoDocumento.getStrUrl());//link de documento http
			model.setDocument(documento);
		 return model;
	 }
	 public PeticionEnvioMensaje enviarImagen(String strTelefono, DatoImagen datoImagen) {
		 
		 PeticionEnvioMensaje model = new PeticionEnvioMensaje();
		 	model.setMessaging_product(ValoresWhatsapp.WHATSAPP.getStrValor());
	        model.setRecipient_type(ValoresWhatsapp.RECIPENT_TYPE.getStrValor());
	        model.setTo(strTelefono);
	        model.setType(ValoresWhatsapp.IMAGEN.getStrValor());
	        
	        Image image =new Image();
	        image.setLink(datoImagen.getStrUrl());//link de documento http
			model.setImage(image);
		 return model;
	 }
	 public PeticionEnvioMensaje enviarVideo(String strTelefono, DatoVideo datoVideo) {
		 PeticionEnvioMensaje model= new PeticionEnvioMensaje();
		 	model.setMessaging_product(ValoresWhatsapp.WHATSAPP.getStrValor());
	        model.setRecipient_type(ValoresWhatsapp.RECIPENT_TYPE.getStrValor());
	        model.setTo(strTelefono);
	        model.setType(ValoresWhatsapp.VIDEO.getStrValor());
	        
	        
	        
	        Video video  =new Video();
	        video.setLink(datoVideo.getStrUrl());//link de documento http
			model.setVideo(video);
		 return model;
	 }
	 public PeticionEnvioMensaje enviar2Boton(String strTelefono,List<DatoBotones> lstDatosBottones,String strTexto) {
		 PeticionEnvioMensaje model = new PeticionEnvioMensaje();
		 
		 model.setMessaging_product(ValoresWhatsapp.WHATSAPP.getStrValor());
	     model.setRecipient_type(ValoresWhatsapp.RECIPENT_TYPE.getStrValor());
	     model.setTo(strTelefono);
	     model.setType(ValoresWhatsapp.INTERACTIVO.getStrValor());
	
		 
		 Interactive interactive = new Interactive();
		 interactive.setType(ValoresWhatsapp.BOTON.getStrValor());
		 
		 Body body = new Body();
		 body.setText(strTexto);
		 interactive.setBody(body);
		 
		 Action action= new Action();

	      
	     Buttons botones= new Buttons();
	     List<Button> lstButtons= new ArrayList<>();
	     for(DatoBotones datoBotones:lstDatosBottones) {
	    	 Button botton= new Button();
	    	 botton.setType(ValoresWhatsapp.RESPONDER.getStrValor());
	    	 	Reply reply = new Reply();
	    	 	reply.setId(datoBotones.getStrId());
	    	 	reply.setTitle(datoBotones.getStrTextoBoton());
	    	 botton.setReply(reply);
	    	 lstButtons.add(botton);
	     }
	     botones.setButtons(lstButtons);
		action.setButtons(lstButtons);
		interactive.setAction(action);
		model.setInteractive(interactive);
		
		 return model;
	 }
}
