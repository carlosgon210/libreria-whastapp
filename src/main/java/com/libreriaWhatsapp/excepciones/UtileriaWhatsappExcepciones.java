package com.libreriaWhatsapp.excepciones;

import com.libreriaWhatsapp.entidades.constantes.UtilieriasWhatsappMensaje;

public class UtileriaWhatsappExcepciones extends LibreriaGenericaExcepciones{

private static final long serialVersionUID = 1L;
	
	private static final String TIPO_EXCEPCION = "Error al realizar consumos de whatsapp.";
	private String mensajeTecnico = "Error al realizar consumos de whatsapp.";
	private String mensajeUsuario = "Error al realizar consumos de whatsapp.";
	private Integer codigo = 400;
	private Exception excepcionReal = new IllegalArgumentException("Ocurrió una excepcion al consumir api whatsapp");
 
	public UtileriaWhatsappExcepciones() {
		super(TIPO_EXCEPCION);
	}
 
	/**
	 * Con este constructor se debe indicar que tipo de mensaje tecnico, de usuario
	 * y codigo especifico se debe devolver. Si se envia null, se enviaran los
	 * valores predeterminados
	 * 
	 * @param mensaje mensaje tecnico
	 * @param excepcion objeto de excepcion
	 */
	public UtileriaWhatsappExcepciones(UtilieriasWhatsappMensaje mensaje, Exception excepcion) {
		super(TIPO_EXCEPCION);
		if (mensaje != null) {
			this.mensajeTecnico = mensaje.getMensajeTecnico();
			this.mensajeUsuario = mensaje.getMensajeUsuario();
			this.codigo = mensaje.getCodigoEspecifico();
		}
		if(excepcion== null) {
			this.excepcionReal = excepcion;
		}
	}
 
	/**
	 * Con este constructor se indican el mensaje de usuario y tecnico para
	 * clarificar la razon de la excepcion
	 * 
	 * @param mensajeTecnico mensaje tecnico
	 * @param mensajeUsuario mensaje de usuario
	 */
	public UtileriaWhatsappExcepciones(String mensajeTecnico, String mensajeUsuario) {
		super(TIPO_EXCEPCION);
		this.mensajeTecnico = mensajeTecnico;
		this.mensajeUsuario = mensajeUsuario;
	}
 
	public String getMensajeTecnico() {
		return mensajeTecnico;
	}
 
	public String getMensajeUsuario() {
		return mensajeUsuario;
	}
 
	public Integer getCodigo() {
		return codigo;
	}
 
	
	@Override
	public Exception getExcepcion() {
		return excepcionReal;
	}

}
