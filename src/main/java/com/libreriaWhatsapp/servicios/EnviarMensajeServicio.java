package com.libreriaWhatsapp.servicios;

import java.util.List;

import com.libreriaWhatsapp.dominio.DatoAudio;
import com.libreriaWhatsapp.dominio.DatoBotones;
import com.libreriaWhatsapp.dominio.DatoDocumento;
import com.libreriaWhatsapp.dominio.DatoImagen;
import com.libreriaWhatsapp.dominio.DatoTexto;
import com.libreriaWhatsapp.dominio.DatoVideo;
import com.libreriaWhatsapp.dominio.DatosContacto;
import com.libreriaWhatsapp.dominio.DatosUbicacion;

public interface EnviarMensajeServicio {

	/**
	 * Se envía mensaje de tipo Contacto a Whatssapp por medio de los datos 
	 * 
	 * @param lstDatoContacto
	 * 			valor obligatorio nombreformato
	 * 			si ponden birthdaY el formato debe ser YYYY-MM-DD
	 * 			Todos los tipos puedens ser HOME o WORK
	 * @param strEndPoint es la base del Url de facebook
	 * @param strIdTelefonoPropietario es el codigo que da meta para tu numero
	 * @param strToken es el token que se pone en el meta for developers
	 * @param strVersion  es la version que esta usando meta for developers
	 * @param strTelefonoCliente es el numero a donde se le manda el mensaje 
	 * @return
	 */
	public Boolean enviarContacto(List<DatosContacto> lstDatoContacto,
			String strEndPoint,String strTelefonoPropietario,String strToken, 
			String strVersio,String strTelefonoCliente);
 /**
  	 * Se envía mensaje de tipo Ubicacion a Whatssapp por medio de los datos 
  * @param datosUbicacion
  * 		valores requerido son :
  * 					longuited debe estar entre -180 y 180
  * 					latitud debe estar entre -90 y 90
  *  @param strEndPoint es la base del Url de facebook
  * @param strIdTelefonoPropietario es el codigo que da meta para tu numero
  * @param strToken es el token que se pone en el meta for developers
  * @param strVersion  es la version que esta usando meta for developers
  * @param strTelefonoCliente es el numero a donde se le manda el mensaje 
  * @return
  */
	public Boolean enviarUbicacion(DatosUbicacion datosUbicacion,String strEndPoint,String strTelefonoPropietario,String strToken, 
			String strVersio,String strTelefonoCliente);
	/**
	 * Se envía mensaje de tipo Audio a Whatssapp por medio de los datos
	 * 
	 * @param datosAudio
	 * 			valores requerido strUrl
	 * 			el Url debe terminar con /aac,/mp4,/mpeg,/amr o /ogg
	 * 			tamaño limite de archivo 16MB
	 * @param strEndPoint es la base del Url de facebook
	 * @param strIdTelefonoPropietario es el codigo que da meta para tu numero
	 * @param strToken es el token que se pone en el meta for developers
	 * @param strVersion  es la version que esta usando meta for developers
	 * @param strTelefonoCliente es el numero a donde se le manda el mensaje 
	 * @return
	 */
	public Boolean enviarAudio(DatoAudio datosAudio,String strEndPoint,
			String strTelefonoPropietario,String strToken, 
			String strVersio,String strTelefonoCliente);
	/**
	 * Se envía mensaje de tipo Imagen a Whatssapp por medio de los datos
	 * @param datosImagen
	 * 			valores requerido strUrl
	 * 			el Url debe terminar con /jpeg o /png
	 * 			tamaño limite de archivo 5MB
	 *@param strEndPoint es la base del Url de facebook
	 * @param strIdTelefonoPropietario es el codigo que da meta para tu numero
	 * @param strToken es el token que se pone en el meta for developers
	 * @param strVersion  es la version que esta usando meta for developers
	 * @param strTelefonoCliente es el numero a donde se le manda el mensaje 
	 * @return
	 */
	public Boolean enviarImagen(DatoImagen datosImagen,String strEndPoint,
			String strTelefonoPropietario,String strToken, 
			String strVersio,String strTelefonoCliente);
	/**
	 * Se envía mensaje de tipo Documento a Whatssapp por medio de los datos
	 * @param datosImagen
	 * 			valores requerido strNombreDocumento
	 * 							  strUrl
	 * 						el Url debe terminar context/plain, application/pdf, application/vnd.ms-powerpoint, 
	 * 										application/msword, application/vnd.ms-excel,
	 * 										application/vnd.openxmlformats-officedocument.wordprocessingml.document, 
	 * 										application/vnd.openxmlformats-officedocument.presentationml.presentation,
	 * 										application/vnd.openxmlformats-officedocument.spreadsheetml.sheet
	 * 						tamaño limite de archivo 100MB
	 * @param strEndPoint es la base del Url de facebook
	 * @param strIdTelefonoPropietario es el codigo que da meta para tu numero
	 * @param strToken es el token que se pone en el meta for developers
	 * @param strVersion  es la version que esta usando meta for developers
	 * @param strTelefonoCliente es el numero a donde se le manda el mensaje 
	 * @return
	 */
	public Boolean enviarDocumento(DatoDocumento datosDocumento,
			String strEndPoint,String strTelefonoPropietario,String strToken, 
			String strVersio,String strTelefonoCliente);
	/**
	 * Se envía mensaje de tipo Video a Whatssapp por medio de los datos
	 * @param datosImagen
	 * 			valores requerido strNombreDocumento
	 * 							  strUrl
	 * 						el Url debe terminar video/mp4, video/3gp
	 * 						tamaño limite de archivo 16MB
	 * @param strEndPoint es la base del Url de facebook
	 * @param strIdTelefonoPropietario es el codigo que da meta para tu numero
	 * @param strToken es el token que se pone en el meta for developers
	 * @param strVersion  es la version que esta usando meta for developers
	 * @param strTelefonoCliente es el numero a donde se le manda el mensaje 
	 * @return
	 */
	public Boolean enviarVideo(DatoVideo datosVideo,String strEndPoint,
			String strTelefonoPropietario,String strToken, 
			String strVersio,String strTelefonoCliente);
	/**
	 * Se envía mensaje de tipo Boton o Botones a Whatssapp por medio de los datos
	 * @param lstDatosBotones
	 * 			valores requeridos
	 * 							strId debe ser diferente para cada boton
	 * 							strTextoBoton  es el texto que va en el boton
	 * @param strEndPoint es la base del Url de facebook
	 * @param strIdTelefonoPropietario es el codigo que da meta para tu numero
	 * @param strToken es el token que se pone en el meta for developers
	 * @param strVersion  es la version que esta usando meta for developers
	 * @param strTelefonoCliente es el numero a donde se le manda el mensaje 
	 * @param strTexto es un valor requerido que indica al cliente  a que selecciones una opcion
	 * @return
	 */
	public Boolean enviarBotton(List<DatoBotones> lstDatosBotones,
			String strEndPoint,String strTelefonoPropietario,String strToken, 
			String strVersio,String strTelefonoCliente, String strTexto);
	/**
	 * Se envía mensaje de tipo Texto a Whatssapp por medio de los datos
	 * @param datosTexto
	 * 			valores requerido strMensjae (es un mensaje de texto que desea enviar)
	 * 
	 * @param strEndPoint es la base del Url de facebook
	 * @param strIdTelefonoPropietario es el codigo que da meta para tu numero
	 * @param strToken es el token que se pone en el meta for developers
	 * @param strVersion  es la version que esta usando meta for developers
	 * @param strTelefonoCliente es el numero a donde se le manda el mensaje 
	 * @return
	 */
	public Boolean enviarText(DatoTexto datosTexto,
			String strEndPoint,String strTelefonoPropietario,String strToken, 
			String strVersio,String strTelefonoCliente);
	/**
	 * Se envía mensaje de tipo Texto  con vita previa  al URL a Whatssapp por medio de los datos
	 *
	 * @param datosTexto
	 * 			valores requerido strMensaje
	 * @param strEndPoint es la base del Url de facebook
	 * @param strIdTelefonoPropietario es el codigo que da meta para tu numero
	 * @param strToken es el token que se pone en el meta for developers
	 * @param strVersion  es la version que esta usando meta for developers
	 * @param strTelefonoCliente es el numero a donde se le manda el mensaje 
	 * @return
	 */
	public Boolean enviarUrlVisible(DatoTexto datosTexto,
			String strEndPoint,String strTelefonoPropietario,String strToken, 
			String strVersio,String strTelefonoCliente);
}
