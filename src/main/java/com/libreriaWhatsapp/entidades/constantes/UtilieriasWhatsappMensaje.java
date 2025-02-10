package com.libreriaWhatsapp.entidades.constantes;

public enum UtilieriasWhatsappMensaje {
	ERROR_ENVIO_MENSAJES(
			"No fue  enviar el mensaje",
			"No fue posible enviar el mensaje",
			400),
	ERROR_CONTACTO(
			"El valor del nombre del contacto esta vacio",
			"El valor del nombre del contacto esta vacio",
			400),
	ERROR_ID(
			"El valor del id esta vacio",
			"El valor del id esta vacio",
			400),
	ERROR_ID_IGUAL(
			"El valor del id se repite",
			"El valor del id se repite",
			400),
	ERROR_LATITUD(
			"El valor de latitud debe estar entre -90 y 90",
			"El valor de latitud debe estar entre -90 y 90",
			400),
	ERROR_LATITUD_VALOR(
			"El valor de latitud esta vacio",
			"El valor de latitud esta vacio",
			400),
	ERROR_LONGITUD(
			"El valor de longitud debe estar entre -180 y 180",
			"El valor de longitud debe estar entre -180 y 180",
			400),
	ERROR_LONGITUD_VALOR(
			"El valor de longitud esta vacio",
			"El valor de longitud esta vacio",
			400),
	ERROR_TOKEN(
			"El token esta mal",
			"El token esta mal",
			401),
	ERROR_VALOR_URL(
			"falta el valor del enlace",
			"falta el valor del URL",
			400),
	ERROR_VALOR_TEXTO(
			"falta el valor del texto",
			"falta el valor del texto",
			400);
	
	private String mensajeTecnico;
	private String mensajeUsuario;
	private Integer codigoEspecifico;

	private UtilieriasWhatsappMensaje(String mensajeTecnico, String mensajeUsuario,
			Integer codigoEspecifico) {
		this.mensajeTecnico = mensajeTecnico;
		this.mensajeUsuario = mensajeUsuario;
		this.codigoEspecifico = codigoEspecifico;
	}
	public String getMensajeTecnico() {
		return mensajeTecnico;
	}
	public String getMensajeUsuario() {
		return mensajeUsuario;
	}
	public Integer getCodigoEspecifico() {
		return codigoEspecifico;
	}
}
