package com.libreriaWhatsapp.servicios.impl;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.List;


import com.google.gson.Gson;
import com.libreriaWhatsapp.convertidores.TipoMensajeConvertidor;
import com.libreriaWhatsapp.dominio.DatoAudio;
import com.libreriaWhatsapp.dominio.DatoBotones;
import com.libreriaWhatsapp.dominio.DatoDocumento;
import com.libreriaWhatsapp.dominio.DatoImagen;
import com.libreriaWhatsapp.dominio.DatoTexto;
import com.libreriaWhatsapp.dominio.DatoVideo;
import com.libreriaWhatsapp.dominio.DatosContacto;
import com.libreriaWhatsapp.dominio.DatosUbicacion;
import com.libreriaWhatsapp.dominio.PeticionEnvioMensaje;
import com.libreriaWhatsapp.entidades.constantes.UtilieriasWhatsappMensaje;
import com.libreriaWhatsapp.excepciones.UtileriaWhatsappExcepciones;
import com.libreriaWhatsapp.servicios.EnviarMensajeServicio;

public class EnviarMensajeServicioImpl implements EnviarMensajeServicio {
	
	private Boolean enviarMensaje(PeticionEnvioMensaje peticionMensaje,String strEndPoint,String strTelefonoPropietario,String strToken,String strVersion) {

		HttpClient client = HttpClient.newHttpClient();
        String uri =strEndPoint+strVersion+strTelefonoPropietario+"/messages" ; 
        String jsonBody = new Gson().toJson(peticionMensaje);
        byte[] byteData = jsonBody.getBytes(StandardCharsets.UTF_8);
         System.out.println(jsonBody);
       try {
        	HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(uri))
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + strToken)
                    .POST(HttpRequest.BodyPublishers.ofByteArray(byteData))
                    .build();
        	HttpResponse<String> respuesta = client.send(request, HttpResponse.BodyHandlers.ofString());
        	//validacion del token
        	return ValidacionToken(respuesta);
        	
                       
       }catch( Exception e){
    	   throw new UtileriaWhatsappExcepciones(
       			UtilieriasWhatsappMensaje.ERROR_TOKEN.getMensajeTecnico() , 
       			UtilieriasWhatsappMensaje.ERROR_TOKEN.getMensajeUsuario());
       } 
   }

	public Boolean enviarContacto(List<DatosContacto> lstDatoContacto,String strEndPoint,String strTelefonoPropietario,String strToken, 
			String strVersio,String strTelefonoCliente) {
		try {
			//validacion de los datos requerido
			validacionDatoRequeridoEnviarContacto(lstDatoContacto);
			//se inicializa el convertidor de tipo contacto
			TipoMensajeConvertidor tipoMensajeConvertidor= new TipoMensajeConvertidor();
			//se hace la convercion de datos requeridos al objeto de PeticionEnvioMensaje
			PeticionEnvioMensaje peticionEnvioMensaje = tipoMensajeConvertidor.enviarContacto(strTelefonoCliente, lstDatoContacto);
			//se estaria enviando el mensaje 
			return this.enviarMensaje(peticionEnvioMensaje, strEndPoint, strTelefonoPropietario, strToken, strVersio);
		} catch (Exception e) {
			throw new UtileriaWhatsappExcepciones(UtilieriasWhatsappMensaje.ERROR_CONTACTO, e);
		}	
	}	
	public Boolean enviarUbicacion(DatosUbicacion datosUbicacion,String strEndPoint,String strTelefonoPropietario,String strToken, 
			String strVersio,String strTelefonoCliente) {
			try {
				//se realisa de los datos requeridos
				validacionDatosRequeridoEnviarUbicacion(datosUbicacion);
				//se inicializa el convertidor de tipo contacto
				TipoMensajeConvertidor tipoMensajeConvertidor = new TipoMensajeConvertidor();
				//se hace la convercion de datos requeridos al objeto de PeticionEnvioMensaje
				PeticionEnvioMensaje peticionEnvioMensaje = tipoMensajeConvertidor.enviarUbicacion(strTelefonoCliente,datosUbicacion);
				//se estaria enviando el mensaje 
				return this.enviarMensaje(peticionEnvioMensaje, strEndPoint, strTelefonoPropietario, strToken, strVersio);
			} catch (Exception e) {
				throw new UtileriaWhatsappExcepciones(UtilieriasWhatsappMensaje.ERROR_ENVIO_MENSAJES, e);
			}
	}
	public Boolean enviarAudio(DatoAudio datosAudio,String strEndPoint,String strTelefonoPropietario,String strToken, 
			String strVersio,String strTelefonoCliente) {
		try {
			//se valida  los datos requeridos 
			validacionDatosRequeridoEnvairAudio(datosAudio);
			//se inicializa el convertidor de tipo contacto
			TipoMensajeConvertidor tipoMensajeConvertidor = new TipoMensajeConvertidor();
			//se hace la convercion de datos requeridos al objeto de PeticionEnvioMensaje
			PeticionEnvioMensaje peticionEnvioMensaje = tipoMensajeConvertidor.enviarAudio(strTelefonoCliente, datosAudio);
			//se estaria enviando el mensaje 
			return this.enviarMensaje(peticionEnvioMensaje, strEndPoint, strTelefonoPropietario, strToken, strVersio);
		} catch (Exception e) {
			throw new UtileriaWhatsappExcepciones(UtilieriasWhatsappMensaje.ERROR_VALOR_URL.getMensajeTecnico(),UtilieriasWhatsappMensaje.ERROR_VALOR_URL.getMensajeUsuario());
		}
	}
	public Boolean enviarImagen(DatoImagen datosImagen,String strEndPoint,String strTelefonoPropietario,String strToken, 
			String strVersio,String strTelefonoCliente) {
		try {
			//se valida  los datos requeridos 
			validacionDatosRequeridoEnviarImagen(datosImagen);
			//se inicializa el convertidor de tipo contacto
			TipoMensajeConvertidor tipoMensajeConvertidor = new TipoMensajeConvertidor();
			//se hace la convercion de datos requeridos al objeto de PeticionEnvioMensaje
			PeticionEnvioMensaje peticionEnvioMensaje = tipoMensajeConvertidor.enviarImagen(strTelefonoCliente, datosImagen);
			//se estaria enviando el mensaje 
			return this.enviarMensaje(peticionEnvioMensaje, strEndPoint, strTelefonoPropietario, strToken, strVersio);
		} catch (Exception e) {
			throw new UtileriaWhatsappExcepciones(UtilieriasWhatsappMensaje.ERROR_VALOR_URL,e);
		}		
	}
	public Boolean enviarDocumento(DatoDocumento datosDocumento,String strEndPoint,String strTelefonoPropietario,String strToken, 
			String strVersio,String strTelefonoCliente) {
		try {
			//se valida  los datos requeridos
			validacionDatosRequeridoEnviarDocumento(datosDocumento);
			//se inicializa el convertidor de tipo contacto
			TipoMensajeConvertidor tipoMensajeConvertidor = new TipoMensajeConvertidor();
			//se hace la convercion de datos requeridos al objeto de PeticionEnvioMensaje
			PeticionEnvioMensaje peticionEnvioMensaje = tipoMensajeConvertidor.enviarDocumento(strTelefonoCliente, datosDocumento);
			//se estaria enviando el mensaje 
			return this.enviarMensaje(peticionEnvioMensaje, strEndPoint, strTelefonoPropietario, strToken, strVersio);
		} catch (Exception e) {
			System.out.println( new UtileriaWhatsappExcepciones(UtilieriasWhatsappMensaje.ERROR_VALOR_URL,e));
			throw new UtileriaWhatsappExcepciones(UtilieriasWhatsappMensaje.ERROR_VALOR_URL,e);
		}
			
	}
	public Boolean enviarVideo(DatoVideo datosVideo,String strEndPoint,String strTelefonoPropietario,String strToken, 
			String strVersio,String strTelefonoCliente) {
		try {
			//se valida  los datos requeridos
			validacionDatoRequeridoEnviarVideo(datosVideo);
			//se inicializa el convertidor de tipo contacto
			TipoMensajeConvertidor tipoMensajeConvertidor = new TipoMensajeConvertidor();
			//se hace la convercion de datos requeridos al objeto de PeticionEnvioMensaje
			PeticionEnvioMensaje peticionEnvioMensaje = tipoMensajeConvertidor.enviarVideo(strTelefonoCliente, datosVideo);
			//se estaria enviando el mensaje 
			return this.enviarMensaje(peticionEnvioMensaje, strEndPoint, strTelefonoPropietario, strToken, strVersio);
		} catch (Exception e) {
			throw new UtileriaWhatsappExcepciones(UtilieriasWhatsappMensaje.ERROR_VALOR_URL.getMensajeTecnico(),UtilieriasWhatsappMensaje.ERROR_VALOR_URL.getMensajeUsuario());
		}
			
	}
	public Boolean enviarBotton(List<DatoBotones> lstDatosBotones,String strEndPoint,String strTelefonoPropietario,String strToken, 
								String strVersio,String strTelefonoCliente, String strTexto) {
		try {
			//se valida  los datos requeridos
			validacionDatoRequeridoEnviarBoton(lstDatosBotones);
			//se inicializa el convertidor de tipo contacto
			TipoMensajeConvertidor tipoMensajeConvertidor = new TipoMensajeConvertidor();
			//se hace la convercion de datos requeridos al objeto de PeticionEnvioMensaje
			PeticionEnvioMensaje peticionEnvioMensaje = tipoMensajeConvertidor.enviar2Boton(strTelefonoCliente, lstDatosBotones, strTexto);
			//se estaria enviando el mensaje 
			return this.enviarMensaje(peticionEnvioMensaje, strEndPoint, strTelefonoPropietario, strToken, strVersio);
			
		} catch (Exception e) {
			throw new UtileriaWhatsappExcepciones(UtilieriasWhatsappMensaje.ERROR_ID.getMensajeTecnico(),UtilieriasWhatsappMensaje.ERROR_ID.getMensajeUsuario());
		}
			
	}
	public Boolean enviarText(DatoTexto datosTexto,String strEndPoint,String strTelefonoPropietario,String strToken, 
			String strVersio,String strTelefonoCliente) {
		try {
			//se valida  los datos requeridos
			validacionDatosRequeridoEnviarTexto(datosTexto);
			//se inicializa el convertidor de tipo contacto
			TipoMensajeConvertidor tipoMensajeConvertidor = new TipoMensajeConvertidor();
			//se hace la convercion de datos requeridos al objeto de PeticionEnvioMensaje
			PeticionEnvioMensaje peticionEnvioMensaje = tipoMensajeConvertidor.enviarText(strTelefonoCliente, datosTexto);
			//se estaria enviando el mensaje 
			return this.enviarMensaje(peticionEnvioMensaje, strEndPoint, strTelefonoPropietario, strToken, strVersio);
		} catch (Exception e) {
			throw new UtileriaWhatsappExcepciones(UtilieriasWhatsappMensaje.ERROR_VALOR_TEXTO.getMensajeTecnico(),UtilieriasWhatsappMensaje.ERROR_VALOR_TEXTO.getMensajeUsuario());
		}
			
	}
	public Boolean enviarUrlVisible(DatoTexto datosTexto,String strEndPoint,String strTelefonoPropietario,String strToken, 
			String strVersio,String strTelefonoCliente) {
		try {
			//se valida  los datos requeridos
			validacionDatosRequeridoEnviarUrlVisible(datosTexto);
			//se inicializa el convertidor de tipo contacto
			TipoMensajeConvertidor tipoMensajeConvertidor = new TipoMensajeConvertidor();
			//se hace la convercion de datos requeridos al objeto de PeticionEnvioMensaje
			PeticionEnvioMensaje peticionEnvioMensaje = tipoMensajeConvertidor.enviarURLVIstaPrevia(strTelefonoCliente, datosTexto);
			//se estaria enviando el mensaje 
			return this.enviarMensaje(peticionEnvioMensaje, strEndPoint, strTelefonoPropietario, strToken, strVersio);
		} catch (Exception e) {
			throw new UtileriaWhatsappExcepciones(
					UtilieriasWhatsappMensaje.ERROR_VALOR_TEXTO.getMensajeTecnico(),
					UtilieriasWhatsappMensaje.ERROR_VALOR_TEXTO.getMensajeUsuario());
		}
			
	}
	
	public Boolean ValidacionToken(HttpResponse<String> respuesta) {
		//verifica que obtiene un codigo de respuesta de 200
		if (respuesta.statusCode() == 200) {
            return true;
        }
        	throw new UtileriaWhatsappExcepciones(
        			UtilieriasWhatsappMensaje.ERROR_TOKEN.getMensajeTecnico() , 
        			UtilieriasWhatsappMensaje.ERROR_TOKEN.getMensajeUsuario());
        
	} 
	public void validacionDatoRequeridoEnviarContacto(List<DatosContacto> lstDatoContacto) {
		//verifica que el lista de datos de contacto no sean vacio
		if(lstDatoContacto==null) {
			throw new UtileriaWhatsappExcepciones(
					UtilieriasWhatsappMensaje.ERROR_CONTACTO.getMensajeTecnico(),
					UtilieriasWhatsappMensaje.ERROR_CONTACTO.getMensajeUsuario() );
		}
		//verifica que el valor requeridono este vacio
		lstDatoContacto.forEach(Contacto->{if(Contacto.getStrNombreFormato()==null) {
			throw new UtileriaWhatsappExcepciones(
					UtilieriasWhatsappMensaje.ERROR_CONTACTO.getMensajeTecnico(),
					UtilieriasWhatsappMensaje.ERROR_CONTACTO.getMensajeUsuario() );
		}});
	}
	public void validacionDatoRequeridoEnviarBoton(List<DatoBotones> lstDatosBotones) {
		//verifica que no este vacio lista de boton
		if(lstDatosBotones==null) {
			throw new UtileriaWhatsappExcepciones(
								UtilieriasWhatsappMensaje.ERROR_ID.getMensajeTecnico(),
								UtilieriasWhatsappMensaje.ERROR_ID.getMensajeUsuario());
		}
		
		long idCunteo= lstDatosBotones.stream()
				//transforma lista de DatosBotones a secuencia de strId
				.map(DatoBotones::getStrId)
				//se alpica flitro
                .filter(strId -> strId != null && !strId.isEmpty())
                //verifica que strId sean distintos
                .distinct()
                //cuenta la cantidad de strId en lista
                .count();
		//System.out.println(idCunteo);
		lstDatosBotones.forEach(Botones->{
			//verifica que strid no este vacio
			if(Botones.getStrId()==null) {	
				throw new UtileriaWhatsappExcepciones(
										UtilieriasWhatsappMensaje.ERROR_ID.getMensajeTecnico(),
										UtilieriasWhatsappMensaje.ERROR_ID.getMensajeUsuario());}
			//verifica que la longitud de lista se mayor o igual a la cantidad de strid contado 
			if(idCunteo<lstDatosBotones.size()) {
				throw new UtileriaWhatsappExcepciones(
									UtilieriasWhatsappMensaje.ERROR_ID.getMensajeTecnico(),
								UtilieriasWhatsappMensaje.ERROR_ID.getMensajeUsuario());}
		});
	}
	public void validacionDatosRequeridoEnviarUbicacion(DatosUbicacion datosUbicacion) {
		//verifica que el  valor de longitud no este vacio
		if (datosUbicacion.getDoubleLongitud()==null ) {
			throw new UtileriaWhatsappExcepciones(
					UtilieriasWhatsappMensaje.ERROR_LONGITUD_VALOR.getMensajeTecnico(),
					UtilieriasWhatsappMensaje.ERROR_LONGITUD_VALOR.getMensajeUsuario());
		}
		//verifica que el  valor de latitud no este vacio
		if(datosUbicacion.getDoublLatitud()==null) {
			throw new UtileriaWhatsappExcepciones(
					UtilieriasWhatsappMensaje.ERROR_LATITUD_VALOR.getMensajeTecnico(),
					UtilieriasWhatsappMensaje.ERROR_LATITUD_VALOR.getMensajeUsuario());
		}
		//verifica que el  valor de latitud este entre -90 y 90
		if(datosUbicacion.getDoublLatitud()<-90||datosUbicacion.getDoublLatitud()>90){
			throw new UtileriaWhatsappExcepciones(
					UtilieriasWhatsappMensaje.ERROR_LATITUD.getMensajeTecnico(),
					UtilieriasWhatsappMensaje.ERROR_LATITUD.getMensajeUsuario());
		}
		//verifica que el  valor de longitud este entre -180 y 180
		if(datosUbicacion.getDoubleLongitud()<-180||datosUbicacion.getDoubleLongitud()>180){
			throw new UtileriaWhatsappExcepciones(
					UtilieriasWhatsappMensaje.ERROR_LONGITUD.getMensajeTecnico(),
					UtilieriasWhatsappMensaje.ERROR_LONGITUD.getMensajeUsuario());
		}
	}
	public void validacionDatosRequeridoEnvairAudio(DatoAudio datosAudio) {
		//verifica que el url no este vacio
		if(datosAudio.getStrUrl()==null) {
			throw new UtileriaWhatsappExcepciones(UtilieriasWhatsappMensaje.ERROR_VALOR_URL.getMensajeTecnico(),UtilieriasWhatsappMensaje.ERROR_VALOR_URL.getMensajeUsuario());
		}
		//verifica que el url tenga la terminacion que acepta facebhook
		if(!datosAudio.getStrUrl().contains("acc")&&!datosAudio.getStrUrl().contains("mp3")&&!datosAudio.getStrUrl().contains("mpeg")&&!datosAudio.getStrUrl().contains("ogg")&&!datosAudio.getStrUrl().contains("mp4")&&!datosAudio.getStrUrl().contains("amr")) {
			throw new UtileriaWhatsappExcepciones(UtilieriasWhatsappMensaje.ERROR_VALOR_URL.getMensajeTecnico(),UtilieriasWhatsappMensaje.ERROR_VALOR_URL.getMensajeUsuario());
		}
	}
	public void validacionDatosRequeridoEnviarImagen(DatoImagen datosImagen) {
		//verifica que el url no este vacio
		if(datosImagen.getStrUrl()==null) {
			throw new UtileriaWhatsappExcepciones(
					UtilieriasWhatsappMensaje.ERROR_VALOR_URL.getMensajeTecnico(),
					UtilieriasWhatsappMensaje.ERROR_VALOR_URL.getMensajeUsuario());
		}
		//verifica que el url tenga la terminacion que acepta facebhook
		if(!datosImagen.getStrUrl().contains("jpg") && !datosImagen.getStrUrl().contains("png")) {
			throw new UtileriaWhatsappExcepciones(
					UtilieriasWhatsappMensaje.ERROR_VALOR_URL.getMensajeTecnico(),
					UtilieriasWhatsappMensaje.ERROR_VALOR_URL.getMensajeUsuario());
		}
	}
	public void validacionDatosRequeridoEnviarDocumento(DatoDocumento datosDocumento) {
		//verifica que el url no este vacio
		if(datosDocumento.getStrUrl()==null) {
			throw new UtileriaWhatsappExcepciones(UtilieriasWhatsappMensaje.ERROR_VALOR_URL.getMensajeTecnico(),UtilieriasWhatsappMensaje.ERROR_VALOR_URL.getMensajeUsuario());
		}
		//verifica que el url tenga la terminacion que acepta facebook
		if(!datosDocumento.getStrUrl().contains("pdf") && 
	   	!datosDocumento.getStrUrl().contains("plain")&& 
	   	!datosDocumento.getStrUrl().contains("vnd.ms-powerpoint")&& 
	   	!datosDocumento.getStrUrl().contains("vnd.ms-excel")&& 
	   	!datosDocumento.getStrUrl().contains("vnd.openxmlformats-officedocument.wordprocessingml.document")&& 
	   	!datosDocumento.getStrUrl().contains("vnd.openxmlformats-officedocument.presentationml.presentation")&& 
	   	!datosDocumento.getStrUrl().contains("vnd.openxmlformats-officedocument.spreadsheetml.sheet")&& 
	   	!datosDocumento.getStrUrl().contains("msword")) {
			throw new UtileriaWhatsappExcepciones(
					UtilieriasWhatsappMensaje.ERROR_VALOR_URL.getMensajeTecnico(),
					UtilieriasWhatsappMensaje.ERROR_VALOR_URL.getMensajeUsuario());
		}
	}
	public void validacionDatoRequeridoEnviarVideo(DatoVideo datosVideo) {
		//verifica que el url no este vacio
		if(datosVideo.getStrUrl()==null) {
			throw new UtileriaWhatsappExcepciones(
					UtilieriasWhatsappMensaje.ERROR_VALOR_URL.getMensajeTecnico(),
					UtilieriasWhatsappMensaje.ERROR_VALOR_URL.getMensajeUsuario());
		}
		//verifica que el url tenga la terminacion que acepta facebook
		if(!datosVideo.getStrUrl().contains("mp4") && 
		   !datosVideo.getStrUrl().contains("3gp")) {
					throw new UtileriaWhatsappExcepciones(
							UtilieriasWhatsappMensaje.ERROR_VALOR_URL.getMensajeTecnico(),
							UtilieriasWhatsappMensaje.ERROR_VALOR_URL.getMensajeUsuario());
				}
	}
	public void validacionDatosRequeridoEnviarTexto(DatoTexto datosTexto) {
		//verifica que el strMensaje no esta vacio
		if(datosTexto.getStrMensaje()==null) {
			throw new UtileriaWhatsappExcepciones(
						UtilieriasWhatsappMensaje.ERROR_VALOR_TEXTO.getMensajeTecnico(),
						UtilieriasWhatsappMensaje.ERROR_VALOR_TEXTO.getMensajeUsuario());
		}
	}
	public void validacionDatosRequeridoEnviarUrlVisible(DatoTexto datosTexto) {
		//verifica que el strMensaje no esta vacio
			if(datosTexto.getStrMensaje()==null) {
				throw new UtileriaWhatsappExcepciones(
						UtilieriasWhatsappMensaje.ERROR_VALOR_TEXTO.getMensajeTecnico(),
						UtilieriasWhatsappMensaje.ERROR_VALOR_TEXTO.getMensajeUsuario());
			}
	}
}
