package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.libreriaWhatsapp.convertidores.TipoMensajeConvertidor;
import com.libreriaWhatsapp.dominio.DatoAudio;
import com.libreriaWhatsapp.dominio.DatoBotones;
import com.libreriaWhatsapp.dominio.DatoDocumento;
import com.libreriaWhatsapp.dominio.DatoImagen;
import com.libreriaWhatsapp.dominio.DatoTexto;
import com.libreriaWhatsapp.dominio.DatoVideo;
import com.libreriaWhatsapp.dominio.DatosContacto;
import com.libreriaWhatsapp.dominio.DatosUbicacion;
import com.libreriaWhatsapp.servicios.impl.EnviarMensajeServicioImpl;


@SpringBootTest
class PruebaWhatsapp {

	@Ignore
	public void envioMensajePrueba() {
		String endpoint = "https://graph.facebook.com";
	    String phoneNumberId = "143473008849625";
	    String accessToken = "EAAKFLZA5qungBOwn3eZCtBpbE44sPUotkUsUH9GsvAVr2DYSBo8mN59IZA3yeUVgciCHk1a3qZBdy2cQnpY0xbAjmJxSBp6TyyMfagIYPVSNXCohvxByY4s2zUmD8m9EZBF1ZBSqYe1BJNZBbjxFLRbVimp5pmHWZCbtCG8CTNDOTLyP8FMZAMmBI8Rt1vaaZC1fZCv4TzDgWLZCeZAODZCSGgqBZCSjXdDyuS0Uf7bCzcZD";
	    String version ="/v17.0/";
		String telefono="51955784470"; 
		EnviarMensajeServicioImpl enviarMensajeServicioImpl = new EnviarMensajeServicioImpl();
		DatoTexto datoTexto= new DatoTexto();
		//datoTexto.setStrMensaje("hola");
		boolean respuesta= enviarMensajeServicioImpl.enviarText(datoTexto, endpoint, phoneNumberId, accessToken, version, telefono);
	}
	@Ignore
	public void enviarURLVIstaPrevia() {
		String endpoint = "https://graph.facebook.com";
	    String phoneNumberId = "143473008849625";
	    String accessToken = "EAAKFLZA5qungBOwn3eZCtBpbE44sPUotkUsUH9GsvAVr2DYSBo8mN59IZA3yeUVgciCHk1a3qZBdy2cQnpY0xbAjmJxSBp6TyyMfagIYPVSNXCohvxByY4s2zUmD8m9EZBF1ZBSqYe1BJNZBbjxFLRbVimp5pmHWZCbtCG8CTNDOTLyP8FMZAMmBI8Rt1vaaZC1fZCv4TzDgWLZCeZAODZCSGgqBZCSjXdDyuS0Uf7bCzcZD";
	    String version ="/v17.0/";
		String telefono="51955784470"; 
		//llamamos el metodo que envia el modelo
		EnviarMensajeServicioImpl enviarMensajeServicioImpl = new EnviarMensajeServicioImpl();
		
		//llamamos el modelo json
		DatoTexto datosTexto= new DatoTexto();
			datosTexto.setStrMensaje("asas");
		boolean respuesta= enviarMensajeServicioImpl.enviarUrlVisible(datosTexto, endpoint, phoneNumberId, accessToken, version, telefono);

	}
	@Ignore
	public void envioContactoPrueba() {
		String endpoint = "https://graph.facebook.com";
	    String telefonPropietario ="143473008849625";
	    String accessToken = "EAAKFLZA5qungBOwn3eZCtBpbE44sPUotkUsUH9GsvAVr2DYSBo8mN59IZA3yeUVgciCHk1a3qZBdy2cQnpY0xbAjmJxSBp6TyyMfagIYPVSNXCohvxByY4s2zUmD8m9EZBF1ZBSqYe1BJNZBbjxFLRbVimp5pmHWZCbtCG8CTNDOTLyP8FMZAMmBI8Rt1vaaZC1fZCv4TzDgWLZCeZAODZCSGgqBZCSjXdDyuS0Uf7bCzcZD";
	    String version ="/v17.0/";
		String telefonoCliente="51955784470";//"524773774400"; 
		//llamamos el metodo que envia el modelo
		EnviarMensajeServicioImpl enviarMensajeImpl = new EnviarMensajeServicioImpl();
		//llamamos el modelo json
		TipoMensajeConvertidor tipoMensaje= new TipoMensajeConvertidor();
		//PeticionEnvioMensaje model1= tipoMensaje.
		List<DatosContacto> lstDatosContacto= new ArrayList<DatosContacto>();
		DatosContacto datoContacto= new DatosContacto();
		//datoContacto.setStrCiudad("Lima");
		//datoContacto.setStrCalle("Av Canto Grande");
		//datoContacto.setStrEstado("Lima");
		//datoContacto.setCodigoPostal("15404");
		//datoContacto.setPais("Peru");
		datoContacto.setStrTipoDireccion("HOME");
		datoContacto.setStrCorrero("i2020@gmail.com");
		datoContacto.setStrTipoCorreo("HOME");
		datoContacto.setStrNombreFormato("carlos");//**
		datoContacto.setStrNombre("Carlos");
		datoContacto.setStrApellido("Gonzales");
		datoContacto.setStrSegundoNombre("Enrique");
		datoContacto.setStrPrefijo("chuky");
		datoContacto.setStrSufijo("charles");
		datoContacto.setStrCompañia("GFa");
		datoContacto.setStrDepartamento("IT");
		datoContacto.setStrTitulo("practicante");
		datoContacto.setStrTelefono("51955784470");
		datoContacto.setStrTipoTelefono("HOME");
		datoContacto.setStrUrl("google.com");
		datoContacto.setStrTipoUrl("WORK");
		
		lstDatosContacto.add(datoContacto);
		
		Boolean re2 = enviarMensajeImpl.enviarContacto(lstDatosContacto, endpoint, telefonPropietario, accessToken, version, telefonoCliente);
	}
	@Ignore
	public void enviarUbicacionPrueba() {
		String endpoint = "https://graph.facebook.com";
	    String telefonPropietario = "143473008849625";
	    String accessToken = "EAAKFLZA5qungBOwn3eZCtBpbE44sPUotkUsUH9GsvAVr2DYSBo8mN59IZA3yeUVgciCHk1a3qZBdy2cQnpY0xbAjmJxSBp6TyyMfagIYPVSNXCohvxByY4s2zUmD8m9EZBF1ZBSqYe1BJNZBbjxFLRbVimp5pmHWZCbtCG8CTNDOTLyP8FMZAMmBI8Rt1vaaZC1fZCv4TzDgWLZCeZAODZCSGgqBZCSjXdDyuS0Uf7bCzcZD";
	    String version ="/v17.0/";
		String telefonoCliente="51955784470"; 
		//llamamos el metodo que envia el modelo
		EnviarMensajeServicioImpl enviarMensajeServicioImpl = new EnviarMensajeServicioImpl();
		
		DatosUbicacion datoUbicacion= new DatosUbicacion();
		datoUbicacion.setDoubleLongitud(-100.3127);// entre -180 y 180
		datoUbicacion.setDoublLatitud(20.6814); //entre -90 y 90
		datoUbicacion.setStrNombre("El Asturiano");
		datoUbicacion.setStrDireccion("Santiago Tapia Ote. 151, Centro");
		
		boolean respuesta= enviarMensajeServicioImpl.enviarUbicacion(datoUbicacion, endpoint, telefonPropietario, accessToken, version, telefonoCliente);
			
	}
	@Ignore
	public void enviarAudioPrueba() {
		String endpoint = "https://graph.facebook.com";
	    String telefonoPropietario = "143473008849625";
	    String accessToken = "EAAKFLZA5qungBOwn3eZCtBpbE44sPUotkUsUH9GsvAVr2DYSBo8mN59IZA3yeUVgciCHk1a3qZBdy2cQnpY0xbAjmJxSBp6TyyMfagIYPVSNXCohvxByY4s2zUmD8m9EZBF1ZBSqYe1BJNZBbjxFLRbVimp5pmHWZCbtCG8CTNDOTLyP8FMZAMmBI8Rt1vaaZC1fZCv4TzDgWLZCeZAODZCSGgqBZCSjXdDyuS0Uf7bCzcZD";
	    String version ="/v17.0/";
		String telefonoCliente="51955784470"; 
		//llamamos el metodo que envia el modelo
		EnviarMensajeServicioImpl enviarMensajeServicioImpl = new EnviarMensajeServicioImpl();
		DatoAudio datoAudio= new DatoAudio();
		datoAudio.setStrUrl("https://www.elongsound.com/images/mp3/cartoon_4.mp3");
		
		boolean respuesta = enviarMensajeServicioImpl.enviarAudio(datoAudio, endpoint, telefonoPropietario, accessToken, version, telefonoCliente);
			
	}
	@Ignore
	public void enviarDocumentoPrueba() {
		String endpoint = "https://graph.facebook.com";
	    String telefonoPropietario = "143473008849625";
	    String accessToken = "EAAKFLZA5qungBOwn3eZCtBpbE44sPUotkUsUH9GsvAVr2DYSBo8mN59IZA3yeUVgciCHk1a3qZBdy2cQnpY0xbAjmJxSBp6TyyMfagIYPVSNXCohvxByY4s2zUmD8m9EZBF1ZBSqYe1BJNZBbjxFLRbVimp5pmHWZCbtCG8CTNDOTLyP8FMZAMmBI8Rt1vaaZC1fZCv4TzDgWLZCeZAODZCSGgqBZCSjXdDyuS0Uf7bCzcZD";
	    String version ="/v17.0/";
		String telefonoCliente="51955784470"; 
		//llamamos el metodo que envia el modelo
		EnviarMensajeServicioImpl enviarMensajeServicioImpl = new EnviarMensajeServicioImpl();
		 DatoDocumento datoDocumento = new DatoDocumento();
		 datoDocumento.setStrNombreDocumento("Fisica General");
		 datoDocumento.setStrUrl("https://fisicas.ucm.es/data/cont/media/www/pag-39686/fisica-general-libro-completo.pdf");
		 
		 boolean respuesta = enviarMensajeServicioImpl.enviarDocumento(datoDocumento, endpoint, telefonoPropietario, accessToken, version, telefonoCliente);
	}
	@Ignore
	public void enviarImagenPrueba() {
		String endpoint = "https://graph.facebook.com";
	    String telefonoPropietario = "143473008849625";
	    String accessToken = "EAAKFLZA5qungBOwn3eZCtBpbE44sPUotkUsUH9GsvAVr2DYSBo8mN59IZA3yeUVgciCHk1a3qZBdy2cQnpY0xbAjmJxSBp6TyyMfagIYPVSNXCohvxByY4s2zUmD8m9EZBF1ZBSqYe1BJNZBbjxFLRbVimp5pmHWZCbtCG8CTNDOTLyP8FMZAMmBI8Rt1vaaZC1fZCv4TzDgWLZCeZAODZCSGgqBZCSjXdDyuS0Uf7bCzcZD";
	    String version ="/v17.0/";
		String telefonoCliente="51955784470"; 
		//llamamos el metodo que envia el modelo
		EnviarMensajeServicioImpl enviarMensajeServicioImpl = new EnviarMensajeServicioImpl();
		//llamamos el modelo json
		TipoMensajeConvertidor tipoMensaje= new TipoMensajeConvertidor();
		
		DatoImagen datoImagen = new DatoImagen();
		datoImagen.setStrUrl("https://i.pinimg.com/736x/be/41/6f/be416ffb166483d0479b29a4ae907faf.jpg");
		
		boolean respuesta = enviarMensajeServicioImpl.enviarImagen(datoImagen, endpoint, telefonoPropietario, accessToken, version, telefonoCliente);
			
	}
	@Ignore
	public void enviarVideoPrueba() {
		String endpoint = "https://graph.facebook.com";
	    String telefonoPropietario = "143473008849625";
	    String accessToken = "EAAKFLZA5qungBOwn3eZCtBpbE44sPUotkUsUH9GsvAVr2DYSBo8mN59IZA3yeUVgciCHk1a3qZBdy2cQnpY0xbAjmJxSBp6TyyMfagIYPVSNXCohvxByY4s2zUmD8m9EZBF1ZBSqYe1BJNZBbjxFLRbVimp5pmHWZCbtCG8CTNDOTLyP8FMZAMmBI8Rt1vaaZC1fZCv4TzDgWLZCeZAODZCSGgqBZCSjXdDyuS0Uf7bCzcZD";
	    String version ="/v17.0/";
		String telefonoCliente="51955784470"; 
		//llamamos el metodo que envia el modelo
		EnviarMensajeServicioImpl enviarMensajeServicioImpl = new EnviarMensajeServicioImpl();
		DatoVideo datoVideo = new DatoVideo();
		datoVideo.setStrUrl("https://gfa-recursos-portal-conecta-des.s3.amazonaws.com/TRANSPORTE+FORANEO-1350X410_2.mp4");
		
		boolean respuesta = enviarMensajeServicioImpl.enviarVideo(datoVideo, endpoint, telefonoPropietario, accessToken, version, telefonoCliente);
	}
	@Ignore
	public void enviarBotonPrueba() {
		String endpoint = "https://graph.facebook.com";
	    String telefonoPropietario = "143473008849625";
	    String accessToken = "EAAKFLZA5qungBOwn3eZCtBpbE44sPUotkUsUH9GsvAVr2DYSBo8mN59IZA3yeUVgciCHk1a3qZBdy2cQnpY0xbAjmJxSBp6TyyMfagIYPVSNXCohvxByY4s2zUmD8m9EZBF1ZBSqYe1BJNZBbjxFLRbVimp5pmHWZCbtCG8CTNDOTLyP8FMZAMmBI8Rt1vaaZC1fZCv4TzDgWLZCeZAODZCSGgqBZCSjXdDyuS0Uf7bCzcZD";
	    String version ="/v17.0/";
		String telefonoCliente="51955784470";
		String strTexto="selecciones una opcion";
		//llamamos el metodo que envia el modelo
		EnviarMensajeServicioImpl enviarMensajeServicioImpl = new EnviarMensajeServicioImpl();
		List<DatoBotones> lstDatoBotton = new ArrayList<>();
		DatoBotones datoBotton1= new DatoBotones();
		datoBotton1.setStrId("01");
		datoBotton1.setStrTextoBoton("boton1");
		
		DatoBotones datoBotton2= new DatoBotones();
		datoBotton2.setStrId("02");
		datoBotton2.setStrTextoBoton("boton2");
		
		 lstDatoBotton.add(datoBotton1);
		 lstDatoBotton.add(datoBotton2);
		 
		boolean respuesta = enviarMensajeServicioImpl.enviarBotton(lstDatoBotton, endpoint, telefonoPropietario, accessToken, version, telefonoCliente,strTexto);
			
	}
}
