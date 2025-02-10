package com.libreriaWhatsapp.excepciones;

public abstract class LibreriaGenericaExcepciones extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public LibreriaGenericaExcepciones(String MENSAJETECNICO) {
		super(MENSAJETECNICO);
	}

	public abstract String getMensajeTecnico();

	public abstract String getMensajeUsuario();

	public abstract Integer getCodigo();

	/**
	 * Este metodo sirve para obtener la excepcion concreta que ocurrio en la
	 * libreria y deberia usarse solo para pruebas o bien para guardar en bitacora,
	 * pero no para mostrar el usuario final. En caso de que no se asigne una
	 * excepcion a la clase de excepcion que extiende de LibreriaGenericaExcepcion,
	 * se retornara un IllegalArgumentException indicando que la excepcion no fue
	 * pasada por referencia. Para hacer uso de este metodo se debe sobre escribir
	 * en las clases que extienden de LibreriaGenericaExcepcion
	 * 
	 * @since 5.4
	 * @return Excepcion real, generalmente sera un RuntimeException
	 * 
	 */
	public Exception getExcepcion() {
		return new IllegalArgumentException("La excepción de la libreria no fue pasada por referencia.");
	}
}
